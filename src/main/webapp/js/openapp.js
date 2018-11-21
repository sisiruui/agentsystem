$(function(){
	
	
	
})

function checkForm(e){
	alert("nihao")
	if($.trim($("#appUserName").val())==""){
		  humane.error("登陆账户不可以为空。"); 
		  return false;
	}else if($.trim($("#appPassword").val())==""){
		 humane.error("登录密码不可以为空。");
		 return false;
	}else{
		 humane.error("...");
	}
	
	
	
}