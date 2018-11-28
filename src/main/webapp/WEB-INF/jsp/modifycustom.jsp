<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/inc/head.jsp" %>
<script>
    var urlId =
    ${urlId}
</script>
<div class="mbxnav">
    <a href="/main.action">代理商管理</a> \ <a href="/customlist.action">代理商客户管理</a> \ <a
        href="/modifycustom.action?custom.id=<s:property value='custom.id'/>">修改客户信息</a>
</div>
<div class="container" id="app">
    <form id="cform" action="/customs/doUpdate.do">
        <input type="hidden" name="cname" value=""/>
        <div class="subtitle">基本信息</div>
        <div class="info1">
            <ul>
                <li>企业名称：
                    <input type="text" id="custom_name" name="customName" v-model.trim="customs.customName"/> <span
                            style="color:red;">*</span></li>
                <li>企业类型：<input id="customtypename" type="hidden" name="customTypeName"
                                v-model.trim="customs.customTypeName"/>
                    <select id="selectcustomtype" name="customType" v-model.trim="customs.customType">
                        <option value="0">--请选择--</option>
                        <option v-for="syscfg in typeOfServiceSystem" :value="syscfg.id">{{ syscfg.configTypeName }}
                        </option>
                    </select> <span style="color:red;">*</span></li>
                <li>企业主页：<input type="text" name="siteUrl" v-model.trim="customs.siteUrl"/></li>
                <li>状态：<select name="customStatus">
                    <option value="1" selected="selected">启用</option>
                    <option value="0">停用</option>

                </select> <span style="color:red;">*</span></li>
            </ul>
            <div class="clear"></div>
        </div>
        <div class="subtitle">门户信息</div>
        <div class="info2">
            <ul>
                <li>法人代表：<input type="text" name="bossName" v-model.trim="customs.bossName"/></li>
                <li>注册日期：<input class="Wdate" id="laydate" size="15" name="regDatetime" readonly="readonly"
                                type="text" v-model.trim="customs.regDatetime"/></li>
                <li>证件类型：<input id="cardtypename" type="hidden" name="cardTypeName" />
                    <select id="selectcardtype" name="cardType" v-model.trim="customs.cardType"  >
                        <option value="0">--请选择--</option>
                        <option v-for="syscfg in idTypeSystemConfig" :value="syscfg.id">{{ syscfg.configTypeName }}
                        </option>
                    </select></li>
                <li>证件号码：<input type="text" name="cardNum" v-model.trim="customs.cardNum"/></li>
                <li>国家：<input type="text" name="country" v-model.trim="customs.country" readonly /></li>
                <li>省/地区：<select id="selectprovince" name="province" v-model.trim="customs.province" >
                    <option value="0" selected="selected">--请选择--</option>
                    <option v-for="oneprovince in province" :value="oneprovince.provinceID">{{oneprovince.province}}</option>
                </select>
                </li>
                <li>公司传真：<input type="text" name="companyFax"  v-model.trim="customs.companyFax" /></li>
                <li>城市：
                    <select id="selectcity" name="city" v-model.trim="messageCustoms.city">
                        <option value="0" selected="selected" >--请选择--</option>
                        <option v-for="onecity in city" :value="onecity.cityID" selected=''>{{onecity.city}}</option>
                    </select>
                </li>
                <li>公司电话：<input type="text" name="companyTel" v-model.trim="customs.companyTel" /></li>
                <li>区：
                    <select id="selectarea" name="area" v-model.trim="messageCustoms.area">
                        <option value="0" selected="selected">--请选择--</option>
                        <option v-for="onearea in area" :value="onearea.areaId" selected=''>{{onearea.area}}</option>
                    </select>
                <li>公司地址：<input type="text" name="companyAddress" v-model.trim="customs.companyAddress" /></li>
            </ul>
            <div class="clear"></div>
            <div>
                备注：<textarea rows="2" cols="50" name="memo" v-model.trim="customs.memo"></textarea>
            </div>
        </div>
        <div class="subtitle">
            <a   id="addcontact" @click="methodAddContact()">添加一个联系人</a>
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
            <div class="goback">
                <input type="button" value="保存" @click="methodUpdateCustoms()"/>
                <input type="button" onclick="window.history.back(-1);" value="返回"/>
            </div>
        </div>
    </form>


</div>
<script src="/laydate/laydate.js"></script>
<!-- 改成你的路径 -->
<link id='theme' rel='stylesheet' href='/css/modifycustom.css'/>
<script type="text/javascript" src="/js/modifycustom.js" charset="UTF-8"></script>
<jsp:include page="/inc/foot.jsp"></jsp:include>
</body>
</html>
