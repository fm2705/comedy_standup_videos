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
@WebServlet("/admin/create_comedian")
public class CreateComedianServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public CreateComedianServlet() {

    }
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ComedianServices comedianServices = new ComedianServices(request, response);
		try {
			comedianServices.createComedian();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}

}
