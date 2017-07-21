/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01d_personenVerwaltung_v2.model.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hemmerling.aufgabe01d_personenVerwaltung_v2.model.persistence.Person;

/**
 *
 * @author Administrator
 */
public class PersonSaveAction {

    // Parameter
    private static final String VORNAME = "vorname";
    // private /* static */ final String VORNAME = getInitParameter("vorname");
    private static final String NACHNAME = "nachname";
    // private /* static */ final String NACHNAME = getInitParameter("nachname");

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String vorname = request.getParameter(VORNAME);
        String nachname = request.getParameter(NACHNAME);
        if ((vorname != null && !vorname.trim().isEmpty())
                & (nachname != null && !nachname.trim().isEmpty())) {
            Person person = new Person(vorname, nachname);
            PersonService personService = PersonService.getInstance(); // Singleton
            personService.add(person);
        }
    }
}
