<%-- 
    Document   : home_page
    Created on : Apr 4, 2018, 1:03:20 AM
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
        <link rel="stylesheet" href="styles/style.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/reusables/_header.jsp"></jsp:include>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12 text-center">
                    <h1>Welcome, <c:out value="${logined_user.username}"></c:out></h1>
                </div>
            </div>
        </div>	
    </body>
</html>