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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Arturo
 */
public class Inversiones extends JFrame{
    JFrame jFrame;
    JPanel jPanel;
     JLabel sysfecha = new JLabel();
    public Inversiones(){
        jFrame = new JFrame("Inversiones");
        jFrame.setDefaultCloseOperation(jFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);
        jFrame.setLocationRelativeTo(null);
         jFrame.setIconImage(new ImageIcon(getClass().getResource("../imagenes/rana.jpg")).getImage());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("X:" + screenSize.width + " Y:" + screenSize.height);
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);
        
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        
        String columnNames[] = {"Descripcion","Cuenta","Importe","Amortizado","Pendiente"};
        String tablaContent[][] = {};

        JTable jTable = new JTable(tablaContent, columnNames);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn columna1 = jTable.getColumn("Descripcion");
        columna1.setMinWidth(150);
        TableColumn columna2 = jTable.getColumn("Cuenta");
        columna2.setMinWidth(150);
        TableColumn columna3 = jTable.getColumn("Importe");
        columna3.setMinWidth(150);
//        TableColumn columna4 = jTable.getColumn("Amortizaciom");
//        columna4.setMinWidth(50);
//        TableColumn columna5 = jTable.getColumn("Pendiente");
//        columna5.setMinWidth(50);
         JScrollPane jScrollpane = new JScrollPane(jTable);
        jScrollpane.setBounds(90, 150, 603, 200);
        
        Calendar fecha2 = new GregorianCalendar();
        int año = fecha2.get(Calendar.YEAR);
        int mes = fecha2.get(Calendar.MONTH);
        int dia = fecha2.get(Calendar.DAY_OF_MONTH);
        Date date = new Date();


        sysfecha.setText(dia + "/" + (mes + 1 ) + "/" + año);
       
         JLabel fecha = new JLabel("Fecha de inversion:  "+sysfecha.getText());
        fecha.setBounds(550, 10, 200, 15);
        
        JButton boton6 = new JButton("Acceptar");
        boton6.setBounds(580, 485, 150, 30);
        boton6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaGeneral es = new VentanaGeneral();
                jFrame.dispose();
            }
        });
        jPanel.add(boton6);
        
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Archivo");

        JMenu jMenu3 = new JMenu("Ayuda");
        jMenuBar.add(jMenu);

        jMenuBar.add(jMenu3);
        JMenuItem jMenuItem = new JMenuItem("Salir");
        jMenuItem.addActionListener(new MenuListener(jFrame));
        jMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaGeneral es = new VentanaGeneral();
                jFrame.dispose();
            }
        });

        JMenuItem jMenuItem7 = new JMenuItem("Acerca de");
        jMenuItem7.addActionListener(new MenuListener(jFrame));

        jMenu.add(jMenuItem);

        jMenu3.add(jMenuItem7);

        jFrame.setJMenuBar(jMenuBar);
        jPanel.add(fecha);
        jPanel.add(jScrollpane);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }
//    public static void main(String args[]){
//        Inversiones inv=new Inversiones();
//    }
}
