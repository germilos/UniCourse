/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.milos.univesitycourse.dao.impl.CourseDAO;
import org.milos.univesitycourse.domain.Course;
import org.milos.univesitycourse.service.ICourseService;
import org.milos.univesitycourse.dao.ICourseDAO;

/**
 *
 * @author Milos
 */
public class CourseService implements ICourseService {

    private ICourseDAO courseDAO;

    public CourseService() {
        courseDAO = new CourseDAO();
    }

    @Override
    public List<Course> retrieveAll() {
        return courseDAO.getAll();
    }

    @Override
    public Course retrieveById(Long id) throws Exception {
        return courseDAO.getById(id);
    }

    @Override
    public Course save(Course course) throws Exception {
        return courseDAO.insert(course);
    }

    @Override
    public void update(Course course) {
        courseDAO.update(course);
    }

    @Override
    public void remove(Long id) throws Exception {
        courseDAO.delete(id);
    }
    
}
