var path = $("#path").val();
$(function(){
	var map={};
	map[1]="已付款";
	map[2]="未付款";
	var querystate = $("#querystate").val();
	$("#sta1").html("");
	var options = "<option value=\"\">——请选择——</option>";
	for(var prop in map){
	    if(map.hasOwnProperty(prop)){
	    	if(querystate != null && querystate != undefined && prop==querystate ){
				options += "<option selected=\"selected\" value=\""+prop+"\" >"+map[prop]+"</option>";
			}else{
				options += "<option value=\""+prop+"\">"+map[prop]+"</option>";
			}
	    }
	}
	$("#sta1").html(options);
	
	$(".orders").click(function(){
		var obj = $(this);
		window.location.href="getOrder?oid="+obj.attr("oid");
	});
		
});