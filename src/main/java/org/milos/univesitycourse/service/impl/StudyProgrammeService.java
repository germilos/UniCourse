/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.service.impl;

import java.util.List;
import org.milos.univesitycourse.dao.IStudyProgrammeDAO;
import org.milos.univesitycourse.dao.impl.StudyProgrammeDAO;
import org.milos.univesitycourse.domain.StudyProgramme;
import org.milos.univesitycourse.service.IStudyProgrammeService;

/**
 *
 * @author Milos
 */
public class StudyProgrammeService implements IStudyProgrammeService {

    private IStudyProgrammeDAO studyProgrammeDAO;

    public StudyProgrammeService() {
        studyProgrammeDAO = new StudyProgrammeDAO();
    }
    
    @Override
    public List<StudyProgramme> retrieveAll() {
        return studyProgrammeDAO.getAll();
    }

    @Override
    public StudyProgramme retrieveById(Long id) throws Exception {
        return studyProgrammeDAO.getById(id);
    }
    
    
}
