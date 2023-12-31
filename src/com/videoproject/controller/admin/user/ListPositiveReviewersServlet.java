package com.videoproject.controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videodb.entity.Users;
import com.videoproject.controller.admin.BaseServlet;
import com.videoproject.service.ComedianServices;
//import com.videodb.entity;
import com.videoproject.service.UserServices;

/**
 * Servlet implementation class ListUsersServlet
 */
@WebServlet("/admin/list_positive_reviewers")
public class ListPositiveReviewersServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ListPositiveReviewersServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		UserServices userServices = new UserServices(request, response);
		  
		userServices.listPositiveReviewers(null);
	}



}
