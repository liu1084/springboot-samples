package com.jim.redirect.model.entity;

import org.springframework.stereotype.Component;

/**
 * @author: liu jun
 * @date: 07:02 2017/12/10
 * @ver: 1.0
 * @desc:
 */
@Component
public class User {
	private String id;
	private String username;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
