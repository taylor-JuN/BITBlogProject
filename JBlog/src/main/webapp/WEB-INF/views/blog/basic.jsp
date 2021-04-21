<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li> <a href = "<c:url value="basic" />">기본 설정</a></li>
		<li> <a href = "<c:url value="category" />">카테고리</a></li>
		<li> <a href = "<c:url value="write" />">글 작성</a></li>
	</ul>
	
	<h1>블로그 제목</h1>
	<h2>${vo.getBlogTitle()}</h2>
	<h1>로고 이미지</h1>
	<form method="post" >
			
			<label for="blogTitle">블로그제목</label> 
			<input id="blogTitle" name="blogTitle" type="text" value="${vo.getBlogTitle()}">
			<input id="userNo" name="userNo" type="hidden" value="${vo.getUserNo() }">
			<input type="submit" value="등록">
		
		</form>


</body>
</html>