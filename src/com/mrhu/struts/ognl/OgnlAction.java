package com.mrhu.struts.ognl;

import com.opensymphony.xwork2.ActionSupport;

public class OgnlAction extends ActionSupport {

	private String username;
	private String password;
	
	public OgnlAction() {
		
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
	
	public String execute() {
		return SUCCESS;
	}
}
