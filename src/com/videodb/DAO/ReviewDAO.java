package com.videodb.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.videodb.entity.Reviews;
import com.videodb.entity.Videos;

public class ReviewDAO extends jpaDAO<Reviews> implements GenericDAO<Reviews> {
	
	public ReviewDAO() {
	}
	
	

	@Override
	public Reviews create(Reviews review) {
		return super.create(review);
	}

	@Override
	public Reviews get(Object id) {
		return super.find(Reviews.class, id);
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reviews> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
