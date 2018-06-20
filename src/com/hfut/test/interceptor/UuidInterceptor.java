package com.hfut.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hfut.test.model.User;
import com.hfut.test.dao.UserDao;

/**
* @author
* @version 创建时间：2017年9月21日 下午1:05:32
* 类说明
*/
public class UuidInterceptor implements HandlerInterceptor{
	@Autowired
	private UserDao userDao;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String uuid = request.getHeader("uuid");
		if(uuid!=null&&(!uuid.equals(""))) {
			User existUser = userDao.queryByUuid(uuid);
			if(existUser!=null){
				return true;
			}
		}
		return false;
	}
	
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
