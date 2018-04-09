package com.johnnking.appsecdemo.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionManager {

    private static final Strategy STRATEGY = new CookieStrategy();
    // private static Strategy STRATEGY = new CustomSessionStrategy();
    // private static Strategy STRATEGY = new JEESessionStrategy();

    public static String getUsername(HttpServletRequest request) {
        return STRATEGY.getUsername(request);
    }

    public static void login(String username, HttpServletRequest request,
            HttpServletResponse response) {

        STRATEGY.login(username, request, response);
    }

    public static void logout(HttpServletRequest request, HttpServletResponse response) {
        STRATEGY.logout(request, response);
    }
}