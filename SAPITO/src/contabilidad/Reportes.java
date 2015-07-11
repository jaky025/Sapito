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

/**
 *
 * @author Arturo
 */
public class Reportes {

    public JFrame jFrame;

    public Reportes() {
        String jFrameTitle = "Reportes";
        jFrame = new JFrame(jFrameTitle);
        jFrame.setDefaultCloseOperation(jFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);
        ;
        jFrame.setLocationRelativeTo(null);
        jFrame.setIconImage(new ImageIcon(getClass().getResource("../imagenes/rana.jpg")).getImage());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("X:" + screenSize.width + " Y:" + screenSize.height);
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        String boton = "Cuentas por Pagar";
        JButton jButton = new JButton(boton);
        jButton.setBounds(80, 390, 150, 30);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cuentaspagar es = new Cuentaspagar();
                jFrame.dispose();
            }
        });
        jPanel.add(jButton);

        String boton2 = "Cuentas a Cobrar";
        JButton jButton2 = new JButton(boton2);
        jButton2.setBounds(300, 390, 150, 30);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cuentascobrar es = new Cuentascobrar();
                } catch (SQLException ex) {
                    Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
                }
                jFrame.dispose();
            }
        });
        jPanel.add(jButton2);

        String path = "../imagenes/reportes.png";
        URL url = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(url);
        JLabel imagen = new JLabel("sdfs");
        imagen.setBounds(180, 10, 500, 367);
        imagen.setIcon(icon);
        jPanel.add(imagen);

        String boton3 = "Capital";
        JButton jButton3 = new JButton(boton3);
        jButton3.setBounds(510, 390, 150, 30);
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Capital es = new Capital();
                jFrame.dispose();
            }
        });
        jPanel.add(jButton3);

        JButton jbutton6 = new JButton("Regresar");
        jbutton6.setBounds(560, 480, 150, 30);
        jbutton6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaGeneral es = new VentanaGeneral();
                jFrame.dispose();
            }
        });
        jPanel.add(jbutton6);

        JMenuBar jMenuBar = new JMenuBar();

        JMenu jMenu = new JMenu("Inicio");

        JMenu jMenu3 = new JMenu("Ayuda");

        jMenuBar.add(jMenu);

        jMenuBar.add(jMenu3);

        JMenuItem jMenuItem = new JMenuItem("Desconectar");
        jMenuItem.addActionListener(new MenuListener(jFrame));
        jMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pass es1 = new pass();
                jFrame.dispose();
            }
        });
        JMenuItem jMenuItem3 = new JMenuItem("Salir");
        jMenuItem3.addActionListener(new MenuListener(jFrame));
        jMenuItem3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaGeneral es = new VentanaGeneral();
                jFrame.dispose();
            }
        });

        JMenuItem jMenuItem7 = new JMenuItem("Acerca De");
        jMenuItem7.addActionListener(new MenuListener(jFrame));

        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem3);

        jMenu3.add(jMenuItem7);

        jFrame.setJMenuBar(jMenuBar);

        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

//    public static void main(String[] args) {
//        Reportes simple09 = new Reportes();
//    }
}
