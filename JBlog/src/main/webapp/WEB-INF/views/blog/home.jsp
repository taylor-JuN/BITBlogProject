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
<link rel="stylesheet" href="<c:url value="/assets/css/myblogmain.css"/>" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

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
	<jsp:include page="/WEB-INF/views/includes/myblogheader.jsp"></jsp:include>

	<div id = "recentpost">
		<c:choose>
				<c:when test = "${empty postThingsList }">
					<h1> 등록된 글이 없습니다 !</h1>
				</c:when>
				<c:otherwise>
					<h2>${postThingsList[0].getPostTitle()}</h2> 
					<p>${postThingsList[0].getPostContent()}</p>
				</c:otherwise>
		</c:choose>		
		
	</div>
	
	<div id = "category">
		<h1>카테고리</h1>
		<c:forEach items="${cateThingsList}" var="cate">
				<form method = "POST">
					<input type="hidden" name = "cateNo" id = "cateNo" value = "${cate.getCateNo() }">
					<input type="submit" id= "but" value = "${cate.getCateName() }">
				</form>	
		</c:forEach>
	</div>
	
	
	
	<div id ="postbycategory">
		<c:forEach items="${postThingsList}" var="catePost">
			<p style ="float:left;width : 70%; "> ${catePost.getPostTitle() }</p>
			
			<p style ="float:right;width : 30%; text-align:right;">${catePost.getRegDate() }</p>
			
		</c:forEach>
	</div>
	
	 <jsp:include page="/WEB-INF/views/includes/myblogfooter.jsp"></jsp:include>
</body>
</html>