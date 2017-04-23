/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Staff;
import model.Student;

/**
 *
 * @author phatm
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/profile.edit"})
public class ProfileServlet extends HttpServlet {

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
            out.println("<title>Servlet ProfileServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfileServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            HttpSession session = request.getSession();
            String who = (String) session.getAttribute("who");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String email = request.getParameter("email");
            String identify;
            String key ;
            
            if (who.equals("student"))
            {
                Student student = (Student) session.getAttribute("person");
                key = student.getStudent_id();
                identify = "student_id";
                student.setFname(fname);
                student.setLname(lname);
                student.setEmail(email);
                session.setAttribute("person", student);
            }
            else
            {
                Staff staff = (Staff) session.getAttribute("person");
                key = staff.getUsername();
                identify = "username";
                staff.setFname(fname);
                staff.setLname(lname);
                staff.setEmail(email);
                session.setAttribute("person", staff);
            }
            
            try {
                ServletContext ctx = getServletContext();
                Connection caldtb = (Connection) ctx.getAttribute("connection");
                Statement stmt = caldtb.createStatement();
                String sql = "update " + who
                        + " set fname = '" + fname + "'"
                        + ", lname = '" + lname + "'"
                        + ", email = '" + email + "'"
                        + " where " + identify + " = '" + key + "'" + ";";
                int rs = stmt.executeUpdate(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            response.sendRedirect("profile.jsp");
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
