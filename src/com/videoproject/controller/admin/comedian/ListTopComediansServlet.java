package com.videoproject.controller.admin.comedian;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videoproject.controller.admin.BaseServlet;
import com.videoproject.service.ComedianServices;

@WebServlet("/admin/list_top_comedians")
public class ListTopComediansServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public ListTopComediansServlet() {
		super();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("list top comedians");
		ComedianServices comedianServices = new ComedianServices(request, response);
	  
		comedianServices.listTopComedians(null);
	}
	

}
