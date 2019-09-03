package com.zzxx.crm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.zzxx.crm.beans.User;
import com.zzxx.crm.dao.UserDao;
import com.zzxx.crm.utils.HibernateUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> findUserDetachedCriteria(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		return criteria.list();
	}



}
