<%-- 
    Document   : new_lecturer
    Created on : May 10, 2018, 11:34:30 AM
    Author     : Milos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Lecturer</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="styles/style.css">
        <link rel="stylesheet" type="text/css" href="styles/new_lecturer_styles.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="javascript/new_lecturer_scripts.js"></script>
        <script src="javascript/lecturer_validation_scripts.js"></script>
    </head>
    <body onmousemove="enableSaving()">
        <jsp:include page="/WEB-INF/reusables/_header.jsp"></jsp:include>
            <div class="container-fluid">
                <div class="row row-div">
                    <div class="col-sm-12 text-center main-div">
                        <h1 class="course-title">Add New Lecturer:</h1>
                        <hr/>
                    <c:choose>
                        <c:when test = "${error_message != null}">
                            <p style="color:red">
                                <c:out value="${error_message}"></c:out>
                                </p>
                        </c:when>
                        <c:when test = "${message != null}">
                            <p style="color:green">
                                <c:out value="${message}"></c:out>
                                </p>
                        </c:when>
                    </c:choose>
                    <div class="container-fluid">
                        <form method="POST" action="action" id="lecturer_insert_form">
                            <div class="container course-general">
                                <div class="row">
                                    <div class="col">
                                        <div class="form-group" style="float: left">
                                            <label>Type:</label>
                                            <label class="block" style="text-align: left"><input type="radio" name="lecturer_type" id="lecturer_type_prof" value="professor" onclick="lecturerType()" checked="true">Professor</label>
                                            <label class="block" style="text-align: left"><input type="radio" name="lecturer_type" id="lecturer_type_ass" value="assistant" onclick="lecturerType()">Assistant</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col"> 
                                        <div class="form-group col-elem">
                                            <label for="lecturer_name">Name:</label>
                                            <input type="text" class="form-control" id="lecturer_name" name="lecturer_name" onkeyup="lecturerNameValidate()" value="">
                                            <p class="error_label" id="name_error"></p>
                                        </div>
                                        <div class="form-group col-elem">
                                            <label for="lecturer_surname" style="margin-top: 30px">Surname:</label>
                                            <input type="text" class="form-control" id="lecturer_surname" onkeyup="surnameValidate()" name="lecturer_surname" value="">
                                            <p class="error_label" id="surname_error"></p>
                                        </div>
                                        <div class="form-group col-elem">
                                            <label for="lecturer_field" style="margin-top: 45px">Field:</label>
                                            <input type="text" class="form-control" id="lecturer_field" onkeyup="fieldValidate()" name="lecturer_field" value="">
                                            <p class="error_label" id="field_error"></p>
                                        </div>
                                    </div>
                                    <div class="col" style="margin-left: 50px">
                                        <div class="form-group" col-elem>
                                            <label for="lecturer_res_papers">Research Papers:</label>
                                            <input type="text" class="form-control" id="lecturer_res_papers" name="lecturer_res_papers" onkeyup="resPapperValidate()" value="">
                                            <p class="error_label" id="res_papper_error"></p>
                                        </div>
                                        <div class="form-group col-elem">
                                            <label for="lecturer_position" style="margin-top: 30px">Position:</label>
                                            <select class="form-control" id="lecturer_position"  name="lecturer_position">
                                                <c:forEach items="${professor_types}" var="professor_type">
                                                    <option value="${professor_type}">${professor_type}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-elem">
                                            <label for="lecturer_dept"  style="margin-top: 20px">Department:</label>
                                            <input type="text" id="departmens_filter" onkeyup="filterFunction(this, document.getElementById('lecturer_dept'))" placeholder="Search...">
                                            <select class="form-control" id="lecturer_dept"  name="lecturer_dept">
                                                <c:forEach items="${departments}" var="department">
                                                    <option value="${department.id}">${department.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                    </div>
                                    <div class="col" style="margin-left: 30px">
                                        <label for="lecturer_diploma">Diploma:</label>
                                        <select class="form-control" id="lecturer_diploma"  name="lecturer_diploma">
                                            <c:forEach items="${diploma_types}" var="diploma_type">
                                                <option value="${diploma_type}">${diploma_type}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div style="text-align: left; margin-top: 20px">
                                <input type="hidden" name="operation" value="addLecturer"/>
                                <button type="button" class="btn btn-warning" onclick="goBack()">Cancel</button>
                                <button type="submit" class="btn btn-success" id="lecturer_add">Add</button>
                            </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
