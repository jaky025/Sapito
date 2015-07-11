/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facilities;

//import facilities1.*;
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
import Conexion.DataBaseManager;


/**
 *
 * @author Jaky
 */
class Inmueble {
    public JFrame jFrame;
    public JPanel jPanel;

    public Inmueble() {

        String titulo = "Inmuebles";
        jFrame = new JFrame(titulo);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);

        JLabel etiqueta = new JLabel("Inmuebles");
        etiqueta.setBounds(250, 25, 250, 50);
        etiqueta.setFont(new Font("Verdana", Font.BOLD, 30));
        etiqueta.setForeground(Color.BLACK);
        

        String columnas[] = {"Id inmueble","Nombre","Último mantenimiento","Próximo mantenimiento"};
        String contenido[][] = {
            {"", "","",""},
            {"", "","",""},
            {"", "","",""},
            {"", "","",""},
            {"", "","",""},
            {"", "","",""}
        };

        
        JTable tabla = new JTable(contenido, columnas);

        JScrollPane jScrollPane = new JScrollPane(tabla);
        jScrollPane.setBounds(80, 100, 600, 250);
        
        JButton agrega_inm = new JButton("Agregar nuevo");
        agrega_inm.setBounds(200,500,150,30);
        agrega_inm.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                agrega_Inmuebles addinmueble = new agrega_Inmuebles();
                jFrame.dispose();
            }
        });
        
        
        
        
        JButton regresa = new JButton("Regresar");
        regresa.setBounds(400,500,150,30);
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
        jPanel.add(regresa);
        jPanel.add(agrega_inm);
        jPanel.add(jScrollPane);
        jFrame.add(jPanel);

        jFrame.setVisible(true);

    }
   
    
}
