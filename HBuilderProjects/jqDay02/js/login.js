$(() => {
	let serverconfig;
	$.getJSON("./res/serverconfig.json", (responseText, status, xhr) => {
		serverconfig = responseText.protocol + responseText.domain + responseText.port + responseText.context;
		// window.console.log(serverconfig)
		sessionStorage.setItem("conf",serverconfig)
	});
	let conf = sessionStorage.getItem("conf")
	window.console.log(conf)
	$.ajax({
		url:serverconfig,
		dataType:'json',
		type:'post',//HTTP请求类型
		success:function(data){
			
		},
		error:function(xhr,type,errorThrown){
			
		}
	});
});
