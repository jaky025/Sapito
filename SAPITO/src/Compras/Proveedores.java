/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rulo
 */
public class Proveedores extends JPanel {
    JFrame jFrame;
    JTable Tabprov = new JTable();
    DefaultTableModel Tprovmodel = new DefaultTableModel();
    
    private PreparedStatement pS;
    private PreparedStatement pS2;
    private ResultSet resultSet;
    private ResultSet rs2;
    private ResultSet rs;
    Connection conn;
    Statement stmt;
    private Object ex;
    private Component rootPane;
    
    public Proveedores(){
        String jFrameTitle = "PROVEEDORES";
        jFrame=new JFrame(jFrameTitle);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800,600);
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();    
        jFrame.setLocation((screenSize.width/2)-(jFrame.getSize().width/2),(screenSize.height/2)-(jFrame.getSize().height/2));
        
        JPanel jPanel=new JPanel();
        jPanel.setLayout(null);
        
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Archivo");
        
        JMenu jMenu3 = new JMenu("Ayuda");//
        jMenuBar.add(jMenu);        
        jMenuBar.add(jMenu3);
        JMenuItem jMenuItem = new JMenuItem("Inicio");
        jMenuItem.addActionListener(new Compras.MenuListener(jFrame));
        jMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PrincipalCompras opc = new PrincipalCompras();
                jFrame.dispose();
            }
        });
        JMenuItem jMenuItemap= new JMenuItem("Agregar Proveedoro");
        jMenuItemap.addActionListener(new Compras.MenuListener(jFrame));
        jMenuItemap.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AltaProveedor oap = new AltaProveedor();
                jFrame.dispose();
            }
        });        
        JMenuItem jMenuItemcp= new JMenuItem("Consultar Proveedor");
        jMenuItemcp.addActionListener(new Compras.MenuListener(jFrame));
        jMenuItemcp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultarProveedor ocp = new ConsultarProveedor();
                jFrame.dispose();
            }
        });
        
        JMenuItem jMenuItem7 = new JMenuItem("Acerca De");
        jMenuItem7.addActionListener(new Compras.MenuListener(jFrame));// jMenuItem7.addActionListener(new MenuListener(jFrame) {});
        jMenu.add(jMenuItem);
        jMenu.add(jMenuItemap);
        jMenu.add(jMenuItemcp);
        jMenu3.add(jMenuItem7);
        jFrame.setJMenuBar(jMenuBar);
        
        Tabprov.setModel(Tprovmodel);
        JButton Bagregarprod = new JButton("Agregar Proveedor");
        Bagregarprod.setBounds(100, 400, 150, 30);
        Bagregarprod.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                AltaProveedor Oaprov = new AltaProveedor();
                jFrame.dispose();
            }
        });
        
        JButton Bconsultarprod = new JButton("Consultar Proveedor");
        Bconsultarprod.setBounds(330, 400, 160, 30);
        Bconsultarprod.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                ConsultarProveedor Oconprov = new ConsultarProveedor();
                jFrame.dispose();
            }
        });
        
        JButton Bregresar = new JButton("Regresar");
        Bregresar.setBounds(550, 400, 150, 30);
        Bregresar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                PrincipalCompras Opc = new PrincipalCompras();
                jFrame.dispose();
            }
        });
        
        jPanel.add(Tabprov);
        jPanel.add(Bagregarprod);
        jPanel.add(Bconsultarprod);
        jPanel.add(Bregresar);

        jFrame.add(jPanel);
        jFrame.setVisible(true);
        
    }
    
//    public static void main(String arguments[]) {
//        Proveedores PR = new Proveedores();
//    }
    
}