$(function(){
	mover(1);
})

var v = new Vue({
    el:'#app',
    data: {
        customs: {
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
		items: [],
        PageNumberList: { // 分页元素2
            thePage: 1,
            prevList: [],
            nextList: []
        },
        search: { // 分页元素3
            thePage: 1,
            customName: ""

        }
    },
	methods: {
    	methodListCustoms: function () {
    		// 获取列表的方法
            var self = this;
            var paramsMessage = { //分页元素6   前端页面分页 6元素不可缺。
                "thePage": this.search.thePage
            };
            /** 分页需修改的地地方 有几个条件按如下格式添加几个条件 */
            if (this.search.customName != "") {
                paramsMessage.customName = this.search.customName;
            }

            axios({
                method: "GET",
                url: "/customs/json",
                params: paramsMessage
            })
                .then(function (response) {
                    /** 直接复制的内容，后端要把 pageNumber类 与 list 放到map的json中    */
                	var data = JSON.parse(response.data)
                    self.items = data["list"];
                    self.PageNumberList.nextList = data["pageNumber"].nextList;
                    self.PageNumberList.prevList = data["pageNumber"].prevList;
                })
                .catch(function (error) {
                    console.log(error);
                });



        },
        methodtoPage(number) { // 分页元素4
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
            this.PageNumberList.thePage = number;
            // 这个方法是把当前的页码传入搜索类
            this.search.thePage = number;
            this.methodtoPageUpdate();
        },
        /**
         * 需要修改
         * 需要修改
         * 需要修改
         * @param value
         */
        methodtoPageUpdate : function () { // 分页元素5
            // 这个方法是重新调用列表类
            this.methodListCustoms();
        },
        methodToViewCustoms: function (id) {
            // 获得需要查看的id 根据id跳转页面
            window.location.href = "/customs/id/" + id;
        },
        methodToUpdateCustoms: function (id) {
            window.location.href = "/customs/view/" + id;
        },
        methodChangeStateOpen: function (id, value, index) {

            var self = this;
            var paramsMessage = {
                "id":id,
                "customStatus": value
            };
            axios({
                method: "put",
                url: "/customs/state",
                data: paramsMessage
            })
                .then(function (response) {
                    data = response.data;
                    if (data == "success") {
                        self.items[index].customStatus = value;
                    } else {
                        humane.error("修改失败。");
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });


        },

        methodNameSearch() {
            this.methodListCustoms();

        }

	},
    mounted() {
        this.methodListCustoms()
    }
})
// /** 代理商id */
// private Integer agentId;
// /** 代理商的名称 */
// private String agentName;
// /** 代理商的编码 */
// private String  agentCode;
// /** 企业名称 */
// private String customName;
// /** 企业类型 值 */
// private Integer customType;
// /** 企业类型名称 */
// private String customTypeName;
// /** 企业主页 */
// private String siteUrl;
// /** 状态 */
// private Integer customStatus;
// /** 法人 */
// private String bossName;
// /** 证件类型 */
// private Integer cardType;
// /** 证件类型值 */
// private String cardTypeName;
// /** 证件号码 */
// private String cardNum;
// /** 电话 */
// private String companyTel;
// /** 传真 */
// private String companyFax;
// /** 时间 */
// private Date regDatetime;
// /** 国家 */
// private String country;
// /** 省 */
// private String province;
// /** 市 */
// private String city;
// /** 区 */
// private String area;
// /** 地址 */
// private String companyAddress;
// /** 备注 */
// private String memo;
