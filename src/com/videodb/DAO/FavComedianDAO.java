package com.videodb.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.videodb.entity.Comedians;
import com.videodb.entity.Favcomedians;
import com.videodb.entity.Reviews;
import com.videodb.entity.Videos;

public class FavComedianDAO extends jpaDAO<Favcomedians> implements GenericDAO<Favcomedians> {
	
	public FavComedianDAO() {
	}
	
	@Override
	public Favcomedians create(Favcomedians favcomedian) {
		return super.create(favcomedian);
	}

	@Override
	public Favcomedians get(Object id) {
		return super.find(Favcomedians.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Favcomedians.class, id);
		
	}

	@Override
	public List<Favcomedians> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<Favcomedians> listFavoriteById2(Integer userId) {
		return super.findWithNativedQuery("Favcomedians.Favorite", userId);
	}
	
	

	

	
}
