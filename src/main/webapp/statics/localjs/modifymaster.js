var path = $("#path").val();
$(function(){

	$("#back").on("click",function(){
		window.location.href = "masterlist";
	});
	
	$("#password").bind("blur",function(){
		var pwd=$("#password").val();
		if(pwd==null || pwd==""){
			$(".message3").html("密码不能为空！");
			validateTip($("#password"),false);
		}else if(pwd.length<6){
			$(".message3").html("长度不能小于6位！");
			validateTip($("#password"),false);
		}else{
			$(".message3").html("");
			validateTip($("#password"),true);
		}
	});
	
	$("#name").bind("blur",function(){
		var name=$("#name").val();
		if(name==null || name==""){
			$(".message4").html("姓名不能为空！");
			validateTip($("#name"),false);
		}else{
			$(".message4").html("");
			validateTip($("#name"),true);
		}
	});
	$("#phone").bind("blur",function(){
		var patrn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
		var phone=$("#phone").val();
		if(phone.match(patrn)){
			$(".message5").html("");
			validateTip($("#phone"),true);
		}else{
			$(".message5").html("手机格式不对！");
			validateTip($("#phone"),false);
		}
	});
	
	function validateTip(element,status){
		
		element.attr("validateStatus",status);
	}
	
	$("#addBtn").bind("click",function(){
		if($("#password").attr("validateStatus") == "false"){
			$("#password").blur();
		}else if($("#name").attr("validateStatus") == "false"){
			$("#name").blur();
		}else if($("#phone").attr("validateStatus") == "false"){
			$("#phone").blur();
		}else{
			if(confirm("是否确认提交数据")){
				$("#myForm").submit();
			}
		}
	});
	
	
});