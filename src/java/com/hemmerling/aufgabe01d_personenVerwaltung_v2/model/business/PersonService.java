/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01d_personenVerwaltung_v2.model.business;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class PersonService {
    
    // Sitzungsattribut
    private static final String LISTOFPERSONS = "listofpersons";
    
    List<String[]> listofpersons;

    public PersonService(HttpSession session){
        
        listofpersons = (List<String[]>) session.getAttribute(LISTOFPERSONS);
        if (listofpersons == null) {
            listofpersons = new LinkedList<String[]>();
            session.setAttribute(LISTOFPERSONS, listofpersons);
        } 
    }
    
    public List<String[]> getItems(){
        return listofpersons;
    }
    
    public void putItem(){
    }
}
