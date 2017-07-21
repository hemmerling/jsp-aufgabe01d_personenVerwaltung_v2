/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01d_personenVerwaltung_v2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hemmerling.aufgabe01d_personenVerwaltung_v2.model.persistence.*;
import com.hemmerling.aufgabe01d_personenVerwaltung_v2.model.business.*;
/**
 *
 * @author Administrator
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    private static final String ACTION = "action";
    private static final String CREATE = "create";
    private static final String VIEW = "view";

    private static final String VORNAME = "vorname";
    private static final String NACHNAME = "nachname";

    // Sitzungsattribut
    private static final String ITEMS = "items";
    // private /* static */ final String ITEMS = getInitParameter("ITEMS");

    private static final String STARTPAGE = "index.jsp";
    private static final String CREATEPAGE = "create.jsp";
    private static final String VIEWPAGE = "view.jsp";

    private PersonService personService;
 
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
        String[] parameterValues;
        boolean result;
        String nextPage = STARTPAGE;
        response.setContentType("text/html;charset=UTF-8");
  
        HttpSession session = request.getSession();
        personService= new PersonService(session);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FrontController at " + request.getContextPath() + "</h1>");

            Enumeration paramNames = request.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();
                String paramValue = request.getParameter(paramName);
                if (paramValue != null && !paramValue.trim().isEmpty()) {
                    out.print(paramValue + "</BR>");
                }
            }
            out.println("</body>");
            out.println("</html>");

        }

        String action = request.getParameter(ACTION);
        String vorname = request.getParameter(VORNAME);
        String nachname = request.getParameter(NACHNAME);
        
        if (
                (action != null && !action.trim().isEmpty()) &
                (vorname != null && !vorname.trim().isEmpty()) &
                (nachname != null && !nachname.trim().isEmpty()) 
            ){
            switch (action) {
                case CREATE: {
                    PersonSaveAction personSaveAction = new PersonSaveAction();
                    Person person = new Person(vorname, nachname);
                    personSaveAction.set(person);
                    personSaveAction.execute(request, response);
                    nextPage = CREATE;
                    break;
                }
                case VIEW: {
                    nextPage = VIEW;
                    break;
                }
            }

        }
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
