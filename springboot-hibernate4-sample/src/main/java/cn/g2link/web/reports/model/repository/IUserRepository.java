package cn.g2link.web.reports.model.repository;

import cn.g2link.web.reports.model.entity.User;

public interface IUserRepository {
    User findUserById(Integer id);
}
