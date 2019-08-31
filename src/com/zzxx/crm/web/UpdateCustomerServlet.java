package com.zzxx.crm.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.zzxx.crm.beans.Customer;
import com.zzxx.crm.service.CustomerService;
import com.zzxx.crm.service.impl.CustomerServiceImpl;
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer();
		CustomerService cs = new CustomerServiceImpl();
		try {
			BeanUtils.populate(customer, request.getParameterMap());
			cs.modifyCustomer(customer);
			response.sendRedirect(request.getContextPath() + "/ListCustomerServlet");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}