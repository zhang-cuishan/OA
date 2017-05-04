package com.shizongger.oa.domain;

/**
 * @date 2017/05/06
 * @author shizongger
 * 论坛板块
 */
public class Forum {

	private Long id; //主键id
	
	private String name; //板块名称
	
	private String description; //板块描述
	
	private int position;  //板块所在位置

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
	
}
