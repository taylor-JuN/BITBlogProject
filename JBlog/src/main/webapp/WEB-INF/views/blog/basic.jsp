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
	
	

	
		<form method="post" action="update" enctype = "multipart/form-data">
			<label for="blogTitle">블로그제목</label> 
			<input id="blogTitle" name="blogTitle" type="text" value="${vo.getBlogTitle()}">
			<input id="userNo" name="userNo" type="hidden" value="${vo.getUserNo() }">
			<br>			
			<label>로고이미지</label>			
			<img style = "width:30%; height:30% " src="${pageContext.request.contextPath}/${vo.getLogoFile()}">
			<input type="file" id = "file" name="file" >		
			<input class = "btn btn-secondary" style = "width : 200px"type="submit" value="기본설정변경">
		</form>
			

</body>
</html>