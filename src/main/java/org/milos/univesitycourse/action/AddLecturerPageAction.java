/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.action;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.milos.univesitycourse.constant.WebConstants;
import org.milos.univesitycourse.domain.Department;
import org.milos.univesitycourse.enumeration.DiplomaType;
import org.milos.univesitycourse.enumeration.ProfessorType;
import org.milos.univesitycourse.service.IDepartmentService;
import org.milos.univesitycourse.service.impl.DepartmentService;

/**
 *
 * @author Milos
 */
public class AddLecturerPageAction extends AbstractAction {

//    ICourseService courseService;
    IDepartmentService departmentService;
    List<DiplomaType> diplomaTypes;
    List<ProfessorType> professorTypes;

    public AddLecturerPageAction() {
        initServices();
    }

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        List<Department> departments = null;

        try {
            departments = departmentService.retrieveAll();

            populateRequest(departments, request);
            return WebConstants.ADD_LECTURER_PAGE;
        } catch (Exception ex) {
            ex.getMessage();
            return WebConstants.ADMIN_HOME_PAGE;
        }
    }

    private void initServices() {
//        courseService = new CourseService();
        departmentService = new DepartmentService();
        diplomaTypes = Arrays.asList(DiplomaType.values());
        professorTypes = Arrays.asList(ProfessorType.values());
    }

    private void populateRequest(List<Department> departments, HttpServletRequest request) {
        request.setAttribute("departments", departments);
        request.setAttribute("diploma_types", diplomaTypes);
        request.setAttribute("professor_types", professorTypes);
    }

}
