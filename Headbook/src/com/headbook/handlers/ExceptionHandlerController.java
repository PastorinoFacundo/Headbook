package com.headbook.handlers;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

public class ExceptionHandlerController {

	private static final Logger logger = LogManager.getLogger(ExceptionHandlerController.class);
	
	public ExceptionHandlerController() { }
	
	@ExceptionHandler(Exception.class)
	public ModelAndView resolveExceptionDefault(HttpServletRequest request,
			Exception e) {
		logger.error("An unexpected error has happened:", e);
		
		ModelAndView errorView = new ModelAndView(new RedirectView(request.getContextPath() + "/error"));

		errorView.addObject("error", "An unexpected error has happened.");

		return errorView;
	}
	
}