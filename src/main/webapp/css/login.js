function validateLoginUserFun(){
	var flag=false;
	
	var usercode = $.trim($("#userCode").val());
	var userpassword = $.trim($("#userPassword").val());
	
	if(usercode==""||usercode==null){
		$("#userCode").focus();
		alert("账号名不能为空");
	}else if(userpassword==""||userpassword==null){
		$("#userPassword").focus();
		alert("密码不能为空");
		
	}else{
		$.ajax({
			url:'/validateLoginUser.action',
			type:"post",
			async:false,
			data:{"user.userCode":usercode,"user.userPassword":userpassword},
			dataType:'heml',
			success:function(data){
				if("noexitusercode"==data){
					alert("对不起!用户不存在");
				}else if("errorpwd"==data){
					alert("对不起!密码");
					
				}else if("failed"==data){
					alert("对不起!系统错误");
				}else if("success"==data){
					alert("登陆成功");
				}

			}
			
			
			
		});
		
		
	}
	
	
	return flag;
	
} 