package com.example.springbootreadymlsample.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties
@Component
@Data
public class GlobalProperties {
    private String email;
    private Integer threadPool;
}
