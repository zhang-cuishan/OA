package com.shizongger.oa.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shizongger.oa.base.BaseJunitTest;
import com.shizongger.oa.domain.Department;
import com.shizongger.oa.service.DepartmentService;

public class DepartmentServiceImplTest extends BaseJunitTest{

	@Autowired
	private DepartmentService departmentService;
	
	@Test
	public void testFindAll() {
		List<Department> list = departmentService.findAll();
		System.out.println(list.size());
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		Department department = new Department();
		department.setDescription("这里是系统研发部门");
		department.setName("系统研发部");
		
		departmentService.save(department);
	}

	@Test
	public void testGetById() {
		Department department = departmentService.getById(1L);
		assertEquals("系统研发部", department.getName());
		assertEquals((Long)1L, department.getId());
	}

	@Test
	public void testUpdate() {
		Department department = departmentService.getById(1L);
		department.setDescription("这是经过junit测试修改之后的描述");
		departmentService.update(department);
	}

}
