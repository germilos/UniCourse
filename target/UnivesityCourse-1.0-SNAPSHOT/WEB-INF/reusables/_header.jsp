<%-- 
    Document   : _header
    Created on : Apr 3, 2018, 4:33:02 PM
    Author     : Milos
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#" style="color:orange">UniCourse</a>
        </div>
        <ul class="nav navbar-nav">
            <!--<li class="active"><a href="#">Home</a></li>-->
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Course <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="action?operation=displayCourses">View All</a></li>
                    <li><a href="action?operation=addCoursePage">Insert</a></li>
                </ul>
            </li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Lecturer <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">View All</a></li>
                    <li><a href="#">Insert</a></li>
                </ul>
            </li>
            <li><a href="#">About</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${logined_user == null}">
                    <li><a href="login.jsp">Login</a></li>
                    </c:when>
                    <c:when test="${logined_user != null}">
                    <li><a href="action?operation=logout">Logout</a></li>
                    </c:when>
                </c:choose>
        </ul>
    </div>
</nav>
