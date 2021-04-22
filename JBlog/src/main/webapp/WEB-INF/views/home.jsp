<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/assets/css/blogmain.css"/>" />

<body>

	<jsp:include page="/WEB-INF/views/includes/blogheader.jsp"></jsp:include>
	
	<form>
		<input type = "text">
		<input class="btn btn-secondary" type = "submit" value = "검색"> <br>
		<input type = "radio" name = "searchcate" value="blogName"> 블로그제목
		<input type = "radio" name = "searchcate" value="bloger"> 블로거
	</form>
	
</body>
</html>