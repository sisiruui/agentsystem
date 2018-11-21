<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>代理商管理系统</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
    <link rel="stylesheet" type="text/css" href="/css/default.css">
    <link rel="stylesheet" type="text/css" href="/css/public.css">
    <link id="theme" rel="stylesheet" type="text/css"
          href="/humane/themes/original.css">
    <script type="text/javascript" src="/js/jquery-1.12.4.min.js"></script>

    <script type="text/javascript" src="/humane/humane.js"></script>

    <script>

    </script>

</head>

<body>
<!-- 页头 -->
<div class="head">
    <h1>
        AgentSystem|代理商管理系统<span>v1.0</span>
    </h1>
</div>
<!--  -->
<div class="container" >

    <h1>系统登陆|Sign in</h1>



    <div id="app">

        <ul class="loginul" >
            <li>
                登陆账号：<input type="text" id="userCode"  value=""
                            v-model.trim="user.userCode"     name="user.userCode">
            </li>
            <li>登录密码：<input type="password" id="userPassword"
                            v-model.trim="user.password" value=""     name="user.userPassword">
            </li>
            <li><input type="button" value="提交" id="userSubmit"
                     v-on:click="loginsubmit"   name="user.submit">
            </li>


        </ul>
    </div>
</div>
</body>



<div>
    <jsp:include page="/include/foot.jsp"></jsp:include>
</div>
<script src="/publicjs/vue.js"></script>
<script src="/publicjs/vue-router.js"></script>
<script src="/publicjs/vue-resource.min.js"></script>
<script src="/publicjs/axios.min.js"></script>
<!-- 页尾 -->
<script type="text/javascript" src="/js/login.js"></script>
</html>
