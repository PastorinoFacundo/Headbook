package com.headbook.controllers;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.headbook.modelo.User;
import com.headbook.services.UserServices;

@Controller
public class MainController {
	
	@Autowired
	private UserServices userServices;
	@Value("${headbook.loggedUser.id}") 
	private Long loggedUser_id;
	
//	@RequestMapping(value="/login", method = RequestMethod.GET)
//	public String login(){
//		return "login";
//	}
	
//	@RequestMapping(value="/login", method = RequestMethod.POST)
//	public String login(@RequestParam Long userId){
//		return "home";
//	}
	
	@RequestMapping(value="/home")
	public ModelAndView home() throws MalformedURLException{
		ModelAndView modelAndView = new ModelAndView("home");
		User loggedUser = userServices.getUser(loggedUser_id);
		modelAndView.addObject("loggedUser", loggedUser);
		return modelAndView;
	}
	
	@RequestMapping(value="/post/new")
	public ModelAndView newPost() throws MalformedURLException{
		ModelAndView modelAndView = new ModelAndView("newPost");
		User loggedUser = userServices.getUser(loggedUser_id);
		modelAndView.addObject("loggedUser", loggedUser);
		return modelAndView;
	}
	
}
