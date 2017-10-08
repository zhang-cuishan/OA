package com.shizongger.oa.domain;

/**
 * 帖子的回复
 * @author shizongger
 * @date 2017/10/08
 */
public class Reply extends Article {
	//所属话题
	private Topic topic;

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
