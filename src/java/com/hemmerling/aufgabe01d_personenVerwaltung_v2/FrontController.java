/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01d_personenVerwaltung_v2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    // Sitzungsattribut
    private static final String ITEMS = "items";
    // private /* static */ final String ITEMS = getInitParameter("ITEMS");

    private static final String STARTSEITE = "index.jsp";
    private static final String ANLEGEN = "anlegen.jsp";
    private static final String AUFLISTEN = "auflisten.jsp";

    // Parameter
    private static final String VORNAME = "vorname";
    // private /* static */ final String VORNAME = getInitParameter("vorname");
    private static final String NACHNAME = "nachname";
    // private /* static */ final String NACHNAME = getInitParameter("nachname");

    private String personAnlegen(List<String[]> items, HttpServletRequest request) {
        String vorname = request.getParameter(VORNAME);
        String nachname = request.getParameter(NACHNAME);
        String sresult = STARTSEITE;
        boolean isPersonAnlegen = (vorname != null && nachname != null
                && !vorname.trim().isEmpty() && !nachname.trim().isEmpty());
        if (isPersonAnlegen) {
            items.add(new String[]{vorname, nachname});
            sresult = ANLEGEN;
        } else {
            if (vorname != null && nachname != null) {
                sresult = ANLEGEN;
            } else {
                sresult = AUFLISTEN;
            }
        }
        return sresult;
    }

    private void forward(String nextPage, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
        requestDispatcher.forward(request, response);
    }

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
        String[] parameterValues;
        boolean result;
        String nextPage = STARTSEITE;
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");

        List<String[]> items = (List<String[]>) session.getAttribute(ITEMS);

        if (items == null) {
            items = new LinkedList<String[]>();
            session.setAttribute(ITEMS, items);
        }

        nextPage = personAnlegen(items, request);

        // an View weitergeben
        forward(nextPage, request, response);

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
