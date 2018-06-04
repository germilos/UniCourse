/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.action;

/**
 *
 * @author Milos
 */
public class FactoryAction {
    
    /*
    * Create actions based on operation parameter
    */
    public static AbstractAction createActionFactory(String name) {
        AbstractAction action = null;
        
        if (name.equalsIgnoreCase("login"))
            action = new LoginAction();
        if (name.equalsIgnoreCase("logout"))
            action = new LogoutAction();
        if (name.equalsIgnoreCase("displayCourses"))
            action = new DisplayCoursesPageAction();
        if (name.equals("displayCourse")) 
            action = new DisplayCoursePageAction();
        if (name.equals("updateCourse"))
            action = new UpdateCourseAction();
        if (name.equals("addCoursePage")) 
            action = new AddCoursePageAction();
        if (name.equals("addCourse"))
            action = new AddCourseAction();
        if (name.equals("deleteCourse"))
            action = new DeleteCourseAction();
        if (name.equals("addLecturerPage"))
            action = new AddLecturerPageAction();
        if (name.equals("addLecturer"))
            action = new AddLecturerAction();
        if (name.equals("displayLecturers"))
            action = new DisplayLecturersPageAction();
        if (name.equals("displayLecturer"))
            action = new DisplayLecturerPageAction();
        if (name.equals("deleteLecturer")) 
            action = new DeleteLecturerAction();
        if (name.equals("updateLecturer"))
            action = new UpdateLecturerAction();
        return action;
    }
}
