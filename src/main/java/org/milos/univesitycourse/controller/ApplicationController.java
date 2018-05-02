/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.controller;

import javax.servlet.http.HttpServletRequest;
import org.milos.univesitycourse.action.AbstractAction;
import org.milos.univesitycourse.action.FactoryAction;

/**
 *
 * @author Milos
 */
public class ApplicationController {
    
    private static ApplicationController instance;
    
    private ApplicationController() {
        
    }
    
    public static ApplicationController getInstance() {
        if (instance == null)
            instance = new ApplicationController();
        return instance;
    }
    
    public String executeOperation(HttpServletRequest request) {
        String operation = request.getParameter("operation");
        AbstractAction action = FactoryAction.createActionFactory(operation);
        return action.execute(request);
    }
}
