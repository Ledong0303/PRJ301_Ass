/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AttandanceDBContext;
import dal.SessionDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.Attandance;
import model.Session;
import model.Student;

/**
 *
 * @author x
 */
public class TakeAttandanceController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int sesid;
        try {
            sesid = Integer.parseInt(request.getParameter("id"));
            AttandanceDBContext attDB = new AttandanceDBContext();
            
            ArrayList<Attandance> atts = attDB.getAttsBySessionId(sesid);
           
            request.setAttribute("atts", atts);

            SessionDBContext sesDB = new SessionDBContext();
            Session ses = sesDB.get(sesid);
            request.setAttribute("ses", ses);
            request.getRequestDispatcher("view/takeattandance.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("error");
        }
//        if(DateTimeHelper.getDaystoCurrent(ses.getDate())>=2)
//            response.getWriter().println("this session is out of date");
//        else if(DateTimeHelper.getDaystoCurrent(ses.getDate())< 0)
//            response.getWriter().println("this session is not yet started");
//        else

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
        Session ses = new Session();
        ses.setId(Integer.parseInt(request.getParameter("sesid")));
        String[] stdids = request.getParameterValues("stdid");
        for (String stdid : stdids) {
            Attandance a = new Attandance();
            Student s = new Student();
            a.setStudent(s);
            a.setSession(ses);
            s.setId(Integer.parseInt(stdid));
            a.setPresent(request.getParameter("present" + stdid).equals("present"));
            a.setDescription(request.getParameter("description" + stdid));
            ses.getAttandances().add(a);
        }
        SessionDBContext db = new SessionDBContext();
        db.updateAttandance(ses);
        response.sendRedirect("takeatt?id=" + ses.getId());
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold
}
