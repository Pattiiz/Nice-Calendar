package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"css/landing-stylesheet.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Prompt:300\" rel=\"stylesheet\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <title>Nice Calendar</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 if(session.getAttribute("person") != null) { 
      out.write("\n");
      out.write("        ");
      if (true) {
        _jspx_page_context.forward("main.jsp");
        return;
      }
      out.write("\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        <div class=\"site-wrapper\">\n");
      out.write("            <div class=\"site-wrapper-inner\">\n");
      out.write("                <div class=\"cover-container\">\n");
      out.write("                    <div class=\"masthead\">\n");
      out.write("                        <p><nav class=\"navbar navbarcover navbar-default\">\n");
      out.write("                            <div class=\"container-fluid\">\n");
      out.write("                                <div class=\"navbar-header\">\n");
      out.write("                                    <a class=\"navbar-brand list-detail\" id=\"list-detail\" href=\"#\">NC</a>\n");
      out.write("                                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("                                        <span class=\"icon-bar-inverse icon-bar\"></span>\n");
      out.write("                                        <span class=\"icon-bar-inverse icon-bar\"></span>\n");
      out.write("                                        <span class=\"icon-bar-inverse icon-bar\"></span> \n");
      out.write("                                    </button>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("                                    <ul class=\"nav navbar-nav\">\n");
      out.write("                                        <li class=\"active\"><a href=\"#\" id=\"activecover\">Home</a></li>\n");
      out.write("\n");
      out.write("                                    </ul>\n");
      out.write("                                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                                        <li><a href=\"#myModal\" data-toggle=\"modal\" id=\"list-detail\" data-target=\"#myModal\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </nav>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"inner\"><h1>Organize your schedule is easier than before</h1> <p>Helps you to look your class easier and easy looking with calendar view. Get you and teacher closer with joining events system. \n");
      out.write("                            Find a student free time for teacher or Find a teacher free time for student and staff (information to create classroom timetable). Poll for appointment voting.\n");
      out.write("                        </p>\n");
      out.write("                        <p><a href=\"#myModal\" data-toggle=\"modal\" data-target=\"#myModal\" class=\"btn btn-default btn-lg\">Begin</a></p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mastfoot\">\n");
      out.write("                        Information Technology Faculty, King Mongkut's Institude Technology Ladkrabang.\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Modal -->\n");
      out.write("        <div id=\"myModal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("\n");
      out.write("                <!-- Modal content-->\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h4 class=\"modal-title\">Login</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <p>Please login here.</p>\n");
      out.write("                        <form action=\"login.process\" method=\"POST\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"usr\">Name:</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"usr\" name=\"username\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"pwd\">Password:</label>\n");
      out.write("                            <input type=\"password\" class=\"form-control\" id=\"pwd\" name=\"password\">\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" class=\"btn-default btn-submit\" >Login</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
