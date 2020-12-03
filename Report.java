 /**
 * Class to generate the actual report.
 *
 * @author Aswin Timalsina
 * CWID: 30098693
 */

import java.sql.*;
import java.util.*;

public class Report{
   
   Department d = new Department();
   Project p = new Project();
   Employee e = new Employee();
   
   ResultSet department = d.initializeDepartment();
  
   ResultSet employee;
   ResultSet project;
  
  
   // **************************************************
   // Public methods
   // **************************************************
   /**
    * Returns the actual report
    * 
    * Gets the data from Employee.java, Department.java and Project.java
    * 
    * @return The actual report with formatting.
    */
   public void printReport(){
      try{
      //loop to traverse through ResultSet of Employee
         while (department.next()){
            int numberOfEmployee = 0;
            float totalHours = 0;
         
            String dName = department.getString("Dname");
            int dNumber = department.getInt("Dnumber");
         
            System.out.print("\n"+dName);
         
            employee = e.initializeEmployee(dNumber);
         
         //loop to traverse through ResultSet of Employee
            while(employee.next()){
            //counting the number of employees in
               numberOfEmployee++;
            
            //concatenated employee name
               String employeeName = employee.getString("Fname") + " "+employee.getString("Lname");
               int employeeSsn = employee.getInt("Ssn");
               float employeeHours = 0;
            
               System.out.printf("\n\n%2s%s","",employeeName);
            
               project = p.initializeProject(employeeSsn);
            
            //loop to traverse through ResultSet of Projects
               while(project.next()){
                  String projectName = project.getString("Pname");
                  float hoursWorked = 0;
               
                  try{
                     hoursWorked = project.getFloat("Hours");
                  }
                  catch(NullPointerException e){
                     hoursWorked = 0;
                  }
                  totalHours += hoursWorked;
                  employeeHours += hoursWorked;
               
                  System.out.printf("\n%5s%-30s%4.1f", "", projectName, hoursWorked);
               
               } //while ends
            
               if(employeeHours != 0.0){
                  String lines = String.format("%.1f", employeeHours);
               
                  System.out.printf("\n%35s", "");
                  for(int i =0; i<lines.length(); i++){
                     System.out.print("-");
                  }
                  System.out.printf("\n%35s%4.1f", "", employeeHours); 
               }
            
            }//traversing employee ends
         
            System.out.printf("\n\nTotal: %d Employee", numberOfEmployee);
            System.out.printf("\n%-7s%-4.1f Hours\n", "", totalHours);
         }}
      
      catch(SQLException e){
         System.out.print("Error!!!"+e);
      
      }
   
   }

}