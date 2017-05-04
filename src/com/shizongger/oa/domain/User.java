package com.shizongger.oa.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionContext;

/**
 * 用户实体
 * @author shizongger
 * @date 2017/03/24
 */
public class User {
	private Log log = LogFactory.getLog(this.getClass());
	
	private Long id;
	
	private String loginName;
	
	private String password;
	
	private String name;
	
	private String gender;
	
	private String phoneNumber;
	
	private String email;
	
	private String description;
	
	private Department department;
	
	private Set<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * 判断用户是否用该权限
	 * @param privilegename 权限名称
	 * @return
	 */
	public boolean hasPrivilegeByName(String privilegeName) {
		log.debug("权限名称:" + privilegeName);
		
		//从本用户中取出所有角色
		for(Role role : roles) {
			//从角色遍历出所有权限
			Set<Privilege> privilegeList = role.getPrivileges();
			for(Privilege privilege : privilegeList) {
				if(privilegeName.equals(privilege.getName())) {
					log.debug(privilegeName + "---有权限---");
					return true;
				}
			}
		}
		
		log.debug(privilegeName + "---没有权限---");
		return false;
	}
	
	/**
	 * 判断本用户是否有指定URL的权限
	 * 
	 * @param privUrl
	 * @return
	 */
	public boolean hasPrivilegeByUrl(String privUrl) {
		// 超级管理有所有的权限
		if (isAdmin()) {
			return true;
		}

		// >> 去掉后面的参数
		int pos = privUrl.indexOf("?");
		if (pos > -1) {
			privUrl = privUrl.substring(0, pos);
		}
		// >> 去掉UI后缀
		if (privUrl.endsWith("UI")) {
			privUrl = privUrl.substring(0, privUrl.length() - 2);
		}

		// 如果本URL不需要控制，则登录用户就可以使用
		Collection<String> allPrivilegeUrls = (Collection<String>) ActionContext.getContext().getApplication().get("allPrivilegeUrls");
		if (!allPrivilegeUrls.contains(privUrl)) {
			return true;
		} else {
			// 普通用户要判断是否含有这个权限
			for (Role role : roles) {
				for (Privilege priv : role.getPrivileges()) {
					if (privUrl.equals(priv.getUrl())) {
						return true;
					}
				}
			}
			return false;
		}
	}

	/**
	 * 判断本用户是否是超级管理员
	 * 
	 * @return
	 */	
	public boolean isAdmin() {
		return "admin".equals(loginName);
	}
}
