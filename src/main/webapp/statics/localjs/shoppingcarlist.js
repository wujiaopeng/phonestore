var path = $("#path").val();
$(function(){
	//动态加载手机品牌列表
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
	
	$(".shoppingcar").click(function(){
		var obj = $(this);
		window.location.href="shoppingcar?sid="+obj.attr("sid");
	});
	
	
})