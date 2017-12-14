package com.jim.mongodb.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author: liu jun
 * @date: 17:13 2017/12/14
 * @ver: 1.0
 * @desc:
 */
@Setter
@Getter
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String _id;
	private String email;
	private String nickname;
	private String password;
	private boolean enable;
}
