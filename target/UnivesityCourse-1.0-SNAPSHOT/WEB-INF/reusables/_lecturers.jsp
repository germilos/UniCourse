<%-- 
    Document   : _lecturers
    Created on : May 29, 2018, 3:57:50 PM
    Author     : Milos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="table table-striped" id="myTable">
    <thead>
        <tr id="column_names_row">
            <th onclick="sortTable(0)">ID</th>
            <th onclick="sortTable(1)">Name</th>
            <th>FoE</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${professor_list}" var="professor">
            <tr style="text-align: left;">
                <td>${professor.id}</td>
                <td>${professor.nameSurname}</td>
                <td>${professor.fieldOfExpertise}</td>
                <td>Professor</td>
                <td><a href="action?operation=displayLecturer&lecturerId=${professor.id}&lecturerType=professor">View</a></td>
                <td><a href="action?operation=deleteLecturer&lecturerId=${professor.id}" onclick="return confirm('Are you sure you want to delete this lecturer?')">Delete</a></td>
            </tr>
        </c:forEach>
            <c:forEach items="${assistant_list}" var="assistant">
            <tr style="text-align: left;">
                <td>${assistant.id}</td>
                <td>${assistant.nameSurname}</td>
                <td>${assistant.fieldOfExpertise}</td>
                <td>Assistant</td>
                <td><a href="action?operation=displayLecturer&lecturerId=${assistant.id}&lecturerType=assistant">View</a></td>
                <td><a href="action?operation=deleteLecturer&lecturerId=${assistant.id}" onclick="return confirm('Are you sure you want to delete this lecturer?')">Delete</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
