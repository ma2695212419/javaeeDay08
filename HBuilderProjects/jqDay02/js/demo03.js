window.onload = () => {

}
let fun02 = () => {
	// 1、创建浏览器对象
	let xhr;
	try {
		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xhr = new XMLHttpRequest
	} catch (e) {
		// IE6, IE5 浏览器执行代码
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	// 2、建立连接
	xhr.open("GET", "./res/demo03.txt", true)
	// xhr.open(请求方式,资源路径,是否异步,回调函数)
	// 3、发送数据
	// 兼容早起的火狐浏览器，在没有数据发送的时候需要传递一个参数null
	xhr.send(null)
	// 4、服务器响应
	xhr.onreadystatechange = () => {
		// 回传三个参数
		// 4.1	readyState 状态
		// 4.1.1
		// 0	未建立连接
		// 1	连接已建立
		// 2	发送数据
		// 3	服务器处理
		// 4	服务器响应
		// 4.2	responseText 纯文本数据、responseXML xml格式数据、json
		// window.alert(xhr.readyState)
		// status http状态码
		// window.alert(xhr.readyState)
		// status http状态码
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				// window.alert(xhr.responseText)
				// 借助dom解析在页面上异步显示服务器端响应的数据
				window.document.getElementById("content").innerText = xhr.responseText
			} else {
				window.alert("服务器走丢了")
			}

		}
	}
	// 防止页面跳转
	return false;
}
