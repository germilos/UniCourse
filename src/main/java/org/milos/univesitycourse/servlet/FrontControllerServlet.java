/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.milos.univesitycourse.controller.ApplicationController;
import org.milos.univesitycourse.resolver.PageResolver;

/**
 *
 * @author Milos
 */
@WebServlet("/action")
public class FrontControllerServlet extends HttpServlet {
    protected void processRequestGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
    }
    
    protected void processRequestPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        String view = ApplicationController.getInstance().executeOperation(request);
        String nextPage = PageResolver.getInstance().getPage(view);
        RequestDispatcher dispacher = request.getRequestDispatcher(nextPage);
        dispacher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequestPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequestPost(req, resp);
    }
}
