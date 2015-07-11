package Compras;

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
import java.awt.*;
import java.sql.DriverManager;
import javax.swing.*;
import java.sql.*;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Rulo
 */
public class ConsultarProveedor extends JPanel {

    private PreparedStatement pS;
    private PreparedStatement pS2;
    private ResultSet resultSet;
    private ResultSet rs2;
    private ResultSet rs;
    Connection conn;
    Statement stmt;
    
    private String id;
    JFrame jFrame;
    JPanel jPanel;
    JTextField Trazon, Trfc, Tgiro, Ttel, Tcorreo, Tcalle, Tnumint,Tnumext, Tcolonia, Tcodigop, Tmunicipio, Tnombre, Tapaterno, Tamaterno;
    JTextField Tid = new JTextField();
    JTextField Testado = new JTextField();
    JComboBox jComboBox;

    public ConsultarProveedor() {
        String jFrameTitle = "CONSULTAR PROVEEDORES";
        jFrame = new JFrame(jFrameTitle);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation((screenSize.width / 2) - (jFrame.getSize().width / 2), (screenSize.height / 2) - (jFrame.getSize().height / 2));
        JLabel Lid = new JLabel("ID");
        add(Lid);
        add(Tid);
       
        Lid.setBounds(10, 10, 100, 30);
        Tid.setBounds(30, 15, 200, 23);
        Tid.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if (Tid.getText().length() >= 10) {
                    ke.consume();
                }
                if (x < '0' || x > '9') {
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
        JButton b_busc = new JButton("Buscar");
        jPanel = new JPanel(); // se instancia el Panel
        jPanel.setLayout(null); //es donde escribiremos nuestros requerimientos
        add(b_busc);
        b_busc.setBounds(260, 10, 90, 28);

        add(Testado);
        Testado.setBounds(120, 270, 200, 23);

        JLabel Lrazon = new JLabel("Razón Social");
        Lrazon.setBounds(10, 55, 200, 23);
        Trazon = new JTextField();
        Trazon.setBounds(120, 55, 200, 23);

        JLabel Lrfc = new JLabel("RFC");//Acepta letras mayúsculas y números
        Lrfc.setBounds(390, 55, 200, 23);
        Trfc = new JTextField();
        Trfc.setBounds(500, 55, 200, 23);
        Trfc.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'A' || car > 'Z') && (car < '0' || car > '9')) {
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

        JLabel Ltel = new JLabel("Telefono");//Acepta sólo números
        Ltel.setBounds(390, 85, 200, 23);
        Ttel = new JTextField();
        Ttel.setBounds(500, 85, 200, 23);
        Ttel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if (x < '0' || x > '9') {
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

        JLabel Lcorreo = new JLabel("E-mail");
        Lcorreo.setBounds(10, 85, 200, 23);
        Tcorreo = new JTextField();
        Tcorreo.setBounds(120, 85, 200, 23);

        JLabel Ldireccion = new JLabel("Dirección");
        Ldireccion.setBounds(40, 145, 200, 23);

        JLabel Lcalle = new JLabel("Calle"); //Acepta sólo letras
        Lcalle.setBounds(10, 175, 200, 23);
        Tcalle = new JTextField();
        Tcalle.setBounds(120, 175, 200, 23);
        Tcalle.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á' && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' && car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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

        JLabel Lnumint = new JLabel("Núm. Int.");//Acepta números
        Lnumint.setBounds(390, 175, 200, 23);
        Tnumint = new JTextField();
        Tnumint.setBounds(500, 175, 200, 23);
        Tnumint.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if (x < '0' || x > '9') {
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

        JLabel Lnumext = new JLabel("Núm. ext.");//Acepta números
        Lnumext.setBounds(390, 205, 200, 23);
        Tnumext = new JTextField();
        Tnumext.setBounds(500, 205, 200, 23);
        Tnumext.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if (x < '0' || x > '9') {
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

        JLabel Lcolonia = new JLabel("Colonia");//Acepta sólo letras
        Lcolonia.setBounds(10, 205, 100, 20);
        Tcolonia = new JTextField();
        Tcolonia.setBounds(120, 205, 200, 23);
        Tcolonia.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á' && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' && car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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

        JLabel Lcodigop = new JLabel("C.P.");//Acepta sólo números
        Lcodigop.setBounds(390, 235, 100, 20);
        Tcodigop = new JTextField();
        Tcodigop.setBounds(500, 235, 200, 23);
        Tcodigop.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if (x < '0' || x > '9') {
                    ke.consume();
                }
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

        JLabel Lmunicipio = new JLabel("Municipio"); //Acepta solo letras
        Lmunicipio.setBounds(10, 235, 200, 23);
        Tmunicipio = new JTextField();
        Tmunicipio.setBounds(120, 235, 200, 23);
        Tmunicipio.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á' && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' && car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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
        
        JLabel Lestado = new JLabel("Estado");
        Lestado.setBounds(10, 270, 200, 23);
        String items[] = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila", "Colima", "Durango",
            "Estado de México", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla",
            "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas"};
        jComboBox = new JComboBox(items);
        //jComboBox.setName("ComboBox");
        jComboBox.setBounds(120, 275, 200, 23);

        JLabel Lcontacto = new JLabel("Contacto");
        Lcontacto.setBounds(40, 300, 200, 23);

        JLabel Lnombre = new JLabel("Nombre(s)");//Acepta sólo letras y espacio
        Lnombre.setBounds(10, 325, 200, 23);
        Tnombre = new JTextField();
        Tnombre.setBounds(120, 325, 200, 23);
        Tnombre.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á' && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' && car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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

        JLabel Lapaterno = new JLabel("Apellido Paterno");//Acepta sólo letras y espacio
        Lapaterno.setBounds(390, 325, 200, 23);
        Tapaterno = new JTextField();
        Tapaterno.setBounds(500, 325, 200, 23);
        Tapaterno.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á' && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' && car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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

        JLabel Lamaterno = new JLabel("Apellido Materno");//Acepta sólo letras y espacio
        Lamaterno.setBounds(10, 370, 200, 23);
        Tamaterno = new JTextField();
        Tamaterno.setBounds(120, 370, 200, 23);
        Tamaterno.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á' && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' && car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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

        JButton back = new JButton("Regresar");
        back.setBounds(90, 450, 150, 30);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Proveedores OProv = new Proveedores();
                jFrame.dispose();
            }

        });

