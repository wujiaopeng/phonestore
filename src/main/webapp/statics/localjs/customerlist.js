var path = $("#path").val();
$(function(){
	
	$("#addCustomer").click(function(){
		window.location.href="addCustomer";
	});
	
	$(".modifycustomer").click(function(){
		var obj = $(this);
		window.location.href="modifycustomer?cid="+obj.attr("cid");
	});
	
	$(".delCustomer").click(function(){
		var obj = $(this);
		if(confirm("你确定要删除客户【"+obj.attr("cname")+"】吗？")){
			$.ajax({
				type:"GET",
				url:path+"/system/delCustomer",
				data:{cid:obj.attr("cid")},
				dataType:"json",
				success:function(data){
					if(data.delResult == "true"){//删除成功：移除删除行
						alert("删除成功");
						obj.parents("tr").remove();
					}else if(data.delResult == "false"){//删除失败
						alert("对不起，删除用户【"+obj.attr("cname")+"】失败");
					}else if(data.delResult == "notexist"){
						alert("对不起，用户【"+obj.attr("cname")+"】不存在");
					}
				},
				error:function(data){
					alert("对不起，删除失败");
				}
			});
		}
	});
	
});