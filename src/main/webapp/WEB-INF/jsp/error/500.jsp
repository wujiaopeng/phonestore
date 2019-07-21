<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/27
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <title>手机商城管理</title>
    <!-- Favicons -->
    <link href="${pageContext.request.contextPath}/statics/img/phone.png" rel="icon">
    <link href="${pageContext.request.contextPath}/statics/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/statics/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--external css-->
    <link href="${pageContext.request.contextPath}/statics/js/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/statics/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/statics/css/style-responsive.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3 p404 centered">
            <img src="${pageContext.request.contextPath}/statics/img/500.png" alt="">
            <h1>ERROR 500</h1>
            <h3>Ouch!! Something Went Wrong!</h3>
            <br>
            <h5 class="mt">Hey, maybe you will be interested in these pages:</h5>
            <p><a href="${pageContext.request.contextPath}/">Index</a> |
                <a href="${pageContext.request.contextPath}/login">Login</a></p>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/statics/js/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
