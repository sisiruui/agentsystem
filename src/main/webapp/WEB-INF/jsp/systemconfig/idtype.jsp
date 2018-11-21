<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/inc/head.jsp"%>
<link id='theme' rel='stylesheet' href='/css/systemconfig.css'/>

	<div class="mbxnav">
		<!-- 后台需要返回一个systemCoinfigType   这个用的比较多以type命名    这个值决定了要显示的界面 -->
			系统配置管理\
			<a href="/SystemConfig/idtype.do">证件类型</a>
	</div>
	
	
	
	
	
	
	<div class="container" id="app">  <!-- 每一项都包含在 container中   分7项    根据 type显示-->
	
	
	
	
	
	
		<div>
		<div class="addSystemConfig">
			<input type="button" id="addsystemconfig" @click="openAddDiv()" value="添加证件类型"/>
		</div>
			<!-- 添加的方法 -->
			<div id="addSystemdiv" class="modifySystemdiv addback " :class="{ showvue: condition.adddiv }">
				<ul>
					<li class="lititle"><b>您正在进行添加操作</b></li>
					<li>
						<input type="hidden" id="addConfigType" value="1"/>
						类型名称：<input type="text" v-model.trim="SystemConfig.configTypeName" id="addConfigName"/></li>
					<li>是否启用：
						<select id="addIsStartSelect" v-model.trim="SystemConfig.isStart">
							<option value="1">启用</option>
							<option value="2">不启用</option>
						</select>
						<input type="button" id="addSystemConfigBtn" @click="addSystemConfig()" value="保存"/>
						<input type="button" id="cancleAddSystemConfigBtn" @click="openAddDiv()" value="取消"/>
					</li>
				</ul>
			</div>
			<table>
			  <thead>
				  <tr>
					  <th>序号</th>
					  <th>配置类型</th>
					  <th>是否启用</th>
					  <th colspan="2">操作</th>                                          
				  </tr>
			  </thead>   
			  <tbody>
			  <tr v-for="(item, index) in items">
				  <td>{{ item.id }}</td>
				  <td>{{ item.configTypeName }}</td>
				  <td>{{ item.isStart == 1 ? "启用" : "关闭" }}</td>
				  <td>
					 <span class="modifySystemBtn">
							<a class="financialUpdata" @click="openUpdateDiv(index, item.id)">修改</a>
					 </span>|
					  <span class="deleteSystemBtn">
						 <a @click="removeTodo(index, item.id)">删除</a>
					</span>
				  </td>
			  </tr>
			    </tbody>
			</table>
		</div>

		<div id="modifySystemdiv" class="modifySystemdiv modifyback" :class="{ showvue: condition.updatediv }">
			<ul>
				<li class="lititle"><b>您正在进行修改操作</b></li>
				<li><input type="hidden" id="sid"/>
					<input type="hidden" id="idtable"/>
					<input type="hidden" id="modifyConfigType"/>
					类型名称：<input type="text" id="configName" v-model.trim="selectSystemConfig.configTypeName"/>
				</li>

				<li>
					是否启用：<span id="isstart">
                    <select id="updateIsStartSelect" v-model.trim="selectSystemConfig.isStart">
                        <option value="1">启用</option>
                        <option value="2">不启用</option>
                    </select>
				</li>
				</span>
				<li>
					<input type="button"
						   id="modifySystemConfigBtn" @click="updateSystemConfig()" value="保存"/> <input type="button"
																										id="cancleModifySystemConfigBtn"
																										value="取消"
																										@click="closeUpdateDiv()"/>
				</li>
			</ul>
		</div>






	</div>

<script type="text/javascript" src="/js/systemconfig/idtype.js"></script>
<script>
    $(function(){
        mover(5);
    })


</script>
  </body>
</html>