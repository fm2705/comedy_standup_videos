package com.videodb.DAO;

import java.util.List;
import java.util.Locale.Category;

import javax.persistence.EntityManager;

import com.videodb.entity.Comedians;
import com.videodb.entity.Tagscollection;
import com.videodb.entity.Videos;

public class TagsDAO extends jpaDAO<Tagscollection> implements GenericDAO<Tagscollection> {


	
	public TagsDAO() {
	}

	@Override
	public Tagscollection get(Object tagId) {
		return super.find(Tagscollection.class, tagId);
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tagscollection> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	


}
