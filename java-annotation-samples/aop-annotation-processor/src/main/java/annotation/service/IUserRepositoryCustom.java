package annotation.service;
import annotation.model.entity.User;

import java.util.List;

public interface IUserRepositoryCustom {
    List findUserByIds(String[] ids);
    void saveUser(User user);
}
