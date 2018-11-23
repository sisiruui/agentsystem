
var v = new Vue({
    el:'#app',
    data: {
        message: "message",
        customs: {
            agentId: 0,
            agentName: "",
            agentCode: "",
            customName: "",
            customType: 0,
            customTypeName: "",
            siteUrl: "",
            customStatus: 1,
            bossName: "",
            cardType: 0,
            cardTypeName: "",
            cardNum: "",
            companyTel: "",
            companyFax: "",
            regDatetime: "",
            country: "",
            province: "",
            city: "",
            area: "",
            companyAddress: "",
            memo: "",
            list: []

        },

        typeOfServiceSystem:[],
        idTypeSystemConfig: [],
        province: [],
        city: [],
        area: [],
        listContacts: [],
        addContact:{ // 这个是新添加用户的逻辑处理
            id: 0, // id
            customId: 0, // 代理商id 这个是当前登录用户的id
            contactName: "", // 姓名
            contactTel: "", // 电话
            contactFax: "", // 传真
            contactEmail: "", // 邮箱
            contactRole: "", // 职务 这个仅仅是个字符串，与是用户自填的，用业务逻辑无关
        }
//         /** 代理商id */
//         private Long customId;
// /** 用户姓名 */
// private String contactName;
// /** 用户电话 */
// private String contactTel;
// /** 用户传真 */
// private String contactFax;
// /** 用户邮箱 */
// private String contactEmail;
// /** 用户的职务， */
// private String contactRole;
    },
    methods: {
        /** 获取所有的客户类型 */
        methodGetClientType() {
            var self = this;
            var paramsMessage = {
                "configType":5
            };
            axios({
                method: "GET",
                url: "/systemconfig/json",
                params: paramsMessage
            })
                .then(function (response) {
                    console.log(response);
                    data = JSON.parse(response.data);
                    self.typeOfServiceSystem = data
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        /** 获取所有的证件类型 */
        methodGetIdType() {
            var self = this;
            var paramsMessage = {
                "configType":6
            };
            axios({
                method: "GET",
                url: "/systemconfig/json",
                params: paramsMessage
            })
                .then(function (response) {
                    var data = JSON.parse(response.data);
                    self.idTypeSystemConfig = data
                })
                .catch(function (error) {
                    console.log(error);
                });


        },
        /** 获取所有的省 */
        methodGetAllProvice() {
            var self = this;
            var paramsMessage = {}; // 空参数
            axios({
                method: "GET",
                url: "/address/province",
                params: paramsMessage
            })
                .then(function (response) {
                    data = JSON.parse(response.data);
                    self.province = data;

                })
                .catch(function (error) {
                    console.log(error);
                });


        },
        methodAddContact() {
            // 这是一个添加联系人的方法
            // 获取当前的模板数据
            var data = this.addContact;
            // 复制当前的数据
            var copyContact = JSON.parse(JSON.stringify(data));
            // 为什么不选择直接添加呢，如果添加的都是同一个对象的话，那就只能添加一个对象了。这眼集合中的对象之间是没有关系的，便于操作
            // 然后把复制的对象添加的listContacts中
            this.listContacts.push(copyContact);
        },
        // 这是移除的方法
        removeContact: function (index, id) {
            this.listContacts.splice(index, 1);
        },
        methodAddCustoms: function () {
            // 首先是一些元素的检测
            if (this.customs.customName == "") {
                humane.error("企业名称不能为空!!!");
                return false;
            } else if (this.customs.customType == 0) {
                humane.error("请选择企业类型!!!");
                return false;

            } else { // 才可以执行添加
                var self = this;
                self.customs.list;
                var paramsMessage = self.customs;
                axios({
                    method: "GET",
                    url: "/user/",
                    params: paramsMessage
                })
                    .then(function (response) {
                        data = JSON.parse(response.data);
                        if (data == "success") {
                            self.isok.message1 = true;
                            self.message.message1 = "您的密码输入正确。"
                        } else {
                            self.message.message1 = "您的密码输入错误!!!"
                        }
                    })
                    .catch(function (error) {
                        console.log(error);
                    });


            }


        }

    },
    mounted(){
        this.methodGetClientType();
        this.methodGetIdType();
        this.methodGetAllProvice();
    },
    watch: {
        // 当省发生变化的时候要把该省所有的市查出来
        "customs.province": function (value) {
            this.area = [];
            this.customs.area = "0";
            this.customs.city = "0";
            // value 即是当前的provinceID
            var self = this;
            var paramsMessage = {
                "provinceID":value,
            };
            axios({
                method: "GET",
                url: "/address/city",
                params: paramsMessage
            })
                .then(function (response) {
                    data = JSON.parse(response.data);
                    self.city = data;

                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        // 当城市变化的时候要找出所有的该市下的区
        "customs.city": function (value) {
            // value 即是当前的cityId

            var self = this;
            var paramsMessage = {
                "cityID":value
            };
            axios({
                method: "GET",
                url: "/address/area",
                params: paramsMessage
            })
                .then(function (response) {
                    console.log(response)
                    data = JSON.parse(response.data);
                    self.area = data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }



    }

})





// laydate.render({
// 	elem : '#regdate' // 指定元素
// });
//
// $(function(){
// 	mover(1);
//
//
// 	$("#selectprovince").on("click",function(){
// 		//如果省份选择到【请选择】处。市、区无论做何种选择都要回复到请选择的状态
//
// 			$("#selectcity option:not(:first)").remove();
// 			$("#selectarea option:not(:first)").remove();
//
// 		//开始根据#selectprovince").val() 的值  找  区
// 		$.ajax({
//             url:"/address/findCity.do",
//             type:"post",
//             data:{"provinceID":$("#selectprovince").val()},
//             dataType: "json",
//             success:function(data){
//             	//把接收的数据循环
//             	if(data!=null){
//             		var con ="";
//             		$.each(data,function(index,value){
//                         var s1=value.cityID;
//                         var s3=value.city;
//                          con+="<option value='"+s1+"'>"+s3+"</option>";
//                        });
//
//             		$("#selectcity").append(con);
//
//             	}
//
//
//
//             },
//             error:function(e){
//                 alert("系统错误！！");
//             }
//         });
//
//
//
//
//
//
// 	});
//
// 	$("#selectcity").on("click",function(){
// 		//如果省份选择到【请选择】处。市、区无论做何种选择都要回复到请选择的状态
//
//
// 			$("#selectarea option:not(:first)").remove();
//
// 		//开始根据#selectprovince").val() 的值  找  区
// 		$.ajax({
//             url:"/address/findArea.do",
//             type:"post",
//             data:{"cityID":$("#selectcity").val()},
//             dataType: "json",
//             success:function(data){
//             	//把接收的数据循环
//             	if(data!=null){
//             		var con ="";
//             		$.each(data,function(index,value){
//                         var s1=value.areaID;
//                         var s3=value.area;
//                          con+="<option value='"+s1+"'>"+s3+"</option>";
//                        });
//
//             		$("#selectarea").append(con);
//
//             	}
//
//
//
//             },
//             error:function(e){
//                 alert("系统错误！！");
//             }
//         });
//
//
//
//
//
//
// 	});
//
//
//
//
//
//
// });
//
// function checksave(){
//
// 	var rows = document.getElementById("contract").rows.length; //获得行数(包括thead)
//     var colums = document.getElementById("contract").rows[0].cells.length; //获得列数
//     alert("rows"+rows +",colums"+colums);
//     var jsonStr = "[";
//     for(var i = 1;i<$("#contract tr").length;i++){
//         var contactName = $("#contract tr:eq("+i+")").children().eq(0).find("input").val();
//         jsonStr += "{\"contactName\":\""+contactName+"\",";
//         var contactTel = $("#contract tr:eq("+i+")").children().eq(1).find("input").val();
//         jsonStr +="\"contactTel\":\""+contactTel+"\",";
//
//         var contactFax = $("#contract tr:eq("+i+")").children().eq(2).find("input").val();
//         jsonStr +="\"contactFax\":\""+contactFax+"\",";
//         var contactEmail = $("#contract tr:eq("+i+")").children().eq(3).find("input").val();
//         jsonStr +="\"contactEmail\":\""+contactEmail+"\",";
//         var contactRole = $("#contract tr:eq("+i+")").children().eq(4).find("input").val();
//         jsonStr +="\"contactRole\":\""+contactRole+"\"},";
//     }
//     jsonStr = jsonStr.substring(0,jsonStr.length-1)+"]";
//    $("#superString").val(jsonStr);
//
//
//     //线存储信息
//
//
//
//
//
//
//
// 	//先获取数据   获取验证的数据
// 	var customName =	$("#custom_name").val();//企业名称
// 	var customType = $("#selectcustomtype").val();//类型名称
// 	var customStatus = $("#custom.customStatus").val();//获取状态
// 	//必选项执行校验   企业名称不可为空  而且数据库不可以存在同名企业
// 	if($.trim(customName)==""){
// 		humane.error("公司名不可以为空。");
// 		$("#custom_name").focus();
// 		$("#custom_name").next().text();
// 		return false;
// 	}
//
// 	var message ="true";
//
// 	$.ajax({
//         url:"/customs/samename.do",
//         type:"post",
//         data:{"customName":customName},
//         dataType: "text",
//         success:function(data){//返回success 说明在数据库中查到了这个公司名称
//         	if(data=="success"){
//         		humane.error("公司名称被使用了");
//         		message="fail"
//         	}
//         },
//         error:function(e){
//             alert("系统错误！！");
//         }
//     });
// 	//在ajax 内部终止方法  ，在外部做判断
// 	if(message=="fail"){
// 		$("#custom_name").focus();//聚焦
// 		return false;
// 	}
//
// 	//然后判断 企业类型选择了吗
//
// 	if(customType==0){
// 		humane.error("请选择企业类型");
// 		$("#selectcustomtype").focus();//并不起作用
// 		return false;
// 	}
//
//
// 	//状态不用校验	 然后获取各种数据
// /*	var customName =	$("#custom_name").val();//企业名称
// 	var customType = $("#selectcustomtype").val();//类型名称
// 	var customStatus = $("#custom.customStatus").val();//获取状态
// */
// 	//这个是表单提交的  不再通过ajax 提交
//
//
//
//
//
//
//
// }
//
// $(function(){
// 	//这里是表单发生变化引起的函数变动
// 	//企业类型发生变化的时候   保存企业类型的值
// 	$("#selectcustomtype").on("change",function(){
// 		$("#customtypename").val($("#selectcustomtype option:checked").text());
// 	});
// 	//证件类型发生变化的时候，保存证件类型的值
// 	$("#selectcardtype").on("change",function(){
// 		$("#cardtypename").val($("#selectcardtype option:checked").text());
//
// 	});
// 	//这样后台需要的数据前端都能提供了
//
//
// });
//
// $(function(){
// 	//这里是执行尾部添加联系人的代码块
// 	$("#addcontact").on("click",function(){
// /*		alert("ni");*/
// 		var str = "<tr><td><input type='text' /></td>"+
// 		"<td><input type='text' /></td>"+"<td><input type='text' /></td>"+
// 		"<td><input type='text' /></td>"+"<td><input type='text' /></td>"+
// 		"<td ><a href='javascript:void()' onclick='deletethistr(this)' >删除</a></td></tr>"
// 		$("#addtr").append(str);
//
// 	});
// 	//这是给删除的方法添加事件
//
//
//
// });
//
//
// function deletethistr(e){
// 	//根据a标签移除tr
// 	$(e).parent().parent().remove();
// }
//
// //
//
// $(function(){
// 	//这里是执行尾部添加联系人的代码块
// 	$("#mywtest").on("click",function(){
// 		alert("nihao")
//
//
//
// 	});
// 	//这是给删除的方法添加事件
//
//
//
// });
//
