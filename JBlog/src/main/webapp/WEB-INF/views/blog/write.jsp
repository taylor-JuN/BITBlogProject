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
	<form method="post">
		<table border="1" width="640">
			<tr>
				<td>제목</td>
				<td><input type="text" name="postTitle" value=""></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea id="postContent" name="postContent"></textarea>
				</td>
			</tr>
			
				<select id = "cateNo" name="cateNo">
					<c:forEach items="${list}" var="cateVO">
				   		 <option value="${cateVO.getCateNo() }">${cateVO.getCateName() }</option>
				    </c:forEach>
				</select>
			
			
			<tr>
				<td colspan="2">
					<a href="<c:url value="/blog/" />">취소</a>
					<input type="submit" value="등록">
				</td>	
			</tr>
		</table>
	</form>
</body>
</html>