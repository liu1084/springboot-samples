package com.jim.redis.template.model.service;

import java.util.List;

public interface IRedis<K, V> {
    void saveEntities(V entities);
    List<V> getEntities();
    Long leftRemove(Integer index, V ele);
    Long rightRemove(Integer index, V ele);
    void trimElement(Integer start, Integer end);
    V remove(K ele);
}
