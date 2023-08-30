package com.videodb.entity;
// Generated Apr 20, 2020, 12:09:43 AM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 * Favcomedians generated by hbm2java
 */
@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name = "Favcomedians.Favorite", query = "SELECT  favcomedians.id, favcomedians.comedianId, favcomedians.userId from favcomedians \r\n" + 
			" join comedians on favComedians.comedianId = comedians.comedian_id\r\n" + 
			"where favcomedians.userId = ? " , resultClass = Favcomedians.class),
})
@Table(name = "favcomedians", catalog = "videodb")
public class Favcomedians implements java.io.Serializable {

	private Integer id;
	private Comedians comedians;
	private Users users;

	public Favcomedians() {
	}

	public Favcomedians(Comedians comedians, Users users) {
		this.comedians = comedians;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comedianId", nullable = false)
	public Comedians getComedians() {
		return this.comedians;
	}

	public void setComedians(Comedians comedians) {
		this.comedians = comedians;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
