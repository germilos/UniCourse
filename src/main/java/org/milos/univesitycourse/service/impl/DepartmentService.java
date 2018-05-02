/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.service.impl;

import java.util.List;
import org.milos.univesitycourse.dao.IDepartmentDAO;
import org.milos.univesitycourse.dao.impl.DepartmentDAO;
import org.milos.univesitycourse.domain.Department;
import org.milos.univesitycourse.service.IDepartmentService;

/**
 *
 * @author Milos
 */
public class DepartmentService implements IDepartmentService {

    private IDepartmentDAO departmentDAO;

    public DepartmentService() {
        departmentDAO = new DepartmentDAO();
    }
    @Override
    public List<Department> retrieveAll() {
        return departmentDAO.getAll();
    }

    @Override
    public Department retrieveById(Long id) throws Exception {
        return departmentDAO.getById(id);
    }
}
