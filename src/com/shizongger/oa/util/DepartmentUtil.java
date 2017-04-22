package com.shizongger.oa.util;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shizongger.oa.domain.Department;

/**
 * 部门管理工具类
 * @author shizongger
 */
public class DepartmentUtil {
	
	private static Log log = LogFactory.getLog(DepartmentUtil.class);
	
	public static List<Department> getAllDepartment(List<Department> topDept) {
		List<Department> deptList = new LinkedList<Department>();
		for(Department top : topDept) {
			travelDept(top, "┣", deptList);
		}
		
		return deptList;
	}

	private static void travelDept(Department dept, String prefix, List<Department> deptList) {
		//1.拿出当前的部门
		Department deptCopy = new Department();
		deptCopy.setId(dept.getId());
		deptCopy.setName(prefix + dept.getName());
		deptList.add(deptCopy);
		
		//遍历出子部门
		if(dept.getChildren() != null) {
			for(Department temp : dept.getChildren()) {
				travelDept(temp, "　" + prefix, deptList);
			}
		}
	}
}

