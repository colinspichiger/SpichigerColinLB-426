/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.m426.lb803.methoden;

import ch.bbbaden.m426.lb803.Chiffriermethode;
import ch.bbbaden.m426.lb803.Methoden;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author colin
 */
public class Transposition implements Methoden{
    
    private final StringProperty eingabe = new SimpleStringProperty();
    private String mitteilung = "";

    @Override
    public String ausfuehren(Chiffriermethode methode) {
        if (methode == Chiffriermethode.Transposition) {
            mitteilung = "good";
            StringBuilder start = new StringBuilder();
            StringBuilder ende = new StringBuilder();
            String string = eingabe.getValue();
            for (int i = 0; i < string.length(); i++) {
                if (i % 2 == 0) {
                    start.append(string.charAt(i));
                } else {
                    try {
                        ende.append(string.charAt(i));
                    } catch (IndexOutOfBoundsException e) {
                        mitteilung = "bad";
                    }
                }

            }
            start.append(ende);
            eingabe.setValue(start.toString());
        }
        return mitteilung;
    }

    public StringProperty getEingabe() {
        return eingabe;
    }

    public String getMitteilung() {
        return mitteilung;
    }
    
    
    
    
    
}
