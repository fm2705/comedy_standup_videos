package com.videoproject.controller.admin.comedian;

import com.videoproject.controller.admin.BaseServlet;
import com.videoproject.service.ComedianServices;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateComedianServlet
 */
@WebServlet("/admin/add_favoriteComedian")
public class AddFavCOmedianServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public AddFavCOmedianServlet() {

    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Testing the review servlet").append(request.getContextPath());
		
        ComedianServices comedianServices = new ComedianServices(request, response);
		try {
			comedianServices.addFavoriteComedian();
		} catch (ServletException | IOException | ParseException e) {
			e.printStackTrace();
		}
		
		
	}

}
