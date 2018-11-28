<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/inc/head.jsp" %>
<script>
	var urlId = ${urlId}
</script>
<div class="mbxnav">
	<a href="/main.action">代理商管理</a> \ <a href="/customlist.action">代理商客户管理</a> \ <a href="/viewcustom.action?custom.id=<s:property value='custom.id'/>">查看客户信息</a>
</div>

<div class="container" id="app">

	<div class="subtitle">基本信息</div>
	<div class="info1">
		<ul>
			<li>企业名称： {{ customs.customName }}</li>
			<li>状态：
				<font color="green" v-if="customs.customStatus == 1">启用</font>
				<font color="red" v-else>停用</font>
			<li>企业类型：{{ customs.customTypeName }} </li>
			<li>企业主页：{{ customs.siteUrl }}</li>
		</ul>
		<div class="clear"></div>
	</div>
	<div class="subtitle">门户信息</div>
	<div class="info2">
		<ul>
			<li>法人代表：{{ customs.bossName }}</li>
			<li>注册日期：{{ customs.regDatetime }}/></li>
			<li>证件类型：{{ customs.cardTypeName }}${custom.cardTypeName}</li>
			<li>证件号码：{{ customs.cardNum }}${custom.cardNum}</li>
			<li>国家：{{ customs.country }}${custom.country}</li>
			<li>省/地区：{{ customs.province }}
			</li>
			<li>城市：{{ customs.city }}
		
			</li>
			<li>区：{{ customs.area }}
		
			
			</li>
			<li>公司电话：{{ customs.companyTel }}</li>
			<li>公司传真：{{ customs.companyFax }}</li>
			<li>公司地址：{{ customs.companyAddress }}</li>
			<li>备注：{{ customs.memo }}</li>
		</ul>
		<div class="clear"></div>
	</div>

	<div class="subtitle">联系人信息</div>
	<div class="info3">
		<ul v-if="0 == listContacts.length">
			<li >没有任何联系人</li>
		</ul>
		<ul v-else>

			<li  v-for="(contacts, index) in listContacts">
				<div>姓名：{{ contacts.contactName }}</div>
				<div>电话：{{ contacts.contactTel }}</div>
				<div>传真：{{ contacts.contactFax }}</div>
				<div>邮箱：{{ contacts.contactEmail }}</div>
				<div>职务：{{ contacts.contactRole }}</div>
			</li>
		</ul>
		<div class="clear"></div>
	</div>
	<div class="goback"><input type="button" onclick="window.history.back(-1);" value="返回" /> </div>
</div>
<link id='theme' rel='stylesheet' href='/css/viewcustom.css'/>
<script type="text/javascript" src="/js/viewcustom.js" charset="UTF-8"></script> 
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>
