/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import backend.TIME_TABLE;
import backend.TIME_TABLE_MODEL;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author preet
 */
public class SetTimeTable extends HttpServlet {

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
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SetTimeTable</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SetTimeTable at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
            getServletConfig().getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);

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
        try {
            String course = request.getParameter("courseOne");
            String faculty = request.getParameter("facultyOne");
            String block = request.getParameter("block");
            String room = request.getParameter("room");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            String day = request.getParameter("day");

            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
            long startTimems = sdf.parse(startTime).getTime();
            long endTimems = sdf.parse(endTime).getTime();
            Time st = new Time(startTimems);
            Time et = new Time(endTimems);

            TIME_TABLE_MODEL tm = new TIME_TABLE_MODEL(course, faculty, block, Integer.parseInt(room), st, et, day);

            boolean timeTableSet = TIME_TABLE.SetTimeTable(tm);

            if (timeTableSet) {
                response.setStatus(200);
                processRequest(request, response);
            } else {
                response.setStatus(404);
                response.sendRedirect(request.getContextPath() + "/");

            }
        } catch (ParseException ex) {
            Logger.getLogger(SetTimeTable.class.getName()).log(Level.SEVERE, null, ex);
        }
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
