/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facilities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JTextField;

/**
 *
 * @author Jaky
 */
public class Facilities extends JPanel {

    public JFrame jFrame;
    public JPanel jPanel;

    public Facilities() {

        String titulo = "Facilities";
        jFrame = new JFrame(titulo);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);

        JLabel etiqueta = new JLabel("Facilities");
        etiqueta.setBounds(300, 25, 200, 50);
        etiqueta.setFont(new Font("Verdana", Font.BOLD, 30));
        etiqueta.setForeground(Color.BLACK);
        JMenuBar jMenuBar = new JMenuBar();
        JMenu ayuda = new JMenu("Ayuda");
        JMenuItem acerca_de = new JMenuItem("Acerca de");
        ayuda.add(acerca_de);
        jMenuBar.add(ayuda);
        
        JButton detalle_inm = new JButton ("Detalle Inmueble");
        detalle_inm.setBounds(270,350,150,30);
        detalle_inm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                DetalleInmueble detallinm = new DetalleInmueble();
                jFrame.dispose();
                
            }
        });
        
        JButton inmueble = new JButton("Inmueble");
        inmueble.setBounds(470,350,150,30);
        inmueble.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Inmueble inmueble = new Inmueble();
                jFrame.dispose();
                
            }
        });
        
        JLabel buscar_in = new JLabel("Buscar Id Inmueble:");
        buscar_in.setBounds(100, 400, 150, 30);
        JTextField busc_idinmueble = new JTextField();
        busc_idinmueble.setBounds(230, 405, 200, 23);
        
        
        JButton busca_inmueble = new JButton("Buscar");
        busca_inmueble.setBounds(470, 400, 150, 30);
        busca_inmueble.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarInmueble buscarinm = new BuscarInmueble();
            }

        });

        JButton inv_refaccion = new JButton("Inventario Refacción");
        inv_refaccion.setBounds(100, 350, 150, 30);
        inv_refaccion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                InventarioRefac inv_refacion = new InventarioRefac();
                jFrame.dispose();
                

            }

        });

        String columnas[] = {"Id_inmueble", "Nombre inmueble", "Fecha de mantenimiento"};
        String contenido[][] = {
            {"01", "nombre", "01/01/15"},
            {"02", "nombre", "01/01/15"},
            {"03", "nombre", "01/01/15"},
            {"04", "nombre", "01/01/15"},
            {"05", "nombre", "01/01/15"},
            {"06", "nombre", "01/01/15"}
        };

        JTable tabla = new JTable(contenido, columnas);

        JScrollPane jScrollPane = new JScrollPane(tabla);
        jScrollPane.setBounds(100, 100, 600, 150);

//        ventana 800x600
//        botones 150x30
        jPanel = new JPanel();
        jPanel.setLayout(null);

        jPanel.add(etiqueta);
        jPanel.add(buscar_in);
        jPanel.add(busc_idinmueble);
        jPanel.add(detalle_inm);
        jPanel.add(inmueble);
        jPanel.add(busca_inmueble);
        jPanel.add(inv_refaccion);
        jPanel.add(jScrollPane);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Facilities facilities = new Facilities();
    }
}
