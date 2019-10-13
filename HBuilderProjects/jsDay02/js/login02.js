window.onload = () => {
	// clear()
	let emp = JSON.parse(localStorage.getItem("emp"))
	if (emp != null) {
		// 当前系统时间与创建时间的差
		let now = new Date()
		let time = now.getTime() - parseInt(cereateTime)
		// 计算相差天数
		let days = Math.floor(time / (1000 * 60 * 60 * 24))

		//计算出小时数
		let leave1 = time % (24 * 60 * 60 * 1000) 
		let hours = Math.floor(leave1 / (60 * 60 * 1000))

		//计算相差分钟数
		let leave2 = leave1 % (60 * 60 * 1000) 
		let minutes = Math.floor(leave2 / (60 * 1000))
		//计算相差秒数
		let leave3 = leave2 % (60 * 1000) 
		let seconds = Math.round(leave3 / 1000)
		window.console.log(minutes)
		if (minutes > 0) {
			clear()
		}else{
			let account = emp.account
			let password = emp.password
			let remember = emp.remember
			let cereateTime = emp.cereateTime
			window.document.getElementById("account").value = account
			window.document.getElementById("password").value = password
			window.document.getElementById("remember").checked = remember
		}
		
	}
}

let loginCheck = () => {
	let account = window.document.getElementById("account").value
	let password = window.document.getElementById("password").value
	let remember = window.document.getElementById("remember").checked
	if ("" == account.trim() || account.trim().length == 0) {
		window.alert("账号不能为空")
	} else if ("" == password.trim() || password.trim().length == 0) {
		window.alert("密码不能为空")
	} else if (remember) {
		let local = JSON.parse(localStorage.getItem("emp"))
		let emp = {
			"account": account,
			"password": password,
			"remember": remember,
		}
		if (local != null) {
			emp.cereateTime = local.cereateTime
		} else {
			emp.cereateTime = new Date().getTime()
		}
		rememberme(emp);
	} else {
		clear()
	}
	// 临时存储
	sessionStorage.setItem("account", account)
	window.location.replace("./index.html")

}
let rememberme = (emp) => {
	if (window.document.getElementById("remember").checked) {
		// 本地存储
		localStorage.setItem("emp", JSON.stringify(emp))
	}
}
// 从本地存储中移除记住的内容
let clear = () => {
	localStorage.removeItem("emp")
}
// 绑定回车事件
window.onkeyup = (event) => {
	if (event.keyCode == 13) {
		loginCheck();
	}
}
