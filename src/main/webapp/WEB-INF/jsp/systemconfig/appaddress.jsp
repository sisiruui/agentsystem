<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/inc/head.jsp"%>
<link id='theme' rel='stylesheet' href='/css/systemconfig.css'/>


	<div class="mbxnav">
			系统配置管理\
			<a href="/SystemConfig/appaddress.do">app地址</a>
	</div>
	
	
	
	
	
	
	<div class="container" id="app">  <!-- 每一项都包含在 container中   分7项    根据 type显示-->
	
	
	
	
	

		<div class="simpleconfig">
		<H3>APP URL管理-填写制作APP的系统的URL地址</H3>


			<ul>
				<li>配置名称：<input type="text" id="simpTypeName" v-model.trim="SystemConfig.configTypeName" /></li>
				<li>配置数值：<input type="text" id="simpConfigValue" v-model.trim="SystemConfig.configValue"/></li>
				<li>

					<input type="button" id="simpleBtn" @click="updateSystemConfig()" value="保存"/></li>
			</ul>
		</div>
			





</div>

<script type="text/javascript" src="/js/systemconfig/appaddress.js"></script>
<script>
    $(function(){
        mover(5);
    })


</script>
  </body>
</html>
