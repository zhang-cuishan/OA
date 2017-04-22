package com.shizongger.oa.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 实体：岗位
 * @author shizongger
 * @date 2017/03/24
 */
public class Role {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private Set<User> users = new HashSet<User>();
	
	private Set<Privilege> privileges = new HashSet<Privilege>();
	
	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
