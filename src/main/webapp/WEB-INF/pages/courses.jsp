<%-- 
    Document   : course
    Created on : Apr 4, 2018, 8:41:52 PM
    Author     : Milos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/style.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="javascript/display_courses_scripts.js"></script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/reusables/_header.jsp"></jsp:include>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12 text-center">
                        <h1 class="course-title">Courses:</h1>
                        <hr/>
                        <div class="container-fluid">

                        <c:if test="${message != null}">
                            <p style="color:green">
                                <c:out value="${message}"></c:out>
                                </p>
                        </c:if>
                        <c:if test="${error_message != null}">
                            <p style="color: red">
                                <c:out value="${error_message}"></c:out>
                                </p>
                        </c:if>
                        <div class="container-fluid">
                            <input type="text" id="myInput" onkeyup="filterFunction()" placeholder="Search by name..">
                            <jsp:include page="/WEB-INF/reusables/_courses.jsp"></jsp:include>
                            </div>

                        <c:if test="${found_course != null}">
                            <c:out value="${found_course}"></c:out>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>	
    </body>
</html>
