package com.videoproject.entity3;
// Generated Apr 20, 2020, 12:09:43 AM by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Videos generated by hbm2java
 */
@Entity
@Table(name = "videos", catalog = "videodb", uniqueConstraints = @UniqueConstraint(columnNames = "URL"))
public class Videos implements java.io.Serializable {

	private Integer videoId;
	private Comedians comedians;
	private Users users;
	private String url;
	private String tittle;
	private String description;
	private Date date;
	private String tags;
	private Set<Tagscollection> tagscollections = new HashSet<Tagscollection>(0);
	private Set<Reviews> reviewses = new HashSet<Reviews>(0);

	public Videos() {
	}

	public Videos(Comedians comedians, Users users, String url, String tittle, String description, Date date,
			String tags, Set<Tagscollection> tagscollections, Set<Reviews> reviewses) {
		this.comedians = comedians;
		this.users = users;
		this.url = url;
		this.tittle = tittle;
		this.description = description;
		this.date = date;
		this.tags = tags;
		this.tagscollections = tagscollections;
		this.reviewses = reviewses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "video_id", unique = true, nullable = false)
	public Integer getVideoId() {
		return this.videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comedianId")
	public Comedians getComedians() {
		return this.comedians;
	}

	public void setComedians(Comedians comedians) {
		this.comedians = comedians;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "URL", unique = true, length = 500)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "tittle", length = 100)
	public String getTittle() {
		return this.tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "Tags", length = 100)
	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "video_tags", catalog = "videodb", joinColumns = {
			@JoinColumn(name = "videoId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "tagsId", nullable = false, updatable = false) })
	public Set<Tagscollection> getTagscollections() {
		return this.tagscollections;
	}

	public void setTagscollections(Set<Tagscollection> tagscollections) {
		this.tagscollections = tagscollections;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "videos")
	public Set<Reviews> getReviewses() {
		return this.reviewses;
	}

	public void setReviewses(Set<Reviews> reviewses) {
		this.reviewses = reviewses;
	}

}
