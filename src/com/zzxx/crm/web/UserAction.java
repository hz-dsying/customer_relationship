package com.zzxx.crm.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzxx.crm.beans.User;
import com.zzxx.crm.exception.LoginException;
import com.zzxx.crm.service.UserService;
import com.zzxx.crm.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private UserService us = new UserServiceImpl();
	
	public String login() throws Exception {
		User loginUser = us.login(user);
		ActionContext.getContext().getSession().put("user", loginUser);
		return SUCCESS;
	}

	@Override
	public User getModel() {
		return user;
	}
	

}
