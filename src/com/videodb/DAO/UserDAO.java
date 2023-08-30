package com.videodb.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.videodb.entity.Users;
import com.videodb.entity.Videos;

public class UserDAO extends jpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Users create(Users user) {
		return super.create(user);
	}

	@Override
	public Users update(Users user) {	
		return super.update(user);
	}

	@Override
	public Users get(Object userId) {
		return super.find(Users.class, userId);
	}
	
	public Users findByEmail(String email) {
		List<Users> listUsers = super.findWithNamedQuery("Users.findByEmail", "email", email);

		if(listUsers != null && listUsers.size() > 0) {
			return listUsers.get(0);
		}
		return null;
	}

	@Override
	public void delete(Object userId) {
		 super.delete(Users.class, userId);
		
	}

	@Override
	public List<Users> listAll() {
		return super.findWithNamedQuery("Users.findAll");
	}
	
	public List<Users> listPositiveReviewers() {
		return super.findWithNamedQuery("Users.PositiveReviewrs");
	}
	
	public List<Users> listProductiveUsers() {
		return super.findWithNamedQuery("Users.ProductiveUsers");
	}

	
	@Override
	public long count() {
		return super.countWithNamedQuery("Users.countAll");
		
	}
	
	
	
	public boolean checkLogin(String email, String password) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("email", email);
		parameters.put("password", password);
		
		List<Users> listUsers = super.findWithNamedQuery("Users.checkLogin", parameters);
		
		if (listUsers.size() == 1) {
			return true;
		}
		
		return false;
	}


}
