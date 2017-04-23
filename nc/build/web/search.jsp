<%-- 
    Document   : search
    Created on : Apr 23, 2017, 1:20:54 AM
    Author     : Plaster
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="model.Appointment"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/vote-stylesheet.css" rel="stylesheet">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Prompt:300,400,500,600,700,800,900" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>ESMICs | Search result</title>
    </head>

    <body>
        <%if (session.getAttribute("person") == null) { %>
        <jsp:forward page="index.jsp"/>
        <% }%>
        <% DateFormat df2 = new SimpleDateFormat("d-MM-yyyy");
            DateFormat df3 = new SimpleDateFormat("HH:mm");
            List<Appointment> appointment;
            String person_who = (String) session.getAttribute("who");
            
        %>
        <div class="site-wrapper">
            <div class="site-wrapper-inner">
                <div class="cover-container">
                    <div class="masthead">
                        <p>
                        <nav class="navbar navbarcover navbar-default">
                            <div class="container-fluid">
                                <div class="navbar-header"> <a class="navbar-brand list-detail nav-list-detail" href="#">ESMICs</a>
                                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar"> <span class="icon-bar-inverse icon-bar"></span> <span class="icon-bar-inverse icon-bar"></span> <span class="icon-bar-inverse icon-bar"></span> </button>
                                </div>
                                <div class="collapse navbar-collapse" id="myNavbar">
                                    <ul class="nav navbar-nav">
                                        <li><a href="main.jsp" class="nav-list-detail" >Home</a></li>
                                        <li><a href="schedule.jsp" class="nav-list-detail" >Class schedule</a></li>
                                        <% if(person_who.equals("student")){ %>
                                        <li><a href="find-a-teacher.html" class="nav-list-detail" >Busy finder</a></li>
                                        <%}else{%>
                                        <li><a href="find-a-student.jsp" class="nav-list-detail" >Busy finder</a></li>
                                        <%} %>
                                        <li class="active"><a href="vote.jsp"  class="activecover">Appointment vote</a></li>
                                    </ul>
                                    <ul class="nav navbar-nav navbar-right">
                                        <li><a href="profile.jsp" class="nav-list-detail" >Profile</a></li>
                                        <li><a href="logout.process" class="nav-list-detail"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                                    </ul>
                                </div>
                            </div>
                        </nav>
                        </p>
                    </div>
                    <div class="inner">
                        <h1>Event search result</h1>
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-md-12 main-col-detail">
                                    <form action="search.process" method="GET">
                                        <div class="row input-group search-bar"> 
                                            <input name="search" type="text" class="form-control" placeholder="Search" />
                                            <span class="input-group-btn">
                                                <button class="btn btn-default btn-search" type="submit"> <span class="glyphicon glyphicon-search"></span> </button>
                                            </span></div>
                                    </form>
                                    <div class="w3-panel w3-card card-main-detail">
                                        <p> <% appointment = (List) session.getAttribute("search_r");
                                            for (int i = 0; i < appointment.size(); i++) {%>
                                            <a data-toggle="modal" data-target="#detail<%=appointment.get(i).getAppnt_no()%>" class="title-blue">
                                                <div class="notice notice-blue"> <strong><%=appointment.get(i).getTitle()%></strong> 
                                                    <%if (appointment.get(i).getAppnt_start_date().equals(appointment.get(i).getAppnt_end_date())) {%>
                                                    <%= df2.format(appointment.get(i).getAppnt_start_date())%>
                                                    <% } else {%> <%= df2.format(appointment.get(i).getAppnt_start_date())%> - <%= df2.format(appointment.get(i).getAppnt_end_date())%> <% }%> 
                                                    <%= df3.format(appointment.get(i).getAppnt_start_time())%> - <%= df3.format(appointment.get(i).getAppnt_end_time())%>
                                                </div>
                                            </a>
                                            <% }
                                            %>
                                            <% if(appointment.size() == 0) { %>
                                            <p style="color: #000;">No event found. Try to use space bar between your keywords.</p>
                                            <% } %>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mastfoot">
                        <p>Information Technology, King Mongkut's Institude Technology of Ladkrabang.</p>
                    </div>
                </div>
            </div>
        </div>
        
        <% appointment = (List) session.getAttribute("search_r");

            for (int i = 0; i < appointment.size(); i++) {%>
        <div id ="detail<%=appointment.get(i).getAppnt_no()%>" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title"><%=appointment.get(i).getTitle()%></h4>
                    </div>
                    <div class="modal-body">
                        <p>Date: <%if (appointment.get(i).getAppnt_start_date().equals(appointment.get(i).getAppnt_end_date())) {%>
                            <%= df2.format(appointment.get(i).getAppnt_start_date())%>
                            <% } else {%> <%= df2.format(appointment.get(i).getAppnt_start_date())%> - <%= df2.format(appointment.get(i).getAppnt_end_date())%> <% }%></p>
                        <p>Time: <%= df3.format(appointment.get(i).getAppnt_start_time())%> - <%= df3.format(appointment.get(i).getAppnt_end_time())%></p>
                        <p> <%= appointment.get(i).getDescription()%> </p>
                        <form action="delapp.process" method="GET">
                            <div style="height: 0px; overflow: hidden;">
                                <input type="text" name="id" value="<%=appointment.get(i).getAppnt_no()%>" readonly>
                            </div>
                            <button type="submit" class="btn-default btn-submit">Delete</button> </form>
                        <button type="button" class="btn-default btn-submit" ><a href="main-d.jsp?jump=<%= df2.format(appointment.get(i).getAppnt_start_date())%>">Edit</a></button>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <%}
        %>
        

    </body>
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
        <%if
    </script>
</html>
