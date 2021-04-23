package com.blogproject.jblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{
	

	@ResponseStatus()
	@ExceptionHandler(ControllerException.class)
	public ModelAndView handleContorllerException(ControllerException e) {
		
		e.printStackTrace();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());
		mav.setViewName("error/exception");
		
		return mav;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserDAOException.class)
	public ModelAndView handleMemberDAOException(UserDAOException e) {
		System.err.println("memberdaoexception" + e.getMessage());
		e.printStackTrace();
		System.err.println("UserVO : " + e.getUserVO());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());
		mav.setViewName("error/exception");
		
		return mav;
	}
}
