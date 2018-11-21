$().ready(function(){
	mover(1);
	
	

});
/**
 * 开通app   
 * @param e
 * @param id
 * @returns
 */
function openApp(e,id){

	ymPrompt.win({message:'/keysmall/openAppFirst.do?id='+id,width:600,height:400,title:'开通APP',handler:callBack,iframe:true})
}
//续费
function renewal(e,id){
	ymPrompt.win({message:'/keysmall/renewalBefore.do?id='+id,width:600,height:400,title:'当前进行续费操作',handler:callBack,iframe:true})
}
function deletekeyword(e,id){
	ymPrompt.win({message:'/xufei.action?keywords.id='+kid,width:600,height:400,title:'当前为【'+keyword+'】进行续费操作',handler:callBack,iframe:true})
}

function callBack(){
	window.location.reload(true);
}