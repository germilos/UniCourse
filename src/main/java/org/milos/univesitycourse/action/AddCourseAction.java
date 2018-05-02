/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.action;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.milos.univesitycourse.constant.WebConstants;
import org.milos.univesitycourse.domain.Course;
import org.milos.univesitycourse.domain.CourseUnit;
import org.milos.univesitycourse.domain.CourseUnitPK;
import org.milos.univesitycourse.domain.Professor;
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
public class AddCourseAction extends AbstractAction {

    ICourseService courseService;
    IStudyProgrammeService studyProgrammeService;
    IDepartmentService departmentService;
    ILecturerService lecturerService;

    public AddCourseAction() {
        initServices();
    }

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        Long studyProgrammeId = Long.parseLong(request.getParameter("course_st_program"));
        Long departmentId = Long.parseLong(request.getParameter("course_dept"));
        String[] cuNames = request.getParameterValues("cuName");
        String[] cuNumbers = request.getParameterValues("cuNumber");
        String[] cuDescriptions = request.getParameterValues("cuDescription");
        String[] professorsStrings = request.getParameterValues("professors_selected");
        String[] assistantsString = request.getParameterValues("assistants_selected");
        

        try {
            Course newCourse = new Course(request.getParameter("course_name"), request.getParameter("course_goal"),
                    Status.valueOf(request.getParameter("course_status")), Integer.parseInt(request.getParameter("course_espb")),
                    studyProgrammeService.retrieveById(studyProgrammeId), departmentService.retrieveById(departmentId));
            Course course = courseService.save(newCourse);

            populateCourse(course, cuNames, cuNumbers, cuDescriptions, professorsStrings,
                    assistantsString);
            courseService.update(course);

            session.setAttribute("message", "Course successfully inserted!");
            return WebConstants.ADD_COURSE_PAGE;

        } catch (Exception e) {
            session.setAttribute("error_message", "There was an error inserting course");
            e.printStackTrace();
            return WebConstants.ADD_COURSE_PAGE;
        }

    }

    private void initServices() {
        courseService = new CourseService();
        studyProgrammeService = new StudyProgrammeService();
        departmentService = new DepartmentService();
        lecturerService = new LecturerService();
    }

    private void addCourseUnits(Course course, String[] cuNames, String[] cuNumbers, String[] cuDescriptions) {
        for (int i = 0; i < cuNumbers.length; i++) {
            System.out.println(cuDescriptions[i]);

            course.getCourseUnits().add(new CourseUnit(new CourseUnitPK(course.getId(), Integer.parseInt(cuNumbers[i])), cuNames[i], cuDescriptions[i]));
        }
    }

    private void addLecturers(Course course, String[] professorsStrings) throws Exception {
        for (String professorString : professorsStrings) {
            long professorId = Long.parseLong(professorString.split(" ")[0]);
            course.getLecturers().add(lecturerService.retrieveProfessorById(professorId));
        }
    }

    private void addAssistants(Course course, String[] assistantsString) throws Exception {
        for (String assistantString : assistantsString) {
            long assistantId = Long.parseLong(assistantString.split(" ")[0]);
            course.getLecturers().add(lecturerService.retrieveAssistantById(assistantId));
        }
    }

    private void populateCourse(Course course, String[] cuNames, String[] cuNumbers,
            String[] cuDescriptions, String[] professorsStrings,
            String[] assistantsString) throws Exception {
        addCourseUnits(course, cuNames, cuNumbers, cuDescriptions);
        addLecturers(course, professorsStrings);
        addAssistants(course, assistantsString);
    }

}
