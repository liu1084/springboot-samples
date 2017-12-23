package com.jim.annotation.aop;

import org.bson.types.ObjectId;

public interface IUserService {
    User getUserById(ObjectId id);
    void saveUser(User user);
}
