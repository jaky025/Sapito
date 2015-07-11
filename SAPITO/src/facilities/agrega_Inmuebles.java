
package facilities;


import Conexion.DataBaseManager;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class agrega_Inmuebles extends JPanel{
    JFrame jFrame;
    JPanel jPanel;
    Connection conn;
    Statement sent;
    JComboBox jComboBox;
    JComboBox jComboBoxinmueble;
    JTextField Trazon, Trfc,Tgiro,Ttel,Tcorreo,Tcalle,Tnumero,Tnumero_ext,Tcolonia,Tcodigop,Tmunicipio,Tnombre,Tapaterno,Tamaterno;
    public agrega_Inmuebles(){
        String jFrameTitle = "Agregar Inmueble";
        jFrame = new JFrame(jFrameTitle);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800,600);
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();    
        jFrame.setLocation((screenSize.width/2)-(jFrame.getSize().width/2),(screenSize.height/2)-(jFrame.getSize().height/2));
        
        
        jPanel = new JPanel(); // se instancia el Panel
        jPanel.setLayout(null); //es donde escribiremos nuestros requerimientos
        
        JLabel personf = new JLabel("Ingrese Datos");
        personf.setBounds(200, 10, 100, 30);

        
        JLabel Ldireccion = new JLabel("Dirección");
        Ldireccion.setBounds(200, 130,230,23);
        
        JLabel Lcalle = new JLabel("Calle"); //Acepta sólo letras
        Lcalle.setBounds(50,175 ,200,23);
        Tcalle = new JTextField();
        Tcalle.setBounds(140, 175, 200,23);
        Tcalle.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();       
                if((car<'a' || car>'z') && (car<'A' || car>'Z')&& car !='á' && car !='é'  && car !='í' && car !='ó' && car !='ú' && car !='Á' && car !='É' && car !='Í'               && car !='Ó'    && car !='Ú'    && car !='ñ'    && car !='Ñ' && (car!=(char)KeyEvent.VK_SPACE)){       
                    ke.consume();  
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        JLabel Lnumero = new JLabel("Número_int");//Acepta números
        Lnumero.setBounds(370,175 ,200,23);
        Tnumero = new JTextField();
        Tnumero.setBounds(450,175, 200,23);
        Tnumero.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if(x<'0'||x>'9') ke.consume();
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
         JLabel Lcodigop = new JLabel("C.P.");//Acepta sólo números
        Lcodigop.setBounds(370,255 ,200,23);
        Tcodigop = new JTextField();
        Tcodigop.setBounds(450, 255, 200,23);
        Tcodigop.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if(x<'0'||x>'9') ke.consume();
            }
            @Override
            public void keyPressed(KeyEvent ke) {
            //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        JLabel Lnumero_ext = new JLabel("Número_ext");//Acepta números
        Lnumero_ext.setBounds(370,215 ,200,23);
        Tnumero_ext = new JTextField();
        Tnumero_ext.setBounds(450, 215, 200,23);
        Tnumero_ext.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if(x<'0'||x>'9') ke.consume();
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        JLabel Lcolonia = new JLabel("Colonia");//Acepta sólo letras
        Lcolonia.setBounds(50,215 ,200,23);
        Tcolonia = new JTextField();
        Tcolonia.setBounds(140, 215, 200,23);
        Tcolonia.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();       
                if((car<'a' || car>'z') && (car<'A' || car>'Z')&& car !='á' && car !='é'  && car !='í' && car !='ó' && car !='ú' && car !='Á' && car !='É' && car !='Í'               && car !='Ó'    && car !='Ú'    && car !='ñ'    && car !='Ñ' && (car!=(char)KeyEvent.VK_SPACE)){       
                    ke.consume();  
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                
            }
        });
        
       
        
        JLabel Lmunicipio = new JLabel("Municipio"); //Acepta solo letras
        Lmunicipio.setBounds(50,255 ,200,23);
        Tmunicipio = new JTextField();
        Tmunicipio.setBounds(140, 255, 200,23);
        Tmunicipio.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();       
                if((car<'a' || car>'z') && (car<'A' || car>'Z')&& car !='á' && car !='é'  && car !='í' && car !='ó' && car !='ú' && car !='Á' && car !='É' && car !='Í'               && car !='Ó'    && car !='Ú'    && car !='ñ'    && car !='Ñ' && (car!=(char)KeyEvent.VK_SPACE)){       
                    ke.consume();  
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        JLabel Lestado = new JLabel("Entidad");
        Lestado.setBounds(50,305 ,200,23);
        String items[] = {"Aguascalientes","Baja California","Baja California Sur","Campeche","Chiapas","Chihuahua","Coahuila","Colima","Durango",
            "Estado de México","Guanajuato","Guerrero","Hidalgo","Jalisco","Michoacán","Morelos","Nayarit","Nuevo","León","Oaxaca","Puebla",
            "Querétaro","Quintana Roo","San Luis Potosí","Sinaloa","Sonora","Tabasco","Tamaulipas","Tlaxcala","Veracruz","Yucatán","Zacatecas"};
        jComboBox = new JComboBox(items);
        //jComboBox.setName("ComboBox");
        jComboBox.setBounds(140, 305, 200,23);
        
         JLabel LestadoInmueble = new JLabel("Estado fisico");
        LestadoInmueble.setBounds(370,305 ,300,23);
        String items_inmueble[] = {"Activo","Inactivo","En Remodelación"};
        jComboBoxinmueble = new JComboBox(items_inmueble);
        //jComboBox.setName("ComboBox");
        jComboBoxinmueble .setBounds(450, 305, 200,23);

        
        JLabel Lnombre = new JLabel("Nombre(s)");//Acepta sólo letras y espacio
        Lnombre.setBounds(50, 55, 200,23);
        Tnombre = new JTextField();
        Tnombre.setBounds(140, 55, 200,23);
        Tnombre.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();       
                if((car<'a' || car>'z') && (car<'A' || car>'Z')&& car !='á' && car !='é'  && car !='í' && car !='ó' && car !='ú' && car !='Á' && car !='É' && car !='Í'               && car !='Ó'    && car !='Ú'    && car !='ñ'    && car !='Ñ' && (car!=(char)KeyEvent.VK_SPACE)){       
                    ke.consume();  
                }
                //char x = ke.getKeyChar();
                //if((x<'a'||x>'z')&&(x<'A'||x>'Z')&&(x=' ')) ke.consume();
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
            
        JButton guardar = new JButton("Guardar");
        guardar.setBounds(250, 400, 100, 30);
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validaLleno() == true) {
                    System.out.println("Ok");
                    DataBaseManager obc = new DataBaseManager();
                    obc.Connection();
                    
                    
                   // int Tnumero = Integer.parseInt(campoId.getText());
                     String Tnombre1 = Tnombre.getText();
                    String Tcolonia1 = Tcolonia.getText();
                    String Tcodigop1 = Tcodigop.getText();
                    String jComboBox1 = (String) jComboBox.getSelectedItem ();
                    String jComboBoxinmueble1 = (String) jComboBoxinmueble.getSelectedItem();
                    String Tmunicipio1 = Tmunicipio.getText();
                    String Tnumero_ext1 = Tnumero_ext.getText();
                    String Tnumero1 = Tnumero.getText();
                    String Tcalle1 = Tcalle.getText();
                  
                    // genero 
                    String chalala = "insert into  inmuebles values (seq_person.nextval,'" 
                            
        
        +Tnombre1 + "','"
        +jComboBox1 + "','"
        +Tmunicipio1 + "','"
        +Tcolonia1 + "','"
        +Tcalle1 + "',"
        +Tcodigop1 + ",'"
        +Tnumero1 + "','"
        +Tnumero_ext1 + "','"
        +jComboBoxinmueble1 +"')";

                    System.out.println(chalala);
                    String Sentencia = (chalala);
                    obc.Escribir(Sentencia);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                }
            }
        });
       
            
       
        JButton Bcancelar = new JButton("Cancelar");
        Bcancelar.setBounds(450, 400, 100, 30);
        Bcancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (llenouno()==true) {
                    System.out.println("Ok");
                    limpiar();
                }else JOptionPane.showMessageDialog(null, "No ha ingresado nada");
            }
        });
        
         JButton regresa = new JButton("Regresar");
        regresa.setBounds(300,500,150,30);
        regresa.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Inmueble inmueble = new Inmueble();
                jFrame.dispose();
                
            }

        });

                
        jPanel.add(personf);
        jPanel.add(Ldireccion);
        jPanel.add(Lcalle);
        jPanel.add(Tcalle);
        jPanel.add(Lnumero);
        jPanel.add(Tnumero);
        jPanel.add(Lnumero_ext);
        jPanel.add(Tnumero_ext);
        jPanel.add(Lcolonia);
        jPanel.add(Tcolonia);
        jPanel.add(Lcodigop);
        jPanel.add(Tcodigop);
        jPanel.add(Lmunicipio);
        jPanel.add(Tmunicipio);
        jPanel.add(jComboBox);
        jPanel.add(jComboBoxinmueble);
        jPanel.add(Lestado);
        jPanel.add(LestadoInmueble);
        jPanel.add(Lnombre);
        jPanel.add(Tnombre);
        jPanel.add(guardar);
        jPanel.add(regresa);
        jPanel.add(Bcancelar);
        
        
        jFrame.add(jPanel);
        jFrame.setVisible(true); // se hace visible el frame

        
    }
    
    public boolean validaLleno() {
        
        if 
 
                (
                 Tnumero_ext.getText().isEmpty()
                ||Tnumero.getText().isEmpty()
                || Tnombre.getText().isEmpty()
                || Tcalle.getText().isEmpty()
                    || Tcolonia.getText().isEmpty()
                    || Tcodigop.getText().isEmpty()
                || Tmunicipio.getText().isEmpty()) {
            return false;
        }else return true;
    }
    
   
    
    public void limpiar(){

        Tcalle.setText("");
        Tnumero.setText("");
        Tcolonia.setText("");
        Tcodigop.setText("");
        Tnombre.setText("");
//        Tapaterno.setText("");
//        Tamaterno.setText("");
    }
    public boolean llenouno(){
        if(
                Trazon.getText().length()!=0 ||
                Trfc.getText().length()!=0 ||
                Tgiro.getText().length()!=0 ||
                Ttel.getText().length()!=0 ||
                Tcorreo.getText().length()!=0 ||
                Tcalle.getText().length()!=0 ||
                Tnumero.getText().length()!=0  ||
                Tcolonia.getText().length()!=0 ||
                Tcodigop.getText().length()!=0 ||
                Tnombre.getText().length()!=0 ||
                Tapaterno.getText().length()!=0 ||
                Tamaterno.getText().length()!=0){
            return true;
        }else return false;
    }
  
}
