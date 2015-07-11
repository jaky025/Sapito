/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniel
 */
public class BajaProducto extends JPanel {
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

    public BajaProducto() /*throws SQLException*/ {
        String jTitulo = " Bajas producto";
        jframe = new JFrame(jTitulo);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jframe.getSize().width / 2);
        int y = (screenSize.height / 2) - (jframe.getSize().height / 2);
        jframe.setLocation(x, y);
        ///////////////////  panel

        String tloP = "Bajas";
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
        String etiqueta11 = " Bajas";
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
        
           
        jpanel.add(jLabel);
       
        jpanel.add(jLabel11);
        jpanel.add(jTextField);
     
        jframe.setJMenuBar(bar);
        jframe.add(jpanel);
        jframe.setVisible(true);

    
}
    public static void main(String[] args) {
        BajaProducto bp=new BajaProducto();
    }

}
