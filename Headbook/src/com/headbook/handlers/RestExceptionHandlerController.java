package com.headbook.handlers;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.headbook.response.AjaxResponseGenerator;
import com.headbook.response.AjaxResponseObject;

@ControllerAdvice(annotations=RestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
@ResponseBody
public class RestExceptionHandlerController {
	
	private static final Logger logger = LogManager.getLogger(RestExceptionHandlerController.class);
	/**
	 * Handler default para excepciones no contempladas.
	 */
	@ExceptionHandler(Exception.class)
	public AjaxResponseObject resolveExceptionDefault(HttpServletRequest request, Exception e) {
		logger.error("RestController - An unexpected error has happened: ", e);
		return AjaxResponseGenerator.createSimpleResponseError("An unexpected error has happened");
	}
	
}