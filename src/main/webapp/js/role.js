mover(4);
var v = new Vue({
    el: '#app',
    data: {
        items: [],
        condition: {
            adddiv: false,
            updatediv: false
        },
        indexflag: -1,
		role: {
        	id: -1,
            roleName: "",
            creationTime: "",
            createdBy: "",
            lastUpdateTime: "",
            isStart: 1
		},
        updateRole: {
            id: -1,
            roleName: "",
            creationTime: "",
            createdBy: "",
            lastUpdateTime: "",
            isStart: 1
        }




    },
    methods: {
        openAddDiv: function () { // 打开 添加财务类型
            this.condition.adddiv = !this.condition.adddiv
        },
        closeAddDiv: function () { // 关闭 添加财务类型
            this.condition.adddiv = false;
        },
        openUpdateDiv: function (index, id) { // 点击添加div 修改数据

            this.condition.updatediv = !this.condition.updatediv
            // 复制对象
            this.updateRole =
                JSON.parse(JSON.stringify(this.items[index]))
            this.indexflag = index;



        },
        updateRoless: function () {  // 执行修改

            // 将 selectSystemConfig 保存 financial.js  /user/id/1  put 更新id是1的user
            var self = this;

            axios({
                method: 'put',
                url: '/role/id/' + self.updateRole.id,
                data: {
                    "thePage": self.updateRole.id,

                }
            })
                .then(function (response) {

                    data = response.data;
                    if (data < 1) { // 修改失败
                        humane.error("修改失败，您的页面可能已经过期，请刷新您的页面！");
                        return;
                    } else {

                        self.$set(self.items[self.indexflag], "roleName", self.updateRole.roleName);
                        self.$set(self.items[self.indexflag], "isStart", self.updateRole.isStart);
                        // self.$forceUpdate();
                        self.condition.updatediv = false;
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

        addRole: function () { // 这是添加配置的方法
            // 获得 role 对象的 roleName 与 isStart
            if (this.role.roleName == "") {
                humane.error("类型名称不可以为空。");
                return false;
            } else {
                // 获得vue对象role的基础信息。然后发送到后台 使用post提交
                var self = this;

                axios.post('/role', {
                    roleName: this.role.roleName,
                    isStart: this.role.isStart
                }).then(function (response) {
                    console.log(response);
                    data = JSON.parse(response.data);
                    // 如果没有插入成功 则放回 failuer 就不要执行了
                    if ("missing" == data) {
                        humane.error("您没有输入正确的内容！");
                        return false;
                    } else if ("failure" == data) {
                        humane.error("添加失败，请检查您输入的数据！");
                        return false;
                    } else if ("exception" == data) {
                        humane.error("请检查您时否已经添加过此数据。");
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
                    url: '/role/id/' + id,

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
                url: "/role/json",

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























//
//
//
//
// $(function(){
//
// 	mover(4);
// 	//点击新增的事件
// 	$("#addRole").on("click",function(){
// 		$("#addRoleDiv").css("display","block");
//
//
// 	});
//
// 	//点击新增后取消的事件
// 	$("#addcancel").on("click",function(){
// 		$("#addRoleDiv").css("display","none");
//
//
// 	});
//
// 	//点击新增后的事件
// 	$("#addRoleSubmit").on("click",function(){
//
//
//
//
// 		//获取角色名称
// 		var rolename =	$("#a_roleName").val();
// 		if($.trim(rolename)==""){
// 			humane.error("角色名不能为空");
// 			return false;
//
// 		}
// 		var isStart = $("#a_isStart").val();
// 		//获取之后执行在ajax添加到后台
// 		$.ajax({
//             url:"/role/add.do",
//             type:"post",
//             data:{"rolename":rolename,"isStart":isStart},
//             dataType: "html",
//             success:function(data){
//
//              if(data=="success"){
//             	  humane.error("添加角色【"+rolename+"】成功");
//             	  window.location.href = '/role/list.do';
//              } else{
//             	  humane.error("添加角色失败。");
//               }
//             },
//             error:function(e){
//                 alert("ajax系统错误！！");
//             }
//         });
// 	});
//
// 	//关闭修改列表
// 	$("#modifycancel").on("click",function(){
// 		$(".modifyback").css("display","none");
// 	});
//
// 	//保存修改
//
// 	$("#modifyRoleSubmit").on("click",function(){
// 		//获取角色名称
// 		var rolename =	$("#m_roleName").val();
//
// 		if($.trim(rolename)==""){
// 			humane.error("角色名不能为空");
// 			return false;
//
// 		}
// 		var isStart = $("#a_isStart_updata").val();
// 		var id = $("#m_roleId").val();
//
//
// 		//获取之后执行在ajax添加到后台
// 		$.ajax({
//             url:"/role/update.do",
//             type:"post",
//             data:{"rolename":rolename,"isStart":isStart,"id":id},
//             dataType: "html",
//             success:function(data){
//
//              if(data=="success"){
//             	  humane.error("修改成功");
//             	  window.location.href = '/role/list.do';
//              } else{
//             	  humane.error("修改失败。");
//               }
//             },
//             error:function(e){
//                 alert("ajax系统错误！！");
//             }
//         });
//
//
// 	});
//
//
// });
//
// function roleupdate(e,id){
// 	//当点击的时候，展开列表
// 	$(".modifyback").css("display","block");
// 	//获取名称
// 	var rolename= $(e).parent().parent().prev().prev().prev().text();
//
// 	$("#m_roleName").val(rolename);
// 	$("#m_roleId").val(id);
//
// 	//获取状态
//
//
//
//
// }
//
// function roledelete(e,id){
// 	alert(id);
// 	if(confirm("确定要删除吗？")){
// 		//当点击的时候，展开列表
// 		$.ajax({
// 	        url:"/role/delete.do",
// 	        type:"post",
// 	        data:{"id":id},
// 	        dataType: "html",
// 	        success:function(data){
//
// 	         if(data=="success"){
// 	        	  humane.error("删除成功");
// 	        	  window.location.href = '/role/list.do';
// 	         } else{
// 	        	  humane.error("修改失败。");
// 	          }
// 	        },
// 	        error:function(e){
// 	            alert("ajax系统错误！！");
// 	        }
// 	    });
//
//
// 	}else{
// 		return false;
// 	}
//
//
//
//
// 	//获取状态
//
//
//
//
// }
//
//
//
//
//
//
//
