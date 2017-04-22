package com.shizongger.oa.service.impl;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shizongger.oa.base.BaseJunitTest;
import com.shizongger.oa.domain.Department;
import com.shizongger.oa.domain.Role;
import com.shizongger.oa.domain.User;
import com.shizongger.oa.service.DepartmentService;
import com.shizongger.oa.service.RoleService;
import com.shizongger.oa.service.UserService;

public class UserServiceImplTest extends BaseJunitTest {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Test
	public void testAdd() {
		Role role = roleService.selectById(1L);
		Department department = departmentService.getById(3L);
		
		User user = new User();
		user.setDescription("This is admin account");
		user.setEmail("lily@shizongger.com");
		user.setGender("female");
		user.setLoginName("lily");
		user.setName("lily");
		user.setPassword("lily");
		user.setPhoneNumber("139520520520");
		
		user.setDepartment(department);
		
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRoles(roles);
		
		userService.add(user);
	}

	@Test
	public void testDelete() {
		userService.delete(14L);
	}

	@Test
	public void testUpdate() {
		User user = (User) userService.selectById(14L);
		if(user != null) {
			user.setPhoneNumber("18201357365");
			userService.update(user);
		}
	}

	@Test
	public void testSelectAll() {
		List<User> userList = userService.selectAll();
		for(final User user : userList) {
			log.info(user.toString());
		}
	}

	@Test
	public void testSelectById() {
		User user = (User) userService.selectById(11L);
		log.info("姓名:" + user.getName() + ", 性别:" + user.getGender() + ", email:" + user.getEmail());
		log.info("所在部门:" + user.getDepartment().getName());
		
		//获取岗位
		Set<Role> roles = user.getRoles();
		Iterator<Role> it = roles.iterator();
		while(it.hasNext()) {
			Role role = it.next();
			log.info("岗位名称:" + role.getName());
		}
		
		assertEquals("lily", user.getLoginName());
	}

	@Test
	@Ignore
	public void testSelectByNameAndPassword() {
	}

}
