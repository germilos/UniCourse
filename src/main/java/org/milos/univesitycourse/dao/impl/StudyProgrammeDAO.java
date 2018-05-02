/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.milos.univesitycourse.dao.IStudyProgrammeDAO;
import org.milos.univesitycourse.domain.StudyProgramme;
import org.milos.univesitycourse.listeners.EMF;

/**
 *
 * @author Milos
 */
public class StudyProgrammeDAO implements IStudyProgrammeDAO {

    private EntityManager em;
    
    @Override
    public List<StudyProgramme> getAll() {
        em = EMF.createEntityManager();
        List<StudyProgramme> studyProgrammes = em.createQuery("SELECT s FROM StudyProgramme s")
                .getResultList();
        em.close();
        return studyProgrammes;
    }

    @Override
    public StudyProgramme getById(Long id) throws Exception {
        em = EMF.createEntityManager();
        StudyProgramme studyProgramme = em.find(StudyProgramme.class, id);
        try {
            if (studyProgramme != null) {
                return studyProgramme;
            } else {
                throw new Exception("No study programme by that id found!");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }
    
}
