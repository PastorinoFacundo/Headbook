package com.headbook.restControllers;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.headbook.modelo.Post;
import com.headbook.modelo.User;
import com.headbook.response.AjaxResponseGenerator;
import com.headbook.response.AjaxResponseObject;
import com.headbook.services.LikeServices;
import com.headbook.services.PostServices;
import com.headbook.services.UserServices;

@RequestMapping("/post/rest")
@RestController
public class PostRestController {

	@Autowired
	private PostServices postServices;
	@Autowired
	private LikeServices likeServices;
	@Autowired
	private UserServices userServices;
	@Value("${headbook.loggedUser.id}") 
	private Long loggedUser_id;
	
	private static final Logger logger = LogManager.getLogger(PostRestController.class);
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public @ResponseBody AjaxResponseObject createPost(@RequestBody Post post) throws MalformedURLException{
		try {
			User loggedUser = userServices.getUser(loggedUser_id);
			post.setCreator(loggedUser);
			postServices.insertPost(post);
			return AjaxResponseGenerator.createSimpleResponseOK(null);
		}catch(RuntimeException e) {
			return AjaxResponseGenerator.createSimpleResponseError("An error has happened while creating your post");
		}
		
	}
	
	@RequestMapping(value="/like", method = RequestMethod.POST)
	public @ResponseBody AjaxResponseObject giveLike(@RequestBody Post post) throws MalformedURLException{
		User loggedUser = userServices.getUser(loggedUser_id);
		try {
			logger.debug("Registering [" + loggedUser.getId() + "] user's like to [" + post.getId() + "] post" );
			likeServices.giveLike(post, loggedUser);
			logger.error("[" + loggedUser.getId() + "] user's like registered succesfully");
			return AjaxResponseGenerator.createSimpleResponseOK(null);			
		}catch(RuntimeException e) {
			logger.error("An error has happened while registering user [" + loggedUser.getId() + "] like", e);
			return AjaxResponseGenerator.createSimpleResponseError("An error has happened while registering your 'like' to " + post.getCreator().getName() + "'s post");
		}
	}
	
}
