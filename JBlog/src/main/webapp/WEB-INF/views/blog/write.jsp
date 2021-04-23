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
<style>
	.container{
	width: 50%;
	text-align : left;}
</style>
<body>
<jsp:include page="/WEB-INF/views/includes/myblogheader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/includes/myblognav.jsp"></jsp:include>

	<form method="post">
	    <label style="width : 5%" for="postTitle">제목</label>
	    <input style="width : 380px" type="text" name="postTitle" value="">
	
	    <select id="cateNo" name="cateNo">
	        <c:forEach items="${list}" var="cateVO">
	            <option value="${cateVO.getCateNo() }">${cateVO.getCateName() }</option>
	        </c:forEach>
	    </select>
	
	    <br>
	    <label style="width : 5%" for="postContent">내용</label>
	    <textarea style="width : 500px; height : 500px;" name="postContent"></textarea>
	    <br>
	    <label style="width : 5%"></label>
	    <input style="width : 450px" class="btn btn-secondary" type="submit" value="등록">
	</form>
</body>
</html>