package annotation.service;
import annotation.model.entity.User;
import annotation.service.aop.RedisCache;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Service
public class UserRepositoryImpl implements IUserRepositoryCustom {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    private ValueOperations ops;

    @PostConstruct
    public void init() {
        ops = redisTemplate.opsForValue();
    }

    @Override
    @RedisCache(key = "user")
    public List<User> findUserByIds(String[] ids) {
        if (redisTemplate.hasKey("user")) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                List users = mapper.readValue((String) ops.get("user"), List.class);
                return users;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Query query = new Query(Criteria.where("_id").in(ids));
        return mongoTemplate.find(query, User.class);
    }

    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }
}
