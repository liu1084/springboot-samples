package com.jim.data.model.service;

import com.jim.data.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Jim
 * Date: 2018/8/3:下午5:23
 * Description:
 */

public interface IUserService extends JpaRepository<User, Long> {
}
