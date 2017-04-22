package com.shizongger.oa.action;

import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.shizongger.oa.base.BaseAction;
import com.shizongger.oa.domain.Department;
import com.shizongger.oa.util.Common;
import com.shizongger.oa.util.DepartmentUtil;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	
	/**
	 * 记录部门的上级部门id
	 */
	private String parentId;
	
	private Log log = LogFactory.getLog(this.getClass());
	
	public String list() throws Exception {
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		
		//查找所有的顶级部门,顶级部门没有上级部门
		if(Common.isEmpty(parentId)) {
			List<Department> topDepartment = departmentService.findTopDept();
			request.put("departmentList", topDepartment);
		} else {
			List<Department> departmentList = departmentService.findChildren(new Long(parentId));
			request.put("departmentList", departmentList);			
		}
		
		return "list";
	}
	
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		
		return "toList";
	}
	
	public String addUI() throws Exception {
		log.info("上级部门是:" + parentId);

		//查出所有的部门
//		List<Department> deptList = departmentService.findAll();
//		ActionContext.getContext().put("deptList", deptList);
		//查找所有部门-树形结构
		List<Department> topDept = departmentService.findTopDept();
		List<Department> departmentList = DepartmentUtil.getAllDepartment(topDept);
		ActionContext.getContext().put("deptList", departmentList);

		return "saveUI";
	}
	
	public String add() throws Exception {
		log.info("上级部门是:" + parentId);
		
		Department parentDept = departmentService.getById(Long.parseLong(parentId));
		model.setParent(parentDept);
		
		departmentService.save(model);
		
		return "toList";
	}
	
	public String editUI() throws Exception {
		
//		//查出所有的部门
//		List<Department> deptList = departmentService.findAll();
//		ActionContext.getContext().put("deptList", deptList);
//		
		//准备数据,departmentList
		Department department = departmentService.getById(model.getId());
		ActionContext.getContext().put("department", department);
		
		//1.所有部门查出
//		List<Department> departmentList = departmentService.findAll();
//		ActionContext.getContext().put("deptList", departmentList);
		
		//查找所有部门-树形结构
		List<Department> topDept = departmentService.findTopDept();
		List<Department> departmentList = DepartmentUtil.getAllDepartment(topDept);
		ActionContext.getContext().put("deptList", departmentList);
		
		//2.当前部门
		if(!Common.isEmpty(parentId)) {
			Department dept = departmentService.getById(Long.parseLong(parentId));
			if (dept != null) {
				parentId = dept.getId().toString();
			}
		} else if(model.getId() != null) {
			Department dept = departmentService.getById(model.getId());
			if (dept != null) {
				parentId = dept.getId().toString();
			}
		}

		return "saveUI";
	}
	
	public String edit() throws Exception {
		Department department = departmentService.getById(model.getId());
		Department departmentDept = departmentService.getById(Long.parseLong(parentId));
		
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		department.setParent(departmentDept);
		
		departmentService.update(department);
	
		return "toList";
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}
