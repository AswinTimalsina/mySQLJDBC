 /**
 * Class to get data related to project from the database.
 *
 * @author Aswin Timalsina
 * CWID: 30098693
 */
import java.sql.*;

public class Project{
  
   // **************************************************
   // Public methods
   // **************************************************
   /**
    * Initializes the Project class.
    * 
    * Makes proper connection with the server to get the data related to project of employee.
    * 
    * @return ResultSet The set of result after querying the syntax.
    */
   public ResultSet initializeProject(int ssn){
      ServerConnection connect = new ServerConnection("example.properties");
      Connection connected = connect.getConnection();
      
      try{
         if(connected != null && !connected.isClosed()){
            ResultSet projects = new QueryParser(connected).getResult("SELECT Pname, Hours FROM (EMPLOYEE JOIN WORKS_ON ON Ssn=Essn) JOIN PROJECT ON Pno = Pnumber WHERE Ssn = "+ ssn);
            return projects;
         }
      }
      catch(Exception e){
         System.out.println("Error!! Error message: "+ e);
      
      }
      return null;
      
   }
}