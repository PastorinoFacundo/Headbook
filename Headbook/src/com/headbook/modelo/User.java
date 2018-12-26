package com.headbook.modelo;

import java.net.URL;

public class User {

	private Long id;
	private String name;
	private String surname;
	private URL avatar;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public URL getAvatar() {
		return avatar;
	}
	public void setAvatar(URL avatar) {
		this.avatar = avatar;
	}
	
}
