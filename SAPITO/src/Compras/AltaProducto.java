/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import static java.awt.Component.TOP_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;//Para venta si o no consumo internoo
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Rulo
 */
public class AltaProducto extends JPanel {

    public JFrame jFrame;
    int i = 0;
    JTextField Tnombre, Tprecio, Tdetalle, Tproveedor, Tid;
    JComboBox CBumedida, CBfin;
    Connection conn;
    private Object ex;

    public AltaProducto() {
        String jFrameTitle = "DAR DE ALTA PRODUCTOS";
        jFrame = new JFrame(jFrameTitle);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation((screenSize.width / 2) - (jFrame.getSize().width / 2), (screenSize.height / 2) - (jFrame.getSize().height / 2));

        JPanel jPanel = new JPanel(); // se instancia el Panel
        jPanel.setLayout(null); //es donde escribiremos nuestros requerimientos

        JLabel Ldatos = new JLabel("Ingrese Datos");
        Ldatos.setBounds(350, 10, 200, 23);

        JLabel Lnombre = new JLabel("Nombre");
        Lnombre.setBounds(10, 65, 200, 23);
        Tnombre = new JTextField();
        Tnombre.setBounds(120, 65, 200, 23);
        Tnombre.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if (Tnombre.getText().length() >= 25) {
                    ke.consume();
                }
                if ((car < 'A' || car > 'Z') && (car < 'a' || car > 'z') && (car != (char) KeyEvent.VK_SPACE)) {
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

        JLabel Lfin = new JLabel("Fin");
        Lfin.setBounds(360, 65, 200, 23);
        String fins[]= {"para venta","para consumo"};
        CBfin = new JComboBox(fins);
        CBfin.setBounds(440, 65, 200, 23);
        JLabel Lprecio = new JLabel("Precio");
        Lprecio.setBounds(360, 105, 200, 23);
        Tprecio = new JTextField();
        Tprecio.setBounds(440, 105, 200, 23);
        Tprecio.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if (Tprecio.getText().length() >= 10) {
                    ke.consume();
                }
                if ((car < '0' || car > '9') && (car != '.')) {
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

        JLabel Lumedida = new JLabel("Unidad de medida");
        Lumedida.setBounds(10, 105, 200, 23);
        String items[] = {"kg", "litro", "metro", "gramo", "pieza", "cm", "mm", "ml"};
        CBumedida = new JComboBox(items);
        //jComboBox.setName("ComboBox");
        CBumedida.setBounds(120, 105, 200, 23);
        //jComboBox.addActionListener(new ComboBoxListener(jComboBox));

        JLabel Ldetalle = new JLabel("Detalle");
        Ldetalle.setBounds(360, 145, 200, 23);
        Tdetalle = new JTextField();
        Tdetalle.setBounds(440, 145, 200, 23);
        Tdetalle.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();

                if (Tdetalle.getText().length() >= 25) {
                    ke.consume();
                }
                if ((car < 'A' || car > 'Z') && (car < 'a' || car > 'z') && (car != (char) KeyEvent.VK_SPACE)) {
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

        JLabel Lproveedor = new JLabel("Proveedor");
        Lproveedor.setBounds(10, 145, 200, 23);
        Tproveedor = new JTextField();
        Tproveedor.setBounds(120, 145, 200, 23);
        Tproveedor.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if (Tproveedor.getText().length() >= 10) {
                    ke.consume();
                }
                if ((car < '0' || car > '9') && (car != '.')) {
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
        guardar.setBounds(380, 300, 150, 30); //botones 150x30 200x23 
        guardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                      // 1 para venta , 0 para consumo interno
                String nombre = Tnombre.getText();
                String precio = Tprecio.getText();
                String umedida = CBumedida.getSelectedItem().toString();
                String detalle = Tdetalle.getText();
                String proveedor = Tproveedor.getText();
                String cantidad = null;
                String max = null;
                String min = null;
                String pavent = null;
                if(CBfin.getSelectedItem()=="para venta"){
                    pavent="1";
                }else pavent="0";

                if (lleno() == false) {
                    String a[] = {nombre, precio, umedida, detalle, proveedor};
                    Compra Ocomp = new Compra();
                    int k = Ocomp.verifica(a);
                    String b[] = {"Nombre", "Precio", "Unidad de mdeida", "Detalle", "Proveedor"};
               JOptionPane.showMessageDialog(null, "El campo "+b[k]+" esta vacio\nDebe llenarlo", "ALERTA",JOptionPane.ERROR_MESSAGE);
                } else {
                    MetodosBd Omb = new MetodosBd();
                    int id = 0;
                    try {
                        id = Omb.idGenerarprod() + 1;
                        Omb.insertProd(id, nombre, cantidad, umedida, detalle, precio, proveedor, min, max, pavent);
                        limpiar();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "ID de proveedor no existente");
                        Logger.getLogger(AltaProducto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });

        JButton back = new JButton("Regresar");

        back.setBounds(120, 300, 150, 30);
        back.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae
                    ) {
                        Productos OProd = new Productos();
                        jFrame.dispose();
                    }

                }
        );

        jPanel.add(Ldatos);
        jPanel.add(Lnombre);
        jPanel.add(Tnombre);
        jPanel.add(Lumedida);
        jPanel.add(CBumedida);
        jPanel.add(Lfin);
        jPanel.add(CBfin);
        jPanel.add(Lprecio);
        jPanel.add(Tprecio);
        jPanel.add(Lproveedor);
        jPanel.add(Tproveedor);
        jPanel.add(Ldetalle);
        jPanel.add(Tdetalle);
        jPanel.add(guardar);
        jPanel.add(back);

        jFrame.add(jPanel);
        jFrame.setVisible(true); // se hace visible el frame
    }

    public boolean lleno() {
        if (Tnombre.getText().length() != 0
                && Tprecio.getText().length() != 0
                && Tproveedor.getText().length() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void limpiar() {
        Tnombre.setText("");
        Tprecio.setText("");
        Tdetalle.setText("");
        Tproveedor.setText("");
    }

//    public static void main(String arguments[]) {
//        AltaProducto AP = new AltaProducto();
//    }
}
