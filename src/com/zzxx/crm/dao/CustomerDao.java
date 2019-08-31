package com.zzxx.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zzxx.crm.beans.Customer;

public interface CustomerDao {

	void save(Customer c);

	List<Customer> findAllCustomer();

	void delete(Customer customer);

	Customer getCustomerById(Long cust_id);

	void update(Customer customer);

	List<Customer> findAllCustomer(DetachedCriteria dc);

}
