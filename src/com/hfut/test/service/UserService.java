package com.hfut.test.service;

import com.hfut.test.model.User;

public interface UserService {

	void updateUserByTel(User user);

	void insertUser(User user);

	User queryByTel(String telno);
	
	User queryByUuid(String uuid);
}