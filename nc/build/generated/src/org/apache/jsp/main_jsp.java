package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Course;
import java.sql.Connection;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import model.Appointment;
import java.util.Calendar;
import model.Calendarmodel;
import java.util.Arrays;
import java.sql.Array;
import java.util.List;
import model.Staff;
import model.Student;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/main-stylesheet.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/w3.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/datetimepicker.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Prompt:100,200,300,400,500,600,700,800,900\" rel=\"stylesheet\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/datetimepicker.js\"></script>\n");
      out.write("        <script src=\"js/datetimepicker.min.js\"></script>\n");
      out.write("        <title>ESMICs | Main</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
if (session.getAttribute("person") == null) { 
      out.write("\n");
      out.write("        ");
      if (true) {
        _jspx_page_context.forward("index.jsp");
        return;
      }
      out.write("\n");
      out.write("        ");
 }
      out.write("\n");
      out.write("        ");
 int undate_flag = 0;
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
        
      out.write("\n");
      out.write("        ");
if (request.getParameter("dsp_method") != null) {
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
            List<String> mc = cm.getMonthcalendar();
      out.write("\n");
      out.write("        <div class=\"site-wrapper\">\n");
      out.write("            <div class=\"site-wrapper-inner\">\n");
      out.write("                <div class=\"cover-container\">\n");
      out.write("                    <div class=\"masthead\">\n");
      out.write("                        <p>\n");
      out.write("                        <nav class=\"navbar navbarcover navbar-default\">\n");
      out.write("                            <div class=\"container-fluid\">\n");
      out.write("                                <div class=\"navbar-header\"> <a class=\"navbar-brand list-detail nav-list-detail\" href=\"#\">ESMICs</a>\n");
      out.write("                                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\"> <span class=\"icon-bar-inverse icon-bar\"></span> <span class=\"icon-bar-inverse icon-bar\"></span> <span class=\"icon-bar-inverse icon-bar\"></span> </button>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("                                    <ul class=\"nav navbar-nav\">\n");
      out.write("                                        <li class=\"active\"><a href=\"main.jsp\" class=\"activecover\">Home</a></li>\n");
      out.write("                                        <li><a href=\"schedule.jsp\" class=\"nav-list-detail\" >Class schedule</a></li>\n");
      out.write("                                        ");
 if(person_who.equals("student")){ 
      out.write("\n");
      out.write("                                        <li><a href=\"find-a-teacher.html\" class=\"nav-list-detail\" >Busy finder</a></li>\n");
      out.write("                                        ");
}else{
      out.write("\n");
      out.write("                                        <li><a href=\"find-a-student.jsp\" class=\"nav-list-detail\" >Busy finder</a></li>\n");
      out.write("                                        ");
} 
      out.write("\n");
      out.write("                                        <li><a href=\"vote.jsp\" class=\"nav-list-detail\" >Appointment vote</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                                        <li><a href=\"profile.jsp\" class=\"nav-list-detail\" >Profile</a></li>\n");
      out.write("                                        <li><a href=\"logout.process\" class=\"nav-list-detail\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </nav>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"inner\">\n");
      out.write("                        <h1>Hello ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.person.fname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.person.lname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" :)</h1>\n");
      out.write("                        <div class=\"container-fluid\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-md-1\"></div>\n");
      out.write("                                <div class=\"col-md-10\">\n");
      out.write("                                    <form action=\"search.process\" method=\"GET\">\n");
      out.write("                                        <div class=\"row input-group search-bar\"> \n");
      out.write("                                            <input name=\"search\" type=\"text\" class=\"form-control\" placeholder=\"Search\" />\n");
      out.write("                                            <span class=\"input-group-btn\">\n");
      out.write("                                                <button class=\"btn btn-default btn-search\" type=\"submit\"> <span class=\"glyphicon glyphicon-search\"></span> </button>\n");
      out.write("                                            </span></div>\n");
      out.write("                                    </form>\n");
      out.write("                                    <div class=\"row contain-main\">\n");
      out.write("                                        <div class=\"col-md-4 contain-header-left\">");
      out.print( month_title.get(cm.getMonth() - 1));
      out.write(' ');
      out.print( cm.getYear());
      out.write("</div>\n");
      out.write("                                        <div class=\"col-md-4\">\n");
      out.write("                                            <ul class=\"pagination contain-header-mid\">\n");
      out.write("                                                <li><a href=\"main-d.jsp\" class=\"contain-header-mid-detail\">Day</a></li>\n");
      out.write("                                                <li><a href=\"#\" class=\"contain-header-mid-detail\" style=\"background-color:#c0c0c0;\">Month</a></li>\n");
      out.write("                                            </ul>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-4 contain-header-dright\">\n");
      out.write("                                            <ul class=\"pagination contain-header-right\">\n");
      out.write("                                                <li><a href=\"main.jsp?dsp_method=prev\" class=\"contain-header-right-detail2\"><span class=\"glyphicon glyphicon-chevron-left\"></span></a></li>\n");
      out.write("                                                <li><a href=\"main.jsp?dsp_method=next\" class=\"contain-header-right-detail2\"><span class=\"glyphicon glyphicon-chevron-right\"></span></a></li>\n");
      out.write("                                            </ul>\n");
      out.write("                                            <ul class=\"pagination contain-header-right\">\n");
      out.write("                                                <li><a href=\"main.jsp?dsp_method=today\" class=\"contain-header-right-detail\">Today</a></li>\n");
      out.write("                                                <li><a href=\"#\" class=\"contain-header-right-detail\" data-toggle=\"modal\" data-target=\"#myJump\">Go to</a></li>\n");
      out.write("                                            </ul>\n");
      out.write("                                            <ul class=\"pagination contain-header-right\">\n");
      out.write("                                                <li><a href=\"#\" class=\"contain-header-right-detail2\" data-toggle=\"modal\" data-target=\"#myAdd\"><span class=\"glyphicon glyphicon-plus\"></span></a></li>\n");
      out.write("                                            </ul>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row contain-main\">\n");
      out.write("                                        <table class=\"table contain-table\">\n");
      out.write("                                            <thead class=\"contain-table-head\">\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <td>MON</td>\n");
      out.write("                                                    <td>TUE</td>\n");
      out.write("                                                    <td>WED</td>\n");
      out.write("                                                    <td>THU</td>\n");
      out.write("                                                    <td>FRI</td>\n");
      out.write("                                                    <td>SAT</td>\n");
      out.write("                                                    <td>SUN</td>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                                            <tbody class=\"contain-table-date\">\n");
      out.write("                                                ");
 for (int i = 1; i <= 6; i++) { 
      out.write("\n");
      out.write("                                                <tr>");

                                                    for (int j = 1; j <= 7; j++) {
                                                        if (mc.get(date_count).equals("1") && undate_flag == 0) {
                                                            undate_flag = 1;
                                                            appointment_phase = 1;
                                                        } else if (mc.get(date_count).equals("1") && undate_flag == 1) {
                                                            undate_flag = 0;
                                                            appointment_phase = 2;
                                                        }
      out.write("\n");
      out.write("                                                    <td class=\"");
 if (undate_flag == 0) { 
      out.write("\n");
      out.write("                                                        contain-date-unmonth \n");
      out.write("                                                        ");
 }
                                                            if (j == 6 || j == 7) { 
      out.write("\n");
      out.write("                                                        contain-table-holiday \n");
      out.write("                                                        ");
 }
      out.write(" \"><div style=\"height: 75px; overflow: hidden;\"> \n");
      out.write("                                                            ");
 if (String.valueOf(date.get(Calendar.DATE)).equals(mc.get(date_count)) && date.get(Calendar.MONTH) + 1 == cm.getMonth() && date.get(Calendar.YEAR) == cm.getYear()) { 
      out.write("\n");
      out.write("                                                            <div class=\"contain-table-active\">\n");
      out.write("                                                                ");
 }
      out.write(' ');
      out.print( mc.get(date_count));
      out.write(" \n");
      out.write("                                                                ");
 if (String.valueOf(date.get(Calendar.DATE)).equals(mc.get(date_count)) && date.get(Calendar.MONTH) + 1 == cm.getMonth() && date.get(Calendar.YEAR) == cm.getYear()) { 
      out.write("\n");
      out.write("                                                            </div>\n");
      out.write("                                                            ");
 } 
      out.write("\n");
      out.write("                                                            ");
 Calendarmodel cm2 = new Calendarmodel();
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

                                                                for (int k = 0; k < appointment.size(); k++) {
      out.write("\n");
      out.write("                                                            <a href=\"#detail");
      out.print( appointment.get(k).getAppnt_no());
      out.write("\" data-toggle=\"modal\"\n");
      out.write("                                                               data-target=\"#detail");
      out.print( appointment.get(k).getAppnt_no());
      out.write("\">\n");
      out.write("                                                                <div class =\"");
 if (appointment.get(k).getAppnt_type().equals("personal")) { 
      out.write("\n");
      out.write("                                                                     event eventday-blue\n");
      out.write("                                                                     ");
 } else if (appointment.get(k).getAppnt_type().equals("shared")) { 
      out.write("\n");
      out.write("                                                                     event eventday-red\n");
      out.write("                                                                     ");
 } else if (appointment.get(k).getAppnt_type().equals("university")) { 
      out.write("\n");
      out.write("                                                                     event eventday-green\n");
      out.write("                                                                     ");
 } else { 
      out.write("\n");
      out.write("                                                                     event eventday-yellow\n");
      out.write("                                                                     ");
 } 
      out.write(" \" ");
 if (String.valueOf(date.get(Calendar.DATE)).equals(mc.get(date_count)) && date.get(Calendar.MONTH) + 1 == cm.getMonth() && date.get(Calendar.YEAR) == cm.getYear()) { 
      out.write("\n");
      out.write("                                                                     style=\"margin-top: 22px;\" ");
 } 
      out.write(" > ");

                                                                         if (df.format(appointment.get(k).getAppnt_start_date()).equals(date_mark_check) && df.format(appointment.get(k).getAppnt_end_date()).equals(date_mark_check)) {
      out.write("\n");
      out.write("                                                                    ");
      out.print( appointment.get(k).getTitle());
      out.write("\n");
      out.write("                                                                    ");
 } else if (df.format(appointment.get(k).getAppnt_start_date()).equals(date_mark_check)) {
      out.write("\n");
      out.write("                                                                    < START: ");
      out.print( appointment.get(k).getTitle());
      out.write("\n");
      out.write("                                                                    ");
 } else if (df.format(appointment.get(k).getAppnt_end_date()).equals(date_mark_check)) {
      out.write("\n");
      out.write("                                                                    END: ");
      out.print( appointment.get(k).getTitle());
      out.write(" >\n");
      out.write("                                                                    ");
 } 
      out.write(" </div></a>\n");
      out.write("\n");
      out.write("                                                            ");
 }
                                                            
      out.write("\n");
      out.write("                                                        </div>");
if (appointment.size() >= 3) {
      out.write("<div style=\"font-size: 10px;\"> <a href=\"main-d.jsp?jump=");
      out.print(cm2.getDay());
      out.write('-');
      out.print(cm2.getMonth());
      out.write('-');
      out.print(cm2.getYear());
      out.write("\"> more...</a></div>");
}
      out.write("</td>\n");
      out.write("                                                    ");
 date_count++;
                                                        } 
      out.write(" </tr>\n");
      out.write("                                                    ");
 }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            </tbody>\n");
      out.write("                                        </table>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-1\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mastfoot\">\n");
      out.write("\n");
      out.write("                        <p>Information Technology, King Mongkut's Institude Technology of Ladkrabang.</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--Add Modal -->\n");
      out.write("        <div id=\"myAdd\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\"> \n");
      out.write("\n");
      out.write("                <!-- Modal content-->\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h4 class=\"modal-title\">Add your events</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <p>Enter your details.</p>\n");
      out.write("                        <form action=\"appointment.process\" method=\"GET\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"title\">Title</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"title\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"detail\">Description</label>\n");
      out.write("                                <textarea name=\"description\" class=\"form-control\" rows=\"3\" id=\"detail\"></textarea>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"start_time\">Start</label>\n");
      out.write("                                <input name=\"start\" size=\"16\" type=\"text\" value=\"\" readonly class=\"form_datetime\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"end_time\">End</label>\n");
      out.write("                                <input name=\"end\" size=\"16\" type=\"text\" value=\"\" readonly class=\"form_datetime\">\n");
      out.write("                            </div>\n");
      out.write("                            ");
 if (person_who.equals("staff") || person_who.equals("teacher")) { 
      out.write("\n");
      out.write("                            <p><input type=\"checkbox\" id=\"blocked\" name=\"blocked\" /> Share events to your students</p><br>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"sel1\">Faculty :</label>\n");
      out.write("                                <select name=\"faculty\" class=\"form-control optionlist\" id=\"faculty_id\" disabled>\n");
      out.write("                                    <option>Information Technology</option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"sel4\">Department :</label>\n");
      out.write("                                <select name=\"department\" class=\"form-control\" id=\"dept_id\" disabled>\n");
      out.write("                                    <option selected value=\"all\">All Department</option>\n");
      out.write("                                    ");
 Course cou_d = new Course();
                                        List<Course> all_department = cou_d.getNameAllDepartment(caldtb);
                                        for (int i = 0; i < all_department.size(); i++) {
      out.write("\n");
      out.write("                                    <option name=\"");
      out.print( all_department.get(i).getDepartment());
      out.write('"');
      out.write('>');
      out.print( all_department.get(i).getDepartment());
      out.write("</option>\n");
      out.write("                                    ");
 }
                                    
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"sel2\">Major / Track :</label>\n");
      out.write("                                <select name=\"branch\" class=\"form-control\" id=\"major_id\" disabled>\n");
      out.write("                                    <option selected value=\"all\">All Major / Track</option>\n");
      out.write("                                    ");
 Course cou_b = new Course();
                                        List<Course> all_branch = cou_b.getNameAllBranch(caldtb);
                                        for (int i = 0; i < all_branch.size(); i++) {
      out.write("\n");
      out.write("                                    <option name=\"");
      out.print( all_branch.get(i).getBranch());
      out.write('"');
      out.write('>');
      out.print( all_branch.get(i).getBranch());
      out.write("</option>\n");
      out.write("                                    ");
 }
                                    
      out.write("\n");
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"sel5\">Year :</label>\n");
      out.write("                                <select name=\"year\" class=\"form-control optionlist\" id=\"year_id\" disabled>\n");
      out.write("                                    <option value=\"all\">All Year</option>\n");
      out.write("                                    <option value=\"1\">1</option>\n");
      out.write("                                    <option value=\"2\">2</option>\n");
      out.write("                                    <option value=\"3\">3</option>\n");
      out.write("                                    <option value=\"4\">4</option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"sel3\">Course :</label>\n");
      out.write("                                <select name=\"course\" class=\"form-control optionlist\" id=\"course_id\" disabled>\n");
      out.write("                                    <option value=\"all\">All Course</option>\n");
      out.write("                                    ");
 Course cou_s = new Course();
                                        List<Course> all_course = cou_s.getNameAllCourse(caldtb);
                                        for (int i = 0; i < all_course.size(); i++) {
      out.write("\n");
      out.write("                                    <option name=\"");
      out.print( all_course.get(i).getCourse_id());
      out.write('"');
      out.write('>');
      out.print(all_course.get(i).getCourse_name());
      out.write("</option>\n");
      out.write("                                    ");
 }
                                    
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("\n");
      out.write("                            <button type=\"submit\" class=\"btn-default btn-submit\" >Add</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--Jump Modal -->\n");
      out.write("        <div id=\"myJump\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\"> \n");
      out.write("\n");
      out.write("                <!-- Modal content-->\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h4 class=\"modal-title\">GO TO</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <p>Jump to?</p>\n");
      out.write("                        <form action=\"main.jsp\" method=\"GET\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"detail\">MONTH / YEAR</label>\n");
      out.write("                                <input size=\"16\" type=\"text\" value=\"\" readonly class=\"form_month_year\" name=\"jump\">\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"submit\" class=\"btn-default btn-submit\" >GO!</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Appointment modal -->\n");
      out.write("        ");
 appointment_phase = 0;
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
                for (int k = 0; k < appointment.size(); k++) {
      out.write("\n");
      out.write("        <div id=\"detail");
      out.print( appointment.get(k).getAppnt_no());
      out.write("\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <!-- Modal content-->\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h4 class=\"modal-title\">");
      out.print( appointment.get(k).getTitle());
      out.write("</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <p>Date: ");
if (appointment.get(k).getAppnt_start_date().equals(appointment.get(k).getAppnt_end_date())) {
      out.write("\n");
      out.write("                            ");
      out.print( df2.format(appointment.get(k).getAppnt_start_date()));
      out.write("\n");
      out.write("                            ");
 } else {
      out.write(' ');
      out.print( df2.format(appointment.get(k).getAppnt_start_date()));
      out.write(" - ");
      out.print( df2.format(appointment.get(k).getAppnt_end_date()));
      out.write(' ');
 }
      out.write("</p>\n");
      out.write("                        <p>Time: ");
      out.print( df3.format(appointment.get(k).getAppnt_start_time()));
      out.write(" - ");
      out.print( df3.format(appointment.get(k).getAppnt_end_time()));
      out.write("</p>\n");
      out.write("                        <p> ");
      out.print( appointment.get(k).getDescription());
      out.write(" </p><form action=\"delapp.process\" method=\"GET\">\n");
      out.write("                            <div style=\"height: 0px; overflow: hidden;\">\n");
      out.write("                                <input type=\"text\" name=\"id\" value=\"");
      out.print(appointment.get(k).getAppnt_no());
      out.write("\" readonly>\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"submit\" class=\"btn-default btn-submit\">Delete</button> </form>\n");
      out.write("                        <button type=\"button\" class=\"btn-default btn-submit\" ><a href=\"#\" data-toggle=\"modal\" data-target=\"#edit");
      out.print( appointment.get(k).getAppnt_no());
      out.write("\">Edit</a></button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
 }
            }

        
      out.write("\n");
      out.write("        <!-- Appointment edit modal -->\n");
      out.write("        ");
 appointment_phase = 0;
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
                for (int k = 0; k < appointment.size(); k++) {
      out.write("\n");
      out.write("        <div id=\"edit");
      out.print( appointment.get(k).getAppnt_no());
      out.write("\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <!-- Modal content-->\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h4 class=\"modal-title\">Edit your events: ");
      out.print( appointment.get(k).getTitle());
      out.write("</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <form action=\"editapp.process\" method=\"GET\">\n");
      out.write("                            <div style=\"height: 0px; overflow: hidden;\">\n");
      out.write("                                <input type=\"text\" name=\"id\" value=\"");
      out.print(appointment.get(k).getAppnt_no());
      out.write("\" readonly>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"title\">Title</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"title\" value=\"");
      out.print( appointment.get(k).getTitle());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"description\">Description</label>\n");
      out.write("                                <textarea class=\"form-control\" rows=\"3\" name=\"description\" >");
      out.print( appointment.get(k).getDescription());
      out.write("</textarea>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"start_time\">Start</label>\n");
      out.write("                                <input size=\"16\" type=\"text\" name=\"start\" value=\"");
      out.print(df2.format(appointment.get(k).getAppnt_start_date()));
      out.write(' ');
      out.print(df3.format((appointment.get(k).getAppnt_start_time())));
      out.write("\" readonly class=\"form_datetime\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"start_time\">End</label>\n");
      out.write("                                <input size=\"16\" type=\"text\" name=\"end\" value=\"");
      out.print(df2.format(appointment.get(k).getAppnt_end_date()));
      out.write(' ');
      out.print(df3.format((appointment.get(k).getAppnt_end_time())));
      out.write("\" readonly class=\"form_datetime\">\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"submit\" class=\"btn-default btn-submit\">Apply</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
 }
            }

        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                var scroll_pos = 0;\n");
      out.write("                $(document).scroll(function () {\n");
      out.write("                    scroll_pos = $(this).scrollTop();\n");
      out.write("                    if (scroll_pos > 20) {\n");
      out.write("                        $(\".navbarcover\").css('background-color', 'rgba(104,104,104,1.0)');\n");
      out.write("                    } else {\n");
      out.write("                        $(\".navbarcover\").css('background-color', 'rgba(104,104,104,0.5)');\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            $(\".form_datetime\").datetimepicker({format: 'dd-mm-yyyy hh:ii'});\n");
      out.write("            $(\".form_month_year\").datetimepicker({format: 'mm-yyyy',\n");
      out.write("                startView: \"year\",\n");
      out.write("                minView: \"year\"});\n");
      out.write("            $('#blocked').change(function () {\n");
      out.write("                $(\"#faculty_id\").prop(\"disabled\", !$(this).is(':checked'));\n");
      out.write("                $(\"#dept_id\").prop(\"disabled\", !$(this).is(':checked'));\n");
      out.write("                $(\"#major_id\").prop(\"disabled\", !$(this).is(':checked'));\n");
      out.write("                $(\"#course_id\").prop(\"disabled\", !$(this).is(':checked'));\n");
      out.write("                $(\"#year_id\").prop(\"disabled\", !$(this).is(':checked'));\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
