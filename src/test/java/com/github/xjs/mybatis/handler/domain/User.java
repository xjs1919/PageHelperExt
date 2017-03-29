package com.github.xjs.mybatis.handler.domain;

import java.io.Serializable;

public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 9030785649977959711L;

	private Integer id;
	private String username;
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
