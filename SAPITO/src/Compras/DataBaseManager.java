/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Richard
 */
public class DataBaseManager {
       
    private Connection dbConnection;
    private final String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String user = "SAPITO";
    private final String password = "sapito";
    
    public DataBaseManager() {
        
    }
    
    public void openConnection() throws SQLException {
        if (dbConnection == null) {
            dbConnection = DriverManager.getConnection(dbURL, user, password);
        }
    }
    
    public void closeConnection() throws SQLException {
        if (dbConnection != null) {
            dbConnection.close();
        }
    }
    
    public Connection getConnection() {
        return dbConnection;
    }
    
    public static void main(String[] args) throws SQLException {
        String apellido = "lopez";
        DataBaseManager dbConn = new DataBaseManager();  //Importante 1
        dbConn.openConnection(); //Importante 2
        System.out.println("Conexion:" + dbConn.getConnection());
        Statement stmt = dbConn.getConnection().createStatement(); //Importante 3
        //ResultSet rs = stmt.executeQuery("SELECT * from EMPLEADOS");
        //ResultSet rs = stmt.executeQuery("SELECT * from EMPLEADOS WHERE APELLIDO_M = 'lopez'");
        //ResultSet rs = stmt.executeQuery("SELECT * from EMPLEADOS WHERE APELLIDO_M = '" + apellido + "'"); //Importante 4
        int regModif = stmt.executeUpdate("UPDATE EMPLEADOS SET NOMBRE='loquelequeramosdar' WHERE NOMBRE='Jona'");
        System.out.println("Cantidad de registros modificados=" + regModif);
        //while (rs.next()) { //Importante 5
        //    System.out.println("Empleados:" + rs.getString("NOMBRE"));
        //}
        
        dbConn.closeConnection(); //Importante 6
    }
}

