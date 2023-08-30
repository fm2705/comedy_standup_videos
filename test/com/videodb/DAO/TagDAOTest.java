package com.videodb.DAO;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.videodb.entity.Comedians;
import com.videodb.entity.Tagscollection;

public class TagDAOTest extends BaseDAOTest1{
	
	private static TagsDAO tagsDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tagsDao = new TagsDAO();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tagsDao.close();
	}

	


	@Test
	public void testGet() {
		Integer tagid = 2;
		Tagscollection tag = tagsDao.get(tagid);
		assertNotNull(tagid);
	}

	

}
