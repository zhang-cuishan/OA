package com.shizongger.oa.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.shizongger.oa.domain.Privilege;

/**
 * @author shizongger
 * 权限数据的初始化工作
 */
@Component
public class Installer {
	
	@Autowired
	private SessionFactory sessionFactory;

	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * 权限数据的初始化工作
	 */
	@Transactional
	public void install() {
		log.debug("------------------程序开始安装咯------------------");
		Session session = sessionFactory.getCurrentSession();
		
		//一级菜单
		Privilege sysManage = new Privilege("系统管理", null, null);
		//二级菜单
		Privilege deptManage = new Privilege("部门管理", "/department_list", sysManage);
		Privilege roleManage = new Privilege("岗位管理", "/role_list", sysManage);
		Privilege userManage = new Privilege("用户管理", "/user_list", sysManage);
		session.save(sysManage);
		session.save(deptManage);
		session.save(roleManage);
		session.save(userManage);
		
		//具体链接，包括增删改查
		session.save(new Privilege("部门列表", "/department_list", deptManage));
		session.save(new Privilege("部门添加", "/department_add", deptManage));
		session.save(new Privilege("部门修改", "/department_edit", deptManage));
		session.save(new Privilege("部门删除", "/department_delete", deptManage));

		session.save(new Privilege("岗位列表", "/role_list", roleManage));
		session.save(new Privilege("岗位添加", "/role_add", roleManage));
		session.save(new Privilege("岗位修改", "/role_edit", roleManage));
		session.save(new Privilege("岗位删除", "/role_delete", roleManage));
		
		session.save(new Privilege("用户列表", "/user_list", userManage));
		session.save(new Privilege("用户添加", "/user_add", userManage));
		session.save(new Privilege("用户修改", "/user_edit", userManage));
		session.save(new Privilege("用户删除", "/user_delete", userManage));	
		session.save(new Privilege("密码初始化", "/user_initPassword", userManage));	
		
		//一级菜单网上交流
		Privilege netChat = new Privilege("网速交流", null, null);
		//二级菜单论坛管理,论坛
		Privilege forumManage = new Privilege("论坛管理", "/forumManage_list", netChat);
		Privilege forumList = new Privilege("论坛", "/forum_list", netChat);
		session.save(netChat);
		session.save(forumManage);
		session.save(forumList);
		
		//一级菜单，审批流转
		Privilege process = new Privilege("审批流转", null, null);
		Privilege menu1 = new Privilege("审批流程管理", "/processDefinition_list", process);
		Privilege menu2 = new Privilege("申请模板管理", "/template_list", process);
		Privilege menu3 = new Privilege("起草申请", "/flow_templateList", process);
		Privilege menu4 = new Privilege("我的申请查询", "/flow_myApplicationList", process);
		session.save(process);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		
		log.debug("-------------------程序安装结束-------------------");
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
	}

}
