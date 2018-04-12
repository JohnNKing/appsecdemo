package com.johnnking.appsecdemo.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionController {

    private static final Strategy STRATEGY = new CookieStrategy();
    // private static final Strategy STRATEGY = new CustomSessionStrategy();
    // private static final Strategy STRATEGY = new JEESessionStrategy();

    public static String getUsername(HttpServletRequest request, HttpServletResponse response) {
        return STRATEGY.getUsername(request, response);
    }

    public static void login(String username, HttpServletRequest request,
            HttpServletResponse response) {

        STRATEGY.login(username, request, response);
    }

    public static void logout(HttpServletRequest request, HttpServletResponse response) {
        STRATEGY.logout(request, response);
    }
}