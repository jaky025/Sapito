/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author daniel
 */
public class Menu extends JPanel {
Inventario Inv;
    public JFrame jframe;
    public JPanel jpanel;

    public Menu() {

        jframe = new JFrame("Módulo Inventario");
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jframe.getSize().width / 2);
        int y = (screenSize.height / 2) - (jframe.getSize().height / 2);
        jframe.setLocation(x, y);

        String tloP = "Módulo Inventario";
        jpanel = new JPanel();
        jpanel.setSize(300, 300);
        jpanel.setLayout(null);

        JMenuBar bar = new JMenuBar();

        JMenu jMenu = new JMenu("Menú");
        JMenu jMenu2 = new JMenu("Ayuda");
        jMenu2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JMenu prod = new JMenu("Producto");
        JMenu es = new JMenu("E/S");
        JMenuItem es2 = new JMenuItem("Altas");
        JMenuItem es3 = new JMenuItem("Bajas");
        JMenuItem es4 = new JMenuItem("Consultas");
        JMenuItem es5 = new JMenuItem("Modificaciones");

        JMenu inter = new JMenu("Interno");
        JMenuItem inter2 = new JMenuItem("Altas");
        JMenuItem inter3 = new JMenuItem("Bajas");
        JMenuItem inter4 = new JMenuItem("Consultas");
        JMenuItem inter5 = new JMenuItem("Modificaciones");

        JMenu invenInt = new JMenu("Inventario Entradas y Salidas");
        JMenuItem invenInt2 = new JMenuItem("Nuevo");

        JMenu invenInfra = new JMenu("Inventario Interno");
        JMenuItem invenInfra2 = new JMenuItem("Nuevo");

        bar.add(jMenu);

        JLabel jLabel = new JLabel("Módulo Inventario ");
        jLabel.setBounds(350, 35, 200, 23);
        JLabel jLabel1 = new JLabel(" Selecciona opción que desea:");
        jLabel1.setBounds(70, 100, 350, 23);

        JButton InvG = new JButton("Inventario  E/S");
        InvG.setBounds(150, 200, 150, 30);
        InvG.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              Inventario   inv= new Inventario();
                jframe.dispose();
            }
        });

        JButton Con = new JButton("Consulta E/S");
        Con.setBounds(150, 300, 150, 30);
        Con.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Consultas con = new Consultas();
                jframe.dispose();
            }
        });

        JButton infra = new JButton("Inv. Infraestructura");
        infra.setBounds(450, 200, 150, 30);
        infra.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Inventario2 infraes = new Inventario2();
                jframe.dispose();
            }
        });
        
        
        JButton Ingresar = new JButton("Consulta Interna");
        Ingresar.setBounds(450, 300, 150, 30);
        Ingresar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultasInternas For = new ConsultasInternas ();
                jframe.dispose();
            }
        });

        jMenu.add(prod);
        prod.add(es);
       // es.add(es2);
       // es.add(es3);
        es.add(es4);
       // es.add(es5);
        prod.add(inter);
       // inter.add(inter2);
       // inter.add(inter3);
        inter.add(inter4);
      //  inter.add(inter5);
        jMenu.add(invenInt);
        invenInt.add(invenInt2);
        jMenu.add(invenInfra);
        invenInfra.add(invenInfra2);

        bar.add(jMenu2);

        invenInt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Inventario prInAl = new Inventario();
            }

        });
        
         invenInfra2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Inventario2 inv2 = new Inventario2();
            }

        });
        ///    producto   interno

        //JMenuItem jMenuItem6 = new JMenuItem("Pedir producto");
        // jMenuItem6.addActionListener(new MenuListener(jframe));
        inter4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Consultas prInCo = new Consultas();
            }

        });
        //JMenuItem jMenuItem7 = new JMenuItem(" Recibir producto");
        //jMenuItem7.addActionListener(new MenuListener(jframe));
        inter5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //  Modif prInMo=new Modif();
            }

        });

        //JMenuItem jMenuItem6 = new JMenuItem("Pedir producto");
        // jMenuItem6.addActionListener(new MenuListener(jframe));
        es4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Consultas prEsCo = new Consultas();
            }

        });
        //JMenuItem jMenuItem7 = new JMenuItem(" Recibir producto");
        //jMenuItem7.addActionListener(new MenuListener(jframe));
        es5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //  Modif prEsMo=new Modif();
            }

        });

        jpanel.add(jLabel);
        jpanel.add(jLabel);
        jpanel.add(jLabel1);
        jpanel.add(Con);
        jpanel.add(InvG);
        jpanel.add(Ingresar);
        jpanel.add(infra);
        jframe.setJMenuBar(bar);
        jframe.setVisible(true);
        jframe.add(jpanel);

    }

    public static void main(String[] args) {
        Menu menu = new Menu();
    }

}
