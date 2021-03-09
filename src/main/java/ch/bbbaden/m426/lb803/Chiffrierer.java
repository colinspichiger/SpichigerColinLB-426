    package ch.bbbaden.m426.lb803;

import java.util.ArrayList;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Manuel Bachofner
 */
public class Chiffrierer {

    private final ArrayList<Chiffriermethode> methoden = new ArrayList<>();
    private final StringProperty eingabe = new SimpleStringProperty();
    private final StringProperty log = new ReadOnlyStringWrapper();
    private final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public void fuehreAus(Chiffriermethode methode) {

        methoden.add(methode);
        
        if (methode == Chiffriermethode.Caesar) {
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
        if (methode == Chiffriermethode.Transposition) {
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
                    }
                }

            }
            start.append(ende);
            eingabe.setValue(start.toString());
        }
        if (methode == Chiffriermethode.Kamasutra) {
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
        /*
        if (methode == Chiffriermethode.Secure) {
            String klartext = eingabe.getValue();
            StringBuilder chiffrat = new StringBuilder());   
            for(int i = 0; i<klartext.length(i++); i++){
                chiffrat.append("*");
            }
            eingabe.setValue(chiffrat.toString());

        }
         */
        doit();

    }

    public void macheRueckgaenig() {
        if (methoden.size() > 0) {
            Chiffriermethode methode = methoden.remove(methoden.size() - 1);
            switch (methode) {
                case Caesar:
                    dechiffriereCaesar();
                    break;
                case Transposition:
                    dechiffriereTransposition();
                    break;
                case Kamasutra:
                    dechiffriereTransposition();
                    break;
            }
            doit();
        }
    }

    public void leereLog() {
        methoden.clear();
        doit();
    }

    //Private Methoden -----------------------------------------------------------------
    public StringProperty getEingabe() {
        return eingabe;
    }

    /*
    * getLog
     */
    public StringProperty getLog() {
        return log;
    }

    /*
    *   Leeren der Methoden im Log
     */
    private void doit() {
        StringBuilder sb = new StringBuilder();
        for (Chiffriermethode methode : methoden) {
            sb.append(methode);
            sb.append(" ");
        }
        log.setValue(sb.toString());
    }

    private void dechiffriereCaesar() {
        String original = eingabe.getValue();
        int caesarOffset = 3;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            int index = alphabet.indexOf(original.charAt(i));
            int neuerIndex = index - caesarOffset;
            if (neuerIndex < 0) {
                neuerIndex += alphabet.length();
            }

            sb.append(alphabet.charAt(neuerIndex));
        }
        eingabe.setValue(sb.toString());
    }

    private boolean ueberpruefeChiffre() {
        for (Chiffriermethode m : methoden) {
            switch (m) {
                case Caesar:
                    return true;
                case Transposition:
                    return false;
                default:
                    return true;
            }
        }
        return false;
    }

    private void dechiffriereTransposition() {
        StringBuilder klartext = new StringBuilder();
        String original = eingabe.getValue();
        int originalLength = original.length();
        int centerIndex = original.length() / 2 + (originalLength % 2 == 0 ? 0 : 1);
        String start = original.substring(0, centerIndex);
        String end = original.substring(centerIndex);

        for (int i = 0; i < start.length(); i++) {
            klartext.append(start.charAt(i));
            klartext.append(end.charAt(i));
        }
        eingabe.setValue(klartext.toString());
    }

    private void dechiffriereKamasutra() {
        //funktioniert gleich wie beim Chiffrieren
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

}
