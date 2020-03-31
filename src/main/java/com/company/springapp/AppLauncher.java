package com.company.springapp;

import com.company.springapp.server.ServerConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppLauncher {

    public static void main(String[] ars) {
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.register(ServerConfig.class);
            ctx.refresh();
            ctx.start();
    }

}
