package com.videoproject.entity3;
// Generated Apr 20, 2020, 12:09:43 AM by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Comedians1 generated by hbm2java
 */
@Entity
@Table(name = "comedians1", catalog = "dbtrain")
public class Comedians1 implements java.io.Serializable {

	private int comedianId;
	private String firstname;
	private String lastname;
	private Date birthday;
	private String birthplace;
	private String city;
	private String state;
	private String street;
	private Set<Users1> users1s = new HashSet<Users1>(0);

	public Comedians1() {
	}

	public Comedians1(int comedianId) {
		this.comedianId = comedianId;
	}

	public Comedians1(int comedianId, String firstname, String lastname, Date birthday, String birthplace, String city,
			String state, String street, Set<Users1> users1s) {
		this.comedianId = comedianId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.birthplace = birthplace;
		this.city = city;
		this.state = state;
		this.street = street;
		this.users1s = users1s;
	}

	@Id

	@Column(name = "comedian_id", unique = true, nullable = false)
	public int getComedianId() {
		return this.comedianId;
	}

	public void setComedianId(int comedianId) {
		this.comedianId = comedianId;
	}

	@Column(name = "FIRSTNAME", length = 30)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "LASTNAME", length = 30)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY", length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "BIRTHPLACE", length = 30)
	public String getBirthplace() {
		return this.birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	@Column(name = "city", length = 100)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", length = 100)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "street", length = 100)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "favcomedians1", catalog = "dbtrain", joinColumns = {
			@JoinColumn(name = "comedianId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "userId", nullable = false, updatable = false) })
	public Set<Users1> getUsers1s() {
		return this.users1s;
	}

	public void setUsers1s(Set<Users1> users1s) {
		this.users1s = users1s;
	}

}
