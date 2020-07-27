package com.javaex.vo;

public class BlogVo {

	private String id;
	private String blogTitle;
	private long logoFile;
	
	public BlogVo () {}
	
	
	public BlogVo(String id, String blogTitle, long logoFile) {
		this.id = id;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public long getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(long logoFile) {
		this.logoFile = logoFile;
	}

	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", blogTitle=" + blogTitle + "]";
	}
	
	
	
}
