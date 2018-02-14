package com.jim.vertx.util;

import com.jim.vertx.entity.Article;
import com.jim.vertx.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 * @author 刘军
 * @version 1.0
 * @project springboot-vertx-sample
 * @create 2018/2/14
 */
@Component
public class DBBootstrap implements CommandLineRunner {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void run(String... strings) throws Exception {
        IntStream.range(0, 10)
                .forEach(
                        repository -> this.articleRepository
                                .save(new Article(new Random().nextLong(), UUID.randomUUID().toString())));
    }
}
