// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2021T1, Assignment 2
 * Name: Ella Wipatene
 * Username: wipateella
 * ID: 300558005
 */

import ecs100.*;
import java.awt.Color;
// libaries for the regex patterns for challenge
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Key:
 * Core:       Method must report whether the key is valid, or
 *             report that it is invalid and give one reason why it is invalid.
 *             To be valid, the key must
 *             - be at least 8 characters and at most 16 characters long,
 *             - not end with the special characters '#' or '$',
 *             - not have a hyphen ('-') character anywhere
 *            
 * Completion: Method should either report that the key is valid, or
 *             report that it is invalid and list ALL the reasons that it is invalid.
 *             To be valid, the key must
 *             - satisfy all of the conditions above AND
 *             - have at least one Upper case character and at least one Lower case character,
 *             - not start with the same character as the first character of the user's name
 *             - contain either a '#' or a '$', but not both.
 * Challenge:  Same as completion, except that to be valid, the key must
 *             - satisfy all of the conditions above AND
 *             - have a mix of numbers and letters
 *             - not contain any "suffix" of the user's name of 2 characters or more in any case.
 *               (eg if name is Peter, it does not contain "er", or "eR" or "ter", or "eTer" or "ETER", or...)
 *
 * Hint.  Look at the documentation in the String class.
 * You will definitely find the length(), endsWith(...), and contains(...) methods to be helpful
 */

public class KeyValidator {

    /**
     * Asks user for key word and then checks if it is a valid key word.
     */
    public void doCore(){
        UI.clearText();
        String key = UI.askString("Key:   ");
        UI.println();
        this.validateKeyCore(key);
    }

    /** CORE
     * Report "Valid" or "Invalid: ...reason...."
     */
    public void validateKeyCore(String key){
        int length = key.length();
        char lastChar = key.charAt(length - 1); 
        int hyphen = key.indexOf('-'); 
        
        if (length > 7 && length < 17){
            if (lastChar == '#' || lastChar == '$'){
                UI.println("Key not valid"); 
                UI.println("This is because the last character is # or $."); 
            } else {
                if (hyphen == -1){
                    UI.println("Your Key is valid."); 
                }else {
                    UI.println("Key not valid"); 
                    UI.println("This is because there is a '-' in your key"); 
                }
            }
        } else{
            UI.println("Key not valid"); 
            UI.println("Your key length is not valid." ); 
        } 
    }

    /**
     * Asks user for key word and the name and then checks if it is a valid key word.
     */
    public void doCompletion(){
        UI.clearText();
        String key = UI.askString("Key:   ");
        String name = UI.askString("Your name:   ");
        UI.println();
        this.validateKeyCompletion(key, name);
    }

    /** COMPLETION
     * Report that the key is valid or report ALL the rules that the key failed.
     */
    public void validateKeyCompletion(String key, String name){
        boolean[] valid = {false, false, false, false, true, false, true}; 
        String[] message = {"Your key length needs to be 8-12 characters long.", 
                            "Your key needs to contain both uppercase and lowercase.",
                            "The first character of your name equals first character of your key.",
                            "This is because there is a '-' in your key.",
                            "It cannot contain both $ and #.",
                            "Your key does not have either $ or #.",
                            "Your last character is # or $."};

        int length = key.length();
        char lastChar = key.charAt(length - 1); 
        int hyphen = key.indexOf('-'); 
        
        char nameFirstChar = name.charAt(0); 
        char keyFirstChar = key.charAt(0); 

        int hashtag = key.indexOf('#');
        int dollar = key.indexOf('$');
        
        boolean upperCase = !key.equals(key.toUpperCase()); 
        boolean lowerCase = !key.equals(key.toLowerCase());
        //https://stackoverflow.com/questions/16127923/checking-letter-case-upper-lower-within-a-string-in-java
        
        int i = 0; 
        if (length > 7 && length < 17){
            valid[i] = true; 
        }
        i++; 
        if (upperCase == true && lowerCase == true){
            valid[i] = true; 
        }
        i++; 
        if (nameFirstChar != keyFirstChar){
            valid[i] = true;     
        }
        i++; 
        if (hyphen == -1){
            valid[i] = true;           
        }
        i++; 
        if (hashtag > 0 && dollar > 0){ 
            valid[i] = false;
        }
        i++;
        if (hashtag > 0 || dollar > 0){
            valid[i] = true; 
        }
        i++;
        if (lastChar == '#' || lastChar == '$'){
            valid[i] = false;
        }
        
        boolean found = false;
        boolean searchedValue = true;

        for(boolean x : valid){
            if(x == searchedValue){
                found = false;
                break;
            }
        }
        
        if (found == false){
            UI.println("Your key is not valid."); 
            for (int y = 0; y <= i; y++) {
                if (valid[y] == false){
                    UI.println(message[y]);
                }
            }
            } else{
                UI.println("Your key is valid."); 
        }
    }
    
