package com.jim.mongodb.config;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.EnumSet;

/**
 * @author: liu jun
 * @date: 20:30 2017/12/14
 * @ver: 1.0
 * @desc:
 */

public enum EnumResponseStatus {
	OK("ok", 2000),
	EMPTY("empty", 2001),
	EXCEPTION("exception", 3000),
	ERROR("error", 4000),
	UNKNOWN("unknown", 5000);

	private String name;
	private int code;

	EnumResponseStatus(String name, int code){
		this.name = name;
		this.code = code;
	}
	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}

//	public static void main(String[] args) {
//		for (EnumResponseStatus status : EnumSet.range(EnumResponseStatus.OK, EnumResponseStatus.UNKNOWN)){
//			System.out.println(status.getName() + "->" + status.getCode());
//		}
//
//		EnumSet<EnumResponseStatus> set = EnumSet.of(EnumResponseStatus.ERROR);
//		for (EnumResponseStatus status : set){
//			System.out.println(status.code);
//		}
//	}
}
