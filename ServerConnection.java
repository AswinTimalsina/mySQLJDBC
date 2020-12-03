/**
 * Class to make connection with the server.
 * The class's method is used anytime connection is to be made.
 *
 * @author Aswin Timalsina
 * CWID: 30098693
 */

import java.io.*;
import java.sql.*;
import java.util.*;

public class ServerConnection{

   private String url;
   private String username;
   private String password;
   private String driver;

 
   // **************************************************
   // Constructor
   // **************************************************
   /**
    * 
    * Constructor to initialize instance variables with the value
    * 
    */
   public ServerConnection(String informationFile){
      try{
         FileReader read = new FileReader(informationFile);
         
         Properties data = new Properties();
         data.load(read);   
         
         url = data.getProperty("db.url");
         username = data.getProperty("db.user");
         password = data.getProperty("db.password");
         driver = data.getProperty("db.driver");
         
      }
      catch(Exception e){
         System.out.println("Error!!! Error message: "+e);
      }
   }
   
   
   // **************************************************
   // Public methods
   // **************************************************
   /**
    * Returns the connection established after using credentials
    * 
    * Method to connect to the server with credentials
    * 
    * @return The connection with the database.
    */
   public Connection getConnection(){
      try{
         Class.forName(driver).getDeclaredConstructor().newInstance();
         return DriverManager.getConnection(url, username, password);
      }
      catch(Exception e){
         System.out.println("Error!!! Error message: "+ e);
         return null;
      }
   }
   

   // **************************************************
   // Public methods
   // **************************************************
   /**
    * 
    * Method to close the connection with the server.
    * 
    */
   public void closeConnection(Connection current){
      try{
         if(current != null){
            current.close();
         }
      }
      catch(Exception e){
         System.out.println("Error!!! Error message: "+ e);
      }
   }
   
   
}