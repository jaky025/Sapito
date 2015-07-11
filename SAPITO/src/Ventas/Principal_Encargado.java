/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Conexion.DataBaseManager;
import Reventas.Customer;
import Reventas.Product;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author Jorge
 */
public class Principal_Encargado extends JFrame {

    private Object lista = new Object[4];
    private JPanel jpanel;
    private JTable jtproductos;
    private JMenuBar jmBar;
    DefaultTableModel modeloT;
    private JTable jTable;
    private JTextField jtcantidad;
    private JComboBox jccliente;
    private JComboBox jcproducto;
    private JButton jbprueba;
    private JButton jbsearch;
    private JButton jbgenerar;
    private JButton jbagregar;
    private JButton jbeliminarpro;
    private JButton jbpagar;
    private JButton jbcancelar;
    private JLabel sysfecha;
    private JLabel jlvendedor;
    private JLabel jlcliente;
    private JLabel jlproducto;
    private JLabel jlsubtotal;
    private JLabel jliva;
    private JLabel jlST;
    private JLabel jlI;
    private JLabel jlT;
    private JLabel jltotal;
    private JLabel jlcomprovante;
    private JLabel jlcantidad;
    private JMenu jmArchivo;
    private JMenu jmAyuda;
    private JRadioButton jrfactura;
    private JRadioButton jrticket;
    private Object tableContent[][] = {{"", "", "", ""}};
    int pos = 0;
    Customer[] cliente = new Customer[10];
    Product[] listproduc = new Product[10];
    public int i = 0;
    public int k = 0;
    
   // public String TablaContent[][]={};
//
//    public Double caltotal(int a, DefaultTableModel modeloT) {
//        Double total = 0.0;
//        int renglones = modeloT.getColumnCount();
//        for (int j = 0; j < renglones; j++) {
//            System.out.println(modeloT.getValueAt(pos, a));
//            total = total + Double.parseDouble((String) modeloT.getValueAt(pos, a));
//        }
//        System.out.println(total);
//        return total;
//    }

    public String[] getNames() {
        String[] names = new String[10];
        for (int j = 0; j < i; j++) {
            names[j] = cliente[j].getName() + " " + cliente[j].getLastname() + " " + cliente[j].getSecondname();
        }

        return names;
    }

    public String[] getProduct() {
        String[] productt = new String[10];
        for (int j = 0; j < k; j++) {
            productt[j] = listproduc[j].getProductname();
        }

        return productt;
    }

    public void cargarinformacion() throws SQLException {
        DataBaseManager dbConn = new DataBaseManager();  //Importante 1
        dbConn.openConnection(); //Importante 2
        Statement stmt = dbConn.getConnection().createStatement(); //Importante 3
        ResultSet rs = stmt.executeQuery("SELECT * from CLIENTES");

        while (rs.next()) { //Importante 5
            cliente[i] = new Customer();
            cliente[i].setName(rs.getString("NOMBRE"));
            cliente[i].setLastname(rs.getString("APELLIDO_P"));
            cliente[i].setSecondname(rs.getString("APELLIDO_M"));
            cliente[i++].setId(i);

        }
        stmt = dbConn.getConnection().createStatement(); //Importante 3
        rs = stmt.executeQuery("SELECT * from PRODUCTOS");

        while (rs.next()) { //Importante 5
            listproduc[k] = new Product();
            listproduc[k].setProductname(rs.getString("NOMBRE"));
            listproduc[k].setQuantity(rs.getInt("CANTIDAD_PROD"));
            listproduc[k].setPrice(rs.getInt("PRECIO_VENTA"));
            // listproduc[k].setPrice(rs.getString("PRECIO_VENTA"));

            listproduc[k++].setId(i);

        }
        dbConn.closeConnection();
    }

