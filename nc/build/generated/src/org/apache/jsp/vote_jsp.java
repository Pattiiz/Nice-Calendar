package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class vote_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/vote-stylesheet.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Prompt:300,400,500,600,700,800,900\" rel=\"stylesheet\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <title>ESMICs | Appointment vote</title>\n");
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

            String person_who = (String) session.getAttribute("who");
        
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
      out.write("                                        <li><a href=\"#\" class=\"nav-list-detail\" >Home</a></li>\n");
      out.write("                                        <li><a href=\"search-course.html\" class=\"nav-list-detail\" >Class schedule</a></li>\n");
      out.write("                                        <li><a href=\"find-a-teacher.html\" class=\"nav-list-detail\" >Busy finder</a></li>\n");
      out.write("                                        <li class=\"active\"><a href=\"vote.html\"  class=\"activecover\">Appointment vote</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                                        <li><a href=\"profile-student.html\" class=\"nav-list-detail\" >Profile</a></li>\n");
      out.write("                                        <li><a href=\"logout.process\" class=\"nav-list-detail\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </nav>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"inner\">\n");
      out.write("                        <h1>Appointment Vote</h1>\n");
      out.write("                        <div class=\"container-fluid\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-md-12 main-col-detail\">\n");
      out.write("                                    <div class=\"menu-card\"> ");
