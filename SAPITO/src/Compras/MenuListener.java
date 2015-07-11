/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rulo
 */
public class MenuListener implements ActionListener{
     JFrame jFrame;
    
    public MenuListener(JFrame jFrame){
        this.jFrame=jFrame;
        
    }
   
   @Override
    public void actionPerformed(ActionEvent e) {   
        System.out.println("e"+ e.getActionCommand());
        switch (e.getActionCommand()){
            case "Proveedores":
                ComboBox comboBox=new ComboBox();
                break;
            case "Acerca de":
              JOptionPane.showMessageDialog(jFrame, "se presiono acerca de", "Información", JOptionPane.ERROR_MESSAGE);
              break;
                        
        }
    }

    
}
