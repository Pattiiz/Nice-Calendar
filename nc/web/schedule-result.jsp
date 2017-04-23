<%-- 
    Document   : schedule-result
    Created on : Apr 23, 2017, 5:18:32 PM
    Author     : Plaster
--%>

<%@page import="model.Course"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
        <title>ESMICs | Search schedule result</title>
    </head>

    <body>
        <% DateFormat df2 = new SimpleDateFormat("d-MM-yyyy");
            DateFormat df3 = new SimpleDateFormat("HH:mm");
            List<Appointment> appointment;
            String person_who = (String) session.getAttribute("who");
            ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection");
            String user_id = (String) session.getAttribute("user_id");
            List<Course> cou_li = (List<Course>) session.getAttribute("cou_search");
        %>
        <div class="site-wrapper">
            <div class="site-wrapper-inner">
                <div class="cover-container">
                    <div class="masthead">

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
                                    <form action="sc.process" method="GET">
                                        
                                    </form>
                                    <div class="w3-panel w3-card card-main-detail">
                                        <p> <%
                                            for (int i = 0; i < cou_li.size(); i++) {%>
                                            <a href="#" class="title-yellow">
                                                <div class="notice notice-blue">
                                                    <div class="row">
                                                        <div class="col-md-11">
                                                            <strong><%=cou_li.get(i).getCourse_name()%></strong><br>
                                                            <p>Department: <%= cou_li.get(i).getDepartment()%></p>
                                                            <P>Branch: <%=cou_li.get(i).getBranch()%></p>
                                                            <p>Mid term exam: <%=cou_li.get(i).getMid_exam_date()%> <%=cou_li.get(i).getMid_exam_time()%> </p>
                                                            <p>Final term exam: <%=cou_li.get(i).getFinal_exam_date()%> <%=cou_li.get(i).getFinal_exam_time()%> </p>
                                                            <p>School day: <%=cou_li.get(i).getSchool_day().toUpperCase()%> <%=cou_li.get(i).getStudy_time()%> </p>
                                                            <p>Section: <%=cou_li.get(i).getSection()%> | Year: <%=cou_li.get(i).getYear()%> | Term: <%=cou_li.get(i).getTerm()%>
                                                            <p>Teacher: <%=cou_li.get(i).getTeacher()%>
                                                        </div>
                                                            <div class="col-md-1"><a href="sca.process?course_add=<%=cou_li.get(i).getCourse_id()%>&section=<%=cou_li.get(i).getSection() %>">
                                                                <div class="menu-card-inside"> <span class="glyphicon glyphicon-plus"></span> </div>
                                                            </a></div>
                                                    </div>
                                                </div>
                                            </a>
                                            <% if (cou_li.size() == 0) { %>
                                        <p style="color: #000;">No schedule class found. Try again.</p>
                                        <% } %>
                                        <% }
                                        %>
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

        <div id="acceptpopup" class="modal fade" role="dialog">
            <div class="modal-dialog"> 

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">แจ้งเตือน</h4>
                    </div>
                    <div class="modal-body">
                        <p>เพิ่มตารางวิชาเรียนนี้ลงในระบบและปฏิทินเรียบร้อยแล้ว</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

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
        <%if (request.getAttribute("accept") != null) { %>
        $(document).ready(function () {

            $('#acceptpopup').modal('show');

        });
        <% }%>
    </script>
</html>
