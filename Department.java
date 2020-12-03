/**
 * Class to get data related to Employee from the database.
 *
 * @author Aswin Timalsina
 * CWID: 30098693
 */

import java.sql.*;

public class Department{
      
      
      // **************************************************
   // Public methods
   // **************************************************
   /**
    * Initializes the Department class.
    * 
    * Makes proper connection with the server to get the data related to Department.
    * 
    * @return ResultSet The set of result after querying the syntax.
    */
   public ResultSet initializeDepartment(){
      ServerConnection connect = new ServerConnection("example.properties");
      Connection connected = connect.getConnection();
      
      try{
         if(connected != null && !connected.isClosed()){
            ResultSet departments = new QueryParser(connected).getResult("SELECT Dname, Dnumber FROM DEPARTMENT");
            return departments;
         }
      }
      catch(Exception e){
         System.out.println("Error!! Error message: "+ e);
      
      }
      return null;
      
   }
}