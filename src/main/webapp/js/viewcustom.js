$(function(){
	mover(1);
})
var v = new Vue({
    el:'#app',
    data: {
        customs: {
            id: 0,
            agentId: 0,
            agentName: "",
            agentCode: "",
            customName: "",
            customType: 0,
            customTypeName: "",
            siteUrl: "",
            customStatus: 0,
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

        },
        listContacts: []
    },
    mounted() {
        this.methodGetCustoms();
    },
    methods: {
        methodGetCustoms: function () {


            var self = this;
            var paramsMessage = {
                "id": urlId,
            };
            axios({
                method: "GET",
                url: "/customs/id/json",
                params: paramsMessage
            })
                .then(function (response) {
                    console.log(response)
                    data = JSON.parse(response.data);
                    self.customs = data;
                    self.methodGetProvince();
                    self.methodGetCity();
                    self.methodGetArea();
                    self.methodGetContacts();
                    self.methodUpdateMessage();
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        // 获取所有的 contacts， 这个方法肯定要在 methodGetCustoms 之后执行
        methodGetContacts: function () {
            if (0 == this.customs.id) { // 如果当前的customsid为0那就没有做列表的必要了
                return false;
            }
            var self = this;
            var paramsMessage = { // 获得当前所有customId下的contacts
                "id": self.customs.id,
            };
            axios({
                method: "GET",
                url: "/contacts/json",
                params: paramsMessage
            })
                .then(function (response) {
                    data = JSON.parse(response.data);
                    self.listContacts = data;
                })
                .catch(function (error) {
                    console.log(error);
                });


        },
        methodGetProvince: function () {
            var self = this;
            var paramsMessage = {
                "provinceID":self.customs.province,
            };
            axios({
                method: "GET",
                url: "/address/province/provinceID",
                params: paramsMessage
            })
                .then(function (response) {
                    data = JSON.parse(response.data);
                    self.customs.province = data.province;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        methodGetCity: function () {
            var self = this;
            var paramsMessage = {
                "cityID":self.customs.city,
            };
            axios({
                method: "GET",
                url: "/address/city/cityID",
                params: paramsMessage
            })
                .then(function (response) {
                    data = JSON.parse(response.data);
                    self.customs.city = data.city;
                })
                .catch(function (error) {
                    console.log(error);
                });

        },
        methodGetArea: function () {
            var self = this;
            var paramsMessage = {
                "areaID":self.customs.area,
            };
            axios({
                method: "GET",
                url: "/address/area/areaID",
                params: paramsMessage
            })
                .then(function (response) {
                    data = JSON.parse(response.data);
                    self.customs.area = data.area;
                })
                .catch(function (error) {
                    console.log(error);
                });

        },
        methodUpdateMessage() {
          this.customs.province =  this.messageCustoms.province
          this.customs.city =  this.messageCustoms.city
          this.customs.area =  this.messageCustoms.area

        }
	}
})



