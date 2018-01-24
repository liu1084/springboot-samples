package com.jim.redis.template.controller;

import com.jim.redis.template.model.entity.Student;
import com.jim.redis.template.model.service.IRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired private IRedis redis;

    @GetMapping("/get")
    public List<Student> getAll(){
        return (List<Student>) redis.getEntities();
    }

    @PostMapping("/lremove/{index}")
    public Long leftRemove(@PathVariable("index") int index){
        Student student1 = new Student();
        student1.setId("1");
        student1.setUsername("jim");
        return redis.leftRemove(index, student1);
    }

    @PostMapping("/rremove/{index}")
    public Long rightRemove(@PathVariable("index") int index){
        Student student2 = new Student();
        student2.setId("2");
        student2.setUsername("jim");
        return redis.rightRemove(index, student2);
    }

    @PostMapping("/save")
    public List<Student> saveList(){

        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        student1.setId("1");
        student1.setUsername("jim");

        Student student2 = new Student();
        student2.setId("2");
        student2.setUsername("jim2");

        students.add(student1);
        students.add(student2);

        redis.remove(students);
        redis.saveEntities(students);
        return students;
    }
}
