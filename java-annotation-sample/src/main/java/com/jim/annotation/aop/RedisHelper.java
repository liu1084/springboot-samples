package com.jim.annotation.aop;

import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisHelper<K, V> {
    @Autowired private StringRedisTemplate stringRedisTemplate;
    public <T> void saveCache(String key, T t){
        GsonBuilder json = new GsonBuilder();
        String value = json.create().toJson(t);
        stringRedisTemplate.opsForValue().set(key, value);
    }
}
