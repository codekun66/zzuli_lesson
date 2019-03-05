package com.zzuli.lesson.bean;

import java.util.Date;
/**
 * 教师信息
 * @author xk
 * @data 2018/12/07
 * 
 */
public class Teacher {
	// 主键ID
	private int id;
	// 教师编号
	private String teaNum;
	// 教师名字
	private String teaName;
	// 教师简介
	private String teaIntroduce;
	// 图片地址
	private String picUrl;
	// 排序
	private int sort;
	// 有效状态码
	private String validStsCd;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date modifieldTime;
	//userid
	private String userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeaNum() {
		return teaNum;
	}
	public void setTeaNum(String teaNum) {
		this.teaNum = teaNum;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public String getTeaIntroduce() {
		return teaIntroduce;
	}
	public void setTeaIntroduce(String teaIntroduce) {
		this.teaIntroduce = teaIntroduce;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getValidStsCd() {
		return validStsCd;
	}
	public void setValidStsCd(String validStsCd) {
		this.validStsCd = validStsCd;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifieldTime() {
		return modifieldTime;
	}
	public void setModifieldTime(Date modifieldTime) {
		this.modifieldTime = modifieldTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teaNum=" + teaNum + ", teaName=" + teaName + ", teaIntroduce=" + teaIntroduce
				+ ", picUrl=" + picUrl + ", sort=" + sort + ", validStsCd=" + validStsCd + ", createTime=" + createTime
				+ ", modifieldTime=" + modifieldTime + ", userId=" + userId + "]";
	}
	
	
}