        JButton Mod = new JButton("Modificar");
        Mod.setBounds(300, 450, 150, 30);
        Mod.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(Tid.getText().length()>0){
                 habilitar();
                }else{
                    JOptionPane.showMessageDialog(null, "Ingrese un ID");
                }
            }
        });
        
        deshabilitar();
        
        JButton Bactualizar = new JButton("Guardar");
        Bactualizar.setBounds(500, 450, 150, 30);
        Bactualizar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               
                String tid = Tid.getText().toString();
                String Tnom = Tnombre.getText().toString();
                String Tap = Tapaterno.getText().toString();
                String Tam = Tamaterno.getText().toString();
                String Trf = Trfc.getText().toString();
                String Tte = Ttel.getText().toString();
                String Tcor = Tcorreo.getText().toString();
                String Tca = Tcalle.getText().toString();
                // String val_t_ne= Tnumeroext.getText().toString();
                //String Tni = Tnumeroint.getText().toString();
                //String Tne = Tnumeroint.getText().toString();
                String Tcol = Tcolonia.getText().toString();
                String Tcp = Tcodigop.getText().toString();
                String Tmun = Tmunicipio.getText().toString();
                String Testado = jComboBox.getSelectedItem().toString();
                String Trs = Trazon.getText().toString();
               

                DataBaseManager data = new DataBaseManager();

                try {
                    
                    data.openConnection();
                    PreparedStatement ps = data.getConnection().prepareStatement("update PROVEEDORES set nombre='"+Tnom+"', apellido_p='"+Tap+"',apellido_m='"+Tam+"',rfc='"+Trf+"',"
                            + "telefono='"+Tte+"',mail='"+Tcor+"',calle='"+Tca+"',colonia='"+Tcol+"',cp='"+Tcp+"',municipio='"+Tmun+"',estado='"+Testado+"',razon_social='"+Trs+"' where id_proveedor='"+tid+"'");

                    ps.execute();
                    data.closeConnection();
                    deshabilitar();
                    JOptionPane.showMessageDialog(null, "Registro Guardado En La BD", "CONFIRMACIÓN ", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    System.out.println(ex.getCause());
                }
 

            }

            private void dispose() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
                            
        jPanel.add(Lrazon);
        jPanel.add(Trazon);
        jPanel.add(Lrfc);
        jPanel.add(Trfc);
        jPanel.add(Ltel);
        jPanel.add(Ttel);
        jPanel.add(Lcorreo);
        jPanel.add(Tcorreo);
        jPanel.add(Ldireccion);
        jPanel.add(Lcalle);
        jPanel.add(Tcalle);
        jPanel.add(Lnumint);
        jPanel.add(Tnumint);
        jPanel.add(Tnumext);
        jPanel.add(Lnumext);
        jPanel.add(Lcolonia);
        jPanel.add(Tcolonia);
        jPanel.add(Lcodigop);
        jPanel.add(Tcodigop);
        jPanel.add(Lmunicipio);
        jPanel.add(Tmunicipio);
