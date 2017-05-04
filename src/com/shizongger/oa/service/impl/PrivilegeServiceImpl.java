package com.shizongger.oa.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shizongger.oa.base.DaoSupportImpl;
import com.shizongger.oa.domain.Privilege;
import com.shizongger.oa.service.PrivilegeService;

@Service
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService {

	@Override
	@Transactional
	public List<Privilege> findTopList() {
		List<Privilege> topPrivletList = this.getSession()
		.createQuery("FROM Privilege p WHERE p.parent IS NULL")
		.list();
		
		return topPrivletList;
	}

	@Override
	@Transactional
	public Collection<String> getAllPrivilegeUrls() {
		return getSession().createQuery(//
				"SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL")//
				.list();
	}

}
