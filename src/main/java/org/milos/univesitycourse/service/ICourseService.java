/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.service;

import java.util.List;
import org.milos.univesitycourse.domain.Course;

/**
 *
 * @author Milos
 */
public interface ICourseService {
    public List<Course> retrieveAll();
    public Course retrieveById(Long id) throws Exception;
    public Course save(Course course) throws Exception;
    public void update(Course course);
    public void remove(Long id) throws Exception;
}
