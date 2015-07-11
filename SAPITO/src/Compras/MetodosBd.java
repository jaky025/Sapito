/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import java.awt.Component;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rulo
 */
public class MetodosBd {
    
    private PreparedStatement pS;
    private PreparedStatement pS2;
    private ResultSet resultSet;
    private ResultSet rs2;
    private ResultSet rs;
    Connection conn;
    Statement stmt;
    private Object ex;
    private Component rootPane;
    private JTable Tabla;
    
    public void tablaProv(JTable Tabla,DefaultTableModel Tprov){
               Tabla.setModel(Tprov);
    try {
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sapito", "sapito");
                    stmt = conn.createStatement();
                    System.out.println("Conexion realizada");
                    pS = conn.prepareStatement("select * from PROVEEDORES");
                    rs = pS.executeQuery();
                    System.out.println(rs);
                    if (rs.next()) {
                        pS = conn.prepareStatement("select * from proveedores");
                        resultSet = pS.executeQuery();
                        ResultSetMetaData rsmd = resultSet.getMetaData();
                          int columnas = rsmd.getColumnCount();
                          for (int i = 1; i <= columnas; i++) {
                            Tprov.addColumn(rsmd.getColumnLabel(i));
                        }
                        while (resultSet.next()) {
                          Object[] fila= new Object[columnas];
                            for (int i = 0; i < 10; i++) {
                                fila[i]=resultSet.getObject(i+1);
                            }
                            Tprov.addRow(fila);

                        }
                    } else {
                        //JOptionPane.showMessageDialog(rootPane, "VERIFIQUE SU ID", "Error!! ", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null, "VERIFIQUE SU ID POR FAVOR", "Error!!", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    System.out.println("X: " + ex);
                }
    }
    
    public void consulta(String id,JTextField Tid,JTextField Trazon,JTextField Trfc,JTextField Tgiro,JTextField Ttel,JTextField Tcorreo,JTextField Tcalle, JTextField Tnumint,JTextField Tnumext,JTextField Tcolonia,JTextField Tcodigop,JComboBox jComboBox,JTextField Tmunicipio,JTextField Tnombre,JTextField Tapaterno,JTextField Tamaterno ) {
                try {
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sapito", "sapito");
                    stmt = conn.createStatement();
                    System.out.println("Conexion realizada");
                    pS = conn.prepareStatement("select id_proveedor from PROVEEDORES where id_proveedor =?");
                    pS.setString(1, id);
                    rs = pS.executeQuery();
                    System.out.println(rs);
                    //
                    if (rs.next()) {
                        //el .next sirve para pasarnos a otra tupla

                        pS = conn.prepareStatement("select nombre,apellido_p,apellido_m,RFC,telefono,mail,calle,num_int,num_ext,cp,estado,municipio,colonia,razon_social from PROVEEDORES where id_proveedor =?");
                        pS.setString(1, id);

                        resultSet = pS.executeQuery();
//                        pS2 = conn.prepareStatement("select puesto from empleado where idempleado in (select idpersona from persona where idpersona =?)");
//                        pS2.setString(1, id);
//                        rs2 = pS2.executeQuery();
                        while (resultSet.next()) {

                            Tnombre.setText(resultSet.getString("nombre"));
                            System.out.println(resultSet.getString("nombre"));
                            Tapaterno.setText(resultSet.getString("apellido_p"));
                            Tamaterno.setText(resultSet.getString("apellido_m"));
                            Trfc.setText(resultSet.getString("RFC"));
                            Ttel.setText(resultSet.getString("telefono"));
                            Tcorreo.setText(resultSet.getString("mail"));
                            Tcalle.setText(resultSet.getString("calle"));
                            Tnumint.setText(resultSet.getString("num_int"));
                            Tnumext.setText(resultSet.getString("num_ext"));
                            Tcodigop.setText(resultSet.getString("cp"));
                            jComboBox.setSelectedItem(resultSet.getString("estado"));  
                            Tmunicipio.setText(resultSet.getString("municipio"));
                            Tcolonia.setText(resultSet.getString("colonia"));
                            Trazon.setText(resultSet.getString("razon_social"));
                            ////// t_par.setText(resultSet.getString("pareja"));

                        }
                    } else {
                        //JOptionPane.showMessageDialog(rootPane, "VERIFIQUE SU ID", "Error!! ", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null, "VERIFIQUE SU ID POR FAVOR", "Error!!", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    System.out.println("X: " + ex);
                }
            }
    
    public void insertProv(int id,String nombre,String ap,String am, String rfc,String tel,String mail, String calle, String numint,String numext,String cp,String estado,String municipio,String colonia, String razon){
        //select id_proveedor from proveedores where rownum<=1 order by id_proveedor desc;
        Logger.getLogger(AltaProveedor.class.getName()).log(Level.SEVERE, null, ex);

                DataBaseManager data = new DataBaseManager();

                try {
                    data.openConnection();
                    PreparedStatement ps = data.getConnection().prepareStatement("insert into PROVEEDORES values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                    ps.setInt(1, id);
                    ps.setString(2, nombre);
                    ps.setString(3, ap);
                    ps.setString(4, am);
                    ps.setString(5, rfc);
                    ps.setString(6, tel);
                    ps.setString(7, mail);
                    ps.setString(8, calle);
                    ps.setString(9, numint);
                    ps.setString(10,numext);
                    ps.setBigDecimal(11, BigDecimal.valueOf(Long.parseLong(cp)));
                    ps.setString(12, estado);
                    ps.setString(13, municipio);
                    ps.setString(14, colonia);
                    ps.setString(15, razon);
                    ps.execute();
                    data.closeConnection();

                    JOptionPane.showMessageDialog(rootPane, "Registro Guardado En La BD", "CONFIRMACIÓN ", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(AltaProveedor.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "registro no guardado\n e-mail debe tener @ y . ","ERROR...",JOptionPane.ERROR_MESSAGE);
                }
    }
    
    public void insertProd(int id, String nombre, String cantidad, String umedida, String detalle, String precio,String proveedor,String min,String max, String pavent){
                               Logger.getLogger(AltaProveedor.class.getName()).log(Level.SEVERE, null, ex);

                DataBaseManager data = new DataBaseManager();

                try {
                    data.openConnection();
                    PreparedStatement ps = data.getConnection().prepareStatement("insert into PRODUCTOS values (?,?,?,?,?,?,?,?,?,?)");
                    System.out.println(id);
                    ps.setInt(1, id);    
                    ps.setString(2, nombre);
                    ps.setString(3, cantidad);
                    ps.setString(4, umedida);
                    ps.setString(5, detalle);
                    ps.setDouble(6, Double.parseDouble(precio));
                    ps.setBigDecimal(7, BigDecimal.valueOf(Long.parseLong(proveedor)));
                    ps.setString(8, min);
                    ps.setString(9, max);
                    ps.setString(10, pavent);
                    ps.execute();
                    data.closeConnection();
                    JOptionPane.showMessageDialog(null, "Registro Guardado En La BD", "CONFIRMACIÓN ", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(AltaProveedor.class.getName()).log(Level.SEVERE, null, ex);
                }

                
    }
    
    public int idGenerar() throws SQLException{
        int id=0;
       try {
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sapito", "sapito");
                    stmt = conn.createStatement();
                    System.out.println("Conexion realizada");
                    pS = conn.prepareStatement("select id_proveedor from PROVEEDORES where rownum<=1 order by id_proveedor desc");
                    rs = pS.executeQuery();
                    System.out.println(rs);
                    if (rs.next()) {
                        pS = conn.prepareStatement("select id_proveedor from PROVEEDORES where rownum<=1 order by id_proveedor desc");
                        resultSet = pS.executeQuery();
                        while (resultSet.next()) {
                            id= Integer.parseInt(resultSet.getString("id_proveedor"));
                        }
                    } 

                } catch (SQLException ex) {
                    System.out.println("X: " + ex);
                }
        return id;
        
    }
    
    public int idGenerarprod() throws SQLException{
        int id=0;
       try {
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sapito", "sapito");
                    stmt = conn.createStatement();
                    System.out.println("Conexion realizada");
                    pS = conn.prepareStatement("select id_producto from PRODUCTOS where rownum<=1 order by id_producto desc");
                    rs = pS.executeQuery();
                    System.out.println(rs);
                    if (rs.next()) {
                        pS = conn.prepareStatement("select id_producto from PRODUCTOS where rownum<=1 order by id_producto desc");
                        resultSet = pS.executeQuery();
                        while (resultSet.next()) {
                            id= Integer.parseInt(resultSet.getString("id_producto"));
                        }
                    } 

                } catch (SQLException ex) {
                    System.out.println("X: " + ex);
                }
        return id;
        
    }
    
    public String[] comboProveedores(){
        String id=null;
        String proveedores[]=null;
       try {
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sapito", "sapito");
                    stmt = conn.createStatement();
                    System.out.println("Conexion realizada");
                    pS = conn.prepareStatement("select razon_social from PROVEEDORES order by razon_social asc");
                    rs = pS.executeQuery();
                    System.out.println(rs);
                    if (rs.next()) {
                        pS = conn.prepareStatement("select razon_social from PROVEEDORES order by razon_social asc");
                        resultSet = pS.executeQuery();
                        int i =0;
                        while (resultSet.next()) {
                         
                            //proveedores= resultSet.getArray("razon_social");
                            System.out.println(id);
                             System.out.println(resultSet.getRow());
                             i++;
                        }
                        System.out.println("vas bien "+resultSet.getRow());
                    } 

                } catch (SQLException ex) {
                    System.out.println("X: " + ex);
                }
       return proveedores;
    }
    
    public void conProd(String id,JTextField Tnombre,JComboBox CBumedida,JTextField Tprecio,JTextField Tdetalle,JTextField Tproveedor){
        try {
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sapito", "sapito");
                    stmt = conn.createStatement();
                    System.out.println("Conexion realizada");
                    pS = conn.prepareStatement("select id_producto from PRODUCTOS where id_producto =?");
                    pS.setString(1, id);
                    rs = pS.executeQuery();
                    System.out.println(rs);
                    //
                    if (rs.next()) {
                        //el .next sirve para pasarnos a otra tupla

                        pS = conn.prepareStatement("select nombre,unidad_medida,precio_venta,detalles,id_proveedor from PRODUCTOS where id_producto =?");
                        pS.setString(1, id);

                        resultSet = pS.executeQuery();
//                        pS2 = conn.prepareStatement("select puesto from empleado where idempleado in (select idpersona from persona where idpersona =?)");
//                        pS2.setString(1, id);
//                        rs2 = pS2.executeQuery();
                        while (resultSet.next()) {

                            Tnombre.setText(resultSet.getString("nombre"));
                            CBumedida.setSelectedItem(resultSet.getString("unidad_medida"));
                            Tprecio.setText(resultSet.getString("precio_venta"));
                            Tdetalle.setText(resultSet.getString("detalles"));
                            Tproveedor.setText(resultSet.getString("id_proveedor"));

                        }
                    } else {
                        //JOptionPane.showMessageDialog(rootPane, "VERIFIQUE SU ID", "Error!! ", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(rootPane, "VERIFIQUE SU ID POR FAVOR", "Error!!", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    System.out.println("X: " + ex);
                }
    }
    
    public void insDetOrd(int iddet,double impuesto, double subtord, double totord, String fechap, String fechar,String status, int numorden) throws ParseException{
       SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate = formatter.parse(fechap);
      java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Logger.getLogger(AltaProveedor.class.getName()).log(Level.SEVERE, null, ex);

                DataBaseManager data = new DataBaseManager();

                try {
                    data.openConnection();
                    PreparedStatement ps = data.getConnection().prepareStatement("insert into DETALLE_ORDENES values (?,?,?,?,?,?,?,?)");
                    System.out.println(iddet);
                    ps.setInt(1, iddet);    
                    ps.setDouble(2, impuesto);
                    ps.setDouble(3, subtord);
                    ps.setDouble(4, totord);
                    ps.setDate(5, sqlDate);
                    ps.setDate(6, sqlDate);
                    ps.setString(7, status);
                    ps.setInt(8, numorden);
                    ps.execute();
                    data.closeConnection();
                    
                    JOptionPane.showMessageDialog(null, "Registro Guardado En La BD", "CONFIRMACIÓN ", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(AltaProveedor.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public int folio(){
        int id=0;
       try {
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sapito", "sapito");
                    stmt = conn.createStatement();
                    System.out.println("Conexion realizada");
                    pS = conn.prepareStatement("select no_compra from DETALLE_ORDENES where rownum<=1 order by no_compra desc");
                    rs = pS.executeQuery();
                    System.out.println(rs);
                    if (rs.next()) {
                        pS = conn.prepareStatement("select no_compra from DETALLE_ORDENES where rownum<=1 order by no_compra desc");
                        resultSet = pS.executeQuery();
                        while (resultSet.next()) {
                            id= Integer.parseInt(resultSet.getString("no_compra"));
                        }
                    } 

                } catch (SQLException ex) {
                    System.out.println("X: " + ex);
                }
        return id;
        
    }
    
    public void insOrdnComp(DefaultTableModel modeloT){
        Double totalf = 0.0;
               int renglones = modeloT.getRowCount();
               int columnas = modeloT.getColumnCount();
                   for (int i = 0; i < renglones; i++) {
                       for (int j = 0; j < columnas; j++) {
                           System.out.println(modeloT.getValueAt(i, j)); 
                           
                       }

                      
                   }
    }
}

