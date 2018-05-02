/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.action;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.WebConnection;
import org.milos.univesitycourse.constant.WebConstants;
import org.milos.univesitycourse.domain.Admin;
import org.milos.univesitycourse.service.IAdminService;
import org.milos.univesitycourse.service.impl.AdminService;

/**
 *
 * @author Milos
 */
public class LoginAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        HttpSession session = request.getSession();
        IAdminService adminService = new AdminService();
        
        try {
            Admin admin = adminService.login(new Admin(username, password));
            session.setAttribute("logined_user", admin);
            
            return WebConstants.ADMIN_HOME_PAGE;
        } catch (Exception e) {
            session.setAttribute("error_message", "Wrong username or password!");
            return WebConstants.LOGIN_PAGE;
        }
    }
}
