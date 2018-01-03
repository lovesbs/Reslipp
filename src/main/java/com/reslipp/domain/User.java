package com.reslipp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String userid;
	private String password;
	private String name;
	private String email;
	
	public Long getId() {
		return id;
	}
	public String getUserid() {
		return userid;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}
	public void update(User newUser) {
		// TODO Auto-generated method stub
		
		this.password=newUser.password;
		this.name=newUser.name;
		this.email=newUser.email;
	}
	
	
	
}
