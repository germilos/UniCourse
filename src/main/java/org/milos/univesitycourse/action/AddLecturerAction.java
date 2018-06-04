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
import org.milos.univesitycourse.domain.Department;
import org.milos.univesitycourse.domain.Lecturer;
import org.milos.univesitycourse.domain.Professor;
import org.milos.univesitycourse.enumeration.DiplomaType;
import org.milos.univesitycourse.enumeration.ProfessorType;
import org.milos.univesitycourse.enumeration.Status;
import org.milos.univesitycourse.service.ICourseService;
import org.milos.univesitycourse.service.IDepartmentService;
import org.milos.univesitycourse.service.ILecturerService;
import org.milos.univesitycourse.service.IStudyProgrammeService;
import org.milos.univesitycourse.service.impl.CourseService;
import org.milos.univesitycourse.service.impl.DepartmentService;
import org.milos.univesitycourse.service.impl.LecturerService;
import org.milos.univesitycourse.service.impl.StudyProgrammeService;

/**
 *
 * @author Milos
 */
public class AddLecturerAction extends AbstractAction {

    LecturerService lecturerService;
    IDepartmentService departmentService;

    public AddLecturerAction() {
        initServices();
    }

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        Long departmentId = Long.parseLong(request.getParameter("lecturer_dept"));
        String lecturerType = request.getParameter("lecturer_type");

        try {
            Department department = departmentService.retrieveById(departmentId);
            
            if ("assistant".equals(lecturerType)) {
                Assistant newAssistant = new Assistant(request.getParameter("lecturer_name") + " " +
                        request.getParameter("lecturer_surname"), request.getParameter("lecturer_field"),
                        department, DiplomaType.valueOf(request.getParameter("lecturer_diploma")));
                lecturerService.insertLecturer(newAssistant);
            } else if ("professor".equals(lecturerType)) {
                Professor newProfessor = new Professor(request.getParameter("lecturer_name") + " " +
                        request.getParameter("lecturer_surname"), request.getParameter("lecturer_field"),
                        department, ProfessorType.valueOf(request.getParameter("lecturer_position")),
                        Integer.parseInt(request.getParameter("lecturer_res_papers")));
                lecturerService.insertLecturer(newProfessor);
            }
            
            request.setAttribute("professor_list", lecturerService.retrieveAllProfessors());
            request.setAttribute("assistant_list", lecturerService.retrieveAllAssistants());
            request.setAttribute("message", "Lecturer successfully inserted!");
            
            return WebConstants.DISPLAY_LECTURERS_PAGE;

        } catch (Exception e) {
            request.setAttribute("error_message", e.getMessage());
            e.printStackTrace();
            return WebConstants.ADD_LECTURER_PAGE;
        }

    }

    private void initServices() {
        lecturerService = new LecturerService();
        departmentService = new DepartmentService();
    }
    
}
