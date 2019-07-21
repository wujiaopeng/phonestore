<%--
  Created by IntelliJ IDEA.
  User: vcc
  Date: 2019/5/3
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/common.css" />
</head>
<script src="${pageContext.request.contextPath}/statics/js/jquery/jquery.min.js" ></script>
<script type="text/javascript" >
    $(document).ready(function(){
        //点击弹出登陆框
        $("#login_box .close").click(function(){
            $("#login_box").hide();
        })

        $(".login_enter .login_btn").click(function(){
            $(".login_enter").hide();
            $("#login_box").show();
        })

        $(".byname").click(function(){
            $(".code_login").hide();
            $(".login_form").show();
        })

        $(".bycode").click(function(){
            $(".login_form").hide();
            $(".code_login").show();
        })


        //

        $(".close img").click(function(){
            $(".phone_sign").slideUp(500);
        })

        $(".phone_btn").click(function(){
            $(".phone_sign").show();
        })

        //鼠标移到用户图标
        $(".right_box .login").mouseover(function(){
            $(".login_enter").show();
            $(".login_out").show();
        })
        $(".login_enter").mouseleave(function(){
            $(".login_enter").hide();
        })

        $(".login_out").mouseleave(function(){
            $(".login_out").hide();
        })

        //点击手机品牌
        $(".phone_btn").click(function(){
            $(".phone_sign").show();

            $(".phone_logo ul").hide().fadeIn(1000);

        })
        //获得购物车商品数

            $.ajax({
                type:"post",
                url:"/getcountofspc",
                success:function (data) {
                    $(".ci-count").html(data.count);
                }
            })


        //ajax异步修改购物车状态
        $(".add").click(function(){
            if($("#customerName").val()!=null && $("#customerName").val()!=""){
                var gid= $(this).attr("gid");
                //判断是否在购物车里
                $.ajax({
                    type:"post",
                    url:"/checkspc",
                    data:{gid:gid},
                    dataType: "json",
                    success:function (data) {
                        if(data.result=="exit"){
                            var scId=data.scId;
                            var number=data.number;
                            $.ajax({
                                type:"post",
                                url:"/modifyCar",
                                data:{scId:scId,number:number+1},
                                dataType: "json",
                                success:function (data) {
                                    if(data.result=="success"){
                                        alert("已加入购物车！");
                                    }else{
                                        alert("加入购物车失败");
                                    }
                                }
                            });
                        }else{
                            $.ajax({
                                type: "post",
                                url: "/addCar",
                                data: {gid: gid},
                                dataType: "json",
                                success: function (data) {
                                    if(data.res=="true"){
                                        alert("加入购物车成功！");
                                        window.location.reload();
                                    }else{
                                        alert("加入购物车失败");
                                    }
                                }
                            });
                        }
                    }
                })
            }else{
                alert("请先登入！");
            }
        })

        //点击我的订单判断是否登录
        $(".myorder").click(function () {
            if($("#customerName").val()!=null && $("#customerName").val()!=""){
                window.location.href = "/myorder";
            }else{
                alert("请先登录！");
            }
        })

        //ajax登陆判断
        $("#login_btn").click(function () {
            var account = $("#account").val();
            var password = $("#password").val();
            if(account.length==0){
                $(".errormsg p").html("用户名不能为空");
            }else if(password.length==0){
                $(".errormsg p").html("密码不能为空");
            }else{
                $.ajax({
                    type:"post",
                    url:"/checklogin",
                    data:{account:account,password:password},
                    success:function (data) {
                        if(data.result=="success"){
                            window.location.reload();
                        }else{
                            if(data.error==1){
                                $(".errormsg p").html("用户名错误");
                            }
                            if(data.error==2){
                                $(".errormsg p").html("密码错误");
                            }
                        }
                    }
                })
            }

        })

        //获得拦截器传来的json数据
        $.ajax({
            type:"post",
            url:"",
            dataType:"json",
            success:function(data){
                alert(data.msg);
            }
        })
        if($("#customerName").val()!=null && $("#customerName").val()!=""){
            $(".customer_name").html($("#customerName").val());
        }
    })
</script>
<body>
<input type="hidden" id="customerName" value="${customer.name}">
<div id="header">
    <div id="logo">
        <a href="/"><img src="${pageContext.request.contextPath}/statics//images/logo/Nokia-Connecting-People-720.png"></a>
    </div>

    <div class="nav">
        <ul>
            <li class="phone_btn"><a href="#">手机品牌 </a><span class="line"></span></li>
            <li><a href="#">服务与支持 </a><span class="line"></span></li>
            <li class="myorder"><a href="javascript:;">我的订单</a></li>
        </ul>
    </div>

    <div class="right_box">
        <div class="customer_name">
        </div>
        <div class="login">
            <a>
                <img src="${pageContext.request.contextPath}/statics//images/logo/iconfinder_user.png">
            </a>
        </div>
        <span class="line"></span>
        <div class="shoppingcar">
            <a href="/toshoppingcar"><img src="${pageContext.request.contextPath}/statics/images/logo/iconfinder_shopping_cart.png">我的购物车<i class="ci-count" >0</i></a>
        </div>
    </div>
</div>

<div class="none"></div>

<c:if test="${customer.id==null}">
    <div class="login_enter">
        <div class="login_btn">
            <a href="#">登陆</a>
        </div>
        <div class="register_btn">
            <a href="/toregister">注册</a>
        </div>
    </div>
</c:if>
<c:if test="${customer.id!=null}">
    <div class="login_out">
        <a href="/logout" class="logout_btn">注销</a>
    </div>
</c:if>

<!--
    作者：lizisilove@sina.com
    时间：2019-04-18
    描述：点击选择品牌
-->
<div class="phone_sign">
    <div class="close">
        <img src="${pageContext.request.contextPath}/statics/images/logo/iconfinder_close.png">
    </div>

    <div class="phone_logo">
        <ul>
            <li><a href="/getbrandphone?brand=5"><img src="${pageContext.request.contextPath}/statics/images/logo/1024px-Apple_logo_black.svg.png"><span>iphone</span></a></li>
            <li><a href="/getbrandphone?brand=3"><img src="${pageContext.request.contextPath}/statics/images/logo/Huawei-logo-sun-880x660.png"><span>华为</span></a></li>
            <li><a href="/getbrandphone?brand=1"><img src="${pageContext.request.contextPath}/statics/images/logo/icon_mi.png"><span>小米</span></a></li>
            <li><a href="/getbrandphone?brand=4"><img src="${pageContext.request.contextPath}/statics/images/logo/Samsung-Logo.jpg"><span>三星</span></a></li>
            <li><a href="/getbrandphone?brand=6"><img src="${pageContext.request.contextPath}/statics/images/logo/meizu-new-logo.png"><span>魅族</span></a></li>
            <li><a href="/getbrandphone?brand=2"><img src="${pageContext.request.contextPath}/statics/images/logo/OPPO_Logo_wiki.png"><span>OPPO</span></a></li>

            <div class="more">
                <div class="right-line"></div>
                <div class="right_content">
                    <a href="#">更多品牌>></a>
                </div>
            </div>
        </ul>
    </div>
</div>

<div id="login_box" style="background-color: #e9e9e9;">
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
</body>
</html>
