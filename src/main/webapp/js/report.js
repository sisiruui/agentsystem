$(function(){
	mover(3);
})
//这是为日期控件服务的操作
laydate.render({
	elem : '#starttime' // 指定元素
});
laydate.render({
	elem : '#endtime' // 指定元素
});

function checksubmit(){
	starttime =$.trim($("#starttime").val()) ;
	endtime =$.trim($("#endtime").val()) ;
	if($("#reporttype").val()!=1 && $("#reporttype").val()!=4){

		if(starttime == "" || endtime ==""){
			humane.error("请输入您要查询的日期。");
			return false;
		}
		if(dateCompare(starttime,endtime)==-1){
			humane.error("第二个日期应该大于第一个日期。");
			return false;
		}
		if($("#reporttype").val()>900){
			humane.error("请选择子类进行查询，您应该选择的是当前类别的子类进行查询。");
			return false;
		}
		if($("#reporttype").val()==6){
			humane.error("客户消费汇总（暂无）");
			return false;
		}
		
	
	}
	
	
	
}