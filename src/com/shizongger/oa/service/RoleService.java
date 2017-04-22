package com.shizongger.oa.service;

import java.util.List;
import java.util.Set;

import com.shizongger.oa.domain.Role;

public interface RoleService {

	public List<Role> selectAll();

	public void add(Role role);

	public void delete(Long id);

	public Role selectById(Long id);

	public void update(Role role);

	public Set<Role> selectByIds(Long[] roleIdList);

}
