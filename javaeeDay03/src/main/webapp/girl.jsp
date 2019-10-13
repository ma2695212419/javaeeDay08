<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>美女图片</title>
<script type="text/javascript">
	function cha() {
		//获取value值
		var id = document.getElementById("sel").value;

		//修改img的图片
		var photo = document.getElementById("img");
		if (id != 0) {
			//1、javascript调用servlet并传递参数
			photo.src = "imgAction?id=" + id;
		} 
	}
</script>
</head>
<body>
	<!-- 下拉列表（列出n个美女） -->
	<select id="sel" onchange="cha()">
		<option selected="selected" value="0">---请选择---</option>
		<option value="1">杨幂</option>
		<option value="2">刘晓庆</option>
		<option value="3">林青霞</option>
		<option value="4">邓丽君</option>
		<option value="5">章子怡</option>
	</select>
	<hr />
	<!-- img用于显示美女图片 -->
	<img alt="" id="img" />
</body>
</html>