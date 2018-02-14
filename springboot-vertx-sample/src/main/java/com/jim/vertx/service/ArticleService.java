package com.jim.vertx.service;

import com.jim.vertx.entity.Article;
import com.jim.vertx.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘军
 * @version 1.0
 * @project springboot-vertx-sample
 * @create 2018/2/14
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticle(){
        return articleRepository.findAll();
    }
}
