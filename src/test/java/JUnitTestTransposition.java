/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ch.bbbaden.m426.lb803.methoden.Transposition;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author colin
 */
public class JUnitTestTransposition {
    
    public JUnitTestTransposition() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
        @Test
        public void test() {
            Transposition t = new Transposition();
            assertTrue("Mitteilung gleich good", t.getMitteilung().equals("good"));
            assertEquals("false", t.getMitteilung());
        }
}
