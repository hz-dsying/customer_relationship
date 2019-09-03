package com.zzxx.crm.service.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zzxx.crm.beans.User;
import com.zzxx.crm.dao.UserDao;
import com.zzxx.crm.dao.impl.UserDaoImpl;
import com.zzxx.crm.service.UserService;
import com.zzxx.crm.utils.HibernateUtils;

public class UserServiceImpl implements UserService {
	UserDao ud = new UserDaoImpl();
	
	@Override
	public boolean login(User user) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		User u = ud.findUserByUsercodeAndPassword(user);
		tx.commit();
		if(user != null) {
			return true;
		}else {
			return false;
		}
	}

}
