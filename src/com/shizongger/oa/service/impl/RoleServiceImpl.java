package com.shizongger.oa.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import com.shizongger.oa.base.DaoSupportImpl;
import com.shizongger.oa.domain.Role;
import com.shizongger.oa.service.RoleService;

@Service
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService {

	@SuppressWarnings("unused")
	private Log log = LogFactory.getLog(this.getClass());

	@Override
	public void add(Role entity) {
		super.add(entity);
	}

	@Override
	public void delete(Long id) {
		super.delete(id);
	}

	@Override
	public void update(Role entity) {
		super.update(entity);
	}

	@Override
	public Role selectById(Long id) {
		return super.selectById(id);
	}

	@Override
	public List<Role> selectAll() {
		return super.selectAll();
	}

	@Override
	public Set<Role> selectByIds(Long[] roleIdList) {
		List<Role> roleList = super.getByIds(roleIdList);
		//底层传来的是list,需要转为set
		return new HashSet(new ArrayList(roleList));
	}
	
}
