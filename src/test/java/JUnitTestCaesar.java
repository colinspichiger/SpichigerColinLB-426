/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ch.bbbaden.m426.lb803.Chiffriermethode;
import ch.bbbaden.m426.lb803.methoden.Caesar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author colin
 */
public class JUnitTestCaesar {
    
    public JUnitTestCaesar() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
        @Test
        public void test() {
            Caesar c = new Caesar();
            assertTrue("Mitteilung gleich good", c.getMitteilung().equals("good"));
            assertEquals("false", c.getMitteilung());
        }
}
