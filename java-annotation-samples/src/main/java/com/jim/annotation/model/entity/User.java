package com.jim.annotation.model.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@Document(collection = "user")
public class User implements Serializable {
    @Id
    private String id;
    private String name;

    public User(String name){
        this.name = name;
    }
}
