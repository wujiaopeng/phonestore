$(document).ready(function(){
	var imgIndex = $("#img ul li");
	var text =$(".text .content")
	var count = 0;
	var time;
	$(".circle span").eq(0).attr("class","active");
	//把图片的轮播定义为一个函数,轮播到某张图，获取该图索引，然后通过索引找到对应的span添加class="active"来改变圆圈颜色
	function scroll(){
		time=setInterval(function(){
			$(".circle span").eq(count+1).attr("class","active");
			imgIndex.eq(count).hide();
			text.eq(count).hide();
			$(".circle span").eq(count).attr("class",null);
			count++;
			//设置图片数，5为5张图
			if(count==3){
				imgIndex.show();
				text.show();
				count=0;
				$(".circle span").eq(count).attr("class","active");
			}
		},3000);//设置图片轮播速度，1000为1秒，类推
	}
	//鼠标悬浮，轮播停止
		$("#container").mouseover(function(){
		   clearInterval(time);
		   $("#next").stop().animate({right:"0px"},"fast");
		   $("#prev").stop().animate({left:"0px"},"fast");
	    });
	//鼠标离开，图片重新开始轮播
	    $("#container").mouseleave(function(){
	       scroll();
	       //如果替换自己的箭头图标的话 需要修改 对应的right 和 left
	       $("#next").stop().animate({right:"-44px"},"fast");
		   $("#prev").stop().animate({left:"-44px"},"fast");
	    });
	//通过圆圈控制图片
	    $(".circle span").mouseover(function(){
	    	clearInterval(time);
	    	if($(this).index()!=count){
	    		$(".circle span").eq(count).attr("class",null);
	    	}
	    	if($(this).index()>count){
	    		for(var i=count;i<$(this).index();i++){
	    			imgIndex.eq(i).hide();
	    			text.eq(i).hide();
	    			count=$(this).index();
	    			$(".circle span").eq(count).attr("class","active");
	    		}
	    	}else{
	    		for(var i=count;i>$(this).index();i--){
	    			imgIndex.eq(i-1).show();
	    			text.eq(i-1).show();
	    			count=$(this).index();
	    			$(".circle span").eq(count).attr("class","active");
	    		}
	    	}
	    });
	   //箭头控制图片
	   //点击下一张
	   $("#next").click(function(){
	   	imgIndex.eq(count).hide();
	   	text.eq(count).hide();
	   	$(".circle span").eq(count).attr("class",null);
	   	count++;
	   	$(".circle span").eq(count).attr("class","active");
	   	//根据图片数 改if条件里count的对应值
	   	if(count==3){
				imgIndex.show();
				text.show();
				count=0;
				$(".circle span").eq(count).attr("class","active");
			}
	   });
	   
	   //点击前一张
	   $("#prev").click(function(){
	   	$(".circle span").eq(count).attr("class",null);
	   	if(count==0){
	   		for(var i=0;i<2;i++){ //5张图的话i<4，类推n张图的话，i<n即可
	   			imgIndex.eq(count).hide();
	   			text.eq(count).hide();
	   			$(".circle span").eq(count).attr("class",null);
	   			count++;
	   			$(".circle span").eq(count).attr("class","active");
	   		}
	   	}else{
	   		count--;
	   	}
	   	$(".circle span").eq(count).attr("class","active");
	   	imgIndex.eq(count).show();
	   	text.eq(count).show();
	   });
	   
	   
	//执行scroll函数达到轮播效果
	window.onload=scroll();



});