<%-- 
    Document   : profile
    Created on : Apr 21, 2017, 11:28:02 PM
    Author     : phatm
--%>

<%@page import="java.sql.Connection"%>
<%@page import="model.Staff"%>
<%@page import="model.Student"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/student.css" rel="stylesheet">
        <link href="css/w3.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Prompt:300,400,500,600,700,800,900" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>ESMICs | Profile </title>
    </head>
    <body>
        <%String person_who = (String)session.getAttribute("who"); %>
        <div class="site-wrapper">
            <div class="cover-container">
                <div class="row-fluid padding-top-10">
                    <nav class="navbar navbar-default navbarcover fixed-top">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <a class="navbar-brand nav-ls-color" href="#">ESMICs</a>
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                                    <span class="icon-bar-color icon-bar"></span>
                                    <span class="icon-bar-color icon-bar"></span>
                                    <span class="icon-bar-color icon-bar"></span> 
                                </button>
                            </div>
                            <div class="collapse navbar-collapse" id="myNavbar">
                                <ul class="nav navbar-nav">
                                    <li><a href="main.jsp" class="nav-ls-color">Home</a></li>
                                    <% if(person_who.equals("student")){ %>
                                        <li><a href="schedule.jsp" class="nav-ls-color" >Class schedule</a></li>
                                        <% } %>
                                    <% if(person_who.equals("student") || person_who.equals("staff")){ %>
                                        <li><a href="find-a-teacher.html" class="nav-ls-color" >Busy finder</a></li>
                                        <%}else{%>
                                        <li><a href="find-a-student.jsp" class="nav-ls-color" >Busy finder</a></li>
                                        <%} %>
                                    <li><a href="vote.jsp" class="nav-ls-color" >Appointment vote</a></li>
                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <li class="active"><a href="profile.jsp" class="activecover" >Profile</a></li>
                                    <li><a class="nav-ls-color" href="logout.process"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
                <h1 class="text-center padding-top-10-p padding-bott-20"> Profile </h1>
                <div class="col-md-2"></div>
                <div class="col-md-8 main-col-detail">
                    <div class="padding-bott-20">
                        <center>
                            <img src="img/profile-icon.jpg">
                        </center>
                    </div>
                    <div class="w3-panel w3-card width-100-p">
                        <div class="notice notice-blue">
                            <strong>Student ID : </strong>  <% if(person_who.equals("student")){ %>
                                ${sessionScope.person.student_id}
                           <% } else{ %>
                           ${sessionScope.person.username}
                           <% } %>
                        </div>
                        <div class="notice notice-blue">
                            <strong>First name : </strong>  ${sessionScope.person.fname}
                        </div>
                        <div class="notice notice-blue">
                            <strong>Last name : </strong>  ${sessionScope.person.lname}
                        </div>
                        <div class="notice notice-blue">
                            <strong>E-mail : </strong>  ${sessionScope.person.email}
                        </div>
                        <div class="text-center padding-bott-10">
                            <a href="profile-edit.jsp">
                                <div class="btn btn-default padding" type="button">Edit</div>
                            </a>
                        </div>
                    </div>

                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
        <div class="text-center footer">
            <p>Information Technology, King Mongkut's Institude Technology of Ladkrabang.</p>
        </div>
        <script>
            $(document).ready(function () {
                var scroll_pos = 0;
                $(document).scroll(function () {
                    scroll_pos = $(this).scrollTop();
                    if (scroll_pos > 20) {
                        $(".navbarcover").css('background-color', 'rgba(104,104,104,1.0)');
                    } else {
                        $(".navbarcover").css('background-color', 'rgba(104,104,104,0.5)');
                    }
                });
            });

            $(".form_datetime").datetimepicker({format: 'dd-mm-yy hh:ii'});
        </script>
    </body>
</html>