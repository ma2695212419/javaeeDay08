window.onload = () => {
	let account = localStorage.getItem("account")
	let password = localStorage.getItem("password")
	if (account != null && password != null) {
		window.document.getElementById("account").value=account
		window.document.getElementById("password").value=password
		window.document.getElementById("remember").checked=true
	}
}

let loginCheck = () => {
	let account = window.document.getElementById("account").value
	let password = window.document.getElementById("password").value
	if ("" == account.trim() || account.trim().length == 0) {
		window.alert("账号不能为空")
	} else if ("" == password.trim() || password.trim().length == 0) {
		window.alert("密码不能为空")
	} else if(window.document.getElementById("remember").checked){
		remember(account,password);
	} else{
		clear()
	}
	// 临时存储
	sessionStorage.setItem("account", account)
	window.location.replace("./index.html")
}
let remember = (account,password) => {
	if (window.document.getElementById("remember").checked) {
		// 本地存储
		localStorage.setItem("account",account)
		localStorage.setItem("password",password)
	}
}
// 从本地存储中移除记住的内容
let clear = () =>{
	localStorage.removeItem("account")
	localStorage.removeItem("password")
}
// 绑定回车事件
window.onkeyup = (event) => {
	if (event.keyCode == 13) {
		loginCheck();
	}
}
