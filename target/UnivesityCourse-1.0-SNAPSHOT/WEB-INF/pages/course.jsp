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
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script>
            function goBack() {
                window.history.back();
            }
            function enableInputs() {
                var elem = document.getElementById("course_info").elements;
                document.getElementById("course_update").disabled = false;

                for (var i = 0; i < elem.length; i++) {
                    if (elem[i].type === "text" || elem[i].type === "textarea") {
                        if (elem[i].id === "course_id") {
                            continue;
                        }
                        elem[i].disabled = false;
                    }
                }
                document.getElementById("course_edit").disabled = true;
                document.getElementById("course_status").disabled = false;
                document.getElementById("course_st_program").disabled = false;
                document.getElementById("course_dept").disabled = false;

            }

            function addField(argument) {
                var myTable = document.getElementById("myTable");
                var currentIndex = myTable.rows.length;

                if (document.getElementById("myTable").rows[currentIndex - 1].cells[1].children[0].value === "") {
                    alert("You must enter the course unit name first!");

                } else {
                    var currentRow = myTable.insertRow(-1);
                    var cuNumber = document.createElement("input");
                    cuNumber.setAttribute("type", "text")
                    cuNumber.setAttribute("name", "cuNumber");
//                    cuNumber.style.border = "0";
//                    cuNumber.style.max-width = "5px";
//                    cuNumber.style.size = "2";
                    cuNumber.setAttribute("value", currentIndex);
                    cuNumber.setAttribute("disabled", true);

                    var cuName = document.createElement("input");
                    cuName.setAttribute("type", "text");
                    cuName.setAttribute("name", "cuName");
//                    cuName.setAttribute("value", "");

                    var currentCell = currentRow.insertCell(-1);
                    currentCell.appendChild(cuNumber);

                    currentCell = currentRow.insertCell(-1);
                    currentCell.appendChild(cuName);
                }
            }

            function deleteRow() {

                var table = document.getElementById("myTable");
                if (table.rows.length > 2) {
                    if (confirm('Are you sure you want to delete this course unit?')) {
                        var rowCount = table.rows.length;
                        table.deleteRow(rowCount - 1);
                    }
                }
            }

        </script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/reusables/_header.jsp"></jsp:include>
            <div class="container-fluid">
                <div class="row" style="display:inline">
                    <div class="col-sm-12 text-center" style="display:inline">
                        <h1 style="text-align:left; margin-bottom:20px; margin-left: 10px">Course:</h1>
                        <hr/>
                        <div style="display:inline; float:left">
                            <div class="container-fluid" style="display:inline-block; float:left">
                                <form method="POST" action="action" id="course_info">
                                    <div style="float:left;margin-right: 0px;display: inline">
                                        <div class="form-group" style="display:inline-block">
                                            <label for="courseId" style="display: block; text-align: left">ID:</label>
                                            <input type="text" class="form-control" id="courseId" name="courseId" value="${selected_course.id}"  style="min-width: 200px;" disabled>
                                    </div>
                                    <div class="form-group" style="display: inline-block; margin-left:50px">
                                        <label for="course_name" style="display: block; text-align: left">Name:</label>
                                        <input type="text" class="form-control" id="course_name"  name="course_name" value="${selected_course.name}" style="min-width: 200px;"disabled>
                                    </div>
                                </div>
                                <br style="clear:both;" />
                                <div class="form-group">
                                    <label for="course_goal" style="display: block; text-align: left">Goal:</label>
                                    <textarea class="form-control" rows="5" id="course_goal" name="course_goal" style="min-width: 450px" disabled>${selected_course.goal}</textarea>
                                </div>
                                <div style="float:left;margin-right: 0px;display: inline-block">
                                    <!--                                <div class="form-group" style="display:inline-block">
                                                                        <label for="course_status" style="display: block; text-align: left">Status:</label>
                                                                        <input type="text" class="form-control" id="course_status"  name="course_status" value="${selected_course.status}" style="min-width: 200px;" disabled>
                                                                    </div>-->
                                    <div class="form-group" style="display: inline-block">
                                        <label for="course_status" style="display: block; text-align: left">Status:</label>
                                        <select class="form-control" id="course_status" style="min-width: 200px;" disabled>
                                            <c:forEach items="${statuses}" var="status">
                                                <option>${status}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group" style="display: inline-block; margin-left:50px">
                                        <label for="course_espb" style="display: block; text-align: left">ESPB:</label>
                                        <input type="text" class="form-control" id="course_espb"  name="course_espb" value="${selected_course.espb}" style="min-width: 200px;" disabled>
                                    </div>
                                </div>
                                <br style="clear:both;" />
                                <div style="float:left;margin-right: 0px;display: inline-block">
                                    <div class="form-group" style="display:inline-block">
                                        <label for="course_st_program" style="display: block; text-align: left">Study Programme:</label>
                                        <select class="form-control" id="course_st_program"  name="course_st_program" style="min-width: 200px;" disabled>
                                            <c:forEach items="${study_programmes}" var="programme">
                                                <option value="${programme.id}">${programme.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group" style="display: inline-block; margin-left:50px">
                                        <label for="course_dept" style="display: block; text-align: left">Department:</label>
                                        <select class="form-control" id="course_dept" name="course_dept" style="min-width: 200px;" disabled>
                                            <c:forEach items="${departments}" var="department">
                                                <option value="${department.id}">${department.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <br style="clear:both;" />
                                </div>
                                <br style="clear:both;" />
                                <div style="float:left; text-align: left; margin-top:20px">
                                    <input type="hidden" name="operation" value="updateCourse"/>
                                    <button type="button" class="btn btn-warning" onclick="goBack()">Cancel</button>
                                    <button type="button" class="btn btn-warning" id="course_edit" onclick="enableInputs()">Edit</button>
                                    <button type="submit" class="btn btn-default" id="course_update" disabled>Update</button>
                                </div>
                                <br/>
                        </div>
                        <div class="container-fluid" style="display: inline-blocks; float:left; margin-left: 20px">     
                            <h3 style="text-align: left; margin-top:-5px">Units:</h3>
                            <table class="table table-striped table-hoover" id="myTable" style="max-width: 350px">
                                <col width="20"/>
                                <col width="250"/>
                                <thead>
                                    <tr id="column_names_row">
                                        <th>no.</th>
                                        <th>Name</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${selected_course.courseUnits}" var="courseUnit">
                                        <tr style="text-align: left;">
                                            <td style="max-width: 5px; padding: 10px">
                                                <input type="text" name="cuNumber" value="${courseUnit.courseUnitPK.unitNumber}" style="border: 0; max-width: 5px" size='2' disabled/>
                                            </td>
                                            <td> 
                                                <input type="text" name="cuName" value="${courseUnit.name}" style="border: 0; width: 10px" size="15"/>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div style="float:left; text-align: left; margin-top:20px">
                                <button type="button" class="btn btn-warning" id="cu_add" onclick="addField()">+</button>
                                <button type="button" class="btn btn-default" id="cu_remove" onclick="deleteRow()">-</button>
                            </div>
                        </div>
                        </form>
                    </div>
                    </body>

                </div>
            </div>
        </div>
    </body>
</html>
