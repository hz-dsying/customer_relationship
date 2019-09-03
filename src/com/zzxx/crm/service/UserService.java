package com.zzxx.crm.service;

import com.zzxx.crm.beans.User;
import com.zzxx.crm.exception.LoginException;

public interface UserService {

	User login(User user) throws LoginException;

}
