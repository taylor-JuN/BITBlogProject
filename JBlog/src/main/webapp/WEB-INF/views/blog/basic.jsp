<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="<c:url value="/assets/css/myblogmain.css"/>" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<body>
<jsp:include page="/WEB-INF/views/includes/myblogheader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/includes/myblognav.jsp"></jsp:include>
	
	
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