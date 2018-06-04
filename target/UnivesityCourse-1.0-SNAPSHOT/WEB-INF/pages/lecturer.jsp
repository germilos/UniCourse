<%-- 
    Document   : lecturer
    Created on : Apr 4, 2018, 8:41:59 PM
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
        <link rel="stylesheet" type="text/css" href="styles/update_lecturer_styles.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="javascript/update_lecturer_scripts.js"></script>
        <script src="javascript/lecturer_validation_scripts.js"></script>
    </head>
    <body onmousemove="enableSaving()">
        <jsp:include page="/WEB-INF/reusables/_header.jsp"></jsp:include>
            <div class="container-fluid">
                <div class="row row-div">
                    <div class="col-sm-12 text-center main-div">

                        <div style="text-align: left">
                            <h1 class="course-title" style="display: inline">Lecturer</h1>
                            <input type="text" class="form-control" id="lecturer_id" name="lecturer_id" value="${selected_lecturer.id}" readonly="true" 
                               style="display: inline; margin-left: 10px; min-width: 80px; max-width: 80px">
                    </div>
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
                        <form method="POST" action="action" id="lecturer_update_form">
                            <div class="container course-general">
                                <div class="row">
                                    <div class="col">
                                        <div class="form-group">
                                            <label>Type:</label>
                                            <c:if test="${selected_lecturer.getClass().name eq 'org.milos.univesitycourse.domain.Assistant'}">
                                                <label class="block"><input type="radio" name="lecturer_type" id="lecturer_type_prof" value="professor" onclick="lecturerType()"/>Professor</label>
                                                <label class="block"><input type="radio" name="lecturer_type" id="lecturer_type_ass" value="assistant" onclick="lecturerType()" checked="true"/>Assistant</label>
                                                </c:if>
                                                <c:if test="${selected_lecturer.getClass().name eq 'org.milos.univesitycourse.domain.Professor'}">
                                                <label class="block"><input type="radio" name="lecturer_type" id="lecturer_type_prof" value="professor" onclick="lecturerType()" checked="true"/>Professor</label>
                                                <label class="block"><input type="radio" name="lecturer_type" id="lecturer_type_ass" value="assistant" onclick="lecturerType()"/>Assistant</label>
                                                </c:if>
                                        </div>
                                        <c:catch var="exception"><p style="display: none">${selected_lecturer.numOfResearch}</p></c:catch>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col"> 
                                            <div class="form-group col-elem">
                                                <label for="lecturer_name">Name:</label>
                                                <input type="text" class="form-control" id="lecturer_name" name="lecturer_name" onkeyup="lecturerNameValidate()" value="${lecturer_name}" required="true">
                                            <p class="error_label" id="name_error"></p>
                                        </div>
                                        <div class="form-group col-elem">
                                            <label for="lecturer_surname" style="margin-top: 40px">Surname:</label>
                                            <input type="text" class="form-control" id="lecturer_surname" name="lecturer_surname" onkeyup="surnameValidate()" value="${lecturer_surname}">
                                            <p class="error_label" id="surname_error"></p>
                                        </div>
                                        <div class="form-group col-elem"">
                                            <label for="lecturer_field" style="margin-top: 40px">Field:</label>
                                            <input type="text" class="form-control" id="lecturer_field" name="lecturer_field" onkeyup="fieldValidate()" value="${selected_lecturer.fieldOfExpertise}">
                                            <p class="error_label" id="field_error"></p>
                                        </div>
                                    </div>
                                    <div class="col" style="margin-left: 30px">
                                        <div class="form-group col-elem">
                                            <label for="lecturer_res_papers">Research Papers:</label>
                                            <c:if test="${empty exception}">
                                                <input type="text" class="form-control" id="lecturer_res_papers" name="lecturer_res_papers" onkeyup="resPapperValidate()" value="${selected_lecturer.numOfResearch}">
                                            </c:if>
                                            <c:if test="${not empty exception}">
                                                <input type="text" class="form-control" id="lecturer_res_papers" name="lecturer_res_papers" onkeyup="resPapperValidate()" value="">
                                            </c:if>
                                            <p class="error_label" id="res_papper_error"></p>
                                        </div>
                                        <div class="form-group">
                                            <label for="lecturer_position" style="margin-top: 40px">Position:</label>
                                            <select class="form-control" id="lecturer_position"  name="lecturer_position">
                                                <c:catch var="exception">${selected_lecturer.position}</c:catch>

                                                <c:forEach items="${professor_types}" var="professor_type">
                                                    <c:choose>
                                                        <c:when test="${empty exception && professor_type eq selected_lecturer.position}">
                                                            <option value="${professor_type}" selected="true">${professor_type}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${professor_type}">${professor_type}</option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-elem" style="margin-left: 20px; margin-top: -30px">
                                            <label for="lecturer_dept" style="margin-top: -20px">Department:</label>
                                            <input type="text" id="departmens_filter" onkeyup="filterFunction(this, document.getElementById('lecturer_dept'))" placeholder="Search...">
                                            <select class="form-control" id="lecturer_dept"  name="lecturer_dept">
                                                <c:set var="selected_department" value="${selected_lecturer.deptIdFk}"/>
                                                <c:forEach items="${departments}" var="department">
                                                    <c:choose>
                                                        <c:when test = "${department.name eq selected_department.name}">
                                                            <option value="${department.id}" selected="true">${department.name}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${department.id}">${department.name}</option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col col-elem">
                                        <label for="lecturer_diploma">Diploma:</label>
                                        <select class="form-control" id="lecturer_diploma"  name="lecturer_diploma">
                                            <c:catch var="exception">${selected_lecturer.diplomaType}</c:catch>

                                            <c:forEach items="${diplomas}" var="diploma_type">
                                                <c:choose>
                                                    <c:when test="${empty exception && diploma_type eq selected_lecturer.diplomaType}">
                                                        <option value="${diploma_type}" selected="true">${diploma_type}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${diploma_type}">${diploma_type}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>

                                        </select>
                                    </div>
                                </div>
                                <div style="text-align: left; margin-top: 10px; margin-left: -20px">
                                    <input type="hidden" name="operation" value="updateLecturer"/>
                                    <button type="button" class="btn btn-warning" onclick="goBack()" id="lecturer_cancel">Cancel</button>
                                    <button type="button" class="btn btn-default" id="lecturer_enable" onclick="enableAllFormElements()">Enable</button>
                                    <button type="submit" class="btn btn-success" id="lecturer_add">Update</button>

                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

