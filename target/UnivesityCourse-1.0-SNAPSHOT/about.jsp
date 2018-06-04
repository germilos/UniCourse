<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="container-fluid" style="margin-left: 40px; margin-right: 40px; text-align: justify">
            <h1>UniCourse Web Application</h1>
            <hr/>
            <h4>This web application was built for the purposes of creating, reading, updating and deleting various university courses and their respective lecturers. The task itself was
                appointed by the members of the Laboratory of Software Engineering @ Faculty of Organizational Sciences. <br/><br/>
                Mentors throughout development process: dr Savić Dušan, dr Antović Ilija, dr Milić Miloš
            </h4>
        </div>
    </body>
</html>