/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.action;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.milos.univesitycourse.constant.WebConstants;
import org.milos.univesitycourse.domain.Course;
import org.milos.univesitycourse.domain.Department;
import org.milos.univesitycourse.domain.StudyProgramme;
import org.milos.univesitycourse.enumeration.Status;
import org.milos.univesitycourse.service.ICourseService;
import org.milos.univesitycourse.service.IDepartmentService;
import org.milos.univesitycourse.service.IStudyProgrammeService;
import org.milos.univesitycourse.service.impl.CourseService;
import org.milos.univesitycourse.service.impl.DepartmentService;
import org.milos.univesitycourse.service.impl.StudyProgrammeService;

/**
 *
 * @author Milos
 */
public class DisplayCoursePageAction extends AbstractAction {

    ICourseService courseService;
    IStudyProgrammeService studyProgrammeService;
    IDepartmentService departmentService;
    List<Status> statuses;

    public DisplayCoursePageAction() {
        courseService = new CourseService();
        studyProgrammeService = new StudyProgrammeService();
        departmentService = new DepartmentService();
        statuses = Arrays.asList(Status.values());
    }

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        Course course;
        List<StudyProgramme> studyProgrammes;
        List<Department> departments;
        
        try {

            Long courseId = Long.parseLong(request.getParameter("courseId"));
            
            course = courseService.retrieveById(courseId);
            studyProgrammes = studyProgrammeService.retrieveAll();
            departments = departmentService.retrieveAll();
            
            populateSession(course, studyProgrammes, departments, session);
            
            return WebConstants.DISPLAY_COURSE_PAGE;
        } catch (Exception ex) {
            ex.getMessage();
            session.setAttribute("error_message", "Failed to load course for view!");
            return WebConstants.DISPLAY_COURSES_PAGE;
        }
    }

    private void populateSession(Course course, List<StudyProgramme> studyProgrammes, List<Department> departments, HttpSession session) {
        session.setAttribute("selected_course", course);
        session.setAttribute("study_programmes", studyProgrammes);
        session.setAttribute("departments", departments);
        session.setAttribute("statuses", statuses);
    }
}
