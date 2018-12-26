package com.headbook.modelo;

public class Like {

	private User user;
	private Post post;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	
	public Like(User user, Post post) {
		super();
		this.user = user;
		this.post = post;
	}
	
}
