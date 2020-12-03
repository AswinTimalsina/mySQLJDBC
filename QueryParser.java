 /**
 * Class to parse the query.
 *
 * @author Aswin Timalsina
 * CWID: 30098693
 */
import java.sql.*;

public class QueryParser{

   private Statement stmnt;

    // **************************************************
    // Constructors
    // **************************************************
    /**
    * Default constructor.
    */
   public QueryParser(Connection connect){
   
      try{
         this.stmnt = connect.createStatement();
      }
      
      catch(SQLException e){
         System.out.println("Error!!"+e);
      }
   }
   
   // **************************************************
   // Public methods
   // **************************************************
   /**
    * Returns the actual report
    * 
    * @return ResultSet The result after querying.
    */
   public ResultSet getResult(String query){
   
      ResultSet result = null;
   
      try{            
         result = this.stmnt.executeQuery(query);
      }
        
      catch(SQLException e){
         System.out.println("Error: " + e.getMessage());
      }
        
      return result;
   }
    

}