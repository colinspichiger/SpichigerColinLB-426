/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ch.bbbaden.m426.lb803.methoden.Kamasutra;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author colin
 */
public class JUnitTestKamasutra {
    
    public JUnitTestKamasutra() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
        @Test
        public void test() {
            Kamasutra k = new Kamasutra();
            assertTrue("Mitteilung gleich good", k.getMitteilung().equals("good"));
            assertEquals("false", k.getMitteilung());
        }
}
