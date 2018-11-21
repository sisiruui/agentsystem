$(function(){
	mover(5);
	//实现定义type的值
	var clickTypeId = $("#selectTypeValue").val();
	 $("#addsystemconfig").on("click",function(){
		 $("#addSystemdiv").css("display","block");
	 });
	 //点击取消
	 $("#cancleAddSystemConfigBtn").on("click",function(){
		 $("#addSystemdiv").css("display","none");
	 });
	//点击取消
	 $("#cancleModifySystemConfigBtn").on("click",function(){
		 $("#modifySystemdiv").css("display","none");
	 });
	 //修改数据
	 $("#modifySystemConfigBtn").on("click",function(){
		 //先进行校验   只简单的进行非空校验   获取配置类型
		 var updateConfigName =$("#configName").val();//获取名称
		var modifyConfigValue = $("#modifyConfigValue").val()//获取数值
		 //获取id  修改的时候根据id修改
		 //注意  以后都设置为方法，不再用绑定事件的方式  这个真是太烦了
		 //拿到之前放到元素里面的id  
		 var $id =$("#sid").val();
		 
		 var isStart = $("#updateIsStartSelect").val();
		 //获取一个值给
		 var idtable = parseInt($("#idtable").val())-1;
		 alert(idtable);
		 //值已经都拿到了  直接传过去   三个值   id  ConfigName   isstart
		 if(clickTypeId==2){
			 if($.trim(modifyConfigValue)==""){
				 alert("数值名称不能为空");
			 }
		 }
		 
		 if($.trim(addConfigName)==""){
			 alert("类型名称不能为空");
		 }else{ 
			 $.ajax({
	               url:"/SystemConfig/financial/update.do",
	                type:"post",
	                data:{"updateConfigName":updateConfigName,"isStart":isStart,
	                	"id":$id,"modifyConfigValue":" "+modifyConfigValue+" ","typeid":$("#selectTypeValue").val()
	                },
	                dataType: "json",
	                success:function(data){
	                	//返回的数据又可能是空
	                	alert(data.configTypeName);
	                	if(data==""){
	                		humane.error("修改失败");
	                		
	                	}else{
	                		//获取到json的数据       ，然后应用变化   这个还要应用变化   这个要死人了
	                		humane.error("修改成功");
	                	
	                		//获得tr
	                		  var h = $(document).height()-$(window).height();
	                  		  $(document).scrollTop(h);
	                  		 $("#modifySystemdiv").css("display","none");
	                		var tr = $("tbody tr").eq(idtable);
	                		alert(tr.html());
	                		//把值放进去
	                		tr.children(":eq(1)").text(data.configTypeName);
	                		
	                		if($("#selectTypeValue").val()==1){
	                			if(data.isStart==1){
		                			tr.children(":eq(2)").text("开启");
		                		}else{
		                			tr.children(":eq(2)").text("关闭");
		                		}
		                		tr.children(":eq(3)").html("" +
		                				"<span class='modifySystemBtn'><a class='financialUpdata' onclick='systemConfigUpdate(this,"+data.id+")'>修改</a></span>| "+
		                				"<span class='deleteSystemBtn'><a class='financialDelete' onclick='systemConfigDelete(this,"+data.id+")'>刪除</a></span>" 
		                			);
	                		}else if($("#selectTypeValue").val() == 2){
	                		
	                			tr.children(":eq(2)").text(data.configValue);
	                			if(data.isStart==1){
		                			tr.children(":eq(3)").text("开启");
		                		}else{
		                			tr.children(":eq(3)").text("关闭");
		                		}
		                		tr.children(":eq(4)").html("" +
		                				"<span class='modifySystemBtn'><a class='financialUpdata' onclick='systemConfigUpdate(this,"+data.id+")'>修改</a></span>| "+
		                				"<span class='deleteSystemBtn'><a class='financialDelete' onclick='systemConfigDelete(this,"+data.id+")'>刪除</a></span>" 
		                			);
	                		}
	                		
	                		
	                		
	                		
	                	}
	                
	                 },
	                error:function(e){
	                    alert("ajax系统错误！！");
	                }
	            }); 
			
			 
		 }	
		 
});
	 
	 //服务年限   修改年限  
	 $("#simpleBtn").on("click",function(){
		 //获取id
		 var id = $("#simpleId").val();
		 //获取年限
		 var simpConfigValue = $("#simpConfigValue").val();
		 if(simpConfigValue<1){
			 humane.error("请输入正确的年限。");
		 }else{
			 $.ajax({
	               url:"/SystemConfig/seniority/save.do",
	                type:"post",
	                data:{"id":id,"simpConfigValue":simpConfigValue},
	                dataType: "json",
	                success:function(data){
	                	if(data!=null){
	                		 humane.error("修改成功，已保存");
	                	}else{
	                		 humane.error("修改失败");	
	                	}
	                	
	                 },
	                error:function(e){
	                    alert("ajax系统错误！！");
	                }
	            }); 
			 
		 }
	});
	 
	 
	 //修改app地址
	//服务年限   修改年限  
	 $("#simpleBtn2").on("click",function(){
		 //获取id
		 var url = $("#simpConfigValue").val();
		 var simpTypeName = $("#simpTypeName").val();
		 var id = $("#simpleId").val();
		 //获取年限
		
		 var reg=/^([hH][tT]{2}[pP]:\/\/|[hH][tT]{2}[pP][sS]:\/\/)(([A-Za-z0-9-~]+)\.)+([A-Za-z0-9-~\/])+$/;
		 
		 
		 if($.trim(simpTypeName)==""){
			 humane.error("配置名称不能为空。");
		 }else if (!reg.test(url)){
			 humane.error("这网址不是以http://https://开头，或者不是网址！"); 
			 
		 }else{
			 $.ajax({
	               url:"/SystemConfig/appaddress/save.do",
	                type:"post",
	                data:{"id":id,"simpTypeName":simpTypeName,"url":url},
	                dataType: "json",
	                success:function(data){
	                	if(data!=null){
	                		 humane.error("修改成功，已保存");
	                	}else{
	                		 humane.error("修改失败");	
	                	}
	                	
	                 },
	               
	            }); 
			 
		 }
	});
	 
	 
	 

});

