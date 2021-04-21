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

<body>
		<div id = "site-introduction">
				<h1>회원 가입</h1>
				
				<form id="join-form" name="registerForm" action= " <c:url value="/users/join"/> " method="POST" onsubmit = "return checkForm(this)">
					<input type="hidden" name="a" value="join">
					<input type="hidden" name="check" value="f">
					
					<label for="userName">이름</label><br/>
					<input name="userName" type="text" placeholder="이름을 입력하십시오"><br>
				
					<label for="id">아이디</label>
					<input type="button" value="중복체크" onclick="checkID(this.form.id,'<c:url value="/users/idcheck"/>')"><br/>
					<input type="text" name="id" placeholder="아이디를 입력하십시오.">
					<div id = "msg_id"></div>
					
				
					<label for="password">비밀번호</label><br/>
					<input name="password" type="password" placeholder="비밀번호를 입력하십시오"><br>
					
					<label for="agree">약관동의</label><br/>
					<input type="checkbox" name="agree">서비스 약관에 동의합니다
					<input type="submit" value="전송">
					 
				</form>
			
		</div>
</body>
</html>