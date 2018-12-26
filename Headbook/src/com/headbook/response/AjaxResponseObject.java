package com.headbook.response;

import com.google.gson.annotations.Expose;

public class AjaxResponseObject {

	@Expose private AjaxResponseState state;
	@Expose private String message;
	@Expose private Object data;
	
	public AjaxResponseObject(AjaxResponseState state, String message) {
		super();
		this.state = state;
		this.message = message;
	}
	public AjaxResponseObject(AjaxResponseState state, String message, Object data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
	}
	public AjaxResponseState getState() {
		return state;
	}
	public void setState(AjaxResponseState state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}	
}
