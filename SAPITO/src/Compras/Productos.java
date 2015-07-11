/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Rulo
 */
public class Productos extends JPanel {
    public JFrame jFrame;
    DefaultTableModel modeloT;
    public Productos(){
        String jFrameTitle = "PRODUCTOS";
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
        JMenuItem jMenuItemap= new JMenuItem("Agregar producto");
        jMenuItemap.addActionListener(new Compras.MenuListener(jFrame));
        jMenuItemap.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AltaProducto oap = new AltaProducto();
                jFrame.dispose();
            }
        });        
        JMenuItem jMenuItemcp= new JMenuItem("Consultar producto");
        jMenuItemcp.addActionListener(new Compras.MenuListener(jFrame));
        jMenuItemcp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultarProducto ocp = new ConsultarProducto();
                jFrame.dispose();
            }
        });
        
        JMenuItem jMIproveedores = new JMenuItem("Proveedores");
        JMenuItem jMenuItem7 = new JMenuItem("Acerca de");
        jMenuItem7.addActionListener(new Compras.MenuListener(jFrame));// jMenuItem7.addActionListener(new MenuListener(jFrame) {});
        jMenu.add(jMenuItem);
        jMenu.add(jMenuItemap);
        jMenu.add(jMenuItemcp);
        jMenu3.add(jMenuItem7);
        jFrame.setJMenuBar(jMenuBar);
        
        String columnNames[] = {"ID","Producto", "Precio", "U Medida","Proveedor","Existencia"};
        Object tableContent[][] = {};

//        modeloT = new DefaultTableModel(tableContent, columnNames);
//        JTable jTable = new JTable(modeloT);
//        TableColumn columna1 = jTable.getColumn("Producto");
//        columna1.setMinWidth(100);
//        TableColumn columna2 = jTable.getColumn("Precio");
//        columna2.setMinWidth(60);
//        JScrollPane jScrollPane = new JScrollPane(jTable);
//        jScrollPane.setBounds(30, 130, 520, 200);
        
        JButton Bagregarprod = new JButton("Agregar Producto");
        Bagregarprod.setBounds(100, 400, 150, 30);
        Bagregarprod.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                AltaProducto Oaprov = new AltaProducto();
                jFrame.dispose();
            }
        });
        
        JButton Bconsultarprod = new JButton("Consultar Producto");
        Bconsultarprod.setBounds(330, 400, 150, 30);
        Bconsultarprod.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                ConsultarProducto Oconprod = new ConsultarProducto();
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
        
        jPanel.add(Bagregarprod);
        jPanel.add(Bconsultarprod);
        jPanel.add(Bregresar);
 //       jPanel.add(jScrollPane);
        
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }
    
}
