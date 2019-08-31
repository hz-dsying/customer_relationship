package com.zzxx.crm.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzxx.crm.beans.Customer;
import com.zzxx.crm.service.CustomerService;
import com.zzxx.crm.service.impl.CustomerServiceImpl;
@WebServlet("/ModifyCustomerServlet")
public class ModifyCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cust_id = request.getParameter("cust_id");
		CustomerService cs = new CustomerServiceImpl();
		Customer customer = cs.findCustomerById(cust_id);
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/jsp/customer/edit.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}