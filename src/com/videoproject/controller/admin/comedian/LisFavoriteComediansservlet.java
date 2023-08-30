package com.videoproject.controller.admin.comedian;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videoproject.controller.admin.BaseServlet;
import com.videoproject.service.ComedianServices;

/**
 * Servlet implementation class LisComediansservlet
 */
@WebServlet("/admin/list_favorites")
public class LisFavoriteComediansservlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       

    public LisFavoriteComediansservlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("list favorites comedians");
		ComedianServices comedianServices = new ComedianServices(request, response);
	  
		comedianServices.listFavComediansById(null);
	}
}
