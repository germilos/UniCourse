/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.dao;

import java.util.List;
import org.milos.univesitycourse.domain.Department;

/**
 *
 * @author Milos
 */
public interface IDepartmentDAO {
    public List<Department> getAll() throws Exception;
    public Department getById(Long id) throws Exception;
}
