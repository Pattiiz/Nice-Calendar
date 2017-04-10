/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Plaster
 */
@WebServlet(urlPatterns = {"/login.process"})
public class LoginServ extends HttpServlet {

    @Resource(name = "dbcon")
    private DataSource dbcon;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Connection conn;

    @Override
    public void init() {

        try {
            conn = dbcon.getConnection();
        } catch (SQLException sqle) {
            System.out.println("" + sqle);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Nice Calendar | Main</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/landing-stylesheet.css\" rel=\"stylesheet\">");
            out.println("<link href=\"https://fonts.googleapis.com/css?family=Prompt:300\" rel=\"stylesheet\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<script src=\"js/jquery.js\"></script>");
            out.println("<script src=\"js/bootstrap.min.js\"></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"site-wrapper\">\n"
                    + "            <div class=\"site-wrapper-inner\">\n"
                    + "                <div class=\"cover-container\">\n"
                    + "                    <div class=\"masthead\">\n"
                    + "                        <p><nav class=\"navbar navbarcover navbar-default\">\n"
                    + "                            <div class=\"container-fluid\">\n"
                    + "                                <div class=\"navbar-header\">\n"
                    + "                                    <a class=\"navbar-brand list-detail\" id=\"list-detail\" href=\"#\">NC</a>\n"
                    + "                                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n"
                    + "                                        <span class=\"icon-bar-inverse icon-bar\"></span>\n"
                    + "                                        <span class=\"icon-bar-inverse icon-bar\"></span>\n"
                    + "                                        <span class=\"icon-bar-inverse icon-bar\"></span> \n"
                    + "                                    </button>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n"
                    + "                                    <ul class=\"nav navbar-nav\">\n"
                    + "                                        <li class=\"active\"><a href=\"#\" id=\"activecover\">Home</a></li>\n"
                    + "\n"
                    + "                                    </ul>\n"
                    + "                                    <ul class=\"nav navbar-nav navbar-right\">\n"
                    + "                                        <li><a href=\"#myModal\" data-toggle=\"modal\" id=\"list-detail\" data-target=\"#myModal\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>\n"
                    + "                                    </ul>\n"
                    + "                                </div>\n"
                    + "                            </div>\n"
                    + "                        </nav>\n"
                    + "                        </p>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"inner\"><h1>Organize your schedule is easier than before</h1> <p>Helps you to look your class easier and easy looking with calendar view. Get you and teacher closer with joining events system. \n"
                    + "                            Find a student free time for teacher or Find a teacher free time for student and staff (information to create classroom timetable). Poll for appointment voting.\n"
                    + "                        </p>\n"
                    + "                        <p><a href=\"#myModal\" data-toggle=\"modal\" data-target=\"#myModal\" class=\"btn btn-default btn-lg\">Begin</a></p>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"mastfoot\">\n"
                    + "                        Information Technology Faculty, King Mongkut's Institude Technology Ladkrabang.\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "        <!-- Modal -->\n"
                    + "        <div id=\"myModal\" class=\"modal fade\" role=\"dialog\">\n"
                    + "            <div class=\"modal-dialog\">\n"
                    + "\n"
                    + "                <!-- Modal content-->\n"
                    + "                <div class=\"modal-content\">\n"
                    + "                    <div class=\"modal-header\">\n"
                    + "                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n"
                    + "                        <h4 class=\"modal-title\">Login</h4>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"modal-body\">");
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            try {
                Statement stmt = conn.createStatement();
                String sql1 = "select * from student where student_id='" + user + "'";
                ResultSet rs = stmt.executeQuery(sql1);
                if (rs.next()) {
                    if (pass.equals(rs.getString("password"))) {

                    } else {
                        out.println("<p style=\"color: red;\">Password is incorrect</p><br>");
                        out.println("<p>Please login here.</p>\n"
                                + "                        <form action=\"login.process\" method=\"POST\">\n"
                                + "                        <div class=\"form-group\">\n"
                                + "                            <label for=\"usr\">Name:</label>");
                        out.println("<input type=\"text\" class=\"form-control\" id=\"usr\" name=\"username\" value=\"" + user + "\">");

                    }
                } else {
                    out.println("<p style=\"color: red;\">User not found</p><br>");
                    out.println("<p>Please login here.</p>\n"
                            + "                        <form action=\"login.process\" method=\"POST\">\n"
                            + "                        <div class=\"form-group\">\n"
                            + "                            <label for=\"usr\">Name:</label>");
                    out.println("<input type=\"text\" class=\"form-control\" id=\"usr\" name=\"username\">");
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginServ.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("                        </div>\n"
                    + "                        <div class=\"form-group\">\n"
                    + "                            <label for=\"pwd\">Password:</label>\n"
                    + "                            <input type=\"password\" class=\"form-control\" id=\"pwd\" name=\"password\">\n"
                    + "                        </div>\n"
                    + "                        <button type=\"submit\" class=\"btn-default btn-submit\" >Login</button>\n"
                    + "                        </form>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"modal-footer\">\n"
                    + "                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "\n"
                    + "            </div>\n"
                    + "        </div>");
            out.println("<script>\n" + "$(document).ready(function () {\n"
                    + "    $('#myModal').modal('show');\n"
                    + "});\n" + "</script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
