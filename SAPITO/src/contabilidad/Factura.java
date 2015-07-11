/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Factura extends JFrame {

    public JFrame jFrame;
    public JPanel jPanel;

    public Factura() {
        jFrame = new JFrame("Factura");
        jFrame.setDefaultCloseOperation(jFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(500, 300);
        jFrame.setLocationRelativeTo(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("X:" + screenSize.width + " Y:" + screenSize.height);
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(Color.WHITE);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Archivo");
        JMenu jMenu2 = new JMenu("Edición");
        JMenu jMenu3 = new JMenu("Ayuda");
        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu2);
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
        JMenuItem jMenuItem2 = new JMenuItem("Actualizar");
        jMenuItem2.addActionListener(new MenuListener(jFrame));
        JMenuItem jMenuItem3 = new JMenuItem("Cerrar");
        jMenuItem3.addActionListener(new MenuListener(jFrame));
        jMenuItem3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
            }
        });
        JMenuItem jMenuItem4 = new JMenuItem("Copiar");
        jMenuItem4.addActionListener(new MenuListener(jFrame));
        JMenuItem jMenuItem5 = new JMenuItem("Pegar");
        jMenuItem5.addActionListener(new MenuListener(jFrame));
        JMenuItem jMenuItem6 = new JMenuItem("Resaltar");
        jMenuItem6.addActionListener(new MenuListener(jFrame));
        JMenuItem jMenuItem7 = new JMenuItem("Acerca De");
        jMenuItem7.addActionListener(new MenuListener(jFrame));

        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem2);
        jMenu.add(jMenuItem3);
        jMenu2.add(jMenuItem4);
        jMenu2.add(jMenuItem5);
        jMenu2.add(jMenuItem6);
        jMenu3.add(jMenuItem7);

        jFrame.setJMenuBar(jMenuBar);

        JLabel boton = new JLabel("Folio:");
        boton.setBounds(10, 10, 40, 20);
        jPanel.add(boton);

        JLabel boton2 = new JLabel("Nombre:");
        boton2.setBounds(10, 30, 90, 20);
        jPanel.add(boton2);

        JLabel boton3 = new JLabel("RFC:");
        boton3.setBounds(300, 30, 90, 20);
        jPanel.add(boton3);

        JLabel boton4 = new JLabel("Producto:");
        boton4.setBounds(10, 50, 90, 20);
        jPanel.add(boton4);

        JLabel boton5 = new JLabel("Cantidad:");
        boton5.setBounds(300, 50, 90, 20);
        jPanel.add(boton5);

        JLabel boton6 = new JLabel("Fecha:");
        boton6.setBounds(400, 10, 90, 20);
        jPanel.add(boton6);

        JLabel boton7 = new JLabel("Total:");
        boton7.setBounds(300, 200, 90, 20);
        jPanel.add(boton7);

        JButton boton01 = new JButton("Regresar");
        boton01.setBounds(10, 200, 90, 20);
        boton01.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Reportes es = new Reportes();
                jFrame.dispose();
            }
        });
        JTextField q=new JTextField("");
        q.setBounds(40, 10, 90, 20);
        jPanel.add(q);
        JTextField q1=new JTextField("");
        q1.setBounds(60, 30, 90, 20);
        jPanel.add(q1);
        JTextField q2=new JTextField("");
        q2.setBounds(330, 30, 90, 20);
        jPanel.add(q2);
        JTextField q3=new JTextField("");
        q3.setBounds(70, 50, 90, 20);
        jPanel.add(q3);
        JTextField q4=new JTextField("");
        q4.setBounds(360, 50, 60, 20);
        jPanel.add(q4);
        JTextField q5=new JTextField("");
        q5.setBounds(440, 10, 60, 20);
        jPanel.add(q5);
        JTextField q6=new JTextField("");
        q6.setBounds(330, 200, 60, 20);
        jPanel.add(q6);
        jPanel.add(boton6);
        jPanel.add(boton01);

        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

//    public static void main(String[] args) {
//        Factura simple09 = new Factura();
//    }
}
