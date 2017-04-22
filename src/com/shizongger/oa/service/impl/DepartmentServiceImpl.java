package com.shizongger.oa.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shizongger.oa.base.DaoSupportImpl;
import com.shizongger.oa.domain.Department;
import com.shizongger.oa.service.DepartmentService;

@Service
@SuppressWarnings("unchecked")
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService {
	
	private Log log = LogFactory.getLog(this.getClass());	
	
	@Override
	public List<Department> findAll() {
		return super.selectAll();
	}

	@Override
	public void save(Department model) {

		super.add(model);
	}

	@Override
	public Department getById(Long id) {
		return super.selectById(id);
	}

	@Override
	public List<Department> findTopDept() {
		
		return getSession().createQuery(//
				"FROM Department d WHERE d.parent IS NULL")//
				.list();
	}

	@Override
	public List<Department> findChildren(Long parentId) {
		return getSession().createQuery(//
				"FROM Department d WHERE d.parent.id=?")//
				.setParameter(0, parentId)//
				.list();
	}	
}
