package com.videodb.DAO;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.videodb.entity.Reviews;
import com.videodb.entity.Users;
import com.videodb.entity.Videos;

public class ReviewsTest {
	
	private static ReviewDAO reviewDao;

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@BeforeClass
	public static void setupClass() throws Exception {
		BaseDAOTest1.setUpBeforeClass();
		reviewDao = new ReviewDAO();	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		BaseDAOTest1.tearDownAfterClass();
	}
	
	
	@Test
	public void testCreateReview() {
		Reviews review = new Reviews();
		
		//review.setReviewId(23);
		review.setRemark("This is test remark");
		review.setScore("Good");
		
		Users user = new Users();
		user.setUserId(3);
		review.setUsers(user);
		
		Videos video = new Videos();
		video.setVideoId(49);
		review.setVideos(video);
		
		Reviews createReview = reviewDao.create(review);
		
		assertTrue(createReview.getReviewId() > 0); 
	
	}
	

}
