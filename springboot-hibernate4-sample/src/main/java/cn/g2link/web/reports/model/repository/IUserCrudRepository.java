package cn.g2link.web.reports.model.repository;

import cn.g2link.web.reports.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 可以直接注入到service中
 */
@Transactional
public interface IUserCrudRepository extends CrudRepository<User, Integer>{
    User findUserById(Integer id);
    List<User> findAll();
}
