package com.zzxx.crm.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zzxx.crm.beans.Customer;

public interface CustomerService {

	void addCustomer(Customer c);

	List<Customer> queryAllCustomer();

	void delectCustomerById(String cust_id);

	Customer findCustomerById(String cust_id);

	void modifyCustomer(Customer customer);

	List<Customer> queryAllCustomer(DetachedCriteria dc);

}
