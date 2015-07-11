/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facilities;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JOptionPane;


/**
 *
 * @author Jaky
 */
class reprogramaRep extends JPanel {

    public JFrame jFrame;
    public JPanel jPanel;
    Funciones funciones = new Funciones();

    public reprogramaRep() {
        String titulo = "Reprogramar mantenimiento";
        jFrame = new JFrame(titulo);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);

        JLabel etiqueta = new JLabel("Nueva fecha: ");
        etiqueta.setBounds(250, 25, 250, 100);
        etiqueta.setFont(new Font("Verdana", Font.BOLD, 30));
        etiqueta.setForeground(Color.BLACK);

        JMenuBar jMenuBar = new JMenuBar();

        JMenu ayuda = new JMenu("Ayuda");
        jMenuBar.add(ayuda);
        
                
        JLabel calendario = new JLabel("Fecha de Operación:");
        calendario.setBounds(60, 150, 150, 30);
        
        
        final JDateChooser calend = new JDateChooser();
        calend.setBounds(200,150,150,30);
        
        JButton reprog = new JButton("Reprogramar");
        reprog.setBounds(400,150,150,30);
        reprog.addActionListener(new java.awt.event.ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(jPanel, "La fecha es: "+ funciones.getFecha(calend));
                               
            }
        });

        JButton regresa = new JButton("Regresar");
        regresa.setBounds(500, 500, 150, 30);
        regresa.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DetalleInmueble deta = new DetalleInmueble();
                jFrame.dispose();
            }

        });

        jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.add(etiqueta);
        jPanel.add(calendario);
        jPanel.add(calend);
        jPanel.add(reprog);
        jPanel.add(regresa);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(jPanel);

        jFrame.setVisible(true);

    }
       

}
