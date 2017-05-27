package com.sms.utils;

/**
 * 翻页工具类
 * @author 李宇斌
 *
 */
public class Pager {

	int currentPageNo = 1;//当前页号
	int totalPageCount = 1;//总页号
	int pageCount = 10;//每页记录数
	boolean hasNext;//是否有下一页
	boolean hasPrevious;//是否有上一页
	
	int totalCount;//总记录数
	int start;//当前页起始位置
	int end;//当前页结束位置
	
	
	public Pager() {
		
	}
	
	/*
	 * Getters and Setters
	 */
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getPageCount() {
		
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
		//重新计算
		start = (currentPageNo - 1) * pageCount + 1;
		end = currentPageNo * pageCount;
	}
	public boolean isHasNext() {
		return hasNext;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	public boolean isHasPrevious() {
		return hasPrevious;
	}
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//计算总页数
		totalPageCount = totalCount / pageCount;
		
		if(totalCount != 0){
			//如果还有剩余
			if(totalCount % pageCount > 0){
				totalPageCount ++;
			}
		}
		//计算是否有下一页
		hasNext = currentPageNo < totalPageCount;
		//计算是否有上一页
		hasPrevious = currentPageNo > 1;
		
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
}
