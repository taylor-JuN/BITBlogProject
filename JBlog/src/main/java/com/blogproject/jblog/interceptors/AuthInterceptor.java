package com.blogproject.jblog.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.blogproject.jblog.vo.UserVO;



public class AuthInterceptor extends HandlerInterceptorAdapter {

	private static Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.debug("authInterceptor log");
		HttpSession session = request.getSession();
		UserVO authUser = null;
		
		if(session != null) {
			authUser = (UserVO)session.getAttribute("authUser");
		}
		
		if(authUser == null) {
			response.sendRedirect(request.getContextPath() + "/users/login");
			return false;
		}
		
		return true;
		
	}

}