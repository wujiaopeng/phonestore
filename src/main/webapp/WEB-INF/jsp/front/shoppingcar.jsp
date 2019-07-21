<%--
  Created by IntelliJ IDEA.
  User: vcc
  Date: 2019/4/26
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jsp/front/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的购物车</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/shoppingcar.css"/>
</head>
<script type="text/javascript" >
    $(document).ready(function(){

        //实现全选反选
        $("#chooseAll").on('click', function() {
            $("li input:checkbox").prop("checked", $(this).prop('checked'));
        })


        $("li input:checkbox").on('click', function() {
            //当选中的长度等于checkbox的长度的时候,就让控制全选反选的checkbox设置为选中,否则就为未选中
            if($("li input:checkbox").length === $("li input:checked").length) {
                $("#chooseAll").prop("checked", true);
            } else {
                $("#chooseAll").prop("checked", false);
            }
        })

        //加减数目
        $(".addBtn").click(function () {
            var scId=$(this).closest(".phone_li").attr("scId");
            var a=$(this).val();
            var num=parseInt($(this).closest("div").find(".join-money").val());
            if(a=="-"){
                if(num<=1){
                    alert("数量不能小于0");
                }else{
                    num=num-1;
                    $.ajax({
                        type:"post",
                        url:"/modifyCar",
                        data:{scId:scId,number:num},
                        dataType:"json",
                        success:function (data) {
                            if(data.result == "success"){
                                window.location.reload();
                            }else{
                                alert("失败！");
                            }
                        },error:function(data){
                            alert("500错误")
                        }
                    });
                }
            }
            if(a=="+"){
                var stock=$(this).closest(".phone_li").find(".stock").val();
                if(num>=stock){
                    alert("购买数量大于库存！");
                }else{
                    num=num+1;
                    $.ajax({
                        type:"post",
                        url:"/modifyCar",
                        data:{scId:scId,number:num},
                        dataType:"json",
                        success:function (data) {
                            if(data.result == "success"){
                                window.location.reload();
                            }else{
                                alert("失败！");
                            }
                        },error:function(data){
                            alert("500错误")
                        }
                    });
                }
            }
        });


        //改变颜色和总价
        setInterval(function(){
            var count=0;
            $("li input:checkbox").each(function(){
                if($(this).prop("checked")){
                    count+=parseFloat($(this).parent().siblings(".p_sum").children().children().text());
                    $(this).parent().parent().css("background","#fff4e8");
                }else{
                    $(this).parent().parent().css("background","#FFFFFF");
                }
            })
            $(".total p span").html(count);
        })
        
        //点击结算
        $(".topay").click(function () {
            //先创建订单信息
            var total = parseFloat($(".total p span").text());
            $.ajax({
                type: "post",
                url: "/addOrder",
                data: {total: total},
                dataType: "json",
                success: function (data) {
                    if (data.result == "success") {
                        var oid = data.oid;
                        $("li input:checkbox").each(function () {
                            if ($(this).prop("checked")) {
                                var gid = parseInt($(this).parent().parent().attr("gid"));
                                var number = parseInt($(this).parent().parent().attr("number"));
                                $.ajax({
                                    type: "post",
                                    url: "/addOrderGoods",
                                    data: {gid: gid, oid: oid, number: number},
                                    dataType: "json",
                                    success: function (data) {
                                        if (data.res == "true") {
                                            window.location.href = "toplay?oid=" + oid;
                                        } else {
                                            alert("添加商品错误");
                                        }
                                    }
                                });
                                var scId=parseInt($(this).parent().parent().attr("id"));
                                $.ajax({
                                    type: "post",
                                    url: "/deleteCar",
                                    data:{scId:scId},
                                    dataType: "json",
                                    success:function (data) {
                                        if(data.result=="success"){
                                        }else{
                                        }
                                    }
                                });
                            }
                        });
                    } else {
                        alert("失败！");
                    }
                }
            });
        });
        //从购物车里删除
        $(".delete").each(function(){
            var count=parseInt($(".ci-count").text())-1;
            $(this).click(function(){
                var scId=$(this).closest(".phone_li").attr("scId");
                if(confirm("你确定要移除购物车吗？")) {
                    $.ajax({
                        type:"post",
                        url:"/deleteCar",
                        data:{scId:scId},
                        dataType:"json",
                        success:function (data) {
                            if(data.result=="success"){
                                window.location.reload();
                            }else{
                                alert("失败");
                            }
                        },
                        error:function (data) {
                            alert("500错误");
                        }
                    })
                }

            })
        })


    })
</script>
<body>


<div id="shopping_list">
    <div class="title">
        <div class="check">
            <input type="checkbox" id="chooseAll" checked="checked" style="width:15px;height:15px">全选
        </div>
        <div class="goods">商品</div>
        <div class="price">单价</div>
        <div class="num">数量</div>
        <div class="sum">总价</div>
        <div class="action">操作</div>
    </div>

    <div class="list">
        <ul>
            <c:forEach var = "shoppingcar" items="${shoppingCarList}">
                <li class="phone_li" id="phone_li${shoppingcar.id}" scId="${shoppingcar.id}" style="margin-top: 30px;">
                    <input type="hidden" class="stock" value="${shoppingcar.stock}">
                    <div class="li_white"></div>
                    <div class="phone_inf" id="${shoppingcar.id}" number="${shoppingcar.number}" gid="${shoppingcar.goodId}">
                        <div class="checkbox">
                            <input type="checkbox" checked="checked">
                        </div>
                        <div class="p_img">
                            <img width="155px" height="155px" src="${pageContext.request.contextPath}/${shoppingcar.src}">
                        </div>
                        <div class="p_inf">
                            <h3>${shoppingcar.goodName}</h3>
                            <br>
                            <p>${shoppingcar.colorName}</p>
                            <p>${shoppingcar.specs}GB</p>
                        </div>
                        <div class="p_price">
                            <h4>￥<span>${shoppingcar.price}</span></h4>
                        </div>
                        <div class="p_num" >
                            <div style="margin-top: 55px;" id="p_num${shoppingcar.id}">
                                <input class="addBtn" type="button" value="-">
                                <input class="join-money" type="text" readonly="readonly" value="${shoppingcar.number}" />
                                <input class="addBtn" type="button" value="+">
                            </div>
                        </div>
                        <div class="p_sum">
                            <h4>￥<span>${shoppingcar.number*shoppingcar.price}</span></h4>
                        </div>
                        <div class="delete">
                            <a href="#">删除</a>
                        </div>
                    </div>
                </li>
            </c:forEach>

        </ul>
    </div>


    <div id="pay">
        <div class="topay">
            <a href="#">结算</a>
        </div>
        <div class="total">
            <p>总价：￥<span></span></p>
        </div>
    </div>
</div>
</body>
</html>

