package com.headbook.converters;

import org.springframework.stereotype.Service;

import com.headbook.db.model.LikesKey;
import com.headbook.modelo.Like;

@Service
public class LikeConverter {

	public LikesKey LiketoLikesKey(Like like) {
		LikesKey likesKey = new LikesKey();
		likesKey.setPostId(like.getPost().getId());
		likesKey.setUserId(like.getUser().getId());
		return likesKey;
	}
	
}