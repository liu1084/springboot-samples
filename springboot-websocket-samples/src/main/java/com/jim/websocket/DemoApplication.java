package com.jim.websocket;

import com.jim.websocket.controller.MessageController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class DemoApplication {
	public static void main(String[] args) {
	    SpringApplication application = new SpringApplication(DemoApplication.class);
        ConfigurableApplicationContext context = application.run(args);
        MessageController.setApplicationContext(context);
	}
}
