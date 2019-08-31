package com.zzxx.crm.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zzxx.crm.beans.Customer;
import com.zzxx.crm.beans.Linkman;
import com.zzxx.crm.dao.CustomerDao;
import com.zzxx.crm.dao.LinkmanDao;
import com.zzxx.crm.dao.impl.CustomerDaoImpl;
import com.zzxx.crm.dao.impl.LinkmanDaoImpl;
import com.zzxx.crm.service.LinkmanService;
import com.zzxx.crm.utils.HibernateUtils;

public class LinkmanServiceImpl implements LinkmanService {
	private CustomerDao cd = new CustomerDaoImpl();
	private LinkmanDao ld = new LinkmanDaoImpl();

	@Override
	public void addLinkman(Long cust_id, Linkman linkman) {
		// 开启事务
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 1.查找Customer
		Customer c = cd.getCustomerById(cust_id);
		// 2.设置关联关系
		c.getLinkmen().add(linkman);
		linkman.setCustomer(c);
		// 3.保存linkman
		ld.save(linkman);
		
		// 关闭事务
		tx.commit();
	}

	@Override
	public List<Linkman> queryAllLinkman() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		List<Linkman> list = ld.findAllLinkman();
		
		tx.commit();
		return list;
	}

	@Override
	public Linkman findLinkmanById(Long lkm_id) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Linkman linkman = ld.getLinkmanById(lkm_id);
		tx.commit();
		return linkman;
	}

	@Override
	public void modifyLinkman(Linkman linkman) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		ld.update(linkman);
		tx.commit();
	}

	@Override
	public void deleteLinkmanById(Long lkm_id) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		/////////////////////////////////////////////
		Linkman linkman = ld.getLinkmanById(lkm_id);
		Customer customer = linkman.getCustomer();
		customer.getLinkmen().remove(linkman);
		ld.delete(linkman);
		tx.commit();
	}

}
