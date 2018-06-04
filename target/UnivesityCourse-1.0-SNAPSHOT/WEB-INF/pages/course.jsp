<%-- 
    Document   : course
    Created on : Apr 9, 2018, 4:31:44 PM
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
        <link rel="stylesheet" href="styles/update_course_styles.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="javascript/update_course_scripts.js"></script>
        <script src="javascript/course_validation_scripts.js"></script>

    </head>
    <body onmousemove="enableSaving()">
        <jsp:include page="/WEB-INF/reusables/_header.jsp"></jsp:include>
            <div class="container-fluid">
                <div class="row row-div">
                    <div class="col-sm-12 text-center main-div">
                        <div style="text-align: left">
                            <h1 class="course-title" style="display: inline;">Course:</h1>
                            <input type="text" class="form-control" id="course_id" name="course_id" value="${selected_course.id}" readonly="true" style="margin-left: 13px; max-width: 80px; display: inline">
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
                        <form method="POST" action="action" id="course_update_form">
                            <div class="container course-general">
                                <!--                                <div class="row">
                                                                    <div class="col">
                                                                        <div class="form-group">
                                                                            <label for="course_name">ID:</label>
                                                                            <input type="text" class="form-control" id="course_id" name="course_id" value="${selected_course.id}" readonly="true">
                                                                        </div>
                                                                    </div>
                                                                </div>-->
                                <div class="row">
                                    <div class="col">
                                        <div class="form-group col-elem">
                                            <label for="course_name">Name:</label>
                                            <input type="text" class="form-control" id="course_name" name="course_name" onkeyup="nameValidate()" value="${selected_course.name}" required="true" style="min-width: 200px">
                                            <p class="error_label" id="name_error"></p>
                                        </div>
                                        <div class="form-group col-elem">
                                            <label for="course_st_program" style="margin-top: 25px">Study Programme:</label>
                                            <select class="form-control" id="course_st_program"  name="course_st_program">

                                                <c:set var="selected_study_prog" value="${selected_course.studProgIdFk}"/>
                                                <c:forEach items="${study_programmes}" var="programme">
                                                    <c:choose>
                                                        <c:when test = "${programme eq selected_study_prog}">
                                                            <option value="${programme.id}" selected="true">${programme.name}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${programme.id}">${programme.name}</option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-elem">
                                            <label for="course_espb" class="course_espb_label">ESPB:</label>
                                            <input type="text" class="form-control" id="course_espb" name="course_espb" onkeyup="espbValidate()" value="${selected_course.espb}" required="true" style="min-width: 200px">
                                            <p class="error_label" id="espb_error"></p>
                                        </div>
                                    </div>
                                    <div class="col status_department_col">
                                        <div class="form-group col-elem">
                                            <label for="course_status" style="">Status:</label>
                                            <select class="form-control" id="course_status" name="course_status">
                                                <c:set var="selected_status" value="${selected_course.status}"/>
                                                <c:forEach items="${statuses}" var="status">
                                                    <c:if test = "${status eq selected_status}">
                                                        <option value="${status}" selected="true">${status}</option>
                                                    </c:if>
                                                    <option value="${status}">${status}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-elem">
                                            <label for="course_dept" style="margin-top: 25px">Department:</label>
                                            <select class="form-control" id="course_dept"  name="course_dept">

                                                <c:set var="selected_department" value="${selected_course.departmentFk}"/>
                                                <c:forEach items="${departments}" var="department">
                                                    <c:choose>
                                                        <c:when test = "${department eq selected_department}">
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
                                    <div class='col'>
                                        <div class="col">
                                            <div class="form-group col-elem">
                                                <label for="course_goal" class="course_goal_label">Goal:</label>
                                                <textarea class="form-control" rows="5" id="course_goal" name="course_goal" value="${selected_course.goal}" required="true">${selected_course.goal}</textarea>
                                                <p class="error_label" id="goal_error"></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <label for="sel1">Professors:</label>
                                        <input type="text" id="professors_filter" onkeyup="filterFunction(this, document.getElementById('professors_unselected'))" placeholder="Search..."> 
                                        <select multiple class="form-control" id="professors_unselected" name="professors_unselected" style="min-height: 110px; min-width: 250px"> 
                                            <c:forEach items="${remaining_professors}" var="rem_professor">
                                                <option value="${rem_professor.id}">${rem_professor.id}. ${rem_professor.nameSurname}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col select_buttons">
                                        <div>
                                            <button type="button" class="btn btn-default" id="left_professors" value="<"><</button>
                                            <button type="button" class="btn btn-default" id="right_professors" value=">">></button>
                                        </div>
                                        <div>
                                            <button type="button" class="btn btn-default" id="leftall_professors" value="<<"><<</button>
                                            <button type="button" class="btn btn-default" id="rightall_professors" value=">>">>></button>
                                        </div>
                                    </div>
                                    <div class="col selected_lecturers">
                                        <select multiple class="form-control" id="professors_selected" name="professors_selected" onchange="professorsValidate()" style="min-height: 110px; min-width: 250px">
                                            <c:forEach items="${course_professors}" var="professor">
                                                <option value="${professor.id}">${professor.id}. ${professor.nameSurname}</option>
                                            </c:forEach>
                                        </select>
                                        <p class="error_label" id="professor_error"></p>
                                        <br />
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <label for="sel2">Assistants:</label>
                                        <input type="text" id="assistants_filter" onkeyup="filterFunction(this, document.getElementById('assistants_unselected'))" placeholder="Search...">
                                        <select multiple class="form-control" id="assistants_unselected" name="assistants_unselected" style="min-height: 110px; min-width: 250px">
                                            <c:forEach items="${remaining_assistants}" var="rem_assistant">
                                                <option value="${rem_assistant.id}">${rem_assistant.id}. ${rem_assistant.nameSurname}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col select_buttons">
                                        <div>
                                            <button type="button" class="btn btn-default" id="left_assistants" value="<"><</button>
                                            <button type="button" class="btn btn-default" id="right_assistants" value=">">></button>
                                        </div>
                                        <div>
                                            <button type="button" class="btn btn-default" id="leftall_assistants" value="<<"><<</button>
                                            <button type="button" class="btn btn-default" id="rightall_assistants" value=">>">>></button>
                                        </div>
                                    </div>
                                    <div class="col selected_lecturers">
                                        <select multiple class="form-control" id="assistants_selected" name="assistants_selected" onchange="assistantsValidate()" style="min-height: 110px; min-width: 250px">
                                            <c:forEach items="${course_assistants}" var="assistant">
                                                <option value="${assistant.id}">${assistant.id}. ${assistant.nameSurname}</option>
                                            </c:forEach>
                                        </select>
                                        <p class="error_label" id="assistant_error"></p>
                                        <br />
                                    </div>


                                </div>
                            </div>

                    </div>
                    <div class="course-units">
                        <h3 class="course-subtitle">Units:</h3>
                        <div style="text-align: left;">
                            <button type="button" class="btn btn-success" id="cu_add" onclick="addField()">+</button>
                            <button type="button" class="btn btn-warning" id="cu_remove" onclick="deleteRow()">-</button>
                        </div>
                        <table class="table table-striped" id="myTable">
                            <thead>
                                <tr class="course-units-head-row">
                                    <th>no.</th>
                                    <th>Name</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${selected_course.courseUnits}" var="courseUnit">
                                    <tr>
                                        <td>
                                            <input type="text" name="cuNumber" value="${courseUnit.courseUnitPK.unitNumber}" readonly="true"/>
                                        </td>
                                        <td> 
                                            <input type="text" name="cuName" value="${courseUnit.name}"/>
                                        </td>
                                        <td> 
                                            <textarea rows="3" name="cuDescription" value="${courseUnit.description}">${courseUnit.description}</textarea>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    <div>
                        <input type="hidden" name="operation" value="updateCourse"/>

                        <button type="button" class="btn btn-warning" onclick="goBack()" id="course_cancel">Cancel</button>
                        <button type="button" class="btn btn-default" onclick="enableAllFormElements()" id="course_enable">Enable</button>
                        <button type="submit" class="btn btn-success" id="course_update">Update</button>

                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
