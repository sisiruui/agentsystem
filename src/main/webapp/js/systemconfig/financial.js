mover(5);
var v = new Vue({
    el: '#app',
    data: {
        items: [],
        condition: {
            adddiv: false,
            updatediv: false
        },
        index: -1,
        SystemConfig: {
            configType: 1,
            configTypeName: "",
            configTypeValue: 0,
            configValue: "",
            isStart: 1,
        },
        selectSystemConfig: {
            configType: 1,
            configTypeName: "",
            configTypeValue: 0,
            configValue: "",
            isStart: 1

        }

    },
    methods: {
        openAddDiv: function () { // 打开 添加财务类型
            this.condition.adddiv = !this.condition.adddiv
            this.SystemConfig.configTypeName = "";

        },
        closeAddDiv: function () { // 关闭 添加财务类型
            this.condition.adddiv = false;
        },
        openUpdateDiv: function (index, id) { // 点击添加div 修改数据

            this.condition.updatediv = !this.condition.updatediv
            // 复制对象
            this.selectSystemConfig =
                JSON.parse(JSON.stringify(this.items[index]))
            this.indexflag = index;


        },
        updateSystemConfig: function () {  // 执行修改

            // 将 selectSystemConfig 保存 financial.js  /user/id/1  put 更新id是1的user
            var self = this;

            axios({
                method: 'put',
                url: '/systemconfig/id/' + self.selectSystemConfig.id,
                data: {
                    "id": self.selectSystemConfig.id,
                    "configTypeName": self.selectSystemConfig.configTypeName,
                    "isStart": self.selectSystemConfig.isStart

                }
            })
                .then(function (response) {

                    data = response.data;
                    if (data < 1) { // 删除失败
                        humane.error("修改失败，您的页面可能已经过期，请刷新您的页面！");
                        return;
                    } else {
                        self.condition.updatediv = true;
                        self.$set(self.items[self.indexflag], "configTypeName", self.selectSystemConfig.configTypeName);
                        self.$set(self.items[self.indexflag], "isStart", self.selectSystemConfig.isStart);
                        // self.$forceUpdate();
                        humane.success("操作成功！！！");
                    }

                })
                .catch(function (response) {
                    console.log(response);
                });


        },

        closeUpdateDiv: function () {
            this.condition.updatediv = false;
        },

        addSystemConfig: function () { // 这是添加配置的方法

            if (this.SystemConfig.configTypeName == "") {
                humane.error("类型名称不可以为空。");
                return false;
            } else {
                //    获取当前的SystemConfig
                //     this.SystemConfig.configType = 1;
                // this.SystemConfig.configTypeName; // 这个取自表单
                // this.SystemConfig.configTypeValue; // 这个数据由JAVA操作
                // this.SystemConfig.configValue = ""; // 这个为空
                // this.SystemConfig.isStart ; // 这个取自表单
                // 先执行数据库操作 以post 提交到 /systemconfig/financial
                var self = this;
                axios.post('/systemconfig/financial', {
                    configType: 1,
                    configTypeName: this.SystemConfig.configTypeName,
                    configTypeValue: "NULL",
                    isStart: this.SystemConfig.isStart
                }).then(function (response) {
                    console.log(response);
                    data = JSON.parse(response.data);
                    // 如果没有插入成功 则放回 failuer 就不要执行了
                    if (data == "nohave") {
                        humane.error("您没有输入正确的内容！");
                        return false;
                    } else if (data == "failuer") {
                        humane.error("插入失败，请检查您输入的数据！");
                        return false;
                    } else {  // 如果插入成功，则返回json，并添加到 items中。
                        console.log(data);
                        self.items.push(data);
                        self.closeAddDiv();
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
            }
        },
        removeTodo: function (index, id) {
            var truthBeTold = window.confirm("将执行删除，请谨慎操作！！！单击“确定”继续。单击“取消”停止。")
            //  /user/id/1  delete 删除id是1的user
            // 原本应该是'/systemconfig/financial/id/' + id 但在这里所有删除的方法都是一样的。所以把financial 去掉
            if (truthBeTold) {
                var self = this;
                axios({
                    method: 'delete',
                    url: '/systemconfig/id/' + id,
                    data: {
                        "id": id,
                    }
                })
                    .then(function (response) {
                        data = response.data;
                        if (data < 1) { // 删除失败
                            humane.error("删除失败，您的页面可能已经过期，请更新您的页面！");
                            return;
                        } else {
                            self.items.splice(index, 1);
                            humane.success("操作成功！！！");
                        }
                    })
                    .catch(function (response) {
                        console.log(response);
                    });
            } else {
                humane.error("您取消了删除操作");
            }

        },
        Toggle: function () {
            this.ok = !this.ok;
        },

        created: function () {
            var self = this;
            axios({
                method: "GET",
                url: "/systemconfig/json",
                 params:{
                     configType: 1,
                 }
            })
            .then(function (response) {
                self.items = JSON.parse(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });

        },
    },
    computed: {}
})
v.created()







