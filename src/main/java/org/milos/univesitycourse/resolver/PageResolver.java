/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milos.univesitycourse.resolver;

import org.milos.univesitycourse.constant.WebConstants;

/**
 *
 * @author Milos
 */
public class PageResolver {

    private static PageResolver instance;

    private PageResolver() {

    }

    public static PageResolver getInstance() {
        if (instance == null) {
            instance = new PageResolver();
        }
        return instance;
    }

    public String getPage(String view) {
        switch (view) {
            case WebConstants.ADMIN_HOME_PAGE:
                return "/WEB-INF/pages/home_page.jsp";
            case WebConstants.LOGIN_PAGE:
                return "/login.jsp";
            case WebConstants.INDEX_PAGE:
                return "/index.jsp";
            case WebConstants.DISPLAY_COURSES_PAGE:
                return "/WEB-INF/pages/courses.jsp";
            case WebConstants.DISPLAY_COURSE_PAGE:
                return "/WEB-INF/pages/course.jsp";
            case WebConstants.ADD_COURSE_PAGE:
                return "/WEB-INF/pages/new_course.jsp";
            default:
                return null;
        }
    }
}
