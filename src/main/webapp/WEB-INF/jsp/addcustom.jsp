<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/inc/head.jsp" %>
<script language="javascript" type="text/javascript" src="/My97DatePicker/WdatePicker.js"></script>
<div class="mbxnav">
	<a href="/main.action">代理商管理</a> \ <a href="/customlist.action">代理商客户管理</a> \ <a href="/addcustom.action?custom.id=<s:property value='custom.id'/>">添加客户信息</a>
</div>
<div class="container" id="app">
<form id="cform" action="/customs/add.do" method="post" onsubmit="return checksave();">
	<div class="subtitle">基本信息</div>
	<div class="info1">
		<ul>
			<li>企业名称：
			<input type="text" name="customName" v-model.trim="customs.customName" id="custom_name" /> <span style="color:red;">*</span></li>
			<li>企业类型：<input id="customtypename"  type="hidden" name="custom.customTypeName" value=""/>
        	 	<select id="selectcustomtype" v-model.trim="customs.customType" name="custom.customType">
        	 		<option value="0" selected="selected">--请选择--</option>
					<option v-for="syscfg in typeOfServiceSystem" :value="syscfg.id">{{ syscfg.configTypeName }}</option>

	      		</select> <span style="color:red;">*</span></li>
			<li>企业主页：<input type="text" v-model.trim="customs.siteUrl" name="custom.siteUrl"  id="custom.siteUrl"/></li>
			<li>状态：<select name="custom.customStatus"  v-model.trim="customs.customStatus" id="custom.customStatus">
	      			<option value="1" selected="selected">启用</option>
	      			<option value="0">停用</option>
	      		 </select> <span style="color:red;">*</span></li>
		</ul>
		<div class="clear"></div>
	</div>
	<div class="subtitle">门户信息</div>
	<div class="info2">
		<ul>
			<li>法人代表：<input type="text" v-model.trim="customs.bossName" name="custom.bossName"/></li>
			<li>注册日期：<input type="text" id="laydate" size="15"  v-model.trim="customs.regDatetime" value=""
			/></li>
			<li>证件类型：<input id="cardtypename" type="hidden" name="custom.cardTypeName" v-model.trim="customs.cardTypeName" value=""/>
				<select id="selectcardtype" name="custom.cardType" v-model.trim="customs.cardType">
        	 		<option value="0" selected="selected">--请选择--</option>
					<option v-for="syscfg in idTypeSystemConfig" :value="syscfg.id">{{ syscfg.configTypeName }}</option>
				</select>
			</li>
			<li>证件号码：<input id="card_num" type="text" v-model.trim="customs.cardNum" name="custom.cardNum"/></li>
			<li>国家：<input type="text" name="custom.country" v-model.trim="customs.country" value="中国" disabled  /></li>
			<li>省/地区：<select id="selectprovince" v-model.trim="customs.province" name="custom.province">
        	 		<option value="0" selected="selected">--请选择--</option>
					<option v-for="oneprovince in province" :value="oneprovince.provinceID">{{oneprovince.province}}</option>
			</select>
			</li>
			<li>公司传真：<input type="text" name="custom.companyFax" v-model.trim="customs.companyFax"/></li>
			<li>城市：
			<select id="selectcity" name="custom.city" v-model.trim="customs.city">
        	 		<option value="0" selected="selected">--请选择--</option>
					<option v-for="onecity in city" :value="onecity.cityID">{{onecity.city}}</option>

			</select>
			</li>
			<li>公司电话：<input type="text" v-model.trim="customs.companyTel" name="custom.companyTel"/></li>
			<li>区：
			<select id="selectarea" name="custom.area" v-model.trim="customs.area" >
        	 		<option value="0" selected="selected">--请选择--</option>
					<option v-for="onearea in area" :value="onearea.areaId">{{onearea.area}}</option>

			</select>
			<li>公司地址：<input type="text" name="custom.companyAddress" v-model.trim="customs.companyAddress"/></li>
		</ul>
		<div class="clear"></div>
		<div>
		备注：<textarea rows="2" cols="50" name="custom.memo" v-model.trim="customs.memo"></textarea>
		</div>
	</div>
	<div class="subtitle"> 
	<a href="javascript:void(0);" @click="methodAddContact()" id="addcontact">添加一个联系人</a>
        
         <input type="hidden" id="c_count" /></div>
	<div class="info3">
		<table id="contract">
            <thead>
            <tr>
	     	<th>姓名</th>
	     	<th>电话</th>
	     	<th>传真</th>
	     	<th>邮箱</th>
	     	<th>职务</th>
	     	<th>操作</th>
  			</tr>
            </thead>
            <tbody id="addtr">
				<tr v-for="(contact, index) in listContacts">
					<td> <input type="text" v-model.trim="contact.contactName"/>   </td>
					<td> <input type="text" v-model.trim="contact.contactTel"/>   </td>
					<td> <input type="text" v-model.trim="contact.contactFax"/>   </td>
					<td> <input type="text" v-model.trim="contact.contactEmail"/>   </td>
					<td> <input type="text" v-model.trim="contact.contactRole"/>   </td>

					<td><a href="javascript:void(0);" @click="removeContact(index, contact.id)" >删除</a></td>
				</tr>
            </tbody>
          </table>
	</div>
	<input type="hidden" name="superString" id="superString"> 
	<div class="goback"><input type="button" value="保存" @click="methodAddCustoms()" /> <input type="button" onclick="window.history.back(-1);" value="返回" /> </div>


</form>



	
</div>
<script src="/laydate/laydate.js"></script> <!-- 改成你的路径 -->



<link id='theme' rel='stylesheet' href='/css/addcustom.css'/>
<script type="text/javascript" src="/js/addcustom.js" charset="UTF-8"></script> 
<script >

</script>
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>
