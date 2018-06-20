package com.hfut.test.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hfut.test.model.Dialog;
import com.hfut.test.model.User;
import com.hfut.test.service.DialogService;
import com.hfut.test.service.UserService;
import com.hfut.test.utils.Result;
import com.hfut.test.utils.Talk;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/service/dialog")// url:/模块/资源/{id}/细分 /seckill/list
public class DialogController { 
	@Autowired
	private UserService userService;
	@Autowired
	private DialogService dialogService;
	@Autowired
	private HttpServletRequest request;
	/**
     * 获取回答接口
     * question
     * onlytuling
     */
	@RequestMapping(value="/getanswer")
	@ResponseBody
    public Result<Dialog> getanswer(Dialog dialog,String onlytuling) throws JsonProcessingException, IOException{
		String uuid = request.getHeader("uuid");
		User user=userService.queryByUuid(uuid);
		dialog.setUid(user.getUid());
		dialog.setRobid(1000);
		JSONObject answer=null;
		if(!onlytuling.equals("onlytuling")) {
			String requestUrl = "http://127.0.0.1:5000/getanswer?";
			Map params = new HashMap();
			params.put("question",dialog.getQuestion());
			String string = Talk.httpRequest(requestUrl,params);
			answer = JSONObject.fromObject(string);
			if(Double.parseDouble(answer.getString("score"))<0.6) {
				answer.put("text", "您的问题还不能回答哦，您要找的是不是："+answer.getString("source_question"));
				dialog.setMode(2);
			}
			else {
				dialog.setMode(1);
			}
		}
		else{
			answer = Talk.result(dialog.getQuestion(), "985e10faa7d64605b0771c180c7bdd8d");
			dialog.setMode(0);
		}
		
		dialog.setAnswer(answer.toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dialog.setDateCreated(sdf.format(new Date()));
		if(!answer.getString("code").equals("308000")&&!answer.getString("code").equals("302000")) {
			dialogService.insertDialog(dialog);
		}
		return new Result<Dialog>(true,dialog);
    }
}