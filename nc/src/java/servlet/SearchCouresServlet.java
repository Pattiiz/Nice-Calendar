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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Course;

/**
 *
 * @author Plaster
 */
@WebServlet(name = "SearchCouresServlet", urlPatterns = {"/sc.process"})
public class SearchCouresServlet extends HttpServlet {

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
            int flag_search = 0;
            HttpSession session = request.getSession();
            String who = (String) session.getAttribute("who");
            ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection");
            String faculty = request.getParameter("faculty");
            String department = request.getParameter("department");
            String branch = request.getParameter("branch");
            String year_app = request.getParameter("year");
            String term = request.getParameter("term");
            String course = request.getParameter("course");

            if (course.length() < 1) {
                course = "all";
            }
            if (year_app.equals("all")) {
                year_app = "0";
            }
            if (term.equals("all")) {
                term = "0";
            }
            Course cou = new Course();
            cou.setFaculty(faculty);
            cou.setDepartment(department);
            cou.setBranch(branch);
            cou.setCourse_id(course);
            cou.setYear(Integer.parseInt(year_app));
            cou.setTerm(Integer.parseInt(term));
            List<Course> cou_li = cou.getSchedule(caldtb);
            session.removeAttribute("cou_search");
            if (cou_li.size() > 0) {
                session.setAttribute("cou_search", cou_li);
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/schedule-result.jsp");
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
