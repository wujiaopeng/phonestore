var path = $("#path").val();
$(function(){
	//动态加载所属平台列表
	$.ajax({
		type:"GET",//请求类型
		url:path+"/goods/getBrandList",//请求的url
		data:{},//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			var querybrand = $("#querybrand").val();
			$("#brand1").html("");
			var options = "<option value=\"\">——请选择——</option>";
			for(var i = 0; i < data.length; i++){
				if(querybrand != null && querybrand != undefined && data[i].id == querybrand ){
					options += "<option selected=\"selected\" value=\""+data[i].id+"\" >"+data[i].brandType+"</option>";
				}else{
					options += "<option value=\""+data[i].id+"\">"+data[i].brandType+"</option>";
				}
			}
			$("#brand1").html(options);
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			alert("加载品牌列表失败！");
		}
	});
	
	//动态加载商品状态
	$.ajax({
		type:"GET",//请求类型
		url:path+"/goods/getStateList",//请求的url
		data:{},//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			var querystate = $("#querystate").val();
			$("#sta").html("");
			var options = "<option value=\"\">——请选择——</option>";
			for(var i = 0; i < data.length; i++){
				if(querystate != null && querystate != undefined && data[i].id == querystate ){
					options += "<option selected=\"selected\" value=\""+data[i].id+"\" >"+data[i].values+"</option>";
				}else{
					options += "<option value=\""+data[i].id+"\">"+data[i].values+"</option>";
				}
			}
			$("#sta").html(options);
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			alert("加载状态列表失败！");
		}
	});
	$(".modifyGoods").click(function(){
		var obj=$(this);
		window.location.href="modifyGoods?gid="+obj.attr("gid");
	});

    $(".goodsView").click(function(){
        var obj=$(this);
        window.location.href="goodsview?gid="+obj.attr("gid");
    });

    $(".delGoods").click(function(){
        var obj = $(this);
        if(confirm("你确定要删除商品【"+obj.attr("gname")+"】吗？")){
            $.ajax({
                type:"GET",
                url:path+"/goods/delGoods",
                data:{gid:obj.attr("gid")},
                dataType:"json",
                success:function(data){
                    if(data.delResult == "true"){//删除成功：移除删除行
                        alert("删除成功");
                        obj.parents("tr").remove();
                    }else if(data.delResult == "false"){//删除失败
                        alert("对不起，删除用户【"+obj.attr("gname")+"】失败");
                    }else if(data.delResult == "notexist"){
                        alert("对不起，用户【"+obj.attr("gname")+"】不存在");
                    }
                },
                error:function(data){
                    alert("对不起，删除失败");
                }
            });
        }
    });

	//上下架判断
	$(document).on("click",".saleSwichOpen,.saleSwichClose",function(){
		var obj = $(this);
		var gid = obj.attr("gid");
		var saleSwitch = obj.attr("saleSwitch");
		var gname=obj.attr("gname");
		if("open" == saleSwitch){
			 saleSwitchAjax(gid,obj);
		}
		if("close" == saleSwitch){
			if(confirm("你确定要下架您的商品【"+gname+"】吗？")){
				saleSwitchAjax(gid,obj);
			}
		}
	});
	//上下架操作
	var saleSwitchAjax=function(gid,obj){
		$.ajax({
			type:"GET",
			url:path+"/goods/updateState",
			data:{gid:gid,gstate:obj.attr("gstate")},
			dataType:"json",
			success:function(data){
				if(data.errorCode == "0"){
					if(data.resultMsg == "success"){//操作成功
						if("open" == obj.attr("saleSwitch")){
							$("#goodState" + obj.attr("gid")).html("已上架");
							obj.className="saleSwichClose";
							obj.html("下架");
							obj.attr("saleSwitch","close");
							obj.attr("gstate","2");
							$("#goodState" + obj.attr("gid")).css({
								'background':'green',
								'color':'#fff',
								'padding':'3px',
								'border-radius':'3px'
							});
							$("#goodState" + obj.attr("gid")).hide();
							$("#goodState" + obj.attr("gid")).slideDown(300);
						}else if("close" == obj.attr("saleSwitch")){
							$("#goodState" + obj.attr("gid")).html("已下架");
							obj.className="saleSwichOpen";
							obj.html("上架");
							obj.attr("saleSwitch","open");
							obj.attr("gstate","1");
							$("#goodState" + obj.attr("gid")).css({
								'background':'red',
								'color':'#fff',
								'padding':'3px',
								'border-radius':'3px'
							});		
							$("#goodState" + obj.attr("gid")).hide();
							$("#goodState" + obj.attr("gid")).slideDown(300);
						}
					}else if(data.resultMsg == "failed"){//删除失败
						if("open" == obj.attr("saleSwitch")){
							alert("【"+obj.attr("gname")+"】的【上架】操作失败");
						}else if("close" == obj.attr("saleSwitch")){
							alert("【"+obj.attr("gname")+"】的【下架】操作失败");
						}
					}
				}else{
					if(data.errorCode == 'exception000001'){
						alert("对不起，系统出现异常，请联系IT管理员");
					}else if(data.errorCode == 'param000001'){
						alert("对不起，参数出现错误，您可能在进行非法操作");
					}
				}
			},
			error:function(data){
				if("open" == obj.attr("saleSwitch")){
					alert("【"+obj.attr("gname")+"】的【上架】操作失败");
				}else if("close" == obj.attr("saleSwitch")){
					alert("【"+obj.attr("gname")+"】的【下架】操作失败");
				}
			}
		});
	};
	
})