/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Rulo
 */
public class ConsultarProducto extends JPanel {

    public JFrame jFrame;
    private PreparedStatement pS;
    private PreparedStatement pS2;
    private ResultSet resultSet;
    private ResultSet rs2;
    private ResultSet rs;
    private String id;

    JTextField Tid, Tnombre, Tprecio, Tdetalle, Tproveedor;
    JComboBox CBumedida;

    public ConsultarProducto() {
        String jFrameTitle = "CONSULTAR PRODUCTOS";
        jFrame = new JFrame(jFrameTitle);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation((screenSize.width / 2) - (jFrame.getSize().width / 2), (screenSize.height / 2) - (jFrame.getSize().height / 2));

        JPanel jPanel = new JPanel(); // se instancia el Panel
        jPanel.setLayout(null); //es donde escribiremos nuestros requerimientos

        JLabel Lid = new JLabel("ID Procucto");
        Lid.setBounds(80, 40, 150, 23);
        Tid = new JTextField();
        Tid.setBounds(200, 40, 150, 23);
        Tid.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if (Tid.getText().length() >= 10) {
                    ke.consume();
                }
                if (car < '0' || car > '9') {
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
        JButton Bidbusc = new JButton("Buscar");
        Bidbusc.setBounds(400, 33, 200, 30);
        Bidbusc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               if(Tid.getText().length()>0){
                MetodosBd conprod = new MetodosBd();
                id = Tid.getText();
                conprod.conProd(id, Tnombre, CBumedida, Tprecio, Tdetalle, Tproveedor);
               }else JOptionPane.showMessageDialog(null, "Ingrese un ID de producto");

            }

        });

        JLabel Lnombre = new JLabel("Nombre");
        Lnombre.setBounds(80, 105, 150, 23);
        Tnombre = new JTextField();
        Tnombre.setBounds(200, 105, 150, 23);

        JLabel Lprecio = new JLabel("Precio");
        Lprecio.setBounds(400, 105, 150, 23);
        Tprecio = new JTextField();
        Tprecio.setBounds(540, 105, 150, 23);

        JLabel Lumedida = new JLabel("Unidad de medida");
        Lumedida.setBounds(80, 165, 150, 23);
        String items[] = {"kg", "litro", "metro", "gramo", "pieza", "cm", "mm", "ml"};
        CBumedida = new JComboBox(items);
        //jComboBox.setName("ComboBox");
        CBumedida.setBounds(200, 165, 150, 23);

        JLabel Ltipo = new JLabel("Detalle");
        Ltipo.setBounds(400, 165, 150, 23);
        Tdetalle = new JTextField();
        Tdetalle.setBounds(540, 165, 150, 23);

        JLabel Lcorreo = new JLabel("Proveedor");
        Lcorreo.setBounds(80, 225, 150, 23);
        Tproveedor = new JTextField();
        Tproveedor.setBounds(200, 225, 150, 23);

        deshabilitar();

        JButton Bmodificar = new JButton("Modificar");
        Bmodificar.setBounds(500, 400, 200, 30);
        Bmodificar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               if(Tid.getText().length()>0){
                habilitar();
               }else{
                   JOptionPane.showMessageDialog(null, "Ingrese ID de producto");
               }
            }
        });
        
        JButton Bguardar = new JButton("Guardar");
        Bguardar.setBounds(285, 400, 200, 30);
        Bguardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String tid = Tid.getText();
                String Tnom = Tnombre.getText();
                String Tum = CBumedida.getSelectedItem().toString();
                String Tpr = Tprecio.getText();
                String Tdet = Tdetalle.getText();
                String Tpv = Tproveedor.getText();
               

                DataBaseManager data = new DataBaseManager();

                try {
                    data.openConnection();
                    PreparedStatement ps = data.getConnection().prepareStatement("update PRODUCTOS set nombre='" + Tnom + "', unidad_medida='" + Tum + "',precio_venta='" + Tpr + "',detalles='" + Tdet + "',"
                            + "id_proveedor='" + Tpv + "'where id_producto='"+tid+"'");

                    ps.execute();
                    data.closeConnection();
                                    JOptionPane.showMessageDialog(null, "Registro Guardado En La BD", "CONFIRMACIÓN ", JOptionPane.INFORMATION_MESSAGE);
                    deshabilitar();

                } catch (SQLException ex) {
                       System.out.println("algo paso aqui "+ex.getSQLState());
                }


            }

            private void dispose() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        JButton back = new JButton("Regresar");
        back.setBounds(70, 400, 200, 30);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Productos OProv = new Productos();
                jFrame.dispose();
            }

        });

        jPanel.add(Lid);
        jPanel.add(Tid);
        jPanel.add(Bidbusc);
        jPanel.add(Lnombre);
        jPanel.add(Tnombre);
        jPanel.add(Lumedida);
        jPanel.add(CBumedida);
        jPanel.add(Lprecio);
        jPanel.add(Tprecio);
        jPanel.add(Lcorreo);
        jPanel.add(Tproveedor);
        jPanel.add(Ltipo);
        jPanel.add(Tdetalle);
        jPanel.add(Bmodificar);
        jPanel.add(Bguardar);
        jPanel.add(back);

        jFrame.add(jPanel);
        jFrame.setVisible(true); // se hace visible el frame

    }

//    public static void main(String arguments[]) {
//        ConsultarProducto cP = new ConsultarProducto();
//    }
    
    public void deshabilitar(){
        Tid.setEditable(true);
        Tnombre.setEditable(false);
        CBumedida.setEnabled(false);
        Tprecio.setEditable(false);
        Tdetalle.setEditable(false);
        Tproveedor.setEditable(false);
    }
    
    public void habilitar(){
        Tid.setEditable(false);
        Tnombre.setEditable(true);
        CBumedida.setEnabled(true);
        Tprecio.setEditable(true);
        Tdetalle.setEditable(true);
        Tproveedor.setEditable(true);
    }

}
