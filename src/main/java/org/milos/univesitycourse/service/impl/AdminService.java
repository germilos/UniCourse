/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.service.impl;

import org.milos.univesitycourse.dao.IAdminDAO;
import org.milos.univesitycourse.dao.impl.AdminDAO;
import org.milos.univesitycourse.domain.Admin;
import org.milos.univesitycourse.service.IAdminService;

/**
 *
 * @author Milos
 */
public class AdminService implements IAdminService {

    IAdminDAO adminDAO;

    public AdminService() {
        adminDAO = new AdminDAO();
    }
    
    @Override
    public Admin login(Admin admin) throws Exception {
        return adminDAO.getAdmin(admin);
    }
    
}
