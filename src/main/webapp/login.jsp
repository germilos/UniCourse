<%-- 
    Document   : login
    Created on : Apr 4, 2018, 12:02:06 AM
    Author     : Milos
--%>

<%@page import="org.milos.univesitycourse.domain.CourseUnit"%>
<%@page import="java.util.List"%>
<%@page import="org.milos.univesitycourse.domain.Course"%>
<%@page import="org.milos.univesitycourse.service.impl.CourseService"%>
<%@page import="org.milos.univesitycourse.service.ICourseService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/style.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="WEB-INF/reusables/_header.jsp"></jsp:include>
            <div class="container">
                <h2>Login form</h2>
                <form method="POST" action="action">
                    <div class="form-group">
                        <label for="email">Username:</label>
                        <input type="text" class="form-control" id="email" placeholder="Enter username" name="username">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Password:</label>
                        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
                    </div>
                    <input type="hidden" name="operation" value="login"/>
                    <button type="submit" class="btn btn-default">Login</button>
                </form>
                <br/>
                <c:if test="${error_message != null}">
                    <p style="color:red">
                        <c:out value="${error_message}"></c:out>
                    </p>
                </c:if>
            </div>
    </body>
</html>
