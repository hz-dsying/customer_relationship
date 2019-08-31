package com.zzxx.crm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.zzxx.crm.beans.Customer;
import com.zzxx.crm.dao.CustomerDao;
import com.zzxx.crm.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void save(Customer c) {
		// 使用Hibernate
		// getCurrentSession必须要配置
		// No CurrentSessionContext configured!
		Session session = HibernateUtils.getCurrentSession();
		
		session.save(c);

	}

	@Override
	public List<Customer> findAllCustomer() {
		Session session = HibernateUtils.getCurrentSession();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		return list;
	}

	@Override
	public void delete(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		session.delete(customer);
	}

	@Override
	public Customer getCustomerById(Long cust_id) {
		Session session = HibernateUtils.getCurrentSession();
		Customer customer = session.get(Customer.class, cust_id);
		return customer;
	}

	@Override
	public void update(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		session.update(customer);		
	}

	@Override
	public List<Customer> findAllCustomer(DetachedCriteria dc) {
		Session session = HibernateUtils.openSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		List<Customer> list = criteria.list();
		return list;
	}

}
