package com.zzxx.crm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.zzxx.crm.beans.Linkman;
import com.zzxx.crm.dao.LinkmanDao;
import com.zzxx.crm.utils.HibernateUtils;

public class LinkmanDaoImpl implements LinkmanDao {

	@Override
	public void save(Linkman linkman) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(linkman);
	}

	@Override
	public List<Linkman> findAllLinkman() {
		Session session = HibernateUtils.getCurrentSession();
		Criteria criteria = session.createCriteria(Linkman.class);
		List<Linkman> list = criteria.list();
		return list;
	}

	@Override
	public Linkman getLinkmanById(Long lkm_id) {
		Session session = HibernateUtils.getCurrentSession();
		Linkman linkman = session.get(Linkman.class, lkm_id);
		return linkman;
	}

	@Override
	public void update(Linkman linkman) {
		Session session = HibernateUtils.getCurrentSession();
		session.update(linkman);
	}

	@Override
	public void delete(Linkman linkman) {
		Session session = HibernateUtils.getCurrentSession();
		session.delete(linkman);
		
	}

}
