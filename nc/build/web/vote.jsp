<%-- 
    Document   : vote
    Created on : Apr 23, 2017, 2:57:03 AM
    Author     : Plaster
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="model.Poll"%>
<%@page import="java.util.List"%>
<%@page import="model.Course"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/vote-stylesheet.css" rel="stylesheet">
        <link href="css/datetimepicker.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Prompt:300,400,500,600,700,800,900" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/datetimepicker.js"></script>
        <script src="js/datetimepicker.min.js"></script>

        <title>ESMICs | Appointment vote</title>
    </head>

    <body>
        <%if (session.getAttribute("person") == null) { %>
        <jsp:forward page="index.jsp"/>
        <% }%>
        <%
            String person_who = (String) session.getAttribute("who");
            ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection");
            String user_id = (String) session.getAttribute("user_id");
            List<Poll> poll_li;
            List<String> choice_li;
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
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
                        <h1>Appointment Vote</h1>
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-md-12 main-col-detail">
                                    <div class="menu-card"> <%if (person_who.equals("teacher")) { %>
                                        <a data-toggle="modal" data-target="#myAdd">
                                            <div class="menu-card-inside"> <span class="glyphicon glyphicon-plus"></span> </div>
                                        </a> <%}%> </div>
                                    <div class="w3-panel w3-card card-main-detail">
                                        <p> <%if (person_who.equals("student")) {
                                                Poll pol = new Poll();
                                                poll_li = pol.getPollStudent(caldtb, user_id);
                                                for (int i = 0; i < poll_li.size(); i++) {%>
                                            <a data-toggle="modal" data-target="#vote<%=poll_li.get(i).getAppnt_no()%>" class="title-yellow">
                                                <div class="notice notice-yellow"> <strong><%=poll_li.get(i).getTitle()%></strong> 
                                                    <%if (poll_li.get(i).getDescription().length() > 81) {%><%= poll_li.get(i).getDescription().substring(0, 80)%>...<%} else { %>
                                                        <%= poll_li.get(i).getDescription()%>
                                                    <%}%>
                                                </div>
                                            </a>
                                            <%}
                                                }%>
                                            <%if (person_who.equals("teacher")) {
                                                    Poll pol = new Poll();
                                                    poll_li = pol.getPollTeacher(caldtb, user_id);
                                                    for (int i = 0; i < poll_li.size(); i++) {%>
                                            <a data-toggle="modal" data-target="#vote<%=poll_li.get(i).getAppnt_no()%>" class="title-yellow">
                                                <div class="notice notice-yellow"> <strong><%=poll_li.get(i).getTitle()%></strong> 
                                                    <%if (poll_li.get(i).getDescription().length() > 81) {%><%= poll_li.get(i).getDescription().substring(0, 80)%>...<%} else { %>
                                                        <%= poll_li.get(i).getDescription()%>
                                                    <%}%>
                                                </div>
                                            </a>
                                            <%}
                                                }%>


                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mastfoot">
                        <p></p>
                    </div>
                </div>
            </div>
        </div>
        <div id="myAdd" class="modal fade" role="dialog">
            <div class="modal-dialog"> 

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Add your Poll</h4>
                    </div>
                    <div class="modal-body"><form action="vote.process" method="GET">
                            <p>Enter your details.</p>
                            <div class="form-group">
                                <label for="title">Title</label>
                                <input name="title" type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="detail">Description</label>
                                <textarea name="description" class="form-control" rows="3" id="detail"></textarea>
                            </div>
                            <div class="form-group">
                                <label for="sel1">Faculty :</label>
                                <select name="faculty" class="form-control" id="faculty_id">
                                    <option>Information Technology</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="sel4">Department :</label>
                                <select name="department" class="form-control" id="dept_id">
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
                                <select name="branch" class="form-control" id="major_id">
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
                                <select name="year" class="form-control optionlist" id="year_id">
                                    <option value="all">All Year</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="sel3">Course :</label>
                                <select name="course" class="form-control optionlist" id="course_id">
                                    <option value="all">All Course</option>
                                    <% Course cou_s = new Course();
                                        List<Course> all_course = cou_s.getNameAllCourse(caldtb);
                                        for (int i = 0; i < all_course.size(); i++) {%>
                                    <option name="<%= all_course.get(i).getCourse_id()%>"><%=all_course.get(i).getCourse_name()%></option>
                                    <% }
                                    %>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="detail">Poll Start</label>
                                <input name="start" size="16" type="text" value="" readonly class="form_datetime">
                            </div>
                            <div class="form-group">
                                <label for="detail">Poll End</label>
                                <input name="end" size="16" type="text" value="" readonly class="form_datetime">
                            </div>
                            <div class="form-group">
                                <label for="detail">Poll choice</label>
                                <textarea name="choice" class="form-control" rows="3" id="detail"></textarea>
                            </div>
                            <p>พิมพ์ตัวเลือกการลงคะแนนลงในช่อง และใช้เครื่องหมายจุลภาคในการคั่นระหว่างตัวเลือกโดยไม่ต้องเว้นวรรค</p>
                            <button type="submit" class="btn-default btn-submit" >Add</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <%if (person_who.equals("student")) {
                Poll pol = new Poll();
                poll_li = pol.getPollStudent(caldtb, user_id);
                for (int i = 0; i < poll_li.size(); i++) {%>
        <div id="vote<%=poll_li.get(i).getAppnt_no()%>" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title"><%=poll_li.get(i).getTitle()%></h4>
                    </div>
                    <div class="modal-body"><form action="voteselect.process" method="GET">
                            <div style="height: 0px; overflow: hidden;">
                                <input type="text" name="id" value="<%=poll_li.get(i).getAppnt_no()%>" readonly>
                            </div>
                            <p>Title: <%=poll_li.get(i).getTitle()%></p>
                            <p>Description: <%=poll_li.get(i).getDescription()%></p>
                            <p>Start: <%=poll_li.get(i).getAppnt_open_date()%> </p>
                            <p>End: <%=poll_li.get(i).getAppnt_close_date()%></p>
                            <strong>Vote</strong> <br>

                            <% choice_li = poll_li.get(i).getChoice();
                                for (int j = 0; j < choice_li.size(); j++) {%>
                            <input type="radio" name="choice" value="<%=j%>"> <%=choice_li.get(j)%> <br>
                            <%}
                            %>
                            <button type="submit" class="btn-default btn-submit">Vote</button>
                        </form></div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <%}
            }%>
        <%if (person_who.equals("teacher")) {
                Poll pol = new Poll();
                poll_li = pol.getPollTeacher(caldtb, user_id);
                for (int i = 0; i < poll_li.size(); i++) {%>
        <div id="vote<%=poll_li.get(i).getAppnt_no()%>" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title"><%=poll_li.get(i).getTitle()%></h4>
                    </div>
                    <div class="modal-body">
                            <div style="height: 0px; overflow: hidden;">
                                <input type="text" name="id" value="<%=poll_li.get(i).getAppnt_no()%>" readonly>
                            </div>
                            <p>Title: <%=poll_li.get(i).getTitle()%></p>
                            <p>Description: <%=poll_li.get(i).getDescription()%></p>
                            <p>Start: <%=poll_li.get(i).getAppnt_open_date()%> </p>
                            <p>End: <%=poll_li.get(i).getAppnt_close_date()%></p>
                            <strong>Vote Result</strong> <br>

                            <% choice_li = poll_li.get(i).getChoice();
                                for (int j = 0; j < choice_li.size(); j++) {%>
                            <p><%=choice_li.get(j)%></p> <br>
                            <%}
                            %>
                            <button type="submit" class="btn-default btn-submit">Vote</button><form action="delvote.process" method="POST">
                                <div style="height: 0px; overflow: hidden;">
                                <input type="text" name="id" value="<%=poll_li.get(i).getAppnt_no()%>" readonly>
                            </div>
                                <button type="submit" class="btn-default btn-submit">Delete</button>
                        </form></div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <%}
            }%>


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

    </script>
</html>
