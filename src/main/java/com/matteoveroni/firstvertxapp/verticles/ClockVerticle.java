package com.matteoveroni.firstvertxapp.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import java.util.Date;

public class ClockVerticle extends AbstractVerticle {

    private final static String NAME = "FIRST_VERTICLE";

    @Override
    public void start(Future<Void> future) throws Exception {
        System.out.println(NAME + " started");

        long timerID = vertx.setPeriodic(1000, id -> {
            Date currentTime = new Date();
            vertx.eventBus().publish("time", currentTime.toString());
        });

        future.complete();
    }

}
