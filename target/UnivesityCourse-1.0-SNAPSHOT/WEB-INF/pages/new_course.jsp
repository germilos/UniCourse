<%-- 
    Document   : new_course
    Created on : Apr 26, 2018, 5:09:04 PM
    Author     : Milos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="styles/style.css">
        <link rel="stylesheet" type="text/css" href="styles/new_course_styles.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="javascript/new_course_scripts.js"></script>
        <script src="javascript/course_validation_scripts.js"></script>

    </head>
    <body onmousemove="enableSaving()">
        <jsp:include page="/WEB-INF/reusables/_header.jsp"></jsp:include>
            <div class="container-fluid">
                <div class="row row-div">
                    <div class="col-sm-12 text-center main-div">
                        <h1 class="course-title">Add New Course:</h1>
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
                        <form method="POST" action="action" id="course_insert_form">
                            <div class="container course-general">
                                <div class="row">
                                    <div class="col"> 
                                        <div class="form-group col-elem">
                                            <label for="course_name">Name:</label>
                                            <input type="text" class="form-control" id="course_name" name="course_name" value="" onkeyup="nameValidate()" required="true" style="min-width: 200px">
                                            <p class="error_label" id="name_error"></p>
                                        </div>
                                        <div class="form-group col-elem">
                                            <label for="course_st_program" style="margin-top: 28px">Study Programme:</label>
                                            <select class="form-control" id="course_st_program"  name="course_st_program">
                                                <c:forEach items="${study_programmes}" var="programme">
                                                    <option value="${programme.id}">${programme.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-elem">
                                            <label for="course_espb" class="course_espb_label">ESPB:</label>
                                            <input type="text" class="form-control" id="course_espb" name="course_espb" value="" onkeyup="espbValidate()" required="true" style="min-width: 200px">
                                            <p class="error_label" id="espb_error"></p>
                                        </div>
                                    </div>
                                    <div class="col status_department_col">
                                        <div class="form-group col-elem">
                                            <label for="course_status">Status:</label>
                                            <select class="form-control" id="course_status" name="course_status">
                                                <c:forEach items="${statuses}" var="status">
                                                    <option value="${status}">${status}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-elem">
                                            <label for="course_dept" class="course_dept_label" style="margin-top: 28px">Department:</label>
                                            <select class="form-control" id="course_dept"  name="course_dept">
                                                <c:forEach items="${departments}" var="department">
                                                    <option value="${department.id}">${department.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-group col-elem">
                                            <label for="course_goal"  class="course_goal_label">Goal:</label>
                                            <textarea class="form-control" rows="5" id="course_goal" name="course_goal" value="" required="true">Enter course goal...</textarea>
                                            <p class="error_label" id="goal_error"></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <label for="sel1">Professors:</label>
                                        <input type="text" id="professors_filter" onkeyup="filterFunction(this, document.getElementById('professors_unselected'))" placeholder="Search...">
                                        <select multiple class="form-control select_list_lecturers" id="professors_unselected" name="professors_unselected" style="min-height: 110px; min-width: 250px">

                                            <c:forEach items="${professors}" var="professor">
                                                <option value="${professor.id}">${professor.id}. ${professor.nameSurname}</option>
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
                                        <select multiple class="form-control select_list_lecturers" id="professors_selected" name="professors_selected" onchange="professorsValidate()" style="min-height: 110px; min-width: 250px">
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
                                            <c:forEach items="${assistants}" var="assistant">
                                                <option value="${assistant.id}">${assistant.id}. ${assistant.nameSurname}</option>
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
                                    <th>Description</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <input type="text"name="cuNumber" value="1" readonly="true"/>
                                    </td>
                                    <td> 
                                        <input type="text" name="cuName" value=""/>
                                    </td>
                                    <td>
                                        <textarea rows="3" name="cuDescription" value=""></textarea>
                                    </td>
                                </tr>
                            </tbody>
                        </table>

                    </div>

                    <div>
                        <input type="hidden" name="operation" value="addCourse"/>
                        <button type="button" class="btn btn-warning" onclick="goBack()">Cancel</button>
                        <button type="submit" class="btn btn-success" id="course_add">Add</button>

                    </div>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
