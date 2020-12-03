/**
 * Class to get data related to Employee from the database.
 *
 * @author Aswin Timalsina
 * CWID: 30098693
 */

import java.sql.*;

public class Employee{
   
   // **************************************************
   // Public methods
   // **************************************************
   /**
    * Initializes the Employee class.
    * 
    * Makes proper connection with the server to get the data related to Employee woking in the department.
    * 
    * @return ResultSet The set of result after querying the syntax.
    */
   public ResultSet initializeEmployee(int Dnumber){
      ServerConnection connect = new ServerConnection("example.properties");
      Connection connected = connect.getConnection();
      
      try{
         if(connected != null && !connected.isClosed()){
            ResultSet employees = new QueryParser(connected).getResult("SELECT Fname, Lname, Ssn FROM EMPLOYEE JOIN DEPARTMENT ON Dno = Dnumber WHERE Dno = " + Dnumber + " ORDER BY Fname, Lname");
            return employees;
         }
      }
      catch(Exception e){
         System.out.println("Error!! Error message: "+ e);
      
      }
      return null;
      
   }
}