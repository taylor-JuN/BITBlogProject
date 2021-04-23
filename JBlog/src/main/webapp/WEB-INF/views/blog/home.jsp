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
					<p>${postThingsList[0].getPostNo()}</p>
					<p> ${siteID.getUserNo()} </p>
					<h3>comments</h3>
					<c:choose>
						<c:when test = "${not empty authUser }">
							<form method = "POST" action = "${siteID.getId()}/insertcomment">
								<input type="hidden" name = "postNo" id = "postNo" value = "${postThingsList[0].getPostNo()}">
								<input type="hidden" name = "userNo" id = "userNo" value = "${authUser.getUserNo() }">
								<label style = "float : left; width :20%">${authUser.getUserName() }</label>
								<input style = "float : left; width :50%"type="text" name = "cmtContent" id ="cmtContent">
								<input style = "float : left; width :30%" type="submit" value = "코멘트작성">
							</form>	
						</c:when>
					</c:choose>
					<c:forEach items="${commentList}" var="commentList">
							
							<p style = "float : left; width : 20%; height : 30px">${commentList.getUserName() }</p>
							<p style = "float : left; width : 50%; height : 30px">${commentList.getCmtContent() }</p>
							<p style = "float : left; width : 15%; height : 30px">${commentList.getRegDate() }</p>
							<p style = "float:left; width : 10%; height : 30px">
								<c:choose>
										<c:when test = "${commentList.getUserNo() == authUser.getUserNo() }">
										<form method="post" action="<c:url value="${siteID.getId()}/deletecomment"/>">
										<input type='hidden' id = "no" name="no" value="${commentList.getCmtNo()}">
										
										<input class ="btn btn-danger" type="submit" value="삭제">
										</form>
										</c:when>
										<c:otherwise>
											
										</c:otherwise>
									</c:choose>
							</p>
					</c:forEach>
				</c:otherwise>
		</c:choose>	
		
		
		
	</div>
	
	<div id = "category">
		<img style = "width:100%; height:30% "src="${vo.getLogoFile()}">
		<a href="${siteID.getId()}">카테고리</a>
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