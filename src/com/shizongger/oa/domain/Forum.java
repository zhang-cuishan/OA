package com.shizongger.oa.domain;

import java.util.Set;

/**
 * @date 2017/05/06
 * @update 2017/10/08
 * @author shizongger
 * 论坛板块
 */
public class Forum {

	private Long id; //主键id
	
	private String name; //板块名称
	
	private String description; //板块描述
	
	private int position;  //板块所在位置

	private Set<Topic> topics; //话题
	
	private int topicCount; //主题数量
	
	private int articleCount;//文章数量
	
	private Topic lastTopic;//最后发表的主题

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	public int getTopicCount() {
		return topicCount;
	}

	public void setTopicCount(int topicCount) {
		this.topicCount = topicCount;
	}

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public Topic getLastTopic() {
		return lastTopic;
	}

	public void setLastTopic(Topic lastTopic) {
		this.lastTopic = lastTopic;
	}
}
