package com.headbook.services;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.headbook.converters.PostConverter;
import com.headbook.db.mappers.LikesMapper;
import com.headbook.db.mappers.PostsMapper;
import com.headbook.db.model.LikesExample;
import com.headbook.db.model.Posts;
import com.headbook.db.model.PostsExample;
import com.headbook.modelo.Post;
import com.headbook.modelo.PostView;
import com.headbook.modelo.User;

@Service
public class PostServices {
	
	@Autowired
	private PostsMapper postsMapper;
	@Autowired
	private PostConverter postConverter;
	@Autowired
	private UserServices userServices;
	@Autowired
	private LikesMapper likesMapper;
	@Value("${headbook.loggedUser.id}") 
	private Long loggedUser_id;
	
	
	public PostView getPost(Long id) throws MalformedURLException {
		Posts postDB = postsMapper.selectByPrimaryKey(id);
		return setPostView(postDB);
	}
	
	
	public List<PostView> getAllPost() throws MalformedURLException {
		PostsExample example = new PostsExample();
		List<Posts> postDBList = postsMapper.selectByExample(new PostsExample());
		List<PostView> postViews = new ArrayList<>();
		for(Posts postDB : postDBList) {
			postViews.add(setPostView(postDB));
		}
		return postViews;
	}
	
	
	private PostView setPostView(Posts postDB) throws MalformedURLException {
		User user = userServices.getUser(postDB.getCreator());
		PostView postView = postConverter.PostDBtoPostView(postDB,user);
		
		LikesExample likesNumberExample = new LikesExample();
		likesNumberExample.createCriteria().andPostIdEqualTo(postDB.getId());
		int likesNumber = likesMapper.countByExample(likesNumberExample);
		LikesExample givenLikeExample = new LikesExample();
		givenLikeExample.createCriteria().andUserIdEqualTo(loggedUser_id).andPostIdEqualTo(postDB.getId());;
		int givenLike = likesMapper.countByExample(givenLikeExample);
		
		postView.setLikesNumber(likesNumber);
		postView.setGivenLike(givenLike > 0? true : false);
		return postView;
	}
	
	
	public void insertPost(Post post) {
		Posts postDB = postConverter.PostToPostDB(post);
		postDB.setDate(new Date());
		postsMapper.insert(postDB);
	}
}
