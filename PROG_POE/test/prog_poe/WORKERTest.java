/*
WORKER Class Unit tests
*/
package prog_poe;

import org.junit.Test;
import static org.junit.Assert.*;

public class WORKERTest {
    
    WORKER testData = new WORKER();
    
    public WORKERTest() { 
    }

    //Method to populate arrays
    public void populateArraysWithTestData()
    {//Developer Names
        testData.developerArray[0] = "Mike Smith";
        testData.developerArray[1] = "Edward Harrington";
        testData.developerArray[2] = "Samantha Paulson";
        testData.developerArray[3] = "Glenda Oberholzer";
     //Task Duration
        testData.taskDurationArray[0] = 5;
        testData.taskDurationArray[1] = 8;
        testData.taskDurationArray[2] = 2;       
        testData.taskDurationArray[3] = 11;
     //Task Names
        testData.taskNamesArray[0] = "Create Login";
        testData.taskNamesArray[1] = "Create Add Features";
        testData.taskNamesArray[2] = "Create Reports";
        testData.taskNamesArray[3] = "Add Arrays";
     //Task Status
        testData.taskStatusArray[0] = 1;
        testData.taskStatusArray[1] = 3;
        testData.taskStatusArray[2] = 2;
        testData.taskStatusArray[3] = 1;
     //Task Counter
        testData.taskCounter = 4;
    }
    /**
     * Test of developer array, of class WORKER.
     */
    @Test
    public void testDeveloperArray()
    {
        System.out.println("Developer Array Test");
        //Array that is gonna store expected results
        String[] expResult =  new String[4];
        //Test Data
        //Populating expected results Array
        expResult[0] = "Mike Smith";
        expResult[1] = "Edward Harrington";
        expResult[2] = "Samantha Paulson";
        expResult[3] = "Glenda Oberholzer";
        //Test Data
        populateArraysWithTestData();
        //Compare values from arrays
        System.out.print("System returns: ");
        for(int i = 0; i < 4;i++)
        {//Variable to hold developer name from array
             String result =  testData.developerArray[i];
             assertEquals(expResult[i], result);
             
             if(expResult[i].equals(result))
             {
                 System.out.print("[" + result + "]" + " ");
             }
        }
        System.out.print("\n");
    }
    
    /**
     * Test of displayReport method, of class WORKER.
     */
    @Test
    public void testDisplayReport(){
        
        System.out.println("\nDisplay Report Test");
        //Test Data
        populateArraysWithTestData();
        testData.displayReport();
    }

    /**
     * Test of displayDevAndDurForLongestDuration method, of class WORKER.
     */
    @Test
    public void testDisplayDevAndDurForLongestDuration() {
        
        System.out.println("\nDeveloper and Duration for task with " +
        "longest duration Test");
        
        //Test Data
         populateArraysWithTestData();
        
        String result = testData.displayDevAndDurForLongestDuration();
        String expResult = "Glenda Oberholzer" + ", " + 11;
        
        assertEquals(expResult, result);
        
        if (expResult.equals(result))
        {
            System.out.println("System returns: " + result);
        }
    }

    /**
     * Test of searchTaskWithTaskName method, of class WORKER.
     */
    @Test
    public void testSearchTaskWithTaskName() {
        
        System.out.println("\nSearch for Task");
        //Test Data
        populateArraysWithTestData();
        
        String result = testData.searchTaskWithTaskName();
        String expResult = "Mike Smith" + ", " + "Create Login";
        
        assertEquals(expResult, result);
        
         if (expResult.equals(result))
        {
            System.out.println("System returns: " + result);
        }
    }
    
    /**
     * Test of tasksAssignedToDeveloper method, of class WORKER.
     */
    @Test
    public void testTasksAssignedToDeveloper() {
        
        System.out.println("\nSearch all tasks assigned to Developer");
   
        //Test Data
        populateArraysWithTestData();
        
        String result = testData.tasksAssignedToDeveloper();
        String expResult = "Create Reports";
        
        assertEquals(expResult, result);
        
        if (expResult.equals(result))
        {
            System.out.println("System returns: " + result);
        }
    }

    /**
     * Test of deleteTaskWithTaskName method, of class WORKER.
     */
    @Test
    public void testDeleteTaskWithTaskName() {
        
        System.out.println("\nDelete Task from array");
        
        //Test Data
         populateArraysWithTestData();
        
        String result = testData.deleteTaskWithTaskName();
        String expResult = "Create Reports";
        
        assertEquals(expResult, result);
        
        if (expResult.equals(result))
        {
            System.out.println("System returns: Entry " + expResult + "successfully deleted");
        }
    }
}
