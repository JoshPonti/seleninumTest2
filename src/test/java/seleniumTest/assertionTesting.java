package seleniumTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class assertionTesting {

    @Test
    public void assertion1(){
        assertEquals(1,2);
    }

    @Test
    public void assertion2(){
        assertEquals(10,10);
    }
}
