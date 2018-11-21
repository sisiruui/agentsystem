<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/inc/head.jsp" %>


<link id='theme' rel='stylesheet' href='/css/rolelist.css'/>

<!-- 上面的是头部引用 -->
<div class="mbxnav">
    <a href="javascript:void();">系统管理</a>
    \ <a href="/role/list.do">角色管理</a>
</div>

<div class="container" id = "app">
    <div id="addRoleDiv" class="addRoleDivClass addback" :class="{ showvue: condition.adddiv }">
        <form>
            <ul>
                <li class="lititle">
                    <b>添加角色信息</b>
                </li>
                <li>角色名称：<input id="a_roleName" type="text" v-model.trim="role.roleName" name="role.roleName"/> <span>*</span></li>
                <li>是否启用：
                    <select id="a_isStart" name="role.isStart" v-model.trim="role.isStart">
                        <option value="1" selected="selected">启用</option>
                        <option value="0">不启用</option>
                    </select> <span>*</span>
                    <input id="addRoleSubmit" type="button" @click="addRole()" value="保存"/> <input id="addcancel" type="reset" @click="closeAddDiv()" value="取消"/>
                </li>
            </ul>
        </form>
    </div>
    <div id="modifyRoleDiv" class="addRoleDivClass modifyback" :class="{ showvue: condition.updatediv }" >
        <ul>
            <li class="lititle">
                <input id="m_roleId" type="hidden" name="role.id"/>
                <b>修改角色信息</b>
            </li>
            <li>

                角色名称：<input id="m_roleName" type="text" name="role.roleName" v-model.trim="updateRole.roleName"/> <span>*</span></li>
            <li>是否启用：<select id="a_isStart_updata" name="role.isStart" v-model.trim="updateRole.isStart">
                <option value="1">启用</option>
                <option value="0">不启用</option>
            </select>
                <span>*</span>
                <input id="aaa" type="button" @click="updateRoless()" value="保存"/> <input id="modifycancel" type="button"  @click="closeUpdateDiv()"
                                                                                       value="取消"/>
            </li>
        </ul>
    </div>


    <div class="addRoleDiv"><input id="addRole" type="button" @click="openAddDiv()" value="新增"/></div>
    <table>
        <thead>
        <tr>
            <th>角色名称</th>
            <th>创建时间</th>
            <th>是否启用</th>
            <th colspan="2">操作</th>
        </tr>
        </thead>
        <tbody>
        <%-- 在这里绑定数据 --%>
<tr v-for="(item, index) in items">
    <td>{{ item.roleName }}</td>
    <td>{{ item.creationTime }}</td>
    <td>{{ item.isStart == 1 ? "启用" : "关闭" }}</td>
    <td>
         <span class="modifySystemBtn">
                <a class="financialUpdata"  @click="openUpdateDiv(index, item.id)" >修改</a>
         </span>|
        <span class="deleteSystemBtn">
             <a @click="removeTodo(index, item.id)">删除</a>
        </span>
    </td>
</tr>


        <%--<c:forEach var="role" items="${rolelist}" varStatus="status">--%>
            <%--<tr>--%>
                <%--<td>${role.roleName}</td>--%>
                <%--<td>--%>
                    <%--<fmt:formatDate value="${role.creationTime}" pattern="yyyy-MM-dd HH:mm:ss"/>--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--<c:choose>--%>
                        <%--<c:when test="${role.isStart == 1}">启用</c:when>--%>
                        <%--<c:otherwise>关闭</c:otherwise>--%>
                    <%--</c:choose>--%>
                <%--</td>--%>
                <%--<td colspan="2">--%>
                    <%--<span class="modifyRole"><a onclick="roleupdate(this,${role.id})">修改</a></span> |--%>
                    <%--<span class="deleteRole"><a onclick="roledelete(this,${role.id})">删除</a></span>--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>


        </tbody>
    </table>


</div>


<script type="text/javascript" src="/js/role.js"></script>
</body>
</html>
