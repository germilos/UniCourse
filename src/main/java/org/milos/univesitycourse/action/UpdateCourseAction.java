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
import org.milos.univesitycourse.service.IStudyProgrammeService;
import org.milos.univesitycourse.service.impl.CourseService;
import org.milos.univesitycourse.service.impl.DepartmentService;
import org.milos.univesitycourse.service.impl.StudyProgrammeService;

/**
 *
 * @author Milos
 */
public class UpdateCourseAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        
        HttpSession session = request.getSession(false);
        ICourseService courseService = new CourseService();
        IStudyProgrammeService studyProgrammeService = new StudyProgrammeService();
        IDepartmentService departmentService = new DepartmentService();
        
        Course course;
        List<CourseUnit> courseUnits;
        Long courseId = Long.parseLong(request.getParameter("courseId"));
        Long studyProgrammeId = Long.parseLong(request.getParameter("course_st_program"));
        Long departmentId = Long.parseLong(request.getParameter("course_dept"));
        
        try {
            course = courseService.retrieveById(courseId);
            courseUnits = new ArrayList<>();
            course.getCourseUnits().clear();
            String[] cuNumbers = request.getParameterValues("cuNumber");
            String[] cuNames = request.getParameterValues("cuName");
            for (int i = 0; i < cuNumbers.length; i++) {
                System.out.println(cuNumbers[i] + " " + cuNames[i]);
//                CourseUnit cu = new CourseUnit(new CourseUnitPK(course.getId(),
//                                Integer.parseInt(cuNumbers[i])), cuNames[i]);
//                System.out.println(cu);
//                courseUnits.add(cu);
            }
//            course.getCourseUnits().addAll(courseUnits);
//            course.setName(request.getParameter("course_name"));
//            course.setGoal(request.getParameter("course_status"));
//            course.setStatus(Status.valueOf(request.getParameter("course_status")));
//            course.setEspb(Integer.parseInt(request.getParameter("course_espb")));
//            course.setStudProgIdFk(studyProgrammeService.retrieveById(studyProgrammeId));
//            course.setDepartmentFk(departmentService.retrieveById(departmentId));
//            courseService.update(course);
            
        } catch(Exception ex) {
            
        }
        return WebConstants.DISPLAY_COURSES_PAGE;
    }

    
    
}
