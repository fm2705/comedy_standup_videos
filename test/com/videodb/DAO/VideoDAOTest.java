package com.videodb.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.videodb.entity.Comedians;
import com.videodb.entity.Users;
import com.videodb.entity.Videos;

public class VideoDAOTest extends BaseDAOTest1 {
	private static VideoDAO videoDao;
	private UserDAO userDAO;
	private ComedianDAO comedianDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		videoDao = new VideoDAO();
		//BaseDAOTest.setUpBeforeClass();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		videoDao.close();
		//BaseDAOTest.tearDownAfterClass();
	}
	

	@Test
	public void testCreateVideos() throws ParseException {
		
		System.out.println("start");
        System.out.println("create comedian");
        
        Comedians comedian = new Comedians();
		comedian.setComedianId(6);
		
		Videos newVideo = new Videos();
		System.out.println("set comedian");
        newVideo.setComedians(comedian);

		System.out.println("set video");
		newVideo.setUrl("www.shuhdfierhfurdgf.com");
		newVideo.setTittle("new Title Video");
		newVideo.setDescription(" description for the video");
		newVideo.setDate(new Date());
		newVideo.setTags("newtag");
		
		 System.out.println("create video");
		Videos createdVideo = videoDao.create(newVideo);
		System.out.println("assert:");
		assertTrue(createdVideo.getVideoId() > 0); 
		System.out.println("End");
	}
	
	@Test
	public void testListPoorVideos() {
		List<Videos> listPoorYouTube = videoDao.listPoorYouTube();
		
		for (Videos aVideo : listPoorYouTube) {
			System.out.println(aVideo.getTittle() + " - " + aVideo.getUrl()); 
		}
		
	   assertFalse(listPoorYouTube.isEmpty());
	}
	
	@Test
	public void testListAll() {
		List<Videos> listVideos = videoDao.listAll();
		
		for (Videos aVideo : listVideos) {
			System.out.println(aVideo.getTittle() + " - " + aVideo.getUrl()); 
		}
		
	   assertFalse(listVideos.isEmpty());
	}
	
	@Test
	public void testListTop() {
		List<Videos> listVideos = videoDao.listTop();
		
		for (Videos aVideo : listVideos) {
			System.out.println(aVideo.getTittle() + " - " + aVideo.getUrl()); 
		}
		
	   assertFalse(listVideos.isEmpty());
	}
	
	
	@Test
	public void testGetVideoSuccess() {
		Integer videoId = 27;
		Videos video = videoDao.get(videoId);
		
		assertNotNull(video);
	}
	
	
	@Test
	public void testFindByURLNotExist() {
		String url = "www.notexsits";
		Videos video = videoDao.findByURL(url);
		
		assertNull(video);
	}
	
	@Test
	public void testFindByURLExist() {
		String url = "www.orange.com";
		Videos video = videoDao.findByURL(url);
		
		System.out.println(video.getTittle());
		System.out.println(video.getUrl());
		
		assertNotNull(video);
		
	}
	
	
	@Test
	public void testListByComedians() {
		int comedianId = 10;
		
		List<Videos> listVideos = videoDao.listByComedians(comedianId);
		for (Videos aVideo : listVideos) {
			System.out.println(aVideo.getTittle() + " - " + aVideo.getUrl()); 
		}
		
		assertTrue(listVideos.size() > 0);
	}
	
	@Test
	public void testListByUser() {
		int userId = 1;
		
		List<Videos> listVideos = videoDao.findAllVideosByUser(1);
		for (Videos aVideo : listVideos) {
			System.out.println(aVideo.getTittle() + " - " + aVideo.getUrl()); 
		}
		
		assertTrue(listVideos.size() > 0);
	}
	

	@Test
	public void testSearchVideoInTitle() {
		String keyword = "Alex";
		List<Videos> result = videoDao.search(keyword);
		
		for (Videos aBook : result) {
			System.out.println(aBook.getUrl());
		}
		
		assertEquals(1, result.size());
	}
}
