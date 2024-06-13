package prog_poe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LOGIN {
    
    //Variable Declarations
    private String userName;
    private String password;
    private String name;
    private String surname;
    final int MAXIMUN_USERNAME_LENGTH = 5;
    final int MINIMUN_PASSWORD_LENGTH = 8;
    //-----------------------------------------------------------------
    //=================================================================
    //This Method checks user input for Upper character----------------
    public boolean checkInputForUpperCharacter(String input)
    {//Initialised variable to false
        boolean value = false;
        
        //Loop string for its length till a character is found
        for (int count = 0; count < input.length(); count++)
        {//Check each character in string
            char ch = input.charAt(count);
            if (Character.isUpperCase(ch))
            {//Set boolean variable value to TRUE in case string has Upper Character
                value = true;
            }
        }
        return value;//
    }
    //--------------------------------------------------------------end
    //=================================================================
    //This Method checks user input for Digit--------------------------
    public boolean checkInputForDigit (String input)
    {//Initialised variable to false
        boolean value = false;
        
        //Loop string for its length till a digit is found
        for (int count = 0; count < input.length(); count++)
        {//Check each character in string
            char ch = input.charAt(count);
            if (Character.isDigit(ch))
            {//Set boolean variable value to TRUE in case string has digit
                value = true;
            }
        }
        return value;
    }
    //-----------------------------------------------------------------end
    //====================================================================
    //This Method checks user input for Special Characters----------------
    public boolean checkInputForSpecialCharacter (String input)
    {//Initialised variable to false
        boolean value = false;
        //Creates pattern object to detect if string has no special characters
        Pattern speCharPattern = Pattern.compile("[a-zA-Z0-9]*");
        //Object to trace the matched pattern to a particular string
        Matcher speCharMatcher = speCharPattern.matcher(input);
        //Check if pattern doesnt match String
        if (!speCharMatcher.matches())
        {//set value to true in case indicating that pattern doesnt match string
            value = true;
        }
        return value; 
    }
    //-------------------------------------------------------------------end
    //======================================================================
    //This Method checks if userName meets all conditions
    public boolean checkUserName(String input)
    {//Initialised variable to false
        boolean value = false;
        //Call method to check if Username doesnt exceed 5 characters
        if (input.length() <= MAXIMUN_USERNAME_LENGTH)
        {//Check if Username has UNDERSCORE
            if (input.contains("_"))
            {//Return true if all criterias are obeyed
                value = true;
            }
        } 
        return value;
    }
    //-------------------------------------------------------------------end
    //This Method checks if Password meets all conditions-------------------
    public boolean checkPasswordComplexity(String input)
    {//Initialised variable to false
        boolean value = false;
        //Check if PASSWORD contains 8 or more units
        if (input.length() >= MINIMUN_PASSWORD_LENGTH)
        {//Call method to check password for Upper characters
            if (checkInputForUpperCharacter(input))
            {//Call method to check password for Digit
                if (checkInputForDigit(input))
                {//Call method to check password for special character
                    if (checkInputForSpecialCharacter(input))
                    {//Return true if all conditions are obeyed
                        value = true;
                    }
                }
            }
        }
        return value;
    }
    
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
}

