package com.shizongger.oa.domain;

import java.util.Date;

/**
 * @date 2017/10/08
 * @author shizongger
 * 话题和回帖的抽象公共部分
 */
public class Article {
	private Long id; //id
	
	private String title; //标题
	
	private String content; //内容
	
	private User author; //作者
	
	private Date postTime; //发表时间
	
	private String ipAddress; //ip地址

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
}
