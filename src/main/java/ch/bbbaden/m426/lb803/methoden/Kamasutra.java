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
public class Kamasutra implements Methoden{
    
    private final StringProperty eingabe = new SimpleStringProperty();

    private String mitteilung = "";
    
    @Override
    public String ausfuehren(Chiffriermethode methode) {
        if (methode == Chiffriermethode.Kamasutra) {
            mitteilung = "good";
            String schluessel = "T5tIi0Bb1PpW2wQq3LlXx4CcJjEeY6yGgAa7UuRrOoFfZzMmS9sVvDdNn8KkHh";

            StringBuilder chiffrat = new StringBuilder();
            String klartext = eingabe.getValue();
            for (int i = 0; i < klartext.length(); i++) {
            char buchstabe = klartext.charAt(i);
            int chiffratIndex;
            int index = schluessel.indexOf(buchstabe);
            if (index < schluessel.length() / 2) {
            chiffratIndex = index + schluessel.length() / 2;
            } else {
            chiffratIndex = index - schluessel.length() / 2;
            }
            chiffrat.append(schluessel.charAt(chiffratIndex));
            }
            eingabe.setValue(chiffrat.toString());
        }
        return mitteilung;
    }

    public String getMitteilung() {
        return mitteilung;
    }
    
    
    
}
