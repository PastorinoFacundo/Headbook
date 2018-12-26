package com.headbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.headbook.converters.LikeConverter;
import com.headbook.db.mappers.LikesMapper;
import com.headbook.db.model.LikesKey;
import com.headbook.modelo.Like;
import com.headbook.modelo.Post;
import com.headbook.modelo.User;

@Service
public class LikeServices {
	
	@Autowired
	private LikeConverter likeConverter;
	@Autowired
	private LikesMapper likesMapper;

	public void giveLike(Post post, User user) {
		Like like = new Like(user, post);
		LikesKey likesKey = likeConverter.LiketoLikesKey(like);
		likesMapper.insert(likesKey);
	}
	
}
