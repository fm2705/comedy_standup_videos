package com.videodb.DAO;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.videodb.entity.Comedians;
import com.videodb.entity.Favcomedians;
import com.videodb.entity.Users;

public class ComedianDAOTest extends BaseDAOTest1{
	
	private static ComedianDAO comedianDao;
	private static FavComedianDAO favComedianDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		comedianDao = new ComedianDAO();
		favComedianDao = new FavComedianDAO();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		comedianDao.close();
		favComedianDao.close();
	}


	@Test
	public void testCreateComedians() {
		
		Comedians comedian = new Comedians();
		comedian.setFirstName("blue");
		comedian.setLastName("pink");		
		comedian.setBirthDay(java.sql.Date.valueOf(java.time.LocalDate.now()));
		comedian.setBirthPlace("ko");
		
		comedian = comedianDao.create(comedian);
		
		assertTrue(comedian != null && comedian.getComedianId() > 0 );
	}

	@Test
	public void testUpdateComedians() {
		Comedians comedian = new Comedians();
		comedian.setComedianId(2);
		
		comedian.setFirstName("FFComedian");
		comedian.setLastName("FLChange");		
		comedian.setBirthDay(java.sql.Date.valueOf(java.time.LocalDate.now()));
		comedian.setBirthPlace("Mi");
		
		comedian = comedianDao.update(comedian);
		String expected = "FLChange";
		String actual = comedian.getLastName();
		
		assertEquals(expected, actual);
	}
	


	@Test
	public void testGet() {
		Integer comdId = 2;
		Comedians com = comedianDao.get(comdId);
		
		assertNotNull(comdId);
	}

	@Test
	public void testDeleteObject() {
		Integer comdId = 4;
		comedianDao.delete(comdId);
		
		Comedians com = comedianDao.get(comdId);
		assertNull(com);
	}

	@Test
	public void testListAll() {
		List<Comedians> listComedians = comedianDao.listAll();
		listComedians.forEach(c -> System.out.println(c.getFirstName() + ", "));
		assertTrue(listComedians.size() > 0);
		
	}
	
	@Test
	public void testListByDate() {
		String name = "2020-03-20";
		List<Comedians> listComedians = comedianDao.listByDate(name);
		listComedians.forEach(c -> System.out.println(c.getFirstName()  + ", "));
		assertTrue(listComedians.size() > 0);
		
	}
	
	
	@Test
	public void testNativelistByDate() {
		String name = "2020-03-20";
		List<Comedians> listComedians = comedianDao.NativefindNew();
		listComedians.forEach(c -> System.out.println(c.getFirstName()  + ", "));
		assertTrue(listComedians.size() > 0);
		
	}
	
	

	@Test
	public void testNativefindCool() {
		String name = "2020-03-20";
		List<Comedians> listComedians = comedianDao.NativefindCool();
		listComedians.forEach(c -> System.out.println(c.getFirstName()  + ", "));
		assertTrue(listComedians.size() > 0);
		
	}
	
	@Test
	public void testNativefindTop() {
		List<Comedians> listComedians = comedianDao.NativefindTop();
		listComedians.forEach(c -> System.out.println(c.getFirstName()  + ", "));
		assertTrue(listComedians.size() > 0);
		
	}
	
	@Test
	public void testNativefindHot() {
		List<Comedians> listComedians = comedianDao.NativefindHot();
		listComedians.forEach(c -> System.out.println(c.getFirstName()  + ", "));
		assertTrue(listComedians.size() > 0);
		
	}
	
	@Test
	public void testCommonFavComedians() {
		int user1 = 1;
		int user2 = 3;
		List<Comedians> listFavComedians = comedianDao.listCommonFavComedians(user1, user2);
		listFavComedians.forEach(c -> System.out.println(c.getFirstName()  + ", "));
		assertTrue(listFavComedians.size() > 0);
		
	}
	

	@Test
	public void testListFavByUserId() {
		
		List<Comedians> listComedians = comedianDao.listFavoriteById(1);
		listComedians.forEach(c -> System.out.println(c.getFirstName()  + ", "));
		assertTrue(listComedians.size() > 0);
		
	}

	@Test
	public void testListFavByUserId2() {
		
		List<Favcomedians> listComedians = favComedianDao.listFavoriteById2(1);
		listComedians.forEach(c -> System.out.println(c.getId()  + ", "));
		assertTrue(listComedians.size() > 0);
		
	}
	
	@Test
	public void testCount() {
		long totalComedians = comedianDao.count();
		assertEquals(7, totalComedians);
	}
	
	@Test
	public void testFindByName() {
		String name = "FFComedian";
		Comedians comedian = comedianDao.findByName(name);
		
		assertNotNull(comedian);
	}
	
	@Test
	public void testFindByNameNotFound() {
		String name = "FFComedian1";
		Comedians comedian = comedianDao.findByName(name);
		
		assertNull(comedian);
	}
	

	@Test
	public void testAddFavComedians() {
		
        Favcomedians favComedian = new Favcomedians();
		

		Comedians comedian = new Comedians();
		comedian.setComedianId(10);
		favComedian.setComedians(comedian);
		

		System.out.println("User:");
		Users user = new Users();
		user.setUserId(3);
		favComedian.setUsers(user);
		
		System.out.println("Creating favcomedians");
		Favcomedians createFavComedian = favComedianDao.create(favComedian);

		System.out.println("id is" + createFavComedian.getId());
	
		assertTrue(createFavComedian != null && createFavComedian.getId() > 0);
	}
	

	@Test
	public void testGetFavCom() {
		Integer comdId = 2;
		Favcomedians com = favComedianDao.get(comdId);
		
		assertNotNull(com);
	}
	

	

}
