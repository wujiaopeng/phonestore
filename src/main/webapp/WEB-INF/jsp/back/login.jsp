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
    <style>
        input{
            margin-top: 15px;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4"
             style="margin-top:80px;padding-bottom: 15px;border-bottom: 1px solid;">
            <h4 class="text-center">手机商城后台管理平台</h4>
            <form id="myForm" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/back/dologin"
                style="margin-top: 24px;">
                    <div class="col-sm-12">
                        <input class="form-control" id="account" name="account" type="text" placeholder="账号" />
                    </div>

                    <div class="col-sm-12">
                        <input class="form-control" id="password" name="password" type="password" placeholder="密码" />
                    </div>
                    <p id="error" class="text-center" style="color:red;">${error}</p>
                    <div class="col-sm-6 col-sm-offset-3" style="margin-top:15px;margin-bottom: 10px;">
                        <button id="login" class="btn btn-theme" type="button">登录</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button class="btn btn-theme04" type="reset">重置</button>
                    </div>
            </form>
        </div>
        <div class="col-sm-12 text-center" style="margin-top:10px;font-font: '宋体';font-size: 8px;">
            <p>Copyright ©2019 手机商城管理后台 v1.1 All Rights Reserved.</p>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/statics/js/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/localjs/login.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
