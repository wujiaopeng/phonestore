<%--
  Created by IntelliJ IDEA.
  User: vcc
  Date: 2019/5/4
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jsp/front/common/header.jsp"%>
<html>
<head>
    <title>商品评价</title>
</head>
<style>
    .title{
        width:1210px;
        margin:40px auto 20px auto;
        text-align: center;
        font: 12px/22px verdana;
        color: #999;
    }

    .title span{
        color: #333;
    }

    .comment_ul{
        width:1210px;
        overflow: hidden;
        margin:0 auto;
    }
    .comment_li{
        width:1210px;
        height:320px;
    }

    #comment{
        width:1210px;
        height:320px;
        margin:0 auto;
        color: #666;
        background: #fff;

    }

    #comment .goodsinf{
        width:320px;
        height:320px;
        float:left;
        border-right: 1px solid #f5f5f5;
    }

    #comment .comment_box{
        width:889px;
        height:320px;
        float:left;
    }

    #comment .goodsinf img{
        width:150px;
        height:150px;
        margin:30px 85px 20px 85px;
    }

    #comment .goodsinf p{
        width:320px;
        height:30px;
        line-height: 30px;
        text-align: center;
    }

    .f_textarea{
        width:700px;
        height:100px;
        padding: 10px 10px 0;
        border: 1px solid #e0e0e0;
        margin:80px auto 0 auto;
        overflow: hidden;
    }

    .f_textarea textarea{
        width: 100%;
        height: 54px;
        line-height: 18px;
        border: medium none;
        color: #333;
        resize: vertical;
        resize: none;
        font-size: 12px;
        cursor: text;

        text-rendering: auto;
        color: initial;
        letter-spacing: normal;
        word-spacing: normal;
        text-transform: none;
        text-indent: 0px;
        text-shadow: none;
        display: inline-block;
        text-align: start;
    }

    .textarea-ext{
        height: 30px;
        line-height: 30px;
        text-align: right;
        color: #999;
    }

    #btn_box{
        width:1210px;
        height:108px;
        margin:30px auto 0 auto;
        color: #666;
        background: #fff;
    }
    #btn_box .btn_submit{
        width: 220px;
        height: 48px;
        line-height: 48px;
        padding: 0;
        font-family: "Microsoft YaHei";
        font-size: 18px;
        margin:30px 495px 0 495px;

        display: inline-block;
        text-align: center;
        cursor: pointer;
        color: #fff;
        border-radius: 3px;
        background-color: #df3033;
    }
</style>
<script type="text/javascript">
    $(document).ready(function () {
        $(".btn_submit").click(function () {
            $(".f_textarea").each(function () {
                var gid=parseInt($(this).attr("gid"));
                var content=$(this).children(".customer_comment").val();
                $.ajax({
                    type:"post",
                    url:"/commentsubmit",
                    data:{gid:gid,content:content},
                    success:function (data) {
                        if(data.result=="true"){
                            alert("谢谢你的评价，我们更好的服务您！");
                        }else{
                            alert("对不起评论失败！");
                        }
                    }
                })
            })
            window.location.href = "/index";
        })
    })
</script>
<body style="background-color: #f5f5f5;">
<h4 class="title">订单号：<span>${order.orderNo}</span>&nbsp;&nbsp;&nbsp;&nbsp;
    <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.createdate}"/>
</h4>
<ul  class="comment_ul">
    <c:forEach var="orderGoods" items="${orderGoodsList}">
        <li class="comment_li">
            <div id="comment">
                <div class="goodsinf">
                    <img src="${pageContext.request.contextPath}/${orderGoods.src}">
                    <p>${orderGoods.goodName}  ${orderGoods.colorName} ${orderGoods.specs}g</p>
                </div>

                <div class="comment_box">
                    <div class="f_textarea" gid="${orderGoods.goodsId}">
                        <textarea id="customer_comment" class="customer_comment" placeholder="写写你的感受吧 一不小心就成了评论高手"></textarea>
                        <div class="textarea-ext">还可输入500字</div>
                    </div>
                </div>
            </div>
        </li>
    </c:forEach>
</ul>

<div id="btn_box">
    <a href="#" class="btn_submit">发表</a>
</div>
</body>
</html>
