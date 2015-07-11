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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Jaky
 */
class InventarioRefac {
    public JFrame jFrame;
    public JPanel jPanel;

    public InventarioRefac() {

        String titulo = "Inventario Refacciones";
        jFrame = new JFrame(titulo);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);

        JLabel etiqueta = new JLabel("Inventario de Refacciones");
        etiqueta.setBounds(200, 25, 500, 50);
        etiqueta.setFont(new Font("Verdana", Font.BOLD, 30));
        etiqueta.setForeground(Color.BLACK);
        

        String columnas[] = {"Producto","Cantidad"};
        String contenido[][] = {
            {"", ""},
            {"", ""},
            {"", ""},
            {"", ""},
            {"", ""},
            {"", ""}
        };

        
        JTable tabla = new JTable(contenido, columnas);

        JScrollPane jScrollPane = new JScrollPane(tabla);
        jScrollPane.setBounds(100, 100, 600, 250);
        
        JButton detalleRef = new JButton("Detalles");
        detalleRef.setBounds(200, 450, 150, 30);
        detalleRef.addActionListener(null);
        
        JButton regresa = new JButton("Regresar");
        regresa.setBounds(400,450,150,30);
        regresa.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Facilities facilities = new Facilities();
                jFrame.dispose();
                
            }

        });

        jPanel = new JPanel();
        jPanel.setLayout(null);

        jPanel.add(etiqueta);
        jPanel.add(detalleRef);
        jPanel.add(jScrollPane);
        jPanel.add(regresa);
        jFrame.add(jPanel);

        jFrame.setVisible(true);

    }
    
    
    
}
