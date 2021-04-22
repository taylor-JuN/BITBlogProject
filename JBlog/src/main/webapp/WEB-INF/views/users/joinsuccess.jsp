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


<body>

	<jsp:include page="/WEB-INF/views/includes/blogheader.jsp"></jsp:include>
	<h3 style = "text-align : center"> 감사합니다. 회원 가입 및 블로그가 성공적으로 만들어 졌습니다. </h3>
	<div style= "text-align:center">
		<a style = "display:inline-block; font-size :1.2em" href= "<c:url value="/users/login" />">로그인하기</a>
	</div>
</body>
</html>