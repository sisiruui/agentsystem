package ssru.myw.agentsystem.util;

import java.util.ArrayList;
import java.util.List;




/**
 * 马一文自用分页类
 * @author: mayiwen
 * @date: 2018/11/16
 *  根据当前页左侧的页码放在prevList中  ，当前页右侧的页码放在nextList 中
 *
 *
 */
public class Pages {
	/**  1 2 3 4 5 6 如果当前页是第3页，则前置集合是1，2 */
	private List<Integer> prevList = new ArrayList<Integer>();
	/**  1 2 3 4 5 6 如果当前页是第3页，则后置集合是4，5，6*/
	private List<Integer> nextList = new ArrayList<Integer>();
	/** 请求的页码 -需要传入*/
	private Integer thePage;//当前页
	/** 总记录数 - 需要传入 */
	private Integer totalCount;//总记录数
	/** 总页数  */
	private Integer pageCount;//总页数
	/** 每页的信息数 本类默认为10，不可修改。因为修改后的逻辑未加入 待加入 */
	private Integer pageSize = 10;
	/** 前页后页都能使用的数量   如 当前页是5，则num为1的时候，结果是456，如果为2，则结果是34567  */
	private Integer num=5;  //当前页前与页后都能显示3页
	//需要传入总记录数，页大小，当前页。   prev 与  next 存放的是左右两侧显示的数;
	
	
	/**
	 * 当前页      唯一的入口方法
	 * @param thePage  当前页     必须大于0
	 * @param totalCount 总记录数    必须大于0
	 */
	public Pages(Integer thePage, Integer totalCount) {
		super();
		// 给属性附值
		this.thePage = thePage;
		this.totalCount = totalCount;

		if (totalCount>=0) {//判断是否大于0    总条数大于0 才有执行的必要
			this.pageCount = totalCount%pageSize==0? totalCount/pageSize:totalCount/pageSize+1;//得到总页码
			if (this.pageCount<7) {//如果小于7页就不用执行那么多的逻辑了
				pageCountLess();
			}else {//如果大于7，则说明页码比较多了   页码比较多了   就看当前页
				if(this.thePage<6){// 页码小于6
					thePageLess();
				}else if(this.thePage>=(pageCount-5)){//
					thePageMore();
				}else{
					thePageLeftIsNumRightIsNum();
				}
			}
			
		}
	}
	private void thePageLeftIsNumRightIsNum() {
		// TODO Auto-generated method stub
		//如总页11  当前页  9    此处为 5,6,7,8
		prevList.add(this.thePage-3);
		prevList.add(this.thePage-2);
		prevList.add(this.thePage-1);
		nextList.add(this.thePage+1);
		nextList.add(this.thePage+2);
		nextList.add(this.thePage+3);
	}

	/**
	 * 当前页很大的情况
	 *
	 *
	 *
	 */
	private void thePageMore() {
		// TODO Auto-generated method stub
		//如总页11  当前页  9    此处为 5,6,7,8
		for (int i = this.pageCount-5; i <this.thePage ; i++) {
			prevList.add(i);
		}



		//如总页11  当前页  9    此处为10,11
		for (int i = this.thePage+1; i <=pageCount ; i++) {
			nextList.add(i);
		}
	}

	/**
	 * 当前页很小的情况
	 * 如果 当前页小于6 在左侧显示全部 右侧 如果总页数大于11，则显示5页，否则显示全部pageCount
	 *
	 */
	private void thePageLess() {
		// TODO Auto-generated method stub
		for (int i = 1; i <this.thePage ; i++) {
			prevList.add(i);
		}

		for (int i = this.thePage+1; i <= pageCount; i++) {
			nextList.add(i);
		}



	}

	/**
	 * 这个方法是页数小于7 的执行方法
	 * @return
	 */
	private void pageCountLess(){
		// 如果thepage为1，则没有，如果为2，集合为1 如果为6 集合为12345
		for (int i = 1; i <this.thePage ; i++) {
			prevList.add(i);
		}
		//如果thepage 为1 集合为23456 ，为2 集合是3456， 为6 没有
		for (int i = this.thePage+1; i <= this.pageCount; i++) {
			nextList.add(i);
		}
	}
	
	private void pageCountMore(){
		for (int i = 1; i <this.thePage ; i++) {
			prevList.add(i);
		}
		for (int i = this.thePage+1; i <= this.pageCount; i++) {
			nextList.add(i);
		}
	}
	/**
	 * 得到前置 数字   出口方法
	 * @return
	 */
	public List<Integer> getPrevList() {
		return prevList;
	}
	/** 
	 * 得到后置数字 出口方法
	 * @return
	 */
	public List<Integer> getNextList() {
		return nextList;
	}	
}
