/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.milos.univesitycourse.constant.WebConstants;
import org.milos.univesitycourse.domain.Assistant;
import org.milos.univesitycourse.domain.Professor;
import org.milos.univesitycourse.service.ILecturerService;
import org.milos.univesitycourse.service.impl.LecturerService;

/**
 *
 * @author Milos
 */
public class DeleteLecturerAction extends AbstractAction {

    ILecturerService lecturerService;

    public DeleteLecturerAction() {
        lecturerService = new LecturerService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Long lecturerId = Long.parseLong(request.getParameter("lecturerId"));
        try {
            lecturerService.deleteLecturer(lecturerId);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("error_message", ex.getMessage());
        } finally {
            List<Professor> professors = lecturerService.retrieveAllProfessors();
            List<Assistant> assistants = lecturerService.retrieveAllAssistants();
            request.setAttribute("professor_list", professors);
            request.setAttribute("assistant_list", assistants);
            return WebConstants.DISPLAY_LECTURERS_PAGE;
        }
    }

}
