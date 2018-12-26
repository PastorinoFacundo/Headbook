package com.headbook.restControllers;

import java.net.MalformedURLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.headbook.modelo.PostView;
import com.headbook.response.AjaxResponseGenerator;
import com.headbook.response.AjaxResponseObject;
import com.headbook.services.PostServices;

@RequestMapping("/home/rest")
@RestController
public class HomeRestController {

	@Autowired
	private PostServices postServices;
	
	private static final Logger logger = LogManager.getLogger(HomeRestController.class);
	
	@RequestMapping(value="/getAllPosts")
	public @ResponseBody AjaxResponseObject getAllPosts() throws MalformedURLException{
		try {
			logger.debug("Retrieving all posts");
			List<PostView> posts = postServices.getAllPost();
			logger.debug("All posts retrieved succesfully");
			return AjaxResponseGenerator.createSimpleResponseOK(posts);			
		}catch(RuntimeException e) {
			logger.error("An error has happened while retrieving all posts", e);
			return AjaxResponseGenerator.createSimpleResponseError("An error has happened while retrieving all posts");
		}
	}
	
}
