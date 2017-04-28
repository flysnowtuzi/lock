package com.haibei.core;

import java.util.Map;

public class Page {
	// 总数
	private int totalCount;
	// 总数
	private int totalPage;
	// 当前页码
	private int pageNum;
	// 每页多少条
	private int numPerPage;
	// 页码数量
	private int pageNumShown;
	// 排序的字段
	private String orderField;
	// 排序的方向
	private String orderDirection;

	private Map<String, Object> conditions;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		//System.out.println((int) Math.ceil(totalCount/getNumPerPage()));
		//System.out.println(((double)totalCount)/getNumPerPage());
		return totalPage==0?(int) Math.ceil(((double)totalCount)/getNumPerPage()):totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNum() {
		return pageNum == 0 ? 1 : pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage == 0 ? 10 : numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getPageNumShown() {
		return pageNumShown == 0 ? 5 : pageNumShown;
	}

	public void setPageNumShown(int pageNumShown) {
		this.pageNumShown = pageNumShown;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	public Map<String, Object> getConditions() {
		return conditions;
	}

	public void setConditions(Map<String, Object> conditions) {
		this.conditions = conditions;
	}

}
