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


/**
 *
 * @author Jaky
 */
class DetalleInmueble {
    public JFrame jFrame;
    public JPanel jPanel;

    public DetalleInmueble() {

        String titulo = "Detalle del Inmueble";
        jFrame = new JFrame(titulo);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);

        JLabel etiqueta = new JLabel("Detalle de Inmueble");
        etiqueta.setBounds(250, 25, 500, 100);
        etiqueta.setFont(new Font("Verdana", Font.BOLD, 30));
        etiqueta.setForeground(Color.BLACK);

        JLabel id_inm = new JLabel("Id inmueble: ");
        id_inm.setBounds(50,45,100,150);
        JLabel desc_id = new JLabel("");
        desc_id.setBounds(250,45,100,150);
        JLabel nom_inm = new JLabel ("Nombre inmueble: ");
        nom_inm.setBounds(50,55,200,200);
        JLabel des_nombre_inm = new JLabel("");
        des_nombre_inm.setBounds(250,55,200,200);
        JLabel fch_mtto = new JLabel("Fecha mantenimiento:");
        fch_mtto.setBounds(50,65,200,250);
        JLabel des_fecha_mtto = new JLabel("");
        des_fecha_mtto.setBounds(250,65,200,250);
        
        JLabel herramienta = new JLabel("Herramientas: ");
        herramienta.setBounds(50,100,200,300);
        JLabel des_herram = new JLabel("");
        des_herram.setBounds(250,100,200,300);
        
        JLabel fac_hum = new JLabel("Factor humano:");
        fac_hum.setBounds(50,135,200,350);
        JLabel des_fac_hum = new JLabel("");
        des_fac_hum.setBounds(250,135,200,350);
        
        JLabel tercero = new JLabel("Terceros: ");
        tercero.setBounds(50,165,200,400);
        JLabel des_terceros = new JLabel("");
        des_terceros.setBounds(250,165,200,400);

        JButton realizado = new JButton("Realizado");
        realizado.setBounds(100, 500, 150, 30);

        JButton reprog = new JButton("Reprogramar");
        reprog.setBounds(300, 500, 150, 30);
        reprog.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                reprogramaRep reprogRep = new reprogramaRep();
                jFrame.dispose();
                
            }

        });
        
        JButton regresa = new JButton("Regresar");
        regresa.setBounds(500,500,150,30);
        regresa.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Facilities facilities = new Facilities();
                facilities.setVisible(true);
                jFrame.dispose();
                
            }

        });
        

        

        jPanel = new JPanel();
        jPanel.setLayout(null);

        jPanel.add(etiqueta);
        jPanel.add(id_inm);
        jPanel.add(desc_id);
        jPanel.add(nom_inm);
        jPanel.add(des_nombre_inm);
        jPanel.add(fch_mtto);
        jPanel.add(des_fecha_mtto);
        jPanel.add(herramienta);
        jPanel.add(des_herram);
        jPanel.add(fac_hum);
        jPanel.add(des_fac_hum);
        jPanel.add(tercero);
        jPanel.add(des_terceros);
        jPanel.add(realizado);
        jPanel.add(reprog);
        jPanel.add(regresa);
        jFrame.add(jPanel);

        jFrame.setVisible(true);
        

    }
    
//    public static void main(String[] args) {
//        DetalleInmueble deta = new DetalleInmueble();
//    }
      
    
}
