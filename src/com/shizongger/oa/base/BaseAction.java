package com.shizongger.oa.base;

import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shizongger.oa.service.DepartmentService;
import com.shizongger.oa.service.ForumService;
import com.shizongger.oa.service.PrivilegeService;
import com.shizongger.oa.service.RoleService;
import com.shizongger.oa.service.UserService;
import com.shizongger.oa.service.impl.PrivilegeServiceImpl;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	protected T model;
	
	@Autowired
	protected DepartmentService departmentService;
	
	@Autowired
	protected RoleService roleService;
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected PrivilegeService privilegeService;
	
	@Autowired
	protected ForumService forumService;
	
	public BaseAction() {
		try {
			// 通过反射获取model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public T getModel() {
		return model;
	}
}
