<%--
  Created by IntelliJ IDEA.
  User: vcc
  Date: 2019/4/30
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/jsp/front/common/header.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/myorder.css" />
</head>
<script type="text/javascript" >
    $(document).ready(function(){
        $(".o_inf").each(function(){
            var height = parseInt($(this).height())-30;
            $(this).siblings().css("height",height);
        })
    })
</script>
<body style="background-color: #f5f5f5">

<div id="myorder">
    <div class="title">
        <h5>我的订单</h5>
    </div>

    <div class="orderbox">
        <div class="nav">
            <a href="/myorder">全部订单</a>
            <a href="/myorder?state=2">未付款</a>
        </div>
        <div class="order_head">
            <div class="inf">
                订单详情
            </div>
            <div class="customer">
                单价
            </div>
            <div class="price">
                数量
            </div>
            <div class="status">
                状态
            </div>
            <div class="action">
                操作
            </div>
        </div>
        <div class="orderlist">
            <ul>
                <c:forEach var="order" items="${orderList}">
                    <li class="o_li">
                        <div class="top">
                            <span> <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.createdate}"/></span>
                            <span>订单号： ${order.orderNo}</span>
                            <span style="float: right;color:red;">总额：￥${order.total}</span>
                        </div>
                        <div class="bottom">
                                <c:forEach var="orderGoods" items="${order.orderGoodsList}">
                                    <div style="margin-top: 10px;margin-bottom: 10px;">
                                        <div class="o_inf">
                                            <div class="g_inf">
                                                <div class="g_img">
                                                    <img src="${pageContext.request.contextPath}/${orderGoods.src}">
                                                </div>
                                                <div class="g_text">
                                                    <p>${orderGoods.goodName}</p>
                                                    <p>${orderGoods.specs}g ${orderGoods.colorName}</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="o_customer">
                                                ${orderGoods.price}
                                        </div>
                                        <div class="o_price">
                                                ${orderGoods.number}
                                        </div>
                                    </div>
                                </c:forEach>
                            <div class="o_status">
                                    ${order.orderStateName}
                            </div>
                            <div class="o_action">
                                <c:if test="${order.orderState == 1}">
                                    <a href="/tocomment?oid=${order.id}"/>评价</a>
                                </c:if>
                                <c:if test="${order.orderState == 2}">
                                    <a href="/toplay?oid=${order.id}">去付款</a>
                                </c:if>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>


</body>
</html>

