package com.apress.bookstore.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;

	public String execute() {
//		if (this.username.equals("vishal") && this.password.equals("password")) {
//			return "success";
//		} else {
//			addActionError(getText("error.login"));
//			return "error";
//		}
		Map<String, Object> parameters = ActionContext.getContext().getParameters();
		parameters.put("userName", this.username);
		parameters.put("password", this.password);
		ActionContext.getContext().setParameters(parameters);
		return "executeloginLink";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}