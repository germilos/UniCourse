/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.*;
import org.milos.univesitycourse.domain.Course;
import org.milos.univesitycourse.dao.ICourseDAO;
import org.milos.univesitycourse.listeners.EMF;

/**
 *
 * @author Milos
 */
public class CourseDAO implements ICourseDAO {

    private EntityManager em;

    public CourseDAO() {
    }

    @Override
    public List<Course> getAll() {
        em = EMF.createEntityManager();
        List<Course> courses = em.createQuery("SELECT c FROM Course c")
                .getResultList();
        em.close();
        return courses;
    }

    @Override
    public Course getById(Long id) throws Exception {
        em = EMF.createEntityManager();
        Course course = em.find(Course.class, id);
        try {
            if (course != null) {
                return course;
            } else {
                throw new Exception("No course by that id found!");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Course insert(Course course) throws Exception {

        em = EMF.createEntityManager();
        List<Course> courses = em.createQuery("SELECT c FROM Course c WHERE c.id = :id")
                .setParameter("id", course.getId()).getResultList();
        try {
            if (courses.isEmpty()) {
                em.getTransaction().begin();
                em.persist(course);
                em.getTransaction().commit();
                return course;
            } else {
                throw new Exception("Course with that id already exists!");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Course course) {

        em = EMF.createEntityManager();
        em.getTransaction().begin();

        Course foundCourse = em.find(Course.class, course.getId());
        if (foundCourse == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) throws Exception {
        em = EMF.createEntityManager();
        Course course = em.find(Course.class, id);

        try {
            if (course != null) {
                em.getTransaction().begin();
                course.getCourseUnits().clear();
                course.getLecturers().clear();
                em.remove(course);
                em.getTransaction().commit();
            } else {
                throw new Exception("Course with that id not in database!");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }
}
