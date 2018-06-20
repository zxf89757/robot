package com.hfut.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfut.test.dao.UserDao;
import com.hfut.test.model.User;
import com.hfut.test.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	public void updateUserByTel(User user) {
		userDao.updateUserByTel(user);
	}

	public User queryByTel(String telno) {
		return userDao.queryByTel(telno);
	}
	
	public User queryByUuid(String uuid) {
		return userDao.queryByUuid(uuid);
	}

}