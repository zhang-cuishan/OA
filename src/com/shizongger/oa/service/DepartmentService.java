package com.shizongger.oa.service;

import java.util.List;

import com.shizongger.oa.domain.Department;

public interface DepartmentService {

	public List<Department> findAll();

	public void delete(Long id);

	public void save(Department model);

	public Department getById(Long id);

	public void update(Department department);

	public List<Department> findTopDept();

	public List<Department> findChildren(Long parentId);

}
