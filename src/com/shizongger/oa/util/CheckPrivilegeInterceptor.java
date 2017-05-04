package com.shizongger.oa.util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.shizongger.oa.domain.User;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
//		System.out.println("---拦截器未拦截之前---");
//		String result = invocation.invoke();
//		System.out.println("---拦截器拦截之后---");
//		return result;
		
		//获取信息，从session中取出当前登录用户
		User user = (User) ActionContext.getContext().getSession().get("user");
		String nameSpace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		//对应的权限地址
		String privilegeUrl = nameSpace + actionName;
		
		//如果未登录
		if(user == null) {
			//如果是去登录的页面和登录请求，就放行
			if("/user_login".equals(privilegeUrl)) {
				return invocation.invoke();
			//否则跳转到登录页面
			} else {
				return "loginUI";
			}
		} else {
			//如果已经登录则判断是否有权限
			if(user.hasPrivilegeByUrl(privilegeUrl)) {
				return invocation.invoke();
			} else {
				return "noPrivilegeError";
			}
		}
	}

}
