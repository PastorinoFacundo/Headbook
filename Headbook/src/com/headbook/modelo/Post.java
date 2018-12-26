package com.headbook.modelo;

import java.util.Date;

public class Post {

	
	private Long id;
	private User creator;
	private Date date;
	private String title;
	private String content;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Post(Long id, User creator, Date date, String title, String content) {
		super();
		this.id = id;
		this.creator = creator;
		this.date = date;
		this.title = title;
		this.content = content;
	}
	
}
