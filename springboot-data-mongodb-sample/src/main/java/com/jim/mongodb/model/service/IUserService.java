package com.jim.mongodb.model.service;

import com.jim.mongodb.model.entity.User;

import java.util.List;

/**
 * @author: liu jun
 * @date: 17:20 2017/12/14
 * @ver: 1.0
 * @desc:
 */
public interface IUserService {
	User findUserById(String id);
	List<User> findUsers();
	void save(User user);
	void insert(List<User> users);
	void update(User user);
	void delete(String id);
}
