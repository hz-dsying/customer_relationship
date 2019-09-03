package com.zzxx.crm.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.zzxx.crm.beans.User;
import com.zzxx.crm.dao.UserDao;
import com.zzxx.crm.utils.HibernateUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUserByUsercodeAndPassword(User user) {
		Session session = HibernateUtils.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("user_code", user.getUser_code())).add(Restrictions.eq("user_password", user.getUser_password()));
		User u = (User) criteria.uniqueResult();
		return u;
	}

}
