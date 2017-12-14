package com.jim.mongodb.controller;

import com.jim.mongodb.config.EnumResponseStatus;
import com.jim.mongodb.model.entity.User;
import com.jim.mongodb.model.entity.dto.APIResponseDTO;
import com.jim.mongodb.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * @author: liu jun
 * @date: 22:38 2017/12/14
 * @ver: 1.0
 * @desc:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@GetMapping
	public APIResponseDTO findUsers() throws Exception {
		List<User> users = userService.findUsers();
		if (CollectionUtils.isEmpty(users)){
			return APIResponseDTO.toEmptyResponse(null, EnumResponseStatus.EMPTY.getName());
		}

		return APIResponseDTO.toOkResponse(users, EnumResponseStatus.OK.getName());
	}

	@GetMapping("/{id}")
	public APIResponseDTO findUserById(@PathVariable("id") String id) throws Exception{
		User user= userService.findUserById(id);
		if (null == user) {
			return APIResponseDTO.toEmptyResponse(id, EnumResponseStatus.EMPTY.getName());
		}
		return APIResponseDTO.toOkResponse(user, EnumResponseStatus.OK.getName());
	}

	@PostMapping("/save")
	public void saveUser(@RequestBody User user){
		userService.save(user);
	}

	@PostMapping("/insert")
	public void insertUser(@RequestBody List<User> users) {
		userService.insert(users);
	}

	@PostMapping("/delete/{id}")
	public void deleteUserById(@PathVariable("id") String id){
		userService.delete(id);
	}

	@PostMapping("/update")
	public void updateUser(@RequestBody User user){
		userService.update(user);
	}
}
