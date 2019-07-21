var path = $("#path").val();
$(function(){

	$("#login").bind("click",function(){
        var account=$("#account").val();
        var password=$("#password").val();
		if(account == null || account ==""){
			$("#error").html("账号不能为空！");
		}else if(password == null || password == ""){
            $("#error").html("密码不能为空！");
		} else{
				$("#myForm").submit();
		}
	});
	
	
});