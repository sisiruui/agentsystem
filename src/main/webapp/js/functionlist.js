$(function(){

	$("#saverolefunc").on("click",function(){
		alert("nihao");
		var checkList = "";//存储被选中
		var cblist = $(".cb");
		var roleId = $("#roleid").val();
		alert(roleId);
		$(".cb").each(function(ii,vv){
		    //ii 指第几个元素的序列号。
		    //vv 指遍历得到的元素。
			if($(vv).prop("checked")==true){
				checkList = checkList+(ii+1)+",";
			}
		});
	
		alert(checkList);
	
		$.ajax({
			url:"/premisiion/save.do",
			type:"post",
			data:{"checkList":checkList,"roleId":roleId},
            dataType: "html",
            success:function(data){
                
                if(data=="success"){
              	  
              		humane.success("保存成功。");
              	  
                }
                else{
              	  humane.error("数据错误，请联系管理员。"); 
                }
              },
              error:function(data){
                  alert("ajax系统错误！！");
              }

			
			
			
		});
		
		
		
		
	});
	//点击取消
	$("#cancel").on("click",function(){
		top.location.href="/role/firstlist.do";
		/*$(window).attr('location','http://www.jb51.net');  */
	});
	
	
	
	
});

function checkAll(e){
	if($(e).prop("checked")==true){
        $("input[class='cb']").prop('checked', "checked");
    }else{
        $("input[class='cb']").prop('checked', "");
    }
}

