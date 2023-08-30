package com.videodb.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.videodb.entity.Videos;

public class VideoDAO extends jpaDAO<Videos> implements GenericDAO<Videos> {
	
	public VideoDAO() {
	}

	@Override
	public Videos create(Videos video) {
		return super.create(video);
	}

	@Override
	public Videos update(Videos t) {
		return null;
	}
	

	@Override
	public Videos get(Object videoId) {
		return super.find(Videos.class, videoId);
	}
	
	
	@Override
	public void delete(Object id) {
		
	}
	


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Videos findByURL(String url) {
		List<Videos> result = super.findWithNamedQuery("Videos.findByURL", "url", url);
		
		if (!result.isEmpty()) {
			return result.get(0);
		}
		
		return null;
	}

	
	@Override
	public List<Videos> listAll() {
		return super.findWithNamedQuery("Videos.findAll");
	}
	
	
	public List<Videos> listTop() {
		return super.findWithNamedQuery("Videos.Top");
	}
	public List<Videos> listPoorYouTube() {
		return super.findWithNamedQuery("Videos.PoorYouTube");
	}
	

	


	
	public List<Videos> listByComedians(int comedianId) {
		return super.findWithNamedQuery("Videos.findByComedian", "comId", comedianId);
	}
	
	public List<Videos> findAllVideosByUser(int userId) {
		return super.findWithNamedQuery("Videos.listbyUser", "userId", userId);
	}
	

	
	
	public List<Videos> search(String keyword) {
		return super.findWithNamedQuery("Videos.search", "keyword", keyword);
	}




}
