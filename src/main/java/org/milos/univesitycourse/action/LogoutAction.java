/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.milos.univesitycourse.constant.WebConstants;

/**
 *
 * @author Milos
 */
public class LogoutAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return WebConstants.INDEX_PAGE;
    }
    
}
