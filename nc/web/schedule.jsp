<%-- 
    Document   : schedule
    Created on : Apr 23, 2017, 4:26:58 PM
    Author     : Plaster
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="model.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/search-stylesheet.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Prompt:300,400,500,600,700,800,900" rel="stylesheet">
        <link href="css/w3.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>ESMICs | Class schedule</title>
    </head>
    <body>
        <%if (session.getAttribute("person") == null) { %>
        <jsp:forward page="index.jsp"/>
        <% }%>
        <%
            ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection");
            String person_who = (String) session.getAttribute("who");
        %>
        <div class="site-wrapper">
            <div class="cover-container">
                <div class="row-fluid padding-top-10">
                    <nav class="navbar navbar-default navbarcover">
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
                                    <li class="active"><a href="search-course.html" class="activecover" >Class schedule</a></li>
                                    <% if(person_who.equals("student")){ %>
                                        <li><a href="find-a-teacher.html" class="nav-list-detail" >Busy finder</a></li>
                                        <%}else{%>
                                        <li><a href="find-a-student.jsp" class="nav-list-detail" >Busy finder</a></li>
                                        <%} %>
                                    <li><a href="vote.jsp" class="nav-ls-color" >Appointment vote</a></li>

                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <li><a href="profile.jsp" class="nav-ls-color">Profile</a></li>
                                    <li><a class="nav-ls-color" href="logout.process"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
                <h1 class="text-center padding-top-5-p padding-bott-20">Class schedule</h1>
                <div class="col-md-2"></div>
                <div class="col-md-8"><form action="sc.process" method="GET">
                    <div class="w3-panel w3-card width-100-p">
                        <div class="input-group padding-top-20">
                            <input name = "course" type="text" class="form-control" placeholder="Search by subject code...">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="submit">Search</button>
                            </span>
                        </div>
                        <div class="text-center padding-top-20">
                            <label>Or</label>
                        </div>
                        <div class="col-md-6 col-sm-6 padding-top-20">
                            <div class="form-group">
                                <label for="sel1">Faculty :</label>
                                <select name="faculty" class="form-control" id="faculty_id">
                                    <option>Information Technology</option>
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
                                <label for="sel6">Term :</label>
                                <select name="term" class="form-control" id="term_id">
                                    <option value="all">All Term</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6 padding-top-20">
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
                                <label for="sel5">Year :</label>
                                <select name="year" class="form-control" id="year_id">
                                    <option value="all">All Year</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                </select>
                            </div>
                        </div>
                        <div class="text-center padding-bott-10">
                            
                                <div class="btn btn-default padding" type="submit">Search</div>
                            </a>
                        </div>
                    </div></form>
                </div>
                <div class="col-md-2"></div>
            </div>

        </div>
    </body>
</html>