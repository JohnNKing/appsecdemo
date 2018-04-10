package com.johnnking.appsecdemo.session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieStrategy implements Strategy {

    public String getUsername(HttpServletRequest request, HttpServletResponse response) {
        String username = null;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                }
            }
        }

        return username;
    }

    public void login(String username, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("username", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}