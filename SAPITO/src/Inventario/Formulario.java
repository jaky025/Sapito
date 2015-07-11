/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jessica
 */
public class Formulario {

    public JFrame jframe;
    public JPanel jPanel;
    public Object[] data;
    public JPanel jpanel;
    JTextField jTextField;
    JTextField jTextField2;
    JTextField jTextField3;
    JTextField jTextField4;
    JTextField jTextField5;
    JTextField jTextField66;
    JTextField jTextField7;
    JTextField jTextField8;
    JTextField jTextField9;
    DefaultTableModel model;
    JTable jTable;
    

    public Formulario() {
        String jTitulo = "Formulario";
        jframe = new JFrame(jTitulo);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jframe.getSize().width / 2);
        int y = (screenSize.height / 2) - (jframe.getSize().height / 2);
        
       
        jPanel=new JPanel();
        jPanel.setLayout(null);
        
        JLabel jLabel11 = new JLabel("Ingresa la información");
        jLabel11.setBounds(50, 10, 200, 20);


        JLabel jLabel = new JLabel("ID");
        jLabel.setBounds(10, 30, 200, 20);
        jTextField = new JTextField(" ");
        jTextField.setBounds(200, 30, 90, 20);
        
        
        JLabel jLabel2 = new JLabel("Nombre");
        jLabel2.setBounds(10, 50, 200, 20);
        jTextField2 = new JTextField(" ");
        jTextField2.setBounds(200, 50, 90, 20);
       
        
        JLabel jLabel3 = new JLabel("Unidad de medida");
        jLabel3.setBounds(10, 70, 200, 20);
        jTextField3 = new JTextField(" ");
        jTextField3.setBounds(200, 70, 90, 20);
        
        
        JLabel jLabel4 = new JLabel("Existencia");
        jLabel4.setBounds(10, 90, 200, 20);
        jTextField4 = new JTextField(" ");
        jTextField4.setBounds(200, 90, 90, 20);
       
        
        JLabel jLabel5 = new JLabel("Detalles");
        jLabel5.setBounds(10, 110, 200, 20);
        jTextField5 = new JTextField(" ");
        jTextField5.setBounds(200, 110, 90, 20);
        
        
        JLabel jLabel6 = new JLabel("Máximo");
        jLabel6.setBounds(10, 130, 200, 20);
        jTextField66 = new JTextField(" ");
        jTextField66.setBounds(200, 130, 90, 20);

        
        JLabel jLabel7 = new JLabel("Minimo");
        jLabel7.setBounds(10, 150, 200, 20);
        jTextField7 = new JTextField(" ");
        jTextField7.setBounds(200, 150, 90, 20);

        
        JLabel jLabel8 = new JLabel("Precio");
        jLabel8.setBounds(10, 170, 200, 20);
        jTextField8 = new JTextField(" ");
        jTextField8.setBounds(200, 170, 90, 20);

        
        JLabel jLabel9 = new JLabel("Costo");
        jLabel9.setBounds(10, 190, 200, 20);
        jTextField9 = new JTextField(" ");
        jTextField9.setBounds(200, 190, 90, 20);

        
        JButton Agregar = new JButton("Agregar");
        Agregar.setBounds(30, 210, 90, 20);

        data = new Object[9];
        model = new DefaultTableModel();

        String columnNames[] = {"Id",/*"Nombre","Unidad","Existencia","Detalles","Maximos","Minimos","Precio","Costo","Diferencia"*/};
        String tableContent[][];
        model.addColumn("id");
        model.addColumn("nombre");
        model.addColumn("unidad");
        model.addColumn("Existencia");
        model.addColumn("Detalles");
        model.addColumn("Maximos");
        model.addColumn("Minimos");
        model.addColumn("Precio");
        model.addColumn("Costo");

        jTable =new JTable(model);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(50, 300, 700, 130);

        Agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                data[0] = jTextField.getText();

                data[1] = jTextField2.getText();

                data[2] = jTextField3.getText();

                data[3] = jTextField4.getText();

                data[4] = jTextField5.getText();

                data[5] = jTextField66.getText();

                data[6] = jTextField7.getText();

                data[7] = jTextField8.getText();

                data[8] = jTextField9.getText();
                model.addRow(data);
            }

        });
        
        JButton Limp = new JButton("Limpiar");
        Limp.setBounds(300, 210, 90, 20);
        Limp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTextField.setText(null);
                jTextField2.setText(null);
                jTextField3.setText(null);
                jTextField4.setText(null);
                jTextField5.setText(null);
                jTextField66.setText(null);
                jTextField7.setText(null);
                jTextField8.setText(null);
                jTextField9.setText(null);

            }
        });
            
        JButton Elim = new JButton("Eliminar");
        Elim.setBounds(400, 210, 90, 20);
        Elim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x;
                String file;
                int fe = jTable.getSelectedRowCount();
                if (fe >= 0) {
                    model.removeRow(fe);
                } else {

                    JOptionPane.showMessageDialog(null, "no es posible");
                }
            }
        });
        
               
        

        jpanel.add(jScrollPane);
        jPanel.setLayout(null);
        jTable.setVisible(true);
        jpanel.add(Agregar);
        jpanel.add(Elim);
        jpanel.add(Limp);
        jpanel.add(jLabel);
        jpanel.add(jLabel2);
        jpanel.add(jLabel3);
        jpanel.add(jLabel4);
        jpanel.add(jLabel5);
        jpanel.add(jLabel6);
        jpanel.add(jLabel7);
        jpanel.add(jLabel8);
        jpanel.add(jLabel9);
        jpanel.add(jTextField66);
        jpanel.add(jLabel11);
        jpanel.add(jTextField);
        jpanel.add(jTextField2);
        jpanel.add(jTextField3);
        jpanel.add(jTextField4);
        jpanel.add(jTextField5);
        jpanel.add(jTextField7);
        jpanel.add(jTextField8);
        jpanel.add(jTextField9);
        jframe.setVisible(true);
        jframe.add(jpanel);
    }
    
   

    public static void main(String[] args) {
        Formulario f = new Formulario();
    }
}
