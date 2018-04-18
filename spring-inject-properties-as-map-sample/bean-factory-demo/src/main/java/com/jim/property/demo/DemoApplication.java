package com.jim.property.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean(name = "app-property")
    public PropertiesFactoryBean getAppPropertyAsMap(){
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("application.properties"));
        return bean;
    }

    @Resource(name = "app-property")
    private Map<String, String> myProperties;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


	}

    @Override
    public void run(String... args) throws Exception {
	    myProperties.forEach((key, value) ->{
            System.out.println("Key: " + key);
            System.out.println("Value: " + value);
        });
    }
}
