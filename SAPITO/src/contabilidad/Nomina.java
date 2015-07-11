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
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Arturo
 */
public class Nomina extends JFrame {

    public JFrame jFrame;

    public Nomina() {
        jFrame = new JFrame("Nomina");
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
        JMenuItem jMenuItem7 = new JMenuItem("Acerca de");
        jMenuItem7.addActionListener(new MenuListener(jFrame));

        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem2);
        jMenu.add(jMenuItem3);
        jMenu2.add(jMenuItem4);
        jMenu2.add(jMenuItem5);
        jMenu2.add(jMenuItem6);
        jMenu3.add(jMenuItem7);

        jFrame.setJMenuBar(jMenuBar);

        String columnNames[] = {"ID", "Nombre", "Saldo", "Semana", "Año"};
        String tablaContent[][] = {{"123", "Arturo C.", "$40,000", "03", "2015"}};

        JTable jTable = new JTable(tablaContent, columnNames);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane jScrollpane = new JScrollPane(jTable);
        jScrollpane.setBounds(60, 20, 378, 150);

        JButton boton01 = new JButton("Liberar Pago");
        boton01.setBounds(100, 200, 150, 20);
        jPanel.add(boton01);

        JButton boton02 = new JButton("Regresar");
        boton02.setBounds(300, 200, 90, 20);
        boton02.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaGeneral es = new VentanaGeneral();
                jFrame.dispose();
            }
        });
        jPanel.add(boton02);
        jPanel.add(jScrollpane);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

//    public static void main(String[] args) {
//        Nomina simple09 = new Nomina();
//    }
}
