package com.cybage.shoutbox.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "firstName", nullable = false)
	private String firstName;
	@Column(name = "lastName", nullable = false)
	private String lastName;
	@Column(name = "mail", nullable = false)
	private String mail;
	@Column(name = "city")
	private String city;

	public User() {
		super();
	}
	
	public User(String firstName, String lastName, String mail, String city) {
		this.city = city;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
	}

	public User(long id, String name, String lastName, String mail, String city) {
		this.city = city;
		this.firstName = name;
		this.lastName = lastName;
		this.mail = mail;
		this.userId = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", mail=" + mail
				+ ", city=" + city + "]";
	}

}
