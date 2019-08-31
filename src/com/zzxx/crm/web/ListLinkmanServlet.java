package com.zzxx.crm.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzxx.crm.beans.Linkman;
import com.zzxx.crm.service.LinkmanService;
import com.zzxx.crm.service.impl.LinkmanServiceImpl;

import jdk.internal.dynalink.linker.LinkerServices;
@WebServlet("/ListLinkmanServlet")
public class ListLinkmanServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkmanService ls = new LinkmanServiceImpl();
		List<Linkman> list = ls.queryAllLinkman();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/linkman/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}