/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.dao;

import java.util.List;
import org.milos.univesitycourse.domain.Assistant;
import org.milos.univesitycourse.domain.Lecturer;
import org.milos.univesitycourse.domain.Professor;

/**
 *
 * @author Milos
 */
public interface ILecturerDAO {
    public List<Professor> getAllProfessors();
    public List<Assistant> getAllAssistants();
    public Professor getProfessorById(Long id) throws Exception;
    public Assistant getAssistantById(Long id) throws Exception;
}
