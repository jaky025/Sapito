
package Inventario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
public static Connection conectar() throws SQLException {
        //String host="localhost:1521:";
        //String sid="XE";
        //String usuario="sapito";
        //String pass="sapito";
        String conexion="jdbc:oracle:thin:@localhost:1521:XE";
        Connection conx = null ;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conx = DriverManager.getConnection(conexion, "sapito", "sapito");
           // JOptionPane.showMessageDialog(null, "Se establecio la conexion");
            System.out.println("CONEXION CON EXITO");
            return conx;
        } catch (ClassNotFoundException e){
            System.out.println("Algo paso aqui "+ e.getMessage());
            return conx;
        }catch (SQLException e){
            System.out.println("Ahora el problema estubo de este lado"+e.getMessage());
            return null;      
        }
    }

}

//    public Connection getConexion() {
//        return conexion;
//    }
//
//    public void setConexion(Connection conexion) {
//        this.conexion = conexion;
//    }
//    
//        public static Connection Conectar(){
//        try{
//        Class.forName("oracle.jdbc.OracleDriver");
//        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
//        conexion= DriverManager.getConnection(BaseDeDatos,"tallerpro","tallerpro");
//        if(conexion!=null)
//        {
//        System.out.println("Conexion exitosa a esquema");
//        }
//        else{System.out.println("Conexion fallida");}
//        }
//        catch(Exception e)
//        {e.printStackTrace();}
//       
//    }
//
//    public static void main(String[] args) {
//        Conexion oracon = new Conexion();
//        oracon.Conectar();
//    }
//}
