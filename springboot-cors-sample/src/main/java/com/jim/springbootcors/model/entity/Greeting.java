package com.jim.springbootcors.model.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: liu jun
 * @date: 15:11 2017/12/8
 * @ver: 1.0
 * @desc:
 */
public class Greeting {
	private long id;
	private String content;


	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = String.format("Hello, %s", content);
	}
}
