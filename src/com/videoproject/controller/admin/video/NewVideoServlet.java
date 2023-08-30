package com.videoproject.controller.admin.video;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.videoproject.service.VideoServices;

/**
 * Servlet implementation class NewVideoServlet
 */
@WebServlet("/admin/new_video")
public class NewVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public NewVideoServlet() {
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		VideoServices videoServices = new VideoServices(request, response);
		videoServices.showVideoNewForm();
	}


}
