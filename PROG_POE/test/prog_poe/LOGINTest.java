/*
LOGIN Class Unit tests
 */
package prog_poe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LOGINTest {
    
    public LOGINTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkUserName method, of class login.
     */
    @Test
    public void testCheckUserName() 
    {
        System.out.println("checkUserName - kyl_1");
        String input = "kyl_1";
        LOGIN instance = new LOGIN();
        boolean expResult = true;
        boolean result = instance.checkUserName(input);
        assertEquals(expResult,result);
        //-------------------------------------------------
        System.out.println("checkUserName - kyle!!!!!!!");
        input = "kyle!!!!!!!";
        expResult = false;
        result = instance.checkUserName(input);
        assertFalse(result);
    }

    /**
     * Test of checkPasswordComplexity method, of class login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity - Ch&&sec@ke99!");
        String input = "Ch&&sec@ke99!";
        LOGIN instance = new LOGIN();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(input);
        assertEquals(expResult, result);
        //--------------------------------------------------
        System.out.println("checkPasswordComplexity - password");
        input = "password";
        expResult = false;
        result = instance.checkPasswordComplexity(input);
        assertFalse(result);
    }
  
}
