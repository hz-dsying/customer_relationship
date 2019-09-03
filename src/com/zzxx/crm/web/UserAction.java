package com.zzxx.crm.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzxx.crm.beans.User;
import com.zzxx.crm.service.UserService;
import com.zzxx.crm.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	User user = new User();
	private String txtcode;
	UserService us = new UserServiceImpl();
	
	public String login() {
		System.out.println(user);
		boolean isTrue = us.login(user);
		if(isTrue == true) {
			return SUCCESS;
		}else {
			return "loginFalse";
		}
		
		
	}

	@Override
	public User getModel() {
		return user;
	}

	public String getTxtcode() {
		return txtcode;
	}

	public void setTxtcode(String txtcode) {
		this.txtcode = txtcode;
	}
	

}
