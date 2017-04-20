<%-- 
    Document   : landing
    Created on : Apr 13, 2017, 6:02:03 PM
    Author     : Plaster
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/landing-stylesheet.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Prompt:300" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>Nice Calendar</title>
    </head>
    <body>
        <% if(session.getAttribute("person") != null) { %>
        <jsp:forward page="main.jsp"/>
        <% } %>
        <div class="site-wrapper">
            <div class="site-wrapper-inner">
                <div class="cover-container">
                    <div class="masthead">
                        <p><nav class="navbar navbarcover navbar-default">
                            <div class="container-fluid">
                                <div class="navbar-header">
                                    <a class="navbar-brand list-detail" id="list-detail" href="#">NC</a>
                                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                                        <span class="icon-bar-inverse icon-bar"></span>
                                        <span class="icon-bar-inverse icon-bar"></span>
                                        <span class="icon-bar-inverse icon-bar"></span> 
                                    </button>
                                </div>
                                <div class="collapse navbar-collapse" id="myNavbar">
                                    <ul class="nav navbar-nav">
                                        <li class="active"><a href="#" id="activecover">Home</a></li>

                                    </ul>
                                    <ul class="nav navbar-nav navbar-right">
                                        <li><a href="#myModal" data-toggle="modal" id="list-detail" data-target="#myModal"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                                    </ul>
                                </div>
                            </div>
                        </nav>
                        </p>
                    </div>
                    <div class="inner"><h1>Organize your schedule is easier than before</h1> <p>Helps you to look your class easier and easy looking with calendar view. Get you and teacher closer with joining events system. 
                            Find a student free time for teacher or Find a teacher free time for student and staff (information to create classroom timetable). Poll for appointment voting.
                        </p>
                        <p><a href="#myModal" data-toggle="modal" data-target="#myModal" class="btn btn-default btn-lg">Begin</a></p>
                    </div>
                    <div class="mastfoot">
                        Information Technology Faculty, King Mongkut's Institude Technology Ladkrabang.
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal -->
        <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Login</h4>
                    </div>
                    <div class="modal-body">
                        <p>Please login here.</p>
                        <form action="login.process" method="POST">
                        <div class="form-group">
                            <label for="usr">Name:</label>
                            <input type="text" class="form-control" id="usr" name="username">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Password:</label>
                            <input type="password" class="form-control" id="pwd" name="password">
                        </div>
                        <button type="submit" class="btn-default btn-submit" >Login</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
