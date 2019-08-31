package com.zzxx.crm.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzxx.crm.beans.Linkman;
import com.zzxx.crm.service.LinkmanService;
import com.zzxx.crm.service.impl.LinkmanServiceImpl;

import jdk.internal.dynalink.support.LinkerServicesImpl;
@WebServlet("/ModifyLinkmanServlet")
public class ModifyLinkmanServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long lkm_id = Long.valueOf(request.getParameter("lkm_id"));
		LinkmanService ls = new LinkmanServiceImpl();
		Linkman linkman = ls.findLinkmanById(lkm_id);
		request.setAttribute("linkman", linkman);
		request.getRequestDispatcher("/jsp/linkman/edit.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}