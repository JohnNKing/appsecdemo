package com.johnnking.appsecdemo.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class JEESessionStrategy implements Strategy {

    public String getUsername(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("username");
        return username;
    }

    public void login(String username, HttpServletRequest request, HttpServletResponse response) {
        request.getSession(true).invalidate();
        request.getSession(true).setAttribute("username", username);
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession(true).invalidate();
    }
}