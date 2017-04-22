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
import model.Student;

/**
 *
 * @author Plaster
 */
@WebServlet(name = "AppointmentServlet", urlPatterns = {"/appointment.process"})
public class AppointmentServlet extends HttpServlet {

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
            int last_id = 0;
            String user_id = (String) session.getAttribute("user_id");
            Statement stmt = null;
            int share_flag = 0;
            String faculty = null;
            String department = null;
            String branch = null;
            String year_app = null;
            String course = null;
            if (request.getParameter("faculty") != null || request.getParameter("department") != null
                    || request.getParameter("branch") != null || request.getParameter("year") != null
                    || request.getParameter("course") != null) {
                faculty = request.getParameter("faculty");
                department = request.getParameter("department");
                branch = request.getParameter("branch");
                year_app = request.getParameter("year");
                course = request.getParameter("course");
                share_flag = 1;
            }
            try {
                stmt = caldtb.createStatement();
                String sql = "SELECT * appointment_id from appointment order by appointment_id DESC limit 1";
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    last_id = Integer.parseInt(rs.getString("appointment_id")) + 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AppointmentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (who.equals("student")) {
                try {
                    String sql2 = "INSERT INTO appointment (appointment_id, appointment_title, description, "
                            + "appointment_date, appointment_end_date, appointment_time, appointment_end_time, appointment_type) VALUES ('" + last_id + "', '" + title + "', '"
                            + description + "', '" + year_start + "-" + month_start + "-" + date_start + "', '" + year_end + "-" + month_end
                            + "-" + date_end + "', " + time_start + ", " + time_end + ", 'personal')";
                    String sql3 = "INSERT INTO manage (student_student_id, appointment_appointment_id) VALUES ('" + user_id + "', '" + last_id + "')";
                    int numrow2 = stmt.executeUpdate(sql2);
                    int numrow3 = stmt.executeUpdate(sql3);
                } catch (SQLException ex) {
                    Logger.getLogger(AppointmentServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (who.equals("teacher")) {
                if (share_flag == 0) {
                    try {
                        String sql4 = "INSERT INTO appointment (appointment_id, appointment_title, description, "
                                + "appointment_date, appointment_end_date, appointment_time, appointment_end_time, appointment_type, teacher_username) VALUES ('" + last_id + "', '" + title + "', '"
                                + description + "', '" + year_start + "-" + month_start + "-" + date_start + "', '" + year_end + "-" + month_end
                                + "-" + date_end + "', " + time_start + ", " + time_end + ", 'personal', '" + user_id + "')";
                        int numrow4 = stmt.executeUpdate(sql4);
                    } catch (SQLException ex) {
                        Logger.getLogger(AppointmentServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (share_flag == 1) {
                    try {
                        String sql5 = "INSERT INTO appointment (appointment_id, appointment_title, description,\n"
                                + "appointment_date, appointment_end_date, appointment_time, appointment_end_time, appointment_type, teacher_username) VALUES ('" + last_id + "', '" + title + "', '"
                                + description + "', '" + year_start + "-" + month_start + "-" + date_start + "', '" + year_end + "-" + month_end
                                + "-" + date_end + "', " + time_start + ", " + time_end + ", 'shared', '" + user_id + "')";
                        int numrow5 = stmt.executeUpdate(sql5);
                        Student stu = new Student();
                        List<String> all_s_id = stu.getStudentId(caldtb, course);
                        for (int i = 0; i < all_s_id.size(); i++) {
                            String sql5s = "INSERT INTO manage (student_student_id, appointment_appointment_id)\n"
                                    + "VALUES ('"+ all_s_id.get(i) + "', '" + last_id + "')";
                            int numrow5s = stmt.executeUpdate(sql5s);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(AppointmentServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (who.equals("staff")) {
                if (share_flag == 0) {
                    try {
                        String sql6 = "INSERT INTO appointment (appointment_id, appointment_title, description, "
                                + "appointment_date, appointment_end_date, appointment_time, appointment_end_time, appointment_type, teacher_username) VALUES ('" + last_id + "', '" + title + "', '"
                                + description + "', '" + year_start + "-" + month_start + "-" + date_start + "', '" + year_end + "-" + month_end
                                + "-" + date_end + "', " + time_start + ", " + time_end + ", 'personal', '" + user_id + "')";
                        int numrow6 = stmt.executeUpdate(sql6);
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(AppointmentServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (share_flag == 1) {
                    try {
                        String sql7 = "INSERT INTO appointment (appointment_id, appointment_title, description, "
                                + "appointment_date, appointment_end_date, appointment_time, appointment_end_time, appointment_type, officer_username) VALUES ('" + last_id + "', '" + title + "', '"
                                + description + "', '" + year_start + "-" + month_start + "-" + date_start + "', '" + year_end + "-" + month_end
                                + "-" + date_end + "', " + time_start + ", " + time_end + ", 'shared', '" + user_id + "')";
                        int numrow7 = stmt.executeUpdate(sql7);
                        Student stu2 = new Student();
                        List<String> all_s_id = stu2.getStudentId(caldtb, course);
                        for (int i = 0; i < all_s_id.size(); i++) {
                            String sql7s = "INSERT INTO manage (student_student_id, appointment_appointment_id)\n"
                                    + "VALUES ('"+ all_s_id.get(i) + "', '" + last_id + "')";
                            int numrow7s = stmt.executeUpdate(sql7s);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(AppointmentServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            response.sendRedirect("main.jsp");

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
