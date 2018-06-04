/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.service;

import java.util.List;
import org.milos.univesitycourse.domain.Assistant;
import org.milos.univesitycourse.domain.Lecturer;
import org.milos.univesitycourse.domain.Professor;

/**
 *
 * @author Milos
 */
public interface ILecturerService {
    
    public List<Professor> retrieveAllProfessors();
    public List<Assistant> retrieveAllAssistants();
    public Professor retrieveProfessorById(Long id) throws Exception;
    public Assistant retrieveAssistantById(Long id) throws Exception;
    public Lecturer insertLecturer(Lecturer lecturer) throws Exception;
    public void updateLecturer(Lecturer lecturer);
    public void deleteLecturer(Long id) throws Exception;
}
