/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.action;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.milos.univesitycourse.constant.WebConstants;
import org.milos.univesitycourse.service.ICourseService;
import org.milos.univesitycourse.service.impl.CourseService;

/**
 *
 * @author Milos
 */
public class DeleteCourseAction extends AbstractAction {
    
    ICourseService courseService;

    public DeleteCourseAction() {
        courseService = new CourseService();
    }
  
    @Override
    public String execute(HttpServletRequest request) {
        
        HttpSession session = request.getSession(false);
        Long courseId = Long.parseLong(request.getParameter("courseId"));
        System.out.println(courseId);
        try {
            courseService.remove(courseId);
        } catch (Exception ex) {
            ex.printStackTrace();
            session.setAttribute("error_message", "Failed to delete course!");
        }
        return WebConstants.DISPLAY_COURSES_PAGE;
    }
    
}
