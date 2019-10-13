// $(document).ready(function () {
$(() => {
	// clear()
	// 从本地存储获取key为emp的值及需要被记住的信息
	let local = localStorage.getItem("emp")
	// 判断该key在本地存储中是否存在值
	if (local != null) {
		// 为方便操作，使用JSON.parse方法将从本地存储读取到的的json字符串转为对象
		let emp = JSON.parse(local)
		// 获取当前系统时间
		let now = new Date()
		// 当前系统时间毫秒数与创建时间毫秒数的差
		let time = now.getTime() - emp.cereateTime

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
		// 判断如果当前时间与创建时间的差超过了阈值则从本地存储中清除已存储的值
		if (minutes > 0) {
			// 调用从本地存储中清除已存储的值的方法
			clear()
		} else {
			// 如果当前时间与创建时间的差没有超过了阈值则从本地存储中读取的值填充到页面
			let account = emp.account
			let password = emp.password
			// 向页面赋值
			$("#account").val(account)
			$("#password").val(password)
			$("#remember").attr('checked', 'true');
		}
	}

	// 回车绑定事件
	$(document).keyup((event) => {
		if (event.keyCode == 13) {
			// 回车事件与登录按钮单击事件绑定
			$('#loginBtn').click();
		}
	});

	// 绑定登录按钮单击事件
	$('#loginBtn').click(() => {
		// 调用登录方法
		loginCheck();
	});

});
// 登录
let loginCheck = () => {
	let account = $("#account").val()
	let password = $("#password").val()
	let remember = $("#remember").is(':checked')
	// 如果勾选了记住我则向本地存储中存储记录信息
	// 将存储信息存储在emp对象中
	// 注意预存储信息之前是否存储过
	// 只存储是否记住
	let emp = {
		"account": account,
		"password": password,
		"remember": remember,
	}
	if (account.length == 0) {
		window.alert("账号不能为空")
		// 获取焦点
		$("#account").focus()
		return
	} else if (password.length == 0) {
		window.alert("密码不能为空")
		$("#password").focus()
		return
	} else if (remember) {
		
		// 如果勾选了记住我调用rememberme方法存储信息
		rememberme(emp);
	} else {
		// 如果没有勾选了记住我则清空本地存储中存储记录信息
		// 调用clear方法清除信息
		clear()
	}
	// 由于向下一个页面发送的值不需要永久存储则将向下一个页面发送的值存储在临时存储中
	// 临时存储
	sessionStorage.setItem("emp", JSON.stringify(emp))
	// 页面跳转
	window.location.replace("./index.html")
}
let rememberme = (emp) => {
	// 从本地存储获取key为emp的值及需要被记住的信息
	let localString = localStorage.getItem("emp")
	// 如果获取到的值不为null说明之前存储过 
	if (localString != null) {
		// 将读取到的信息转为对象
		let local = JSON.parse(localString)
		if (local.account == emp.account && local.password == emp.password) {
			// 如果之前存储的账号和密码与刚从页面获取的账号密码一致
			// 则将之前存储的创建时间毫秒数赋值给创建时间
			emp.cereateTime = local.cereateTime
		} else {
			// 如果之前存储的账号和密码与刚从页面获取的账号密码不一致
			// 则将当前系统时间毫秒数赋值给创建时间
			emp.cereateTime = new Date().getTime()
		}
	} else {
		// 则将当前系统时间毫秒数赋值给创建时间
		emp.cereateTime = new Date().getTime()
	}
	// 将记录信息的对象转为json字符串存储到本地存储中
	localStorage.setItem("emp",JSON.stringify(emp))
}
// 从本地存储中移除记住的内容
let clear = () => {
	localStorage.removeItem("emp")
}