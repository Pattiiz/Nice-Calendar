<%-- 
    Document   : find-a-student
    Created on : Apr 23, 2017, 10:32:41 PM
    Author     : Plaster
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="model.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/search-stylesheet.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Prompt:300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://www.w3schools.com/w3css/4/w3.css" rel="stylesheet">
        <link href="css/datetimepicker.css" rel="stylesheet" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/datetimepicker.js"></script>
        <script src="js/datetimepicker.min.js"></script>
        <title>ESMICs | Busy finder</title>
    </head>
    <body>
        <%ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection");
            String person_who = (String) session.getAttribute("who");%>
        <div class="site-wrapper">
            <div class="cover-container">
                <div class="row-fluid padding-top-10">
                    <nav class="navbar navbar-default navbarcover">
                        <div class="container-fluid">
                            <div class="navbar-header"> <a class="navbar-brand nav-ls-color" href="main.jsp">ESMICs</a>
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar"> <span class="icon-bar-color icon-bar"></span> <span class="icon-bar-color icon-bar"></span> <span class="icon-bar-color icon-bar"></span> </button>
                            </div>
                            <div class="collapse navbar-collapse" id="myNavbar">
                                <ul class="nav navbar-nav">
                                    <li><a href="main.jsp" class="nav-ls-color">Home</a></li>
                                    <% if(person_who.equals("student")){ %>
                                        <li><a href="schedule.jsp" class="nav-ls-color" >Class schedule</a></li>
                                        <% } %>
                                    <li class="active"><a href="find-a-student.jsp" class="activecover">Busy finder</a></li>
                                    <li><a href="vote.jsp" class="nav-ls-color">Appointment vote</a></li>
                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <li><a href="profile.jsp" class="nav-ls-color">Profile</a></li>
                                    <li><a class="nav-ls-color" href="logout.process"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
                <h1 class="text-center padding-top-5-p padding-bott-20">Busy finder</h1>
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="w3-panel w3-card width-100-p"><form action="ftstudent.process" method="GET">
                        <div class="col-md-6 col-sm-6 padding-top-20">
                            <div class="form-group">
                                <label for="sel1">Faculty :</label>
                                <select name="faculty" class="form-control optionlist" id="faculty_id">
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
                                <select name="year" class="form-control optionlist" id="year_id">
                                    <option value="all">All Year</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="sel6">Date :</label>
                                <input size="16" type="text" value="" readonly class="formdmy form-control" name="date">
                            </div>

                        </div>
                        <div class="text-center padding-bott-10"> 
                                <button class="btn btn-default padding" type="submit">Search</button>
                            </div>
                    </form>
                    </div>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
        <script type="text/javascript">
            $(".formdmy").datetimepicker({format: 'dd-mm-yyyy',
                minView: 2});

        </script>
    </body>
</html>