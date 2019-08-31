package com.zzxx.crm.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzxx.crm.service.CustomerService;
import com.zzxx.crm.service.impl.CustomerServiceImpl;
@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cust_id = request.getParameter("cust_id");
		CustomerService cs = new CustomerServiceImpl();
		cs.delectCustomerById(cust_id);
		response.sendRedirect(request.getContextPath() + "/ListCustomerServlet");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}