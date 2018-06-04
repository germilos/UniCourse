/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.action;

import com.mysql.cj.api.Session;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Hibernate;
import org.milos.univesitycourse.constant.WebConstants;
import org.milos.univesitycourse.domain.*;
import org.milos.univesitycourse.enumeration.Status;
import org.milos.univesitycourse.service.*;
import org.milos.univesitycourse.service.impl.*;

/**
 *
 * @author Milos
 */
public class DisplayCoursePageAction extends AbstractAction {

    ICourseService courseService;
    IStudyProgrammeService studyProgrammeService;
    IDepartmentService departmentService;
    ILecturerService lecturerService;
    List<Status> statuses;

    public DisplayCoursePageAction() {
        initServices();
    }

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        Course course;
        List<StudyProgramme> studyProgrammes;
        List<Department> departments;
        List<Professor> allProfessors = null;
        List<Assistant> allAssistants = null;
        List<Professor> courseProfessors = null;
        List<Assistant> courseAssistants = null;

        try {

            Long courseId = Long.parseLong(request.getParameter("courseId"));

            course = courseService.retrieveById(courseId);
            studyProgrammes = studyProgrammeService.retrieveAll();
            departments = departmentService.retrieveAll();
            allProfessors = lecturerService.retrieveAllProfessors();
            allAssistants = lecturerService.retrieveAllAssistants();

            courseProfessors = new ArrayList<>();
            courseAssistants = new ArrayList<>();

            sortCourseLecturers(course, courseProfessors, courseAssistants);
            allProfessors.removeAll(courseProfessors);
            allAssistants.removeAll(courseAssistants);
            populateRequest(course, studyProgrammes, departments, allProfessors,
                    allAssistants, courseProfessors, courseAssistants, request);

            return WebConstants.DISPLAY_COURSE_PAGE;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("error_message", ex.getMessage());
            return WebConstants.DISPLAY_COURSES_PAGE;
        }
    }

    // Allocate retrieved lecturer list to professor/assitant lists
    private void sortCourseLecturers(Course course, List<Professor> courseProfessors, List<Assistant> courseAssistants) {
        for (Object lecturer : course.getLecturers()) {
            if (lecturer instanceof Professor) {
                Professor p = (Professor) lecturer;
                courseProfessors.add(p);
            } else if (lecturer instanceof Assistant) {
                Assistant a = (Assistant) lecturer;
                courseAssistants.add(a);
            }
        }
    }

    private void initServices() {
        courseService = new CourseService();
        studyProgrammeService = new StudyProgrammeService();
        departmentService = new DepartmentService();
        lecturerService = new LecturerService();
        statuses = Arrays.asList(Status.values());
    }

    private void populateRequest(Course course, List<StudyProgramme> studyProgrammes,
            List<Department> departments, List<Professor> remainingProfessors,
            List<Assistant> remainingAssistants, List<Professor> courseProfessors,
            List<Assistant> courseAssistants, HttpServletRequest req) {
        req.setAttribute("selected_course", course);
        req.setAttribute("study_programmes", studyProgrammes);
        req.setAttribute("departments", departments);
        req.setAttribute("remaining_professors", remainingProfessors);
        req.setAttribute("remaining_assistants", remainingAssistants);
        req.setAttribute("course_professors", courseProfessors);
        req.setAttribute("course_assistants", courseAssistants);
        req.setAttribute("statuses", statuses);
    }
}
