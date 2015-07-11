/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rulo
 */
public class Compra {

    public Float subpart(float cant, float precio) {
        Float totalp = cant * precio;
        return totalp;
    }

    public Float totalpart(Float a) {
        float iva= (float)16/100;
        Float stop = (a) + (a * (iva));
        return stop;
    }
    
    public int verifica (String a []){
        boolean b = true;
        int i=0;
        String x;
        while (b==true && i<a.length){
            x=a[i];
            if(x.isEmpty()){
                b=false;
              System.out.println("El campo "+i+ " esta vacio");
            }
            else {
                b=true;
                i++; 
                
            }     
        }
                    return i;
    }
    
    public Double calcularTotal(int a, DefaultTableModel modeloT){
        Double totalf = 0.0;
               int renglones = modeloT.getRowCount();
                   for (int i = 0; i < renglones; i++) {
                       System.out.println(modeloT.getValueAt(i, a));
                       totalf= totalf+Double.parseDouble((String) modeloT.getValueAt(i, a));
                   }
               System.out.println(totalf);
               return totalf;

    }


}
