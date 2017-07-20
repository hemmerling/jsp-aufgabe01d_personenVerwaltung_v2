/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01d_personenVerwaltung_v2;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class PersonService {
    
    // Sitzungsattribut
    private static final String ITEMS = "items";
    // private /* static */ final String ITEMS = getInitParameter("ITEMS");

    List<String[]> items;

    PersonService(HttpSession session){
        items = (List<String[]>) session.getAttribute(ITEMS);
        if (items == null) {
            items = new LinkedList<String[]>();
            session.setAttribute(ITEMS, items);
        } 
    }
    
    public List<String[]> getItems(){
        return items;
    }
    
    public void putItem(){
    }
}
