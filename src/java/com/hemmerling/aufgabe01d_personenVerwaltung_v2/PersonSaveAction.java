/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01d_personenVerwaltung_v2;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

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

    private String execute(List<String[]> items, HttpServletRequest request) {
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

}
