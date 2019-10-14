$(document).ready(function(){
  $("#firstPage").click(function(){
	  page(1);
  });
  $("#previousPage").click(function(){
	  let index = 1;
	  if($("#currentPage").text() > 1){
		  index = $("#currentPage").text() - 1;
	  }
	  page(index);
  });
  $("#nextPage").click(function(){
	  let index = parseInt($("#countPage").text());
	  if($("#currentPage").text() < $("#countPage").text()){
		  index = parseInt($("#currentPage").text()) + 1;
	  }
	  page(index);
  });
  $("#lastPage").click(function(){
	  page($("#countPage").text());
  });
});
function page(index){
	let queryParmas = "";
	if ($("#queryNickname").text() != "") {
		queryParmas += "&nickname="+$("#queryNickname").text();
	}
	if ($("#queryGender").text() != "") {
		queryParmas += "&gender="+$("#queryGender").text();
	}
	if ($("#queryDid").text() != "") {
		queryParmas += "&did="+$("#queryDid").text();
	}
	if ($("#queryData_from").text() != "") {
		queryParmas += "&data_from="+$("#queryData_from").text();
	}
	if ($("#queryData_to").text() != "") {
		queryParmas += "&data_to="+$("#queryData_to").text();
	}
	location.replace("/front/emp.action?methodName=queryEmps" + queryParmas +"&pageNum=" + index)
    // $("#seachForm").submit();
}
function clearFrom(){
	 $(" input[ type='text' ] ").val("");
}
