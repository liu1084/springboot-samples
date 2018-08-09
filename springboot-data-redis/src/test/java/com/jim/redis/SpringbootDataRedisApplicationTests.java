package com.jim.redis;

import com.jim.redis.model.domain.Student;
import com.jim.redis.service.impl.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDataRedisApplicationTests {

    @Autowired private StudentRepository studentRepository;

	@Test
	public void saveStudent(){
        Student student = new Student();
        student.setId("1");
        student.setName("liujun");
        student.setGrade(9);
        student.setGender(Student.Gender.MALE);

        studentRepository.save(student);
        Student student1 = studentRepository.findOne("1");
        assert student1 != null;
        assert student1.getId().equals("1");
    }

}
