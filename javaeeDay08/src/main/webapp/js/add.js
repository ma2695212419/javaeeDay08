$(function () {
	let flag = false;
	$("#account").focus(function(){
		$("#checkMsg").text("")
	})
	$("#account").blur(function(){
		$("#checkMsg").text("")
	})
	$("#account").keyup(function(){
		$.ajax({
			type:"post",
			url:"/javaeeDay07/front/emp.action?methodName=checkAccount",
			dataType:"json",
			data:{account:$("#account").val()},
			success:function(responseText){
				switch (responseText){
					case 0:
						$("#checkMsg").text("账号可以使用")
						$("#addEmpBtn").attr('disabled',false);
						flag = true;
						break;
					default:
						$("#checkMsg").text("账号已存在，请重新输入")
						$("#addEmpBtn").attr('disabled',true);
						flag = false;
						break;
				}
			}
		});
	})
	$("#addEmpBtn").click(function(){
		addEmp();
	});
	window.document.onkeyup = function (event) {
		if(event.keyCode == 13){
			addCheck(flag)
		}
	}
});

function addEmp(){
	
		let nickname = $("#nickname").val()
		let account = $("#account").val()
		let birthday = $("#birthday").val()
		if ("" == nickname.trim()) {
			alert("姓名不能为空")
			$("#nickname").focus()
		} else if ("" == account.trim()) {
			alert("账号不能为空")
			$("#account").focus()
		} else if("" == birthday.trim()){
			alert("生日不能为空")
			$("#birthday").focus()
		}else{
			alert("ok")
			$("#addEmp").submit();
		}
}