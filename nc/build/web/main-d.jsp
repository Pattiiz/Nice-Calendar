<%-- 
    Document   : main_d
    Created on : Apr 16, 2017, 5:58:01 PM
    Author     : Plaster
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.Appointment"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="model.Calendarmodel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main-stylesheet.css" rel="stylesheet">
        <link href="css/w3.css" rel="stylesheet">
        <link href="css/datetimepicker.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Prompt:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/datetimepicker.js"></script>
        <script src="js/datetimepicker.min.js"></script>
        <title>ESMICs | Main</title>
    </head>

    <body>
        <%if (session.getAttribute("person") == null) { %>
        <jsp:forward page="index.jsp"/>
        <% }%>
        <% Calendarmodel cm = (Calendarmodel) session.getAttribute("cm");
            Calendar date = Calendar.getInstance();
            List<Appointment> appointment;
            String date_mark_check = null;
            DateFormat df = new SimpleDateFormat("HH:mm");
            DateFormat df2 = new SimpleDateFormat("yyyy-M-d");
            DateFormat df3 = new SimpleDateFormat("d-MM-yyyy");
            ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection");
            String person_who = (String) session.getAttribute("who");
            String user_id = (String) session.getAttribute("user_id");
            List<String> month_title = Arrays.asList("January", "Febuary", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December");
            List<Integer> odd_month = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
            List<Integer> even_month = Arrays.asList(4, 6, 9, 11);%>
        <% if (request.getParameter("jump") != null) {
                String[] jump = request.getParameter("jump").split("-");
                cm.setDay(Integer.parseInt(jump[0]));
                cm.setMonth(Integer.parseInt(jump[1]));
                cm.setYear(Integer.parseInt(jump[2]));
            }
            if (request.getParameter("dsp_method") != null) {
                if (request.getParameter("dsp_method").equals("prev")) {
                    if (cm.getDay() == 1) {
                        if (cm.getMonth() == 1) {
                            cm.setMonth(13);
                            cm.setYear(cm.getYear() - 1);
                        }
                        if (odd_month.contains(cm.getMonth() - 1)) {
                            cm.setDay(31);
                            cm.setMonth(cm.getMonth() - 1);
                        } else if (even_month.contains(cm.getMonth() - 1)) {
                            cm.setDay(30);
                            cm.setMonth(cm.getMonth() - 1);
                        } else {
                            if (cm.getYear() % 4 == 0) {
                                cm.setDay(29);
                                if (cm.getYear() % 100 == 0) {
                                    cm.setDay(28);
                                    if (cm.getYear() % 400 == 0) {
                                        cm.setDay(29);
                                    }
                                }
                            }
                            cm.setMonth(cm.getMonth() - 1);
                        }

                    } else {
                        cm.setDay(cm.getDay() - 1);
                    }

                } else if (request.getParameter("dsp_method").equals("next")) {
                    if (cm.getMonth() == 12 && cm.getDay() == 31) {
                        cm.setDay(1);
                        cm.setMonth(1);
                        cm.setYear(cm.getYear() + 1);
                    } else if (cm.getMonth() != 12 && cm.getDay() == 30 || cm.getDay() == 31) {
                        cm.setDay(1);
                        cm.setMonth(cm.getMonth() + 1);
                    } else {
                        cm.setDay(cm.getDay() + 1);
                    }

                } else if (request.getParameter("dsp_method").equals("today")) {
                    cm.setDay(date.get(Calendar.DATE));
                    cm.setMonth(date.get(Calendar.MONTH) + 1);
                    cm.setYear(date.get(Calendar.YEAR));

                } else {
                    cm.setDay(1);
                }
            }
        %>
        
        <div class="site-wrapper">
            <div class="site-wrapper-inner">
                <div class="cover-container">
                    <div class="masthead">
                        <p>
                        <nav class="navbar navbarcover navbar-default">
                            <div class="container-fluid">
                                <div class="navbar-header"> <a class="navbar-brand list-detail nav-list-detail" href="main.jsp">ESMICs</a>
                                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar"> <span class="icon-bar-inverse icon-bar"></span> <span class="icon-bar-inverse icon-bar"></span> <span class="icon-bar-inverse icon-bar"></span> </button>
                                </div>
                                <div class="collapse navbar-collapse" id="myNavbar">
                                    <ul class="nav navbar-nav">
                                        <li class="active"><a href="main.jsp" class="activecover">Home</a></li>
                                        <% if(person_who.equals("student")){ %>
                                        <li><a href="schedule.jsp" class="nav-list-detail" >Class schedule</a></li>
                                        <% } %>
                                        <% if(person_who.equals("student") || person_who.equals("staff")){ %>
                                        <li><a href="find-a-teacher.html" class="nav-list-detail" >Busy finder</a></li>
                                        <%}else{%>
                                        <li><a href="find-a-student.jsp" class="nav-list-detail" >Busy finder</a></li>
                                        <%} %>
                                        <li><a href="vote.jsp" class="nav-list-detail" >Appointment vote</a></li>
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
                        <h1>Hello ${sessionScope.person.fname} ${sessionScope.person.lname} :)</h1>
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-md-1"></div>
                                <div class="col-md-10">
                                    <form>
                                        <div class="row input-group search-bar">
                                            <input type="text" class="form-control" placeholder="Search" />
                                            <span class="input-group-btn">
                                                <button class="btn btn-default btn-search" type="submit"> <span class="glyphicon glyphicon-search"></span> </button>
                                            </span> </div>
                                    </form>

                                    <div class="row contain-main">
                                        <div class="col-md-4 contain-header-left"><%= cm.getDay()%> <%= month_title.get(cm.getMonth() - 1)%> <%= cm.getYear()%><span class="contain-header-date"> </span></div>
                                        <div class="col-md-4">
                                            <ul class="pagination contain-header-mid">
                                                <li><a href="#" class="contain-header-mid-detail" style="background-color:#c0c0c0;">Day</a></li>
                                                <li><a href="main.jsp" class="contain-header-mid-detail">Month</a></li>
                                            </ul>
                                        </div>
                                        <div class="col-md-4 contain-header-dright">
                                            <ul class="pagination contain-header-right">
                                                <li><a href="main-d.jsp?dsp_method=prev" class="contain-header-right-detail2"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
                                                <li><a href="main-d.jsp?dsp_method=next" class="contain-header-right-detail2"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
                                            </ul>
                                            <ul class="pagination contain-header-right">
                                                <li><a href="main-d.jsp?dsp_method=today" class="contain-header-right-detail">Today</a></li>
                                                <li><a href="#" class="contain-header-right-detail" data-toggle="modal" data-target="#myJump">Go to</a></li>
                                            </ul>
                                            <ul class="pagination contain-header-right">
                                                <li><a href="#" class="contain-header-right-detail2" data-toggle="modal" data-target="#myAdd"><span class="glyphicon glyphicon-plus"></span></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="row contain-main" style="">
                                        <div style="margin-top: 10px;"><%
                                            appointment = cm.getAppointment(caldtb, person_who, user_id);
                                            date_mark_check = cm.getYear() + "-" + cm.getMonth() + "-" + cm.getDay();
                                            for (int k = 0; k < appointment.size(); k++) {%>
                                            <a href="#" data-toggle="modal" data-target="#detail<%= appointment.get(k).getAppnt_no()%>">
                                                <div class="<% if (appointment.get(k).getAppnt_type().equals("personal")) { %>
                                                     eventday eventday-blue
                                                     <% } else if (appointment.get(k).getAppnt_type().equals("shared")) { %>
                                                     eventday eventday-red
                                                     <% } else if (appointment.get(k).getAppnt_type().equals("university")) { %>
                                                     eventday eventday-green
                                                     <% } else { %>
                                                     eventday eventday-yellow
                                                     <% }%> "><strong><%= df.format(appointment.get(k).getAppnt_start_time())%> - <%= df.format(appointment.get(k).getAppnt_end_time())%> </strong>
                                                    <%if (df2.format(appointment.get(k).getAppnt_start_date()).equals(date_mark_check) && df2.format(appointment.get(k).getAppnt_end_date()).equals(date_mark_check)) {%>
                                                    <%= appointment.get(k).getTitle()%>
                                                    <% }else if (df2.format(appointment.get(k).getAppnt_start_date()).equals(date_mark_check)) {%>
                                                    << EVENT START >> <%= appointment.get(k).getTitle()%>
                                                    <% } else if (df2.format(appointment.get(k).getAppnt_end_date()).equals(date_mark_check)) {%>
                                                    << EVENT END >> <%= appointment.get(k).getTitle()%>
                                                    <% } %></div>
                                            </a>
                                            <% }%>
                                            <% if(appointment.size() == 0) { %>
                                            <p style="color: #000;">No event on this day.</p>
                                            <% } %>
                                            
                                        </div>

                                    </div>

                                </div>
                                <div class="col-md-1"></div>
                            </div>
                        </div>
                    </div>
                    <div class="mastfoot">

                        <p>Information Technology, King Mongkut's Institude Technology of Ladkrabang.</p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal -->
        <div id="myAdd" class="modal fade" role="dialog">
            <div class="modal-dialog"> 

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Add your events</h4>
                    </div>
                    <div class="modal-body">
                        <p>Enter your details.</p>
                        <div class="form-group">
                            <label for="title">Title</label>
                            <input type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="detail">Description</label>
                            <textarea class="form-control" rows="3" id="detail"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="detail">Start</label>
                            <input size="16" type="text" value="" readonly class="form_datetime">
                        </div>
                        <div class="form-group">
                            <label for="detail">End</label>
                            <input size="16" type="text" value="" readonly class="form_datetime">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="allday" value="1">
                                All day events</label>
                        </div>
                        <button type="submit" class="btn-default btn-submit" >Add</button>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal -->
        <div id="myJump" class="modal fade" role="dialog">
            <div class="modal-dialog"> 

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">GO TO</h4>
                    </div>
                    <div class="modal-body">
                        <p>Jump to?</p>
                        <form action="main-d.jsp" method="GET">
                            <div class="form-group">
                                <label for="detail">DATE - MONTH - YEAR</label>
                                <input size="16" type="text" value="" readonly class="form_dmy" name="jump">
                            </div>
                            <button type="submit" class="btn-default btn-submit" >GO!</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <% appointment = cm.getAppointment(caldtb, person_who, user_id);

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
                            <%= df3.format(appointment.get(i).getAppnt_start_date())%>
                            <% } else {%> <%= df3.format(appointment.get(i).getAppnt_start_date())%> - <%= df3.format(appointment.get(i).getAppnt_end_date())%> <% }%></p>
                        <p>Time: <%= df.format(appointment.get(i).getAppnt_start_time())%> - <%= df.format(appointment.get(i).getAppnt_end_time())%></p>
                        <p> <%= appointment.get(i).getDescription()%> </p>
                        <form action="delapp.process" method="GET">
                            <div style="height: 0px; overflow: hidden;">
                                <input type="text" name="id" value="<%=appointment.get(i).getAppnt_no()%>" readonly>
                            </div>
                            <button type="submit" class="btn-default btn-submit">Delete</button> </form>
                        <button type="button" class="btn-default btn-submit" ><a href="#" data-toggle="modal" data-target="#edit<%= appointment.get(i).getAppnt_no()%>">Edit</a></button>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <%}
        %>
        <% for (int k = 0; k < appointment.size(); k++) {%>
        <div id="edit<%= appointment.get(k).getAppnt_no()%>" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Edit your events: <%= appointment.get(k).getTitle()%></h4>
                    </div>
                    <div class="modal-body">
                        <form action="editapp.process" method="GET">
                            <div style="height: 0px; overflow: hidden;">
                                <input type="text" name="id" value="<%=appointment.get(k).getAppnt_no()%>" readonly>
                            </div>
                            <div class="form-group">
                                <label for="title">Title</label>
                                <input type="text" class="form-control" name="title" value="<%= appointment.get(k).getTitle()%>">
                            </div>
                            <div class="form-group">
                                <label for="description">Description</label>
                                <textarea class="form-control" rows="3" name="description" ><%= appointment.get(k).getDescription()%></textarea>
                            </div>
                            <div class="form-group">
                                <label for="start_time">Start</label>
                                <input size="16" type="text" name="start" value="<%=df3.format(appointment.get(k).getAppnt_start_date())%> <%=df.format((appointment.get(k).getAppnt_start_time()))%>" readonly class="form_datetime">
                            </div>
                            <div class="form-group">
                                <label for="start_time">End</label>
                                <input size="16" type="text" name="end" value="<%=df3.format(appointment.get(k).getAppnt_end_date())%> <%=df.format((appointment.get(k).getAppnt_end_time()))%>" readonly class="form_datetime">
                            </div>
                            <button type="submit" class="btn-default btn-submit">Apply</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <% } %>
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
            $(".form_dmy").datetimepicker({format: 'dd-mm-yyyy',
                startView: "month",
                minView: "month"});

        </script>
    </body>
</html>

