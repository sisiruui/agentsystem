$(function(){
	//什么时候回触发事件
	$("#servicetype").on("change",function(){
		if(	$("#servicetype").val()==0){
			$("#price").val("");
		}
		getPrice();
	});	
	$("#serviceyears").on("change",function(){
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
            data:{"servicetype":$("#servicetype").val(),"serviceyears":$("#serviceyears").val()},
            dataType: "html",
            success:function(data){
            	$("#price").val(data);
            },
            error:function(e){
                alert("系统错误！！ 获取金额错误1");
            }
        });
	}	
}

//续费提交
$(function(){
	
	$("#submitkeyword").on("click",function(){
		var customname =$.trim($("#customname").val()) ;
		var keywordsId = $.trim( $("#keywordsId").val());
		var servicetype = $.trim( $("#servicetype").val());
		var serviceyears = $.trim( $("#serviceyears").val());
		var price = $.trim($("#price").val()) ;
		
		
		if (serviceyears==0) {
			humane.error("您必须选择服务年限才可以执行下一步操作。");
			return false;
		}
		alert($("#accountspan").text());
		alert(price);
		
		//如果金额不足则不能注册
		if(parseInt($("#accountspan").text())<parseInt(price)){
			humane.error("您的金额不足。");
			return false;
		}
		
		
		
		
		//需要的数据有服务类型 服务年限 与价格
		
		
		
		$.ajax({
	        url:"/keysmall/renewal.do",
	        type:"post",
	        data:{
	        	"keywordsId":keywordsId,
	        	"servicetype":servicetype,
	        	"serviceyears":serviceyears,
	        	"price":price
	        },
	        dataType: "text",
	        success:function(data){
	        	alert(data);
	        	if(data=="succ"){
	        		humane.success("添加成功");
	        		
	        	}else{
	        		humane.error("添加失败。");
	        		
	        	}
	        },
	        error:function(e){
	            alert("系统错误！！ 获取金额错误");
	        }
	    });
		
		
	})
	
	
	
	
/*	//获取用户信息
	

	
	
	
	
	$.ajax({
        url:"/keysmall/renewal.do",
        type:"post",
        data:{"customname":customname,
        	"keywordsId":keywordsId,
        	"servicetype":servicetype,
        	"serviceyears":serviceyears,
        	"privae":privae
        
        },
        dataType: "html",
        success:function(data){
        	$("#price").val(data);
        },
        error:function(e){
            alert("系统错误！！ 获取金额错误");
        }
    });
	*/
	
	
	
	
	
})




