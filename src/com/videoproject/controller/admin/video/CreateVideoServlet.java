package com.videoproject.controller.admin.video;


import com.videoproject.controller.admin.BaseServlet;
import com.videoproject.service.VideoServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateVideoServlet
 */
@WebServlet("/admin/create_video")
public class CreateVideoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public CreateVideoServlet() {
        
    }

    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VideoServices videoServices = new VideoServices(request, response);
		videoServices.createVideo();
	}

}
