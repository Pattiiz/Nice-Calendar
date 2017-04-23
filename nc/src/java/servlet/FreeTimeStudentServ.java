package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Time;

/**
 *
 * @author Plaster
 */
@WebServlet(urlPatterns = {"/ftstudent.process"})
public class FreeTimeStudentServ extends HttpServlet {

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
            String faculty = null;
            String department = null;
            String branch = null;
            String year_app = null;
            String course = null;
            String date = request.getParameter("date");
            String[] pre_date = date.split("-");
            String day = pre_date[0];
            String month = pre_date[1];
            String year = pre_date[2];
            ServletContext ctx = getServletContext();
            Connection caldtb = (Connection) ctx.getAttribute("connection");
            HttpSession session = request.getSession();
            if (request.getParameter("faculty") != null || request.getParameter("department") != null
                    || request.getParameter("branch") != null || request.getParameter("year") != null
                    || request.getParameter("course") != null) {
                faculty = request.getParameter("faculty");
                department = request.getParameter("department");
                branch = request.getParameter("branch");
                year_app = request.getParameter("year");
                course = request.getParameter("course");
            }
           Time tme = new Time();
           tme.setCourse_id(course);
           tme.setBranch(branch);
           tme.setDepartment(department);
           tme.setFaculty(faculty);
           tme.setDay(Integer.parseInt(day));
           tme.setMonth(Integer.parseInt(month));
           tme.setYear(Integer.parseInt(year));
           String result = tme.getFreeTimeStudent(caldtb);
           session.setAttribute("fts", result);
           response.sendRedirect("freetime-s.jsp");
           
    }

    }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
