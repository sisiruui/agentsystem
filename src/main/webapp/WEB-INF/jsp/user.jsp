<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/inc/head.jsp" %>
<link id='theme' rel='stylesheet' href='/css/userlist.css'/>
<script type="text/javascript" src="/alertframe/ymPrompt.js"></script>

<!-- 上面的是头部引用 -->
<div class="mbxnav">
    <a href="javascript:void();">系统管理</a> \ <a href="/userlist.action">用户管理</a>
</div>
<%-- 在最大的标签中引入vue--%>
<div class="container" id="app">
    <div class="searchuserdiv ope">
        <ul>
            <li>
                <form >
                    用户名称:
                    <input type="text" id="uname"  v-model.trim="searchUser.userName" name="uname"/>
                    角色：
                    <select name="roleId" v-model.trim="searchUser.roleId" >
                        <option value="0" selected="selected" >--请选择--</option>
                        <option v-for="role in roleItems" :value="role.id" > {{role.roleName}}</option>
                    </select>
                    是否启用：
                    <select name="isStart" v-model.trim="searchUser.isStart">
                        <option value="-1" selected="selected">--请选择--</option>
                        <option value="0">未启用</option>
                        <option value="1">启用</option>
                    </select>
                    <input type="button" value="查询" @click="methodsListUser()"/>
                </form>
            </li>
        </ul>
    </div>
    <div class="addUserDiv">
        <input id="addUser" type="button" @click="methodOpenAdd()" value="新增"/>
    </div>
    <table>
        <thead>
        <tr>
            <th>登录账号</th>
            <th>用户名称</th>
            <th>角色</th>
            <th>创建时间</th>
            <th>是否启用</th>
            <th colspan="3">操作</th>
        </tr>
        </thead>
        <tbody>
        <%-- 这是列表的div --%>
        <tr v-for="(item, index) in items">
            <td>{{ item.userCode }}</td>
            <td>{{ item.userName }}</td>
            <td>{{ item.roleName }}</td>
            <td>{{ item.creationTime }}</td>
            <td>{{ item.isStart == 1 ? "启用" : "关闭" }}</td>
            <td colspan="3">
                 <span class="modifySystemBtn">
                        <a class="financialUpdata" @click="methodOpenUpdate(index, item.id)">修改</a>
                 </span>|
                <span class="deleteSystemBtn">
                     <a @click="methodRemoveUser(index, item.id)">删除</a>
                </span>
            </td>
            <%--<td colspan="3">--%>
                <%--&lt;%&ndash;<span>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<a  @click="openUpdateDiv(index, item.id)">修改</a>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</span> |&ndash;%&gt;--%>
                <%--&lt;%&ndash;<span>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<a @click="removeTodo(index, item.id)" >删除</a></span> |&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<a>预付款</a> |&ndash;%&gt;--%>
                <%--&lt;%&ndash;<a href="javascript:ymPrompt.win('/logs/list.do?id=${user.id}&code=${user.userCode}',1015,540,' LOG日志',null,null,null,true);">LOG日志</a>&ndash;%&gt;--%>

            <%--</td>--%>
        </tr>
        <%--<c:if test="${list!=null}">--%>
            <%--<c:forEach var="user" items="${list}" varStatus="sta">--%>


                <%--<tr>--%>
                    <%--<td>${user.userCode}</td>--%>
                    <%--<td>${user.userName}</td>--%>
                    <%--<td roleId="${user.roleId}">${user.roleName}</td>--%>
                    <%--<td><fmt:formatDate value="${user.creationTime}"--%>
                                        <%--pattern="yyyy-MM-dd HH:mm:ss"/>--%>
                    <%--</td>--%>
                    <%--<td><c:choose>--%>
                        <%--<c:when test="${user.isStart==1}">启用</c:when>--%>
                        <%--<c:otherwise>关闭</c:otherwise>--%>

                    <%--</c:choose></td>--%>
                    <%--<td colspan="3"><span><a onclick="updateUser(this,${user.id})">修改</a></span> | <span><a--%>
                            <%--onclick="deleteUser(${user.id})">删除</a></span> |--%>
                        <%--<a>预付款</a> | <a>LOG日志</a>--%>
                        <%--<a href="javascript:ymPrompt.win('/logs/list.do?id=${user.id}&code=${user.userCode}',1015,540,' LOG日志',null,null,null,true);">LOG日志</a>--%>

                    <%--</td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
        <%--</c:if>--%>



        </tbody>
    </table>


    <!-- 这是新增的div  在这里绑定   在此方法中用vmodeltrim 来绑定方法-->
    <div id="addUserDiv" class="addUserDivClass addback" :class="{ showvue: condition.adddiv }">
        <ul>
            <li class="lititle">
                <b>添加代理商用户信息</b>

            </li>
            <li>登录账号：<input id="a_userCode" v-model.trim="user.userCode"  type="text" name="user.userCode"/> <span v-html="message.message1">*{{ message.message1 }}</span></li>
            <li>用户名称：<input id="a_userName" v-model.trim="user.userName" type="text" name="user.userName"/> <span  v-html="message.message2" >*{{ message.message2 }}</span></li>
            <li>登录密码：<input id="a_userPassword" v-model.trim="user.userPassword" type="password" name="user.userPassword"  value="123456"/> <span v-html="message.message3"></span>
            </li>
            <li>角&nbsp;&nbsp;&nbsp;&nbsp;色：
                <select id="a_roleId"  name="user.roleId" v-model.trim="user.roleId" >
                    <option value="0" selected="selected">--请选择--</option>
                     // 在这里获得所有的角色
                    <option v-for="role in roleItems" :value="role.id" > {{role.roleName}}</option>
                </select> <span>*</span>
            </li>
            <li>是否启用：
                <select id="a_isStart" name="user.isStart" v-model.trim="user.isStart" >
                    <option value="1" selected="selected">启用</option>
                    <option value="0">不启用</option>
                </select> <span>*</span>
                <input id="addUserSubmit" type="button" @click="methodSaveUser()"  value="保存"/>
                <input id="addcancel" type="reset" @click="methodCloseAdd()" value="取消"/>
            </li>
        </ul>
    </div>
    <div id="modifyUserDiv" class="addUserDivClass modifyback" :class="{ showvue: condition.updatediv }"  >
        <ul>
            <li class="lititle">
                <b>修改代理商用户信息</b>
            </li>
            <li>登录账号：<input id="m_userCode" type="text"  v-model.trim="selectUser.userCode" />
                <span v-html="message.message4"></span></li>
            <li>用户名称：<input id="m_userName" type="text" name="user.userName" v-model.trim="selectUser.userName"/> <span v-html="message.message5"></span></li>
            <li>登录密码：<input id="m_userPassword" type="password" name="user.userPassword" v-model.trim="selectUser.userPassword"/>
                <span v-html="message.message6"></span></li>
            <li>角&nbsp;&nbsp;&nbsp;&nbsp;色：
                <span id=m_SelectRole>
      			<select id="a_roleIdupdate" name="user.roleId" v-model.trim="selectUser.roleId">
                    <option v-for="role in roleItems" :value="role.id"  > {{role.roleName}}</option>
 			    </select>

      			</span> <span>*</span>
            </li>
            <li>是否启用：
                <span id="m_Select" >
      			<select id="a_isStartupdate" name="user.isStart" v-model.trim="selectUser.isStart">
 				<option value="1" selected="selected">启用</option>
 				<option value="0">不启用</option>
 			</select>
      			</span> <span>*</span>
                <input id="modifyUserSubmit" type="submit" @click="methodUpdateUser()" value="保存"/>
                <input id="modifycancel" type="button" @click="methodCloseUpdate()"
                                                                               value="取消"/></li>
        </ul>
    </div>
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
</div>


<script type="text/javascript" src="/js/userlist.js"></script>
</body>
</html>
