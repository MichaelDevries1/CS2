/* Program: User Login
   Created by:  Michael DeVries
   Created on: 9/2017
   This program is meant to verify if a login given by a user meets certain criteria. This criteria
      includes at least one uppercase and lowercase letter, on number, one symbol (!@# or $) without
      without any whitespace or character not mentioned before.
*/

package hw1;

import java.util.Scanner;
import java.io.*;

public class UserLogin {
   public static void main (String[] args) 
                 throws IOException {
      // Create the output
      final String OUTPUT_FILE = "UserLoginResult.txt";
      FileWriter outputDataFile = new 
                 FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new 
                 PrintWriter(outputDataFile);
      Scanner scn = new Scanner(System.in).useDelimiter("\n");
      char answer = 'Y';
      StringBuffer finalReport = new StringBuffer("");
      
      
      greetUser();
      while (answer == 'y' || answer == 'Y') {
         String login = "";
         String loginValid = "";
         StringBuffer errors = new StringBuffer("");
         
         login = readUser(login, scn);
         errors = checkCase(login, errors);
         errors = checkLength(login, errors);
         loginValid = checkValidity(errors, loginValid);
         errors = printUser(login, loginValid, errors);
         finalReport = addToReport(finalReport, errors);
         printReport(finalReport, outputFile);
         
         System.out.println("Do you have another login? (Y/N)");
         answer = scn.next().trim().charAt(0);

      } // End while
      
      
      // Close files
      outputFile.close();
      System.exit(0);
   } // End main
//-------------------------------------------------------------------------------------------------
   public static void greetUser () {                       // 
      System.out.println("This program will accept an" +
            " input and check to make sure it is a is a " +
            "is a valid login.");
   } // End greetUser
//-------------------------------------------------------------------------------------------------
   public static String readUser (String loginFromUser,    // 
                 Scanner scn) {
      System.out.print("What is your login?: ");
      loginFromUser = scn.nextLine();
      //System.out.println(loginFromUser);
      return loginFromUser;
   } // End readUser
//-------------------------------------------------------------------------------------------------
   public static StringBuffer checkCase (String login,     // Check for character errors
                 StringBuffer errors) {
      boolean upper = false;                               // Varriable for uppercase
      boolean lower = false;                               // Varriable for lowercase
      boolean digit = false;                               // Varriable for numbers
      boolean symbol = false;                              // Varriable for accepted symbols
      boolean spaces = false;                              // Varriable for whitespace
      boolean notAccepted = false;                         // Varriable for non-accepted symbols
      
      for (int i = 0; i < login.length(); i++) {           // Check for character criteria.
         char ch = login.charAt(i);                        // Current character
         if (spaces == false) {                            // Check whitespace
            if (Character.isWhitespace(ch)) {            
               spaces = true;
               break;
            } // End if
         } // End if
         if (upper == false) {                             // Check for Uppercase letters
            if (Character.isUpperCase(ch)) {
               upper = true;
               continue;
            } // End if
         } // End if
         if (lower == false) {                             // Check for Lowercase letters
            if (Character.isLowerCase(ch)) {               
               lower = true;
               continue;
            } // End if
         } // End if
         if (digit == false) {                             // Check for numbers
            if (Character.isDigit(ch)) {
               digit = true;
               continue;
            } // End if
         } // End if
         if (symbol == false) {                            // Check for !, @, #, $ characters
            if (ch == '!' || ch == '@' || ch == '#' || 
                ch == '$') {
               symbol = true;
               continue;
            } // End if
         } // End if
         if (notAccepted == false) {                       // Check for characters other than 
            if (!Character.isDigit(ch) &&                  // previously mentioned characters
                !Character.isLetter(ch) && ch != '!' && 
                ch != '@' && ch != '#' && ch != '$') {
               notAccepted = true;
               continue;
            } // End if
         } // End if
      } // End for
      
/*    // Checks for all the possibilities
      if (spaces == false) {
         System.out.println("OK Spaces");
      } // End if
      if (upper == true) {
         System.out.println("OK Upper");
      } // End if
      if(lower == true) {
         System.out.println("OK Lower"); 
      } // End if
      if(digit == true) {
         System.out.println("OK Digit");  
      } // End if
      if(symbol == true) {
         System.out.println("OK Symbol");  
      } // End if
      if(notAccepted == false) {
         System.out.println("OK other characters"); 
      } // End if
*/
      
      // Error reports if an error is found
      if (spaces == true) {
         errors.append("   --Spaces and tabs are not allowed\n");
      } // End if
      if (upper == false) {
         errors.append("   --No uppercase letter (A-Z)\n");
      } // End if
      if(lower == false) {
         errors.append("   --No lowercase letter (a-z)\n");
      } // End if
      if(digit == false) {
         errors.append("   --No numerical digit (0-9)\n");
      } // End if
      if(symbol == false) {
         errors.append("   --No special character (!@#$)\n");
      } // End if
      if(notAccepted == true) {
         errors.append("   --Invalid special character\n");
      } // End if
      // System.out.println("" + upper + " " + lower + " " + digit + " " + symbol + " " + spaces + " " + notAccepted);
      return errors;
   } // End checkCase
//-------------------------------------------------------------------------------------------------
   public static StringBuffer checkLength (String login,   // Checks to see if the login is more 
                 StringBuffer errors) {                    // than 5 characters long
      if (login.length() < 5) {
         errors.append("   --Too short (minimum of 5 " +   // Error report for a short login
            "characters)\n");
      } // End if
      // System.out.println("" + login.length());
      return errors;
   } // End checkLength
//-------------------------------------------------------------------------------------------------
   public static String checkValidity (StringBuffer errors,// Checks the validity of all login 
                  String valid) {                          // checks
      if (errors.toString().equals("")) {                  // Checks for error reports
         valid = "(valid)\n";                              // Login is valid
      } //End if
      else {
         valid = "(invalid)\n";                            // Login isn't Valid
      } // End else
      return valid;
   } // End checkValidity
//-------------------------------------------------------------------------------------------------
   public static StringBuffer printUser (String login,     // Creates the first line of the report
                 String valid, StringBuffer errors) {
      int count = 15 - login.length();                     // Formats result so validity is always
      String whitespace = "";                              // in the same place
      
      errors.insert(0, "\nLogin: " + login + whitespace + valid);
      System.out.println(errors);
      
      return errors;                                        
   } // End printUser
//-------------------------------------------------------------------------------------------------
   public static StringBuffer addToReport (StringBuffer finalReport,   // Adds the first line to the error
                 StringBuffer errors) {                                // report
      finalReport.append("\n" + errors);
      return finalReport;
   } // End addToReport
//-------------------------------------------------------------------------------------------------
   public static void printReport(StringBuffer     // Prints reports to document and 
                 finalReport,PrintWriter                 // console
                 outputFile) {
      outputFile.println(finalReport);         
   // System.out.println(finalReport);                           
   } // End printReport
} // End Class