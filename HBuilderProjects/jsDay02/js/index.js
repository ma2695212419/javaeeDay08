window.onload = ()=>{
	// 从临时存储区获取key的value值
	let account = sessionStorage.getItem("account")
	if (account == null || account.trim().length == 0){
		window.location.replace("./login.html")
	} else{
		window.document.getElementById("optioner").innerText=account
	}
}