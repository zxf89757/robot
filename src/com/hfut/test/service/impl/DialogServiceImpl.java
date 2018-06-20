package com.hfut.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfut.test.dao.DialogDao;
import com.hfut.test.model.Dialog;
import com.hfut.test.service.DialogService;

@Service
public class DialogServiceImpl implements DialogService{
	@Autowired
	private DialogDao dialogDao;
	
	public void insertDialog(Dialog dialog) {
		dialogDao.insertDialog(dialog);	
	}

}
