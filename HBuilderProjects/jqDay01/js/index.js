$(()=>{
    // 从临时存储区获取key的value值
    let empString = sessionStorage.getItem("emp")
	if (empString == null){
        // 如果没有获取到值则跳转登录页面
		window.location.replace("./login.html")
	} else{
        // 将从临时存储中获取到的信息显示在页面上
		let emp = JSON.parse(empString)
		$("#optioner").text(emp.account)
	}
})