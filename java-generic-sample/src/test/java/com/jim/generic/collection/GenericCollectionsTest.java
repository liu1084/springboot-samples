package com.jim.generic.collection;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

@Test
public class GenericCollectionsTest {
    List<String> list = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    @BeforeTest
    public void setup(){
        list.add("String1");
        map.put("key1", 2);
        GenericCollections genericCollections = new GenericCollections(list, map);
    }

    @Test
    public void getListTest(){
        Assert.assertEquals(list.get(0).getClass(), String.class);
    }

    @Test
    public void getMapTest(){
        Assert.assertEquals(map.get("key1").getClass(), Integer.class);

        Set<String> keys = map.keySet();

        for (String key : keys){
            Assert.assertEquals(key.getClass(), String.class);
            Assert.assertEquals(map.get(key).getClass(), Integer.class);
        }
    }
}
