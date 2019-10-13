$(document).ready(function() {
	getCookie()
	$("#remember").click(function() {
		var accountCookie = "user_account=" + $('#user_account').val()
		var passwordCookie = "user_password=" + $('#user_password').val()
		setCookie('user_account', accountCookie, 10)
		setCookie('user_password', passwordCookie, 10)
		return false
	});
	deleteCookie('user_password')
	getCookie()

});

var setCookie = function(key, value, expiresDay) {
	var date = new Date()
	date.setDate(date.getDate() + expiresDay)
	var d = date.toGMTString()
	document.cookie = key + '=' + value + '; expires=' + d
}
var getCookie = function() {
	var cookis = document.cookie
	if(cookis.length > 0) {
		var cookie = cookis.split("; ")
		for(var i = 0; i < cookie.length; i++) {
			var strCookie = cookie[i].split("=")
			for(var j = 0; j < strCookie.length; j++) {
				if("user_account" == strCookie[j]) {
					$('#user_account').val(strCookie[j + 1])
					console.log("user_account = " + strCookie[j + 1])
				}
				if("user_password" == strCookie[j]) {
					$('#user_password').val(strCookie[j + 1])
					console.log("user_password = " + strCookie[j + 1])
				}
			}
		}
	} else {
		console.log("当前cookie是空的")
	}
}

var deleteCookie = function(key){
	setCookie(key,null,-1)
}
