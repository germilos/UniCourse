/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.milos.univesitycourse.dao.IDepartmentDAO;
import org.milos.univesitycourse.domain.Department;
import org.milos.univesitycourse.listeners.EMF;

/**
 *
 * @author Milos
 */
public class DepartmentDAO implements IDepartmentDAO {

    private EntityManager em; 
    
    @Override
    public List<Department> getAll() {
        em = EMF.createEntityManager();
        List<Department> departments = em.createQuery("SELECT d FROM Department d")
                .getResultList();
        em.close();
        return departments;
    }

    @Override
    public Department getById(Long id) throws Exception {
        em = EMF.createEntityManager();
        Department department = em.find(Department.class, id);
        try {
            if (department != null) {
                return department;
            } else {
                throw new Exception("No department by that id found!");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }
}
