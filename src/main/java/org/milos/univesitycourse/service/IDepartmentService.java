/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.service;

import java.util.List;
import org.milos.univesitycourse.domain.Department;
import org.milos.univesitycourse.domain.StudyProgramme;

/**
 *
 * @author Milos
 */
public interface IDepartmentService {
 
    public List<Department> retrieveAll();
    public Department retrieveById(Long id) throws Exception;
}
