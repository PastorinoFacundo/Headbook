package com.headbook.modelo;

import java.util.Date;

public class PostView extends Post {

	Integer likesNumber;
	boolean givenLike;
	
	public PostView(Long id, User creator, Date date, String title, String content) {
		super(id, creator, date, title, content);
		this.likesNumber = 0;
		this.givenLike = false;
	}

	public Integer getLikesNumber() {
		return likesNumber;
	}
	public void setLikesNumber(Integer likesNumber) {
		this.likesNumber = likesNumber;
	}
	public boolean isGivenLike() {
		return givenLike;
	}
	public void setGivenLike(boolean givenLike) {
		this.givenLike = givenLike;
	}
	
}
