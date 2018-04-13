package com.jim.annotation.service.aop;
import com.google.gson.Gson;
import com.jim.annotation.model.entity.User;
import com.jim.annotation.service.IUserRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Slf4j
public class AOPAnnotationProcessor {
    @Pointcut("@annotation(com.jim.annotation.aop.RedisCache)")
    private void cache() {
    }

    @Autowired
    private RedisTemplate<String, String> template;
    private ValueOperations<String, String> ops;
    @Autowired
    IUserRepositoryImpl userRepository;

    @PostConstruct
    public void init() {
        ops = template.opsForValue();
    }

    @AfterReturning(returning = "ret", pointcut = "cache()")
    public void afterMethodReturning(Object ret) {
        if (!template.hasKey("user")) {
            //300秒缓存
            ops.set("user", new Gson().toJson(ret), 300, TimeUnit.SECONDS);
        }
    }
}
