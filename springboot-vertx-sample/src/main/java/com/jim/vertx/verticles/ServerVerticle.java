package com.jim.vertx.verticles;

/**
 * @author 刘军
 * @version 1.0
 * @project springboot-vertx-sample
 * @create 2018/2/15
 */

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.springframework.stereotype.Component;

@Component
public class ServerVerticle extends AbstractVerticle {

    private void getAllArticlesHandler(RoutingContext routingContext) {
        vertx.eventBus()
                .<String>send(ArticleRecipientVerticle.GET_ALL_ARTICLES, "", result -> {
                    if (result.succeeded()) {
                        routingContext.response()
                                .putHeader("content-type", "application/json")
                                .setStatusCode(200)
                                .end(result.result()
                                        .body());
                    } else {
                        routingContext.response()
                                .setStatusCode(500)
                                .end();
                    }
                });
    }

    @Override
    public void start() throws Exception {
        super.start();

        Router router = Router.router(vertx);
        router.get("/api/baeldung/articles")
                .handler(this::getAllArticlesHandler);

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(9090);
    }

}
