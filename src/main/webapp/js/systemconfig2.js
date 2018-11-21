$(function(){
	mover(5);
	//实现定义type的值
	var clickTypeId = $("#selectTypeValue").val();
	//添加 弹出
	 $("#addsystemconfig").on("click",function(){
		 $("#addSystemdiv").css("display","block");
	 });
	 //添加取消
	 $("#cancleAddSystemConfigBtn").on("click",function(){
		 $("#addSystemdiv").css("display","none");
	 });
	//修改取消
	 $("#cancleModifySystemConfigBtn").on("click",function(){
		 $("#modifySystemdiv").css("display","none");
	 });
	 //修改数据
	 $("#modifySystemConfigBtn").on("click",function(){
		 //先进行校验   只简单的进行非空校验   获取配置类型
		var modifyConfigName =$.trim($("#configName").val());//获取名称
		var modifyConfigValue = $.trim($("#modifyConfigValue").val());//获取数值
		var modifyConfigTypeValue = $.trim($("#modifyConfigTypeValue").val());//获取实际数值
		//获取id  修改的时候根据id修改
		 //注意  以后都设置为方法，不再用绑定事件的方式  这个真是太烦了
		 //拿到之前放到元素里面的id  
		 var $id =$("#sid").val();
		 var isStart = $("#updateIsStartSelect").val();
		 if(modifyConfigName==""){
			 humane.error("类型名称不能为空");
			 return false;
		 } 
		 if(modifyConfigValue==""){
			 humane.error("类型数值不能为空");
			 return false;
		 }
		 if(modifyConfigTypeValue==""){
			 humane.error("实际数值不能为空");
			 return false;
		 }
		 $.ajax({
               url:"/SystemConfig/update7.do",
                type:"post",
                data:{"id":$id,
                	"configType":7,
                	"configTypeName":modifyConfigName,
                	"configTypeValue":modifyConfigTypeValue,
                	"configValue":modifyConfigValue,
                	"isStart":isStart            
               },
                dataType: "text",
                success:function(result){
                	if (result == "success") {
    					humane.error("添加成功");
    					//刷新页面
    					$(window).attr('location','/SystemConfig/preperential.do');
    					
    					
    				} else {
    					humane.error("添加失败");
    					//执行关闭添加按钮吧
    					 $("#addSystemdiv").css("display","none");
    					
    				}

                	
                 },
                error:function(result){
                    alert("ajax系统错误！！");
                }
          }); 
			
			 
		 
		 
	 });
	 
	 
	 
	 
	
	 
	 
	 

});
/**
 * 这是添加config的方法
 * @param typeid
 * @returns
 */
function addSystemConfig(typeid) {
	var addConfigName = $("#addConfigName").val();
	var addConfigValue = $("#addConfigValue").val();
	var addConfigTypeValue = $("#addConfigTypeValue").val();

	if (addConfigName == "") {
		humane.error("类型名称不能为空");
		return false;
	} else if (addConfigValue == "") {
		humane.error("类型数值不能为空");
		return false;
	} else if (addConfigTypeValue == "") {
		humane.error("实际数值不能为空");
		return false;
	} else {
		$.ajax({
			url : "/SystemConfig/financial/add7.do",
			type : "post",
			data : {
				"configType" : typeid,
				"configTypeName" : addConfigName,
				"isStart" : $("#addIsStartSelect").val(),
				"configValue" :addConfigValue,
				"configTypeValue" : $("#addConfigTypeValue").val()
			},
			dataType : "text",
			success : function(result) {
				if (result == "success") {
					humane.error("添加成功");
					//刷新页面
					$(window).attr('location','/SystemConfig/preperential.do');
				} else {
					humane.error("添加失败");
					//执行关闭添加按钮吧
					 $("#addSystemdiv").css("display","none");
					
				}

			},
			error : function(result) {
				alert("ajax系统错误！！");
			}
		});
	}
}
function systemConfigDelete(e,id){
	 if(confirm("确定删除吗？")){
			 $.ajax({
	            url:"/SystemConfig/financial/delete.do",
	             type:"post",
	             data:{"id":id},
	             dataType: "html",
	             success:function(data){
	           	if(data=="delete"){
	           		$(e).parent().parent().parent().remove();
	             	}else{
	             		alert("删除失败");
	             	}
	             },
	             error:function(data){
	                 alert("ajax系统错误！！");
	             }
	         }); 
		}else{
			return false;
		}	
}


	function systemConfigUpdate(e,id){
		$("#modifySystemdiv").css("display","block");
		//附id
		$("#sid").val(id);
		$("#configName").val($(e).parent().parent().prev().prev().prev().prev().text());
		$("#modifyConfigValue").val($(e).parent().parent().prev().prev().prev().text());
		$("#modifyConfigTypeValue").val($(e).parent().parent().prev().prev().text());
		$("#modifyConfigTypeValue").val();
		
		if($.trim($(e).parent().parent().prev().text())=="关闭"){
		
			$("#updateIsStartSelect option:eq(1)").attr("selected","selected");
			
			
		}
		
	
	}







