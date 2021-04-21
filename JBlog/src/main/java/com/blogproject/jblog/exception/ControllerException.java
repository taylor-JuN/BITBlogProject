package com.blogproject.jblog.exception;

import javax.servlet.http.HttpServletRequest;

public class ControllerException extends RuntimeException{

	private HttpServletRequest req;
	public ControllerException(String message) {
		super(message);
	}
	public ControllerException(String message, HttpServletRequest req) {
		super(message);
		this.req = req;
	}
	public HttpServletRequest getReq() {
		return req;
	}
	public void setReq(HttpServletRequest req) {
		this.req = req;
	}
	
	
}