//        jPanel.add(jComboBox);
        jPanel.add(Lestado);
        jPanel.add(jComboBox);
        jPanel.add(Lcontacto);
        jPanel.add(Lnombre);
        jPanel.add(Tnombre);
        jPanel.add(Lapaterno);
        jPanel.add(Tapaterno);
        jPanel.add(Lamaterno);
        jPanel.add(Tamaterno);
        jPanel.add(back);
        jPanel.add(Mod);
        jPanel.add(b_busc);
        jPanel.add(Lid);
        jPanel.add(Tid);
        jPanel.add(Bactualizar);
        jFrame.add(jPanel);
        jFrame.setVisible(true); // se hace visible el frame
       
        b_busc.addActionListener(new ActionListener() {
            private Component rootPane;

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(Tid.getText().length()>0){
                   id = Tid.getText();
                   MetodosBd Obm = new MetodosBd();
                    Obm.consulta(id, Tid, Trazon, Trfc, Tgiro, Ttel, Tcorreo, Tcalle, Tnumint, Tnumext, Tcolonia, Tcodigop, jComboBox, Tmunicipio, Tnombre, Tapaterno, Tamaterno);            
                }else JOptionPane.showMessageDialog(rootPane, "Debe ingresar un ID de Proveedor");

            }

        });

    }
    
    public void habilitar(){
        Trazon.setEditable(true);
        Trfc.setEditable(true);
        Ttel.setEditable(true);
        Tcorreo.setEditable(true);
        Tcalle.setEditable(true);
        Tnumint.setEditable(true);
        Tnumext.setEditable(true);
        Tcolonia.setEditable(true);
        Tcodigop.setEditable(true);
        Tmunicipio.setEditable(true);
        jComboBox.setEnabled(true);
        Tnombre.setEditable(true);
        Tapaterno.setEditable(true);
        Tamaterno.setEditable(true);
        Tid.setEditable(false);
    }
    
    public void deshabilitar(){
        Trazon.setEditable(false);
        Trfc.setEditable(false);
        Ttel.setEditable(false);
        Tcorreo.setEditable(false);
        Tcalle.setEditable(false);
        Tnumint.setEditable(false);
        Tnumext.setEditable(false);
        Tcolonia.setEditable(false);
        Tcodigop.setEditable(false);
        Tmunicipio.setEditable(false);
        jComboBox.setEnabled(false);
        Tnombre.setEditable(false);
        Tapaterno.setEditable(false);
        Tamaterno.setEditable(false);
        Tid.setEditable(true);
    }
//    public static void main(String[] args) {
//        ConsultarProveedor ConPro = new ConsultarProveedor();
//    }

}
