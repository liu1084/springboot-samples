package com.jim.redis.service.impl;

import com.jim.redis.model.domain.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * @author 刘军
 * @version ${VERSION}
 * @project springboot-data-redis
 * @create 2018/8/10
 */
public interface StudentRepository extends CrudRepository<Student, String> {
}
