<%--
  Created by IntelliJ IDEA.
  User: mayiwen
  Date: 2018/11/19
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        body {
            text-align:center
        }
        header {
            text-align: center;
            padding-top: 23px;
            margin-bottom: 50px;
        }
        section {
            margin:0 auto;
            text-align: center;
            width: 284px;
        }
        hr {
            background-color: #F0F0F0 ;
            border:none;
            height:1px;

        }

        .logininput {
            width: 284px;
            text-align: center;
        }
        h1 {
            font-family: "Microsoft YaHei";
            transform: scale(1.07,1);
            margin-bottom: -5px;

        }
        #app {
            margin-top: 90px;
        }

        .loginul {
            list-style: none;
            margin: 0px;
            padding: 0px;
        }
        .loginul li{
            font-size: 12px;
        }
        .loginul li:nth-of-type(1) input,.loginul li:nth-of-type(2) input{
            width: 140px;
        }
        .loginul li:nth-of-type(1),  .loginul li:nth-of-type(2){
            margin-bottom: 9px;

        }
        [type=button] {
            background-color: #368CE7;

            color: white;
        }
        input {
            border-radius: 5px;
        }
    </style>


</head>
<body>
<header >
    <img src="imgs/u2.png"/>
</header>
<section >
    <div class="logininput" >
        <h1>登录系统 | Sign in</h1>
        <hr/>
        <div id="app">
            <ul class="loginul" >
                <li>
                    登陆账号：<input type="text" id="userCode" v-model.trim="user.userCode"    >
                </li>
                <li>登录密码：<input type="password" id="userPassword"
                                v-model.trim="user.password" value=""     name="user.userPassword">
                </li>
                <li><input type="button" value="登录 | Login" id="userSubmit"
                           name="user.submit" v-on:click="loginsubmit">
                </li>
            </ul>
        </div>
    </div>


</section>



</body>
<script src="/publicjs/vue.js"></script>
<script src="/publicjs/vue-router.js"></script>
<script src="/publicjs/vue-resource.min.js"></script>
<script src="/publicjs/axios.min.js"></script>
<!-- 页尾 -->
<script type="text/javascript" src="/js/login.js"></script>
</html>