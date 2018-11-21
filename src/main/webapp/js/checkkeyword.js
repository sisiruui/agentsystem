$(function(){
	mover(4);
})
/**
 * checkWord(this,27,丝丝123,2,1)
 * @param e
 * @param id
 * @param keywords
 * @param agentId
 * @param serviceYears
 * @returns
 */
 
var checkWord = function(e,id){

	if($(e).val()==0){//不等于0的时候
		return false;
	}else {
		if(confirm("确定要执行此操作吗？")){
			if($(e).val()!=4){
				$.ajax({
			        url:"/keywords/update.do",
			        type:"post",
			        data:{"checkselect":$(e).val(),"id":id},
			        dataType: "text",
			        success:function(data){
			        	if(data=="succ"){
			        	humane.success("修改成功") ;
			        	 setTimeout(location.reload(),1000);
			        	}else{
			        
			        		humane.success("修改失败") ;
				        	 setTimeout(location.reload(),1000) ;
			        	}
			        },
			        error:function(data){
			            alert("ajax系统错误！！");
			        }
			    });
			}else{
				//如果等于4   则执行的是添加app的事情，在这里暂时不表。   执行页面跳转
				ymPrompt.win({message:'/xufei.action?keywords.id='+id,width:600,height:400,title:'当前为【'+obj.attr("keyword")+'】进行续费操作',handler:callBack,iframe:true})
				
				
			}
			
			
		}else{
			return false;
		}
		
		
	}
	
}

