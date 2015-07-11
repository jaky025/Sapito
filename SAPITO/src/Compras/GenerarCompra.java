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
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Rulo
 */
public class GenerarCompra extends JPanel {
    private Connection conn;
    private Statement stmt;
    Object[] ObLista = new Object[6];
    public JFrame jFrame;
    DefaultTableModel modeloT;
    Compra obc = new Compra();
    double eliminado;
    JTable jTable;
    JLabel Limpgen, Lsubtgen, Ltotalf;
    java.sql.Date javaSqlDate;
    JComboBox CBareas;

    public GenerarCompra() throws SQLException {
        String jFrameTitle = "GENERAR COMPRAS";
        jFrame = new JFrame(jFrameTitle);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation((screenSize.width / 2) - (jFrame.getSize().width / 2), (screenSize.height / 2) - (jFrame.getSize().height / 2));

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        String etiquetaprov = "Proveedor";
        JLabel jLabelProv = new JLabel(etiquetaprov);
        jLabelProv.setBounds(10, 20, 100, 30);
        String items[] = {"Proveedor A", "Proveedor B"};
        JComboBox jComboBox = new JComboBox(items);
        jComboBox.setName("ComboBox");
        jComboBox.setBounds(90, 20, 120, 20);
        jComboBox.addActionListener(new ComboBoxListener(jComboBox));
        jPanel.add(jComboBox);
        
        JLabel Larea = new JLabel("Area");
        Larea.setBounds(10, 80, 120, 20);
        String area[]={"Inventario","Recursos Humanos","Dirección","Compras","Ventas","Infraestructura","Contabilidad"};
        CBareas = new JComboBox(area);
        CBareas.setBounds(90, 80, 120, 20);
        
        final JLabel sysfecha = new JLabel();
        Calendar fecha1 = new GregorianCalendar();
        int año = fecha1.get(Calendar.YEAR);
        int mes = fecha1.get(Calendar.MONTH);
        int dia = fecha1.get(Calendar.DAY_OF_MONTH);

        sysfecha.setText(dia + "/" + (mes + 1) + "/" + año);
        JLabel fecha = new JLabel("Fecha: " + sysfecha.getText());
        fecha.setBounds(400, 10, 120, 20);
        

        String etiquetaprod = "Producto";
        JLabel jLabelProd = new JLabel(etiquetaprod);
        jLabelProd.setBounds(10, 50, 120, 20);
        String item[] = {"Producto A", "Producto B"};
        final JComboBox jComboBoxp = new JComboBox(item);
        jComboBoxp.setName("ComboBox");
        jComboBoxp.setBounds(90, 50, 120, 20);
        jComboBoxp.addActionListener(new ComboBoxListener(jComboBox));
        jPanel.add(jComboBoxp);
         DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sapito", "sapito");
        stmt = conn.createStatement();
        System.out.println("Conexion realizada");
        ResultSet rs = stmt.executeQuery("SELECT * from PRODUC");
        while (rs.next()) {
            jComboBoxp.addItem(rs.getString("nombre"));
            {
            
        
            }
        }

        String etiquetacant = "Cantidad";
        JLabel jLabelCant = new JLabel(etiquetacant);
        jLabelCant.setBounds(250, 50, 150, 23);
        final JTextField jTFcant = new JTextField();
        jTFcant.setBounds(320, 50, 150, 23);
        jTFcant.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
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

        String etiquetacosto = "Precio";
        JLabel jLabelCost = new JLabel(etiquetacosto);
        jLabelCost.setBounds(250, 90, 150, 23);
        final JTextField jTFcost = new JTextField();
        jTFcost.setBounds(320, 90, 150, 23);

        String etiquetasubtotal = "Subtotal:";
        JLabel Lsubtotal = new JLabel(etiquetasubtotal);
        Lsubtotal.setBounds(10, 400, 100, 20);
        Lsubtgen = new JLabel();
        Lsubtgen.setBounds(70, 400, 100, 20);

        String etiquetaimpuesto = "Impuesto:";
        JLabel Limpuesto = new JLabel(etiquetaimpuesto);
        Limpuesto.setBounds(250, 400, 75, 20);
        Limpgen = new JLabel();
        Limpgen.setBounds(320, 400, 100, 20);

        String etiquetatotal = "Total:";
        JLabel Ltotal = new JLabel(etiquetatotal);
        Ltotal.setBounds(500, 400, 120, 20);
        Ltotalf = new JLabel();
        Ltotalf.setBounds(560, 400, 120, 20);

        String columnNames[] = {"Producto", "Precio", "Cantidad", "Subtotal", "Total","Area"};
        Object tableContent[][] = {};

        modeloT = new DefaultTableModel(tableContent, columnNames);
        jTable = new JTable(modeloT);
        jTable.setCellSelectionEnabled(false);
        TableColumn columna1 = jTable.getColumn("Producto");
        columna1.setMinWidth(100);
        TableColumn columna2 = jTable.getColumn("Precio");
        columna2.setMinWidth(60);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(30, 130, 720, 250);

        String btnagregar = "AGREGAR";
        JButton jButtonAgregar = new JButton(btnagregar);
        jButtonAgregar.setBounds(550, 30, 200, 30);
        jButtonAgregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (jTFcant.getText().length() != 0) {
                    ObLista[0] = jComboBoxp.getSelectedItem();
                    ObLista[1] = jTFcost.getText();
                    ObLista[2] = jTFcant.getText();
                    Float x = obc.subpart(Float.parseFloat(jTFcant.getText()), Float.parseFloat(jTFcost.getText()));
                    ObLista[3] = String.valueOf(x);
                    Float y = obc.totalpart(x);
                    ObLista[4] = String.valueOf(y);
                    ObLista[5]=CBareas.getSelectedItem();
                    modeloT.addRow(ObLista);
                    
                    
                    Double subtgen = obc.calcularTotal(3, modeloT);
                    Double totgen = obc.calcularTotal(4, modeloT);
                    Double impgen = totgen - subtgen;
                    Lsubtgen.setText(String.format("%.3f", subtgen));
                    Ltotalf.setText(String.format("%.3f", totgen));
                    Limpgen.setText(String.format("%.3f", impgen));
                } else {
                    JOptionPane.showMessageDialog(null, "Elija un producto para agregar");
                }
            }
        });

        JButton Bquitar = new JButton("Quitar");
        Bquitar.setBounds(550, 80, 200, 30);
        Bquitar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
                int reliminar = jTable.getSelectedRow();

                if (reliminar < 0) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un producto");
                } else {
                    int confirmar = JOptionPane.showConfirmDialog(null, "Esta seguro que desea elimiar el producto?");
                    if (JOptionPane.OK_OPTION == confirmar) {
                        eliminado = Double.parseDouble(modelo.getValueAt(reliminar, 2).toString());
                        modelo.removeRow(reliminar);
                        JOptionPane.showMessageDialog(null, "Producto Eliminado");
                    }
                }
            }
        });

        String btnguardar = "GENERAR ORDEN";
        JButton jButtonAceptar = new JButton(btnguardar);
        jButtonAceptar.setBounds(550, 450, 200, 30);
        jButtonAceptar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (modeloT.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe agregar una compra");
                } else {
                    System.out.println("Todo ok");
                    MetodosBd ob = new MetodosBd();
                    double iva = Double.parseDouble(Limpgen.getText());
                    double total = Double.parseDouble(Ltotalf.getText());
                    double subtotal = Double.parseDouble(Lsubtgen.getText());
                    String status="en proceso";
                    String fecha = sysfecha.getText();
                    int k = 1+(ob.folio());
                    JOptionPane.showMessageDialog(null, "Dato Agregado");
                    try {
                        ob.insDetOrd(k, iva, subtotal, total,fecha, fecha, status, k);
                        
                    } catch (ParseException ex) {
                        Logger.getLogger(GenerarCompra.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        JButton Bcancelar = new JButton("Cancelar Compra");
        Bcancelar.setBounds(300, 500, 200, 30);
        Bcancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
                if (modelo.getRowCount() != 0) {
                    int confirmar = JOptionPane.showConfirmDialog(null, "Esta seguro que desea cancelar la compra?");
                    if (JOptionPane.OK_OPTION == confirmar) {
                        clean();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No hay compras para cancelar");
                }
            }
        });

        String btnregresar = "REGRESAR";
        JButton jButtonRegresar = new JButton(btnregresar);
        jButtonRegresar.setBounds(50, 500, 200, 30);
        jButtonRegresar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                PrincipalCompras Pcomp = new PrincipalCompras();
                MetodosBd oli = new MetodosBd();
                oli.insOrdnComp(modeloT);
                jFrame.dispose();
            }

        });

        jPanel.add(jLabelCost);
        jPanel.add(jTFcost);
        jPanel.add(jLabelProv);
        jPanel.add(Larea);
        jPanel.add(fecha);
        jPanel.add(jLabelProd);
        jPanel.add(jLabelCant);
        jPanel.add(jTFcant);
        jPanel.add(Lsubtotal);
        jPanel.add(Limpuesto);
        jPanel.add(Ltotal);
        jPanel.add(CBareas);
        jPanel.add(jButtonAgregar);
        jPanel.add(Bquitar);
        jPanel.add(Bcancelar);
        jPanel.add(jScrollPane);
        jPanel.add(jButtonAceptar);
        jPanel.add(jButtonRegresar);
        jPanel.add(Ltotalf);
        jPanel.add(Lsubtgen);
        jPanel.add(Limpgen);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

    public void clean() {
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        try {

            int filas = jTable.getRowCount();
            for (int i = 0; i < filas; i++) {
                modelo.removeRow(0);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar venta");
        }
    }

//    public static void main(String arguments[]) {
//        GenerarCompra OC = new GenerarCompra();
//    }

}
