package com.videoproject.entity3;
// Generated Apr 20, 2020, 12:09:43 AM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Customers generated by hbm2java
 */
@Entity
@Table(name = "customers", catalog = "dbtrain", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Customers implements java.io.Serializable {

	private int userId;
	private String email;
	private String password;
	private String firstname;
	private String lastName;
	private String gender;
	private int age;

	public Customers() {
	}

	public Customers(int userId, String email, String password, String lastName, String gender, int age) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
	}

	public Customers(int userId, String email, String password, String firstname, String lastName, String gender,
			int age) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
	}

	@Id

	@Column(name = "user_id", unique = true, nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "email", unique = true, nullable = false, length = 30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "FIRSTNAME", length = 30)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastName", nullable = false, length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "gender", nullable = false, length = 10)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "age", nullable = false)
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
