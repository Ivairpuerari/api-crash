package com.aceleradev.api.crash;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Iniciado API Crash...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Finalizando API Crash...");
    }

}