<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/inc/head.jsp" %>
<!-- 定义一个代码块 -->
<div class="mbxnav">
	<a href="/main.action">代理商管理</a> \ <a href="/yfk.action">代理商预付款</a>
</div>
<div class="container" id="app">


<div class="searchuserdiv ope">
	<ul>
		<li>
		<form action="/AccountDetail/list/page.do?page=1" method="post" onsubmit="return searchyfklistFunc();">
		操作类型：
		<select  name="type">
		<option value="0" >---请选择---</option>
			<option value="9999" >系统自动-关键词申请扣款</option>
			<option value="9999" >系统自动-返回预注册冻结资金</option>
			<option value="9999" >系统自动-扣除申请关键词的所有资金</option>
			<option value="9999" >系统自动-扣除关键词续费资金</option>
			<%-- 这个地方要获取所有的systemconfig的configtype=1的值 --%>
			<option v-for="sysConfig in systemConfigList" :value="sysConfig.configTypeValue">{{sysConfig.configTypeName }}</option>
		</select>
		操作时间：
		<input class="Wdate" size="15" name="startTime" id="starttime"  class='laydate' readonly="readonly"  value='<c:if test="${startTime !=null }">${startTime  }</c:if>'	 />
		至
		<input class="Wdate" size="15" name="entTime" id="endtime"  class='laydate' readonly="readonly" value='<c:if test="${entTime !=null }">${entTime  }</c:if>' />
		
		<input type="submit" value="查询"/>
		</form>
		</li>
	</ul>
</div>
 <table>
  <thead>
	  <tr>
		  <th>序号</th>
		  <th>账务类型</th>
		  <th>账务资金</th>
		  <th>账户余额</th>
		  <th>备注信息</th>
		  <th>明细时间</th>                                          
	  </tr>
  </thead>   
  <tbody>

	 	<c:if test="${ list!=null}">
  		<c:forEach items="${list}" var="accountDetail" varStatus="sta">
  		<tr>
  		<td>${sta.index+1}</td>
  			<td>${accountDetail.detailTypeName}</td>
			<td>￥${accountDetail.money}</td>
			<td>￥${accountDetail.accountMoney}</td>
			<td>${accountDetail.memo}</td>
			<td class="center">
			<fmt:formatDate value="${accountDetail.detailDateTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
  			 </tr>
  		</c:forEach>
  	
  	
  	</c:if>
</tbody>
</table>

<%--<div class="pagination pagination-centered">--%>
						  <%--<ul>--%>
						  <%--<c:if test="${prevList!=null  || thePage!=null || nextList!=nill }">--%>
			<%----%>
			<%--<li><a href="/keywords/manage.do?page=1<c:if test="${type != null }">&type=${type }</c:if>">首页</a></li>--%>
			<%--<c:if test="${prevList!=null}">--%>
				<%--<c:forEach var="prev" items="${prevList}" varStatus="sta">--%>
				<%--<li><a href="/keywords/manage.do?page=${prev}<c:if test="${type != null }">&type=${type }</c:if>" class="number" >${prev} </a></li>--%>
				<%--</c:forEach>--%>
			<%--</c:if>--%>
			<%--<li class="active">--%>
			  <%--<a href="javascript:void()">${thePage}</a>--%>
			<%--</li>--%>
			<%--<c:if test="${nextList!=null}">--%>
				<%--<c:forEach var="next" items="${nextList}" varStatus="sta">--%>
				<%--<li><a href="/keywords/manage.do?page=${next}<c:if test="${type != null }">&type=${type }</c:if>" class="number" >${next} </a></li>--%>
				<%--</c:forEach>--%>
			<%--</c:if>--%>
			<%--<li><a href="/keywords/manage.do?page=0<c:if test="${type != null }">&type=${type }</c:if>">尾页</a></li>--%>
		<%----%>
		<%--</c:if>	--%>
							 <%--</ul>--%>
						<%--</div>--%>
</div>
<link id='theme' rel='stylesheet' href='/css/yfk.css'/>
<script language="javascript" type="text/javascript" src="/My97DatePicker/WdatePicker.js"></script>

<script src="/laydate/laydate.js"></script> <!-- 改成你的路径 -->\
<script type="text/javascript" src="/js/AgentAdvicePayment.js"></script>


<jsp:include page="/inc/foot.jsp"></jsp:include>


</body>
</html>