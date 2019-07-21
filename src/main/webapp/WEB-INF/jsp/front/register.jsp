<%--
  Created by IntelliJ IDEA.
  User: vcc
  Date: 2019/4/22
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery/jquery.min.js" ></script>
</head>
<style>
    *{
        padding:0px;
        margin:0px;
        color: #6f6f6f;
    }
    body{
        font-size: 16px;
        font-family: "akkuratPro-regular",Helvetica,Arial,sans-serif,"&#24494;&#36719;&#38597;&#40657;","&#23435;&#20307;","Verdana,Arial,Helvetica,sans-serif";
        margin: 0 auto;
        color: #000;
        background-color: #f2f2f2;
    }
    #header{
        background-color: #333;
        height: 67px;
        width:100%;
    }

    .register_box{
        margin: 0 auto;
        padding-top: 30px;
        margin-top:30px;
        width: 960px;
        height:850px;
        color: #333;
        background: #fff;
    }
    .register_form{
        width:600px;
        height:500px;
        padding: 30px 180px;
        margin-top:50px;
    }

    .input_container{
        background: #f7f7f7;
        height: 60px;
        border: 1px solid #d9d9d9;
        border-radius: 30px;
        margin-bottom: 20px;
        width:600px;
    }
    .input_left{
        text-align: center;
        width:90px;
        height: 100%;
        border-right: 1px solid #d9d9d9;
        padding: 0 16px;
        line-height: 60px;
        float:left;
    }
    .input_content{
        height: 100%;
        overflow: hidden;
        float: left;
    }

    .input_content input{
        width:450px;
        outline:none;
        border:0px;
        font-size:20px;
        height:60px;
        background: #f7f7f7;
        padding-left: 10px;
    }
    .input_content1 input{
        margin:20px;
        width: 20px;
    }
    .register_btn{
        width:200px;
        margin:0 auto;
    }

    .btn{
        width: 200px;
        height: 60px;
        border: 1px solid #ccc;
        border-radius: 30px;
        background: #fff;
        cursor: pointer;
    }
    .btn:hover{
        background-color: #be0000;
        color:#fff;
    }

    a{
        font-size: 24px;
        margin-right: 5px;
        display:block;
        float:right;
    }
    .errormsg{
        text-align: center;
        color:#e54346;
    }
</style>
<script>
    $(document).ready(function(){
        //判断用户名
        $("#account").bind("blur",function(){
            var account =$("#account").val();
            if(account==""){
                $(".errormsg").html("账号不能为空！").css("color","red");
            }else if(account.length>12){
                $(".errormsg").html("账号不能超过12位！").css("color","red");
            }else{
                $.ajax({
                    type:"post",
                    url:"/checkaccount",
                    data:{account:account},
                    dataType:"json",
                    success:function (data) {
                        if(data.result=="noexit"){
                            $(".errormsg").html("账号可用").css("color","green");
                        }else{
                            $(".errormsg").html("账号已存在！").css("color","red");
                        }
                    }
                })
            }
        });
        
        $("#registerbtn").click(function () {
            var account = $("#account").val();
            var password = $("#password").val();
            var name = $("#name").val();
            if(account==null || account==""){
                $(".errormsg").html("账号不能为空！").css("color","red");
            }else if(password==null || password==""){
                $(".errormsg").html("密码不能为空！").css("color","red");
            }else if(password.length<6){
                $(".errormsg").html("密码不能小于6位！").css("color","red");
            }else  if(name==null || name==""){
                $(".errormsg").html("姓名不能为空！").css("color","red");
            }else{
                $("#myForm").submit();
            }
        });

    })
</script>
<body>
<div id="header">

</div>

<div class="register_box">
    <div class="back">
        <a href="index.html">返回</a>
    </div>
    <h4 class="errormsg"></h4>
    <div class="register_form">
        <form  method="post" id="myForm" action="/register">
            <div class="input_container">
                <div class="input_left">
                    账号
                </div>
                <div class="input_content">
                    <input type="text" id="account" name="account">
                </div>
            </div>

            <div class="input_container">
                <div class="input_left">
                    密码
                </div>
                <div class="input_content">
                    <input type="password" id="password" name="password" placeholder="小于12位">
                </div>
            </div>

            <div class="input_container">
                <div class="input_left">
                    名字
                </div>
                <div class="input_content">
                    <input type="text" id="name" name="name">
                </div>
            </div>

            <div class="input_container">
                <div class="input_left">
                    性别
                </div>
                <div class="input_content1">
                    <p>
                        <input type="radio" name="sex" value="1" size="5">男

                        <input type="radio" name="sex" value="2">女
                    </p>
                </div>
            </div>

            <div class="input_container">
                <div class="input_left">
                    地址
                </div>
                <div class="input_content">
                    <input type="text" id="address" name="address">
                </div>
            </div>
            <div class="input_container">
                <div class="input_left">
                    出生日期
                </div>
                <div class="input_content">
                    <input type="date" id="birth" name="birth">
                </div>
            </div>
            <div class="input_container">
                <div class="input_left">
                    手机号码
                </div>
                <div class="input_content">
                    <input type="text" id="phone" name="phone">
                </div>
            </div>

            <div class="register_btn">
                <input type="button" id="registerbtn" class="btn" value="注册">
            </div>
        </form>
    </div>
</div>
</body>
</html>

