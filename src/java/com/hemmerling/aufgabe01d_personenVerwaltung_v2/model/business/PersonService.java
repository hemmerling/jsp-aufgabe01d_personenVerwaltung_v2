/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01d_personenVerwaltung_v2.model.business;

import java.util.LinkedList;
import java.util.List;
import com.hemmerling.aufgabe01d_personenVerwaltung_v2.model.persistence.*;

/**
 *
 * @author Administrator
 */
public class PersonService {
    
    static List<String[]> persons;
    private static PersonService instance = null;

    protected PersonService(){
        // Exists only to defeat instantiation.
    }
    
    public static PersonService getInstance() {
        if ( instance == null) {
            instance = new PersonService();
        }
        return instance;
    }    
    
    public List<String[]> get(){
        if (persons == null) {
            persons = new LinkedList<String[]>();
        }
        return persons;
    }
    
    public void add(Person person){
        persons.add(new String[]{person.getVorname(), person.getNachname()});
    }
}
