package com.matteoveroni.firstvertxapp;

import com.matteoveroni.firstvertxapp.verticles.ServerVerticle;
import io.vertx.core.Vertx;

public class MainLoader {

    public static void main(String... args) {
        Vertx vertx = Vertx.vertx();

//        // Generates clock events using vertx periodic (of 1 second frequence)
//        vertx.deployVerticle(new ClockVerticle(), result -> {
//            if (result.succeeded()) {
//                String deploymentID = result.result();
//                System.out.println("Clock verticle deployment ID => " + deploymentID);
//            } else {
//                System.out.println("Clock verticle deployment failed");
//            }
//        });
//
//        // Prints clock on terminal
//        vertx.deployVerticle(new ConsollePrinterVerticle(), result -> {
//            if (result.succeeded()) {
//                String deploymentID = result.result();
//                System.out.println("Consolle printer verticle deployment ID => " + deploymentID);
//            } else {
//                System.out.println("Consolle printer deployment failed");
//            }
//        });

        // Deploy a web server
        vertx.deployVerticle(new ServerVerticle(), result -> {
            if (result.succeeded()) {
                String deploymentID = result.result();
                System.out.println("Server verticle deployment ID => " + deploymentID);
            } else {
                System.out.println("Server verticle deployment failed");
            }
        });
    }

}
