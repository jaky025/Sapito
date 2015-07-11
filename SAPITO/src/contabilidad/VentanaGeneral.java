/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad;

import java.awt.Dimension;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Arturo
 */
public class VentanaGeneral extends JFrame {

    public JFrame jFrame;
    public JTextField jTextField;
    public JPanel jPanel;
    JLabel sysfecha = new JLabel();

    public VentanaGeneral() {

        String jFrameTitle = "Contabilidad";
        jFrame = new JFrame(jFrameTitle);
        jFrame.setDefaultCloseOperation(jFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);
        jFrame.setLocationRelativeTo(null);
        //jFrame.setIconImage(new ImageIcon(getClass().getResource("../imagenes/rana.jpg")).getImage());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("X:" + screenSize.width + " Y:" + screenSize.height);
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);
        jPanel = new JPanel();
        jPanel.setLayout(null);

        String boton = "Balance General";
        JButton jButton = new JButton(boton);
        jButton.setBounds(305, 390, 150, 30);
        jButton.isOpaque();
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Balance event = new Balance();
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaGeneral.class.getName()).log(Level.SEVERE, null, ex);
                }
                jFrame.dispose();
            }
        });
        jPanel.add(jButton);

//        String path = "../imagenes/conta.jpg";
//        URL url = this.getClass().getResource(path);
//        ImageIcon icon = new ImageIcon(url);
//        JLabel imagen = new JLabel("sdfs");
//        imagen.setBounds(250, 10, 303, 300);
//        imagen.setIcon(icon);
//        jPanel.add(imagen);

        String boton3 = "Estado Resultado";
        JButton jButton3 = new JButton(boton3);
        jButton3.setBounds(55, 390, 150, 30);
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Estado estado = new Estado();
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaGeneral.class.getName()).log(Level.SEVERE, null, ex);
                }
                    jFrame.dispose();
            }
        });

        jPanel.add(jButton3);
//        JButton boton4 = new JButton("Inversiones");
//        boton4.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Inversiones inv = new Inversiones();
//                jFrame.dispose();
//            }
//        });

//        jPanel.add(boton4);
//        boton4.setBounds(410, 390, 150, 30);
//
//        jPanel.add(boton4);

        JButton boton5 = new JButton("Reportes");
        boton5.setBounds(550, 390, 150, 30);
        boton5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Reportes reportes = new Reportes();
                jFrame.dispose();
            }
        });

        jPanel.add(boton5);

        // Calendar fecha1 = Calendar.getInstance();
        Calendar fecha2 = new GregorianCalendar();
        int año = fecha2.get(Calendar.YEAR);
        int mes = fecha2.get(Calendar.MONTH);
        int dia = fecha2.get(Calendar.DAY_OF_MONTH);
        Date date = new Date();

        sysfecha.setText(dia + "/" + (mes + 1) + "/" + año);

        JLabel fecha = new JLabel("Fecha:  " + sysfecha.getText());
        fecha.setBounds(650, 10, 150, 15);

        jPanel.add(fecha);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Inicio");
        JMenu jMenu2 = new JMenu("Estadode Resultado");
        JMenu jMenu3 = new JMenu("Balance General");
        JMenu jMenu4 = new JMenu("Inversiones");
        JMenu jMenu5 = new JMenu("Reporte");
        JMenu jMenu6 = new JMenu("Ayuda");
        
        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu6);
        
        JMenuItem jMenuItem = new JMenuItem("Desconectar");
        jMenuItem.addActionListener(new MenuListener(jFrame));
        jMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pass es1 = new pass();
                jFrame.dispose();
            }
        });
        

        JMenuItem jMenuItem7 = new JMenuItem("Acerca De");
        jMenuItem7.addActionListener(new MenuListener(jFrame));

        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem);
        
        jMenu6.add(jMenuItem7);

        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(jPanel);
        jFrame.setVisible(true);

    }

//    public static void main(String[] args) {
//        VentanaGeneral simple09 = new VentanaGeneral();
//    }
}
