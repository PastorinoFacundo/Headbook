package com.headbook.converters;

import org.springframework.stereotype.Service;

import com.headbook.db.model.Posts;
import com.headbook.modelo.Post;
import com.headbook.modelo.PostView;
import com.headbook.modelo.User;

@Service
public class PostConverter {
  
	public Post PostDBtoPost(Posts postDB, User creator) {
		Post post = new Post(postDB.getId(), 
								creator, 
								postDB.getDate(), 
								postDB.getTitle(), 
								postDB.getContent());
		return post;
	}
	
	public PostView PostDBtoPostView(Posts postDB, User creator) {
		PostView postView = new PostView(postDB.getId(), 
								creator, 
								postDB.getDate(), 
								postDB.getTitle(), 
								postDB.getContent());
		return postView;
	}
	
	public Posts PostToPostDB(Post post) {
		Posts postDB = new Posts();
		postDB.setId(post.getId());
		postDB.setCreator(post.getCreator().getId());
		postDB.setDate(post.getDate());
		postDB.setTitle(post.getTitle());
		postDB.setContent(post.getContent());
		return postDB;
	}
	
}