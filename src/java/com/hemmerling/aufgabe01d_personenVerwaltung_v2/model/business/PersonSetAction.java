/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01d_personenVerwaltung_v2.model.business;

import com.hemmerling.aufgabe01d_personenVerwaltung_v2.model.persistence.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rhemmerling
 */
public class PersonSetAction {
    // Parameter
    private static final String VORNAME = "vorname";
    private static final String NACHNAME = "nachname";
    private static final String ID = "id";

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String idString = request.getParameter(ID);
        String vorname = request.getParameter(VORNAME);
        String nachname = request.getParameter(NACHNAME);
        if ((idString != null) &
            (vorname != null && !vorname.trim().isEmpty())
                & (nachname != null && !nachname.trim().isEmpty())) {
            int id = Integer.valueOf(idString);
            Person person = new Person(vorname, nachname);
            PersonService personService = PersonService.getInstance(); // Singleton
            personService.set(id, person);
        }
    }
}
