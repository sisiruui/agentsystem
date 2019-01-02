$(function(){
	mover(1);
})

var v = new Vue({
    el:'#app',
    data: {
        keywords: { // 基础类
			id: 0,
            keywords: "",
            agentId: 0,
            agentName: "",
            customId: 0,
            customName: "",
            preRegFrozenMoney: 0,
            price: 0,
            productType: 0, // 这里就是是否上传苹果商店
            serviceYears: 0,
            openApp: 0,
            appUserName: "",
            appPassword: "",
            loginUrl: "",
            iosDownloadUrl: "",
            androidDownloadUrl: "",
            codeIosUrl: "",
            preRegDatetime: "",
            preRegPassDatetime: "",
            regDatetime: "",
            regPassDatetime: "",
            isPass: 0,
            checkStatus: 0,
            isUse: 0,
		}, // 基础类
		search: { // 搜索类
			customsName: ""
		},
		account: { // 获取当前的Account
		},
        searchDiv: false,
        customsList: [],
        selectCustoms: {},
        typeOfServiceSystemConfig: [],
        preperentialSystemConfig: [],
        servicePrice: 0, // 服务内容的存储
        trueYears : 0,
        checkKeywords: true


    },
    methods: {
        /** 获取当前的Account */
    	methodGetAccount: function () {
            var self = this;
            var paramsMessage = { // 搜索的条件在当前的session中
            };
            axios({
                method: "GET",
                url: "/account/json",
                params: paramsMessage
            })
                .then(function (response) {
                    data = JSON.parse(response.data);
                 	self.account = data;
                })
                .catch(function (error) {
                    console.log(error);
                });

        },
        methodSelectCustoms(id, index) { // 如果选择了客户之后，就要为keywords的客户名称设置上内容 而且该keywords与customs有关系的内容都要存上内容
    	    // 然后就可以根据index获取选中的customs的信息了
            // 下面是设置的内容。
            this.selectCustoms = this.customsList[index];
            this.keywords.customId = this.selectCustoms.id;
            console.log(this.selectCustoms.customName)
            this.keywords.customName = this.selectCustoms.customName;
            // 下面是操作的css 关闭展示框
            this.searchDiv = false;
        },
        /** 获取所有的服务类型 */
        methodGetTypeOfService() {
            var self = this;
            axios({
                method: "GET",
                url: "/systemconfig/json",
                params:{
                    configType: 2,
                }
            })
                .then(function (response) {
                    self.typeOfServiceSystemConfig = JSON.parse(response.data);

                })
                .catch(function (error) {
                    console.log(error);
                });
        }
        , /** 获取所有的优惠类型 */
        methodGetPreperential() {
            var self = this;
            axios({
                method: "GET",
                url: "/systemconfig/json",
                params:{
                    configType: 7,
                }
            })
                .then(function (response) {
                    self.preperentialSystemConfig = JSON.parse(response.data);

                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        methodSaveKeywords: function () { // 保存keywords的方法
            // 当前的客户名称不可为空
            if ("" == this.keywords.customName) {
                console.log(this.keywords.customName)
                humane.error("请在搜索客户中查找要申请关键词的客户。");
                return false;
            }
            // 如果服务类型为0，则提示选择服务类型
            if (0 == this.keywords.productType) {
                humane.error("请选择您的服务类型。");
                return false;
            }
            // 如果服务年限为0，则提示选择服务年限
            if (0 == this.keywords.serviceYears) {
                humane.error("请选择您的服务年限。");
                return false;
            }
            if (0 == this.keywords.price) {
                humane.error("价格不可以为0，请选择服务类型或服务年限。");
                return false;
            }
            this.methodCheckKeywords();





        },
        methodSaveKeywordsCallBack: function () {
            // 如果为true则表示存在，那个不做任何事情，相关的提醒，已经在methodCheckKeywords中存在

            if (this.checkKeywords) {
                alert("sss" +
                    "")
                return false
            } else {
                // 如果不存在，则可以执行下一步操作，直接获得页面中的keywords

                var self = this;
                var paramsMessage = self.keywords;
                axios({
                    method: "post",
                    url: "/keywords",
                    data: paramsMessage
                })
                    .then(function (response) {
                        data = response.data;
                        if (data = "success") {
                            humane.success("添加成功");
                        } else {
                            humane.erroe("添加失败！请检查您的数据。");
                        }
                        self.checkKeywords = true;
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            }
        },

        /**验证keywords是否存在，以及keywords是否注册过 */
        methodCheckKeywords: function () {
            // 如果keywords为空，则说明没有指定关键词
            if ("" == this.keywords.keywords) {
                humane.error("请填写您的关键词。");
                this.checkKeywords = true;
            } else {
                // 在数据库中验证是否已存在
                var self = this;
                var paramsMessage = {
                    "keywords": this.keywords.keywords
                };
                axios({
                    method: "GET",
                    url: "/keywords/check/keywords",
                    params: paramsMessage
                })
                    .then(function (response) {
                        data = response.data;
                        if (data == "success") {
                            humane.error("该关键词已存在，请选用其他关键词。");
                            self.checkKeywords = true;
                        } else {
                            humane.error("，false。");
                            self.checkKeywords = false;
                            self.methodSaveKeywordsCallBack();

                        }
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            }
        }
            },
    mounted() {
        // 获取当前用户的金额
    	this.methodGetAccount();
    	// 获取所有的服务类型
        this.methodGetTypeOfService();
        this.methodGetPreperential();
    },
    watch: {
        /** 点击搜索获得展示的列表 */
        "search.customsName": function () {
            // 根据搜索的名称获得该名称的所有customs 这个要在controller中重写方法
            if (this.search.customsName == "") {   // 如果当前为空，则这展示名称的div要是隐藏的
                this.searchDiv = false;
            } else {
                this.searchDiv = true;
                var self = this;
                var paramsMessage = {
                    "customName":self.search.customsName,
                };
                axios({
                    method: "GET",
                    url: "/customs/top",
                    params: paramsMessage
                })
                    .then(function (response) {
                        data = JSON.parse(response.data);
                        self.customsList = data;
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            }
        },
        "keywords.productType": function () { // 这是产品类型
            if (this.keywords.productType == 0) { // 如果 服务类型为0，则价格为0。价格 = 服务年限 * 产品类型
                this.keywords.price = 0;
            } else { // 根据 对应的产品类型找到 产品类型对应的价格
                for (var i = 0; i < this.typeOfServiceSystemConfig.length;  i++) { // 寻找对应的价格
                    if (this.keywords.productType == this.typeOfServiceSystemConfig[i].configTypeValue) {
                        this.servicePrice =  this.typeOfServiceSystemConfig[i].configValue;
                    }
                }
                this.keywords.price = this.servicePrice * this.trueYears; // 这个 是真实的价格
            }
        },
        "keywords.serviceYears": function () { // 服务年限
            if (0 == this.keywords.serviceYears) {
                this.keywords.price = 0; // 如果服务年限为0，则价格也是0。 价格 = 服务年限 * 产品类型
            } else {
                this.trueYears = this.keywords.serviceYears;
                this.keywords.price = this.servicePrice * this.trueYears; // 真实的价格
            }

        }
    }
})


function sleep(n) {
    var start = new Date().getTime();
    //  console.log('休眠前：' + start);
    while (true) {
        if (new Date().getTime() - start > n) {
            break;
        }
    }

}
//
// /** 关键词 */
// private String keywords;
// /**  */
// private Integer agentId;
// /** 代理商姓名 */
// private String agentName;
// /** 用户id */
// private Integer customId;
// /** 用户姓名 */
// private String customName;
// /**  */
// private BigDecimal preRegFrozenMoney;
// /**  */
// private BigDecimal price;
// /** 产品类型 */
// private Integer productType;
// /** //服务年限 */
// private Integer serviceYears;
// /** 0未开通 1 开通 */
// private Integer openApp;
// /**  */
// private String appUserName;
// /**  */
// private String appPassword;
// /** 登陆地址 */
// private String loginUrl;
// /** ios客户端下载地址 */
// private String iosDownloadUrl;
// /** android客户端下载地址 */
// private String androidDownloadUrl;
// /** IOS二维码下载地址 */
// private String codeIosUrl;
// /** android二维码下载地址 */
// private String codeAndroidUrl;
// /** 申请时间 */
// private Date preRegDatetime;
// /** 第一次申请的结束时间 */
// private Date preRegPassDatetime;
// /** 申请时间 */
// private Date regDatetime;
// /** 申请截止的时间 */
// private Date regPassDatetime;
// /** 0为不过期，1为预注册过期，2为正式注册过期 */
// private Integer isPass;
// /** '0为已申请 1为审核中 2为已通过 3未通过 */
// private Integer checkStatus;
// /** 1为已使用 0为未使用 */
// private Integer isUse;



// //这个方法是用来触发搜索用户的
// $(function(){
//
// 	$("#searchUerText").on("keyup click",function(){
// 		loadUsers();
// 	});
// })
//
//
// //使用ajax在数据库中查找
// function loadUsers(){
// 	$.ajax({
// 		url:'/customs/searchName.do',
// 		type:"post",
// 		async:false,
// 		data:{"name":$("#searchUerText").val()},
// 		dataType:'json'                       ,
// 		success:function(result){
// 			var userList = "<ul>";
// 			for(var i=0;i< result.length;i++){
// 				userList = userList +
// 				"<li onclick=\"confirmCustom("+result[i].id+",'"+result[i].customName+"');\"><span>客户类型："+result[i].customTypeName+"</span><br/><a>"+result[i].customName+"</a></li>";
// 			}
// 			userlist = userList +"</ul>";
// 			$("#serachresult").html(userList);
// 			$("#serachresult").slideDown(500);
// 		}
// 	});
// }
//
// //选择用户所做的操作
// function confirmCustom(uid,ucode){
// 	userid = uid;
// 	userName = ucode;
// 	$("#searchUerText").val(ucode);
// 	$("#serachresult").html("");
// 	$("#serachresult").hide();
// 	$("#customname").val(ucode);
// 	$("#customId1").val(uid);
// }
//
// //这是自动计算价格的ajax
// $(function(){
// 	//什么时候回触发事件
// 	$(document).on("change","#servicetype",function(){
// 		if(	$("#servicetype").val()==0){
// 			$("#price").val("");
// 		}
// 		getPrice();
// 	});
// 	$(document).on("change","#serviceyears",function(){
// 		if(	$("#serviceyears").val()==0){
// 			$("#price").val("");
// 		}
// 		getPrice();
// 	});
// });
//
// /**
//  * 计算价格的方法
//  * @returns
//  */
// function getPrice (){
// 	//首先进行验证	//获取服务类型
// 	$("#servicetype").val();//服务类别
// 	$("#serviceyears").val();//服务年限
// 	if($("#servicetype").val()!=0 && $("#serviceyears").val()!=0){
// 		//发送服务类别，服务年限到数据库  返回价格   然后把价格添加到价格框中   执行ajax
// 		$.ajax({
//             url:"/keywords/price.do",
//             type:"post",
//             data:{"servicetype":$.trim($("#servicetype").val()),"serviceyears":$.trim($("#serviceyears").val())},
//             dataType: "html",
//             success:function(data){
//             	$("#price").val(data);
//             },
//             error:function(e){
//                 alert("系统错误！！ 获取金额错误");
//             }
//         });
// 	}
//
//
//
//
//
//
// }
//
// //检测关键词是否被注册过
// var check =     function  checkKeyword(){
// 	var message ="";
//
// 	$.ajax({
//
//         url:"/keywords/checkKeywordTest.do",
//         type:"post",
//         data:{"keyword":$("#keyword").val()},
//         dataType: "html",
//         success:function(data){
//
//         	if(data=="succ"){//查到了就不能使用
//
//         		$("#savemessage").val("fail");
//
//         	}else{
//
//         		$("#savemessage").val("succ");
//
//         	}
//
//         },
//         error:function(e){
//         	alert("wrong at keywords")
//         }
//     });
//
// }
//
//
//
//
//
// //提交关键词
// $(function(){
// 	$("#submitkeyword").on("click",function(){
// 		//首先 客户名称 不能喝为空
// 		if ($.trim($("#customname").val())=="") {
// 			 humane.error("请在搜索客户处选择客户。");
// 			 $("#searchUerText").focus();
// 			 return false;
// 		}
// 		if ($.trim($("#keyword").val())=="") {
// 			 humane.error("您的关键词不可以为空。");
// 			 $("#keyword").focus();
// 			 return false;
// 		}
// 		check();
// 		if($("#savemessage").val()=="fail"){
// 			 humane.error("您的关键词已被使用。");
// 			 $("#keyword").focus();
// 			 return false;
// 		}
// 		if($("#servicetype").val()==0){
// 			 humane.error("您的服务类型不能为空。");
// 			 $("#servicetype").focus();
// 			 return false;
// 		}
// 		if($("#serviceyears").val()==0){
// 			 humane.error("您的服务年限不能为空。");
// 			 $("#serviceyears").focus();
// 			 return false;
// 		}
// 		//验证
// 		$("#customname").val();//客户名称
// 		$("#keyword").val();//关键词
// 		$("#servicetype").val();//servicetype 服务类别
// 		$("#serviceyears").val();//服务年限
// 		$("#price").val();//价格
// 		$.ajax({
// 			url:"/keywords/add.do",
// 	        type:"post",
// 	        data:{"customName":$("#customname").val(),"keywords":$("#keyword").val(),
// 	        	"productType":$("#servicetype").val(),"serviceYears":$("#serviceyears").val(),
// 	        	"price":$("#price").val(),"customId":$("#customId1").val()
// 	        	},
// 	        dataType: "html",
// 	        success:function(data){
//
// 	        	if(data=="succ"){//查到了就不能使用
// 	        		$("#submitkeyword").off("click");
// 	        		humane.success("添加成功");
// 	        		setInterval("shuaxin()",1000);
//
//
// 	        	}else{
// 	        		$("#submitkeyword").off("click");
// 	        		humane.success("添加失败");
// 	        		setInterval("shuaxin()",1000);
// 	        	}
// 	        },
// 	        error:function(e){
// 	        	alert("wrong at add")
// 	        }
// 	    });
//
// 	})
//
//
//
//
//
//
// })
//
// var shuaxin = function(){
// 	window.location.reload();
// }







