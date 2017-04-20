/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import model.Student;
import model.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Calendarmodel;

/**
 *
 * @author Plaster
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login.process"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection");
            Student student = new Student();
            Staff staff = new Staff();
            Calendarmodel cm = new Calendarmodel();
            Calendar date = Calendar.getInstance();
            cm.setDay(date.get(Calendar.DATE));
            cm.setMonth(date.get(Calendar.MONTH) + 1);
            cm.setYear(date.get(Calendar.YEAR));

            try {
                String send_usr = user;
                Statement stmt = caldtb.createStatement();
                String sql1 = "select * from student join branch "
                        + "on (branch_branch_name = branch_name) "
                        + "join department "
                        + "on (department_department_name = department_name) "
                        + "join faculty "
                        + "on (faculty_faculty_name = faculty_name) where student_id='" + user + "'";
                ResultSet rs = stmt.executeQuery(sql1);
                if (rs.next()) {
                    student.setStudent_id(rs.getString("student_id"));
                    student.setPassword(rs.getString("password"));
                    student.setFname(rs.getString("fname"));
                    student.setLname(rs.getString("lname"));
                    student.setEmail(rs.getString("email"));
                    student.setYear(Integer.parseInt(rs.getString("year_year")));
                    student.setBranch(rs.getString("branch_name"));
                    student.setDepartment(rs.getString("department_name"));
                    student.setFaculty(rs.getString("faculty_name"));
                    if (pass.equals(student.getPassword())) {
                        HttpSession session = request.getSession();
                        session.setMaxInactiveInterval(15 * 60);
                        session.setAttribute("person", student);
                        session.setAttribute("who", "student");
                        session.setAttribute("dsp_method", "start");
                        session.setAttribute("user_id", student.getStudent_id());
                        session.setAttribute("cm", cm);
                        response.sendRedirect("main.jsp");
                    } else {
                        response.sendRedirect("loginerror.jsp?result=wpass&user=" + send_usr);
                    }
                } else {
                    String sql2 = "select * from teacher where username='" + user + "'";
                    ResultSet rs2 = stmt.executeQuery(sql2);
                    if (rs2.next()) {
                        staff.setUsername(rs2.getString("username"));
                        staff.setPassword(rs2.getString("password"));
                        staff.setFname(rs2.getString("fname"));
                        staff.setLname(rs2.getString("lname"));
                        staff.setEmail(rs2.getString("email"));
                        if (pass.equals(staff.getPassword())) {
                            HttpSession session = request.getSession();
                            session.setMaxInactiveInterval(15 * 60);
                            session.setAttribute("person", staff);
                            session.setAttribute("who", "staff");
                            session.setAttribute("dsp_method", "start");
                            session.setAttribute("user_id", staff.getUsername());
                            session.setAttribute("cm", cm);
                            response.sendRedirect("main.jsp");

                        } else {
                            response.sendRedirect("loginerror.jsp?result=wpass&user=" + send_usr);
                        }
                    } else {

                        response.sendRedirect("loginerror.jsp?result=nouser&user=" + send_usr);
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
