package com.headbook.response;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

public class AjaxResponseGenerator {
	
	private static final Logger logger = LogManager.getLogger(JsonGenerator.class);
	private static ObjectMapper objectMapper = new ObjectMapper();

	public static AjaxResponseObject createSimpleResponseOK(Object okMessageData){
		return new AjaxResponseObject(AjaxResponseState.OK, "", okMessageData);
	}
	
	public static AjaxResponseObject createSimpleResponseError(String errorMessage){
		return new AjaxResponseObject(AjaxResponseState.ERROR, errorMessage);
	}
	
	public static String objectToJson(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (IOException e) {
			logger.error("Ocurrio un error al convertir el objeto a json", e);
			throw new RuntimeException("Ocurrió un error inesperado.", e);
		}
	}
}
