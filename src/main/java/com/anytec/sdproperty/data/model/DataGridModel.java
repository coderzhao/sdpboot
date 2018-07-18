package com.anytec.sdproperty.data.model;

public class DataGridModel implements java.io.Serializable {
	
	private static final long serialVersionUID = 7232798260610351343L;
	private Integer page; //当前页,名字必须为page
	private Integer rows ; //每页大小,名字必须为rows
	private String sort; //排序字段
	private String order; //排序规则
	private Integer total;//输出用的

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}
