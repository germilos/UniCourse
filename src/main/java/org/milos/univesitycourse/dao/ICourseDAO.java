/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.dao;

import java.util.List;
import org.milos.univesitycourse.domain.Course;

/**
 *
 * @author Milos
 */
public interface ICourseDAO {
    
    public List<Course> getAll();
    public Course getById(Long id) throws Exception;
    public Course insert(Course course) throws Exception;
    public void update(Course course);
    public void delete(Long id) throws Exception;
    
}
