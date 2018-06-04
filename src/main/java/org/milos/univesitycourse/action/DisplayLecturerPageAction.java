/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.action;

import com.sun.javafx.webkit.WebConsoleListener;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.milos.univesitycourse.constant.WebConstants;
import org.milos.univesitycourse.dao.IDepartmentDAO;
import org.milos.univesitycourse.domain.Assistant;
import org.milos.univesitycourse.domain.Department;
import org.milos.univesitycourse.domain.Professor;
import org.milos.univesitycourse.enumeration.DiplomaType;
import org.milos.univesitycourse.enumeration.ProfessorType;
import org.milos.univesitycourse.service.IDepartmentService;
import org.milos.univesitycourse.service.ILecturerService;
import org.milos.univesitycourse.service.impl.DepartmentService;
import org.milos.univesitycourse.service.impl.LecturerService;

/**
 *
 * @author Milos
 */
public class DisplayLecturerPageAction extends AbstractAction {

    ILecturerService lecturerService;
    IDepartmentService departmentService;
    List<DiplomaType> diplomas;
    List<ProfessorType> professorTypes;

    public DisplayLecturerPageAction() {
        initServices();
    }

    @Override
    public String execute(HttpServletRequest request) {

        Professor professor = null;
        Assistant assistant = null;
        List<Department> departments = null;
        String lecturerType = request.getParameter("lecturerType");
        Long lecturerId = Long.parseLong(request.getParameter("lecturerId"));
        String[] nameSurname = null;

        try {
            departments = departmentService.retrieveAll();

            if ("professor".equals(lecturerType)) {
                professor = lecturerService.retrieveProfessorById(lecturerId);
                nameSurname = professor.getNameSurname().split(" ");
                request.setAttribute("selected_lecturer", professor);
            } else if ("assistant".equals(lecturerType)) {
                assistant = lecturerService.retrieveAssistantById(lecturerId);
                System.out.println(assistant);
                nameSurname = assistant.getNameSurname().split(" ");
                request.setAttribute("selected_lecturer", assistant);
            }
            
            request.setAttribute("departments", departments);
            request.setAttribute("lecturer_name", nameSurname[0]);
            request.setAttribute("lecturer_surname", nameSurname[1]);
            request.setAttribute("diplomas", diplomas);
            request.setAttribute("professor_types", professorTypes);

            return WebConstants.DISPLAY_LECTURER_PAGE;

        } catch (Exception e) {
            e.getMessage();
            request.setAttribute("error_message", e.getMessage());
            return WebConstants.DISPLAY_LECTURERS_PAGE;
        }
    }

    private void initServices() {
        lecturerService = new LecturerService();
        departmentService = new DepartmentService();
        diplomas = Arrays.asList(DiplomaType.values());
        professorTypes = Arrays.asList(ProfessorType.values());
    }

}
