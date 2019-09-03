package com.zzxx.crm.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PermissionInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 判断用户有没有登录
		Object obj = ActionContext.getContext().getSession().get("user");
		if(obj == null) {
			// 没有登录
			return "toLogin";
		}
		invocation.invoke();
		return null;
	}

}
