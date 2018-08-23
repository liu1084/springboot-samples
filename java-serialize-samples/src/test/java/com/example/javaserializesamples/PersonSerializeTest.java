package com.example.javaserializesamples;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Author: Jim
 * Date: 2018/8/23:下午3:05
 * Description:
 */

public class PersonSerializeTest {

    @Test
    public void test1() throws IOException {
        Person p1 = new Person();
        p1.setAge(10);
        p1.setName("刘军");
        Address address1 = new Address();
        address1.setNumber("1111");
        p1.setAddress(address1);

        FileOutputStream fileOutputStream = new FileOutputStream("person1.txt");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(p1);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    @Test
    public void test2() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("person1.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object p1 = objectInputStream.readObject();

        assertTrue(p1 instanceof Person);
        Person person = (Person) p1;
        assertEquals(person.getName(), "刘军");
        assertEquals(person.getAge(), 10);
    }
}
