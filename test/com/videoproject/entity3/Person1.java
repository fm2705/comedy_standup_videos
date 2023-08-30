package com.videoproject.entity3;
// Generated Apr 20, 2020, 12:09:43 AM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Person1 generated by hbm2java
 */
@Entity
@Table(name = "person1", catalog = "dbtrain")
public class Person1 implements java.io.Serializable {

	private Integer personId;
	private String firstname;
	private String lastname;
	private String nickname;
	private Integer age;
	private Set<Videos1> videos1sForUserid = new HashSet<Videos1>(0);
	private Set<Videos1> videos1sForComedianid = new HashSet<Videos1>(0);

	public Person1() {
	}

	public Person1(String firstname, String lastname, String nickname, Integer age, Set<Videos1> videos1sForUserid,
			Set<Videos1> videos1sForComedianid) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.nickname = nickname;
		this.age = age;
		this.videos1sForUserid = videos1sForUserid;
		this.videos1sForComedianid = videos1sForComedianid;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "person_id", unique = true, nullable = false)
	public Integer getPersonId() {
		return this.personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	@Column(name = "firstname", length = 30)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", length = 45)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "nickname", length = 100)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person1ByUserid")
	public Set<Videos1> getVideos1sForUserid() {
		return this.videos1sForUserid;
	}

	public void setVideos1sForUserid(Set<Videos1> videos1sForUserid) {
		this.videos1sForUserid = videos1sForUserid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person1ByComedianid")
	public Set<Videos1> getVideos1sForComedianid() {
		return this.videos1sForComedianid;
	}

	public void setVideos1sForComedianid(Set<Videos1> videos1sForComedianid) {
		this.videos1sForComedianid = videos1sForComedianid;
	}

}
