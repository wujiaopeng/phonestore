<%--
  Created by IntelliJ IDEA.
  User: vcc
  Date: 2019/4/29
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jsp/front/common/header.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>付款界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/pay.css" />
</head>
<script type="text/javascript" >
    $(document).ready(function(){

        $(".pay").click(function(){
            var obj=$(this);
            $.ajax({
                type: "post",
                url: "/playmoney",
                data: {oid:obj.attr("oid") },
                dataType: "json",
                success: function (data) {
                    if (data.result == "true") {
                       alert("付款成功！");
                    } else {
                        alert("对不起，付款失败");
                    }
                }, error: function (data) {
                    alert("500错误1");
                }
            });
        });
    })
</script>
<body>



<div id="paybox">
    <div class="title">
        <h3>订单编号：${order.orderNo}</h3>
    </div>
    <div class="orderbox">
        <div class="customerInf">
            <div class="title">
                <h4>收货人信息</h4>
            </div>
            <div class="inf">
                <p>联系人：${order.customerName}
                    &nbsp;&nbsp;&nbsp;&nbsp; 收货地址：${order.address}
                    &nbsp;&nbsp;&nbsp;&nbsp; 联系电话：${order.phone}</p>
            </div>
        </div>

        <div class="goodlist">
            <div class="title">
                <h4>购买商品</h4>
            </div>
            <div class="list">
                <ul>
                    <c:forEach var="orderGoods" items="${orderGoodsList}">
                        <li>
                            <div class="good_img">
                                <img src="${pageContext.request.contextPath}/${orderGoods.src}">
                            </div>
                            <div class="good_inf">
                                <div class="left">
                                    <p>${orderGoods.goodName}</p>
                                    <p>${orderGoods.colorName}</p>
                                    <p>${orderGoods.specs}G</p>
                                </div>
                                <div class="right">
                                    <span>${orderGoods.number}台</span>
                                </div>
                                <div class="right">
                                    <span>￥${orderGoods.price}</span>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="payway">
            <div class="title">
                <h4 style="float: left;">选择付款</h4>
                <h5 style="float: right;color:red;margin-right: 20px;">共：￥${order.total}</h5>
            </div>
            <div class="paychoose" style="clear: both;">
                <div class="nopay">
                    <a href="#">暂不付款</a>
                </div>
                <div class="pay" oid="${order.id}">
                    <a href="javascript:;">付款</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

