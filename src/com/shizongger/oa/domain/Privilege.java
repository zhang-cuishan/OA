package com.shizongger.oa.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 权限的javabean
 * @author shizongger
 * @date 2017/04/13
 */
public class Privilege {
	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 对应的url
	 */
	private String url;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 上一级权限
	 */
	private Privilege parent;
	
	/**
	 * 下一级权限
	 */
	private Set<Privilege> children = new HashSet<Privilege>();
	
	/**
	 * 角色
	 */
	private Set<Role> roles = new HashSet<Role>();

	public Privilege() {
	}
	
	public Privilege(String name, String url, Privilege parent) {
		this.name = name;
		this.url = url;
		this.parent = parent;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Privilege getParent() {
		return parent;
	}

	public void setParent(Privilege parent) {
		this.parent = parent;
	}

	public Set<Privilege> getChildren() {
		return children;
	}

	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
