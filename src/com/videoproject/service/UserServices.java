package com.videoproject.service;


import static com.videoproject.service.CommonUtitlity.*;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videodb.DAO.ComedianDAO;
import com.videodb.DAO.UserDAO;
import com.videodb.entity.Comedians;
import com.videodb.entity.Users;

public class UserServices {

	private EntityManager entityManager;
	private UserDAO userDAO;
	private HttpServletResponse response;
	private HttpServletRequest request;
	
	
	public UserServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response=response;
		userDAO = new UserDAO();

	}
	
	


	public void listUser(String message) throws ServletException, IOException {

		List<Users> listUsers = userDAO.listAll();
		request.setAttribute("listUsers", listUsers);
		
		if(message != null) {
			request.setAttribute("message", message);
		}

		String listPage = "user_list.jsp";
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
	     
	    requestDispatcher.forward(request, response);
		
	}
	public void listUsersAndChoose(String message) throws ServletException, IOException {

		List<Users> listUsersToChoose = userDAO.listAll();
		request.setAttribute("listUsersToChoose", listUsersToChoose);
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("users_choose.jsp");
	     
	    requestDispatcher.forward(request, response);
		
	}



	public void chooseUsers() throws ServletException, IOException {
		forwardToPage("users_choose.jsp", request, response);
		
	}

	
	
	public void listUser() throws ServletException, IOException {
		listUser(null);
	}
	
	public void listPositiveReviewers(String message) throws ServletException, IOException {
		List<Users> listPositiveReviewers= userDAO.listPositiveReviewers();
		request.setAttribute("listPositiveReviewers", listPositiveReviewers);
		forwardToPage("list_positive_reviewers.jsp", request, response);	
		
	}
	


	public void listProductiveUsers(String message) throws ServletException, IOException {
		List<Users> ProductiveUsers= userDAO.listProductiveUsers();
		request.setAttribute("ProductiveUsers", ProductiveUsers);
		forwardToPage("list_productive_users.jsp", request, response);	
		
	}
	
	public void createUser() throws ServletException, IOException{
		String email = request.getParameter("email");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		Integer age = Integer.parseInt(request.getParameter("age"));

		Users existsUser = userDAO.findByEmail(email);
		if(existsUser != null) {
			String message = "user " + email + "exists";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user_form.jsp");
			dispatcher.forward(request,response);
			
		}else {
			Users newUser = new Users(email, password, firstName, lastName, gender, age);
			userDAO.create(newUser);
			listUser("The user created successfully");
		}
		
	}
	
	public void register() throws ServletException, IOException{
		System.out.println("Registering: ");
		String email = request.getParameter("email");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		Integer age = Integer.parseInt(request.getParameter("age"));
		System.out.println("Creating user: ");
		Users existsUser = userDAO.findByEmail(email);
		if(existsUser != null) {
			//String message = "user " + email + "exists";
			//request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user_form2.jsp");
			dispatcher.forward(request,response);
			
		}else {
			System.out.println("go to homepage: ");
			Users newUser = new Users(email, password, firstName, lastName, gender, age);
			userDAO.create(newUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);	
		}
		
	}


	public void editUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		Users user = userDAO.get(userId );

		String destPage = "user_form.jsp";
		
		if (user == null) {
			destPage = "message.jsp";
			String errorMessage = "Could not find user with ID " + userId;
			request.setAttribute("message", errorMessage);
		} else {
			request.setAttribute("user", user);			
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destPage);
		requestDispatcher.forward(request, response);
		
	}
	
	public void updateUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String email = request.getParameter("email");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		
        Users userById = userDAO.get(userId);
		
		Users userByEmail = userDAO.findByEmail(email);
		
		if (userByEmail != null && userByEmail.getUserId() != userById.getUserId()) {
			String message = "Could not update user. User with email " + email + " already exists.";
			request.setAttribute("message", message);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);			
			
		} else {
			Users user = new Users(userId, email, firstName, lastName, password, gender, age);
			userDAO.update(user);

			String message = "User has been updated successfully";
			listUser(message);
		}
	}
	
	public void login() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean loginResult = userDAO.checkLogin(email, password);
		
		if (loginResult) {
			request.getSession().setAttribute("useremail", email);
            if(email.contentEquals("root")) {
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
    			dispatcher.forward(request, response);
				
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("userAccount.jsp");
    			dispatcher.forward(request, response);
				
			}
			
			
			
		} else {
			String message = "Login failed!";
			request.setAttribute("message", message);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);			
		}
	}

	public void showLogin() throws ServletException, IOException {
		forwardToPage("login.jsp", request, response);
	}
	
	public void showRegister() throws ServletException, IOException {
		forwardToPage("user_form2.jsp", request, response);
	}




}
