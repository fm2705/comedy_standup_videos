package com.videoproject.controller.admin.comedian;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videoproject.controller.admin.BaseServlet;
import com.videoproject.service.ComedianServices;

@WebServlet("/admin/list_hot_comedians")
public class ListHotComediansServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public ListHotComediansServlet() {
		super();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("list hot comedians");
		ComedianServices comedianServices = new ComedianServices(request, response);
	  
		comedianServices.listHotComedians(null);
	}
	

}
