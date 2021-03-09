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
public class Caesar implements Methoden{
    
    private final StringProperty eingabe = new SimpleStringProperty();
    private final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private String mitteilung = "";
    
    @Override
    public String ausfuehren(Chiffriermethode methode) {
        if (methode == Chiffriermethode.Caesar) {
            mitteilung = "good";
            String original = eingabe.getValue();
            int caesarOffset = 6;
            StringBuilder chiffrat = new StringBuilder();
            for (int i = 0; i < original.length(); i++) {
                int index = alphabet.indexOf(original.charAt(i));
                int neuerIndex = (index + caesarOffset) % alphabet.length();
                chiffrat.append(alphabet.charAt(neuerIndex));
            }
            eingabe.setValue(chiffrat.toString());
        }
        return "";
    }

    public String getMitteilung() {
        return mitteilung;
    }
    
    
    
}
