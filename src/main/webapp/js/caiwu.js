

$().ready(function(){
	mover(4);
	// 这是查找用户的方法
	$(document).on("keyup click", "#searchUserText",function() {
		loadUsers();
	});
	/**
	 * 这是财务管理 操作的程序 具体的逻辑是根据正负数据操作表中的用户的money值 这个是在 account表
	 * 操作成功后 在accountdatail表中添加数据
	 */
	$("#caiwuok").on("click",function() { // 进行前置的一些判断

		if ($("#checkId").val() == "") {// 搜索用户提示框没有做选择
			humane.error("对不起，您还没有选择用户，请搜索进行用户选择");
		} else if ($("#zijintype").val() == ""|| $("#zijintype").val() == 0) {
			humane.error("对不起，您还没有选择类型，请选择");// 就不做判断了
		} else if ($("#zijin").val() == 0) {// 改type为number
			// 限制输入
			humane.error("对不起，您还没有输入金额，请输入金额。");
		} else {
			if (confirm("确认要执行当前操作吗？")) { // 把当前的内容添加到后台
								// //关系到金额
								// 输入确认

				$.ajax({
						// 把数据全部传入过去
						// 本页可以传过去的数据有 操作类型
						// 操作资金 操作备注
						url : '/AccountDetail/update.do',
						type : "post",
						data : {
							"userId" : $("#checkId").val(),// 用户id
							"userName" : $("#searchUserText").val(), // 用户code
							"money" : $("#zijin").val(),// 操作资金
							"zijintype" : $("#zijintype").val(),// 操作类型
							"memo" : $("#memo").val(),
							"zijintypeValue" : $("#zijintype option:checked").text()
						},
						dataType : 'html',
						success : function(data) {
							if (data == "success") {
								humane.success("操作成功。");
							} else {
								humane.error("操作失败。");
							}

						},
						error : function(data) {
							humane.success("程序执行错误。");
						}
					});

				}

			}

		});

});

// 这个是根据关键词模糊查找用户数据的
function loadUsers() {

	$.ajax({
		url : '/user/seacchFuzzyQueryCode.do',
		type : "post",
		async : false,
		data : {
			"user.userCode" : $("#searchUserText").val()
		},
		dataType : 'json',
		success : function(data) {
			// data是json数组
			var userList = "<ul>";
			for (var i = 0; i < data.length; i++) {
				userList = userList + "<li onclick=\"confirmUser('"
						+ data[i].id + "','" + data[i].userCode + "')\">"
						+ data[i].userCode + "</li>";
			}
			userList = userList + "</ul>";

			$("#serachresult").html(userList);
		}
	});
}

function confirmUser(uid, ucode) {
	$("#checkId").val(uid);
	$("#searchUserText").val(ucode);
	$("#serachresult").html("");

}
