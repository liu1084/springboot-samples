package com.jim.annotation.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log
public class RedisCacheAspect {

    @Autowired private RedisHelper redisHelper;
    @Pointcut("@annotation(RedisCache)")
    private void cache(){

    }

    @Around(value = "cache()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
            Object [] args = proceedingJoinPoint.getArgs();
            redisHelper.saveCache(result.getClass().getName() + "-" + args[0], result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
