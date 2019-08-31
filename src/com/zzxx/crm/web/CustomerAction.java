package com.zzxx.crm.web;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzxx.crm.beans.Customer;
import com.zzxx.crm.service.CustomerService;
import com.zzxx.crm.service.impl.CustomerServiceImpl;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	Customer customer = new Customer();
	CustomerService cs = new CustomerServiceImpl();
	public String add(){
		cs.addCustomer(customer);
		return "toList";
	}
	public String list() {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if(customer.getCust_name() != null) {
			dc.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
		}
		List<Customer> list = cs.queryAllCustomer(dc);
		ActionContext.getContext().put("list", list);
		// 转发,不能使用重定向是因为有request域存在
		return "list";
	}
	

	
	@Override
	public Customer getModel() {
		return customer;
	}

}
