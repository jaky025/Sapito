/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario;

/**
 *
 * @author daniel
 */

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ConsultasInternas extends JPanel{
    JTable jTable;
    DefaultTableModel model;
    public Object[] data;
    private String id;
     private PreparedStatement pS;
    private PreparedStatement pS2;
    private ResultSet resultSet;
     Statement stmt;
   // private ResultSet rs2;
    private ResultSet rs;
JTextField jTextField;


    public JFrame jframe;
    public JPanel jpanel;
    Connection conn;

    public ConsultasInternas() /*throws SQLException*/ {
        String jTitulo = " Consultas";
        jframe = new JFrame(jTitulo);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jframe.getSize().width / 2);
        int y = (screenSize.height / 2) - (jframe.getSize().height / 2);
        jframe.setLocation(x, y);
        ///////////////////  panel

        String tloP = "Consultas";
        jpanel = new JPanel();
        jpanel.setSize(300, 300);
        jpanel.setLayout(null);

        

        JMenuBar bar = new JMenuBar();

        JMenu jMenu = new JMenu("Menu");
        JMenu jMenu2 = new JMenu("Ayuda");

        JMenuItem es2 = new JMenuItem("Por Id");
        JMenuItem es3 = new JMenuItem("Por Nombre");

        jMenu.add(es2);
        jMenu.add(es3);
        bar.add(jMenu);
        bar.add(jMenu2);

        // etiqueta generar inventario
        String etiqueta11 = " Consulta";
        JLabel jLabel11 = new JLabel(etiqueta11);
        jLabel11.setBounds(350, 35, 200, 23);

        //   Generar y ubicar una etiqueta
        String etiqueta = "Id: ";
        JLabel jLabel = new JLabel(etiqueta);
        jLabel.setBounds(100, 80, 200, 23);
         jTextField = new JTextField(" ");
        jTextField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < '0' || car > '9')) {
                    ke.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        jTextField.setBounds(100, 120, 200, 23);
        JButton con_id = new JButton("Consultar");
        con_id.setBounds(100, 180, 150, 30);
        
        
         String etiqueta2 = "Nombre: ";
        JLabel jLabel2 = new JLabel(etiqueta2);
        jLabel2.setBounds(410, 80, 200, 23);
        JTextField jTextField2 = new JTextField(" ");
        jTextField2.setBounds(410, 120, 200, 23);
        jTextField2.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'a' || car > 'z')) {
                    ke.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        data = new Object[100];
        model = new DefaultTableModel();
         String columnNames[] = {"Id",/*"Nombre","Unidad","Existencia","Detalles","Maximos","Minimos","Precio","Costo","Diferencia"*/};
        String tableContent[][];
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Cantidad_prod");
        model.addColumn("Unidad");
        model.addColumn("Detalles");
        model.addColumn("Precio venta");
        model.addColumn("Id prov");
        model.addColumn("Max");
        model.addColumn("Min");
       //  model.addColumn("Para venta");
        
         jTable =new JTable(model);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        JScrollPane jScrollPane = new JScrollPane(jTable);//tabla
        jScrollPane.setBounds(60, 250, 850, 200);
        
        ////////////////////////// boton de consulta o busqueda
        con_id.addActionListener(new ActionListener() 
        {
             private Component rootPane;
         @Override
                  public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(jTextField.getText().length()>0){
                   id = jTextField.getText();
                   this.consulta(id);
                }else JOptionPane.showMessageDialog(rootPane, "Debe ingresar un ID de Proveedor");

            }

        
             private void consulta(String id)/* throws SQLException*/ {
             try {
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sapito", "sapito");
                    stmt = conn.createStatement();
                    System.out.println("Conexion realizada");
                    pS = conn.prepareStatement("select id_producto from PRODUCTOS2 where id_producto =?");
                    
                     pS.setString(1, id);
                    rs = pS.executeQuery();
                    System.out.println(rs);
                    //s
                      if (rs.next()) {
                        //el .next sirve para pasarnos a otra tupla

    pS = conn.prepareStatement("select nombre,cantidad_prod,unidad_medida,detalles,precio_venta,id_proveedor,m_ax,m_in,para_venta   from PRODUCTOS2 where id_producto =?");
                        pS.setString(1, id);
                         resultSet = pS.executeQuery();
                         
                           while (resultSet.next()) {

//                            jTextField2.setText(resultSet.getString("nombre"));
//                            jTextField2.setEditable(false);
                              // jTextField2.setText(resultSet.getString("nombre"));
                              
                                // data[0]=jTextField2.getText();
                               data[0]=jTextField.getText();
                                 data[1]=resultSet.getString("nombre");
                                 data[2]=resultSet.getString("cantidad_prod");
                                 data[3]=resultSet.getString("unidad_medida");
                                 data[4]=resultSet.getString("detalles");
                                 data[5]=resultSet.getString("precio_venta");
                                 //data[6]=null;
                                 data[6]=resultSet.getString("id_proveedor");
                                 data[7]=resultSet.getString("m_ax");
                                 data[8]=resultSet.getString("m_in");
                                 data[9]=resultSet.getString("para_venta");
                                 
                                 model.addRow(data);
                                 
                           }
                            
                  JOptionPane.showMessageDialog(rootPane, "Muy bien entraste", "CORRECTO!!", JOptionPane.ERROR_MESSAGE);

                      }
                      else {
                        //JOptionPane.showMessageDialog(rootPane, "VERIFIQUE SU ID", "Error!! ", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(rootPane, "Verifique Id por favor", "Error!!", JOptionPane.ERROR_MESSAGE);
                    }
                     } catch (SQLException ex) {
                    System.out.println("X: " + ex);
                }
             }
                 

        });

       

        JButton con_nom = new JButton("Consultar");
        con_nom.setBounds(410, 180, 150, 30);
        con_nom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton Reg = new JButton("Regresar");
        Reg.setBounds(600, 470, 150, 30);
        Reg.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                jframe.dispose();
            }
        });

        jpanel.add(jScrollPane);
        jpanel.add(con_nom);
        jpanel.add(Reg);
        jpanel.add(jLabel);
        jpanel.add(jLabel2);
        jpanel.add(jLabel11);
        jpanel.add(jTextField);
       jpanel.add(jTextField2);
        jpanel.add(con_id);
        jframe.setJMenuBar(bar);
        jframe.add(jpanel);
        jframe.setVisible(true);

    }

    public static void main(String[] args) throws SQLException {
        ConsultasInternas con = new ConsultasInternas();
    }

}
