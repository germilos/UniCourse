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

}
