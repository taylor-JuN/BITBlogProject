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
	<div>
		<ul>			
			<li> <a href = "<c:url value="/users/join" />">joinUs</a></li>
			<li> <a href = "<c:url value="/users/login" />">login</a></li>			
			<li> <a href = "<c:url value="/users/logout" />">logout</a></li>
		</ul>	
	</div>
</body>
</html>