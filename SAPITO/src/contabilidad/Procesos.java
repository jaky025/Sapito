/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad;

import java.io.IOException;

/**
 *
 * @author Arturo
 */
public class Procesos {
    
 
   public void cargarArchivo() {
       abrir();
   }
    private void abrir() {
  //ruta del archivo en el pc
  //String file = new String("C:\\pruebaArchivo\\ArchivoPrueba.xlsx"); 
   String fileLocal = new String("src/Archivo/ManualdeUsuario.docx"); 
try{ 
 
   Runtime.getRuntime().exec("cmd /c start "+fileLocal);
     
  }catch(IOException e){
     e.printStackTrace();
  } 
}
 
  }


