window.onload = () => {
	
}

let regCheck = () => {
    let account = window.document.getElementById("account").value
    let password = window.document.getElementById("password").value
	let repassword = window.document.getElementById("repassword").value
    if ("" == account.trim() || account.trim().length == 0) {
        window.alert("账号不能为空")
    } else if ("" == password.trim() || password.trim().length == 0) {
        window.alert("密码不能为空")
    } else if ("" == repassword.trim() || repassword.trim().length == 0) {
        window.alert("重复密码不能为空")
    }else if(password.trim().length != repassword.trim().length){
		 window.alert("两次密码长度不一致")
        
    }else if(password.trim() != repassword.trim()){
		 window.alert("两次密码内容不一致")
    }else{
		if(window.confirm("恭喜注册成功，点击缺点跳转登录页面")){
			window.location.replace("./login.html")
		}
		
	}
}
// 绑定回车事件
window.onkeyup = (event)=>{
	if (event.keyCode == 13) {
		regCheck();
	}
}