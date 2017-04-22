package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.sql.Connection;
import model.Appointment;
import java.util.Arrays;
import java.util.List;
import java.util.Calendar;
import model.Calendarmodel;

public final class main_002dd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/main-stylesheet.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/w3.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/datetimepicker.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Prompt:100,200,300,400,500,600,700,800,900\" rel=\"stylesheet\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/datetimepicker.js\"></script>\n");
      out.write("        <script src=\"js/datetimepicker.min.js\"></script>\n");
      out.write("        <title>Nice Calendar | Main</title>\n");
      out.write("    </head>\n");
      out.write("\n");
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
 Calendarmodel cm = (Calendarmodel) session.getAttribute("cm");
            Calendar date = Calendar.getInstance();
            List<Appointment> appointment;
            String date_mark_check = null;
            DateFormat df = new SimpleDateFormat("HH:mm");
            DateFormat df2 = new SimpleDateFormat("yyyy-M-d");
            ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection");
            String person_who = (String) session.getAttribute("who");
            String user_id = (String) session.getAttribute("user_id");
            List<String> month_title = Arrays.asList("January", "Febuary", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December");
            List<Integer> odd_month = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
            List<Integer> even_month = Arrays.asList(4, 6, 9, 11);
      out.write("\n");
      out.write("        ");
 if (request.getParameter("jump") != null) {
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
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"site-wrapper\">\n");
      out.write("            <div class=\"site-wrapper-inner\">\n");
      out.write("                <div class=\"cover-container\">\n");
      out.write("                    <div class=\"masthead\">\n");
      out.write("                        <p>\n");
      out.write("                        <nav class=\"navbar navbarcover navbar-default\">\n");
      out.write("                            <div class=\"container-fluid\">\n");
      out.write("                                <div class=\"navbar-header\"> <a class=\"navbar-brand list-detail nav-list-detail\" href=\"#\">NC</a>\n");
      out.write("                                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\"> <span class=\"icon-bar-inverse icon-bar\"></span> <span class=\"icon-bar-inverse icon-bar\"></span> <span class=\"icon-bar-inverse icon-bar\"></span> </button>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("                                    <ul class=\"nav navbar-nav\">\n");
      out.write("                                        <li class=\"active\"><a href=\"main.html\" class=\"activecover\">Home</a></li>\n");
      out.write("                                        <li><a href=\"search-course.html\" class=\"nav-list-detail\" >Class schedule</a></li>\n");
      out.write("                                        <li><a href=\"find-a-teacher.html\" class=\"nav-list-detail\" >Busy finder</a></li>\n");
      out.write("                                        <li><a href=\"vote-student.html\" class=\"nav-list-detail\" >Appointment vote</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                                        <li><a href=\"profile-student.html\" class=\"nav-list-detail\" >Profile</a></li>\n");
      out.write("                                        <li><a href=\"logout.process\" data-toggle=\"modal\" class=\"nav-list-detail\" data-target=\"#myModal\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</a></li>\n");
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
      out.write("                                    <form>\n");
      out.write("                                        <div class=\"row input-group search-bar\">\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"Search\" />\n");
      out.write("                                            <span class=\"input-group-btn\">\n");
      out.write("                                                <button class=\"btn btn-default btn-search\" type=\"submit\"> <span class=\"glyphicon glyphicon-search\"></span> </button>\n");
      out.write("                                            </span> </div>\n");
      out.write("                                    </form>\n");
      out.write("\n");
      out.write("                                    <div class=\"row contain-main\">\n");
      out.write("                                        <div class=\"col-md-4 contain-header-left\">");
      out.print( cm.getDay());
      out.write(' ');
      out.print( month_title.get(cm.getMonth() - 1));
      out.write(' ');
      out.print( cm.getYear());
      out.write("<span class=\"contain-header-date\"> </span></div>\n");
      out.write("                                        <div class=\"col-md-4\">\n");
      out.write("                                            <ul class=\"pagination contain-header-mid\">\n");
      out.write("                                                <li><a href=\"#\" class=\"contain-header-mid-detail\" style=\"background-color:#c0c0c0;\">Day</a></li>\n");
      out.write("                                                <li><a href=\"main.jsp\" class=\"contain-header-mid-detail\">Month</a></li>\n");
      out.write("                                            </ul>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-4 contain-header-dright\">\n");
      out.write("                                            <ul class=\"pagination contain-header-right\">\n");
      out.write("                                                <li><a href=\"main-d.jsp?dsp_method=prev\" class=\"contain-header-right-detail2\"><span class=\"glyphicon glyphicon-chevron-left\"></span></a></li>\n");
      out.write("                                                <li><a href=\"main-d.jsp?dsp_method=next\" class=\"contain-header-right-detail2\"><span class=\"glyphicon glyphicon-chevron-right\"></span></a></li>\n");
      out.write("                                            </ul>\n");
      out.write("                                            <ul class=\"pagination contain-header-right\">\n");
      out.write("                                                <li><a href=\"main-d.jsp?dsp_method=today\" class=\"contain-header-right-detail\">Today</a></li>\n");
      out.write("                                                <li><a href=\"#\" class=\"contain-header-right-detail\" data-toggle=\"modal\" data-target=\"#myJump\">Go to</a></li>\n");
      out.write("                                            </ul>\n");
      out.write("                                            <ul class=\"pagination contain-header-right\">\n");
      out.write("                                                <li><a href=\"#\" class=\"contain-header-right-detail2\" data-toggle=\"modal\" data-target=\"#myAdd\"><span class=\"glyphicon glyphicon-plus\"></span></a></li>\n");
      out.write("                                            </ul>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row contain-main\" style=\"\">\n");
      out.write("                                        <div style=\"margin-top: 10px;\">");

                                            appointment = cm.getAppointment(caldtb, person_who, user_id);
                                            date_mark_check = cm.getYear() + "-" + cm.getMonth() + "-" + cm.getDay();
                                            for (int k = 0; k < appointment.size(); k++) {
      out.write("\n");
      out.write("                                            <a href=\"#\" data-toggle=\"modal\" data-target=\"#detail");
      out.print( appointment.get(k).getAppnt_no());
      out.write("\">\n");
      out.write("                                                <div class=\"");
 if (appointment.get(k).getAppnt_type().equals("personal")) { 
      out.write("\n");
      out.write("                                                     eventday eventday-blue\n");
      out.write("                                                     ");
 } else if (appointment.get(k).getAppnt_type().equals("shared")) { 
      out.write("\n");
      out.write("                                                     eventday eventday-red\n");
      out.write("                                                     ");
 } else if (appointment.get(k).getAppnt_type().equals("university")) { 
      out.write("\n");
      out.write("                                                     eventday eventday-green\n");
      out.write("                                                     ");
 } else { 
      out.write("\n");
      out.write("                                                     eventday eventday-yellow\n");
      out.write("                                                     ");
 }
      out.write(" \"><strong>");
      out.print( df.format(appointment.get(k).getAppnt_start_time()));
      out.write(" - ");
      out.print( df.format(appointment.get(k).getAppnt_end_time()));
      out.write(" </strong>\n");
      out.write("                                                    ");
if (df2.format(appointment.get(k).getAppnt_start_date()).equals(date_mark_check) && df2.format(appointment.get(k).getAppnt_end_date()).equals(date_mark_check)) {
      out.write("\n");
      out.write("                                                    ");
      out.print( appointment.get(k).getTitle());
      out.write("\n");
      out.write("                                                    ");
 }else if (df2.format(appointment.get(k).getAppnt_start_date()).equals(date_mark_check)) {
      out.write("\n");
      out.write("                                                    << EVENT START >> ");
      out.print( appointment.get(k).getTitle());
      out.write("\n");
      out.write("                                                    ");
 } else if (df2.format(appointment.get(k).getAppnt_end_date()).equals(date_mark_check)) {
      out.write("\n");
      out.write("                                                    << EVENT END >> ");
      out.print( appointment.get(k).getTitle());
      out.write("\n");
      out.write("                                                    ");
 } 
      out.write("</div>\n");
      out.write("                                            </a>\n");
      out.write("                                            ");
 }
      out.write("\n");
      out.write("                                            ");
 if(appointment.size() == 0) { 
      out.write("\n");
      out.write("                                            <p style=\"color: #000;\">No event on this day.</p>\n");
      out.write("                                            ");
 } 
      out.write("\n");
      out.write("                                            \n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
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
      out.write("        <!-- Modal -->\n");
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
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"title\">Title</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"detail\">Description</label>\n");
      out.write("                            <textarea class=\"form-control\" rows=\"3\" id=\"detail\"></textarea>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"detail\">Start</label>\n");
      out.write("                            <input size=\"16\" type=\"text\" value=\"\" readonly class=\"form_datetime\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"detail\">End</label>\n");
      out.write("                            <input size=\"16\" type=\"text\" value=\"\" readonly class=\"form_datetime\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"checkbox\">\n");
      out.write("                            <label>\n");
      out.write("                                <input type=\"checkbox\" name=\"allday\" value=\"1\">\n");
      out.write("                                All day events</label>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" class=\"btn-default btn-submit\" >Add</button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"myDetail01\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\"> \n");
      out.write("\n");
      out.write("                <!-- Modal content-->\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h4 class=\"modal-title\">ส่งงาน webpro</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <p>Date : 31 April 2017</p>\n");
      out.write("                        <p>ส่งงาน front-end webprogramming</p>\n");
      out.write("                        <button type=\"button\" class=\"btn-default btn-submit\" >Delete</button>\n");
      out.write("                        <a href=\"main-de.html\">\n");
      out.write("                            <button type=\"button\" class=\"btn-default btn-submit\" >Edit</button>\n");
      out.write("                        </a> </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Modal -->\n");
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
      out.write("                        <form action=\"main-d.jsp\" method=\"GET\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"detail\">DATE - MONTH - YEAR</label>\n");
      out.write("                                <input size=\"16\" type=\"text\" value=\"\" readonly class=\"form_dmy\" name=\"jump\">\n");
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
      out.write("            $(\".form_datetime\").datetimepicker({format: 'dd-mm-yy hh:ii'});\n");
      out.write("            $(\".form_dmy\").datetimepicker({format: 'dd-mm-yyyy',\n");
      out.write("                startView: \"month\",\n");
      out.write("                minView: \"month\"});\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
