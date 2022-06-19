/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vvlalalove193
 */
public class DBConnection {
    public static void main(String []args){
        Connection c = createConnection();
    }
    
    public static Connection createConnection(){
        Connection con = null;
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root"; //MySQL URL and followed by the database name
        String username = "root"; //MySQL username
        String password = "123456"; //MySQL password   
        try 
        {
            try 
            {

                Class.forName("com.mysql.cj.jdbc.Driver"); //loading mysql driver 
            } 
            catch (ClassNotFoundException e)
            {
               e.printStackTrace();
            } 
            con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
            System.out.println("Printing connection object "+con);
        } 
        catch (SQLException e) 
        {
           e.printStackTrace();
        }
        return con; 
    }
}
