
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
        SystemConfig: { // 显示的对象
            configType: 1,
            configTypeName: "",
            configTypeValue: 0,
            configValue: "",
            isStart: 1,
        },


    },
    methods: {

        updateSystemConfig: function () {  // 执行修改

            // 将 selectSystemConfig 保存 financial.js  /user/id/1  put 更新id是1的user
            var self = this;

            axios({
                method: 'put',
                url: '/systemconfig/id/' + self.SystemConfig.id,
                data: {
                    "id": self.SystemConfig.id,
                    "configValue": self.SystemConfig.configValue

                }
            })
                .then(function (response) {

                    data = response.data;
                    if (data < 1) { // 修改
                        humane.error("修改失败，您的页面可能已经过期，请刷新您的页面！");
                        return;
                    } else {
                        self.condition.updatediv = true;
                        self.$set(self.items[0], "configValue", self.SystemConfig.configValue);


                        // self.$forceUpdate();
                        humane.success("操作成功！！！");
                    }

                })
                .catch(function (response) {
                    console.log(response);
                });


        },




        created: function () {
            var self = this;
            axios({
                method: "GET",
                url: "/systemconfig/json",
                params:{
                    configType: 3,
                }
            })
                .then(function (response) {
                    self.items = JSON.parse(response.data);
                    self.SystemConfig = self.items[0];
                    self.$set(self.SystemConfig, "configTypeName", self.items[0].configTypeName);
                    self.$set(self.SystemConfig, "configValue", self.items[0].configValue);
                    self.$set(self.SystemConfig, "id", self.items[0].id);

                })
                .catch(function (error) {
                    console.log(error);
                });
        },
    },
    computed: {}
})
v.created()







