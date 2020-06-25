/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;

public abstract class DAO
{
    protected static Connection c;
            
    protected DAO() throws ClassNotFoundException, SQLException
    {
    	Class.forName("com.mysql.jdbc.Driver");
        String bd = "jdbc:mysql://localhost:3306/adventurecity";
        c = DriverManager.getConnection(bd, "root", "azerty");
    }
    
    public void close() throws SQLException
    {
            c.close();
    }
}
