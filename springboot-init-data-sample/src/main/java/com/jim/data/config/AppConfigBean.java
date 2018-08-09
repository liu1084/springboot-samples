package com.jim.data.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Author: Jim
 * Date: 2018/8/3:下午2:20
 * Description:
 */
@Configuration(value = "appConfigBean")
@PropertySource("classpath:env/${spring.profiles.active}.properties")
@Getter
public class AppConfigBean {
    @Value("${swagger.base-package}")
    private String basePackage;

    @Value("${swagger.base-path}")
    private String basePath;

    @Value("${swagger.group-name}")
    private String groupName;

    @Value("${swagger.exclude-path}")
    private String excludePath;
}
