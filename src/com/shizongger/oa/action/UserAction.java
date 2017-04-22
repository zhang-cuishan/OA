package com.shizongger.oa.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.shizongger.oa.base.BaseAction;
import com.shizongger.oa.domain.Department;
import com.shizongger.oa.domain.Role;
import com.shizongger.oa.domain.User;
import com.shizongger.oa.util.DepartmentUtil;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{

	private Log log = LogFactory.getLog(this.getClass());	
	
	/**
	 * 所属部门id
	 */
	private Long departmentId;
	
	/**
	 * 所属岗位
	 */
	private Long[] roleIdList;
	
	/**
	 *用户列表
	 * @return 跳往用户界面
	 * @throws Exception
	 */
	public String list() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> request = (Map<String, Object>) actionContext.get("request");
		List<User> userList = userService.selectAll();
		request.put("userList", userList);
		
		return "list";
	}
	
	/**
	 * 添加用户界面
	 * @return 跳往用户添加用户界面
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		// 准备数据, departmentList
		List<Department> topList = departmentService.findTopDept();
		List<Department> departmentList = DepartmentUtil.getAllDepartment(topList);
		ActionContext.getContext().put("departmentList", departmentList);

		// 准备数据, roleList
		List<Role> roleList = roleService.selectAll();
		ActionContext.getContext().put("roleList", roleList);
		
		return "saveUI";
	}
	
	/**
	 * 添加用户
	 * @return 重定向到用户列表
	 * @throws Exception
	 */
	public String add() throws Exception {
		//从数据库中找到部门
		Department dept = departmentService.getById(departmentId);
		//从数据库中找到所有的岗位
		Set<Role> roleList = roleService.selectByIds(roleIdList);

		model.setDepartment(dept);
		model.setRoles(roleList);
		model.setPassword(DigestUtils.md5Hex("000000"));
		userService.add(model);
		return "toList";
	}
	
	/**
	 * 删除用户操作
	 * @return 重定向到用户列表
	 * @throws Exception
	 */
	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}
	
	/**
	 * 更新用户的界面
	 * @return 跳往用户更新界面
	 * @throws Exception
	 */
	public String updateUI() throws Exception {
		// 准备数据, departmentList
		List<Department> topList = departmentService.findTopDept();
		List<Department> departmentList = DepartmentUtil.getAllDepartment(topList);
		ActionContext.getContext().put("departmentList", departmentList);

		// 准备数据, roleList
		List<Role> roleList = roleService.selectAll();
		ActionContext.getContext().put("roleList", roleList);

		
		Long id = model.getId();
		User user = userService.selectById(id);
		
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("user", user);
		
		return "saveUI";
	}
	
	/**
	 * 更新用户操作
	 * @return 重定向到用户列表
	 * @throws Exception
	 */
	public String update() throws Exception {
		//1.从数据库查找user
		User user = userService.selectById(model.getId());
		
		user.setDescription(model.getDescription());
		user.setEmail(model.getEmail());
		user.setGender(model.getGender());
		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		user.setPhoneNumber(model.getPhoneNumber());
		
		//从数据库中找到部门
		Department dept = departmentService.getById(departmentId);
		//从数据库中找到所有的岗位
		Set<Role> roleList = roleService.selectByIds(roleIdList);		
		
		//3更新model(user)的属性
		user.setDepartment(dept);
		user.setRoles(roleList);
		
		//4将更新后的user存入数据库中
		userService.update(user);
		return "toList";
	}
	
	/**
	 *  登录页面
	 * @throws Exception
	 */
	public String loginUI() throws Exception {
		return "loginUI";
	}

	
	/**
	 * 登录功能
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		User user = userService.findByLoginNameAndPassword(model.getLoginName(), model.getPassword());
		if(user != null) {
			ActionContext.getContext().getSession().put("user", user);
			return "index";
		} else {
			return "loginUI";
		}
	}
	
	/**
	 * 注销功能
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		
		return "loginUI";
	}
	
	/**
	 * 密码初始化
	 * @throws Exception
	 */
	public String initPassword() throws Exception {
		//从数据库中获取用户
		User user = userService.selectById(model.getId());
		user.setPassword(DigestUtils.md5Hex("000000"));
		userService.update(user);
		
		return "toList";
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long[] getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(Long[] roleIdList) {
		this.roleIdList = roleIdList;
	}
	
}
