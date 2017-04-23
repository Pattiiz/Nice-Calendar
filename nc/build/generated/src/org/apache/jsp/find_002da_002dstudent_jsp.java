package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.util.List;
import model.Course;

public final class find_002da_002dstudent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/search-stylesheet.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Prompt:300,400,500,600,700,800,900\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"https://www.w3schools.com/w3css/4/w3.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/datetimepicker.css\" rel=\"stylesheet\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/datetimepicker.js\"></script>\n");
      out.write("        <script src=\"js/datetimepicker.min.js\"></script>\n");
      out.write("        <title>ESMICs | Busy finder</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection"); 
      out.write("\n");
      out.write("        <div class=\"site-wrapper\">\n");
      out.write("            <div class=\"cover-container\">\n");
      out.write("                <div class=\"row-fluid padding-top-10\">\n");
      out.write("                    <nav class=\"navbar navbar-default navbarcover\">\n");
      out.write("                        <div class=\"container-fluid\">\n");
      out.write("                            <div class=\"navbar-header\"> <a class=\"navbar-brand nav-ls-color\" href=\"#\">NC</a>\n");
      out.write("                                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\"> <span class=\"icon-bar-color icon-bar\"></span> <span class=\"icon-bar-color icon-bar\"></span> <span class=\"icon-bar-color icon-bar\"></span> </button>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("                                <ul class=\"nav navbar-nav\">\n");
      out.write("                                    <li><a href=\"main.html\" class=\"nav-ls-color\">Home</a></li>\n");
      out.write("                                    <li><a href=\"search-course.html\" class=\"nav-ls-color\">Class schedule</a></li>\n");
      out.write("                                    <li class=\"active\"><a href=\"find-a-student.html\" class=\"activecover\">Busy finder</a></li>\n");
      out.write("                                    <li><a href=\"voted-result.html\" class=\"nav-ls-color\">Appointment vote</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                                <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                                    <li><a href=\"profile-teacher.html\" class=\"nav-ls-color\">Profile</a></li>\n");
      out.write("                                    <li><a class=\"nav-ls-color\" href=\"#\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("                <h1 class=\"text-center padding-top-5-p padding-bott-20\">Busy finder</h1>\n");
      out.write("                <div class=\"col-md-2\"></div>\n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                    <div class=\"w3-panel w3-card width-100-p\">\n");
      out.write("                        <div class=\"col-md-6 col-sm-6 padding-top-20\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"sel1\">Faculty :</label>\n");
      out.write("                                <select name=\"faculty\" class=\"form-control optionlist\" id=\"faculty_id\">\n");
      out.write("                                    <option>Information Technology</option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"sel2\">Major / Track :</label>\n");
      out.write("                                <select name=\"branch\" class=\"form-control\" id=\"major_id\">\n");
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
      out.write("                                <label for=\"sel3\">Course :</label>\n");
      out.write("                                <select name=\"course\" class=\"form-control optionlist\" id=\"course_id\">\n");
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
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-6 col-sm-6 padding-top-20\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"sel4\">Department :</label>\n");
      out.write("                                <select name=\"department\" class=\"form-control\" id=\"dept_id\">\n");
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
      out.write("                                <label for=\"sel5\">Year :</label>\n");
      out.write("                                <select name=\"year\" class=\"form-control optionlist\" id=\"year_id\">\n");
      out.write("                                    <option value=\"all\">All Year</option>\n");
      out.write("                                    <option value=\"1\">1</option>\n");
      out.write("                                    <option value=\"2\">2</option>\n");
      out.write("                                    <option value=\"3\">3</option>\n");
      out.write("                                    <option value=\"4\">4</option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"sel6\">Date :</label>\n");
      out.write("                                <input size=\"16\" type=\"text\" value=\"\" readonly class=\"formdmy form-control\" name=\"date\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"text-center padding-bott-10\"> <a href=\"time-schedule(yellow).html\">\n");
      out.write("                                <div class=\"btn btn-default padding\" type=\"button\">Search</div>\n");
      out.write("                            </a> </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-2\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(\".formdmy\").datetimepicker({format: 'dd-mm-yyyy',\n");
      out.write("                minView: 2});\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
