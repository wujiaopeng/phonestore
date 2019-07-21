<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: vcc
  Date: 2019/5/4
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/front/common/header.jsp"%>
<html>
<head>
    <title>手机详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/phonemsg.css" />
</head>
<script type="text/javascript">
    $(document).ready(function () {

        $(".addBtn").click(function () {
            var a=$(this).val();
            var price=parseFloat($("#price").val());
            var num=parseInt($(".join-money").val());
            if(a=="-"){
                if(num<=1){
                    alert("购买量不能小于0");
                }else{
                    num=num-1;
                    $(".join-money").val(num);
                    $(".phone_total").find("span").html(price*num);
                }
            }
            if(a=="+"){
                var stock=parseInt($("#stock").val());
                if(num>=stock){
                    alert("购买量大于库存");
                }else{
                    num=num+1;
                    $(".join-money").val(num);
                    $(".phone_total").find("span").html(price*num);
                }
            }
        });
        加入购物车

        //点击结算
        $("#buy_btn").click(function () {
            //先创建订单信息
            var total = parseFloat($(".phone_total  span").text());
            if($("#customerName").val()==null || $("#customerName").val()==""){
                alert("请先登入！");
            }else{
                $.ajax({
                    type: "post",
                    url: "/addOrder",
                    data: {total: total},
                    dataType: "json",
                    success: function (data) {
                        if (data.result == "success") {
                            var oid = data.oid;
                            var gid = parseInt($("#gid").val());
                            var number = parseInt($(".join-money").val());
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
                        } else {
                            alert("失败！");
                        }
                    }
                });
            }
        });
    })
</script>
<body>
<div id="phonemsg">
    <input type="hidden" id="gid" value="${goods.id}"/>
    <div class="phone_img">
        <img src="${pageContext.request.contextPath}/${goods.src}">
    </div>
    <div class="phone_text">
        <h4>${goods.goodName} 全面屏手机  全网通移动联通电信4G手机 双卡双待</h4>
        <input type="hidden" id="price" value="${goods.price}">
        <input type="hidden" id="stock" value="${goods.stock}">
        <div class="phone_price">
            WWP商城价：<span>￥${goods.price}</span>
        </div>
        <div class="address">
            配送至：<span>${customer.address}</span>
        </div>
        <div class="phone_color">
            颜色：<span>${goods.colorName}</span>
        </div>
        <div class="phone_version">
            版本：<span>${goods.specs}g</span>
        </div>
        <div class="phone_taozhuang">
            套装：<span>官方标配</span>
        </div>
        <div class="phone_num">
            数量：
            <span>
                <input class="addBtn" type="button" value="-">
                <input class="join-money" type="text" value="1" readonly="readonly" />
                <input class="addBtn" type="button" value="+">
            </span>
        </div>
        <div class="phone_total">
            总价：￥<span>${goods.price}</span>
        </div>

        <div class="buybox">
            <button class="add" id="add_btn" gid="${goods.id}">加入购物车</button>
            <a href="javascript:;" id="buy_btn">一键购</a>
        </div>
    </div>
</div>


<div id="comment">
    <div class="title">
        商品评价
    </div>
    <div class="customer_comment">
        <ul class="comment_ul">
            <c:forEach var="comment" items="${commentList}">
                <li class="comment_li">
                    <div class="customer_name">
                        ${comment.cName}
                    </div>
                    <div class="content">
                        <p>
                            ${comment.content}。
                        </p>
                    </div>
                    <div class="create_time">
                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${comment.createtime}"/>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>
