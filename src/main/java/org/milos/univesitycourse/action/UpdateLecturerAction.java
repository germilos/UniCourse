/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.action;

import javax.servlet.http.HttpServletRequest;
import org.milos.univesitycourse.constant.WebConstants;
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
public class UpdateLecturerAction extends AbstractAction {

    ILecturerService lecturerService;
    IDepartmentService departmentService;

    public UpdateLecturerAction() {
        initServices();
    }

    @Override
    public String execute(HttpServletRequest request) {

        Long lecturerId = Long.parseLong(request.getParameter("lecturer_id"));
        String name = request.getParameter("lecturer_name");
        String surname = request.getParameter("lecturer_surname");
        Long departmentId = Long.parseLong(request.getParameter("lecturer_dept"));

        Department newDepartment = null;
        Professor professor = null;
        Assistant assistant = null;
        try {
            newDepartment = departmentService.retrieveById(lecturerId);

            if ("professor".equals(request.getParameter("lecturer_type"))) {
                    professor = lecturerService.retrieveProfessorById(lecturerId);
                    professor.setNameSurname(name + " " + surname);
                    professor.setFieldOfExpertise(request.getParameter("lecturer_field"));
                    professor.setDeptIdFk(newDepartment);
                    professor.setNumOfResearch(Integer.parseInt(request.getParameter("lecturer_res_papers")));
                    professor.setPosition(ProfessorType.valueOf(request.getParameter("lecturer_postition")));
                    lecturerService.updateLecturer(professor);
            } else if ("assistant".equals(request.getParameter("lecturer_type"))) {
                    assistant = lecturerService.retrieveAssistantById(lecturerId);
                    assistant.setNameSurname(name + " " + surname);
                    assistant.setFieldOfExpertise(request.getParameter("lecturer_field"));
                    assistant.setDeptIdFk(newDepartment);
                    assistant.setDiplomaType(DiplomaType.valueOf(request.getParameter("lecturer_diploma")));
                    lecturerService.updateLecturer(assistant);
            }
            request.setAttribute("message", "Lecturer successfully updated!");
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("error_message", ex.getMessage());
        } finally {
            request.setAttribute("assistant_list", lecturerService.retrieveAllAssistants());
            request.setAttribute("professor_list", lecturerService.retrieveAllProfessors());
            return WebConstants.DISPLAY_LECTURERS_PAGE;
        }
    }

    private void initServices() {
        lecturerService = new LecturerService();
        departmentService = new DepartmentService();
    }

}
