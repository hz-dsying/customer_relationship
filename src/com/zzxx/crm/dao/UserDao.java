package com.zzxx.crm.dao;

import com.zzxx.crm.beans.User;

public interface UserDao {

	User findUserByUsercodeAndPassword(User user);

}
