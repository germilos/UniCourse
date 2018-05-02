<%-- 
    Document   : course_units
    Created on : Apr 10, 2018, 11:32:25 AM
    Author     : Milos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="table table-striped" id="myTable">
    <thead>
        <tr id="column_names_row">
            <th>ID</th>
            <th>Name</th>
            <th>Status</th>
            <th>ESPB</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${course_list}" var="course">
            <tr style="text-align: left;">
                <td>${course.id}</td>
                <td>${course.name}</td>
                <td>${course.status}</td>
                <td>${course.espb}</td>
                <td><a href="action?operation=displayCourse&courseId=${course.id}">View</a></td>
                <td><a href="action?operation=deleteCourse&courseId=${course.id}" onclick="return confirm('Are you sure you want to delete this course?')">Delete</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
