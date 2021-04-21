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
							<td>포스트수 미정</td>
							<td>${vo.getDescription() }</td>
							<td>${vo.getRegDate() }</td>
							<td><a href="">삭제</a></td>
						</tr>
						</c:forEach>
						<!-- /Loop -->
						
					</table>
					
					<h1> 새로운 카테고리 추가</h1>
					<form method = "POST">
						<label for = "cateName">카테고리명</label>
						<input id = "cateName" name ="cateName" type = "text">
						
						<label for = "description">셜명</label>
						<input id = "description" name ="description" type = "text">
						
						<input id = "userNo" name = "userNo" type = "hidden" value="${authUser.getUserNo() }">
						<input type="submit" value="카테고리 추가">
					</form>
					


</body>
</html>