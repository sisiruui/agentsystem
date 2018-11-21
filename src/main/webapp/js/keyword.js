$(function(){
	mover(1);
})

//这个方法是用来触发搜索用户的
$(function(){
	
	$("#searchUerText").on("keyup click",function(){
		loadUsers();
	});	
})


//使用ajax在数据库中查找
function loadUsers(){	
	$.ajax({
		url:'/customs/searchName.do',
		type:"post",
		async:false,
		data:{"name":$("#searchUerText").val()},
		dataType:'json'                       ,
		success:function(result){
			var userList = "<ul>";
			for(var i=0;i< result.length;i++){
				userList = userList + 
				"<li onclick=\"confirmCustom("+result[i].id+",'"+result[i].customName+"');\"><span>客户类型："+result[i].customTypeName+"</span><br/><a>"+result[i].customName+"</a></li>";
			}
			userlist = userList +"</ul>";
			$("#serachresult").html(userList);
			$("#serachresult").slideDown(500);	     		
		}
	});
}

//选择用户所做的操作
function confirmCustom(uid,ucode){
	userid = uid;
	userName = ucode;
	$("#searchUerText").val(ucode);
	$("#serachresult").html("");
	$("#serachresult").hide();
	$("#customname").val(ucode);
	$("#customId1").val(uid);
}

//这是自动计算价格的ajax
$(function(){
	//什么时候回触发事件
	$(document).on("change","#servicetype",function(){
		if(	$("#servicetype").val()==0){
			$("#price").val("");
		}
		getPrice();
	});	
	$(document).on("change","#serviceyears",function(){
		if(	$("#serviceyears").val()==0){
			$("#price").val("");
		}
		getPrice();
	});	
});

/**
 * 计算价格的方法
 * @returns
 */
function getPrice (){
	//首先进行验证	//获取服务类型     
	$("#servicetype").val();//服务类别
	$("#serviceyears").val();//服务年限
	if($("#servicetype").val()!=0 && $("#serviceyears").val()!=0){
		//发送服务类别，服务年限到数据库  返回价格   然后把价格添加到价格框中   执行ajax
		$.ajax({
            url:"/keywords/price.do",
            type:"post",
            data:{"servicetype":$.trim($("#servicetype").val()),"serviceyears":$.trim($("#serviceyears").val())},
            dataType: "html",
            success:function(data){
            	$("#price").val(data);
            },
            error:function(e){
                alert("系统错误！！ 获取金额错误");
            }
        });
	}
	
	
	
	
	
	
}

//检测关键词是否被注册过
var check =     function  checkKeyword(){
	var message ="";
	
	$.ajax({
		
        url:"/keywords/checkKeywordTest.do",
        type:"post",
        data:{"keyword":$("#keyword").val()},
        dataType: "html",
        success:function(data){
        
        	if(data=="succ"){//查到了就不能使用
        	
        		$("#savemessage").val("fail");
        	
        	}else{
        		
        		$("#savemessage").val("succ");
        		
        	}
        
        },
        error:function(e){
        	alert("wrong at keywords")
        }
    });
	
}





//提交关键词
$(function(){
	$("#submitkeyword").on("click",function(){
		//首先 客户名称 不能喝为空
		if ($.trim($("#customname").val())=="") {
			 humane.error("请在搜索客户处选择客户。"); 
			 $("#searchUerText").focus();	
			 return false;
		}
		if ($.trim($("#keyword").val())=="") {
			 humane.error("您的关键词不可以为空。"); 
			 $("#keyword").focus();	
			 return false;
		}
		check();
		if($("#savemessage").val()=="fail"){
			 humane.error("您的关键词已被使用。"); 
			 $("#keyword").focus();	
			 return false;
		}
		if($("#servicetype").val()==0){
			 humane.error("您的服务类型不能为空。"); 
			 $("#servicetype").focus();	
			 return false;
		}
		if($("#serviceyears").val()==0){
			 humane.error("您的服务年限不能为空。"); 
			 $("#serviceyears").focus();	
			 return false;
		}
		//验证
		$("#customname").val();//客户名称
		$("#keyword").val();//关键词
		$("#servicetype").val();//servicetype 服务类别
		$("#serviceyears").val();//服务年限
		$("#price").val();//价格	
		$.ajax({
			url:"/keywords/add.do",
	        type:"post",
	        data:{"customName":$("#customname").val(),"keywords":$("#keyword").val(),
	        	"productType":$("#servicetype").val(),"serviceYears":$("#serviceyears").val(),
	        	"price":$("#price").val(),"customId":$("#customId1").val()
	        	},
	        dataType: "html",
	        success:function(data){
	        	
	        	if(data=="succ"){//查到了就不能使用
	        		$("#submitkeyword").off("click");
	        		humane.success("添加成功");
	        		setInterval("shuaxin()",1000);
	        	
	        		
	        	}else{
	        		$("#submitkeyword").off("click");
	        		humane.success("添加失败");
	        		setInterval("shuaxin()",1000);
	        	}
	        },
	        error:function(e){
	        	alert("wrong at add")
	        }
	    });
		
	})
	
	
	
	
	
	
})

var shuaxin = function(){
	window.location.reload();
}







