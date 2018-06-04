/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.milos.univesitycourse.dao.ILecturerDAO;
import org.milos.univesitycourse.domain.Assistant;
import org.milos.univesitycourse.domain.Course;
import org.milos.univesitycourse.domain.Lecturer;
import org.milos.univesitycourse.domain.Professor;
import org.milos.univesitycourse.listeners.EMF;

/**
 *
 * @author Milos
 */
public class LecturerDAO implements ILecturerDAO {

    private EntityManager em;

    @Override
    public List<Professor> getAllProfessors() {
        em = EMF.createEntityManager();
        List<Professor> professors = em.createQuery("SELECT p FROM Professor p")
                .getResultList();
        em.close();
        return professors;
    }

    @Override
    public List<Assistant> getAllAssistants() {
        em = EMF.createEntityManager();
        List<Assistant> assistants = em.createQuery("SELECT a FROM Assistant a")
                .getResultList();
        em.close();
        return assistants;
    }

    @Override
    public Professor getProfessorById(Long id) throws Exception {
        em = EMF.createEntityManager();
        Professor professor = em.find(Professor.class, id);
        try {
            if (professor != null) {
                return professor;
            } else {
                throw new Exception("No professor by that id found!");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Assistant getAssistantById(Long id) throws Exception {
        em = EMF.createEntityManager();
        Assistant assistant = em.find(Assistant.class, id);
        try {
            if (assistant != null) {
                return assistant;
            } else {
                throw new Exception("No assistant by that id found!");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Lecturer insertLecutrer(Lecturer lecturer) throws Exception {
        em = EMF.createEntityManager();
        List<Lecturer> lecturers = em.createQuery("SELECT l FROM Lecturer l WHERE l.id = :id")
                .setParameter("id", lecturer.getId()).getResultList();
        try {
            if (lecturers.isEmpty()) {
                em.getTransaction().begin();
                em.persist(lecturer);
                em.getTransaction().commit();
                return lecturer;
            } else {
                throw new Exception("Lecturer with that id already exists!");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void updateLecturer(Lecturer lecturer) {
        em = EMF.createEntityManager();
        em.getTransaction().begin();

        Lecturer foundLecturer = em.find(Lecturer.class, lecturer.getId());
        if (foundLecturer == null) {
            em.persist(lecturer);
        } else {
            em.merge(lecturer);
        }

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteLecturer(Long id) throws Exception {
        em = EMF.createEntityManager();
        Lecturer lecturer = em.find(Lecturer.class, id);

        try {
            if (lecturer != null) {
                em.getTransaction().begin();
                if (!lecturer.getCourses().isEmpty()) {
                    throw new Exception("Lecturer is currently on courses!");
                } else {
                    lecturer.getCourses().clear();
                    em.remove(lecturer);
                    em.getTransaction().commit();
                }
            } else {
                throw new Exception("Lecturer with that id not in database!");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

}
