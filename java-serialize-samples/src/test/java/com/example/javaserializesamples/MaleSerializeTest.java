package com.example.javaserializesamples;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * Author: Jim
 * Date: 2018/8/23:下午4:08
 * Description:
 */

public class MaleSerializeTest {

    @Test
    public void test1() throws IOException {
        Male male = new Male();
        Weapon w1 = new Weapon();
        w1.setName("knife");
        male.setWeapons(w1);
        male.setName("敌人");
        male.setAge(100);

        FileOutputStream fileOutputStream = new FileOutputStream("enemy.txt");
        ObjectOutput objectOutput = new ObjectOutputStream(fileOutputStream);
        objectOutput.writeObject(male);
        objectOutput.flush();
        objectOutput.close();
    }

    @Test
    public void test2() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("enemy.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object male1 = objectInputStream.readObject();

        Assert.assertTrue(male1 instanceof Male);
        Male male = (Male) male1;
        Assert.assertEquals("knife", male.getWeapons().getName());
    }
}
