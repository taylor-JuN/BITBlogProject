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

					<table border="1" width="640">
						
						<tr>
							<th>번호</th>
							<th>카테고리명</th>
							<th>포스트수</th>
							<th>설명</th>
							<th>등록일</th>
							<th>삭제</th>
						</tr>
						<!-- Loop -->
						<c:forEach items="${list }" var="vo">
							<tr>
								<td>${vo.getCateNo() }</td>
								<td>${vo.getCateName() }</td>
								<td>${vo.getPostCount() }</td>
								<td>${vo.getDescription() }</td>
								<td>${vo.getRegDate() }</td>
								
								<td> 
									<c:choose>
										<c:when test = "${vo.getPostCount() ==0 }">
										<form method="post" action="<c:url value="delete"/>">
										<input type='hidden' id = "no" name="no" value="${vo.getCateNo()}">
											<div style = "text-align:center"><input style = "width : 100%" class ="btn btn-danger" type="submit" value="삭제"></div>
										</form>
										</c:when>
										<c:otherwise>
											<div style = "text-align:center"> <button style = "width : 100%" class ="btn btn-warning" onclick="alert('삭제할 수 없습니다.')">X</button></div>
										</c:otherwise>
									</c:choose>
								
								</td>
							</tr>
						</c:forEach>
						
						<!-- /Loop -->
						
					</table>
					
					<h3> 새로운 카테고리 추가</h3>
					<div>
						<form method = "POST">
							<label style = "width : 10%" for = "cateName">카테고리명</label>
							<input style = "width : 20%" id = "cateName" name ="cateName" type = "text">
							<br>
							<label style = "width : 10%" for = "description">설명</label>
							<input style = "width : 20%" id = "description" name ="description" type = "text">
							<br>
							<input id = "userNo" name = "userNo" type = "hidden" value="${authUser.getUserNo() }">
							<input class = "btn btn-secondary" type="submit" value="카테고리 추가">
						</form>
					</div>
					


</body>
</html>