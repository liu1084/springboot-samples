package com.jim.vertx;

import com.jim.vertx.verticles.ArticleRecipientVerticle;
import com.jim.vertx.verticles.ServerVerticle;
import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Configuration
@EnableJpaRepositories("com.jim.vertx.repository")
@EntityScan("com.jim.vertx.entity")
@ComponentScan(basePackages = {"com.jim.vertx"})
public class DemoApplication {
    @Autowired private ServerVerticle serverVerticle;
    @Autowired private ArticleRecipientVerticle clientVerticle;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
    public void deployVerticle(){
	    final Vertx vertx = Vertx.vertx();
	    vertx.deployVerticle(serverVerticle);
	    vertx.deployVerticle(clientVerticle);
    }
}
