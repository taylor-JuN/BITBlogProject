package com.blogproject.jblog.vo;

import java.sql.Date;

public class BlogVO {
	private Long userNo;
	private String blogTitle;
	private String logoFile;
	
	
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
	public String getLogoFile() {
		return logoFile;
	}
	public void setLogoFile(String logoFile) {
		this.logoFile = logoFile;
	}
	@Override
	public String toString() {
		return "BlogVO [userNo=" + userNo + ", blogTitle=" + blogTitle + ", logoFile=" + logoFile + "]";
	}

	
	
	
	
}
