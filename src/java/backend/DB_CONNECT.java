/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author preet
 */
public class DB_CONNECT {
     private static Connection con = null;
     
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DB_UTILS.DB_NAME, 
                    DB_UTILS.DB_USER, DB_UTILS.DB_USER_PASSWORD);
            
            System.out.println("Connected to Database Successfully");
            
        }catch(SQLException x){
            System.out.println(x);
        } catch (ClassNotFoundException ex) {
             Logger.getLogger(DB_CONNECT.class.getName()).log(Level.SEVERE, null, ex);
         }
        return con;
    }
}
