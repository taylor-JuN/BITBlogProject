<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src = "<c:url value="/assets/js/jquery/jquery-3.6.0.js"/>"></script>
<style>
	#but {
	    background-color: Transparent;
	    background-repeat:no-repeat;
	    border: none;
	    cursor:pointer;
	    overflow: hidden;
	    outline:none;
	}
</style>
<body>
	<h1> ${vo.getBlogTitle()}의 블로그 </h1>
	
	<c:choose>
		<c:when test = "${empty authUser }">
			<li> <a href = "<c:url value="/users/join" />">joinUs</a></li>
			<li> <a href = "<c:url value="/users/login" />">login</a></li>
		</c:when>
		<c:when test = "${authUser.getUserNo() != vo.getUserNo() }">
			<li> <a href = "<c:url value="/users/logout" />">logout</a></li>
		</c:when>
		<c:otherwise>
			<li> <a href = "<c:url value="${authUser.getId()}/admin/basic" />">내블로그 관리</a></li>
			<li> <a href = "<c:url value="/users/logout" />">logout</a></li>
		</c:otherwise>
	</c:choose>
	
	<h1>최신 포스트</h1>		
	<p>${postThingsList[0].getPostTitle()}</p> 
	<p>${postThingsList[0].getPostContent()}</p>
	
	<h1>카테고리</h1>
	<c:forEach items="${cateThingsList}" var="cate">
			<form method = "POST">
				<input type="hidden" name = "cateNo" id = "cateNo" value = "${cate.getCateNo() }">
				<input type="submit" id= "but" value = "${cate.getCateName() }">
			</form>	
	</c:forEach>
	
	 <h1>포스트 종류</h1>
	<c:forEach items="${postThingsList}" var="catePost">
		<p>${catePost.getPostTitle() }</p>
		<p>${catePost.getRegDate() }</p>
	</c:forEach>
	
	 
</body>
</html>