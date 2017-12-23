package com.jim.annotation.aop;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {
    String id;
    String name;

}
