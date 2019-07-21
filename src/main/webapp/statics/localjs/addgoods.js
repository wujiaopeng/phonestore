var path = $("#path").val();
$(function(){


	$("#back").on("click",function(){
		window.location.href = "goodslist";
	});
	
	//动态加载手机品牌列表
	$.ajax({
		type:"GET",//请求类型
		url:path+"/goods/getBrandList",//请求的url
		data:{},//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			$("#brand1").html("");
			var options = "<option value=\"\">——请选择——</option>";
			for(var i = 0; i < data.length; i++){
				options += "<option value=\""+data[i].id+"\">"+data[i].brandType+"</option>";
			}
			$("#brand1").html(options);
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			alert("加载品牌列表失败！");
		}
	});
	
	//动态加载所属手机颜色列表
	$.ajax({
		type:"GET",//请求类型
		url:path+"/goods/getColorList",//请求的url
		data:{},//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			$("#color1").html("");
			var options = "<option value=\"\">——请选择——</option>";
			for(var i = 0; i < data.length; i++){
				options += "<option value=\""+data[i].id+"\">"+data[i].colorType+"</option>";
			}
			$("#color1").html(options);
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			alert("加载品牌列表失败！");
		}
	});

	$("#price").bind("blur",function(){
        var price=$("#price").val();
        if(price<0){
            $(".message3").html("价格不能小于0！");
            validateTip($("#price"),false);
        }else{
            $(".message3").html("");
            validateTip($("#price"),true);
        }
    });
    $("#stock").bind("blur",function(){
        var price=$("#stock").val();
        if(price<0){
            $(".message4").html("库存不能小于0！");
            validateTip($("#stock"),false);
        }else{
            $(".message4").html("");
            validateTip($("#stock"),true);
        }
    });

    function validateTip(element,status){

        element.attr("validateStatus",status);
    }
	
	$("#addBtn").bind("click",function(){
        if($("#price").attr("validateStatus") != "true"){
            $("#price").blur();
        }else if($("#stock").attr("validateStatus") != "true"){
            $("#stock").blur();
        }else {
            if(confirm("是否确认提交数据")){
                $("#myForm").submit();
            }
		}
	});
	
	
	
	
	
	
	
});