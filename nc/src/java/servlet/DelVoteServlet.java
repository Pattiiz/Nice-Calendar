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
@WebServlet(name = "DelVoteServlet", urlPatterns = {"/delvote.process"})
public class DelVoteServlet extends HttpServlet {

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
            String id = request.getParameter("id");
            HttpSession session = request.getSession();
            String user_id = (String) session.getAttribute("user_id");
            ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection");
            String id2 = (String) request.getAttribute("id");
            int del_flag = 0;
            try {
                Statement stmt = caldtb.createStatement();
                String sql1 = "select * from poll "
                        + "join teacher_poll "
                        + "on poll_id = poll_poll_id "
                        + "where poll_id =" + id;
                ResultSet rs = stmt.executeQuery(sql1);
                if (rs.next()) {
                    if (rs.getString("teacher_username").equals(id)) {
                        del_flag = 1;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(DelVoteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (id2 != null) {
                del_flag = 2;
            }
            if (del_flag == 1) {
                try {
                    Statement stmt = caldtb.createStatement();
                    String sql2 = "Delete from poll where poll_id=" + id;
                    String sql3 = "\n"
                            + "delete from poll_choice where poll_poll_id = '" + id + "'";
                    String sql4 = "\n"
                            + "Delete from student_poll where poll_poll_id = '" + id + "'";
                    String sql5 = "\n"
                            + "Delete from teacher_poll where poll_poll_id = '" + id + "'";

                    int numrow3 = stmt.executeUpdate(sql3);
                    int numrow4 = stmt.executeUpdate(sql4);
                    int numrow5 = stmt.executeUpdate(sql5);
                    int numrow2 = stmt.executeUpdate(sql2);
                } catch (SQLException ex) {
                    Logger.getLogger(DelVoteServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else if(del_flag == 2){
                try {
                    Statement stmt = caldtb.createStatement();
                    String sql4 = "\n"
                            + "Delete from student_poll where poll_poll_id = '" + id + "'";
                    int numrow4 = stmt.executeUpdate(sql4);

                } catch (SQLException ex) {
                    Logger.getLogger(DelVoteServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            response.sendRedirect("vote.jsp");
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
