/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
import javafx.scene.control.ComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author WW
 */
public class MenuListener implements ActionListener {
    JFrame jFrame;
    
    public MenuListener(JFrame jFrame){
        this.jFrame=jFrame;
        
    }
   
   @Override
    public void actionPerformed(ActionEvent e) {   
        System.out.println("e"+ e.getActionCommand());
        switch (e.getActionCommand()){
            case "Abrir":
                ComboBox comboBox=new ComboBox();
                break;
            case "Acerca de":
              Procesos misProcesos=new Procesos();
                misProcesos.cargarArchivo();
              break;
                        
        }
    }
    

    
  
 
}
       
    
    
