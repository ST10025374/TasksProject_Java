package prog_poe;

public class TASK {

    //Variable declarations
    private int taskNumber = 0;
    private String taskName = "";
    private String taskDescription = "";
    private String developerDetails = "";
    private int taskDuration = 0;
    private String taskID = "";
    private int taskStatus = 0;
    //-----------------------------------------------------------------------end
    //==========================================================================
    //Method that returns the total number of hours from combined tasks
    public int returnTotalHours(int totalHours)
    {
        return totalHours;
    }    
    //-----------------------------------------------------------------------end
    //==========================================================================
    //Method that combines full details of Task ro a variable and returns it
    public String printTaskDetails()
    {   
        //Variable Declarations
        String fullTaskDetails = "";
        String storeStatus = "";
        //Set int value of taskStatus to String from options menu
        if (this.taskStatus == 1)
        {
            storeStatus = "To do";
        }
        else if (this.taskStatus == 2)
        {
            storeStatus = "Done";
        }
        else
        {
            storeStatus = "Doing";
        }
         //Combine all Task Information to present to user
        fullTaskDetails = storeStatus + " " + this.developerDetails + " " 
        + this.taskNumber + " " + this.taskName + " " + this.taskDescription 
        + " " + this.taskID + " " + this.taskDuration + "h";  
         
        return fullTaskDetails;
    }
    //-----------------------------------------------------------------------end
    //==========================================================================
    //This method builds and returns the TaskID
    public String createTaskID(String taskName, int taskNumber, String devDetails)
    {   
        //Variable Declarations
        String TaskID = "";//Variable that will store The TASK ID STring
        String TaskIDName = taskName.substring(0,2);//Get the first two letters from Task name 
        int TaskIDNumber = taskNumber;//Store Task number
        String devIDDetails = devDetails.substring(devDetails.length() - 3);//Get Last three letters from developer name 
        //Combining all variables to build String
        TaskID = TaskIDName + ":" + TaskIDNumber + ":" + devIDDetails; 
        //Return completed TaskID
        return TaskID.toUpperCase();
    }
    //-----------------------------------------------------------------------end
    //==========================================================================
    //This method checks if the task description has less or more than 50 characters
     public boolean checkTaskDescription(String taskDescription)
    {   //Variable Initialized
        boolean valid = false;
        //Check length of task description
        if (taskDescription.length() >= 50)
        {//if length more or equal to 50 return false
            valid = false;
        }
        else 
        {//if length less than 50 return true
            valid = true;
        }   
        return valid;
    }
    //-----------------------------------------------------------------------end
    /**
     * @return the taskNumber
     */
    public int getTaskNumber() {
        return taskNumber;
    }

    /**
     * @param taskNumber the taskNumber to set
     */
    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    /**
     * @return the taskName
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @param taskName the taskName to set
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * @return the taskDescription
     */
    public String getTaskDescription() {
        return taskDescription;
    }

    /**
     * @param taskDescription the taskDescription to set
     */
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    /**
     * @return the developerDetails
     */
    public String getDeveloperDetails() {
        return developerDetails;
    }

    /**
     * @param developerDetails the developerDetails to set
     */
    public void setDeveloperDetails(String developerDetails) {
        this.developerDetails = developerDetails;
    }

    /**
     * @return the taskDuration
     */
    public int getTaskDuration() {
        return taskDuration;
    }

    /**
     * @param taskDuration the taskDuration to set
     */
    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    /**
     * @return the taskID
     */
    public String getTaskID() {
        return taskID;
    }

    /**
     * @param taskID the taskID to set
     */
    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    /**
     * @return the taskStatus
     */
    public int getTaskStatus() {
        return taskStatus;
    }

    /**
     * @param taskStatus the taskStatus to set
     */
    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }   
}
//-----------------------------end