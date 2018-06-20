package com.hfut.test.dao;

import com.hfut.test.model.User;

public interface UserDao {	 

	void updateUserByTel(User user);

	void insertUser(User user);

	User queryByTel(String telno);

	User queryByUuid(String uuid);
 
}