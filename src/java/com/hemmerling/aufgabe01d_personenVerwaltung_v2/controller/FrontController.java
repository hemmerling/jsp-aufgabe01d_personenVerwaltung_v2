/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01d_personenVerwaltung_v2.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    private static final String DELETE = "delete";
    private static final String UPDATE = "update";
    private static final String SET = "set";

    private static final String STARTPAGE = "index.jsp";
    private static final String CREATEPAGE = "create.jsp";
    private static final String VIEWPAGE = "view.jsp";

    private static final String PERSONS = "persons";

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
        String nextPage = STARTPAGE;
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        PersonService personService = PersonService.getInstance(); // Singleton
        Object obj = session.getAttribute(PERSONS);
        List<String[]> persons = personService.get();
        session.setAttribute(PERSONS, persons);

        String action = request.getParameter(ACTION);

        if (action != null && !action.trim().isEmpty()) {
            switch (action) {
               case UPDATE: {
                    new PersonSaveAction().execute(request, response);
                    nextPage = CREATEPAGE;
                    break;
                }
               case CREATE: {
                    new PersonSaveAction().execute(request, response);
                    //nextPage = CREATEPAGE;
                    nextPage = VIEWPAGE;
                    break;
                }
                case VIEW: {
                    nextPage = VIEWPAGE;
                    break;
                }
                case DELETE: {
                    new PersonDeleteAction().execute(request, response);
                    nextPage = VIEWPAGE;
                    break;
                }
                case SET: {
                    new PersonSetAction().execute(request, response);
                    //nextPage = CREATEPAGE;
                    nextPage = VIEWPAGE;
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
