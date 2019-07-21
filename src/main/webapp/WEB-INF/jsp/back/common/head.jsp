<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">

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
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/zabuto_calendar.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/gritter/css/jquery.gritter.css" />
  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/statics/css/style.css" rel="stylesheet">
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/public.css" />
  <link href="${pageContext.request.contextPath}/statics/css/style-responsive.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/statics/js/chart-master/Chart.js"></script>
</head>

<body>
  <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
  <section id="container">
    <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
    <!--header start-->
    <header class="header black-bg">
      <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right" data-original-title="隐藏导航栏"></div>
      </div>
      <!--logo start-->
      <a href="index.html" class="logo"><b>Phone<span>Market</span></b></a>
      <!--logo end-->
      
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
          <li><a class="logout" href="${pageContext.request.contextPath}/back/logout">Logout</a></li>
        </ul>
      </div>
    </header>
    <!--header end-->
    
    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          <p class="centered"><a href="#"><img src="${pageContext.request.contextPath}/statics/img/ui-sam.jpg" class="img-circle" width="80"></a></p>
          <h5 class="centered">${masterSession.name}</h5>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-cogs"></i>
              <span>系统管理</span>
              </a>
            <ul class="sub">
              <li><a href="${pageContext.request.contextPath}/system/customerlist">客户管理</a></li>
              <li><a href="${pageContext.request.contextPath}/system/masterlist">用户管理</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-desktop"></i>
              <span>商品管理</span>
            </a>
            <ul class="sub">
              <li><a href="${pageContext.request.contextPath}/goods/goodslist">商品列表</a></li>
              <li><a href="${pageContext.request.contextPath}/goods/addGoods">添加商品</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-book"></i>
              <span>订单管理</span>
              </a>
            <ul class="sub">
              <li><a href="${pageContext.request.contextPath}/order/shoppingcarlist">购物车管理</a></li>
              <li><a href="${pageContext.request.contextPath}/order/orderlist">订单管理</a></li>
            </ul>
          </li>
        </ul>
        <!-- sidebar menu end-->
        <div class="footer1" style="position: absolute; bottom: 0px;left:0px; font-size:8px;color:#aeb2b7;">
      		<span>&nbsp;&nbsp;&nbsp;&nbsp;&copy;&nbsp;Copyrights 314宿舍所有成员</span>
      	 </div>
      </div>
      
    </aside>
    <!--sidebar end-->
    <!--main content start-->
    <section id="main-content">
      <section class="wrapper Hui-admin-content">
      	<div class="row-fluid pull-right publicTime" style="margin-top: 8px;background-color: #797979; ">
      		<span id="time">2019年1月1日 11:11  星期一</span>
      	</div>
      	<div class="clearfix"></div>
      	