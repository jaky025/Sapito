package Compras;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author K-PB-C05-L01
 */
public class ComboBox {
    JFrame jFrame;
    
    public ComboBox(){
        jFrame = new JFrame("ComboBox");
        jFrame.setSize(300, 300);
        
        
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        
        String items[] = {"Opción uno", "Opción dos"};
        JComboBox jComboBox = new JComboBox(items);
        jComboBox.setName("ComboBox");
        jComboBox.setBounds(10, 10, 100, 20);
        jComboBox.addActionListener(new ComboBoxListener(jComboBox));
        jPanel.add(jComboBox);
        
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }
    
     /*public static void main(String arguments[]) {
        ComboBox PR = new ComboBox();
    }*/
}