    public void validateKeyChallenge(String key, String name){
        boolean[] valid = {false, true, false, false, false, false, true, false, true}; 
        String[] message = {"Your key must have both letters and numbers.", 
                            "Your key can't contains a suffix of your name.", 
                            "Your key length needs to be 8-12 characters long.", 
                            "Your key needs to contain both uppercase and lowercase.",
                            "The first character of your name equals first character of your key.",
                            "This is because there is a '-' in your key.",
                            "It cannot contain both $ and #.",
                            "Your key does not have either $ or #.",
                            "Your last character is # or $."};
                       
        Pattern suffixPattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
        Matcher matcher = suffixPattern.matcher(key);
        boolean matchFound = matcher.find();
        
        
        
        int length = key.length();
        char lastChar = key.charAt(length - 1); 
        int hyphen = key.indexOf('-'); 
        
        char nameFirstChar = name.charAt(0); 
        char keyFirstChar = key.charAt(0); 

        int hashtag = key.indexOf('#');
        int dollar = key.indexOf('$');
        
        boolean upperCase = !key.equals(key.toUpperCase()); 
        boolean lowerCase = !key.equals(key.toLowerCase());
        //https://stackoverflow.com/questions/16127923/checking-letter-case-upper-lower-within-a-string-in-java
        
        boolean onlyLetters = false; 
        boolean onlyNums = false; 
        // will return true if it doesnt have any numbers
        if (key.matches("[a-zA-z]+")){ 
            onlyLetters = true;
        }
        // will return true if it doesnt have any letters
        if (key.matches("[0-9]+")){
            onlyNums = true;
        }
        
        int i = 0;
        if (onlyLetters == false && onlyNums == false){
            valid[i] = true; 
        }
        i++; 
        // Searching for suffix
        if(matchFound) { 
          valid[i] = false; 
        } 
        i++; 
        if (length > 7 && length < 17){
            valid[i] = true; 
        }
        i++; 
        if (upperCase == true && lowerCase == true){
            valid[i] = true; 
        }
        i++; 
        if (nameFirstChar != keyFirstChar){
            valid[i] = true;     
        }
        i++; 
        if (hyphen == -1){
            valid[i] = true;           
        }
        i++; 
        if (hashtag > 0 && dollar > 0){ 
            valid[i] = false;
        }
        i++;
        if (hashtag > 0 || dollar > 0){
            valid[i] = true; 
        }
        i++;
        if (lastChar == '#' || lastChar == '$'){
            valid[i] = false;
        }
        
        boolean found = false;
        boolean searchedValue = true;

        for(boolean x : valid){
            if(x == searchedValue){
                found = false;
                break;
            }
        }
        
        if (found == false){
            UI.println("Your key is not valid."); 
            for (int y = 0; y <= i; y++) {
                if (valid[y] == false){
                    UI.println(message[y]);
                }
            }
            } else{
                UI.println("Your key is valid."); 
        }
    }
    
    public void doChallenge(){
        UI.clearText();
        String key = UI.askString("Key:   ");
        String name = UI.askString("Your name:   ");
        UI.println();
        this.validateKeyChallenge(key, name);
    }


    public void setupGUI(){
        UI.initialise();
        UI.addButton("Clear", UI::clearText );
        UI.addButton("Validate Key Core", this::doCore );
        UI.addButton("Validate Key Completion", this::doCompletion );
        UI.addButton("Validate Key Challenge", this::doChallenge );
        UI.addButton("Quit", UI::quit );
        UI.setDivider(1);       // Expand the text area
    }

    public static void main(String[] args){
        KeyValidator kv = new KeyValidator();
        kv.setupGUI();
    }
}
