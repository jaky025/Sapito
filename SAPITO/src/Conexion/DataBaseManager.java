/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import java.text.ParseException;

/**
 *
 * @author Richard
 */
public class DataBaseManager {

    public static Object getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    private Connection dbConnection;
    private final String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String user = "sapito";
    private final String password = "sapito";
     private ResultSet rs;
     private Statement stmt;
      private JLabel fecha;
    
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
    
//    public static void main(String[] args) throws SQLException {
//        String apellido = "lopez";
//        DataBaseManager dbConn = new DataBaseManager();  //Importante 1
//        dbConn.openConnection(); //Importante 2
//        System.out.println("Conexion:" + dbConn.getConnection());
//        Statement stmt = dbConn.getConnection().createStatement(); //Importante 3
//        //ResultSet rs = stmt.executeQuery("SELECT * from EMPLEADOS");
//        //ResultSet rs = stmt.executeQuery("SELECT * from EMPLEADOS WHERE APELLIDO_M = 'lopez'");
//        //ResultSet rs = stmt.executeQuery("SELECT * from EMPLEADOS WHERE APELLIDO_M = '" + apellido + "'"); //Importante 4
//        int regModif = stmt.executeUpdate("UPDATE EMPLEADOS SET NOMBRE='loquelequeramosdar' WHERE NOMBRE='Jona'");
//        System.out.println("Cantidad de registros modificados=" + regModif);
//        //while (rs.next()) { //Importante 5
        //    System.out.println("Empleados:" + rs.getString("NOMBRE"));
        //}
        
//        dbConn.closeConnection(); //Importante 6
//    }

//     public void insert_PROVEEDORES(
//                               int id_proveedor,
//                               String nombre, 
//                               String Apa,
//                               String Ama,
//                               String correo,
//                               String tel,
//                               String est,
//                               String mun,
//                               String col,
//                               String calle,
//                               int cp,
//                               String num_int,
//                               String num_ext,
//                               String rfc,
//                               String rz ) throws SQLException{
//        
//       stmt= obj.getConnection().createStatement();
//
//        SimpleDateFormat format1 = new SimpleDateFormat("ddMMyy");
//        String fech = format1.format(new Date());
//       
//       int inser=stmt.executeUpdate("insert into TABLE1 values(TO_DATE('"+fech+"'))");
//       int insert = stmt.executeUpdate("INSERT into PROVEEDORES values('"+id_proveedor+"','"+nombre+"','"+Apa+"','"+Ama+"',TO_DATE('"+fech+"'),'"+correo+"','"+tel+"','"+est+"','"+mun+"','"+col+"','"+calle+"','"+cp+"','"+num_int+"','"+num_ext+"','"+rfc+"','"+rz+"')");
//      
//       
//       System.out.println("Proveedpres ingresados: "+insert);
//       stmt.close();
//    
//    }
//
//    public void insert_PRODUCTOS(DataBaseManager obj,
//                               int id_producto,
//                               String nombre, 
//                               String precio_venta,
//                               String unidad_medida,
//                               String detalles,                               
//                               String id_proveedor ) throws SQLException{
//        
//       stmt= obj.getConnection().createStatement();
//
//        SimpleDateFormat format1 = new SimpleDateFormat("ddMMyy");
//        String fech = format1.format(new Date());
//       
//       int inser=stmt.executeUpdate("insert into TABLE1 values(TO_DATE('"+fech+"'))");
//       int insert = stmt.executeUpdate("INSERT into PRODUCTOS values('"+id_proveedor+"','"+nombre+"','"+precio_venta+"','"+unidad_medida+"',TO_DATE('"+fech+"'),'"+detalles+"','"+id_proveedor+"')");
//      
//       
//       System.out.println("Productos ingresados: "+insert);
//       stmt.close();
//    
//    }
//
//    void insert_PROVEEDORES(DataBaseManager con, int i, String text, String text0, String text1, String text2, String toString, String text3, String text4, int parseInt, String text5, String text6, String text7, String text8, String text9) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    public boolean Escribir(String sql) {
        try {
            Statement sentencia;
            sentencia = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.execute(sql);
            sentencia.close();
            //getConexion().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("ERROR SQL");
            return false;
        }
        return true;
    }

    public ResultSet Consultar(String sql) {
        ResultSet resultado = null;
        try {
            Statement sentencia;
            sentencia = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
            resultado.next();
            while (resultado.next()) {
                System.out.println(rs.getString("select * from TABLA"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return resultado;
    }

    public void Connection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}