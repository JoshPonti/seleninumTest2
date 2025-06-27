package seleniumTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

/**
 * This is only here to test in parallel
 */
@TestInstance(PER_CLASS)
public class assertionTest {
    /*
    @Test
    @DisplayName("Fail Assert")
    public void assertion1(){
        //intentionally incorrect
        assertEquals(1,2);
    }
    */

    @Test
    @DisplayName("Pass Assert")
    public void assertion2(){
        //intentionally correct
        assertEquals(10,10);
    }
}
