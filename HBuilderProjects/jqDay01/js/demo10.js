// $(document).ready(function(){
// $(function(){
$(() => {
	let empString = $.cookie("emp")
	window.console.log(empString)
	if (empString == undefined) {
		window.alert("undefined")
	}
	// undefined
	// js方法：

	// document.cookie = 'loginCount=1;expires=' + new Date() + ';path=/';
});
