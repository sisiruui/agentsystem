<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/inc/head.jsp"%>
<link id='theme' rel='stylesheet' href='/css/systemconfig.css'/>
<!-- 上面的是头部引用 -->
	<div class="mbxnav">
		<!-- 后台需要返回一个systemCoinfigType   这个用的比较多以type命名    这个值决定了要显示的界面 -->
			系统配置管理\<a href="/SystemConfig/seniority.do">服务年限</a>
	</div>
	
	
	
	
	
	
	<div class="container" id="app">  <!-- 每一项都包含在 container中   分7项    根据 type显示-->
	
	
	
	
	
	


	<div class="simpleconfig">
		<H3>服务年限管理-填写最大的服务年限</H3>



			<ul>
				<li>配置名称：<input type="text" id="simpTypeName" v-model.trim="SystemConfig.configTypeName"  disabled="disabled"/></li>
				<li>配置数值：<input type="number" id="simpConfigValue" v-model.trim="SystemConfig.configValue"/></li>
				<li>

				<input type="button" id="simpleBtn" @click="updateSystemConfig()" value="保存"/></li>
			</ul>
		</div>



	
	


</div>

<script type="text/javascript" src="/js/systemconfig/seniority.js"></script>
<script>
    $(function(){
        mover(5);
    })


</script>
  </body>
</html>
