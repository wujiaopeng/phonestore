<%--
  Created by IntelliJ IDEA.
  User: vcc
  Date: 2019/4/22
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jsp/front/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>WWP手机商城</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/style_front.css" />
</head>
<script src="${pageContext.request.contextPath}/statics/js/slide.js"></script>
<script type="text/javascript">

</script>
<body>



<!--
    作者：lizisilove@sina.com
    时间：2019-04-20
    描述：轮播
-->
<div id="container">
    <div id="img">
        <ul class="slide">
            <li>
                <a href="#"><img src="${pageContext.request.contextPath}/statics/images/pic_001.jpg"></a>
            </li>
            <li>
                <a href="#"><img src="${pageContext.request.contextPath}/statics/images/pic_002.jpg"></a>
            </li>
            <li>
                <a href="#"><img src="${pageContext.request.contextPath}/statics/images/pic_003.jpg"></a>
            </li>


            <div id="next">
                <img src="${pageContext.request.contextPath}/statics/images/arrow_next.png">
            </div>
            <div id="prev">
                <img src="${pageContext.request.contextPath}/statics/images/arrow_prev.png">
            </div>
            <div class="circle">
                <span></span>
                <span></span>
                <span></span>
            </div>
        </ul>
    </div>

    <div class="phone_user">
        <div class="huawei_user">
            <div class="left_logo">
                <img src="${pageContext.request.contextPath}/statics/images/cuddly-knight.jpg">
            </div>
            <div class="right_text">
                <h3><a href="#">花用户</a></h3>
                <br />
                <p>尊贵的骑士，享受精致生活，有爱国情操，是为人</p>
            </div>
        </div>
        <div class="mi_user">
            <div class="left_logo">
                <img src="${pageContext.request.contextPath}/statics/images/monkey-cartoon-face-hi.png">
            </div>
            <div class="right_text">
                <h3><a href="#">米用户</a></h3>
                <br />
                <p>卑微的猴子，服从猴王安排，常被猴王戏耍，是为畜</p>
            </div>
        </div>
        <div class="iphone_user">
            <div class="left_logo">
                <img src="${pageContext.request.contextPath}/statics/images/Rotten_apple_patch_site_1024x1024.jpg">
            </div>
            <div class="right_text">
                <h3><a href="#">果用户</a></h3>
                <br />
                <p>牛逼的蛆虫，无处不在，无所不咬，是为神</p>
            </div>
        </div>
    </div>
</div>
<div id="recommend">
    <a href="#"><img src="${pageContext.request.contextPath}/statics/images/pic_004.jpg"></a>
</div>

<div id="sell">
    <ul class="sell_ul">
        <c:forEach var="goods" items="${goodsList}">
            <li class="sell_li">
                <div class="sell_phone">
                    <a href="/tophonemsg?gId=${goods.id}">
                        <img src="${pageContext.request.contextPath}/${goods.src}">
                    </a>
                    <p class="color">
                        ${goods.colorName}
                    </p>
                    <p class="phone_name">
                        ${goods.goodName}
                    </p>
                    <ul class="parameter">
                        <li class="price">￥${goods.price}</li>
                        <li>${goods.specs}</li>
                        <li>${goods.cpu}</li>
                    </ul>
                    <button class="add" id="add" gid="${goods.id}">加入购物车</button>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>

<div id="login_box">
    <div class="close">
        <span>×</span>
    </div>
    <div class="con">
        <span class="byname">账号登陆</span>
        <span class="bycode">扫码登陆</span>
        <div class="login_form">
            <form>
                <input type="text" id="account" placeholder="账号"/>
                <input type="password"  id="password" placeholder="密码">
                <input type="button" id="login_btn" value="登陆">
            </form>

            <div class="errormsg">
                <p></p>
            </div>
        </div>

        <div class="code_login">
            <img src="${pageContext.request.contextPath}/statics/images/code.png">
            <p>打开微信扫码登陆</p>
        </div>
    </div>
</div>

<div id="footer">
    <p>尾部无所谓啦，随便写了</p>
</div>
</body>
</html>

