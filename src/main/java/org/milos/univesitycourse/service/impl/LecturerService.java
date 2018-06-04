/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.service.impl;

import java.util.List;
import org.milos.univesitycourse.dao.ILecturerDAO;
import org.milos.univesitycourse.dao.impl.LecturerDAO;
import org.milos.univesitycourse.domain.Assistant;
import org.milos.univesitycourse.domain.Lecturer;
import org.milos.univesitycourse.domain.Professor;
import org.milos.univesitycourse.service.ILecturerService;

/**
 *
 * @author Milos
 */
public class LecturerService implements ILecturerService {

    private ILecturerDAO lecturerDAO;

    public LecturerService() {
        lecturerDAO = new LecturerDAO();
    }

    @Override
    public List<Professor> retrieveAllProfessors() {
        return lecturerDAO.getAllProfessors();
    }

    @Override
    public List<Assistant> retrieveAllAssistants() {
        return lecturerDAO.getAllAssistants();
    }

    @Override
    public Professor retrieveProfessorById(Long id) throws Exception {
        return lecturerDAO.getProfessorById(id);
    }

    @Override
    public Assistant retrieveAssistantById(Long id) throws Exception {
        return lecturerDAO.getAssistantById(id);
    }

    @Override
    public Lecturer insertLecturer(Lecturer lecturer) throws Exception {
        return lecturerDAO.insertLecutrer(lecturer);
    }

    @Override
    public void updateLecturer(Lecturer lecturer) {
        lecturerDAO.updateLecturer(lecturer);
    }

    @Override
    public void deleteLecturer(Long id) throws Exception {
        lecturerDAO.deleteLecturer(id);
    }

}
