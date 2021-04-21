
function checkForm(frm){
	console.log(frm);
	var username = frm.userName.value.trim();
	var password = frm.password.value.trim();
	var id = frm.id.value.trim();
	var check = frm.check.value;
	var agree = document.getElementsByName('agree');

	if(username.length == 0){
		alert("이름을 입력해주세요.");
		frm.userName.focus();
	}else if(id.length == 0){
		alert("아이디를 입력해주세요.");
		frm.id.focus();
	}else if(check !="t"){
		alert("이메일 중복체크를 해주세요.");
	}else if(password.length == 0){
		alert("패스워드를 입력해 주세요.");
		frm.password.focus();
	}else if(!agree[0].checked){
		alert("약관에 동의해 주세요.")
	}else{
		return true;
	}
	return false;
}


function checkID(idfield, url){
	console.log("id field : ", idfield.value);
	
	if(idfield.value.trim().length == 0){

		document.getElementById("msg_id").textContent="이메일을 입력하세요.";

		return;
	}
	
	$.ajax({
		url: url,
		type: "GET",
		dataType: "JSON",
		data: {
			id: idfield.value.trim()
		},
		success: function(result){
			console.log("Result : ", result);
			if(result.data == true){
				idfield.form.check.value="f";
				document.getElementById("msg_id").textContent="다른 아이디로 가입해 주세요.";
			}else{
				idfield.form.check.value="t";
				document.getElementById("msg_id").textContent="사용할 수 있는 아이디 입니다.";
			}
		},
		error: function(xhr, status, error){
			console.error("Status: ", status);
			console.error("Response: ", xhr);
			console.error("error: ", error);
			
			idfield.form.check.value="t";
		}
	});
	
	
}

function change(catefield, url){
	console.log(catefield)
	$.ajax({
		url: url,
		type: "GET",
		dataType: "JSON",
		data: {
			no : catefield
		},
		success: function(result){
			console.log("Result : ", result);
			console.log("Result : ", result.data[0].cateNo, result.data[0].regDate);
		},
		error: function(xhr, status, error){
			console.error("Status: ", status);
			console.error("Response: ", xhr);
			console.error("error: ", error);
			
			idfield.form.check.value="t";
		}
	});
	
	
}