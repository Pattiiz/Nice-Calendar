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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Plaster
 */
@WebServlet(name = "AddScheduleServlet", urlPatterns = {"/sca.process"})
public class AddScheduleServlet extends HttpServlet {

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
            String cou_id = request.getParameter("course_add");
            String section = request.getParameter("section");
            ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection");
            HttpSession session = request.getSession();
            String user_id = (String) session.getAttribute("user_id");
            Statement stmt;
            
            try {
                stmt = caldtb.createStatement();
                String sql1 = "select * from appointment where description like '%" + cou_id + "%' '%SECTION " + section + "%' and appointment_type = 'class'";
                ResultSet rs = stmt.executeQuery(sql1);
                while(rs.next()){
                    stmt = caldtb.createStatement();
                    String sql2 = "INSERT INTO manage (student_student_id, appointment_appointment_id) VALUES ('" + user_id + "', '" + rs.getString("appointment_id")+ "')";
                    int numrow = stmt.executeUpdate(sql2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddScheduleServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("accept", "ok");
            RequestDispatcher dispatcher = request.getRequestDispatcher("schedule-result.jsp");
            dispatcher.forward(request, response);
            
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
