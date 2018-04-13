package com.jim.annotation.service;
import com.jim.annotation.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends MongoRepository<User, String>, IUserRepositoryCustom {

    List<User> findAll();
    User findUserByName(String name);
}