/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package direccion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar Gabriel
 */
public class Direccion extends JPanel {

    public JFrame jFrame;
    public JPanel jPanel;
    public Graphics g;

    public Direccion() {

        jFrame = new JFrame("Dirección");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);

        JLabel etiqueta = new JLabel("Dirección");
        etiqueta.setBounds(300, 25, 200, 50);
        etiqueta.setFont(new Font("Verdana", Font.BOLD, 30));
        etiqueta.setForeground(Color.BLACK);

        ImageIcon imagen = new ImageIcon(getClass().getResource("/direccion/direc.png"));
        JLabel image = new JLabel(imagen);
        image.setBounds(200, 50, 350, 200);

        JLabel sol_pend = new JLabel("Solicitudes Pendientes:");
        sol_pend.setBounds(50, 200, 150, 30);

        JMenuBar jMenuBar = new JMenuBar();

        JMenu acceso = new JMenu("Acceso a");
        JMenu ayuda = new JMenu("Ayuda");

        JMenuItem rec_hum = new JMenuItem("Recursos Humanos");
        JMenuItem conta = new JMenuItem("Contabilidad");
        JMenuItem ventas = new JMenuItem("Ventas");
        JMenuItem compras = new JMenuItem("Compras");
        JMenuItem inventario = new JMenuItem("Inventario");

        JMenuItem acerca_de = new JMenuItem("Acerca de");
        acerca_de.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ayuda", "Ayuda", 3);
            }
        });

        acceso.add(rec_hum);
        acceso.add(conta);
        acceso.add(ventas);
        acceso.add(compras);
        acceso.add(inventario);

        ayuda.add(acerca_de);

        jMenuBar.add(acceso);
        jMenuBar.add(ayuda);

        JButton det_compra = new JButton("Detalle de Compra");
        det_compra.setBounds(550, 450, 150, 30);
        det_compra.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DetalleCompra dc = new DetalleCompra();
            }
        });

        JButton reportes = new JButton("Reportes");
        reportes.setBounds(50, 450, 150, 30);
        reportes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Reportes r = new Reportes();
            }
        });

        String columnas[] = {"Número de Solicitud", "Fecha de Solicitud", "Estatus", "Total"};
        String contenido[][] = {
            {"01", "", "", "", ""},
            {"02", "", "", "", ""},
            {"03", "", "", "", ""},
            {"04", "", "", "", ""},
            {"05", "", "", "", ""},
            {"06", "", "", "", ""}
        };

        JTable tabla = new JTable(contenido, columnas);

        JScrollPane jScrollPane = new JScrollPane(tabla);
        jScrollPane.setBounds(50, 250, 650, 150);

//        ventana 800x600
//        botones 150x30
        jPanel = new JPanel();
        jPanel.setLayout(null);

        jPanel.add(etiqueta);
        jPanel.add(sol_pend);
        jPanel.add(image);
        jPanel.add(reportes);
        jPanel.add(det_compra);
        jPanel.add(jScrollPane);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Direccion d = new Direccion();
    }
}
