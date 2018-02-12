package com.johnnking.appsecdemo;

import javax.servlet.ServletContextEvent;

import com.johnnking.appsecdemo.CommentManager;
import com.johnnking.appsecdemo.UserManager;

public class Listener implements javax.servlet.ServletContextListener {

    public final void contextInitialized(final ServletContextEvent context) {
        try {
	        CommentManager.init();
            UserManager.init();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void contextDestroyed(final ServletContextEvent context) {

    }
}