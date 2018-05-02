<%-- 
    Document   : index.jsp
    Created on : Apr 1, 2018, 11:56:25 PM
    Author     : Milos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
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
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12 text-center">
                    <h1>Welcome to the university course panel!</h1>
                    <h3>Please <a href='login.jsp'>log in</a></h3>
                </div>
            </div>
        </div>	
    </body>
</html>

