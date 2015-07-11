/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import Compras.DataBaseManager;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Date;

/**
 *
 * @author Rulo
 */
public class AltaProveedor extends JPanel {

    private PreparedStatement pS;
    private PreparedStatement pS2;
    private ResultSet resultSet;
    private ResultSet rs2;
    private ResultSet rs;
    private String id;
    JFrame jFrame;
    JPanel jPanel;
    Connection conn;
    Statement stmt;
    JTextField Tid = new JTextField();
    JComboBox jComboBox;
    JTextField Trazon, Trfc, Ttel, Tcorreo, Tcalle, Tnumeroint, Tnumeroext, Tcolonia, Tcodigop, Tmunicipio, Tnombre, Tapaterno, Tamaterno;

    public AltaProveedor() {
        String jFrameTitle = "ALTA PROVEEDORES";
        jFrame = new JFrame(jFrameTitle);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation((screenSize.width / 2) - (jFrame.getSize().width / 2), (screenSize.height / 2) - (jFrame.getSize().height / 2));

        jPanel = new JPanel(); // se instancia el Panel
        jPanel.setLayout(null); //es donde escribiremos nuestros requerimientos

        JLabel personf = new JLabel("Ingrese Datos");
        personf.setBounds(340, 15, 200, 23);

        JLabel Lrazon = new JLabel("Razón Social");
        Lrazon.setBounds(10, 65, 200, 23);
        Trazon = new JTextField();
        Trazon.setBounds(120, 65, 200, 23);
        Trazon.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if (Trfc.getText().length() >= 15) {
                    ke.consume();
                }
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á'
                        && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' &&car!='.'&& car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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

        JLabel Lrfc = new JLabel("RFC");//Acepta letras mayúsculas y números
        Lrfc.setBounds(390, 65, 200, 23);
        Trfc = new JTextField();
        Trfc.setBounds(500, 65, 200, 23);
        Trfc.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if (Trfc.getText().length() >= 13) {
                    ke.consume();
                }
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
        Ltel.setBounds(390, 95, 200, 23);
        Ttel = new JTextField();
        Ttel.setBounds(500, 95, 200, 23);
        Ttel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if (Ttel.getText().length() >= 10) {
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

        JLabel Lcorreo = new JLabel("E-mail"); 
        Lcorreo.setBounds(10, 95, 200, 23);
        Tcorreo = new JTextField();
        Tcorreo.setBounds(120, 95, 200, 23);
//        Tcorreo.addKeyListener(new KeyListener() {
//
//            @Override
//            public void keyTyped(KeyEvent ke) {
//               
//            }
//
//            @Override
//            public void keyPressed(KeyEvent ke) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void keyReleased(KeyEvent ke) {
//                char car = ke.getKeyChar();
//                if (Tcalle.getText().length() >= 15) {
//                    ke.consume();
//                }
//            }
//        });
//        
        JLabel Ldireccion = new JLabel("Dirección");
        Ldireccion.setBounds(40, 155, 200, 23);

        JLabel Lcalle = new JLabel("Calle"); //Acepta sólo letras
        Lcalle.setBounds(10, 185, 200, 23);
        Tcalle = new JTextField();
        Tcalle.setBounds(120, 185, 200, 23);
        Tcalle.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if (Tcalle.getText().length() >= 15) {
                    ke.consume();
                }
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á'
                        && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' && car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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

        JLabel Lnumeroint = new JLabel("Núm. Int.");//Acepta números
        Lnumeroint.setBounds(390, 185, 200, 23);
        Tnumeroint = new JTextField();
        Tnumeroint.setBounds(500, 185, 200, 23);
        Tnumeroint.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if (Trfc.getText().length() >= 10) {
                    ke.consume();
                }
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á'
                        && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' && car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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

        JLabel Lnumeroext = new JLabel("Núm. Ext.");//Acepta números
        Lnumeroext.setBounds(390, 215, 200, 23);
        Tnumeroext = new JTextField();
        Tnumeroext.setBounds(500, 215, 200, 23);
        Tnumeroext.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if (Trfc.getText().length() >= 10) {
                    ke.consume();
                }
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á'
                        && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' && car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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
        Lcolonia.setBounds(10, 215, 100, 20);
        Tcolonia = new JTextField();
        Tcolonia.setBounds(120, 215, 200, 23);
        Tcolonia.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if (Tcolonia.getText().length() >= 25) {
                    ke.consume();
                }
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á'
                        && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' && car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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

        JLabel Lcodigop = new JLabel("C.P.");//Acepta sólo 5 números
        Lcodigop.setBounds(390, 245, 100, 20);
        Tcodigop = new JTextField();
        Tcodigop.setBounds(500, 245, 200, 23);
        Tcodigop.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                if (Tcodigop.getText().length() >= 5) {
                    ke.consume();
                }
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
        Lmunicipio.setBounds(10, 245, 200, 23);
        Tmunicipio = new JTextField();
        Tmunicipio.setBounds(120, 245, 200, 23);
        Tmunicipio.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if (Tmunicipio.getText().length() >= 30) {
                    ke.consume();
                }
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á'
                        && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' && car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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
        Lestado.setBounds(10, 275, 200, 23);
        String items[] = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila", "Colima", "Durango",
            "Estado de México", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla",
            "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas"};
        jComboBox = new JComboBox(items);
        //jComboBox.setName("ComboBox");
        jComboBox.setBounds(120, 275, 200, 23);
        //jComboBox.addActionListener(new ComboBoxListener(jComboBox));

        JLabel Lcontacto = new JLabel("Contacto");
        Lcontacto.setBounds(40, 310, 200, 23);

        JLabel Lnombre = new JLabel("Nombre(s)");//Acepta sólo letras y espacio
        Lnombre.setBounds(10, 345, 200, 23);
        Tnombre = new JTextField();
        Tnombre.setBounds(120, 345, 200, 23);
        Tnombre.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if (Tnombre.getText().length() >= 25) {
                    ke.consume();
                }
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á'
                        && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' && car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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

        JLabel Lapaterno = new JLabel("Apellido Paterno");//Acepta sólo letras y espacio
        Lapaterno.setBounds(390, 345, 200, 23);
        Tapaterno = new JTextField();
        Tapaterno.setBounds(500, 345, 200, 23);
        Tapaterno.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if (Tapaterno.getText().length() >= 25) {
                    ke.consume();
                }
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á'
                        && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' && car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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
        Lamaterno.setBounds(10, 380, 200, 23);
        Tamaterno = new JTextField();
        Tamaterno.setBounds(120, 380, 200, 23);
        Tamaterno.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if (Tamaterno.getText().length() >= 25) {
                    ke.consume();
                }
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á'
                        && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' && car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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

        JButton guardar = new JButton("Guardar");
        guardar.setBounds(510, 440, 150, 30);
        guardar.addActionListener(new ActionListener() {
            //private Object ex;
            //private Component rootPane;

            @Override
            public void actionPerformed(ActionEvent ae) {
                String nombre = Tnombre.getText();
                String ap = Tapaterno.getText();
                String am = Tamaterno.getText();
                String rfc = Trfc.getText();
                String tel = Ttel.getText();
                String mail = Tcorreo.getText();
                String calle = Tcalle.getText();
                String numint = Tnumeroint.getText();
                String numext = Tnumeroext.getText();
                String cp = Tcodigop.getText();
                String estado = (String) jComboBox.getSelectedItem();
                String municipio = Tmunicipio.getText();
                String colonia = Tcolonia.getText();
                String razon = Trazon.getText();
                String a[] = {razon, rfc, mail, tel, calle, numint, colonia, numext, municipio, cp, estado, nombre, ap, am,};
                if (lleno() == false) {
                    Compra Obc = new Compra();
                    String b[] = {"Razon Social", "RFC", "E-mail", "Telefono", "Calle", "Número Interior", "Colonia", "Número Exterior", "Municipio", "Codigo Postal", "Estado", "Nombre", "Apellido Paterno", "Apellido Materno"};
                    int k = Obc.verifica(a);
                    System.out.println(k);
                    JOptionPane.showMessageDialog(null, "El campo " + b[k] + " esta vacio\nDebe llenarlo", "ALERTA", JOptionPane.ERROR_MESSAGE);
                } else {
                    MetodosBd OBinsprov = new MetodosBd();
                    int id = 0;
                    try {
                        id = (OBinsprov.idGenerar()) + 1;
                        OBinsprov.insertProv(id, nombre, ap, am, rfc, tel, mail, calle, numint, numext, cp, estado, municipio, colonia, razon);
                        limpiar();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "registro no guardado", "ERROR...", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(AltaProveedor.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        });

        JButton back = new JButton("Regresar");
        back.setBounds(80, 440, 150, 30);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Proveedores OProv = new Proveedores();
                jFrame.dispose();
            }

        });

        JButton Bcancelar = new JButton("Limpiar");
        Bcancelar.setBounds(300, 440, 150, 30);
        Bcancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                limpiar();
            }
        });

        jPanel.add(personf);
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
        jPanel.add(Lnumeroint);
        jPanel.add(Lnumeroext);
        jPanel.add(Tnumeroint);
        jPanel.add(Tnumeroext);
        jPanel.add(Lcolonia);
        jPanel.add(Tcolonia);
        jPanel.add(Lcodigop);
        jPanel.add(Tcodigop);
        jPanel.add(Lmunicipio);
        jPanel.add(Tmunicipio);
        jPanel.add(jComboBox);
        jPanel.add(Lestado);
        jPanel.add(Lcontacto);
        jPanel.add(Lnombre);
        jPanel.add(Tnombre);
        jPanel.add(Lapaterno);
        jPanel.add(Tapaterno);
        jPanel.add(Lamaterno);
        jPanel.add(Tamaterno);
        jPanel.add(guardar);
        jPanel.add(Bcancelar);
        jPanel.add(back);

        jFrame.add(jPanel);
        jFrame.setVisible(true); // se hace visible el frame

    }

    public void limpiar() {
        Tid.setText("");
        Trazon.setText("");
        Trfc.setText("");
        Ttel.setText("");
        Tcorreo.setText("");
        Tcalle.setText("");
        Tnumeroint.setText("");
        Tnumeroext.setText("");
        Tcolonia.setText("");
        Tcodigop.setText("");
        Tmunicipio.setText("");
        Tnombre.setText("");
        Tapaterno.setText("");
        Tamaterno.setText("");
    }

    public boolean lleno() {
        if (Trazon.getText().length() != 0
                && Trfc.getText().length() != 0
                && Ttel.getText().length() != 0
                && Tcorreo.getText().length() != 0
                && Tcalle.getText().length() != 0
                && Tnumeroint.getText().length() != 0
                && Tnumeroext.getText().length() != 0
                && Tcolonia.getText().length() != 0
                && Tcodigop.getText().length() != 0
                && Tmunicipio.getText().length() != 0
                && Tnombre.getText().length() != 0
                && Tapaterno.getText().length() != 0
                && Tamaterno.getText().length() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean llenouno() {
        if (Tid.getText().length() != 0
                || Trazon.getText().length() != 0
                || Trfc.getText().length() != 0
                || Ttel.getText().length() != 0
                || Tcorreo.getText().length() != 0
                || Tcalle.getText().length() != 0
                || Tnumeroint.getText().length() != 0
                || Tnumeroext.getText().length() != 0
                || Tcolonia.getText().length() != 0
                || Tcodigop.getText().length() != 0
                || Tmunicipio.getText().length() != 0
                || Tnombre.getText().length() != 0
                || Tapaterno.getText().length() != 0
                || Tamaterno.getText().length() != 0) {
            return true;
        } else {
            return false;
        }
    }

//    public static void main(String[] args) {
//        AltaProveedor proveedores = new AltaProveedor();
//    }

}
