package com.jim.mongodb.model.service;

import com.jim.mongodb.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: liu jun
 * @date: 17:25 2017/12/14
 * @ver: 1.0
 * @desc:
 */
@Service
public class UserService implements IUserService {
	@Autowired
	private MongoTemplate template;

	@Override
	public User findUserById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return template.findOne(query, User.class);
	}

	@Override
	public List<User> findUsers() {
		Query query = new Query(Criteria.where("enable").is(true));
		return template.find(query, User.class);
	}

	@Override
	public void save(User user) {
		template.save(user);
	}

	@Override
	public void insert(List<User> users) {
		for (User user : users) {
			template.insert(user);
		}
	}

	@Override
	public void update(User user) {
		Query query = new Query(Criteria.where("_id").is(user.get_id()));
		Update update = new Update().set("email", user.getEmail())
				.set("nickname", user.getNickname())
				.set("password", user.getPassword())
				.set("enable", user.isEnable());
		template.updateFirst(query, update, User.class);
	}

	@Override
	public void delete(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		Update update = new Update().set("enable", false);

		template.updateFirst(query, update, User.class);
	}
}
