package com.jim.redis.template.model.service;

import com.jim.redis.template.config.StudentConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class RedisService<K, V> implements IRedis<K, V> {

    @Autowired
    private RedisTemplate redisTemplate;
    private ListOperations listOperations;
    private K key;

    @PostConstruct
    public void init() {
        listOperations = redisTemplate.opsForList();
        key = (K) StudentConstant.STUDENT_KEY;
    }

    @Override
    public void saveEntities(V entities) {
        listOperations.leftPushAll(key, entities);
    }

    @Override
    public List<V> getEntities() {
        return (List<V>) listOperations.range(key, 0, -1).get(0);
    }

    @Override
    public Long leftRemove(Integer index, V ele) {
        return listOperations.remove(key, index, ele);
    }

    @Override
    public Long rightRemove(Integer index, V ele) {
        return listOperations.remove(key, -index, ele);
    }

    @Override
    public void trimElement(Integer start, Integer end) {
        listOperations.trim(key, start, end);
    }

    @Override
    public V remove(K ele) {
        return (V) listOperations.remove(key, 0, ele);
    }
}