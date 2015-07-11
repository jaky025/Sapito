/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Reventas.Customer;
import Reventas.Product;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
public class Buscar extends JFrame {

    private JFrame frameBusqueda;
    private JMenuBar menuBar;
    private JMenu menuListConsultar;
    private JMenuItem menuItemHabilitarConsulta;
    private JMenuItem menuItemCancelarConsulta;
    private JPanel panelFondo;
    private JLabel lblApPaterno;
    private JLabel lblApMaterno;
    private JTextField txtApPaterno;
//    private JTextField txtApMaterno;
    private JButton btnBuscarCte;
    private JButton btnAgregarCte;
    private JTable tablaCte;
    private DefaultTableModel modeloTabla;
    private JScrollPane deslizarTabla;
    Customer[] cliente = new Customer[10];
    private Object [] busqueda=new Object[3];
    private int i=0;
    private ResultSetMetaData rsmd = null;
    
    

    public Buscar() {
        initFrame();
    }
    
    
    public void cliente() throws SQLException{
        //Se crea un objeto de tipo conexion
        Conexion dbConn = new Conexion();  
        //Abrimos conexion
        dbConn.openConnection(); //Importante 2
        //Creamos una conenexion de tipo statement
        Statement stmt = dbConn.getConnection().createStatement(); //Importante 3
        //Resulset es el que prepara las consultas 
        ResultSet rs = stmt.executeQuery("SELECT APELLIDO_P, APELLIDO_M, NOMBRE FROM CLIENTES WHERE APELLIDO_P='"+txtApPaterno.getText()+"'");
        
        while (rs.next()) { //Importante 5
            cliente[i] = new Customer();
            cliente[i].setName(rs.getString("NOMBRE"));
            cliente[i].setLastname(rs.getString("APELLIDO_P"));
            cliente[i].setSecondname(rs.getString("APELLIDO_M"));
            busqueda[0]=cliente[i].getLastname();
            busqueda[1]=cliente[i].getSecondname();
            busqueda[2]=cliente[i].getName();
            modeloTabla.addRow(busqueda);
            cliente[i++].setId(i);
        }
        txtApPaterno.setText("");
        dbConn.closeConnection();
    }

    private void initFrame() {
        //Creacion del Frame
        frameBusqueda = new JFrame("Busqueda Cliente");
        frameBusqueda.setSize(800, 600);
        frameBusqueda.setLocationRelativeTo(null);/*Aqui le cambias con lo del ese windowToolKit
         pero igual con esta funcion puedes centrar la ventana sin importar el tamaño de la misma*/

        frameBusqueda.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Creacion del menuBar
        menuBar = new JMenuBar();
        menuListConsultar = new JMenu("Consultar");
        menuItemHabilitarConsulta = new JMenuItem("Habilitar Consulta");
        menuItemCancelarConsulta = new JMenuItem("Cancelar Consulta");
        menuItemCancelarConsulta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Principal_Encargado encargado = new Principal_Encargado();
                } catch (SQLException ex) {
                    Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
                }
                frameBusqueda.dispose();
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        //Agregar componentes al menu bar
        menuBar.add(menuListConsultar);
        menuListConsultar.add(menuItemHabilitarConsulta);
        menuListConsultar.add(menuItemCancelarConsulta);

        //Creacion Panel
        panelFondo = new JPanel(true);
        panelFondo.setLayout(null);
        panelFondo.setBackground(new Color(255, 255, 255));

        //Creacion label y textfields
        lblApPaterno = new JLabel("Apellido Paterno");
        lblApPaterno.setSize(110, 23);
        lblApPaterno.setLocation(15, 25);

        txtApPaterno = new JTextField();
        txtApPaterno.setSize(200, 23);
        txtApPaterno.setLocation(130, 25);

        /*Aqui en la parte de las creaciones use el setSize y setLocation
         lo puedes sustituir sin problemas con el setBounds*/

        //Creacion del boton buscar
        btnBuscarCte = new JButton("Buscar Cliente");
        btnBuscarCte.setSize(150, 30);
        btnBuscarCte.setLocation(190, 500);
        
        btnBuscarCte.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtApPaterno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese Apellido Paterno", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }  
                try {
                    cliente();
                } catch (SQLException ex) {
                    Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
        });
        

        //Creacion del boton agregar cte
        
        btnAgregarCte = new JButton("Agregar Cliente");
        btnAgregarCte.setSize(150, 30);
        btnAgregarCte.setLocation(380, 500);
        

    
        
        String [] columnName= {"Apellido Paterno", "Apellido Materno", "Nombre(s)"};
        Object [][]  tableContent={};
        modeloTabla = new DefaultTableModel(tableContent, columnName);
        tablaCte = new JTable(modeloTabla);
        tablaCte.setCellSelectionEnabled(false);
        TableColumn col1 = tablaCte.getColumn("Apellido Paterno");
        col1.setMinWidth(200);
        TableColumn col2 = tablaCte.getColumn("Apellido Materno");
        col2.setMinWidth(200);
        TableColumn col3 = tablaCte.getColumn("Nombre(s)");
        col3.setMinWidth(200);

        deslizarTabla = new JScrollPane(tablaCte);
        deslizarTabla.setSize(600, 400);
        deslizarTabla.setLocation(100, 75);

        //Agregar componentes al panel
        panelFondo.add(lblApPaterno);
        panelFondo.add(txtApPaterno);
        panelFondo.add(btnBuscarCte);
        panelFondo.add(deslizarTabla);
        //Agregar panel al Frame
        frameBusqueda.add(panelFondo);
        frameBusqueda.setJMenuBar(menuBar);
        frameBusqueda.setVisible(true);
    }

    public static void main(String[] args) {
        Buscar search = new Buscar();
    }
 
}