    public Principal_Encargado() throws SQLException {
        cargarinformacion();
        new JFrame("Vendedor - Ventas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (getSize().width / 2);
        int y = (screenSize.height / 2) - (getSize().height / 2);
        setLocation(x, y);

        jpanel = new JPanel();
        jpanel.setLayout(null);/*aquí modifique, siempre que modifiques un componente
         lo ideal es que pongas el nombre, seguido del metodo que vas a utilziar*/

        jpanel.setBackground(new Color(255, 255, 255));/*aqui para el color te recomiendo utilices una
         paleta en RGB*/

        jmBar = new JMenuBar();

        jmArchivo = new JMenu("Archivo");
        jmAyuda = new JMenu("Ayuda");

        jmBar.add(jmArchivo);
        jmBar.add(jmAyuda);

        JMenuItem itemayuda = new JMenuItem("Acerca de...");
        itemayuda.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

//                 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        JMenuItem ItemSalir = new JMenuItem("Cerrar Sesion");
        ItemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                 dispose();
            }
        });

        sysfecha = new JLabel();
        JLabel fecha = new JLabel("Fecha:" + sysfecha.getText());
        fecha.setBounds(680, 0, 100, 20);
        Calendar fecha1 = Calendar.getInstance();
        Calendar fecha2 = new GregorianCalendar();
        int año = fecha2.get(Calendar.YEAR);
        int mes = fecha2.get(Calendar.MONTH);
        int dia = fecha2.get(Calendar.DAY_OF_MONTH);
        Date date = new Date();

        sysfecha.setText(dia + "/" + (mes + 1) + "/" + año);
        sysfecha.setBounds(720, 2, 100, 15);

        jlvendedor = new JLabel("Vendedor:");
        jlvendedor.setBounds(320, 40, 100, 30);

        jlcliente = new JLabel("Cliente:");
        jlcliente.setBounds(55, 120, 100, 30);

        jlproducto = new JLabel("Producto:");
        jlproducto.setBounds(55, 150, 100, 30);

        jccliente = new JComboBox(getNames());
        jccliente.setBounds(115, 120, 300, 25);

        jcproducto = new JComboBox(getProduct());
        jcproducto.setBounds(115, 150, 300, 25);

        jtcantidad = new JTextField();
        jtcantidad.setBounds(580, 120, 120, 23);

        String columnNames[] = {"Producto", "Cantidad", "Precio", "Sub-Total"};

        modeloT = new DefaultTableModel(tableContent, columnNames);
        jTable = new JTable(modeloT);
        TableColumn columna1 = jTable.getColumn("Producto");
        columna1.setMinWidth(120);
        TableColumn columna2 = jTable.getColumn("Cantidad");
        columna2.setMinWidth(150);
        TableColumn columna3 = jTable.getColumn("Precio");
        columna3.setMinWidth(100);

        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(55, 200, 650, 200);

        jbagregar = new JButton("Agregar");
        jbagregar.setBounds(420, 150, 150, 23);
        jbagregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtcantidad.getText().length() > 0) {

                    modeloT.setValueAt(listproduc[jcproducto.getSelectedIndex()].getProductname(), pos, 0);
                    modeloT.setValueAt(jtcantidad.getText(), pos, 1);
                    modeloT.setValueAt(listproduc[jcproducto.getSelectedIndex()].getPrice(), pos, 2);
                    modeloT.setValueAt(listproduc[jcproducto.getSelectedIndex()].getPrice() * Integer.parseInt(jtcantidad.getText()), pos, 3);
                    Object[] obj = new Object[4];
                    modeloT.addRow(obj);
                    pos++;
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        jtcantidad.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < '0' || car > '9')) {
                    ke.consume();
                }
                if (jtcantidad.getText().length() + 1 > 5) {
                    JOptionPane.showMessageDialog(null, "Sobrepasa el nivel de caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    jtcantidad.setText(" ");

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

        jbgenerar = new JButton("Nuevo Cliente");
        jbgenerar.setBounds(580, 150, 150, 23);
        jbgenerar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                registro regi = new registro();
                dispose();
            }
        });

        String path = "/Ventas/cli.png";
        URL url = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(url);
        JLabel imagen = new JLabel("Clientes");
        imagen.setBounds(0, 0, 303, 107);
        imagen.setIcon(icon);

        jlcantidad = new JLabel("Cantidad: ");
        jlcantidad.setBounds(580, 100, 120, 23);
        jpanel.add(jlcantidad);

        jlsubtotal = new JLabel("Sub-Total:");
        jlsubtotal.setBounds(550, 410, 100, 23);
        jpanel.add(jlsubtotal);

        jlST = new JLabel();
        jlST.setBounds(650, 410, 100, 23);
        jpanel.add(jlST);

        jliva = new JLabel("Iva:");
        jliva.setBounds(550, 440, 100, 23);
        jpanel.add(jliva);

        jltotal = new JLabel("Total:");
        jltotal.setBounds(550, 470, 100, 23);
        jpanel.add(jltotal);

        jbpagar = new JButton("Pagar");
        jbpagar.setBounds(550, 500, 150, 30);
        jbpagar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GeneradorFormato pdf = new GeneradorFormato();
            }
        });
        jpanel.add(jbpagar);

        jbsearch = new JButton("Buscar");
        jbsearch.setBounds(420, 120, 150, 23);
        jbsearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Buscar search = new Buscar();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        jbeliminarpro = new JButton("Eliminar producto");
        jbeliminarpro.setBounds(310, 410, 150, 30);

        jpanel.add(jbeliminarpro);

        jbcancelar = new JButton("Cancelar Compra");
        jbcancelar.setBounds(55, 500, 150, 30);

        jpanel.add(jbcancelar);

        jlcomprovante = new JLabel("Generar Comprobante");
        jlcomprovante.setBounds(55, 420, 150, 30);
        jpanel.add(jlcomprovante);

        jrfactura = new JRadioButton("Factura");
        jrfactura.setBounds(55, 450, 100, 23);
        jpanel.add(jrfactura);

        jrticket = new JRadioButton("Ticket");
        jrticket.setBounds(150, 450, 100, 23);
        jpanel.add(jrticket);
        jpanel.add(jbsearch);
        jmArchivo.add(ItemSalir);
        jmAyuda.add(itemayuda);
        setJMenuBar(jmBar);
        jpanel.add(jtcantidad);
        jpanel.add(jScrollPane);
        jpanel.add(jlproducto);
        jpanel.add(jcproducto);
        jpanel.add(jbagregar);
        jpanel.add(jbgenerar);
        jpanel.add(jccliente);
        jpanel.add(jlcliente);
        jpanel.add(jlvendedor);
        jpanel.add(imagen);
        jpanel.add(fecha);
        jpanel.add(sysfecha);
        add(jpanel);

        setVisible(true);
    }
}
//    public static void main(String[] args) throws SQLException {
//        Principal_Encargado Principal_Encargado = new Principal_Encargado();
//    }
//}
