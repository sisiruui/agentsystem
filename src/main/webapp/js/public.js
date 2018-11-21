function mover(object) {
	for (var i = 1; i < 6; i++) {
		if (object == i) {
			// 主菜单
			document.getElementById("m_" + i).className = "m_li_a";
			// 子菜单
			document.getElementById("s_" + i).style.display = "block";
		} else {
			document.getElementById("m_" + i).className = "m_li";
			// 子菜单
			document.getElementById("s_" + i).style.display = "none";

		}
	}
}

/**
 * 这个方法是将字符串转化为日期的方法 输入的字符串应该是以 - 为分割符
 */
var dateformate = function(str) {
	var newStr = str.replace(/\-/g, "/");
	var date = new Date(newStr)
	return date;

}
/**
 * 传入两个字符串 比较日期大小 若第二个字符串大于第一个字符串则返回1 相等=0 小于返回-1
 */
var dateCompare = function(str1, str2) {
	// 首先是比较
	var date1 = dateformate(str1);
	var date2 = dateformate(str2);
	if (date2 > date1) {
		return "1";
	} else if (date2 < date1) {
		return "-1";
	} else {
		return "0";
	}

}
