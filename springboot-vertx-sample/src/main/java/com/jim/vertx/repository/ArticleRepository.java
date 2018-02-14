package com.jim.vertx.repository;

import com.jim.vertx.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 刘军
 * @version ${VERSION}
 * @project springboot-vertx-sample
 * @create 2018/2/14
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
