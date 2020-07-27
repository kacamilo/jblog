package com.javaex.vo;

public class CategoryVo {

	private int cateNo;
	private String id;
	private String cafeName;
	private String descrition;
	private String regDate;
	
	public CategoryVo() {}	
	public CategoryVo(int cateNo, String id, String cafeName, String descrition, String regDate) {
		this.cateNo = cateNo;
		this.id = id;
		this.cafeName = cafeName;
		this.descrition = descrition;
		this.regDate = regDate;
	}
	
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "CategoryVo [cateNo=" + cateNo + ", id=" + id + ", cafeName=" + cafeName + ", descrition=" + descrition
				+ ", regDate=" + regDate + "]";
	}
	
	
}
