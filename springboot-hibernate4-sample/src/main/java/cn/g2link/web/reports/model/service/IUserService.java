package cn.g2link.web.reports.model.service;


import cn.g2link.web.reports.model.entity.User;

import java.util.List;

public interface IUserService {
    User findUserById(Integer id);
    List<User> findAll();
    int createUser(User user);
    int updateUser(User user);
    int deleteUser(List<User> users);
}
