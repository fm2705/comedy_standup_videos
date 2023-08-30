package com.videoproject.controller.admin.comedian;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videoproject.controller.admin.BaseServlet;
import com.videoproject.service.ComedianServices;

@WebServlet("/admin/choose_users_commen_comedian")
public class ListCommonComediansServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public ListCommonComediansServlet() {
		super();
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("list common comedians");
		ComedianServices comedianServices = new ComedianServices(request, response);
	  
		comedianServices.listCommonFavComedinans(null);
	}
	

}
