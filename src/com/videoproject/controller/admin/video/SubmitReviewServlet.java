package com.videoproject.controller.admin.video;


import com.videoproject.controller.admin.BaseServlet;
import com.videoproject.service.VideoServices;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateVideoServlet
 */
@WebServlet("/admin/submit_this_review")
public class SubmitReviewServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public SubmitReviewServlet() {
        
    }

    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	System.out.println("The servlet to submit the review");
		VideoServices videoServices = new VideoServices(request, response);
		try {
			videoServices.submitReview();
		} catch (ServletException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//response.getWriter().append("Testing the review servlet").append(request.getContextPath());
	}

}
