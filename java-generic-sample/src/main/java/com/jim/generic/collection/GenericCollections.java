package com.jim.generic.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用泛型集合
 * 问题描述：你想在一个集合类中存储指定类型的数据，并且取得数据的时候不想使用向下类型强转。
 * 解决方法：使用java提供的泛型机制，在声明集合类型的时候带上正确的类型参数。
 *
 */
public class GenericCollections {

    private List<String> list = new ArrayList<>();
    private Map<String, Integer> map = new HashMap<>();

    public GenericCollections(List<String> l, Map<String, Integer> m){
        this.list = l;
        this.map = m;
    }

    public List<String> getList(){
        return list;
    }

    public Map<String, Integer> getMap(){
        return map;
    }
}
