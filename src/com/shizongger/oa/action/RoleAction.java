package com.shizongger.oa.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shizongger.oa.base.BaseAction;
import com.shizongger.oa.domain.Privilege;
import com.shizongger.oa.domain.Role;
import com.shizongger.oa.domain.User;
import com.shizongger.oa.service.RoleService;
import com.shizongger.oa.util.Common;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	
	private Log log = LogFactory.getLog(this.getClass());

	//权限的id数组
	private Long[] privilegeIds;
	
	/**
	 *岗位列表
	 * @return 跳往用户界面
	 * @throws Exception
	 */
	public String list() throws Exception {
		List<Role> roleList = roleService.selectAll();
		ActionContext.getContext().put("roleList", roleList);
		
		return "list";
	}
	
	/**
	 * 添加岗位界面
	 * @return 跳往用户添加用户界面
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		return "saveUI";
	}
	
	/**
	 * 添加岗位
	 * @return 重定向到用户列表
	 * @throws Exception
	 */
	public String add() throws Exception {
		roleService.add(model);
		
		return "toList";
	}
	
	/**
	 * 删除岗位操作
	 * @return 重定向到用户列表
	 * @throws Exception
	 */
	public String delete() throws Exception {
		roleService.delete(model.getId());
		
		return "toList";
	}
	
	/**
	 * 更新岗位的界面
	 * @return 跳往用户更新界面
	 * @throws Exception
	 */
	public String updateUI() throws Exception {
		Role role = roleService.selectById(model.getId());
		ActionContext.getContext().put("role", role);
		
		return "saveUI";
	}
	
	/**
	 * 更新岗位操作
	 * @return 重定向到用户列表
	 * @throws Exception
	 */
	public String update() throws Exception {
		Role role = roleService.selectById(model.getId());
		role.setDescription(model.getDescription());
		role.setName(model.getName());
		roleService.update(role);
		
		return "toList";
	}
	
	/**
	 *  @author shizongger
	 * @return 设置权限属性的视图
	 * @throws Exception 抛出异常
	 */
	public String privilegeUI() throws Exception {
		Role role = roleService.selectById(model.getId());
		ActionContext.getContext().getValueStack().push(role);

		//本角色对应的权限
		if(role.getPrivileges() != null) {
			Set<Privilege> privileges = role.getPrivileges();
			privilegeIds = new Long[privileges.size()];
			int index = 0;
			for(Privilege privilege : privileges) {
				privilegeIds[index++] = privilege.getId();
			}
		}
		log.debug("privilegeIds数组:" + privilegeIds);
		
		// 准备数据 privilegeList
		List<Privilege> privilegeList = privilegeService.selectAll();
		ActionContext.getContext().put("privilegeList", privilegeList);
		
		return "privilegeUI";
	}
	
	/**
	 * 设置权限
	 * @return 重定向到角色列表页面
	 * @throws Exception
	 */
	public String setPrivilege() throws Exception {
		//1.从数据库中取出role角色对象
		Role role = roleService.selectById(model.getId());
		
//		Set<Privilege> privileges = new HashSet<Privilege>();
//		遍历privilegeIds数组，将元素添加到hashset里面去
//		for(int i = 0; i < privilegeIds.length; i++) {
//			Privilege privilege = privilegeService.selectById(privilegeIds[i]);
//			privileges.add(privilege);
//		}
		
		//一步到位，直接根据id数组查询所有的权限
		List<Privilege> privilegeList = privilegeService.getByIds(privilegeIds);
		role.setPrivileges(new HashSet<Privilege>(privilegeList));
		roleService.update(role);
		
		return "toList";
	}

	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
}
