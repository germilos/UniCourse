/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.milos.univesitycourse.constant.WebConstants;
import org.milos.univesitycourse.dao.IStudyProgrammeDAO;
import org.milos.univesitycourse.domain.Course;
import org.milos.univesitycourse.domain.CourseUnit;
import org.milos.univesitycourse.domain.CourseUnitPK;
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
public class UpdateCourseAction extends AbstractAction {

    ICourseService courseService;
    IStudyProgrammeService studyProgrammeService;
    IDepartmentService departmentService;
    ILecturerService lecturerService;

    public UpdateCourseAction() {
        initServices();
    }

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        Long courseId = Long.parseLong(request.getParameter("course_id"));
        Long studyProgrammeId = Long.parseLong(request.getParameter("course_st_program"));
        Long departmentId = Long.parseLong(request.getParameter("course_dept"));
        String[] cuNames = request.getParameterValues("cuName");
        String[] cuNumbers = request.getParameterValues("cuNumber");
        String[] cuDescriptions = request.getParameterValues("cuDescription");
        String[] professorsStrings = request.getParameterValues("professors_selected");
        String[] assistantsString = request.getParameterValues("assistants_selected");

        try {
            Course course = courseService.retrieveById(courseId);

            course.getCourseUnits().clear();
            course.getLecturers().clear();
            populateCourse(course, cuNames, cuNumbers, cuDescriptions, professorsStrings,
                    assistantsString);
            course.setName(request.getParameter("course_name"));
            course.setGoal(request.getParameter("course_goal"));
            course.setEspb(Integer.parseInt(request.getParameter("course_espb")));
            course.setStatus(Status.valueOf(request.getParameter("course_status")));
            course.setDepartmentFk(departmentService.retrieveById(departmentId));
            course.setStudProgIdFk(studyProgrammeService.retrieveById(studyProgrammeId));

            courseService.update(course);
            request.setAttribute("message", "Course successfully updated!");

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("error_message", ex.getMessage());
        } finally {
            request.setAttribute("course_list", courseService.retrieveAll());
            return WebConstants.DISPLAY_COURSES_PAGE;
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
            course.getCourseUnits().add(new CourseUnit(new CourseUnitPK(course.getId(), Integer.parseInt(cuNumbers[i])), cuNames[i], cuDescriptions[i]));
        }
    }

    private void addLecturers(Course course, String[] professorsStrings) throws Exception {
        if (professorsStrings != null) {
            for (String professorString : professorsStrings) {
                long professorId = Long.parseLong(professorString.split(" ")[0]);
                course.getLecturers().add(lecturerService.retrieveProfessorById(professorId));
            }
        }
    }

    private void addAssistants(Course course, String[] assistantsString) throws Exception {
        if (assistantsString != null) {
            for (String assistantString : assistantsString) {
                long assistantId = Long.parseLong(assistantString.split(" ")[0]);
                course.getLecturers().add(lecturerService.retrieveAssistantById(assistantId));
            }
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
