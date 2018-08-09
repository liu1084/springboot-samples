package annotation.service.aop;
import annotation.service.UserRepositoryImpl;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Slf4j
public class AOPAnnotationProcessor {
    @Pointcut("@annotation(annotation.service.aop.RedisCache)")
    private void cache() {
    }

    @Autowired
    private RedisTemplate<String, String> template;
    private ValueOperations<String, String> ops;
    @Autowired
    UserRepositoryImpl userRepository;

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
