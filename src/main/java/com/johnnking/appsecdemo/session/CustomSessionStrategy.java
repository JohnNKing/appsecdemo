package com.johnnking.appsecdemo.session;

import java.util.Base64;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomSessionStrategy implements Strategy {

    private String getSessionId(HttpServletRequest request, HttpServletResponse response) {

        // Try to get the session ID from a parameter
        String sessionId = request.getParameter("session");

        // Otherwise, get the session ID from a cookie
        if (sessionId == null) {
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("session")) {
                        sessionId = cookie.getValue();
                    }
                }
            }

        // Try to set the session cookie for next time
        } else {
            Cookie cookie = new Cookie("session", sessionId);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie); 
        }

        return sessionId;
    }

    private void createNewSession(HttpServletResponse response) {

        // Generate a new session ID
        byte[] randomBytes = new byte[32];
        new Random().nextBytes(randomBytes);
        String sessionId = Base64.getEncoder().encodeToString(randomBytes);

        // Add the session to the database
        try {
            CustomSessionManager.addSession(new CustomSession(sessionId));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set the session cookie
        Cookie cookie = new Cookie("session", sessionId);
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
    }

    public String getUsername(HttpServletRequest request, HttpServletResponse response) {
        String username = null;
        String sessionId = this.getSessionId(request, response);

        // Find this session in the database
        try {
            CustomSession session = CustomSessionManager.getSession(sessionId);

            if (session != null) {
                username = session.getUsername();
            } else {
                this.createNewSession(response);
            }

        } catch (Exception e) {
			e.printStackTrace();
		}

        return username;
    }

    public void login(String username, HttpServletRequest request, HttpServletResponse response) {
        String sessionId = this.getSessionId(request, response);

        // Set the username associated with the session in the database
        try {
            CustomSessionManager.updateSession(new CustomSession(sessionId, username));

        } catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = this.getSessionId(request, response);

        // Delete the session from the database
        try {
            CustomSessionManager.updateSession(new CustomSession(sessionId));

        } catch (Exception e) {
			e.printStackTrace();
		}
    }
}