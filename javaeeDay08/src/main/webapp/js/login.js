$(function () {
	$("#loginBtn").click(function(){
		loginCheck();
	});
});
window.document.onkeyup = function (event) {
	if(event.keyCode == 13){
		loginCheck()
	}
}
function loginCheck(){
	// let form01 = $("#loginForm").serialize();
	let account = $("#account").val()
	let password = $("#password").val()
	if ("" == account.trim()) {
		alert("账号不能为空")
		$("#account").focus()
	} else if("" == password.trim()){
		alert("密码不能为空")
		$("#password").focus()
	}else{
		$("#loginForm").submit();
	}
}