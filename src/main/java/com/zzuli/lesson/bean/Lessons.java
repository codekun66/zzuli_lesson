package com.zzuli.lesson.bean;

import java.util.Date;

/**
 * 课程
 * @author xk
 * @data 2018/12/07
 * 
 */
public class Lessons {
	//课程id
	private int lessId;
	//图片地址
	private String lessPicUrl;
	//课程名称
	private String lessName;
	//课程级别
	private String rank;
	//教师名字
	private String teaName;
	//访问量
	private int pageView;
	//课程简介
	private String summary;
	//课程分类
	private String lessCategory;
	//创建时间
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date modifieldTime;
	public int getLessId() {
		return lessId;
	}
	public void setLessId(int lessId) {
		this.lessId = lessId;
	}
	public String getLessPicUrl() {
		return lessPicUrl;
	}
	public void setLessPicUrl(String lessPicUrl) {
		this.lessPicUrl = lessPicUrl;
	}
	public String getLessName() {
		return lessName;
	}
	public void setLessName(String lessName) {
		this.lessName = lessName;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public int getPageView() {
		return pageView;
	}
	public void setPageView(int pageView) {
		this.pageView = pageView;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getLessCategory() {
		return lessCategory;
	}
	public void setLessCategory(String lessCategory) {
		this.lessCategory = lessCategory;
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
	
	
}
