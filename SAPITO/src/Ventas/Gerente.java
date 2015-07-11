/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author JONA
 */
public class Gerente extends JFrame{
     private final JPanel panel;
    private final JLabel sysfecha;
    private final JTable tableDeInventario;
    private final JTable tablaDeReporteDia;
    private final JTable tablaDeCliente;
    private final JTable tablaDeEmpleado;
//    private final JButton botonInventario;
    //private final JButton dia;
//    private JButton;
    //private final JFormattedTextField jFTtotal;
    //private final Object[] ObResumen = new Object[4];
    private final JLabel userConnected;
    private final JScrollPane scrollInventario;
    private final JScrollPane scrollDia;
    private final JScrollPane scrollEmpleado;
    private final JScrollPane scrollCliente;
    private final JButton pdfBoton;

    public Gerente()  {
        super("Administrador - Ventas");
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (getSize().width / 2);
        int y = (screenSize.height / 2) - (getSize().height / 2);
        setLocation(x, y);

        initMenu();

        tableDeInventario = estructurarTabla(
                new String[]{"Departamento", "Cantidad", "Producto", "Precio"}
        );
        tablaDeReporteDia = estructurarTabla(
                new String[]{"ID_Producto", "Producto", "Descripcion", "Cantidad", "Precio", "Fecha"}
        );
        tablaDeEmpleado = estructurarTabla(
                new String[]{"ID_Empleado", "Nombre", "Apellido Paterno", "Apellido Materno", "Producto", "Cantidad", "Precio"}
        );
        tablaDeCliente = estructurarTabla(
                new String[]{"ID_Cliente", "Nombre", "Apellido Paterno", "Apellido Materno"}
        );

        scrollInventario = scrollertable(tableDeInventario);
        scrollDia = scrollertable(tablaDeReporteDia);
        scrollEmpleado = scrollertable(tablaDeEmpleado);
        scrollCliente = scrollertable(tablaDeCliente);

        pdfBoton = new JButton("Agregar PDF");
        pdfBoton.setBounds(100, 360, 150, 23);
        panel = new JPanel();
        panel.setBounds(50, 100, 700, 400);
        panel.setBackground(new Color(0, 0, 0));
        panel.setLayout(null);
        panel.add(pdfBoton);
        panel.add(scrollInventario);
        
        sysfecha = new JLabel();
        JLabel fecha = new JLabel("Fecha:" + sysfecha.getText());
        fecha.setBounds(680, 0, 100, 20);
        Calendar fecha2 = new GregorianCalendar();
        int año = fecha2.get(Calendar.YEAR);
        int mes = fecha2.get(Calendar.MONTH);
        int dia = fecha2.get(Calendar.DAY_OF_MONTH);

        sysfecha.setText(dia + "/" + (mes + 1) + "/" + año);
        sysfecha.setBounds(720, 2, 100, 15);

        fecha = new JLabel("Fecha: ");
        fecha.setBounds(640, 2, 90, 15);

        userConnected = new JLabel("Bienvenido ");
        userConnected.setBounds(10, 0, 200, 25);

//        botonInventario = new JButton("Inventario");
//        botonInventario.setBounds(10, 30, 150, 23);
//        botonInventario.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                panel.remove(1);
//                panel.add(scrollInventario);
//                repaint();
//            }
//        });

        this.add(panel);
        this.add(userConnected);
        this.add(fecha);
        this.add(sysfecha);
        this.add(panel);
//        this.add(botonInventario);
        this.setVisible(true);
    }

    private void initMenu() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMArchivo = new JMenu("Archivo");
        JMenu jMInventario = new JMenu("Inventario");
        JMenu jMReportes = new JMenu("Reportes");
        JMenu jMClientes = new JMenu("Clientes");
        JMenu jMVenta = new JMenu("Venta");
        JMenu jMAyuda = new JMenu("Ayuda");

        jMenuBar.add(jMArchivo);
        jMenuBar.add(jMInventario);
        jMenuBar.add(jMReportes);
        jMenuBar.add(jMVenta);
        jMenuBar.add(jMClientes);
        jMenuBar.add(jMAyuda);

        JMenuItem jitemClose = new JMenuItem("Cerrar sesion");
        jitemClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JMenuItem jItemReporteint = new JMenuItem("Reporte Inventario");
        jItemReporteint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.remove(1);
                panel.add(scrollInventario);
                panel.repaint();
            }
        });
        JMenuItem jItemdia = new JMenuItem("Reporte por dia");
        jItemdia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.remove(1);
                panel.add(scrollDia);
                repaint();
            }
        });
        JMenuItem jItemCliente = new JMenuItem("Reporte clientes");
        jItemCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.remove(1);
                panel.add(scrollCliente);
                repaint();
            }
        });
        JMenuItem jItemventas = new JMenuItem("Generar venta");
        jItemventas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Principal_Encargado encargado = new Principal_Encargado();
                } catch (SQLException ex) {
                    Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
            }
        });
        JMenuItem jItemayuda = new JMenuItem("Acerca de...");

        jMArchivo.add(jitemClose);
        jMInventario.add(jItemReporteint);
        jMReportes.add(jItemdia);

        jMClientes.add(jItemCliente);
        jMVenta.add(jItemventas);
        jMAyuda.add(jItemayuda);

        setJMenuBar(jMenuBar);
    }

    private JScrollPane scrollertable(JTable tabla) {
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(50, 50, 600, 300);
        return scroll;
    }

    private JTable estructurarTabla(String[] encabezado) {
        return new JTable(new DefaultTableModel(
                new Object[][]{},
                encabezado
        ));
    }

    public static void main(String[] args) {
        Gerente gerente = new Gerente();
    }
}

    

