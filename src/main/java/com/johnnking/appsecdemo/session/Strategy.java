package com.johnnking.appsecdemo.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Strategy {

    String getUsername(HttpServletRequest request);

    void login(String username, HttpServletRequest request, HttpServletResponse response);

    void logout(HttpServletRequest request, HttpServletResponse response);
}