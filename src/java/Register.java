/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import backend.FACULTY;
import backend.FACULTY_MODEL;
import backend.STUDENT;
import backend.STUDENT_MODEL;
import backend.USER;
import backend.USER_MODEL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author preet
 */
public class Register extends HttpServlet {

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
//            out.println("<title>Servlet Register</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Register at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
            getServletConfig().getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
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

        String userCode = request.getParameter("usercode");
        String name = request.getParameter("name");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        USER_MODEL um = new USER_MODEL(userName, password, userCode);

        boolean registered = USER.RegisterUser(um);
        if (registered) {
            if ("S".equals(userCode)) {
                STUDENT_MODEL sm = new STUDENT_MODEL(userName, name);
                STUDENT s = new STUDENT();
                s.SetStudentID(sm);
                boolean studentRegistered = s.SetStudent(sm);
                if (studentRegistered) {
                    response.setStatus(200);
                    processRequest(request, response);
                } else {
                    response.setStatus(404);
                    response.sendError(401, "Student Unauthorized " + sm);
                }

            } else if ("F".equals(userCode)) {
                FACULTY_MODEL fm = new FACULTY_MODEL(userName, name);
                FACULTY f = new FACULTY();
                f.SetFacultyID(fm);
                boolean facultyRegistered = f.SetFaculty(fm);
                if (facultyRegistered) {
                    response.setStatus(200);
                    processRequest(request, response);
                } else {
                    response.setStatus(404);
                    response.sendError(401, "Faculty Unauthorized " + fm);
                }
            }
        } else {
            response.setStatus(404);
            response.sendError(401, "Auth User Error " + um);
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
