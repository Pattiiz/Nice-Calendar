<%-- 
    Document   : freetime-t
    Created on : Apr 23, 2017, 9:50:19 PM
    Author     : Plaster
--%>

<%@page import="java.util.List"%>
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
        <% List<String> result = (List<String>) session.getAttribute("ftt"); %>
        <div class="site-wrapper">
            <div class="site-wrapper-inner">
                <div class="cover-container">
                    <div class="masthead">
                        <p><nav class="navbar navbarcover navbar-default">
                            <div class="container-fluid">
                                <div class="navbar-header">
                                    <a class="navbar-brand list-detail nav-list-detail" href="main.jsp">ESMICs</a>
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
                                        <li class="active"><a href="find-a-teacher.html" class="activecover">Busy finder</a></li>
                                        <li><a href="vote.jsp" class="nav-list-detail">Appointment vote</a></li>	
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
                                            <% for (int i = 0; i < result.size(); i++) {
                                                    if (result.get(i).equals("0")) {%>
                                        <div class="notice notice-green">
                                            <strong><%= i + 8%>:00 - <%= i + 9%>:00</strong>
                                            It's free
                                        </div>
                                        <%} else {%>
                                        <div class="notice notice-red">
                                            <strong><%= i + 8%>:00 - <%= i + 9%>:00</strong>
                                            It's busy
                                        </div>
                                        <%}%>
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
        <script>$(document).ready(function () {
                var scroll_pos = 0;
                $(document).scroll(function () {
                    scroll_pos = $(this).scrollTop();
                    if (scroll_pos > 20) {
                        $(".navbarcover").css('background-color', 'rgba(104,104,104,1.0)');
                    } else {
                        $(".navbarcover").css('background-color', 'rgba(104,104,104,0.5)');
                    }
                });
            });</script>
    </body>
</html>
