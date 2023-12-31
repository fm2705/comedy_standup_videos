package com.videoproject.entity3;
// Generated Apr 20, 2020, 12:09:43 AM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Person generated by hbm2java
 */
@Entity
@Table(name = "person", catalog = "inheritancedb")
public class Person implements java.io.Serializable {

	private int personId;
	private String firstname;
	private String lastname;
	private Integer age;

	public Person() {
	}

	public Person(int personId, String firstname, String lastname) {
		this.personId = personId;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Person(int personId, String firstname, String lastname, Integer age) {
		this.personId = personId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	@Id

	@Column(name = "person_id", unique = true, nullable = false)
	public int getPersonId() {
		return this.personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	@Column(name = "firstname", nullable = false, length = 30)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", nullable = false, length = 45)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
