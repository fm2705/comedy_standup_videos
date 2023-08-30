package com.videodb.DAO;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.videodb.entity.Users;

public class UserDAOTest extends BaseDAOTest1{
	
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void setupClass() throws Exception {
		BaseDAOTest1.setUpBeforeClass();
		 userDAO = new UserDAO();	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		BaseDAOTest1.tearDownAfterClass();
	}
	
	

	
	@Test
	public void testCreateUsers() {
		Users user = new Users();
		user.setEmail("lala@email");
		user.setFirstName("Ellen");
		user.setLastName("DJ");
		user.setPassword("ellen1234");
		user.setAge(34);
		user.setGender("F");
		
		user = userDAO.create(user);
		System.out.println(user.getUserId());
		
		assertTrue(user.getUserId() > 0 );
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();
		
		user1 = userDAO.create(user1);

		
		assertTrue(user1.getUserId() > 0 );
	}
	
	@Test
	public void testUpdateUsers() {
		Users user = new Users();
		user.setUserId(21);
		
		user.setEmail("tomy@email");
		user.setFirstName("tommy");
		user.setLastName("tom");
		user.setPassword("tNewPassword");
		user.setAge(55);
		user.setGender("M");
		
		user = userDAO.update(user);
		String expected ="tNewPassword";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetUsersFound() {
		Integer userId = 20;
		Users user = userDAO.get(userId);
		if(user != null)
		    System.out.println(user.getEmail());
		assertNotNull(user);
	}
	
	@Test
	public void testGetUsersNotFound() {
		Integer userId = 55;
		Users user = userDAO.get(userId);
		
		assertNotNull(user);
	}
	
	
	
	@Test
	public void testDeleteUsers() {
		Integer userId = 13;
		userDAO.delete(userId);
		Users user = userDAO.get(userId);
		assertNull(user);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistsUsers() {
		Integer userId = 13;
		userDAO.delete(userId);
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers = userDAO.listAll();
		for(Users user : listUsers){
		   System.out.println(user.getEmail());
		}
		//assertTrue(listUsers.size() > 0);
	}
	
	@Test
	public void testListProductiveUsers() {
		List<Users> listUsers = userDAO.listProductiveUsers();
		for(Users user : listUsers){
		   System.out.println(user.getFirstName());
		}
		//assertTrue(listUsers.size() > 0);
	}
	
	@Test
	public void testPositiveReviewrs() {
		List<Users> listPositiveReviewrs = userDAO.listPositiveReviewers();
		for(Users user : listPositiveReviewrs){
		   System.out.println(user.getFirstName());
		}
		//assertTrue(listUsers.size() > 0);
	}
	
	@Test
	public void testCount() {
		long totalUsers = userDAO.count();
		assertEquals(2, totalUsers);
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email = "judi@email";
		String password = "j1234";
		boolean loginResult = userDAO.checkLogin(email, password);
		
		assertTrue(loginResult);
	}

	@Test
	public void testCheckLoginFailed() {
		String email = "root";
		String password = "toot1234";
		boolean loginResult = userDAO.checkLogin(email, password);
		
		assertFalse(loginResult);
	}
	
	@Test
	public void testByEmail() {
		String email = "root";
		Users user =userDAO.findByEmail(email);
		assertNotNull(user);
	}
	
	

}
