/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Poll;
import model.Student;

/**
 *
 * @author Plaster
 */
@WebServlet(name = "VoteServlet", urlPatterns = {"/vote.process"})
public class VoteServlet extends HttpServlet {

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
            String pre_choice = request.getParameter("choice");
            String[] choice = pre_choice.split(",");
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
            String faculty = null;
            String department = null;
            String branch = null;
            String year_app = null;
            String course = null;
            List<String> choice_s = new ArrayList<>();
            ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection");
            HttpSession session = request.getSession();
            String user_id = (String)session.getAttribute("user_id");
            if (request.getParameter("faculty") != null || request.getParameter("department") != null
                    || request.getParameter("branch") != null || request.getParameter("year") != null
                    || request.getParameter("course") != null) {
                faculty = request.getParameter("faculty");
                department = request.getParameter("department");
                branch = request.getParameter("branch");
                year_app = request.getParameter("year");
                course = request.getParameter("course");
            }
            for(int i=0; i < choice.length; i++){
                choice_s.add(choice[i]);
            }
            Student stu = new Student();
            stu.setFaculty(faculty);
                        stu.setDepartment(department);
                        stu.setBranch(branch);
                        if(year_app.equals("all")){
                            stu.setYear(0);
                        }else{
                            stu.setYear(Integer.parseInt(year_app));
                        }
            List<String> all_s_id = stu.getStudentId(caldtb, course);
            Poll pol = new Poll();
            pol.setTitle(title);
            pol.setDescription(description);
            pol.setAppnt_open_date(year_start + "-" + month_start + "-" + date_start);
            pol.setAppnt_close_date(year_end + "-" + month_end + "-" + date_end);
            pol.setChoice(choice_s);
            pol.openVote(caldtb, user_id, all_s_id);
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
