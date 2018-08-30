package com.jim.web.reports.model.repository;

import com.jim.web.reports.model.entity.User;

public interface IUserRepository {
    User findUserById(Integer id);
}
