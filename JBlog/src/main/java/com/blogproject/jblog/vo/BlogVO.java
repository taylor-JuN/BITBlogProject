package com.blogproject.jblog.vo;

import java.util.Date;

public class BlogVO {
	private Long userNo;
	private String blogTitle;
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	
	@Override
	public String toString() {
		return "BlogVO [userNo=" + userNo + ", blogTitle=" + blogTitle + "]";
	}
	
	
	
	
	
}
