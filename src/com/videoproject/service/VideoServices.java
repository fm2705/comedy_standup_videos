package com.videoproject.service;


import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import static com.videoproject.service.CommonUtitlity.*;


import com.videodb.DAO.ComedianDAO;
import com.videodb.DAO.ReviewDAO;
import com.videodb.DAO.UserDAO;
import com.videodb.DAO.VideoDAO;
import com.videodb.entity.Comedians;
import com.videodb.entity.Reviews;
import com.videodb.entity.Users;
import com.videodb.entity.Videos;



public class VideoServices {

	private VideoDAO videoDAO;
	private ComedianDAO comedianDAO;
	
	private ReviewDAO reviewDao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public VideoServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		videoDAO = new VideoDAO();
		comedianDAO = new ComedianDAO();
		reviewDao = new ReviewDAO();
	}
	
	public void listVideos() throws ServletException, IOException {
		listVideos(null);
	}
	
	public void listVideos(String message) throws ServletException, IOException {
		List<Videos> listVideos = videoDAO.listAll();
		request.setAttribute("listVideos", listVideos);
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		
		forwardToPage("video_list.jsp", message, request, response);
	}
	
	public void listVideosByComedian(String message) throws ServletException, IOException {
		Integer comedianId = Integer.parseInt(request.getParameter("id"));
		List<Videos> listVideosByComedian = videoDAO.listByComedians(comedianId);
		request.setAttribute("listVideosByComedian", listVideosByComedian);
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		
		forwardToPage("video_list_by_comedian.jsp", message, request, response);
	}
	
	

	
	public void listVideosByUser(String message) throws ServletException, IOException {
		Integer userId = Integer.parseInt(request.getParameter("id"));
		List<Videos> listVideosByUser = videoDAO.findAllVideosByUser(userId);
		request.setAttribute("listVideosByUser", listVideosByUser);
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		
		forwardToPage("video_list_by_user.jsp", message, request, response);
	}


	public void listPoorYouTube(String message) throws ServletException, IOException {
		List<Videos> listPoorYouTube = videoDAO.listPoorYouTube();
		request.setAttribute("listPoorYouTube", listPoorYouTube);
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		
		forwardToPage("list_poor_youtubes.jsp", message, request, response);
	}
	

	
	public void showVideoNewForm() throws ServletException, IOException {
		List<Comedians> listComedian = comedianDAO.listAll();
		request.setAttribute("listComedian", listComedian);
		forwardToPage("video_form.jsp", request, response);
	}
	
	

	
	public void search() throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		List<Videos> result = null; 
				
		if (keyword.equals("")) {
			
		} else {
			result = videoDAO.search(keyword);
		}
		
		request.setAttribute("keyword", keyword);
		request.setAttribute("result", result);
		forwardToPage("search_result.jsp", request, response);
	}
	

	
	public void createVideo() throws ServletException, IOException {
		String url = request.getParameter("url");
		
		Videos existVideo = videoDAO.findByURL(url);
		
		if (existVideo != null) {
			String message = "Could not create new video because the url '"
					+ url + "' already exists.";
			listVideos(message);
			return;
		}
		
		Videos newVideo = new Videos();
		readVideoFields(newVideo);
		
		Videos createdVideo = videoDAO.create(newVideo);
		
		if (createdVideo.getVideoId() > 0) {
			String message = "A new video has been created successfully.";
			listVideos(message);
		}
	}
	
	public void readVideoFields(Videos newVideo) throws ServletException, IOException {
		Integer comedianId = Integer.parseInt(request.getParameter("comedians"));
		Comedians comedians = comedianDAO.get(comedianId);
		String title = request.getParameter("title");
		String url = request.getParameter("url");
		String description = request.getParameter("description");
		String tag = request.getParameter("tag");
		Date thisDate = java.sql.Date.valueOf(java.time.LocalDate.now());
		

		newVideo.setTittle(title);
		newVideo.setUrl(url);
		newVideo.setDate(thisDate);
		newVideo.setDescription(description);
		newVideo.setTags(tag);
		
		Comedians comedian = comedianDAO.get(comedianId);
		newVideo.setComedians(comedian);

		//console print for testing
		System.out.println("title: " + title);
		System.out.println("url: " + url);
		System.out.println("description: " + description);
		System.out.println("tag: " + tag);
		System.out.println("date: " + thisDate);
		System.out.println("comedian: " + comedianId);
		
	}
	
	public void showVideoToAddReview(String message) throws ServletException, IOException {
		Integer videoId = Integer.parseInt(request.getParameter("id"));
		Videos showVideo = videoDAO.get(videoId);
		
		request.setAttribute("showVideo", showVideo);
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		
		forwardToPage("Review_submit.jsp", message, request, response);
	}


	public void submitReview2() throws ServletException, IOException {
	
		Integer id = Integer.parseInt(request.getParameter("video"));
		Integer user = Integer.parseInt(request.getParameter("user"));
		String score = request.getParameter("score");
		String remark = request.getParameter("description");
		
		
		System.out.println("The video is *********************" + id);
		System.out.println("The score is *********************" + score);
		System.out.println("The description is *********************" + remark);
		System.out.println("The user is *********************" + user);
		

		forwardToPage("header.jsp", request, response);
	}
	
	
	public void submitReview3() throws ServletException, IOException, ParseException {
		
		System.out.println("Creating video ");
		Integer id = Integer.parseInt(request.getParameter("video"));
		Videos setvideo = new Videos();
		setvideo.setVideoId(id);
		
		System.out.println("creating user ");
		Integer user = Integer.parseInt(request.getParameter("user"));
		Users setuser = new Users();
		setuser.setUserId(user);
		
		System.out.println("setting score ");
		String score = request.getParameter("score");
		String remark = request.getParameter("description");

		System.out.println("creating review ");
		Reviews newReview = new Reviews(setuser, setvideo, score, remark) ;
		//reviewDao.create(newReview);
		forwardToPage("header.jsp", request, response);
		//forwardToPage("video_list.jsp", request, response);
	}
	
public void submitReview() throws ServletException, IOException, ParseException {

		Integer id = Integer.parseInt(request.getParameter("video"));
		Integer userId = Integer.parseInt(request.getParameter("user"));
		String score = request.getParameter("score");
		String remark = request.getParameter("description");


        Reviews review = new Reviews();
		review.setRemark(remark);
		review.setScore(score);
		
		Users user = new Users();
		user.setUserId(userId);
		review.setUsers(user);
		
		Videos video = new Videos();
		video.setVideoId(id);
		review.setVideos(video);
		
		Reviews createReview = reviewDao.create(review);

		listVideos(null);
		//forwardToPage("header.jsp", request, response);
	}
}
