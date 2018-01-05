package cn.g2link.web.reports.model.service;

import cn.g2link.web.reports.model.entity.User;
import cn.g2link.web.reports.model.repository.IUserCrudRepository;
import cn.g2link.web.reports.model.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired private IUserRepository userRepository;
    @Autowired private IUserCrudRepository userCrudRepository;

    @Override
    public User findUserById(Integer id) {
        return userCrudRepository.findUserById(id);
    }

    @Override
    public List<User> findAll() {
        return userCrudRepository.findAll();
    }

    @Override
    public int createUser(User user) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(List<User> users) {
        return 0;
    }
}
