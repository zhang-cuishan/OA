package com.shizongger.oa.action;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.shizongger.oa.domain.Privilege;
import com.shizongger.oa.service.PrivilegeService;

public class MyServletContextListener implements ServletContextListener {
	
	Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.debug("---销毁监听器---");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		PrivilegeService privilegeService = (PrivilegeService) ac.getBean("privilegeServiceImpl");
		List<Privilege> topPrivilegeList = privilegeService.findTopList();
		//将权限list放到比application作用域还大的ServletContext
		sc.setAttribute("topPrivilegeList", topPrivilegeList);
		
		// 准备数据：allPrivilegeUrls
		Collection<String> allPrivilegeUrls = privilegeService.getAllPrivilegeUrls();
		sc.setAttribute("allPrivilegeUrls", allPrivilegeUrls);		
	}
}
