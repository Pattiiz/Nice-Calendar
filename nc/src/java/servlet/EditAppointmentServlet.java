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
@WebServlet(name = "EditAppointmentServlet", urlPatterns = {"/editapp.process"})
public class EditAppointmentServlet extends HttpServlet {

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
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String start = request.getParameter("start");
            String end = request.getParameter("end");
            int last_id = Integer.parseInt(request.getParameter("id"));
            String[] pre_start = start.split(" ");
            String[] pre_end = end.split(" ");
            String date_start = pre_start[0].split("-")[0];
            String month_start = pre_start[0].split("-")[1];
            String year_start = pre_start[0].split("-")[2];
            String time_start = pre_start[1] + ":00";
            String date_end = pre_end[0].split("-")[0];
            String month_end = pre_end[0].split("-")[1];
            String year_end = pre_end[0].split("-")[2];
            String time_end = pre_end[1] + ":00";
            HttpSession session = request.getSession();
            String who = (String) session.getAttribute("who");
            ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection");

            String user_id = (String) session.getAttribute("user_id");
            Statement stmt = null;
            int edit_flag = 0;
            int student_flag = 0;
            String page = "";

            try {
                stmt = caldtb.createStatement();

                String sql1 = "SELECT * from manage where student_student_id='" + user_id + "' and appointment_appointment_id='" + last_id + "'";
                ResultSet rs = stmt.executeQuery(sql1);
                if (rs.next()) {
                    student_flag = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(EditAppointmentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                stmt = caldtb.createStatement();
                String sql2 = "SELECT * from appointment where appointment_id='" + last_id + "'";
                ResultSet rs2 = stmt.executeQuery(sql2);
                if (rs2.next()) {
                    if (who.equals("student")) {
                        if (student_flag == 1 && rs2.getString("appointment_type").equals("personal")) {
                            edit_flag = 1;
                        } else {
                            page = "main.jsp";
                        }
                    } else if (who.equals("teacher")) {
                        if (rs2.getString("teacher_username").equals(user_id)) {
                            edit_flag = 1;
                        } else {
                            page = "main.jsp";
                        }
                    } else if (who.equals("staff")) {
                        if (rs2.getString("officer_username").equals(user_id)) {
                            edit_flag = 1;
                        } else {
                            page = "main.jsp";
                        }
                    }
                }
                

            } catch (SQLException ex) {
                Logger.getLogger(EditAppointmentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (edit_flag == 1) {
                try {
                    stmt = caldtb.createStatement();
                    String sql2 = "UPDATE appointment SET appointment_title='" + title + "', description='" + description + "', "
                            + "appointment_date = '" + year_start + "-" + month_start + "-" + date_start + "', appointment_end_date='"
                            + year_end + "-" + month_end + "-" + date_end + "-" + "', appointment_time='" + time_start + "', appointment_end_time='"
                            + time_end + "' where appointment_id='" + last_id + "'";
                    int numrow2 = stmt.executeUpdate(sql2);
                    page = "main.jsp";
                } catch (SQLException ex) {
                    Logger.getLogger(EditAppointmentServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            response.sendRedirect(page);
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
