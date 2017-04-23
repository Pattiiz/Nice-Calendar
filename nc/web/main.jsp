<%-- 
    Document   : main
    Created on : Apr 13, 2017, 5:33:21 PM
    Author     : Plaster
--%>

<%@page import="model.Course"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="model.Appointment"%>
<%@page import="java.util.Calendar"%>
<%@page import="model.Calendarmodel"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Array"%>
<%@page import="java.util.List"%>
<%@page import="model.Staff"%>
<%@page import="model.Student"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main-stylesheet.css" rel="stylesheet">
        <link href="css/w3.css" rel="stylesheet">
        <link href="css/datetimepicker.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Prompt:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/datetimepicker.js"></script>
        <script src="js/datetimepicker.min.js"></script>
        <title>ESMICs | Main</title>
    </head>
    <body>
        <%if (session.getAttribute("person") == null) { %>
        <jsp:forward page="index.jsp"/>
        <% }%>
        <% int undate_flag = 0;
            int appointment_phase = 0;
            Calendarmodel cm = (Calendarmodel) session.getAttribute("cm");
            Calendar date = Calendar.getInstance();
            int date_count = 0;
            List<Appointment> appointment;
            DateFormat df = new SimpleDateFormat("yyyy-M-d");
            DateFormat df2 = new SimpleDateFormat("d-MM-yyyy");
            DateFormat df3 = new SimpleDateFormat("HH:mm");
            String date_mark_check = null;
            String person_who = (String) session.getAttribute("who");
            ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection");
            List<String> month_title = Arrays.asList("January", "Febuary", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December");
            String user_id = (String) session.getAttribute("user_id");
        %>
        <%if (request.getParameter("dsp_method") != null) {
                if (request.getParameter("dsp_method").equals("prev")) {
                    if (cm.getMonth() == 1) {
                        cm.setMonth(12);
                        cm.setYear(cm.getYear() - 1);
                    } else {
                        cm.setMonth(cm.getMonth() - 1);
                    }

                } else if (request.getParameter("dsp_method").equals("next")) {
                    if (cm.getMonth() == 12) {
                        cm.setMonth(1);
                        cm.setYear(cm.getYear() + 1);
                    } else {
                        cm.setMonth(cm.getMonth() + 1);
                    }

                } else if (request.getParameter("dsp_method").equals("today")) {
                    cm.setDay(date.get(Calendar.DATE));
                    cm.setMonth(date.get(Calendar.MONTH) + 1);
                    cm.setYear(date.get(Calendar.YEAR));

                }
            }
            if (request.getParameter("jump") != null) {
                String[] jump = request.getParameter("jump").split("-");
                cm.setMonth(Integer.parseInt(jump[0]));
                cm.setYear(Integer.parseInt(jump[1]));
            }
            List<String> mc = cm.getMonthcalendar();%>
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
                                        <li class="active"><a href="main.jsp" class="activecover">Home</a></li>
                                        <li><a href="schedule.jsp" class="nav-list-detail" >Class schedule</a></li>
                                        <% if(person_who.equals("student")){ %>
                                        <li><a href="find-a-teacher.html" class="nav-list-detail" >Busy finder</a></li>
                                        <%}else{%>
                                        <li><a href="find-a-student.jsp" class="nav-list-detail" >Busy finder</a></li>
                                        <%} %>
                                        <li><a href="vote.jsp" class="nav-list-detail" >Appointment vote</a></li>
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
                        <h1>Hello ${sessionScope.person.fname} ${sessionScope.person.lname} :)</h1>
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-md-1"></div>
                                <div class="col-md-10">
                                    <form action="search.process" method="GET">
                                        <div class="row input-group search-bar"> 
                                            <input name="search" type="text" class="form-control" placeholder="Search" />
                                            <span class="input-group-btn">
                                                <button class="btn btn-default btn-search" type="submit"> <span class="glyphicon glyphicon-search"></span> </button>
                                            </span></div>
                                    </form>
                                    <div class="row contain-main">
                                        <div class="col-md-4 contain-header-left"><%= month_title.get(cm.getMonth() - 1)%> <%= cm.getYear()%></div>
                                        <div class="col-md-4">
                                            <ul class="pagination contain-header-mid">
                                                <li><a href="main-d.jsp" class="contain-header-mid-detail">Day</a></li>
                                                <li><a href="#" class="contain-header-mid-detail" style="background-color:#c0c0c0;">Month</a></li>
                                            </ul>
                                        </div>
                                        <div class="col-md-4 contain-header-dright">
                                            <ul class="pagination contain-header-right">
                                                <li><a href="main.jsp?dsp_method=prev" class="contain-header-right-detail2"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
                                                <li><a href="main.jsp?dsp_method=next" class="contain-header-right-detail2"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
                                            </ul>
                                            <ul class="pagination contain-header-right">
                                                <li><a href="main.jsp?dsp_method=today" class="contain-header-right-detail">Today</a></li>
                                                <li><a href="#" class="contain-header-right-detail" data-toggle="modal" data-target="#myJump">Go to</a></li>
                                            </ul>
                                            <ul class="pagination contain-header-right">
                                                <li><a href="#" class="contain-header-right-detail2" data-toggle="modal" data-target="#myAdd"><span class="glyphicon glyphicon-plus"></span></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="row contain-main">
                                        <table class="table contain-table">
                                            <thead class="contain-table-head">
                                                <tr>
                                                    <td>MON</td>
                                                    <td>TUE</td>
                                                    <td>WED</td>
                                                    <td>THU</td>
                                                    <td>FRI</td>
                                                    <td>SAT</td>
                                                    <td>SUN</td>
                                                </tr>
                                            </thead>
                                            <tbody class="contain-table-date">
                                                <% for (int i = 1; i <= 6; i++) { %>
                                                <tr><%
                                                    for (int j = 1; j <= 7; j++) {
                                                        if (mc.get(date_count).equals("1") && undate_flag == 0) {
                                                            undate_flag = 1;
                                                            appointment_phase = 1;
                                                        } else if (mc.get(date_count).equals("1") && undate_flag == 1) {
                                                            undate_flag = 0;
                                                            appointment_phase = 2;
                                                        }%>
                                                    <td class="<% if (undate_flag == 0) { %>
                                                        contain-date-unmonth 
                                                        <% }
                                                            if (j == 6 || j == 7) { %>
                                                        contain-table-holiday 
                                                        <% }%> "><div style="height: 75px; overflow: hidden;"> 
                                                            <% if (String.valueOf(date.get(Calendar.DATE)).equals(mc.get(date_count)) && date.get(Calendar.MONTH) + 1 == cm.getMonth() && date.get(Calendar.YEAR) == cm.getYear()) { %>
                                                            <div class="contain-table-active">
                                                                <% }%> <%= mc.get(date_count)%> 
                                                                <% if (String.valueOf(date.get(Calendar.DATE)).equals(mc.get(date_count)) && date.get(Calendar.MONTH) + 1 == cm.getMonth() && date.get(Calendar.YEAR) == cm.getYear()) { %>
                                                            </div>
                                                            <% } %>
                                                            <% Calendarmodel cm2 = new Calendarmodel();
                                                                cm2.setDay(Integer.parseInt(mc.get(date_count)));
                                                                if (appointment_phase == 0) {
                                                                    if (cm.getMonth() == 1) {
                                                                        cm2.setMonth(12);
                                                                        cm2.setYear(cm.getYear() - 1);
                                                                    } else {
                                                                        cm2.setMonth(cm.getMonth() - 1);
                                                                        cm2.setYear(cm.getYear());
                                                                    }
                                                                } else if (appointment_phase == 1) {
                                                                    cm2.setMonth(cm.getMonth());
                                                                    cm2.setYear(cm.getYear());
                                                                } else {
                                                                    if (cm.getMonth() == 12) {
                                                                        cm2.setMonth(1);
                                                                        cm2.setYear(cm.getYear() + 1);
                                                                    } else {
                                                                        cm2.setMonth(cm.getMonth() + 1);
                                                                        cm2.setYear(cm.getYear());
                                                                    }
                                                                }
                                                                appointment = cm2.getAppointment(caldtb, person_who, user_id);
                                                                date_mark_check = cm2.getYear() + "-" + cm2.getMonth() + "-" + cm2.getDay();

                                                                for (int k = 0; k < appointment.size(); k++) {%>
                                                            <a href="#detail<%= appointment.get(k).getAppnt_no()%>" data-toggle="modal"
                                                               data-target="#detail<%= appointment.get(k).getAppnt_no()%>">
                                                                <div class ="<% if (appointment.get(k).getAppnt_type().equals("personal")) { %>
                                                                     event eventday-blue
                                                                     <% } else if (appointment.get(k).getAppnt_type().equals("shared")) { %>
                                                                     event eventday-red
                                                                     <% } else if (appointment.get(k).getAppnt_type().equals("university")) { %>
                                                                     event eventday-green
                                                                     <% } else { %>
                                                                     event eventday-yellow
                                                                     <% } %> " <% if (String.valueOf(date.get(Calendar.DATE)).equals(mc.get(date_count)) && date.get(Calendar.MONTH) + 1 == cm.getMonth() && date.get(Calendar.YEAR) == cm.getYear()) { %>
                                                                     style="margin-top: 22px;" <% } %> > <%
                                                                         if (df.format(appointment.get(k).getAppnt_start_date()).equals(date_mark_check) && df.format(appointment.get(k).getAppnt_end_date()).equals(date_mark_check)) {%>
                                                                    <%= appointment.get(k).getTitle()%>
                                                                    <% } else if (df.format(appointment.get(k).getAppnt_start_date()).equals(date_mark_check)) {%>
                                                                    < START: <%= appointment.get(k).getTitle()%>
                                                                    <% } else if (df.format(appointment.get(k).getAppnt_end_date()).equals(date_mark_check)) {%>
                                                                    END: <%= appointment.get(k).getTitle()%> >
                                                                    <% } %> </div></a>

                                                            <% }
                                                            %>
                                                        </div><%if (appointment.size() >= 3) {%><div style="font-size: 10px;"> <a href="main-d.jsp?jump=<%=cm2.getDay()%>-<%=cm2.getMonth()%>-<%=cm2.getYear()%>"> more...</a></div><%}%></td>
                                                    <% date_count++;
                                                        } %> </tr>
                                                    <% }%>



                                            </tbody>
                                        </table>
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
        <!--Add Modal -->
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
                        <form action="appointment.process" method="GET">
                            <div class="form-group">
                                <label for="title">Title</label>
                                <input type="text" class="form-control" name="title">
                            </div>
                            <div class="form-group">
                                <label for="detail">Description</label>
                                <textarea name="description" class="form-control" rows="3" id="detail"></textarea>
                            </div>
                            <div class="form-group">
                                <label for="start_time">Start</label>
                                <input name="start" size="16" type="text" value="" readonly class="form_datetime">
                            </div>
                            <div class="form-group">
                                <label for="end_time">End</label>
                                <input name="end" size="16" type="text" value="" readonly class="form_datetime">
                            </div>
                            <% if (person_who.equals("staff") || person_who.equals("teacher")) { %>
                            <p><input type="checkbox" id="blocked" name="blocked" /> Share events to your students</p><br>
                            <div class="form-group">
                                <label for="sel1">Faculty :</label>
                                <select name="faculty" class="form-control optionlist" id="faculty_id" disabled>
                                    <option>Information Technology</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="sel4">Department :</label>
                                <select name="department" class="form-control" id="dept_id" disabled>
                                    <option selected value="all">All Department</option>
                                    <% Course cou_d = new Course();
                                        List<Course> all_department = cou_d.getNameAllDepartment(caldtb);
                                        for (int i = 0; i < all_department.size(); i++) {%>
                                    <option name="<%= all_department.get(i).getDepartment()%>"><%= all_department.get(i).getDepartment()%></option>
                                    <% }
                                    %>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="sel2">Major / Track :</label>
                                <select name="branch" class="form-control" id="major_id" disabled>
                                    <option selected value="all">All Major / Track</option>
                                    <% Course cou_b = new Course();
                                        List<Course> all_branch = cou_b.getNameAllBranch(caldtb);
                                        for (int i = 0; i < all_branch.size(); i++) {%>
                                    <option name="<%= all_branch.get(i).getBranch()%>"><%= all_branch.get(i).getBranch()%></option>
                                    <% }
                                    %>

                                </select>
                            </div>
                            <div class="form-group">
                                <label for="sel5">Year :</label>
                                <select name="year" class="form-control optionlist" id="year_id" disabled>
                                    <option value="all">All Year</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="sel3">Course :</label>
                                <select name="course" class="form-control optionlist" id="course_id" disabled>
                                    <option value="all">All Course</option>
                                    <% Course cou_s = new Course();
                                        List<Course> all_course = cou_s.getNameAllCourse(caldtb);
                                        for (int i = 0; i < all_course.size(); i++) {%>
                                    <option name="<%= all_course.get(i).getCourse_id()%>"><%=all_course.get(i).getCourse_name()%></option>
                                    <% }
                                    %>
                                </select>
                            </div>
                            <%}%>

                            <button type="submit" class="btn-default btn-submit" >Add</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <!--Jump Modal -->
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
                        <form action="main.jsp" method="GET">
                            <div class="form-group">
                                <label for="detail">MONTH / YEAR</label>
                                <input size="16" type="text" value="" readonly class="form_month_year" name="jump">
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
        <!-- Appointment modal -->
        <% appointment_phase = 0;
            undate_flag = 0;
            for (int i = 0; i < 42; i++) {
                if (mc.get(i).equals("1") && undate_flag == 0) {
                    undate_flag = 1;
                    appointment_phase = 1;
                } else if (mc.get(i).equals("1") && undate_flag == 1) {
                    undate_flag = 0;
                    appointment_phase = 2;
                }
                Calendarmodel cm3 = new Calendarmodel();
                cm3.setDay(Integer.parseInt(mc.get(i)));
                if (appointment_phase == 0) {
                    if (cm.getMonth() == 1) {
                        cm3.setMonth(12);
                        cm3.setYear(cm.getYear() - 1);
                    } else {
                        cm3.setMonth(cm.getMonth() - 1);
                        cm3.setYear(cm.getYear());
                    }
                } else if (appointment_phase == 1) {
                    cm3.setMonth(cm.getMonth());
                    cm3.setYear(cm.getYear());
                } else {
                    if (cm.getMonth() == 12) {
                        cm3.setMonth(1);
                        cm3.setYear(cm.getYear() + 1);
                    } else {
                        cm3.setMonth(cm.getMonth() + 1);
                        cm3.setYear(cm.getYear());
                    }
                }
                appointment = cm3.getAppointment(caldtb, person_who, user_id);
                date_mark_check = cm3.getYear() + "-" + cm3.getMonth() + "-" + cm3.getDay();
                for (int k = 0; k < appointment.size(); k++) {%>
        <div id="detail<%= appointment.get(k).getAppnt_no()%>" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title"><%= appointment.get(k).getTitle()%></h4>
                    </div>
                    <div class="modal-body">
                        <p>Date: <%if (appointment.get(k).getAppnt_start_date().equals(appointment.get(k).getAppnt_end_date())) {%>
                            <%= df2.format(appointment.get(k).getAppnt_start_date())%>
                            <% } else {%> <%= df2.format(appointment.get(k).getAppnt_start_date())%> - <%= df2.format(appointment.get(k).getAppnt_end_date())%> <% }%></p>
                        <p>Time: <%= df3.format(appointment.get(k).getAppnt_start_time())%> - <%= df3.format(appointment.get(k).getAppnt_end_time())%></p>
                        <p> <%= appointment.get(k).getDescription()%> </p><form action="delapp.process" method="GET">
                            <div style="height: 0px; overflow: hidden;">
                                <input type="text" name="id" value="<%=appointment.get(k).getAppnt_no()%>" readonly>
                            </div>
                            <button type="submit" class="btn-default btn-submit">Delete</button> </form>
                        <button type="button" class="btn-default btn-submit" ><a href="#" data-toggle="modal" data-target="#edit<%= appointment.get(k).getAppnt_no()%>">Edit</a></button>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <% }
            }

        %>
        <!-- Appointment edit modal -->
        <% appointment_phase = 0;
            undate_flag = 0;
            for (int i = 0; i < 42; i++) {
                if (mc.get(i).equals("1") && undate_flag == 0) {
                    undate_flag = 1;
                    appointment_phase = 1;
                } else if (mc.get(i).equals("1") && undate_flag == 1) {
                    undate_flag = 0;
                    appointment_phase = 2;
                }
                Calendarmodel cm3 = new Calendarmodel();
                cm3.setDay(Integer.parseInt(mc.get(i)));
                if (appointment_phase == 0) {
                    if (cm.getMonth() == 1) {
                        cm3.setMonth(12);
                        cm3.setYear(cm.getYear() - 1);
                    } else {
                        cm3.setMonth(cm.getMonth() - 1);
                        cm3.setYear(cm.getYear());
                    }
                } else if (appointment_phase == 1) {
                    cm3.setMonth(cm.getMonth());
                    cm3.setYear(cm.getYear());
                } else {
                    if (cm.getMonth() == 12) {
                        cm3.setMonth(1);
                        cm3.setYear(cm.getYear() + 1);
                    } else {
                        cm3.setMonth(cm.getMonth() + 1);
                        cm3.setYear(cm.getYear());
                    }
                }
                appointment = cm3.getAppointment(caldtb, person_who, user_id);
                date_mark_check = cm3.getYear() + "-" + cm3.getMonth() + "-" + cm3.getDay();
                for (int k = 0; k < appointment.size(); k++) {%>
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
                                <input size="16" type="text" name="start" value="<%=df2.format(appointment.get(k).getAppnt_start_date())%> <%=df3.format((appointment.get(k).getAppnt_start_time()))%>" readonly class="form_datetime">
                            </div>
                            <div class="form-group">
                                <label for="start_time">End</label>
                                <input size="16" type="text" name="end" value="<%=df2.format(appointment.get(k).getAppnt_end_date())%> <%=df3.format((appointment.get(k).getAppnt_end_time()))%>" readonly class="form_datetime">
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
        <% }
            }

        %>
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

            $(".form_datetime").datetimepicker({format: 'dd-mm-yyyy hh:ii'});
            $(".form_month_year").datetimepicker({format: 'mm-yyyy',
                startView: "year",
                minView: "year"});
            $('#blocked').change(function () {
                $("#faculty_id").prop("disabled", !$(this).is(':checked'));
                $("#dept_id").prop("disabled", !$(this).is(':checked'));
                $("#major_id").prop("disabled", !$(this).is(':checked'));
                $("#course_id").prop("disabled", !$(this).is(':checked'));
                $("#year_id").prop("disabled", !$(this).is(':checked'));
            });

        </script>

    </body>
</html>
