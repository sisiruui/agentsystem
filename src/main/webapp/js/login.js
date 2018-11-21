// $(function () {
    var vm = new Vue({
        el:'#app',
        data: {
            user: {
                userCode: "",
                password: ""
            }

        },
        methods : {
            loginsubmit: function (event) {

                if (this.user.userCode == "") {
                    humane.error("账号名不能为空，请注意，系统将忽略首尾的空格。");
                    return false;
                } else if (this.user.password == "") {
                    humane.error("密码名不能为空，请注意，系统将忽略首尾的空格。");
                    return false;
                } else {

                    axios({
                        url: '/user/message/login',
                        method: 'post',
                        responseType: 'json', // 默认的
                        data: {
                            //'a': 1,
                            //'b': 2,
                            "userCode": this.user.userCode,
                            "userPassword": this.user.password

                        }
                    }).then(function (response) {

                       if ("noinput" == response.data) {
                            humane.error("请输入您的账号与密码。");
                        } else if ("nousercode" == response.data) {
                            humane.error("请输入您的账号。");
                        } else if ("nopassword" == response.data) {
                            humane.error("请输入您的密码。");
                        } else if ("nouser" == response.data) {
                            humane.error("您的账号或密码有误，请重试。");
                        } else if ("success" == response.data) {

                            window.location.href = '/user/href/balance';
                        } else {
                            alert(response.data)
                            humane.error("未知错误");
                        }
                    }).catch(function (error) {
                        console.log(error);
                    })
                }





                
            }
        }
    })



    // $("#userSubmit").on("click", function () {
    //     var usercode = $.trim($("#userCode").val());
    //     var userpassword = $.trim($("#userPassword").val());
    //
    //     if (usercode == "" || usercode == null) {
    //         $("#userCode").focus();
    //         humane.error("账号名不能为空，请注意，系统将忽略首尾的空格。");
    //         return false;
    //     } else if (userpassword == "" || userpassword == null) {
    //         $("#userPassword").focus();
    //         humane.error("密码名不能为空，请注意，系统将忽略首尾的空格。");
    //         return false;
    //     } else {
    //



            // $.ajax({
            //     url: '/user/message/login',
            //     type: "post",
            //     contentType : 'application/json;charset=UTF-8',
            //     data:
            //         JSON.stringify({
            //             "userCode": usercode,
            //             "userPassword": userpassword
            //         }) ,
            //     dataType: 'json',
            //     success: function (data) {
            //
            //         if ("noinput" == data) {
            //             humane.error("请输入您的账号与密码。");
            //         } else if ("nousercode" == data) {
            //             humane.error("请输入您的账号。");
            //         } else if ("nopassword" == data) {
            //             humane.error("请输入您的密码。");
            //         } else if ("nouser" == data) {
            //             humane.error("您的账号或密码有误，请重试。");
            //         } else if ("success" == data) {
            //
            //             window.location.href = '/user/href/balance';
            //         } else {
            //             alert(data)
            //             humane.error("未知错误");
            //         }
            //
            //     },
            //     error: function (e) {
            //         humane.error("ajax未知错误");
            //     }
            // });


            // alert("n")
            // axios({
            //     url: '/user/message/login',
            //     method: 'post',
            //     responseType: 'json', // 默认的
            //     data: {
            //         //'a': 1,
            //         //'b': 2,
            //         "userCode": usercode,
            //         "userPassword": userpassword
            //
            //     }
            // }).then(function (response) {
            //
            //    if ("noinput" == response.data) {
            //         humane.error("请输入您的账号与密码。");
            //     } else if ("nousercode" == response.data) {
            //         humane.error("请输入您的账号。");
            //     } else if ("nopassword" == response.data) {
            //         humane.error("请输入您的密码。");
            //     } else if ("nouser" == response.data) {
            //         humane.error("您的账号或密码有误，请重试。");
            //     } else if ("success" == response.data) {
            //
            //         window.location.href = '/user/href/balance';
            //     } else {
            //         alert(response.data)
            //         humane.error("未知错误");
            //     }
            // }).catch(function (error) {
            //     console.log(error);
            // })
            //

        // }


    // });


// });
