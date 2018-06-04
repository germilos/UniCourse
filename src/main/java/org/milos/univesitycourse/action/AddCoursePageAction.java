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
import org.milos.univesitycourse.domain.*;
import org.milos.univesitycourse.enumeration.Status;
import org.milos.univesitycourse.service.*;
import org.milos.univesitycourse.service.impl.*;

/**
 *
 * @author Milos
 */
public class AddCoursePageAction extends AbstractAction {

    ICourseService courseService;
    IStudyProgrammeService studyProgrammeService;
    IDepartmentService departmentService;
    ILecturerService lecturerService;
    List<Status> statuses;

    public AddCoursePageAction() {
        initServices();
    }

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        List<StudyProgramme> studyProgrammes = null;
        List<Department> departments = null;
        List<Professor> professors = null;
        List<Assistant> assistants = null;

        try {
            studyProgrammes = studyProgrammeService.retrieveAll();
            departments = departmentService.retrieveAll();
            professors = lecturerService.retrieveAllProfessors();
            assistants = lecturerService.retrieveAllAssistants();

            populateRequest(studyProgrammes, departments, professors, assistants, request);

            return WebConstants.ADD_COURSE_PAGE;
        } catch (Exception ex) {
            ex.getMessage();
            return WebConstants.ADMIN_HOME_PAGE;
        }
    }

    private void initServices() {
        courseService = new CourseService();
        studyProgrammeService = new StudyProgrammeService();
        departmentService = new DepartmentService();
        lecturerService = new LecturerService();
        statuses = Arrays.asList(Status.values());
    }

    private void populateSession(List<StudyProgramme> studyProgrammes,
            List<Department> departments, List<Professor> professors, List<Assistant> assistants,
            HttpSession session) {
        session.setAttribute("study_programmes", studyProgrammes);
        session.setAttribute("departments", departments);
        session.setAttribute("professors", professors);
        session.setAttribute("assistants", assistants);
        session.setAttribute("statuses", statuses);
    }

    private void populateRequest(List<StudyProgramme> studyProgrammes,
            List<Department> departments, List<Professor> professors,
            List<Assistant> assistants, HttpServletRequest request) {
        request.setAttribute("study_programmes", studyProgrammes);
        request.setAttribute("departments", departments);
        request.setAttribute("professors", professors);
        request.setAttribute("assistants", assistants);
        request.setAttribute("statuses", statuses);
    }

}
