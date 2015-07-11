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
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author Rulo
 */
public class PrincipalCompras extends JPanel {
    public JFrame jFrame;
    public PrincipalCompras (){
        String jFrameTitle = "MÓDULO DE COMPRAS";
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
        JMenuItem jMenuItemprod = new JMenuItem("Productos");
        jMenuItemprod.addActionListener(new Compras.MenuListener(jFrame));
        jMenuItemprod.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Productos oprod = new Productos();
                jFrame.dispose();
            }
        });
        
        JMenuItem jMenuItemprov = new JMenuItem("Proveedores");
        jMenuItemprov.addActionListener(new Compras.MenuListener(jFrame));
        jMenuItemprov.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Productos oprod = new Productos();
                jFrame.dispose();
            }
        });

        JMenuItem jMenuItemd = new JMenuItem("Desconectar");
        jMenuItemd.addActionListener(new Compras.MenuListener(jFrame));
        jMenuItemd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
            }
        });

        JMenuItem jMenuItem7 = new JMenuItem("Acerca De");
        jMenuItem7.addActionListener(new Compras.MenuListener(jFrame));// jMenuItem7.addActionListener(new MenuListener(jFrame) {});
        jMenu.add(jMenuItemprod);
        jMenu.add(jMenuItemprov);
        jMenu.add(jMenuItemd);
        jMenu3.add(jMenuItem7);
        jFrame.setJMenuBar(jMenuBar);
        
        String etiquetagencomp = "Generar Compra";
        JButton BtnGComp = new JButton(etiquetagencomp);
        BtnGComp.setBounds(50,400,150,30);
        BtnGComp.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                GenerarCompra OC = new GenerarCompra();
                jFrame.dispose();
            }
            
        });
        
        String etiquetaproveedores = "Proveedores";
        JButton BtnProv = new JButton(etiquetaproveedores);
        BtnProv.setBounds(220, 400, 150, 30);
        BtnProv.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                Proveedores OProv = new Proveedores();
                jFrame.dispose();
            }
            
        });
        
        String etiquetaprod = "Productos";
        JButton BtnProd = new JButton(etiquetaprod);
        BtnProd.setBounds(390, 400, 150, 30);
        BtnProd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                 Productos OProd = new Productos();
                 jFrame.dispose();
            }
            
        });
        
        String etiquetareportes = "Reportes";
        JButton BtnRep = new JButton(etiquetareportes);
        BtnRep.setBounds(560, 400, 150, 30);
        
        jPanel.add(BtnGComp);
        jPanel.add(BtnProv);
        jPanel.add(BtnProd);
        jPanel.add(BtnRep);
        jFrame.add(jPanel);                  
        jFrame.setVisible(true);
    }
    
    public static void main(String arguments[]) {
        PrincipalCompras PR = new PrincipalCompras();
    }
}
