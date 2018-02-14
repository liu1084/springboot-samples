package com.jim.vertx.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 刘军
 * @version 1.0
 * @project springboot-vertx-sample
 * @create 2018/2/14
 */
@Entity
@Data
public class Article {
    @Id @GeneratedValue()
    private Long id;
    private String article;
    private Article(){}
    public Article(Long id, String article){
        this.id = id;
        this.article = article;
    }
}
