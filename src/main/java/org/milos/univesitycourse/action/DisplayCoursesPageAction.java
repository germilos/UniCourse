/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.milos.univesitycourse.constant.WebConstants;
import org.milos.univesitycourse.domain.Course;
import org.milos.univesitycourse.service.ICourseService;
import org.milos.univesitycourse.service.impl.CourseService;

/**
 *
 * @author Milos
 */
public class DisplayCoursesPageAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        ICourseService courseService = new CourseService();

        List<Course> courses = courseService.retrieveAll();
        if (courses.isEmpty()) {
            request.setAttribute("error_message", "No courses found in database!");
        }
        request.setAttribute("course_list", courses);
        return WebConstants.DISPLAY_COURSES_PAGE;
    }

}
