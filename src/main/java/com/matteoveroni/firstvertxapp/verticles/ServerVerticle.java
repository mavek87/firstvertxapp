package com.matteoveroni.firstvertxapp.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;
import java.io.File;
import java.io.IOException;

public class ServerVerticle extends AbstractVerticle {

    private final static String SERVER_ADDRESS = "http://localhost";
    private final static int SERVER_PORT = 8080;
    private final static String WEB_ROOT_FOLDER = "webroot";

    @Override
    public void start(Future<Void> deploymentState) throws Exception {
        deployHttpServer(buildRouter(), deploymentState);
    }

    private Router buildRouter() throws IOException {
        Router mainRouter = Router.router(vertx);
        mainRouter.route().handler(BodyHandler.create());
        mainRouter.route("/*").handler(StaticHandler.create(WEB_ROOT_FOLDER));
        return mainRouter;
    }

    private void deployHttpServer(Router router, Future<Void> serverDeploymentState) {
        vertx.createHttpServer()
            .requestHandler(router::accept)
            .listen(SERVER_PORT, result -> {
                if (result.succeeded()) {
                    System.out.println("Server is listening at => " + SERVER_ADDRESS + ":" + SERVER_PORT);
                    serverDeploymentState.complete();
                } else {
                    System.err.println("Failed to listen on port 8080");
                    serverDeploymentState.fail(result.cause());
                }
            });
    }

}
