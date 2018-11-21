<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/inc/head.jsp"></jsp:include>
<div class="mbxnav">
代理商管理\当前账户信息
</div>
<div class="container">
	<div >
		<div class="userInfo">
		
		<ul>
		<li><b>您好，${sessionScope.user.userName}!</b> 您上次登录时间<fmt:formatDate value="${sessionScope.user.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss" /></li>
		<li>
		您当前账户余额：
<c:choose>
  <c:when test="${not empty  account}">${requestScope.account.money}</c:when>
  <c:otherwise>对不起，您还没有开启账户，或者您的账户的资金出现了问题，请联系系统管理员进行处理。
  </c:otherwise>
 </c:choose>

		<a href="/AccountDetail/list/pagging.do?page=1">查看账户明细</a>
		

	</li>
	</ul>
			
			
		</div>
	</div>
</div>
<jsp:include page="/inc/foot.jsp"></jsp:include>


</body>
</html>
