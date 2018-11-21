$(function(){
	mover(4);
})
//             /** 用户CODE */
//             private String userCode;
// /** 用户名称 */
// private String  userName;
// /** 用户登录密码 */
// private String userPassword;
// /** 注册时间 */
// private Timestamp creationTime;
// /** 最后登录时间 */
// private Timestamp lastLoginTime;
// /** 创建者 */
// private String createdBy;
// /** 最后修改时间 */
// private Timestamp lastUpdateTime;
// /** 这不是boolean  是否启用 */
// private Integer isStart;
// /** 所属角色id */
// private Integer roleId;
// /** 所属角色name */
// private String roleName;


var v = new Vue({
    el:'#app',
    data: {
        items: [], // 这是列表用到的参数。
		roleItem : [],
		flagindex : -1, // 这是记录当前所选择的对象的下标。
		user: { // 这是添加用户用到的user
        	id: 0,
            userCode: "",
            userName: "",
            userPassword: "",
            creationTime: "",
            lastLoginTime: "",
            lastUpdateTime: "",
            isStart: 1,
            roleId: 0,
            roleName: ""

		},
		selectUser: { // 这是修改用户用到的user
            id: 0,
            userCode: "",
            userName: "",
            userPassword: "",
            creationTime: "",
            lastLoginTime: "",
            lastUpdateTime: "",
            isStart: -1,
            roleId: 0,
            roleName: ""
		},
        saveMessage: {
            message1: "",
            message2: ""
        },
        searchUser: { // 这是修改用户用到的user
            userName: "",
            isStart: -1,
            roleId: 0,
            thePage: 1
        },
        roleItems: [],
        PageNumberList: {
            thePage: 1,
            prevList: [],
            nextList: []
        },
        message:{
            message1: "*",
            message2: "*",
            message3: "*默认初始密码123456",
            message4: "",
            message5: "",
            message6: "",
        },
        addMessage:{
            message1: false,
            message2: false,
            message3: false,
        },
        updateMessage: {
            message1: false,
            message2: false,
            message3: false,
        },

        condition: { // 控制显示隐藏元素的类
            adddiv: false, // 添加元素隐藏
            updatediv: false // 修改元素隐藏。
        },
        indexflag: -1,

    },
	methods : { // 这是方法的列表
        methodOpenAdd() { // 打开添加的div的方法
			this.condition.adddiv =  !this.condition.adddiv; // 将true设置为false
			// 在这里获得所有的rolelist
            var self = this;
            axios({
                method: "GET",
                url: "/role/json",

            })
                .then(function (response) {
                    self.roleItem = JSON.parse(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                });


        },
        methodCloseAdd() {
        	this.condition.adddiv = false;
        },
        methodOpenUpdate(index, id) {
            this.condition.updatediv = !this.condition.updatediv
            // 复制对象
            this.selectUser =
                JSON.parse(JSON.stringify(this.items[index]))
            this.saveMessage.message1 == this.selectUser.userCode;
            this.saveMessage.message2 == this.selectUser.userName;


            this.indexflag = index;
            this.selectUser.userPassword = 123456;
            alert(this.selectUser.id);




        },
        methodCloseUpdate() {
            this.condition.updatediv = false;
        },
        methodUpdateUser() {
            if (this.updateMessage.message1 == false || this.updateMessage.message2 == false
                || this.updateMessage.message3 == false) {
                console.log(this.updateMessage);
                humane.error("请检查您的信息");
                return false;
            } else {
                var self = this;
                var paramsMessage = {
                    "id":self.selectUser.id,
                };
                paramsMessage.userCode = self.selectUser.userCode;
                paramsMessage.userName = self.selectUser.userName;
                paramsMessage.userPassword = self.selectUser.userPassword;
                paramsMessage.roleId = self.selectUser.roleId;
                paramsMessage.isStart = self.selectUser.isStart;

                alert(self.selectUser.id)
                axios({
                    method: 'put',
                    url: '/user/id/' + self.selectUser.id,
                    data: paramsMessage
                })
                    .then(function (response) {

                        data = response.data;
                        if (data < 1) { // 修改失败
                            humane.error("修改失败，您的页面可能已经过期，请刷新您的页面！");
                            return;
                        } else {

                            self.$set(self.items[self.indexflag], "userCode", self.selectUser.userCode);
                            self.$set(self.items[self.indexflag], "userName", self.selectUser.userName);
                            self.$set(self.items[self.indexflag], "userPassword", self.selectUser.userPassword);
                            self.$set(self.items[self.indexflag], "roleId", self.selectUser.roleId);
                            self.$set(self.items[self.indexflag], "isStart", self.selectUser.isStart);

                            // self.$forceUpdate();
                            self.condition.updatediv = false;
                            humane.success("操作成功！！！");
                        }

                    })
                    .catch(function (response) {
                        console.log(response);
                    });



            }







        },

        methodSaveUser() { // 这是添加的方法

            if ("" == this.user.userCode) {
                humane.error("登录账号不可以为空");
                return false;
            } else if ("" == this.user.userName) {
                humane.error("用户名称不可以为空");
                return false;
            } else if ("" == this.user.password) {
                humane.error("密码不可以为空");
                return false;
            } else if (0 == this.user.roleId) {
                humane.error("请选择添加的角色");
                return false;
            } else { // 信息都添加完了才可以执行添加操作
                console.log(this.addMessage);
                if (this.addMessage.message1 == false || this.addMessage.message2 == false
                    || this.addMessage.message3 == false) {
                    humane.error("请检查您的信息");
                    return false;
                }


                var self = this;
                axios({
                    method: 'post',
                    url: '/user',
                    data: {
                        "userCode": self.user.userCode,
                        "userName": self.user.userName,
                        "userPassword": self.user.userPassword,
                        "roleId": self.user.roleId,
                        "isStart": self.user.isStart,
                    }
                })
                .then(function (response) {
                    console.log(response);
                    data = response.data;
                    // 如果没有插入成功 则放回 failuer 就不要执行了
                    if ("missing" == data) {
                        humane.error("您没有输入正确的内容！");
                        return false;
                    } else if ("failure" == data) {
                        humane.error("添加失败，请检查您输入的数据！");
                        return false;
                    } else if ("exception" == data) {
                        humane.error("请检查您是否已经添加过此数据。");
                        return false;
                    } else {  // 如果插入成功，则返回json，并添加到 items中。
                        console.log(data);
                        self.condition.adddiv = false;
                        self.methodsListUser();

                    }
                })
                    .catch(function (error) {
                        console.log(error);
                    });
			}
        },







    	// 这是获得user 列表的方法 这个方法，要在加载元素完成的时候，执行
    	methodsListUser : function () { // 这是添加的方法

            var self = this;
            var paramsMessage = {
                "thePage":self.searchUser.thePage,
            };
            if (self.searchUser.roleId != 0) {
                paramsMessage.roleId = self.searchUser.roleId;
            }
            if (self.searchUser.isStart != -1) {
                paramsMessage.isStart = self.searchUser.isStart;
            }
            if (self.searchUser.userName != "") {
                paramsMessage.userName = self.searchUser.userName;
            }

            console.log(paramsMessage);



            axios({
                method: "get",
                url: "/user/json",
                params: paramsMessage
                    // {
                    // "thePage": self.searchUser.thePage,
                    // }
            })
                .then(function (response) {
                    console.log(response);
                    data = JSON.parse(response.data)
                    self.items = data["list"];
                    self.PageNumberList.nextList = data["pageNumber"].nextList;
                    self.PageNumberList.prevList = data["pageNumber"].prevList;

                    //     PageNumberList: {
                    //     thePage: 4,
                    //         prevList: [1,2,3],
                    //         nextList: [5,6,7]
                    // },
                    self.methodRoleList();

                })
                .catch(function (error) {
                    console.log(error);
                });

        },
        methodtoPage(number) {
            // 如果number为0则请求的是最后一页
            // this.$set(this.searchUser, "thePage", number); 在前端控制逻辑。
            if (number == 0) {

                // 如果同时为0，则说明当前只有一个第一页，则最后一页就是第一页。
                if (Object.keys(this.PageNumberList.nextList).length == 0 && Object.keys(this.PageNumberList.prevList).length == 0) {
                    number = 1
                    // 如果 thepage是最后一页，则请求的是最后一页
                } else if (Object.keys(this.PageNumberList.nextList).length == 0) {
                     number = this.PageNumberList.thePage;

                } else {
                    number = this.PageNumberList.nextList[this.PageNumberList.nextList.length - 1]
                }



            }
            

            this.searchUser.thePage = number;
            this.PageNumberList.thePage = number;
            this.methodsListUser();


        },
        methodRoleList: function () {
            var self = this;
            axios({
                method: "GET",
                url: "/role/json",

            })
                .then(function (response) {
                    self.roleItems = JSON.parse(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        methodRemoveUser: function (index, id) {
            alert(id);
            var truthBeTold = window.confirm("将执行删除，请谨慎操作！！！单击“确定”继续。单击“取消”停止。")
            //  /user/id/1  delete 删除id是1的user
            // 原本应该是'/systemconfig/financial/id/' + id 但在这里所有删除的方法都是一样的。所以把financial 去掉
            if (truthBeTold) {
                var self = this;
                axios({
                    method: 'delete',
                    url: '/user/id/' + id,
                    data: {
                        "id": id,
                    }
                })
                    .then(function (response) {
                        data = response.data;
                        console.log(data);
                        if ("failure" == data) { // 删除失败
                            humane.error("删除失败!!!");
                            return;
                        } else if ("exception" == data) {
                            humane.error("删除异常!!!");
                            return;
                        } else {

                            humane.success("操作成功！！！");
                            self.methodsListUser();
                        }
                    })
                    .catch(function (response) {
                        console.log(response);
                    });
            } else {
                humane.error("您取消了删除操作");
            }

        },
        create: function () {
            this.methodsListUser();
        }

    },
    watch: {
        // user: { // 这是添加用户用到的user
        //     id: 0,
        //     userCode: "",
        //     userName: "",
        //     userPassword: "",
        //     creationTime: "",
        //     lastLoginTime: "",
        //     lastUpdateTime: "",
        //     isStart: 1,
        //     roleId: 0,
        //     roleName: "",
        //
        // }
        "user.userName": function (value) {
            var uPattern = /^[\u4e00-\u9fff\w]{2,20}$/;
            if (this.user.userName == "") { //非空验证
                // 如果当前的内容为空
                this.message.message2 = "<span>*请输入您的用户名称！</span>";
                this.addMessage.message2 = false;
            } else if (!uPattern.test(this.user.userName)){ //正则验证，
                this.message.message2 = "<span >*您输入的字符不合规则！［中英文且2至20个自符］</span>";
                this.addMessage.message2 = false;
            } else { //数据库验证
                this.message.message2 = "<span >*符合规则，数据库验证中...</span>";
                var self = this;
                axios({
                    method: "get",
                    url: "/user/exist",
                    params:
                    {
                    "userName": self.user.userName,
                    }
                })
                    .then(function (response) {
                        console.log(response);
                        data = response.data;

                        if (data == "failure") {
                            self.message.message2 = "<span style='color: #4A74BC'>*您可以使用此名称</span>";
                            self.addMessage.message2 = true;
                        } else {
                            self.message.message2 = "<span >*此账号已被使用，请换用其他账号！</span>";
                            self.addMessage.message2 = false;
                        }

                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            }
        },
        "user.userCode": function (value) {
            var uPattern = /^[a-zA-Z0-9_-]{4,16}$/;
            if (this.user.userCode == "") { //非空验证
                // 如果当前的内容为空
                this.message.message1 = "<span>*请输入您的用户名称！</span>";
                this.addMessage.message1 = false;
            } else if (!uPattern.test(this.user.userCode)){ //正则验证，
                this.message.message1 = "<span >*您输入的字符不合规则！［中英文且2至20个自符］</span>";
                this.addMessage.message1 = false;
            } else { //数据库验证
                this.message.message1 = "<span >*符合规则，数据验证中...</span>";
                var self = this;
                axios({
                    method: "get",
                    url: "/user/exist",
                    params:
                        {
                            "userCode": self.user.userCode,
                        }
                })
                    .then(function (response) {
                        console.log(response);
                        data = response.data;
                        if (data == "failure") {
                            self.message.message1 = "<span style='color: #4A74BC'>*您可以使用此名称</span>";
                            self.addMessage.message1 = true;
                        } else {
                            self.message.message1 = "<span >*此账号已被使用，请换用其他账号！</span>";
                            self.addMessage.message1 = false;
                        }

                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            }
        },
        "user.userPassword": function (value) {
            var uPattern = /^\w{6,18}$/;
            if (this.user.userPassword == "123456") {
                this.message.message3 = "<span style='color: #4A74BC'>*默认初始密码123456！</span>";
                this.addMessage.message3 = true;
            } else
            if (this.user.userPassword == "") { //非空验证
                // 如果当前的内容为空
                this.message.message3 = "<span >*请输入您的密码！</span>";
                this.addMessage.message3 = false;
            } else if (!uPattern.test(this.user.userPassword)){ //正则验证，
                this.message.message3 = "<span >*长度在6~18之间</span>";
                this.addMessage.message3 = false;
            } else { //
                this.message.message3 = "<span style='color: #4A74BC'>*您的密码设置成功</span>";
                this.addMessage.message3 = thePage;
            }
        },
        "selectUser.userName": function (value) {
            var uPattern = /^[\u4e00-\u9fff\w]{2,20}$/;
            var self = this;
            this.methodsListUser();
            // 如果没有改变则一定是合适的
            if (self.selectUser.userName == this.saveMessage.message2 ) {
                self.message.message5 = "<span style='color: #4A74BC'>*您的用户名未做更改！</span>";
                self.updateMessage.message2 = true;
            }
            else if (!uPattern.test(this.selectUser.userName)){ //正则验证，
                self.message.message5 = "<span >*您输入的字符不合规则！［中英文且2至20个自符］</span>";
                self.updateMessage.message2 = false;
            } else { //数据库验证
                self.message.message5 = "<span >*符合规则，数据库验证中...</span>";

                axios({
                    method: "get",
                    url: "/user/exist",
                    params:
                        {
                            "userName": self.user.userName,
                        }
                })
                    .then(function (response) {
                        console.log(response);
                        data = response.data;

                        if (data == "failure") {
                            self.message.message5 = "<span style='color: #4A74BC'>*可以使用</span>";
                            self.updateMessage.message2 = true;
                        } else {
                            self.message.message2 = "<span >*此账号已被使用，请换用其他账号！</span>";
                            self.updateMessage.message2 = false;
                        }

                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            }
        },
        "selectUser.userCode": function (value) {
            var uPattern = /^[a-zA-Z0-9_-]{4,16}$/;
            this.methodsListUser();
            if (this.selectUser.userCode == this.saveMessage.message1 ) {
                this.message.message4 = "<span style='color: #4A74BC'>*您的账号未做更改！</span>";
                this.updateMessage.message1 = true;
            } else if (!uPattern.test(this.selectUser.userCode)){ //正则验证，
                this.message.message4 = "<span >*您输入的字符不合规则！［中英文且2至20个自符］</span>";
                this.updateMessage.message1 = false;
            } else { //数据库验证
                this.message.message4 = "<span >*符合规则，数据验证中...</span>";
                var self = this;
                axios({
                    method: "get",
                    url: "/user/exist",
                    params:
                        {
                            "userCode": self.user.userCode,
                        }
                })
                    .then(function (response) {
                        console.log(response);
                        data = response.data;
                        if (data == "failure") {
                            self.message.message4 = "<span style='color: #4A74BC'>*您可以使用此名称</span>";
                            self.updateMessage.message1 = true;
                        } else {
                            self.message.message4 = "<span >*此账号已被使用，请换用其他账号！</span>";
                            self.updateMessage.message1 = false;
                        }

                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            }
        },
        "selectUser.userPassword": function (value) {
            var uPattern = /^\w{6,18}$/;
            if (this.selectUser.userPassword == "123456") {
                this.message.message6 = "<span style='color: #4A74BC'>*默认初始密码123456！</span>";
                this.updateMessage.message3 = true;
            }  else if (!uPattern.test(this.selectUser.userPassword)){ //正则验证，
                this.message.message6 = "<span >*长度在6~18之间</span>";
                this.updateMessage.message3 = false;
            } else { //
                this.message.message6 = "<span style='color: #4A74BC'>*通过</span>";
                this.updateMessage.message3 = true;
            }
        }
    }


})

// 结束之后调用获得user列表的方法


v.methodsListUser();

