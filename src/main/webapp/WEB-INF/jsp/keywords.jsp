<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/inc/head.jsp" %>
<div class="mbxnav">
    <a href="/main.action">代理商管理</a> \ <a href="/keyword.action">关键词申请</a>
</div>
<div class="container" id="app">
    <div class="searchuserdiv">
        <div>搜索客户：<input id="searchUerText" type="text" v-model.trim="search.customsName" /> 输入后自动搜索
            <font color="red" size="2"> 【当前账户余额：￥ <span id="accountspan">{{ account.money }}</span>】</font>
            <div id="serachresult" class="searchresult" :class="{ showvue: searchDiv }" >
                <ul>
                    <li v-for="(cus, index) in customsList" @click="methodSelectCustoms(cus.id, index)" >
                        <span>客户类型：{{ cus.customTypeName }}</span><br/>
                        <a>{{ cus.customName }}</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="formdiv">
        <ul>
            <li><a>客户名称：</a>
                <input id="customname" class="customname" type="text" v-model.trim="keywords.customName" readonly="readonly"/></li>
            <li><a>关键词：</a><input id="keyword" class="keyword" type="text" v-model.trim="keywords.keywords"/> <span id="keywordtip"
                                                                                   class="keywordtip"></span></li>
            <li><a>服务类别：</a>
                <select id=" " v-model.trim="keywords.productType">
                    <option value="0" selected="selected"  >--请选择--</option>
                    <option v-for="(sysCfg, index) in typeOfServiceSystemConfig" :value="sysCfg.configTypeValue">{{sysCfg.configTypeName}}</option>
                </select>
            </li>
            <li><a>服务年限：</a>
                <select id="serviceyears" v-model.trim="keywords.serviceYears">
                    <option value="0" selected="selected">--请选择--</option>
                    <option v-for="sc in 3" :value="sc">{{ sc }}</option>
                    <option v-for="(sysCfg, index) in preperentialSystemConfig" :value="sysCfg.configTypeValue">{{sysCfg.configTypeName}}</option>
                </select>
            </li>
            <li><a>价格：</a><input class="price" id="price" v-model="keywords.price" type="number" readonly="readonly"/></li>
            <li><input id="" type="button" @click="methodSaveKeywords()" value="提交申请"/></li>
        </ul>
    </div>
</div>
<link id='theme' rel='stylesheet' href='/css/keyword.css'/>
<script type="text/javascript" src="/js/keyword.js" charset="UTF-8"></script>
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>