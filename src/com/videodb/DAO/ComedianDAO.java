package com.videodb.DAO;

import java.util.List;
import java.util.Locale.Category;

import javax.persistence.EntityManager;

import com.videodb.entity.Comedians;
import com.videodb.entity.Videos;

public class ComedianDAO extends jpaDAO<Comedians> implements GenericDAO<Comedians> {


	
	public ComedianDAO() {
	}

	
	@Override
	public Comedians create(Comedians comedian) {
		return super.create(comedian);
	}

	@Override
	public Comedians update(Comedians comedian) {
		return super.update(comedian);
	}

	@Override
	public Comedians get(Object comedianId) {
		return super.find(Comedians.class, comedianId);
	}

	@Override
	public void delete(Object comedianId) {	
		 super.delete(Comedians.class, comedianId);
	}

	@Override
	public List<Comedians> listAll() {
		return super.findWithNamedQuery("Comedians.findAll");
	}
	

	public List<Comedians> listByDate(String date) {
		return super.findWithNamedQuery("Comedians.findByDate","date", date);
	}
	
	public List<Comedians> listFavoriteById(Integer userId) {
		return super.findWithNativedQuery("Comedians.Favorite", userId);
	}
	


	
	public List<Comedians> NativefindNew() {
		return super.findWithNativedQuery("Comedians.NativefindByDate");
	}
	
	
	public List<Comedians> NativefindCool() {
		return super.findWithNativedQuery("Comedians.NativefindWhoIsCool");
	}
	
	public List<Comedians> NativefindTop() {
		return super.findWithNativedQuery("Comedians.NativefindWhoIsTop");
	}

	public List<Comedians> NativefindHot() {
		return super.findWithNativedQuery("Comedians.NativefindWhoIsHot");
	}
	
	public List<Comedians> listCommonFavComedians(Integer userId1, Integer userId2) {
		return super.findWithNativedQuery2("Comedians.CommonFavComedians", userId1, userId2);
	}
	
	
	
	

	@Override
	public long count() {
		return super.countWithNamedQuery("Comedians.countAll");
	}
	
	public Comedians findByName(String name) {
		List<Comedians> result = super.findWithNamedQuery("Comedians.findByName" , "firstName", name);
		
		if(result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
		
	}


}