if(person_who.equals("teacher")){ 
      out.write("\n");
      out.write("                                        <a data-toggle=\"modal\" data-target=\"#myAdd\">\n");
      out.write("                                            <div class=\"menu-card-inside\"> <span class=\"glyphicon glyphicon-plus\"></span> </div>\n");
      out.write("                                        </a> ");
}
      out.write(" </div>\n");
      out.write("                                    <div class=\"w3-panel w3-card card-main-detail\">\n");
      out.write("                                        <p> \n");
      out.write("                                            <a data-toggle=\"modal\" data-target=\"#myDetail01\" class=\"title-blue\">\n");
      out.write("                                                <div class=\"notice notice-blue\"> <strong>ชดเชย ITF</strong> ลงคะแนนเลือกวันเรียนชดเชย ITF </div>\n");
      out.write("                                            </a> <a data-toggle=\"modal\" data-target=\"#myDetail02\" class=\"title-blue\">\n");
      out.write("                                                <div class=\"notice notice-blue\"> <strong>ชดเชย PSIT</strong> ลงคะแนนเลือกวันเรียนชดเชย PSIT</div>\n");
      out.write("                                            </a> <a data-toggle=\"modal\" data-target=\"#myDetail03\" class=\"title-yellow\">\n");
      out.write("                                                <div class=\"notice notice-yellow\"> <strong>เลือกวันเรียน ICS</strong> ลงคะแนนเลือกวันที่จะเรียน ICS วันจันทร์ </div>\n");
      out.write("                                            </a>\n");
      out.write("                                        </p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mastfoot\">\n");
      out.write("                        <p></p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"myAdd\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\"> \n");
      out.write("\n");
      out.write("                <!-- Modal content-->\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h4 class=\"modal-title\">Add your Poll</h4>\n");
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
      out.write("                            <label for=\"sel1\">Faculty :</label>\n");
      out.write("                            <select class=\"form-control\" id=\"sel1\">\n");
      out.write("                                <option>Information Technology</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"sel3\">Major :</label>\n");
      out.write("                            <select class=\"form-control\" id=\"sel2\">\n");
      out.write("                                <option>All Major</option>\n");
      out.write("                                <option>Software Engineering</option>\n");
      out.write("                                <option>Network and Syste Technology</option>\n");
      out.write("                                <option>Multimedia and Game Development</option>\n");
      out.write("                                <option>Business Intelligent</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"sel4\">Course :</label>\n");
      out.write("                            <select class=\"form-control\" id=\"sel3\">\n");
      out.write("                                <option>All Course</option>\n");
      out.write("                                <option>Information Technology Fundamentals</option>\n");
      out.write("                                <option>Problem Solving In Information Technology</option>\n");
      out.write("                                <option>Introduction To Computer Systems</option>\n");
      out.write("                                <option>Computer Programming</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"sel2\">Department :</label>\n");
      out.write("                            <select class=\"form-control\" id=\"sel4\">\n");
      out.write("                                <option>Information Technology</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"sel4\">Year :</label>\n");
      out.write("                            <select class=\"form-control\" id=\"sel5\">\n");
      out.write("                                <option>All Year</option>\n");
      out.write("                                <option>1</option>\n");
      out.write("                                <option>2</option>\n");
      out.write("                                <option>3</option>\n");
      out.write("                                <option>4</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"detail\">Start</label>\n");
      out.write("                            <input size=\"16\" type=\"text\" value=\"\" readonly class=\"form_datetime\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"detail\">End</label>\n");
      out.write("                            <input size=\"16\" type=\"text\" value=\"\" readonly class=\"form_datetime\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"detail\">Poll Start</label>\n");
      out.write("                            <input size=\"16\" type=\"text\" value=\"\" readonly class=\"form_datetime\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"detail\">Poll End</label>\n");
      out.write("                            <input size=\"16\" type=\"text\" value=\"\" readonly class=\"form_datetime\">\n");
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
      out.write("                        <h4 class=\"modal-title\">ชดเชย ITF</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <p>Poll: 10 April 2017 10:00 - 13 April 2017 23:50</p>\n");
      out.write("                        <p>Date: 20 April 2017</p>\n");
      out.write("                        <p>Time: 13.30 - 15.30</p>\n");
      out.write("                        <p>ลงคะแนนเลือกวันเรียนชดเชย ITF</p>\n");
      out.write("                        <strong>Result</strong>\n");
      out.write("                        <div class=\"progress\">\n");
      out.write("                            <div class=\"progress-bar\" role=\"progressbar\" aria-valuenow=\"50\"\n");
      out.write("                                 aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:50%\"> 50% </div>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"button\" class=\"btn-default btn-submit\">Delete</button>\n");
      out.write("                        <a href=\"vote-e.html\">\n");
      out.write("                            <button type=\"button\" class=\"btn-default btn-submit\" >Edit</button>\n");
      out.write("                        </a> </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"myDetail02\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\"> \n");
      out.write("\n");
      out.write("                <!-- Modal content-->\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h4 class=\"modal-title\">ชดเชย PSIT</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <p>Poll: 10 April 2017 10:00 - 13 April 2017 23:50</p>\n");
      out.write("                        <p>Date: 20 April 2017</p>\n");
      out.write("                        <p>Time: 13.30 - 15.30</p>\n");
      out.write("                        <p>ลงคะแนนเลือกวันเรียนชดเชย PSIT</p>\n");
      out.write("                        <strong>Result</strong>\n");
      out.write("                        <div class=\"progress\">\n");
      out.write("                            <div class=\"progress-bar\" role=\"progressbar\" aria-valuenow=\"50\"\n");
      out.write("                                 aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:50%\"> 50% </div>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"button\" class=\"btn-default btn-submit\">Delete</button>\n");
      out.write("                        <a href=\"vote-e2.html\">\n");
      out.write("                            <button type=\"button\" class=\"btn-default btn-submit\" >Edit</button>\n");
      out.write("                        </a> </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"myDetail03\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\"> \n");
      out.write("\n");
      out.write("                <!-- Modal content-->\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h4 class=\"modal-title\">เลือกวันเรียน ICS</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <p>Poll: 10 April 2017 10:00 - 13 April 2017 23:50</p>\n");
      out.write("                        <p>Date: 20 April 2017</p>\n");
      out.write("                        <p>Time: 13.30 - 15.30</p>\n");
      out.write("                        <p>ลงคะแนนเลือกวันที่จะเรียน ICS วันจันทร์</p>\n");
      out.write("                        <strong>Result</strong>\n");
      out.write("                        <div class=\"progress\">\n");
      out.write("                            <div class=\"progress-bar\" role=\"progressbar\" aria-valuenow=\"50\"\n");
      out.write("                                 aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:50%\"> 50% </div>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"button\" class=\"btn-default btn-submit\">Delete</button>\n");
      out.write("                        <a href=\"vote-e3.html\">\n");
      out.write("                            <button type=\"button\" class=\"btn-default btn-submit\" >Edit</button>\n");
      out.write("                        </a> </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        $(document).ready(function () {\n");
      out.write("            var scroll_pos = 0;\n");
      out.write("            $(document).scroll(function () {\n");
      out.write("                scroll_pos = $(this).scrollTop();\n");
      out.write("                if (scroll_pos > 20) {\n");
      out.write("                    $(\".navbarcover\").css('background-color', 'rgba(104,104,104,1.0)');\n");
      out.write("                } else {\n");
      out.write("                    $(\".navbarcover\").css('background-color', 'rgba(104,104,104,0.5)');\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        $(\".form_datetime\").datetimepicker({format: 'dd-mm-yy hh:ii'});\n");
      out.write("\n");
      out.write("    </script>\n");
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
