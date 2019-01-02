<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/inc/head.jsp" %>
<div class="mbxnav">
	<a href="/main.action">代理商管理</a> \ <a href="/customlist.action">代理商客户管理</a>
</div>
<div class="container" id="app">
	<form action="/customs/list.do" method="post" >
		 <div>
			<label>客户名称:</label>
			  <input type="hidden" id="page" name="page" value="1"/>
			<input type="text" id="cname" name="cname" v-model.trim="search.customName" value=""/>
			<input type="button" value="查询" @click="methodNameSearch()" />
		  </div>
	</form>
	<div class="addCustomDiv">
	<input onclick="javascript:location.href='/customs/toAddPage';" type="button" value="添加客户" />
	</div>
   <%--<c:choose>--%>
	  <%--<c:when test="${message == 'fail'}">--%>
		<%--您的用户下没有用户，点击[添加客户]可以创建用户。--%>
	  <%--</c:when>--%>
	  <%--<c:otherwise>--%>
	<table>
		<thead>
			<tr>
			<th>序号</th>
			<th>客户名称</th>
			<th>法人代表</th>
			<th>注册时间</th>
			<th>类型</th>
			<th>状态</th>
			<th>操作</th>
			</tr>
		</thead>
			<tr class="tabletr" v-for="(item, index) in items">
				<td> {{ item.id }} </td>
				<td> {{ item.customName }} </td>
				<td> {{ item.bossName }} </td>
				<td> {{ item.regDatetime }} </td>
				<td> {{ item.customTypeName }} </td>
				<td> {{ item.customStatus == 1 ? "启用" : "关闭" }} </td>

				<td class="funcli">
					<ul>
						<li><a class="viewCustom" @click="methodToViewCustoms(item.id)"  >查看</a></li>
						<li><a class="modifyCustom" @click="methodToUpdateCustoms(item.id)" >修改</a></li>

						<li v-if="item.customStatus == 1">
							<a class="modifyCustomStatus"  ><span color="red" @click="methodChangeStateOpen(item.id, 0, index)">停用</span></a></li>
						</li>
						<li v-else>
							<a class="modifyCustomStatus"  ><span color="green" @click="methodChangeStateOpen(item.id, 1, index)">启用</span></a></li>

						</li>
					</ul>
				</td>
			</tr>


		<%--<c:forEach var="customs" items="${list}" varStatus="sta">--%>
			<%--<tr class="tabletr">--%>
				<%--<td>--%>
					<%--${sta.index}--%>
				<%--</td>--%>
				<%--<td>${customs.customName}</td>--%>
				<%--<td>${customs.bossName}</td>--%>
				<%--<td><fmt:formatDate value="${customs.regDatetime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>--%>
				<%--<td>${customs.customTypeName}</td>--%>
				<%--<td>--%>
					<%--${customs.customStatus==1?'启用':'关闭'}--%>
				<%--</td>--%>
				<%--<td class="funcli">--%>
					<%--<ul>--%>
						<%--<li><a class="viewCustom" href="/customs/view.do?id=${customs.id}" >查看</a></li>--%>
						<%--<li><a class="modifyCustom"   href="/customs/updatebefore.do?id=${customs.id}" >修改</a></li>--%>
						<%--<li>--%>
						 <%--<c:choose>--%>
						  <%--<c:when test="${customs.customStatus==1}">--%>
							<%--<a class="modifyCustomStatus"  href="/customs/isstart.do?id=${customs.id}&isstart=0"><font color="red">停用</font></a></li>--%>
						  <%--</c:when>--%>
						  <%--<c:otherwise>--%>
						  <%--<a class="modifyCustomStatus"  href="/customs/isstart.do?id=${customs.id}&isstart=1"><font color="green">启用</font></a></li>--%>
						  <%--</c:otherwise>--%>
						 <%--</c:choose>--%>
					<%--</ul>--%>
				<%--</td>--%>
			 <%--</tr>   --%>
		<%--</c:forEach>--%>
		<%----%>
		 </table>
	<div class="pagination pagination-centered">
	<ul>
		<li><a  @click="methodtoPage(1)" >首页</a></li>
		<li v-for="(prev, index) in PageNumberList.prevList"><a  @click="methodtoPage(prev)" >{{ prev }}</a></li>
		<li><a class="number" >{{ PageNumberList.thePage }}</a></li>
		<li v-for="(next, index) in PageNumberList.nextList"><a  @click="methodtoPage(next)" >{{ next }}</a></li>
		<li><a @click="methodtoPage(0)">尾页</a></li>
	</ul>
</div>
</div>
<link id='theme' rel='stylesheet' href='/css/customlist.css'/>
		<script type="text/javascript" src="/js/customlist.js" charset="UTF-8"></script>
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>

