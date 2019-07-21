var path = $("#path").val();
$(function(){

	$("#back").on("click",function(){
		window.location.href = "customerlist";
	});
	$("#account").bind("blur",function(){
		//ajax后台验证--账号是否已存在
		$.ajax({
			type:"GET",//请求类型
			url:path+"/system/isAccount",//请求的url
			data:{account:$("#account").val()},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				if(data.account == "empty"){//参数APKName为空，错误提示
					//alert("APKName为不能为空！");
					$(".message2").html("账号为不能为空！");
					validateTip($("#account"),false);
				}else if(data.account == "exist"){//账号不可用，错误提示
					$(".message2").html("该账号已存在，不能使用！");
					validateTip($("#account"),false);
				}else if(data.account == "noexist"){//账号可用，正确提示
					//alert("该账号可以使用！");
					$(".message2").html("该账号可以使用！").css("color","green");
					validateTip($("#account"),true);
				}
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				alert("请求错误！");
			}
		});
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
		if($("#account").attr("validateStatus") != "true"){
			$("#account").blur();
		}else if($("#password").attr("validateStatus") != "true"){
			$("#password").blur();
		}else if($("#name").attr("validateStatus") != "true"){
			$("#name").blur();
		}else if($("#phone").attr("validateStatus") != "true"){
			$("#phone").blur();
		}else{
			if(confirm("是否确认提交数据")){
                $("#myForm").submit();
            }
		}
	});
	
	
});