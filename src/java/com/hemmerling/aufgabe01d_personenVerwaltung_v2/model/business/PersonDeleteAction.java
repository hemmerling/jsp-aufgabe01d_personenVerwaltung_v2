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
public class PersonDeleteAction {

// Parameter
    private static final String ID = "id";

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter(ID);
        try {
            int index = Integer.parseInt(id);
            PersonService personService = PersonService.getInstance(); // Singleton
            personService.remove(index);
        } catch (NumberFormatException nfe) {
        }
    }
}
