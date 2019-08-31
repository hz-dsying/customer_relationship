package com.zzxx.crm.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.zzxx.crm.beans.Customer;
import com.zzxx.crm.dao.CustomerDao;
import com.zzxx.crm.dao.impl.CustomerDaoImpl;
import com.zzxx.crm.service.CustomerService;
import com.zzxx.crm.utils.HibernateUtils;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao cd = new CustomerDaoImpl();
	@Override
	public void addCustomer(Customer c) {
		// 1.开启事务
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// 调用Dao
			cd.save(c);
			
			// 2.提交事务
			tx.commit();
		}catch (Exception e) {
			// 3.异常回滚事务
			e.printStackTrace();
			tx.rollback();
		}
		// 和线程绑定的session会自动关闭，无需手动关闭
		/*
		 * finally { session.close(); }
		 */

	}

	@Override
	public List<Customer> queryAllCustomer() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Customer> list = cd.findAllCustomer();
		tx.commit();
		return list;
	}

	@Override
	public void delectCustomerById(String cust_id) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer c = cd.getCustomerById(Long.valueOf(cust_id));
		cd.delete(c);
		tx.commit();
	}

	@Override
	public Customer findCustomerById(String cust_id) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer customer = cd.getCustomerById(Long.valueOf(cust_id));
		tx.commit();
		return customer;
	}

	@Override
	public void modifyCustomer(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		cd.update(customer);
		tx.commit();
	}

	@Override
	public List<Customer> queryAllCustomer(DetachedCriteria dc) {
		// Session session = HibernateUtils.getCurrentSession();
		List<Customer> list = cd.findAllCustomer(dc);
		return list;
	}

}
