//这是做日历选择的
laydate.render({
	elem : '#starttime' // 指定元素
});
laydate.render({
	elem : '#endtime' // 指定元素
});
// 中间的搜索

$(function(){
	mover(1);
})


function searchyfklistFunc() {
	if ($("#detailType").val() ==0) {

		humane.error("必须选择操作类型");
		return false;

	}
	
	
	//判断日期不为空
	if ($.trim($("#starttime").val()) == "") {

		humane.error("请选择日期1");
		return false;

	}
	//判断日期不为空
	if ($.trim($("#endtime").val()) == "") {
		humane.error("请选择日期2");
		return false;

	}

	//方法在public 函数中
	if(dateCompare($.trim($("#starttime").val()),$.trim($("#endtime").val()))!=1){
		humane.error("第二个日期必须大于第一个日期");
		return false;
	}
	
	

}


	
	
	
	
	



