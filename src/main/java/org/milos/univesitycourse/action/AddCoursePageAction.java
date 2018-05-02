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
import org.milos.univesitycourse.domain.Assistant;
import org.milos.univesitycourse.domain.Course;
import org.milos.univesitycourse.domain.Department;
import org.milos.univesitycourse.domain.Lecturer;
import org.milos.univesitycourse.domain.Professor;
import org.milos.univesitycourse.domain.StudyProgramme;
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
            
            populateSession(studyProgrammes, departments, professors, assistants, session);

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

}
