package com.example.springbootreadymlsample.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private List<Menu> menus = new ArrayList<>();
    private Compiler compiler = new Compiler();
    private String error;

    @Data
    public class Menu {
        private String title;
        private String name;
        private String path;
    }

    @Data
    public class Compiler {
        private Integer timeout;
        private String outputFolder;
    }
}
