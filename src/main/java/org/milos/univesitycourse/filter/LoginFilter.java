/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Milos
 */
//@WebFilter("/*")
public class LoginFilter implements Filter {

    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/login.jsp";
        String indexURI = req.getContextPath() + "/index.jsp";
        
        boolean loggedIn = (session != null && session.getAttribute("logined_user") != null);
        boolean indexRequest = req.getRequestURI().equals(indexURI);
        boolean loginRequest = req.getRequestURI().equals(loginURI);
        
        if (loggedIn || loginRequest || indexRequest || req.getRequestURI().equals(req.getContextPath()) || req.getRequestURI().isEmpty()) {
            chain.doFilter(req, resp);
        } else {
            resp.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
    }
    
}
