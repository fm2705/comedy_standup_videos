package com.videodb.entity;
// Generated Mar 7, 2020, 12:14:38 PM by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Comedians generated by hbm2java
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Comedians.findAll", query = "Select c from Comedians c ORDER BY c.firstName"),
	@NamedQuery(name = "Comedians.countAll", query = "SELECT Count(*) FROM Comedians c"),
	@NamedQuery(name = "Comedians.findByName", query = "Select u from Comedians u WHERE u.firstName = :firstName"),
	@NamedQuery(name = "Comedians.findByDate", query = "Select c from Comedians c JOIN Videos v"
	        + " ON v.comedians.comedianId = c.comedianId WHERE v.date  LIKE '%' || :date || '%' Group By c.firstName"),
	})

@NamedNativeQueries({
	@NamedNativeQuery(name = "Comedians.NativefindByDate", query = "select * from comedians join" + 
			" videos on comedians.comedian_id= videos.comedianId where videos.date = '2020-04-20' Group By firstName" , resultClass = Comedians.class),
	
	@NamedNativeQuery(name = "Comedians.Favorite", query = "SELECT comedians.firstName, comedians.lastName, comedians.birthDay, comedians.birthPlace, comedians.comedian_id,"
			+ "favcomedians.id "
			+ " from comedians " + 
			" inner join favcomedians on favComedians.comedianId = comedians.comedian_id " + 
			" where favcomedians.userId = ? " , resultClass = Comedians.class),
	
	@NamedNativeQuery(name = "Comedians.NativefindWhoIsCool", query = " select * from comedians "
			+ " join videos on comedians.comedian_id= videos.comedianId " + 
			" join reviews on videos.video_id=reviews.videoId where score= 'Excellent' group by comedian_id" , resultClass = Comedians.class),
	

	@NamedNativeQuery(name = "Comedians.NativefindWhoIsHot", query = "select firstName, lastName, comedian_id, birthDay, birthPlace,"
			+ " count( reviews.videoId) as reviewsPerVideo, "
			+ " count( videos.comedianId) as videosPercomedian  from comedians" + 
			" left join videos on comedians.comedian_id= videos.comedianId " + 
			" left join reviews on videos.video_id=reviews.videoId " + 
			" group by comedianId order by reviewsPerVideo desc limit 3" , resultClass = Comedians.class),
	
	@NamedNativeQuery(name = "Comedians.NativefindWhoIsTop", query = "select firstName, lastName, comedian_id, birthDay, birthPlace, "
			+ " count( videos.comedianId) as videosPercomedian from comedians" + 
			" left join videos on comedians.comedian_id= videos.comedianId group by comedianId " + 
			" order by videosPercomedian desc limit 1" , resultClass = Comedians.class),
	@NamedNativeQuery(name = "Comedians.CommonFavComedians", query = " select distinct comedians.firstName, comedians.lastName, comedians.comedian_id, "
			+ "birthDay, birthPlace, fav1.userId, fav2.userId from comedians"
			+ " inner join favComedians fav1 on comedians.comedian_id = fav1.comedianId  and fav1.userId = ? " + 
			" inner join favComedians fav2 on comedians.comedian_id = fav2.comedianId and fav2.userId = ? " , resultClass = Comedians.class),
})


@Table(name = "comedians", catalog = "videodb")
public class Comedians implements java.io.Serializable {

	@Column(name = "comedian_id")
	private Integer comedianId;
	
	private String firstName;
	private String lastName;
	private Date birthDay;
	private String birthPlace;
	private Set<Favcomedians> favcomedianses = new HashSet<Favcomedians>(0);
	private Set<Videos> videos = new HashSet<Videos>(0);

	public Comedians() {
	}

	public Comedians(String firstName, String lastName, String birthPlace, Date birthDay) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.birthPlace = birthPlace;
	}

	public Comedians(String firstName, String lastName, Date birthDay, String birthPlace,
			Set<Favcomedians> favcomedianses, Set<Videos> videos) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.birthPlace = birthPlace;
		this.favcomedianses = favcomedianses;
		this.videos = videos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "comedian_id", unique = true, nullable = false)
	public Integer getComedianId() {
		return this.comedianId;
	}

	public void setComedianId(Integer comedianId) {
		this.comedianId = comedianId;
	}

	@Column(name = "firstName", nullable = false, length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", nullable = false, length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthDay", nullable = false, length = 10)
	public Date getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Column(name = "birthPlace", nullable = false, length = 45)
	public String getBirthPlace() {
		return this.birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comedians")
	public Set<Favcomedians> getFavcomedianses() {
		return this.favcomedianses;
	}

	public void setFavcomedianses(Set<Favcomedians> favcomedianses) {
		this.favcomedianses = favcomedianses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comedians")
	public Set<Videos> getVideos() {
		return this.videos;
	}

	public void setVideos(Set<Videos> videos) {
		this.videos = videos;
	}

}
