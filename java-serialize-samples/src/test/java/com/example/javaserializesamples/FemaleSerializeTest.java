package com.example.javaserializesamples;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * Author: Jim
 * Date: 2018/8/23:下午3:30
 * Description:
 */

public class FemaleSerializeTest {

    @Test
    public void test1() throws IOException {
        Female p1 = new Female();
        p1.setAge(20);
        p1.setName("liqing");
        p1.setBoyFriends(10);
        Address address1 = new Address();
        address1.setNumber("1111");
        p1.setAddress(address1);

        FileOutputStream fileOutputStream = new FileOutputStream("female.txt");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(p1);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    @Test
    public void test2() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("female.txt"));
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Object person = inputStream.readObject();
        Assert.assertTrue(person instanceof Person);
        Female girl = (Female) person;
        assertEquals(girl.getAge(), 20);
        assertEquals(10, girl.getBoyFriends());
    }
}
