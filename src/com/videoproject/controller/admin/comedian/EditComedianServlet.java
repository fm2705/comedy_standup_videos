package com.videoproject.controller.admin.comedian;


import com.videoproject.controller.admin.BaseServlet;
import com.videoproject.service.ComedianServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/edit_comedian")
public class EditComedianServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;


    public EditComedianServlet() {

    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ComedianServices comedianServices = new ComedianServices(request, response);
		comedianServices.editComedian();
		
	}


}
