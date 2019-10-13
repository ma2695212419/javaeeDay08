$(document).ready(function() {
	getCookie()
	$("#remember").click(function() {
		var accountCookie = "user_account=" + $('#user_account').val()
		var passwordCookie = "user_password=" + $('#user_password').val()
		document.cookie = accountCookie
		document.cookie = passwordCookie
		getCookie()
	});
});

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

function setCookie(name, value, hours, path, domain, secure) {
	var cdata = name + "=" + value;
	if(hours) {
		var d = new Date();
		d.setHours(d.getHours() + hours);
		cdata += "; expires=" + d.toGMTString();
	}
	cdata += path ? ("; path=" + path) : "";
	cdata += domain ? ("; domain=" + domain) : "";
	cdata += secure ? ("; secure=" + secure) : "";
	document.cookie = cdata;
}

function getCookie(name) {
	var reg = eval("/(?:^|;\\s*)" + name + "=([^=]+)(?:;|$)/");
	return reg.test(document.cookie) ? RegExp.$1 : "";
}

function removeCookie(name, path, domain) {
	this.setCookie(name, "", -1, path, domain);
}