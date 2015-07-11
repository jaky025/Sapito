/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package direccion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Oscar Gabriel
 */
public class DetalleCompra {

    public JFrame jFrame;
    public JPanel jPanel;

    public DetalleCompra() {

        String titulo = "Detalle de Compra";
        jFrame = new JFrame(titulo);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);

        JLabel etiqueta = new JLabel("Orden de Compra");
        etiqueta.setBounds(250, 25, 300, 50);
        etiqueta.setFont(new Font("Verdana", Font.BOLD, 30));
        etiqueta.setForeground(Color.BLACK);

        ImageIcon imagen = new ImageIcon(getClass().getResource("/direccion/compra.png"));
        JLabel image = new JLabel(imagen);
        image.setBounds(50, 50, 200, 150);

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

        String columnas[] = {"Número de Línea", "Nombre del Producto", "Cantidad", "Precio Unitario", "Subtotal"};
        String contenido[][] = {
            {"01", "", "", "", ""},
            {"02", "", "", "", ""},
            {"03", "", "", "", ""},
            {"04", "", "", "", ""},
            {"05", "", "", "", ""},
            {"06", "", "", "", ""}
        };

        JLabel no_sol = new JLabel("No. Solicitud:");
        no_sol.setBounds(350, 100, 150, 30);
        
        JLabel no_sol1 = new JLabel();
        no_sol1.setBounds(375, 100, 150, 30);

        JLabel fecha = new JLabel("Fecha:");
        fecha.setBounds(350, 150, 150, 30);
        
        JLabel fecha1 = new JLabel();
        fecha1.setBounds(375, 150, 150, 30);

        JLabel estatus = new JLabel("Estatus:");
        estatus.setBounds(550, 100, 150, 30);
        
        JLabel estatus1 = new JLabel();
        estatus1.setBounds(575, 100, 150, 30);

        JLabel iva_label = new JLabel("IVA:");
        iva_label.setBounds(600, 400, 150, 30);
        
        JLabel iva_label1 = new JLabel();
        iva_label1.setBounds(625, 400, 150, 30);

        JLabel total_label = new JLabel("Total:");
        total_label.setBounds(600, 450, 150, 30);
        
        JLabel total_label1 = new JLabel();
        total_label1.setBounds(625, 450, 150, 30);

        JButton aprobar = new JButton("Aprobar");
        aprobar.setBounds(100, 450, 150, 30);

        JButton denegar = new JButton("Denegar");
        denegar.setBounds(300, 450, 150, 30);

        JTable tabla = new JTable(contenido, columnas);

        JScrollPane jScrollPane = new JScrollPane(tabla);
        jScrollPane.setBounds(50, 200, 650, 200);

        jPanel = new JPanel();
        jPanel.setLayout(null);

        jPanel.add(etiqueta);
        jPanel.add(image);
        jPanel.add(no_sol);
        jPanel.add(no_sol1);
        jPanel.add(fecha);
        jPanel.add(fecha1);
        jPanel.add(estatus);
        jPanel.add(estatus1);
        jPanel.add(iva_label);
        jPanel.add(iva_label1);
        jPanel.add(total_label);
        jPanel.add(total_label1);
        jPanel.add(jScrollPane);
        jPanel.add(aprobar);
        jPanel.add(denegar);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(jPanel);
        jFrame.setVisible(true);

    }
}
