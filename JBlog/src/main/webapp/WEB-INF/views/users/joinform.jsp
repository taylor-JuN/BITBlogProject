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
<script src = "<c:url value="/assets/js/users.js"/>"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/assets/css/bloguser.css"/>" />


<body>

	<jsp:include page="/WEB-INF/views/includes/blogheader.jsp"></jsp:include>

				<form id="join-form" name="registerForm" action= " <c:url value="/users/join"/> " method="POST" onsubmit = "return checkForm(this)">
					<input type="hidden" name="a" value="join">
					<input type="hidden" name="check" value="f">
					
					<label for="userName">이름</label>
					<input name="userName" type="text" placeholder="이름을 입력하십시오"><br>
				
					<label for="id">아이디</label>
					<input id = "chceckid" style = "float:left; width: 280px"type="text" name="id" placeholder="아이디를 입력하십시오.">
					<input class = "btn btn-secondary" style = "margin-left : 20px; float:left" type="button" value="중복체크" onclick="checkID(this.form.id,'<c:url value="/users/idcheck"/>')">
					<div id = "msg_id"></div>
					
					<label for="password">비밀번호</label>
					<input name="password" type="password" placeholder="비밀번호를 입력하십시오"><br>
					
					<label for="agree">약관동의</label>
					<input type="checkbox" name="agree" style = "text-align:left">서비스 약관에 동의합니다 <br>
					<input class = "btn btn-secondary" style = "font-size:1.2em"type="submit" value="회원가입">
					 
				</form>
			
		
</body>
</html>