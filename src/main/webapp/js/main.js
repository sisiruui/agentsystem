
$(function(){
	mover(1);
})

var main = new Vue({
    el:'#mainapp',
    data: {
        condition: {
            updatediv: false
        },
        loginUser: {
            id: 0,
            oldPassword: "",
            newPassword: "",
            confirmPassword: ""
        },
        message: {
            message1: "您本次登陆时的密码",
            message2: "新密码不少于6个字符",
            message3: "新密码不少于6个字符",
        },
        isok:{
            message1: false,
            message2: false,
            message3: false,

        }
    },
	methods: {
    	methodOpenUpdate : function () {
            this.condition.updatediv = !this.condition.updatediv;
        },
        methodCloseUpdate: function () {
            this.condition.updatediv = false;
        },
        methodInvalidate: function () {
    	    alert("n")
            axios({
                method: "GET",
                url: "/user/invalidate",
            })
                .then(function (response) {
                    console.log(response);
                    window.location.href = '/';
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        methodUpdateUserPassword: function () {
            if (this.isok.message1 == false || this.isok.message2 == false
                || this.isok.message3 == false) {
                humane.error("请检查信息，未通过验证。");
            } else{
                this.loginUser.id =  user_id;
                var self = this;
                var paramsMessage = {
                    "userPassword":self.loginUser.confirmPassword,
                    "id": self.loginUser.id
                };
                axios({
                    method: "put",
                    url: "/user/id/" + self.loginUser.id,
                    data: paramsMessage
                })
                    .then(function (response) {
                        data = response.data;
                        if (data == "success") {
                            humane.success("密码已修改成功，请使用您的新密码登录账号。3秒后跳转登录页");

                            window.location.href = '/user/invalidate';

                        } else {
                            humane.error("密码修改失败。");
                        }
                    })
                    .catch(function (error) {
                        console.log(error);
                    });



            }



        },



	},
    watch: {
        "loginUser.oldPassword": function (value) {
            this.loginUser.id =  user_id;

            var self = this;
            var uPattern = /^\w{6,18}$/;
            if (this.loginUser.oldPassword == "") { // 非空时候的提醒
                this.message.message1 = "您本次登陆时的密码";
                self.isok.message1 = false;
            } else if (!uPattern.test(this.loginUser.oldPassword)) { // 格式正则验证
                this.message.message1 = "您输入的密码格式不正确";
                self.isok.message1 = false;
            } else { // 数据库验证
                this.message.message1 = "正在进行数据库验证请稍后！！！"
                self.isok.message1 = false;
                // axios get 的基本格式

                var paramsMessage = {
                    "userPassword":self.loginUser.oldPassword,
                    "id": self.loginUser.id
                };
                axios({
                    method: "GET",
                    url: "/user/check",
                    params: paramsMessage
                })
                    .then(function (response) {
                        data = response.data;
                        if (data == "success") {
                            self.isok.message1 = true;
                            self.message.message1 = "您的密码输入正确。"
                        } else if(data == "exception") {
                            self.isok.message1 = false;
                            self.message.message1 = "请求错误，!!!"
                        }  else {
                            self.isok.message1 = false;
                            self.message.message1 = "你的密码输入错误，!!!"
                        }
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            }



        },
        "loginUser.newPassword": function (value) {
            var uPattern = /^\w{6,18}$/;
            if (this.loginUser.newPassword == "") { // 非空时候的提醒
                this.message.message2 = "新密码不少于6个字符";
            } else if (!uPattern.test(this.loginUser.newPassword)) { // 格式正则验证
                this.message.message2 = "您输入的密码格式不正确";
                this.isok.message2 = false;
            } else { // 数据库验证
                this.message.message2 = "你的密码可以使用。";
                this.isok.message2 = true;
            }
        },
        "loginUser.confirmPassword": function (value) {
            var uPattern = /^\w{6,18}$/;
            if (this.loginUser.confirmPassword == "") { // 非空时候的提醒
                this.message.message3 = "新密码不少于6个字符";
            } else
            if (this.isok.message == false) {
                this.message.message3 = "请先通过上面的验证";
                this.isok.message3 = false;
            } else if (this.loginUser.newPassword != this.loginUser.confirmPassword) {
                this.message.message3 = "您输入的信息不一致";
                this.isok.message3 = false;
            } else {
                this.message.message3 = "你的密码可以使用。";
                this.isok.message3 = true;
            }



        }



    }
})

