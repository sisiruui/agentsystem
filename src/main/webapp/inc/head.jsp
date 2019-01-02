<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE >
<html lang="en" xmlns:v-bind="http://www.w3.org/1999/xhtml" xmlns:v-on="http://www.w3.org/1999/xhtml">

<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>欢迎登陆-欢迎页</title>


    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="/css/public.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <!-- 使用human提醒库 -->
    <link id="theme" rel="stylesheet" type="text/css"
          href="/humane/themes/original.css">
    <link rel="stylesheet" id='skin' type="text/css" href="/alertframe/skin/simple_gray/ymPrompt.css"/>

    <script type="text/javascript" src="/humane/humane.js"></script>

    <script type="text/javascript" src="/alertframe/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery-1.12.4.min.js"></script>

    <script src="/publicjs/vue.js"></script>
    <script src="/publicjs/vue-router.js"></script>
    <script src="/publicjs/vue-resource.min.js"></script>
    <script src="/publicjs/axios.min.js"></script>

    <style>
        .showvue {
            display: block;
        }
    </style>
    <script>

    </script>
    <script type="text/javascript">
        var user_id = ${sessionScope.user.id}
    </script>

</head>

<body>
<div id="mainapp">
    <div class="head">
        <ul>
            <li></li>
            <li class="headfunc">
                <ul>

                    <li>欢迎您：${sessionScope.user.userName}
                        <a id="modifypwconcledbtn" class="modifypwd" @click="methodOpenUpdate()">修改密码</a>
                        <a @click="methodInvalidate()">退出</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <!-- 修改密码隐藏的div -->
    <div id="modifydiv" class="modifydiv"  :class="{ showvue: condition.updatediv }">

        <div class="modifTop">修改密码</div>
        <div class="modifyPasswordContent">

            <ul>
                <input type="hidden" value="${sessionScope.user.id}"  v-model.trim="loginUser.id" >
                <li>请输入原密码：<input type="password" id="oldpwdtext" v-model.trim="loginUser.oldPassword">
                    <span id="oldpwdtexttip">{{ message.message1 }}</span>
                </li>
                <li>请输入新密码：<input type="password" id="newpwd" v-model.trim="loginUser.newPassword">
                    <span id="newpwdtip">{{ message.message2 }}</span>
                </li>
                <li>再输入新密码：<input type="password" id="newpwd2" v-model.trim="loginUser.confirmPassword">
                    <span id="newpwd2tip">{{ message.message3 }}</span>
                </li>
                <li>
                    <input type="button" id="modifypwdbtn" value="确认修改密码"  @click="methodUpdateUserPassword()">
                    <input id="modifypwdcancel" type="button" @click="methodCloseUpdate()" value="取消">
                </li>
            </ul>
        </div>
    </div>
</div>
<!-- 主菜单 -->
<div class="menu" id="menu">


    <ul>
        <li class="m_line"><img src="/imgs/line1.gif"/></li>
        <li id="m_1" class='m_li_a' onmouseover='mover(1);'><a href="javascript:void()">代理商管理</a></li>
        <li class="m_line"><img src="/imgs/line1.gif"/></li>
        <li id="m_2" class='m_li' onmouseover='mover(2);'><a href="javascript:void()">门户管理</a></li>
        <li class="m_line"><img src="/imgs/line1.gif"/></li>
        <li id="m_3" class='m_li' onmouseover='mover(3);'><a href="javascript:void();">报表管理</a></li>
        <li class="m_line"><img src="/imgs/line1.gif"/></li>
        <li id="m_4" class='m_li' onmouseover='mover(4);'><a href="javascript:void();">系统管理</a></li>
        <li class="m_line"><img src="/imgs/line1.gif"/></li>
        <li id="m_5" class='m_li' onmouseover='mover(5);'><a href="javascript:void();">系统配置管理</a></li>
        <li class="m_line"><img src="/imgs/line1.gif"/></li>


        <!-- 	<li class="m_line"><img src="/imgs/line1.gif"/>     </li>
            <li id="m_1" class="m_li_a"><a>代理商管理</a></li>
            <li id="m_2" class="m_li"><a>门户管理</a></li>
            <li id="m_3" class="m_li"><a>报表管理</a></li>
            <li id="m_4" class="m_li"><a>系统管理</a></li>
            <li id="m_5" class="m_li"><a>系统配置管理</a></li> -->
    </ul>


</div>
<!-- 子菜单 -->
<div class="subbox">
    <ul class="smenu">
        <li style="padding-left:10px;" id="s_1" class='s_li_a'>
            <a href="/keywords/page" title="关键词申请">关键词申请</a>
            <a href="/customs" title="代理商客户管理">代理商客户管理</a>
            <a href="/accountdetail/page" title="代理商预付款">代理商预付款</a>
            <a href="/keywords/manage.do?page=1" title="关键词申请管理">关键词申请管理</a>
            <a href="/logs/logslist.do?page=1" title="操作日志">操作日志</a>
        </li>
        <li style="padding-left:131px;" id="s_2" class='s_li' onmouseover='mover(2);'>
            <a href="/portal/list.do?page=1" title="门户管理">门户管理</a>
        </li>
        <li style="padding-left:243px;" id="s_3" class='s_li' onmouseover='mover(3);'>
            <a href="/report/index.do" title="业务报表">业务报表</a>
        </li>

        <li style="padding-left:140px;" id="s_4" class='s_li' onmouseover='mover(4);'>
            <a href="/AccountDetail/add.do" title="财务管理">财务管理</a>
            <a href="/role" title="角色管理">角色管理</a>
            <a href="/role/firstlist.do" title="角色权限配置">角色权限配置</a>
            <a href="/user" title="代理商用户管理">代理商用户管理</a>
            <a href="/keywords/checkkeyword.do?page=1" title="关键词审核">关键词审核</a>
        </li>

        <li id="s_5" class="s_li">
            <a href="/systemconfig/financial">财务管理</a>
            <a href="/systemconfig/typeofservice">服务类型</a>
            <a href="/systemconfig/seniority">服务年限</a>
            <a href="/systemconfig/appaddress">app地址</a>
            <a href="/systemconfig/clienttype">客户类型</a>
            <a href="/systemconfig/idtype">证件类型</a>
            <a href="/systemconfig/preperential">优惠类型</a>
        </li>
    </ul>
</div>

<script type="text/javascript" src="/js/main.js"></script>
<script type="text/javascript" src="/js/public.js"></script>