<%-- 
    Document   : freetime-s
    Created on : Apr 23, 2017, 9:50:30 PM
    Author     : Plaster
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/vote-stylesheet.css" rel="stylesheet">
        <link href="css/w3.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Prompt:300,400,500,600,700,800,900" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>ESMICs | Time Schedule</title>
    </head>

    <body>
        <% String result = (String)session.getAttribute("fts"); %>
        <div class="site-wrapper">
            <div class="site-wrapper-inner">
                <div class="cover-container">
                    <div class="masthead">
                        <p><nav class="navbar navbarcover navbar-default">
                            <div class="container-fluid">
                                <div class="navbar-header">
                                    <a class="navbar-brand list-detail nav-list-detail" href="#">ESMICs</a>
                                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                                        <span class="icon-bar-inverse icon-bar"></span>
                                        <span class="icon-bar-inverse icon-bar"></span>
                                        <span class="icon-bar-inverse icon-bar"></span> 
                                    </button>
                                </div>
                                <div class="collapse navbar-collapse" id="myNavbar">
                                    <ul class="nav navbar-nav">
                                        <li><a href="main.jsp" class="nav-list-detail">Home</a></li>
                                        <li><a href="schedule.jsp" class="nav-list-detail">Class schedule</a></li>
                                        <li class="active"><a href="#" class="activecover">Busy finder</a></li>
                                        <li><a href="find-a-student.html" class="nav-list-detail">Appointment vote</a></li>	
                                    </ul>
                                    <ul class="nav navbar-nav navbar-right">
                                        <li><a href="profile.jsp" class="nav-list-detail" >Profile</a></li>
                                        <li><a href="logout.process" class="nav-list-detail" ><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                                    </ul>
                                </div>
                            </div>
                        </nav>
                        </p>
                    </div>
                    <div class="inner">
                        <h1>Busy finder</h1>
                        <div class="container-fluid">
                            <div class="row">
                                <div class="span2"></div>
                                <div class="span8 main-col-detail">
                                    <div class="w3-panel w3-card card-main-detail"><p>
                                            <% if(result.equals("low")){ %>
                                                <div class="notice notice-green">
                                            <strong>TODAY IS FREE</strong>
                                        </div>
                                            <%}else if(result.equals("mid")){%>
                                            <div class="notice notice-yellow">
                                            <strong>TODAY IS MODERATE FREE</strong>
                                        </div>
                                            <% }else if(result.equals("high")){ %>
                                            <div class="notice notice-red">
                                            <strong>TODAY IS VERY BUSY</strong>
                                        </div>
                                            <%}%>
                                        


                                        </p></div>
                                </div>
                                <div class="span2"></div>
                            </div>
                        </div>


                    </div>
                    <div class="mastfoot">
                        <p></p>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
