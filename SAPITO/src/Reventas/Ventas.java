/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reventas;

import Conexion.DataBaseManager;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author Curso
 */
public class Ventas extends JFrame {

    public JPanel jPanel;
    public JComboBox jCliente;
    public JComboBox jCproducto;
    public JButton agragar;
    public JButton buscar;
    public JButton continuar;
    public JTable tabla;
    public int i=0;
    public int k=0;
    public JButton jbagregar;
    public String TablaContent[][]={{"1","2","3","4"},{"5","6","7","8"}};
   

    Customer[] cliente = new Customer[10];
    Product[] listproduc = new Product[10];

    public String[] getNames() {
        String[] names = new String[10];
        for (int j = 0; j < i; j++) {
            names[j] = cliente[j].getName();
        }

        return names;
    }

    public String[] getProduct() {
        String[] productt = new String[10];
        for (int j = 0; j < k; j++) {
            productt[j] = listproduc[j].getProductname();
        }

        return productt;
    }
    public void cargarinformacion() throws SQLException{
         DataBaseManager dbConn = new DataBaseManager();  //Importante 1
        dbConn.openConnection(); //Importante 2
//        System.out.println("Conexion:" + dbConn.getConnection());
        Statement stmt = dbConn.getConnection().createStatement(); //Importante 3
        ResultSet rs = stmt.executeQuery("SELECT * from CLIENTES");
        
        while (rs.next()) { //Importante 5
            cliente[i] = new Customer();
            cliente[i].setName(rs.getString("NOMBRE"));
            cliente[i++].setId(i);
            
        }
        stmt = dbConn.getConnection().createStatement(); //Importante 3
        rs = stmt.executeQuery("SELECT * from PRODUCTOS");
        
        while (rs.next()) { //Importante 5
            listproduc[k] = new Product();
            listproduc[k].setProductname(rs.getString("NOMBRE"));
            listproduc[k++].setId(i);
            
        }
        dbConn.closeConnection();
//       for (int i = 0; i < 10; i++) {
//            cliente[i] = new Customer();
//            cliente[i].setName(Integer.toString(i));
//            cliente[i].setId(i);
//        }
       
    }
    public Ventas() throws SQLException {
        
        //String xd [] = {"Jorge Papacito", "Jontahan Master"};
        
        cargarinformacion();
        new JFrame("Ventas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (getSize().width / 2);
        int y = (screenSize.height / 2) - (getSize().height / 2);
        setLocation(x, y);

        jPanel = new JPanel();
        jPanel.setLayout(null);

        jCliente = new JComboBox(getNames());
        jCliente.setBounds(30, 30, 325, 25);
        jPanel.add(jCliente);

        jCproducto = new JComboBox(getProduct());
        jCproducto.setBounds(30, 60, 325, 25);
        jPanel.add(jCproducto);
       
        String ColumName[]={"Producto","Cantidad","Precio","Descripcion"};
       
        
        tabla = new JTable(TablaContent, ColumName);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        TableColumn jona = new tabla.getColumn("Producto");
        JScrollPane jscroll = new JScrollPane(tabla);
        
        jscroll.setBounds(90, 150, 500, 200);
        
//        jPanel.add(tabla);
        jPanel.add(jscroll);
        
        jbagregar=new JButton("Agregar");
        jbagregar.setBounds(400,100 , 100, 23);
        jbagregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TableModel model = (TableModel)tabla.getModel();
                
               // for (int j = 0; j < 4; j++) {
                    //for (int l = 0; l < 4; l++) {
                        //TablaContent [j][l] = new String("udwfhfd");
                        model.setValueAt(listproduc[jCproducto.getSelectedIndex()].getProductname(), 0, 0);
                        model.setValueAt(listproduc[jCproducto.getSelectedIndex()].getPrice(), 0, 2);
            }  
                //}
                
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //}
        });
        jPanel.add(jbagregar);
         add(jPanel);
        setVisible(true);

    }

    public static void main(String[] args) throws SQLException {
        Ventas vnt = new Ventas();
        // TODO code application logic here
    }

}
