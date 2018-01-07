package com.jim.mybatis.model.mapper;


import com.jim.mybatis.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<User> findAll();
    User findUserById(@Param("id") String id);
}
