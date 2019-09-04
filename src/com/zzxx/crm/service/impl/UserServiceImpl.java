package com.zzxx.crm.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.zzxx.crm.beans.User;
import com.zzxx.crm.dao.UserDao;
import com.zzxx.crm.dao.impl.UserDaoImpl;
import com.zzxx.crm.exception.LoginException;
import com.zzxx.crm.service.UserService;
import com.zzxx.crm.utils.HibernateUtils;

public class UserServiceImpl implements UserService {
	UserDao ud = new UserDaoImpl();
	
	@Override
	public User login(User user) throws LoginException {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("user_code", user.getUser_code()));
		dc.add(Restrictions.eq("user_password", user.getUser_password()));
	
		List<User> list = ud.findUserDetachedCriteria(dc);
		tx.commit();
		if(list.isEmpty()) {
			throw new LoginException("用户名/密码错误！");
		}
		return list.get(0);
	}

}
