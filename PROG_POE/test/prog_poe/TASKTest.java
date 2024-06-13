/*
TASK Class Unit tests
 */
package prog_poe;

import org.junit.Test;
import static org.junit.Assert.*;

public class TASKTest {
    
    public TASKTest() {
    }
    
    /**
     * Test of returnTotalHours method, of class TASK.
     */
    @Test
    public void testReturnTotalHours() {
        //1)---------------
        System.out.println("1) returnTotalHours - 18");
        int numberOfTasks = 2;
        int totalHours = 0;
        int[] durations1 = {8,10};
        for (int counter = 0; counter < numberOfTasks; counter++)
        {
            totalHours = totalHours + durations1[counter];
        }
        TASK instance = new TASK();
        int expResult = 18;
        int result = instance.returnTotalHours(totalHours);
        assertEquals(expResult, result);
        //2)---------------
        System.out.println("2) returnTotalHours - 89");
        numberOfTasks = 5;
        totalHours = 0;
        int[] durations2 = {10,12,55,11,1};
        for (int counter = 0; counter < numberOfTasks; counter++)
        {
            totalHours = totalHours + durations2[counter];
        }
        expResult = 89;
        result = instance.returnTotalHours(totalHours);
        assertEquals(expResult, result);
    }

    /**
     * Test of createTaskID method, of class TASK.
     */
    @Test
    public void testCreateTaskID() {
        //1---------------
        System.out.println("1) createTaskID : AD:1:BYN");
        String taskName = "Add login Feature";
        int taskNumber = 1;
        String devDetails = "Robyn";
        TASK instance = new TASK();
        String expResult = "AD:1:BYN";
        String result = instance.createTaskID(taskName, taskNumber, devDetails);
        assertEquals(expResult, result); 
        //2---------------
         System.out.println("2) createTaskID : CR:0:IKE CR:1:ARD CR:2:THA CR:3:NDA");
        String[] taskNames = {"Create Login", "Create Add Features",
        "Create Reports", "Create Arrays"};
        int[] taskNumbers = {0,1,2,3};
        String[] developerDetails = {"Mike","Edward", 
        "Samantha", "Glenda"};
        String[] expResults = {"CR:0:IKE","CR:1:ARD","CR:2:THA","CR:3:NDA"};
        for (int counter = 0; counter < taskNumbers.length; counter++)
        {
            expResult = expResults[counter];
            result = instance.createTaskID(taskNames[counter],
            taskNumbers[counter], developerDetails[counter]);
            assertEquals(expResult, result); 
        }
    }
    
    /**
     * Test of checkTaskDescription method, of class TASK.
     */
    @Test
    public void testCheckTaskDescription() {
        //Success
        System.out.println("(Success) checkTaskDescription - Create Login to authenticate users");
        String input = "Create Login to authenticate users";
        TASK instance = new TASK();
        boolean expResult = true;
        boolean result = instance.checkTaskDescription(input);
        assertEquals(expResult, result);
        //Failure
        System.out.println("(Failure) checkTaskDescription - [string with more than 50 characters]");
        input = "ghjbhbjhbjhbjhvhjvjhjbhvhjvjhvgvghvghvghkvkgh"
        + "vjhvjhvjhvjvjgvjhvjhvhgvghvhgvgh";
        expResult = true;
        result = instance.checkTaskDescription(input);
        assertFalse(result);
    }

}