function addSystemConfig(typeid){
	 var addConfigName =$("#addConfigName").val();
	 var addConfigValue =$("#addConfigValue").val();
	
	 
	 
	 if(addConfigName==""){
		 humane.error("类型名称不能为空");
		 return false;
	 }else if(addConfigValue==""){
		 humane.error("类型名称不能为空");
		 return false;
	 }else{ 
		 $.ajax({
             url:"/SystemConfig/financial/add.do",
              type:"post",
              data:{"typeid":typeid,"configName":addConfigName,"isStart":$("#addIsStartSelect").val()
            	  ,"addConfigValue":" "+addConfigValue+" "},
              dataType: "json",
              success:function(data){
              	if(data!=null){
              		//把信息添加到tbody的最后一行
              		var $lasttr = $("tbody tr:last").clone();
              		$lasttr.children(":first").text(parseInt($lasttr.children(":first").text())+1);
              		
              		
              		
              		$lasttr.children(":eq(1)").text(data.configTypeName);
              		
              		if(addConfigValue===undefined){
              			if(data.isStart==1){
                  			$lasttr.children(":eq(2)").text("启用");
                  		}else{
                  			$lasttr.children(":eq(2)").text("关闭");
                  		}
                  		$lasttr.children(":eq(3)").html(
                  				"" +
                				"<span class='modifySystemBtn'><a class='financialUpdata' onclick='systemConfigUpdate(this,"+data.id+")'>修改</a></span>| "+
                				"<span class='deleteSystemBtn'><a class='financialDelete' onclick='systemConfigDelete(this,"+data.id+")'>刪除</a></span>" 
                					
                  		
                  		);
              			
              			
              			
              		}else{

              			$lasttr.children(":eq(2)").text(data.configValue);
              			if(data.isStart==1){
                  			$lasttr.children(":eq(3)").text("启用");
                  		}else{
                  			$lasttr.children(":eq(3)").text("关闭");
                  		}
                  		$lasttr.children(":eq(4)").html(
                  				"" +
                				"<span class='modifySystemBtn'><a class='financialUpdata' onclick='systemConfigUpdate(this,"+data.id+")'>修改</a></span>| "+
                				"<span class='deleteSystemBtn'><a class='financialDelete' onclick='systemConfigDelete(this,"+data.id+")'>刪除</a></span>"                 		
                  		);
              		}             		
              		$("tbody").append($lasttr);
              		humane.error("添加成功");
              		 $("#addSystemdiv").css("display","none");
              		  var h = $(document).height()-$(window).height();
              		  $(document).scrollTop(h);
              	}else{
              		alert("添加出错");
              	}
             	},
              error:function(e){
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
	var $name = $(e).parent().parent().prev().prev().text();
	$("#modifySystemdiv").css("display","block");
	//然后设置默认值
	//滚动到顶部，否则修改的界面看不到
	$('body').scrollTop(0);
	$("#configName").val($name);
	//还要把id带进来  
	$("#sid").val(id);
	//还要把table的id给带进来
	$("#idtable").val($(e).parent().parent().parent().children(":first").text() );
	alert($("#selectTypeValue").val());
	if($("#selectTypeValue").val()==2){
		alert($(e).parent().parent().parent().children(":eq(2)").text());
		$("#modifyConfigValue").val($(e).parent().parent().parent().children(":eq(2)").text());
	}	
}







