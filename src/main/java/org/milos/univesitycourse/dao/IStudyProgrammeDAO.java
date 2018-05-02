/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.dao;

import java.util.List;
import org.milos.univesitycourse.domain.StudyProgramme;

/**
 *
 * @author Milos
 */
public interface IStudyProgrammeDAO {
    public List<StudyProgramme> getAll();
    public StudyProgramme getById(Long id) throws Exception;
}
