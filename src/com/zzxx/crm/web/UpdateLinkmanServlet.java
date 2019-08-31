package com.zzxx.crm.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.zzxx.crm.beans.Linkman;
import com.zzxx.crm.service.LinkmanService;
import com.zzxx.crm.service.impl.LinkmanServiceImpl;
@WebServlet("/UpdateLinkmanServlet")
public class UpdateLinkmanServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Linkman linkman = new Linkman();
		LinkmanService ls = new LinkmanServiceImpl();
		try {
			BeanUtils.populate(linkman, request.getParameterMap());
			ls.modifyLinkman(linkman);
			response.sendRedirect(request.getContextPath() + "/ListLinkmanServlet");	
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