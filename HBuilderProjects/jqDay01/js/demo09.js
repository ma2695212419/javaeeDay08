// $(document).ready(function(){
// $(function(){
$(() => {
	let emp = {
		"account": "kgc",
		"password": "1233546",
		"remember": true,
	}
	var date = new Date();
	// 字符串转时间函数
	date.setTime(date.getTime() + 60 * 1000); 
	$.cookie('emp',JSON.stringify(emp) , {
		expires: date
	});
	let empString = $.cookie("emp")
	window.console.log(empString)
	// js方法：

	// document.cookie = 'loginCount=1;expires=' + new Date() + ';path=/';
});
