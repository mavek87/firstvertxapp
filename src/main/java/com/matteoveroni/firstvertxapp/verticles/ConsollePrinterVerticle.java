package com.matteoveroni.firstvertxapp.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class ConsollePrinterVerticle extends AbstractVerticle {

    private final static String NAME = "SECOND_VERTICLE";

    @Override
    public void start(Future<Void> future) throws Exception {
        System.out.println(NAME + " started");

        vertx.eventBus().consumer("time", msg -> {
            System.out.println("New time event: " + msg.body());
        });

        future.complete();
    }

}
