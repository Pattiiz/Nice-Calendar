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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Appointment;

/**
 *
 * @author Plaster
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/search.process"})
public class SearchServlet extends HttpServlet {

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
            ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection");
            HttpSession session = request.getSession();
            String who = (String)session.getAttribute("who");
            String user_id = (String) session.getAttribute("user_id");
            String keyword = request.getParameter("search");
            List<Appointment> app = new ArrayList<>();
            
            if(who.equals("student")){
                try {
                    Statement stmt = caldtb.createStatement();
                    String sql = "SELECT * from manage "
                            + "join appointment on appointment_appointment_id = appointment_id"
                            + " where student_student_id='" + user_id + "' and ("
                            + "appointment_id like '%" + keyword + "%' "
                            + "or description like '%" + keyword + "%' "
                            + "or appointment_date like '%" + keyword + "%' "
                            + "or appointment_end_date like '%" + keyword + "%')";
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                    Appointment ap = new Appointment();
                    ap.setAppnt_no(rs.getString("appointment_id"));
                    ap.setTitle(rs.getString("appointment_title"));
                    ap.setDescription(rs.getString("description"));
                    ap.setAppnt_start_date(rs.getDate("appointment_date"));
                    ap.setAppnt_end_date(rs.getDate("appointment_end_date"));
                    ap.setAppnt_start_time(rs.getTime("appointment_time"));
                    ap.setAppnt_end_time(rs.getTime("appointment_end_time"));
                    ap.setAppnt_type(rs.getString("appointment_type"));
                    app.add(ap);
                }
                } catch (SQLException ex) {
                    Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }else if(who.equals("teacher")){
                try {
                    Statement stmt = caldtb.createStatement();
                    String sql2 = "Select * from appointment"
                            + " where teacher_username='" + user_id + "' and ("
                            + "appointment_id like '%" + keyword + "%' "
                            + "or description like '%" + keyword + "%' "
                            + "or appointment_date like '%" + keyword + "%' "
                            + "or appointment_end_date like '%" + keyword + "%')";
                    ResultSet rs2 = stmt.executeQuery(sql2);
                    while (rs2.next()) {
                    Appointment ap = new Appointment();
                    ap.setAppnt_no(rs2.getString("appointment_id"));
                    ap.setTitle(rs2.getString("appointment_title"));
                    ap.setDescription(rs2.getString("description"));
                    ap.setAppnt_start_date(rs2.getDate("appointment_date"));
                    ap.setAppnt_end_date(rs2.getDate("appointment_end_date"));
                    ap.setAppnt_start_time(rs2.getTime("appointment_time"));
                    ap.setAppnt_end_time(rs2.getTime("appointment_end_time"));
                    ap.setAppnt_type(rs2.getString("appointment_type"));
                    app.add(ap);
                }
                } catch (SQLException ex) {
                    Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else if(who.equals("staff")){
                try {
                    Statement stmt = caldtb.createStatement();
                    String sql3 = "Select * from appointment"
                            + " where officer_username='" + user_id + "' and ("
                            + "appointment_id like '%" + keyword + "%' "
                            + "or description like '%" + keyword + "%' "
                            + "or appointment_date like '%" + keyword + "%' "
                            + "or appointment_end_date like '%" + keyword + "%')";
                    ResultSet rs3 = stmt.executeQuery(sql3);
                    while (rs3.next()) {
                    Appointment ap = new Appointment();
                    ap.setAppnt_no(rs3.getString("appointment_id"));
                    ap.setTitle(rs3.getString("appointment_title"));
                    ap.setDescription(rs3.getString("description"));
                    ap.setAppnt_start_date(rs3.getDate("appointment_date"));
                    ap.setAppnt_end_date(rs3.getDate("appointment_end_date"));
                    ap.setAppnt_start_time(rs3.getTime("appointment_time"));
                    ap.setAppnt_end_time(rs3.getTime("appointment_end_time"));
                    ap.setAppnt_type(rs3.getString("appointment_type"));
                    app.add(ap);
                }
                } catch (SQLException ex) {
                    Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            session.setAttribute("search_r", app);
            response.sendRedirect("search.jsp");
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
