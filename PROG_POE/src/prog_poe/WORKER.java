//NOTE
//What to Do
//Code Working Well
//Optimize the code
//=============================READ ABOVE NOTE==================================
package prog_poe;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class WORKER {
    
    //Variable Declarations
    static int numberOfUsers = 0;//Keeps track of registered users
    private int loggedUser = 0;//Record logged User
    int keepTrackOfTasks = 0;//Keep Track Of Tasks to Display in KanBan Menu
    int taskCounter = 0;//When asking for task details indicate correct task numbering and keep track of tasks
    int totalHours = 0;//Keep track of hours
    final static int MAXIMUN_USERS = 5;//Maximun amount of Users allowed to register
    final static int MAXIMUN_TASKS = 10;//Maximun amount of Tasks
    //Arrays for TASK 3
    String[] developerArray = new String[MAXIMUN_TASKS];
    String[] taskNamesArray = new String[MAXIMUN_TASKS];
    String[] taskIDArray = new String[MAXIMUN_TASKS];
    int[] taskDurationArray = new int[MAXIMUN_TASKS];
    int[] taskStatusArray = new int[MAXIMUN_TASKS];
    //--------------end of arrays for TASK 3
    //Array to store each task
    TASK task[] = new TASK[20];
    //Method that prints Login Menu for user to select an option
    public int printLoginMenu()
    {
        //Variable Declarations
        String loginInput;    //Input choosed by user
        int option = 0;       //Store user option selection
        boolean value = false;//Loop control variable
        
        //While Value is false Loop until value is true
        while(!value)
        {
            loginInput = JOptionPane.showInputDialog(null, "Please make a Selection\n" 
                        + "\t1) Register a User\n" 
                        + "\t2) Login a User\n"
                        + "\t3) Quit\n"
                        + "Registered users : " + numberOfUsers,
                        "LOGIN DIALOG",JOptionPane.QUESTION_MESSAGE);
        
            if (loginInput.isEmpty())
            {//If user doesnt select nothing make value false and keep loop running
                value = false;
            }
            else
            {//If login Input not empthy convert String data into Int
                option = Integer.parseInt(loginInput);
            }
            
            if ((option < 1) || (option > 3))
            {//If option is not between 0 and 4 show error message
                JOptionPane.showMessageDialog(null,"Please select options from 1 to 3"
                ,"Error",JOptionPane.ERROR_MESSAGE);
            } 
            else
            {
                value = true;
            }
        } 
    return option;//return user selected option from this method
    }
    //--------------------------------------------------------------end
    //=================================================================
    //This method registers and evaluates user registration information 
    public void registerUser(LOGIN[] user)
    {   
        //Variable Declarations
        String userInput = "";
        boolean value = false;//Initialse to false
        LOGIN users = new LOGIN();//To call methods from class Login
        //Scanner input = new Scanner(System.in);//No longer needed
        
        //USERNAME-------------------------------------------------
        //While boolean variable Valid is not true continue to Loop
        do
        {
            //Enter Username with all parameters respected
            userInput = JOptionPane.showInputDialog(null,"Enter wanted Username\n(must contain 5 max "
            + "characters and UNDERSCORE)","Register User",JOptionPane.QUESTION_MESSAGE);
            
            /*Code Modified for JOption
            System.out.println("\nREGISTER USER\n-------------");
            System.out.print("\nEnter wanted Username\n(must contain 5 max "
            + "characters and UNDERSCORE) \nEnter Username: ");
            userInput = input.next();//Store Input in Variable
            */
            //Use method from Class Login to check if Username is Valid
                if (users.checkUserName(userInput))
                {//Set variable Valid to true in case userName correctly formated
                    value = true;
                }
                else
                {//Inform user if Username is not correctly formated
                    JOptionPane.showMessageDialog(null,"Username is not " +
                    "correctly formatted, " +
                    "please ensure that " +
                    "your username " +
                    "contains an " +
                    "underscore and is no " +
                    "more than 5 " +
                    "characters in length.","Invalid Username",JOptionPane.INFORMATION_MESSAGE);
                }
        }while(!value);//end loop when Valid is true
        
        value = false;//Initialise Valid to false 
        users.setUserName(userInput);//Store Username in object
        //Confirm to user that Username is correctly formatted
        JOptionPane.showMessageDialog(null,"Username sucessfully "
        + "captured","Username Valid",JOptionPane.INFORMATION_MESSAGE);
        
        //PASSWORD----------------------------------------------------
        //While boolean variable Valid is not true continue to Loop
        do
        {   //Enter password with all parameters respected 
            userInput = JOptionPane.showInputDialog(null,"Enter wanted Password\n(must "
            + "contain 8 characters minimun,"
            + "at least one capital letter, a number "
            + "\nand at least one special character)","Register User",JOptionPane.INFORMATION_MESSAGE);
            
            /*Code Modified for JOption
            System.out.print("\nEnter wanted Password\n(must contain 8 characters minimun,"
            + "at least one capital letter, a number \nand at least one special character)\n"
            + "Enter Password: ");      
            userInput = input.next();//Store Input in Variable
            */
            //Use method from Class Login to check if password is Valid
            if (users.checkPasswordComplexity(userInput))
            {//Set variable Valid to true in case password is correctly formated
                value = true;
            }
            else
            {//Inform user if password is not correctly formated
                JOptionPane.showMessageDialog(null,"Password is not " +
                "correctly formatted, " +
                "please ensure that " +
                "the password " +
                "contains at least 8 " +
                "characters, a capital " +
                "letter, a digit and " +
                "a special character.","Password Invalid",JOptionPane.ERROR_MESSAGE);
            }
        }while(!value);//end loop when Valid is true
        
        users.setPassword(userInput);//Store password in object
        //Confirm to user that password is correctly formatted
        JOptionPane.showMessageDialog(null,"Password sucessfully "
        + "captured\n","Password Valid",JOptionPane.INFORMATION_MESSAGE);
        
        //Ask for those inputs when Username and Password are correctly formatted
        userInput = JOptionPane.showInputDialog(null,"Enter Firstname",
        "Register User",JOptionPane.QUESTION_MESSAGE);
        users.setName(userInput);//Store FirstName in Object
        
        /*Code Modified for JOption
        System.out.print("\nEnter Firstname: ");
        userInput = input.next();//Store Input in Variable
        */
        
        userInput = JOptionPane.showInputDialog(null,"Enter Surname",
        "Register User",JOptionPane.QUESTION_MESSAGE);
        users.setSurname(userInput);//Store Surname in Object
        
        /*Code Modified for JOption
        System.out.print("Enter Surname: ");
        userInput = input.next();//Store Input in Variable
        */
        
        user[numberOfUsers] = users;//Store number of candidates and information in array
        numberOfUsers++;
        //Inform user that the registration was successfull
        JOptionPane.showMessageDialog(null,"The two above conditions "
                + "have been met and the user "
                + "has been registered successfully",
                "Registration Sucessfull",JOptionPane.INFORMATION_MESSAGE);
    }
    //---------------------------------------------------------------end
    //==================================================================
    /*This method verifies if the login details entered matches 
    the login details stored when the user registers in registerUser method. 
    */
    public boolean loginUser(LOGIN[] users)
    {
        //Variable Declarations
        boolean value = false;//Initialise to false
        String username, password;
        //Scanner input = new Scanner(System.in);//No longer needed
        
        //Ask user for login details
        username = JOptionPane.showInputDialog(null,"Please enter Username",
        "Login User",JOptionPane.QUESTION_MESSAGE);
        
        /*Code Modified for JOption
        System.out.println("\nLOGIN USER\n-------------");
        System.out.print("\nPlease enter Username: ");
        username = input.next();
        */
        
        password = JOptionPane.showInputDialog(null,"Please enter Password",
        "Login User",JOptionPane.QUESTION_MESSAGE);
        
        /*Code Modified for JOption
        System.out.print("Please enter Password: ");
        password = input.next();
        */
        
        //Check if details inserted match details stored in Array
        //Loop fo the amount of registered users
        for (int counter = 0; counter < numberOfUsers; counter++)
        {//Checking if username inserted matches current user in array based on the loop
            if (users[counter].getUserName().equals(username))
            {//Checking if password inserted matches current user in array based on the loop
                users[counter].getUserName();
                if (users[counter].getPassword().equals(password))
                {//Set Variable valid to true if all conditions are True
                    users[counter].getPassword();
                    value = true;
                    loggedUser = counter;//Record logged User
                    break;//Exit if statement
                }
            }
        }   //Inform User if Login was succesfull or not
            if(value)
            {   
                returnLoginStatus(value, users);
            }
            else
            {   
                returnLoginStatus(value, users);
            }
    return value;
    }
    //-------------------------------------------------------------end
    //================================================================
    //This method returns message for sucessfull Login or failed Login
    public void  returnLoginStatus(boolean value, LOGIN[] users)
    {
        //If Login is successfull
        if (value)
            {
                JOptionPane.showMessageDialog(null, 
                    "Welcome " + users[loggedUser].getName() + 
                    " " + users[loggedUser].getSurname() +
                    ", it is great to see you again.",
                    "Login Success",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        //If Login is not Successful
        else
            {
                JOptionPane.showMessageDialog(null, "Username or \n" +
                    "password incorrect, \n" +
                    "please try again", 
                    "Login Failed",JOptionPane.ERROR_MESSAGE);
            }
    }
    //------------------------------------------------------------end
    //===============================================================
    //=                            TASK 2 CODE                      =
    //===============================================================
    //This method presents a menu with options for the user to select
    public void KanBanMenu()
    {
        //Variable Declarations
        String userInput = "";    //Input choosed by user
        int option = 0;       //Store user option selection
        boolean value = false;//Loop control variable
        TASK user = new TASK();
        
        //While Value is false Loop until value is true
        while(!value)
        {//Display menu to user, ask user to select, store option selected 
         //Added more options to menu for TASK 3
        userInput = JOptionPane.showInputDialog(null, "Please make a Selection\n"
                        + "Number of Tasks: " + keepTrackOfTasks + "\n"
                        + "\tOption 1) Add Tasks\n" 
                        + "\tOption 2) Show Report\n"
                        + "\tOption 3) Finished Tasks\n"
                        + "\tOption 4) Longest Task\n"
                        + "\tOption 5) Search Task\n"
                        + "\tOption 6) Search Developer Tasks\n"
                        + "\tOption 7) Delete Task\n"
                        + "\tOption 8) Quit",
                        "Welcome to EasyKanban",JOptionPane.QUESTION_MESSAGE);
                        
            if (userInput.isEmpty() || userInput == null)
            {//If user doesnt select nothing make value false and keep loop running
                value = false;
            }
            else
            {//If login Input not empthy convert String data into Int
                option = Integer.parseInt(userInput);
            }
            
            if (option == 1)
            {//Call method for option 1
                addKanBanTasks();
                option = 0;//Initializing variable
                //Inform user when the capture is finalized 
                JOptionPane.showMessageDialog(null,
                "Completed Task Capture",
                "Congratulations", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (option == 2)
            {
                displayReport();
        
                //Task 2 Code no more needed------------------------------------
         /*     // Inform user that feature is still in development
                JOptionPane.showMessageDialog(null,"coming soon"
                ,"Request Completed",JOptionPane.INFORMATION_MESSAGE);
                option = 0;//Initializing variable */
                //--------------------------------------------------------------
            }
            else if (option == 3)
            {
                displayDevTaskDurForStatusDone();    
            }
            else if (option == 4)
            {
                displayDevAndDurForLongestDuration();     
            }
            else if (option == 5)
            {   
                searchTaskWithTaskName();
            }
            else if (option == 6)
            {   
                tasksAssignedToDeveloper();
            }
            else if (option == 7)
            {
                deleteTaskWithTaskName();
            }
            else if ((option < 1) || (option > 8))//Changed 3 to 8
            {//If option is not 1 to 8 show error message
                    JOptionPane.showMessageDialog(null,"Please select options from 1 to 3"
                    ,"Error",JOptionPane.ERROR_MESSAGE);
            } 
            else
            {//Return true if user selected one of the valid options in menu
                value = true;
            }
        }   
    }
    //------------------------------------------------------------end
    //===============================================================
    //Method that asks and captures number of tasks from user
    public void addKanBanTasks()
    {
        //Variable Declarations
        String userInput; //Store user inputs
        int numberOfTasks = 0;//Store number of tasks
        //int totalHours = 0; Changed to global variable
        int hours = 0;
        TASK user = new TASK();
        //Scanner input = new Scanner(System.in);//No longer needed
        
        //Ask user for the number of tasks
        userInput = JOptionPane.showInputDialog(null,
            "Please enter the number of Tasks to add",
            "Add Tasks", JOptionPane.QUESTION_MESSAGE);
        
        if (userInput.isEmpty() || userInput == null)
        {//In case user doesnt type nothing display error message and return to menu
            JOptionPane.showMessageDialog(null,
            "Invalid value detected, application will return to menu",
            "Error detected", JOptionPane.ERROR_MESSAGE);
            
            return;
        }
        //Convert String to Integer and store userInput in int Variable
        numberOfTasks = Integer.parseInt(userInput);
        //Store amount of Tasks to present at Menu
        keepTrackOfTasks = keepTrackOfTasks + numberOfTasks;
        //Heading that displays number of Tasks
        JOptionPane.showMessageDialog(null,"Fill in Task details" 
        ,"Number of Tasks to add: " + numberOfTasks,JOptionPane.QUESTION_MESSAGE);
        
        /*Code Modified for JOption 
        System.out.println("\n\nNumber of Tasks: " + numberOfTasks);
        */
        
        //Loop Form for task inputs depending on the No of Tasks selected
        for (int counter = 0; counter < numberOfTasks; counter++)
        {//Call method to in each loop to add Tasks information
            //Store correct Task Number for Form
            taskCounter = taskCounter + 1;
            hours = addTask(taskCounter);
            //Sum total Hours         
            totalHours = totalHours + hours;
        } 
        //Inform user about combined total Hours of Tasks
            JOptionPane.showMessageDialog(null,
            "The combined hours for all Tasks is: " 
            + user.returnTotalHours(totalHours) + " hours",
            "Total Hours", JOptionPane.INFORMATION_MESSAGE); 
    }
    //-----------------------------------------------------------end
    //==============================================================
    //Method that asks user for inputs related to tasks
    public int addTask(int counter)
    {
        //Variable Declarations
        String taskName = "";
        int taskNumber = taskCounter;
        String taskDescription = "";
        String developerDetails = "";
        int taskStatus = 0;
        String taskID = "";
        int taskDuration = 0;
        boolean valid = false;
        //Object from Task class
        TASK user = new TASK();
        //Scanner input = new Scanner(System.in);//No longer needed
        
        /*Code Modified for JOption
        System.out.println("----- Task " + (counter + 1) + " -----");
        */
        
        //Ask user for inputs
        //TASK NAME          //Task Counter Will Display correct Task Number each time
        taskName = JOptionPane.showInputDialog(null,"Task Name","Task " + (taskCounter)
        ,JOptionPane.QUESTION_MESSAGE);
        
        /*Code Modified for JOption
        System.out.println("Task Name: ");
        taskName = input.nextLine();
        */
        
        //In case user types task description less than 50 characters
        //TASK DESCRIPTION
        do
        {   
            taskDescription = JOptionPane.showInputDialog(null,"Task Description",
            "Task " + (taskCounter),JOptionPane.QUESTION_MESSAGE);
            
            /*Code Modified for JOption
            System.out.print("Task Description: ");
            taskDescription = input.nextLine();
            */
            
            //Method from Task Class to if task description is less than 50 char
            if (!user.checkTaskDescription(taskDescription))
            {//If it is more than 50 char print error message to user
                JOptionPane.showMessageDialog(null,
                "Please enter a task description of less than 50 characters",
                "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else 
            {//Return true if task description is less than 50 chars
                valid = true;
            }
        }while(!valid);
        //----------------end of do while
        //DEVELOPER DETAILS
        developerDetails = JOptionPane.showInputDialog(null,"Developer Details",
        "Task " + (taskCounter),JOptionPane.QUESTION_MESSAGE);
        
        /*Code Modified for JOption
        System.out.println("Developer Details: ");
        developerDetails = input.nextLine();
        */
        
        //TASK DURATION
                    //Convert String input to Int
        taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null,"Task Duration",
        "Task " + (taskCounter),JOptionPane.QUESTION_MESSAGE));
        
        /*Code Modified to JOption
        System.out.println("Task Duration: ");
        taskDuration = input.nextInt();
        */
        
        //TASK STATUS
                  
        /*Code Modified for JOption
        System.out.println("Select an option for Task Status\n1) To Do\n2) Done\n3) Doing");
        */
        
        valid = false;//Initializing variable to false 
        //Loop until user inputs value from 1 to 3
        do
        {
        //Ask User Input//Convert String input to Int 
        taskStatus = Integer.parseInt(JOptionPane.showInputDialog(null,"Select an option for Task "
        + "Status\n1) To Do\n2) Done\n3) Doing",
        "Task " + (taskCounter),JOptionPane.QUESTION_MESSAGE));
        
            /*Code Modified for JOption
            System.out.println("Choice: ");
            taskStatus = input.nextInt();//Get user Input
            */
            
            if ((taskStatus < 1) || (taskStatus > 3))
            {//Inform user that input is not valid
                JOptionPane.showMessageDialog(null,
                "You can only choose an option from 1 to 3",
                "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else
            {//Return true if user Input is from 1 to 3
                valid = true;
            }
        }while(!valid);
        //---------------end of do while
        //Call method to generate TaskID from TASK Class
        taskID = user.createTaskID(taskName, taskNumber, developerDetails);
        //Store variables in object
        user.setTaskNumber(taskNumber);
        user.setTaskName(taskName);
        user.setTaskDescription(taskDescription);
        user.setDeveloperDetails(developerDetails);
        user.setTaskDuration(taskDuration);
        user.setTaskStatus(taskStatus);
        user.setTaskID(taskID);
        //store Task in array
        task[taskNumber] = user;
        //Show to user all details about the Task
        //Calling Print Task Details Method from TASK Class
        JOptionPane.showMessageDialog(null,user.printTaskDetails()
        ,"Request Completed",JOptionPane.INFORMATION_MESSAGE);
     //===============================================================
     //=                            TASK 3 CODE                      =
     //===============================================================
        //     -1 is used to to store first array element in position 0 in arrays
        this.developerArray[taskCounter - 1] = developerDetails; //store developer name in array
        this.taskNamesArray[taskCounter - 1] = taskName; //store task name in array
        this.taskIDArray[taskCounter - 1] = taskID; //store task ID in array
        this.taskDurationArray[taskCounter - 1] = taskDuration; //store task duration in array
        this.taskStatusArray[taskCounter - 1] = taskStatus; //store task status in array
        //Return Hours 
        return taskDuration;
    }
    //-----------------------------------------------------------end
    //==============================================================
    //Method to convert Status int input choice to String and return the String
    public String convertStatusToString(int status)
    {
        //Variable declaration
        String storeStatus = "";
        //Set int value of taskStatus to String from options menu
        if (status == 1)
        {
            storeStatus = "To do";
        }
        else if (status == 2)
        {
            storeStatus = "Done";
        }
        else
        {
            storeStatus = "Doing";
        }
        
        return storeStatus; 
    }        
    //-----------------------------------------------------------end
    //==============================================================
    //Method that will display full details of all tasks captured
    //OPTION 2
    public String displayReport()
    {
        //Variable Declarations
        String taskDetails = "";
        String report = "";//First Solution
        //Loop for the amount of tasks
        for (int counter = 0; counter < this.taskCounter; counter++)
        {//Set taskDetails equal to each task details
            taskDetails = "\n\nDeveloper Name: " + this.developerArray[counter]
                   + "\nTask Name: " + this.taskNamesArray[counter]
                   + "\nTask ID: " + this.taskIDArray[counter]
                   + "\nTask Duration: " + this.taskDurationArray[counter]
                   + "\nTask Status: " + convertStatusToString(this.taskStatusArray[counter]);
            //Add each task to variable to be stored
            report = report + taskDetails;//First Solution
        }
        //Display report to user
        JOptionPane.showMessageDialog(null,report,"Report",JOptionPane.INFORMATION_MESSAGE);
        //For unit test
        return report;
    }
    //-----------------------------------------------------------end
    //==============================================================
    //Method to display Developer Name, Task Name and Duration for -DONE- Status
    //OPTION 3
    public void displayDevTaskDurForStatusDone()
    {
       //Variable Declarations
       int counter = 0;
       //Go over array based on number of places
       while (counter < this.taskCounter)
       {//if array status is done get details based on the counter number on other arrays
           if (this.taskStatusArray[counter] == 2)              
           {//Display String that includes DevName,TaskName and Task Duration
               JOptionPane.showMessageDialog(null,"Developer Name: " 
               + this.developerArray[counter] 
               + "\nTask Name: " 
               + this.taskNamesArray[counter] + "\nTask Duration: " 
               + this.taskDurationArray[counter] + "h","Tasks Done",JOptionPane.INFORMATION_MESSAGE);
           }
           counter++;//sum 1 each time it loops
       }
    }
    //-----------------------------------------------------------end
    //==============================================================
    
    //Method to display Developer with the longest Task
    //OPTION 4
    public String displayDevAndDurForLongestDuration()
    {
       //Variable Declarations
       int tempVariable = 0;//Store temporary biggest value from duration array
       int countTemp = 0;//Temporary store position from array with biggest duration 
       //Go over array based on number of places
       for (int counter = 0; counter < this.developerArray.length; counter++)
       {
           //if temporary variable bigger store value
           if (tempVariable > this.taskDurationArray[counter])
           {
               tempVariable = tempVariable;//if temporary variable is bigger keep same value   
           }
           //if temporary variable smaller store value of array place
           else
           {
               tempVariable = this.taskDurationArray[counter];
               countTemp = counter;//get value from a array position with biggest value
           }
       }    
       //Display String to user
       JOptionPane.showMessageDialog(null,"Developer Name: " + this.developerArray[countTemp]
       + "\nDuration: " + this.taskDurationArray[countTemp] + "h",
       "Task with longest duration",JOptionPane.INFORMATION_MESSAGE);
       
       return this.developerArray[countTemp] + ", " + this.taskDurationArray[countTemp];
    }
    //-----------------------------------------------------------end
    //==============================================================
    //Method to search a Task with Task Name as input and Display Task Information once task is found
    //OPTION 5
    public String searchTaskWithTaskName()
    { 
        //Variable Declaration
        String taskName = "";
        //Ask Input from user
        taskName = JOptionPane.showInputDialog(null,
                            "Give Task Name",
                            "Search Task", JOptionPane.QUESTION_MESSAGE);
        //Loop elements of Array
        for (int counter = 0; counter < this.taskNamesArray.length; counter++)
        {//Check which element of array is equal to Input
            if (taskName.equals(this.taskNamesArray[counter]))
            {//Display Task Details of element equal to array
                 JOptionPane.showMessageDialog(null,"Task Name: " 
                + this.taskNamesArray[counter] + "\nDeveloper Name: " 
                + this.developerArray[counter] + "\nTask Status: " 
                + convertStatusToString(this.taskStatusArray[counter]) 
                ,"Task found",JOptionPane.INFORMATION_MESSAGE);
                //for unit test
                return this.developerArray[counter] + ", " 
                + this.taskNamesArray[counter] ;//leave once task was found and displayed
            }
        }//In case Task is not found inform user
                 JOptionPane.showMessageDialog(null,"Please try again"
                ,"Task not found",JOptionPane.INFORMATION_MESSAGE); 
                 
        return "";
    }
    //-----------------------------------------------------------end
    //==============================================================
    //Method to search for all Tasks assigned to a developer and display the Task Name and Status
    //OPTION 6
    public String tasksAssignedToDeveloper()
    {
        //Variable Declarations
        int counter = 0;
        String developerName = "";
        String returnData = "";//Return data for unit test
        //Ask User for Input
        developerName = JOptionPane.showInputDialog(null,"Give Developer Name","Search Task",JOptionPane.QUESTION_MESSAGE);
        //Loop elements of Array
        while (counter < this.developerArray.length)
        {//Check which element of array is equal to Input
            if (developerName.equals(this.developerArray[counter]))
            {//Display Task Details of element equal to array
                JOptionPane.showMessageDialog(null,"Task Name: " 
                + this.taskNamesArray[counter] + "\nTask Status: "
                + convertStatusToString(this.taskStatusArray[counter])
                ,"Task Found",JOptionPane.QUESTION_MESSAGE);
                //For unit test
                returnData = this.taskNamesArray[counter];
            }
            counter++;
        }    
        return returnData;
    }
    //-----------------------------------------------------------end
    //==============================================================
    //Method to Delete Task with Task Name
    //OPTION 7
    public String deleteTaskWithTaskName()
    {
        //Variable Declarations
        String taskName = "";//Store userInput
        String returnData = "";//Return data for unit test
        //Ask and get Task Name
        taskName = JOptionPane.showInputDialog(null,"Type the Name of the Task you wish to delete"
                ,"Delete Task",JOptionPane.QUESTION_MESSAGE);
        //Loop to find match
        for(int counter = 0; counter < this.taskCounter; counter++)
        {//Check which element matches //For unit test 
            if(taskName.equals(returnData = this.taskNamesArray[counter]))
            {//Loop from the match till last element of array
              
                for(int i = counter; i < this.taskCounter; i++)
                {//Copy the next element into this position
                    this.taskNamesArray[counter] = this.taskNamesArray[counter + 1];
                    this.developerArray[counter] = this.developerArray[counter + 1];
                    this.taskIDArray[counter] = this.taskIDArray[counter + 1];
                    this.taskDurationArray[counter] = this.taskDurationArray[counter + 1];
                    this.taskStatusArray[counter] =  this.taskStatusArray[counter + 1];
                }
                //Reset the last element to empty or zero
                this.taskNamesArray[this.taskCounter - 1] = null;
                this.developerArray[this.taskCounter - 1] = null;
                this.taskIDArray[this.taskCounter - 1] = null;
                this.taskDurationArray[this.taskCounter - 1] = 0;
                this.taskStatusArray[this.taskCounter - 1] = 0;
                //Decrease one element in taskCounter
                this.taskCounter--;
                //Decrease one element in Display Menu
                this.keepTrackOfTasks--;
                //Remove added time from total hours
                this.totalHours = this.totalHours - this.taskDurationArray[counter];
                //Inform user that task was deleted
                JOptionPane.showMessageDialog(null,"Task Deleted",
                        "Delete Task",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        //So that it doesnt return empty for unit test
        return returnData;
    }
    //-----------------------------------------------------------end
    //==============================================================
    //This method will be use has main method to call other methods
    public void mainThread()
    {   
        //Variable Declarations
        int option =0;//Initialse variable 
        boolean exit = false;//Exit program control variable
        boolean validLogin = false;//control variable to store Log In status
        //Call array and specify maximun amount of users that can be stored
        LOGIN user[] = new LOGIN[MAXIMUN_USERS];
        //Print Login Menu for User to make selection then proceed based on user selection
        do
        {
            option = printLoginMenu();
            switch (option) {
                case 1:
                    //Call registerUser Method to register a User
                    registerUser(user);
                    break;
                case 2:
                    //Call loginUser method to login an already registered user
                    //Set validLogin to true in case user logs in sucessfully
                    validLogin = loginUser(user);
                    if (validLogin == true)
                    {//Call POE Part 2 Menu if user Logs In sucessfully
                       KanBanMenu();
                    }
                    break;
                default:
                    //Exit Program
                    exit = true;
                    break;
            }
        }while(!exit);//Keep looping till exit is false
    }
    //------------------------------------------------------end
} 




