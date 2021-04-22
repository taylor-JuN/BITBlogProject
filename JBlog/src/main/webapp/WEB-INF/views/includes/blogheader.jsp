<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="<c:url value="/assets/css/blogheader.css"/>" />


	<div class = "container">
		<div class = "row text-center">
			<img src="${pageContext.request.contextPath }/logos/logo.png">
		</div>
			
			<div class = "row">
				
					<ul>
						<c:choose>
							<c:when test = "${empty authUser }">
								
									<li>
										 <a href = "<c:url value="/users/login" />">로그인</a>
									</li>
									
									<li> 
										  <a href = "<c:url value="/users/join" />">회원가입</a>
									</li>
								
							</c:when>
							
							<c:otherwise>
								<li> <a href = "<c:url value="/users/logout" />">로그아웃</a></li>					
							</c:otherwise>
						</c:choose>
					</ul>
				
			</div>
			
	</div>
		
	
	