package com.zzuli.lesson.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zzuli.lesson.util.DateUtil;
import java.io.Serializable;

/**
 * 课程
 * @author xk
 * @data 2018/12/07
 * 
 */
public class Lessons implements Serializable {
	
	//序列化
	private static final long seriaVersionUID = 1L;
	
	//课程id
	private int id;
	//图片地址
	private String lessPicUrl;
	//课程名称
	private String lessName;
	//课程级别
	private String rank;
	//教师名字
	private String teaName;
	//访问量
	private String pageView;
	//课程简介
	private String summary;
	//课程分类
	private String lessCategory;
	//教师id
	private int teaId;
	//创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonSerialize(using = DateUtil.class)
	private Date createTime;
	// 更新时间
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonSerialize(using = DateUtil.class)
	private Date modifieldTime;
	//有效状态码
	private String validStsCd;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public String getPageView() {
		return pageView;
	}
	public void setPageView(String pageView) {
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
	public String getValidStsCd() {
		return validStsCd;
	}
	public void setValidStsCd(String validStsCd) {
		this.validStsCd = validStsCd;
	}
	public int getTeaId() {
		return teaId;
	}
	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}
}
