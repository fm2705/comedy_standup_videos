package com.videoproject.controller.admin.video;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.videoproject.service.VideoServices;

@WebServlet("/admin/search")
public class SearchVideoServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public SearchVideoServices() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VideoServices videoServices = new VideoServices(request, response);
		videoServices.search();
	}
}
