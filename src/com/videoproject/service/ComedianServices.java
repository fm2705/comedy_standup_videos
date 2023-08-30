package com.videoproject.service;


import static com.videoproject.service.CommonUtitlity.*;


import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videodb.DAO.ComedianDAO;
import com.videodb.DAO.FavComedianDAO;
import com.videodb.entity.Comedians;
import com.videodb.entity.Favcomedians;
import com.videodb.entity.Reviews;
import com.videodb.entity.Users;
import com.videodb.entity.Videos;

public class ComedianServices {
	
	private ComedianDAO comedianDAO;
	private FavComedianDAO favComedianDao;
	private HttpServletResponse response;
	private HttpServletRequest request;
	
	public ComedianServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response=response;
		comedianDAO = new ComedianDAO();
		favComedianDao = new FavComedianDAO();
	}  
	
	
	public void listComedians(String message) throws ServletException, IOException {
		List<Comedians> listComedians= comedianDAO.listAll();
		request.setAttribute("listComedians", listComedians);
		forwardToPage("list_comedians.jsp", request, response);	
		
	}
	
	public void listFavComediansById(String message) throws ServletException, IOException {
		List<Comedians> listFavComedians= comedianDAO.listFavoriteById(22);
		request.setAttribute("listFavComedians", listFavComedians);
		forwardToPage("list_fav_comedians.jsp", request, response);	
		
	}
	
	public void listCoolComedians(String message) throws ServletException, IOException {
		List<Comedians> listCoolComedians= comedianDAO.NativefindCool();
		request.setAttribute("listCoolComedians", listCoolComedians);
		forwardToPage("list_cool_comedians.jsp", request, response);	
		
	}
	
	
	public void listNewComedians(String message) throws ServletException, IOException {
		List<Comedians> listNewComedians= comedianDAO.NativefindNew();
		request.setAttribute("listNewComedians", listNewComedians);
		forwardToPage("list_new_comedians.jsp", request, response);	
		
	}
	
	public void listTopComedians(String message) throws ServletException, IOException {
		List<Comedians> listTopComedians= comedianDAO.NativefindTop();
		request.setAttribute("listTopComedians", listTopComedians);
		forwardToPage("list_top_comedians.jsp", request, response);	
		
	}
	
	public void listHotComedians(String message) throws ServletException, IOException {
		List<Comedians> listHotComedians= comedianDAO.NativefindHot();
		request.setAttribute("listHotComedians", listHotComedians);
		forwardToPage("list_hot_comedians.jsp", request, response);	
		
	}
	
	public void listCommonFavComedinans(String message) throws ServletException, IOException {
		Integer userId1 = Integer.parseInt(request.getParameter("id1"));
		Integer userId2 = Integer.parseInt(request.getParameter("id2"));
		
		System.out.println("first user" + userId1 + " second user: " + userId2);
		
		List<Comedians> listCommonComedians= comedianDAO.listCommonFavComedians(userId1, userId1 );
		request.setAttribute("listCommonComedians", listCommonComedians);
		forwardToPage("list_common_comedians.jsp", request, response);	
		
	}
	
	
	
	public void listComedians() throws ServletException, IOException {
		listComedians(null);
	}

	public void createComedian() throws ServletException, IOException, ParseException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String birthPlace = request.getParameter("birthPlace");
		Date birthDate = java.sql.Date.valueOf(java.time.LocalDate.now());

		Comedians existsComedian = comedianDAO.findByName(firstName);
		
		if(existsComedian != null) {
			String message = "Couldn't create Comedian, it already exists";
		 
			request.setAttribute("message",message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("comedian_form.jsp");
			requestDispatcher.forward(request, response);
				
		}else {
			Comedians newComedian = new Comedians(firstName, lastName, birthPlace, birthDate);
			comedianDAO.create(newComedian);
		//	listComedians();
			String message = "New category created successfully.";
			listComedians(message);
			
		}
		
	}
	
	public void editComedian() throws ServletException, IOException {
		int comedianId = Integer.parseInt(request.getParameter("comedianId"));
		Comedians comedian = comedianDAO.get(comedianId);
		
		String destPage = "comedian_form.jsp";
		if (comedian == null) {
			destPage = "message.jsp";
			String message = "Could not find comedian with ID " + comedianId;
			request.setAttribute("comedian", comedian);
		} else {
			request.setAttribute("comedian", comedian);
		}	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destPage);
		requestDispatcher.forward(request, response);
	}
	

	
	
	public void deleteComedian() throws ServletException, IOException {
		int comedianId = Integer.parseInt(request.getParameter("comedianId"));
		String message;
		
		Comedians category = comedianDAO.get(comedianId);
		
		if (category == null) {
			message = "Could not find category with ID " + comedianId
					+ ", or it might have been deleted";
			showMessageBackend(message, request, response);
			return;
		}

		comedianDAO.delete(comedianId);		
		message = "The category with ID " + comedianId + " has been removed successfully.";

		
		listComedians(message);
		
	}
	
	public void addFavoriteComedian() throws ServletException, IOException, ParseException {

       Favcomedians favComedian = new Favcomedians();
		
		Integer comedianId = Integer.parseInt(request.getParameter("comedianId"));

		Comedians comedian = new Comedians();
		comedian.setComedianId(comedianId);
		favComedian.setComedians(comedian);
		
		Users user = new Users();
		user.setUserId(22);

		favComedian.setUsers(user);
		

		Favcomedians createFavComedian = favComedianDao.create(favComedian);
		listFavComediansById(null);
		//forwardToPage("list_fav_comedians.jsp", request, response);
	}



}
