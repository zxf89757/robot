package com.hfut.test.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hfut.test.model.Sms;
import com.hfut.test.model.User;
import com.hfut.test.service.UserService;
import com.hfut.test.utils.Result;
import com.hfut.test.utils.Talk;
import com.hfut.test.utils.UUIDUtils;

import net.sf.json.JSONObject;

@Controller
public class UserController { 
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ServletContext application;
	//存在问题：获取手机号和验证码后修改手机号再注册
    /**
     * telno
     * password
     * 用户登录接口
     * 返回user
     */
    @RequestMapping(value="/user/login")
    @ResponseBody
    public Result<User> login(User user) throws IOException{
    	User existUser = userService.queryByTel(user.getTelno());
        if(existUser!=null && existUser.getPassword().equals(user.getPassword())){
          	return new Result<User>(true,existUser);
        }
        else{
        	return new Result<User>(false,"用户不存在或密码错误");
        }
    }
    
    /**
     * telno
     * 获取短信验证码接口
     * 返回smsid
     */
    @RequestMapping(value="/user/getcode")
    @ResponseBody
    public Result<Sms> getCode(String telno) throws IOException{
    	int mobile_code = (int)((Math.random()*9+1)*100000);
	    String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");
	    String requestUrl = "http://106.ihuyi.com/webservice/sms.php?method=Submit&";
	    Map params = new HashMap();
	    params.put("account","C85349894");
	    params.put("password","e9bcb07ee6d340d89674445dbec851d2");
	    params.put("mobile",telno);
	    params.put("content",content);
	    params.put("format","json");
	    String string = Talk.httpRequest(requestUrl,params);
	    JSONObject json = JSONObject.fromObject(string);
	    if(json.getString("code").equals("2")) {
	    	Sms sms = new Sms();
	    	sms.setSmsid(json.getString("smsid"));
	    	application.setAttribute(json.getString("smsid"), ""+mobile_code);
	    	return new Result<Sms>(true,sms);
	    }
	    return new Result<Sms>(false,"发生错误");
    }
    
    /**
     * telno
     * username
     * password
     * code
     * smsid
     * 用户注册接口
     * 返回user
     */
    @RequestMapping(value="/user/regist")
    @ResponseBody
    public Result<User> regist(User user,String code,String smsid) throws IOException{
    	User existUser = userService.queryByTel(user.getTelno());
    	if(existUser!=null) {
    		return new Result<User>(false,"该手机号已注册");
    	}
    	if(application.getAttribute(smsid)==null||(!application.getAttribute(smsid).equals(code))) {
    		return new Result<User>(false,"验证码错误");
    	}
    	application.removeAttribute(smsid);
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	user.setDateCreated(sdf.format(new Date()));
    	user.setSex("男");
    	user.setCount(0);
    	user.setDateLastActived(sdf.format(new Date()));
    	user.setIpCreated(request.getRemoteAddr());
		user.setIpLastActived(user.getIpCreated());
		user.setUuid(UUIDUtils.getUUID());
        userService.insertUser(user);     
        //返回
		return new Result<User>(true,user);//后面改成重新刷新页面后本句只有前面的true有作用
    }
    
    /**
     * telno
     * password
     * code
     * smsid
     * 修改密码接口
     * 返回user
     */
    @RequestMapping(value="/user/updatePass")
    @ResponseBody
    public Result<User> updatePass(User user,String code,String smsid) throws IOException{
    	User existUser = userService.queryByTel(user.getTelno());
    	if(existUser==null) {
    		return new Result<User>(false,"该手机号未注册");
    	}
    	if(application.getAttribute(smsid)==null||(!application.getAttribute(smsid).equals(code))) {
    		return new Result<User>(false,"验证码错误");
    	}
    	userService.updateUserByTel(user);
    	application.removeAttribute(smsid);
    	return new Result<User>(true,user);
    }
}