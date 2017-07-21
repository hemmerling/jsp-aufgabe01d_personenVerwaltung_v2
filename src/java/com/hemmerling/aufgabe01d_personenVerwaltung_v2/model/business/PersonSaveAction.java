/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01d_personenVerwaltung_v2.model.business;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hemmerling.aufgabe01d_personenVerwaltung_v2.model.persistence.Person;
/**
 *
 * @author Administrator
 */
public class PersonSaveAction {

    private static final String STARTSEITE = "index.jsp";
    private static final String ANLEGEN = "anlegen.jsp";
    private static final String AUFLISTEN = "auflisten.jsp";

    // Parameter
    private static final String VORNAME = "vorname";
    // private /* static */ final String VORNAME = getInitParameter("vorname");
    private static final String NACHNAME = "nachname";
    // private /* static */ final String NACHNAME = getInitParameter("nachname");

    private Person person;
    
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String vorname = request.getParameter(VORNAME);
        String nachname = request.getParameter(NACHNAME);

    }
    
    public void set(Person person) {
        this.person = person;
    }

}
