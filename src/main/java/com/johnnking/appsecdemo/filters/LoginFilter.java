package com.johnnking.appsecdemo.filters;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Restricts access to pages that require authentication. Expects the username attribute to already
 * have been set in the servlet request (e.g. via SessionFilter).
 */
public class LoginFilter implements Filter {

    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
        this.filterConfig = null;
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

        String username = (String) request.getAttribute("username");
        if (username != null) {
            chain.doFilter(req, res);

        } else {
	        response.sendRedirect("login.jsp?destination="
                + URLEncoder.encode(request.getContextPath() + request.getRequestURI(), "UTF-8"));
        }
    }
}