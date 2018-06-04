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
import org.milos.univesitycourse.domain.Course;
import org.milos.univesitycourse.domain.Professor;
import org.milos.univesitycourse.service.ICourseService;
import org.milos.univesitycourse.service.ILecturerService;
import org.milos.univesitycourse.service.impl.CourseService;
import org.milos.univesitycourse.service.impl.LecturerService;

/**
 *
 * @author Milos
 */
public class DisplayLecturersPageAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        ILecturerService lecturerService = new LecturerService();

        List<Professor> professors = lecturerService.retrieveAllProfessors();
        List<Assistant> assistants = lecturerService.retrieveAllAssistants();
        
        if (professors.isEmpty() && assistants.isEmpty()) {
            request.setAttribute("error_message", "No lecturers found in database!");
        }
        request.setAttribute("professor_list", professors);
        request.setAttribute("assistant_list", assistants);
        return WebConstants.DISPLAY_LECTURERS_PAGE;
    }

    
}
