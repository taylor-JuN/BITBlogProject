
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div style = "text-align : center">
		<div id = "blogtitle">
			<h1> ${vo.getBlogTitle()} </h1>
			<ul>
			<c:choose>
					<c:when test = "${empty authUser }">
						<li> <a href = "<c:url value="/users/login" />">로그인</a></li>
					</c:when>
					<c:when test = "${authUser.getUserNo() != vo.getUserNo() }">
						<li> <a href = "<c:url value="/users/logout" />">로그아웃</a></li>
					</c:when>
					<c:otherwise>	
						<li> <a href = "<c:url value="/${authUser.getId() }/admin/basic" />">내블로그 관리</a></li>
						<li> <a href = "<c:url value="/users/logout" />">로그아웃</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>