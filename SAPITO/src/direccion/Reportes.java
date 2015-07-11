/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package direccion;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.freixas.jcalendar.JCalendar;
import org.freixas.jcalendar.JCalendarCombo;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Oscar Gabriel
 */
public class Reportes extends JPanel {

    public JFrame jFrame;
    public JPanel jPanel;

    JFreeChart Grafica;
    DefaultCategoryDataset datos_ventas = new DefaultCategoryDataset();
    DefaultCategoryDataset datos_contabilidad = new DefaultCategoryDataset();
    DefaultCategoryDataset datos_rec_hum = new DefaultCategoryDataset();
    DefaultPieDataset datos_mantenimiento = new DefaultPieDataset();
    DefaultPieDataset datos_compras = new DefaultPieDataset();
    DefaultPieDataset datos_inventario = new DefaultPieDataset();

    double d_mant_rh = 43.2;
    double d_mant_cont = 15.0;
    double d_mant_vent = 10.0;
    double d_mant_comp = 15.0;
    double d_mant_inv = 10.0;
    double d_mant_mant = 10.0;

    double d_comp_nom = 43.2;
    double d_comp_comp = 10.0;
    double d_comp_gf = 17.5;
    double d_comp_gv = 32.5;
    double d_comp_go = 12.5;

    double d_vent_s1_lu = 1.0;
    double d_vent_s1_ma = 3.0;
    double d_vent_s1_mi = 5.0;
    double d_vent_s1_ju = 7.0;
    double d_vent_s1_vi = 9.0;
    double d_vent_s1_sa = 11.0;
    double d_vent_s1_do = 13.0;
    double d_vent_s2_lu = 2.0;
    double d_vent_s2_ma = 4.0;
    double d_vent_s2_mi = 6.0;
    double d_vent_s2_ju = 8.0;
    double d_vent_s2_vi = 10.0;
    double d_vent_s2_sa = 12.0;
    double d_vent_s2_do = 14.0;

    double d_inv_p1 = 43.2;
    double d_inv_p2 = 10.0;
    double d_inv_p3 = 17.5;
    double d_inv_p4 = 32.5;
    double d_inv_p5 = 12.5;

    double d_cont_e_lu = 1.0;
    double d_cont_e_ma = 3.0;
    double d_cont_e_mi = 5.0;
    double d_cont_e_ju = 7.0;
    double d_cont_e_vi = 9.0;
    double d_cont_e_sa = 11.0;
    double d_cont_e_do = 13.0;
    double d_cont_s_lu = 2.0;
    double d_cont_s_ma = 4.0;
    double d_cont_s_mi = 6.0;
    double d_cont_s_ju = 8.0;
    double d_cont_s_vi = 10.0;
    double d_cont_s_sa = 12.0;
    double d_cont_s_do = 14.0;
    double d_cont_u_lu = 5.0;
    double d_cont_u_ma = 10.0;
    double d_cont_u_mi = 15.0;
    double d_cont_u_ju = 20.0;
    double d_cont_u_vi = 25.0;
    double d_cont_u_sa = 30.0;
    double d_cont_u_do = 35.0;

    int d_rh_a_lu = 1;
    int d_rh_a_ma = 2;
    int d_rh_a_mi = 3;
    int d_rh_a_ju = 4;
    int d_rh_a_vi = 5;
    int d_rh_a_sa = 6;
    int d_rh_a_do = 7;
    int d_rh_r_lu = 2;
    int d_rh_r_ma = 4;
    int d_rh_r_mi = 6;
    int d_rh_r_ju = 8;
    int d_rh_r_vi = 10;
    int d_rh_r_sa = 12;
    int d_rh_r_do = 14;
    int d_rh_f_lu = 1;
    int d_rh_f_ma = 3;
    int d_rh_f_mi = 5;
    int d_rh_f_ju = 7;
    int d_rh_f_vi = 9;
    int d_rh_f_sa = 11;
    int d_rh_f_do = 13;

    public Reportes() {

        String titulo = "Reportes";
        jFrame = new JFrame(titulo);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);

        JLabel etiqueta = new JLabel("Reportes");
        etiqueta.setBounds(300, 25, 200, 50);
        etiqueta.setFont(new Font("Verdana", Font.BOLD, 30));
        etiqueta.setForeground(Color.BLACK);

        JMenuBar jMenuBar = new JMenuBar();

        JMenu acceso = new JMenu("Acceso a");
        JMenu ayuda = new JMenu("Ayuda");

        JMenuItem rec_hum = new JMenuItem("Recursos Humanos");
        JMenuItem conta = new JMenuItem("Contabilidad");
        JMenuItem ventas = new JMenuItem("Ventas");
        JMenuItem compras = new JMenuItem("Compras");
        JMenuItem inventario = new JMenuItem("Inventario");

        JMenuItem acerca_de = new JMenuItem("Acerca de");
        acerca_de.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ayuda", "Ayuda", 3);
            }
        });

        acceso.add(rec_hum);
        acceso.add(conta);
        acceso.add(ventas);
        acceso.add(compras);
        acceso.add(inventario);

        ayuda.add(acerca_de);

        jMenuBar.add(acceso);
        jMenuBar.add(ayuda);

        JCalendar cal1 = new JCalendar();
        cal1.setBounds(250, 150, 400, 300);
        JCalendarCombo cal2 = new JCalendarCombo();
        cal2.setBounds(250, 150, 400, 300);

        String reportes[] = {"Mantenimiento", "Compras", "Ventas", "Inventario", "Contabilidad", "Recursos Humanos"};
        JComboBox combobox = new JComboBox(reportes);
        combobox.setBounds(300, 100, 150, 30);

        JLabel calendario = new JLabel("Fecha de Operación:");
        calendario.setBounds(60, 150, 150, 30);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBounds(50, 200, 150, 30);
        aceptar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (combobox.getSelectedIndex() == 0) {

                    datos_mantenimiento.setValue("Recursos Humanos", d_mant_rh);
                    datos_mantenimiento.setValue("Contabilidad", d_mant_cont);
                    datos_mantenimiento.setValue("Ventas", d_mant_vent);
                    datos_mantenimiento.setValue("Compras", d_mant_comp);
                    datos_mantenimiento.setValue("Inventario", d_mant_inv);
                    datos_mantenimiento.setValue("Mantenimiento", d_mant_mant);

                    Grafica = ChartFactory.createPieChart3D("Mantenimiento", datos_mantenimiento, true, true, true);

                    ChartPanel panel_grafica = new ChartPanel(Grafica);
                    JFrame frame_grafica = new JFrame("Gráfico");

                    JMenuBar menu = new JMenuBar();
                    JMenu archivo = new JMenu("Archivo");
                    JMenuItem guardar = new JMenuItem("Guardar como reporte...");
                    guardar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Document document = new Document();
                            PdfWriter writer = null;
                            try {
                                writer = PdfWriter.getInstance(document, new FileOutputStream("Gráfico Mantenimiento.pdf"));
                            } catch (DocumentException ex) {
                                Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            document.open();
                            PdfContentByte cb = writer.getDirectContent();
                            PdfTemplate tp = cb.createTemplate(450, 450);
                            Graphics2D g2 = tp.createGraphicsShapes(450, 450);
                            menu.setVisible(false);
                            frame_grafica.print(g2);
                            menu.setVisible(true);
                            g2.dispose();
                            cb.addTemplate(tp, 30, 400);
                            document.close();

                            HSSFWorkbook workbook = new HSSFWorkbook();
                            HSSFSheet sheet = workbook.createSheet("Reporte de Mantenimiento");

                            Row fila = sheet.createRow(0);
                            File archivo = new File("Reporte de Mantenimiento.xls");
                            Cell celda;

                            String[] titulos = {"Recursos Humanos", "Contabilidad", "Ventas", "Compras", "Inventario", "Mantenimiento"};
                            Double[] datos = {d_mant_rh, d_mant_cont, d_mant_vent, d_mant_comp, d_mant_inv, d_mant_mant};

                            int i;
                            for (i = 0; i < titulos.length; i++) {
                                celda = fila.createCell(i);
                                celda.setCellValue(titulos[i]);
                            }
                            fila = sheet.createRow(1);
                            for (i = 0; i < datos.length; i++) {
                                celda = fila.createCell(i);
                                celda.setCellValue(datos[i]);
                            }
                            try {
                                FileOutputStream out = new FileOutputStream(archivo);
                                workbook.write(out);
                                out.close();
                                System.out.println("¡Archivo creado exitosamente!");
                            } catch (IOException ex) {
                                System.out.println("Error de escritura");
                                ex.printStackTrace();
                            }
                        }
                    });
                    archivo.add(guardar);
                    menu.add(archivo);
                    frame_grafica.getContentPane().add(panel_grafica);
                    frame_grafica.setBounds(60, 60, 450, 400);
                    frame_grafica.setJMenuBar(menu);
                    frame_grafica.setVisible(true);
                    frame_grafica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
                if (combobox.getSelectedIndex() == 1) {

                    datos_compras.setValue("Nomina", d_comp_nom);
                    datos_compras.setValue("Compras", d_comp_comp);
                    datos_compras.setValue("Gastos Fijos", d_comp_gf);
                    datos_compras.setValue("Gastos Variables", d_comp_gv);
                    datos_compras.setValue("Gastos Otros", d_comp_go);

                    Grafica = ChartFactory.createPieChart3D("Compras", datos_compras, true, true, true);

                    ChartPanel panel_grafica = new ChartPanel(Grafica);
                    JFrame frame_grafica = new JFrame("Gráfico");

                    JMenuBar menu = new JMenuBar();
                    JMenu archivo = new JMenu("Archivo");
                    JMenuItem guardar = new JMenuItem("Guardar como reporte...");
                    guardar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Document document = new Document();
                            PdfWriter writer = null;
                            try {
                                writer = PdfWriter.getInstance(document, new FileOutputStream("Gráfico Compras.pdf"));
                            } catch (DocumentException ex) {
                                Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            document.open();
                            menu.setVisible(false);
                            PdfContentByte cb = writer.getDirectContent();
                            PdfTemplate tp = cb.createTemplate(450, 450);
                            Graphics2D g2 = tp.createGraphicsShapes(850, 850);
                            menu.setVisible(false);
                            frame_grafica.print(g2);
                            menu.setVisible(true);
                            g2.dispose();
                            cb.addTemplate(tp, 30, 400);
                            document.close();

                            HSSFWorkbook workbook = new HSSFWorkbook();
                            HSSFSheet sheet = workbook.createSheet("Reporte de Compras");

                            Row fila = sheet.createRow(0);
                            File archivo = new File("Reporte de Compras.xls");
                            Cell celda;

                            String[] titulos = {"Nomina", "Compras", "Gastos Fijos", "Gastos Variables", "Gastos Otros"};
                            Double[] datos = {d_comp_nom, d_comp_comp, d_comp_gf, d_comp_gv, d_comp_go};

                            int i;
                            for (i = 0; i < titulos.length; i++) {
                                celda = fila.createCell(i);
                                celda.setCellValue(titulos[i]);
                            }
                            fila = sheet.createRow(1);
                            for (i = 0; i < datos.length; i++) {
                                celda = fila.createCell(i);
                                celda.setCellValue(datos[i]);
                            }
                            try {
                                FileOutputStream out = new FileOutputStream(archivo);
                                workbook.write(out);
                                out.close();
                                System.out.println("¡Archivo creado exitosamente!");
                            } catch (IOException ex) {
                                System.out.println("Error de escritura");
                                ex.printStackTrace();
                            }
                        }
                    });
                    archivo.add(guardar);
                    menu.add(archivo);
                    frame_grafica.getContentPane().add(panel_grafica);
                    frame_grafica.setBounds(60, 60, 450, 400);
                    frame_grafica.setJMenuBar(menu);
                    frame_grafica.setVisible(true);
                    frame_grafica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
                if (combobox.getSelectedIndex() == 2) {

                    datos_ventas.addValue(d_vent_s1_lu, "Semana 1", "Lunes");
                    datos_ventas.addValue(d_vent_s1_ma, "Semana 1", "Martes");
                    datos_ventas.addValue(d_vent_s1_mi, "Semana 1", "Miércoles");
                    datos_ventas.addValue(d_vent_s1_ju, "Semana 1", "Jueves");
                    datos_ventas.addValue(d_vent_s1_vi, "Semana 1", "Viernes");
                    datos_ventas.addValue(d_vent_s1_sa, "Semana 1", "Sábado");
                    datos_ventas.addValue(d_vent_s1_do, "Semana 1", "Domingo");

                    datos_ventas.addValue(d_vent_s2_lu, "Semana 2", "Lunes");
                    datos_ventas.addValue(d_vent_s2_ma, "Semana 2", "Martes");
                    datos_ventas.addValue(d_vent_s2_mi, "Semana 2", "Miércoles");
                    datos_ventas.addValue(d_vent_s2_ju, "Semana 2", "Jueves");
                    datos_ventas.addValue(d_vent_s2_vi, "Semana 2", "Viernes");
                    datos_ventas.addValue(d_vent_s2_sa, "Semana 2", "Sábado");
                    datos_ventas.addValue(d_vent_s2_do, "Semana 2", "Domingo");

                    Grafica = ChartFactory.createLineChart3D("Ventas", "Días", "Ingresos", datos_ventas, PlotOrientation.VERTICAL, true, true, false);

                    ChartPanel panel_grafica = new ChartPanel(Grafica);
                    JFrame frame_grafica = new JFrame("Gráfico");

                    JMenuBar menu = new JMenuBar();
                    JMenu archivo = new JMenu("Archivo");
                    JMenuItem guardar = new JMenuItem("Guardar como reporte...");
                    guardar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Document document = new Document();
                            PdfWriter writer = null;
                            try {
                                writer = PdfWriter.getInstance(document, new FileOutputStream("Gráfico Ventas.pdf"));
                            } catch (DocumentException ex) {
                                Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            document.open();
                            PdfContentByte cb = writer.getDirectContent();
                            PdfTemplate tp = cb.createTemplate(450, 450);
                            Graphics2D g2 = tp.createGraphicsShapes(450, 450);
                            menu.setVisible(false);
                            frame_grafica.print(g2);
                            menu.setVisible(true);
                            g2.dispose();
                            cb.addTemplate(tp, 30, 400);
                            document.close();

                            HSSFWorkbook workbook = new HSSFWorkbook();
                            HSSFSheet sheet = workbook.createSheet("Reporte de Ventas");

                            Row fila = sheet.createRow(0);
                            File archivo = new File("Reporte de Ventas.xls");
                            Cell celda;

                            String[] titulos1 = {"S1 lunes", "S1 martes", "S1 miercoles", "S1 jueves", "S1 viernes", "S1 sabado", "S1 domingo"};
                            String[] titulos2 = {"S2 lunes", "S2 martes", "S2 miercoles", "S2 jueves", "S2 viernes", "S2 sabado", "S2 domingo"};
                            Double[] datos1 = {d_vent_s1_lu, d_vent_s1_ma, d_vent_s1_mi, d_vent_s1_ju, d_vent_s1_vi, d_vent_s1_sa, d_vent_s1_do};
                            Double[] datos2 = {d_vent_s2_lu, d_vent_s2_ma, d_vent_s2_mi, d_vent_s2_ju, d_vent_s2_vi, d_vent_s2_sa, d_vent_s2_do};

                            int i, j;
                            for (i = 0; i < titulos1.length; i++) {
                                celda = fila.createCell(i);
                                celda.setCellValue(titulos1[i]);
                            }
                            fila = sheet.createRow(1);
                            for (i = 0; i < datos1.length; i++) {
                                celda = fila.createCell(i);
                                celda.setCellValue(datos1[i]);
                            }
                            fila = sheet.createRow(3);
                            for (j = 0; j < titulos2.length; j++) {
                                celda = fila.createCell(j);
                                celda.setCellValue(titulos2[j]);
                            }
                            fila = sheet.createRow(4);
                            for (j = 0; j < datos2.length; j++) {
                                celda = fila.createCell(j);
                                celda.setCellValue(datos2[j]);
                            }
                            try {
                                FileOutputStream out = new FileOutputStream(archivo);
                                workbook.write(out);
                                out.close();
                                System.out.println("¡Archivo creado exitosamente!");
                            } catch (IOException ex) {
                                System.out.println("Error de escritura");
                                ex.printStackTrace();
                            }
                        }
                    });
                    archivo.add(guardar);
                    menu.add(archivo);
                    frame_grafica.getContentPane().add(panel_grafica);
                    frame_grafica.setBounds(60, 60, 450, 400);
                    frame_grafica.setJMenuBar(menu);
                    frame_grafica.setVisible(true);
                    frame_grafica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
                if (combobox.getSelectedIndex() == 3) {

                    datos_inventario.setValue("Producto 1", d_inv_p1);
                    datos_inventario.setValue("Producto 2", d_inv_p2);
                    datos_inventario.setValue("Producto 3", d_inv_p3);
                    datos_inventario.setValue("Producto 4", d_inv_p4);
                    datos_inventario.setValue("Producto 5", d_inv_p5);

                    Grafica = ChartFactory.createPieChart3D("Inventario", datos_inventario, true, true, true);

                    ChartPanel panel_grafica = new ChartPanel(Grafica);
                    JFrame frame_grafica = new JFrame("Gráfico");

                    JMenuBar menu = new JMenuBar();
                    JMenu archivo = new JMenu("Archivo");
                    JMenuItem guardar = new JMenuItem("Guardar como reporte...");
                    guardar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Document document = new Document();
                            PdfWriter writer = null;
                            try {
                                writer = PdfWriter.getInstance(document, new FileOutputStream("Gráfico Inventario.pdf"));
                            } catch (DocumentException ex) {
                                Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            document.open();
                            PdfContentByte cb = writer.getDirectContent();
                            PdfTemplate tp = cb.createTemplate(450, 450);
                            Graphics2D g2 = tp.createGraphicsShapes(450, 450);
                            menu.setVisible(false);
                            frame_grafica.print(g2);
                            menu.setVisible(true);
                            g2.dispose();
                            cb.addTemplate(tp, 30, 400);
                            document.close();

                            HSSFWorkbook workbook = new HSSFWorkbook();
                            HSSFSheet sheet = workbook.createSheet("Reporte de Inventario");

                            Row fila = sheet.createRow(0);
                            File archivo = new File("Reporte de Inventario.xls");
                            Cell celda;

                            String[] titulos = {"Producto 1", "Producto 2", "Prroducto 3", "Producto 4", "Producto 5"};
                            Double[] datos = {d_inv_p1, d_inv_p2, d_inv_p3, d_inv_p4, d_inv_p5};

                            int i;
                            for (i = 0; i < titulos.length; i++) {
                                celda = fila.createCell(i);
                                celda.setCellValue(titulos[i]);
                            }
                            fila = sheet.createRow(1);
                            for (i = 0; i < datos.length; i++) {
                                celda = fila.createCell(i);
                                celda.setCellValue(datos[i]);
                            }
                            try {
                                FileOutputStream out = new FileOutputStream(archivo);
                                workbook.write(out);
                                out.close();
                                System.out.println("¡Archivo creado exitosamente!");
                            } catch (IOException ex) {
                                System.out.println("Error de escritura");
                                ex.printStackTrace();
                            }
                        }
                    });
                    archivo.add(guardar);
                    menu.add(archivo);
                    frame_grafica.getContentPane().add(panel_grafica);
                    frame_grafica.setBounds(60, 60, 450, 400);
                    frame_grafica.setJMenuBar(menu);
                    frame_grafica.setVisible(true);
                    frame_grafica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
                if (combobox.getSelectedIndex() == 4) {

                    datos_contabilidad.addValue(d_cont_e_lu, "Entradas", "Lunes");
                    datos_contabilidad.addValue(d_cont_e_ma, "Entradas", "Martes");
                    datos_contabilidad.addValue(d_cont_e_mi, "Entradas", "Miércoles");
                    datos_contabilidad.addValue(d_cont_e_ju, "Entradas", "Jueves");
                    datos_contabilidad.addValue(d_cont_e_vi, "Entradas", "Viernes");
                    datos_contabilidad.addValue(d_cont_e_sa, "Entradas", "Sábado");
                    datos_contabilidad.addValue(d_cont_e_do, "Entradas", "Domingo");

                    datos_contabilidad.addValue(d_cont_s_lu, "Salidas", "Lunes");
                    datos_contabilidad.addValue(d_cont_s_ma, "Salidas", "Martes");
                    datos_contabilidad.addValue(d_cont_s_mi, "Salidas", "Miércoles");
                    datos_contabilidad.addValue(d_cont_s_ju, "Salidas", "Jueves");
                    datos_contabilidad.addValue(d_cont_s_vi, "Salidas", "Viernes");
                    datos_contabilidad.addValue(d_cont_s_sa, "Salidas", "Sábado");
                    datos_contabilidad.addValue(d_cont_s_do, "Salidas", "Domingo");

                    datos_contabilidad.addValue(d_cont_u_lu, "Utilidades", "Lunes");
                    datos_contabilidad.addValue(d_cont_u_ma, "Utilidades", "Martes");
                    datos_contabilidad.addValue(d_cont_u_mi, "Utilidades", "Miércoles");
                    datos_contabilidad.addValue(d_cont_u_ju, "Utilidades", "Jueves");
                    datos_contabilidad.addValue(d_cont_u_vi, "Utilidades", "Viernes");
                    datos_contabilidad.addValue(d_cont_u_sa, "Utilidades", "Sábado");
                    datos_contabilidad.addValue(d_cont_u_do, "Utilidades", "Domingo");

                    Grafica = ChartFactory.createLineChart3D("Contabilidad", "Días", "Ingresos", datos_contabilidad, PlotOrientation.VERTICAL, true, true, false);

                    ChartPanel panel_grafica = new ChartPanel(Grafica);
                    JFrame frame_grafica = new JFrame("Gráfico");

                    JMenuBar menu = new JMenuBar();
                    JMenu archivo = new JMenu("Archivo");
                    JMenuItem guardar = new JMenuItem("Guardar como reporte...");
                    guardar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Document document = new Document();
                            PdfWriter writer = null;
                            try {
                                writer = PdfWriter.getInstance(document, new FileOutputStream("Gráfico Contabilidad.pdf"));
                            } catch (DocumentException ex) {
                                Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            document.open();
                            PdfContentByte cb = writer.getDirectContent();
                            PdfTemplate tp = cb.createTemplate(450, 450);
                            Graphics2D g2 = tp.createGraphicsShapes(450, 450);
                            menu.setVisible(false);
                            frame_grafica.print(g2);
                            menu.setVisible(true);
                            g2.dispose();
                            cb.addTemplate(tp, 30, 400);
                            document.close();

                            HSSFWorkbook workbook = new HSSFWorkbook();
                            HSSFSheet sheet = workbook.createSheet("Reporte de Contabilidad");

                            Row fila = sheet.createRow(0);
                            File archivo = new File("Reporte de Contabilidad.xls");
                            Cell celda;

                            String[] t_ent = {"E lunes", "E martes", "E miercoles", "E jueves", "E viernes", "E sabado", "E domingo"};
                            String[] t_sal = {"S lunes", "S martes", "S miercoles", "S jueves", "S viernes", "S sabado", "S domingo"};
                            String[] t_uti = {"U lunes", "U martes", "U miercoles", "U jueves", "U viernes", "U sabado", "U domingo"};
                            Double[] d_ent = {d_cont_e_lu, d_cont_e_ma, d_cont_e_mi, d_cont_e_ju, d_cont_e_vi, d_cont_e_sa, d_cont_e_do};
                            Double[] d_sal = {d_cont_s_lu, d_cont_s_ma, d_cont_s_mi, d_cont_s_ju, d_cont_s_vi, d_cont_s_sa, d_cont_s_do};
                            Double[] d_uti = {d_cont_u_lu, d_cont_u_ma, d_cont_u_mi, d_cont_u_ju, d_cont_u_vi, d_cont_u_sa, d_cont_u_do};

                            int i, j, k;
                            for (i = 0; i < t_ent.length; i++) {
                                celda = fila.createCell(i);
                                celda.setCellValue(t_ent[i]);
                            }
                            fila = sheet.createRow(1);
                            for (i = 0; i < d_ent.length; i++) {
                                celda = fila.createCell(i);
                                celda.setCellValue(d_ent[i]);
                            }
                            fila = sheet.createRow(3);
                            for (j = 0; j < t_sal.length; j++) {
                                celda = fila.createCell(j);
                                celda.setCellValue(t_sal[j]);
                            }
                            fila = sheet.createRow(4);
                            for (j = 0; j < d_sal.length; j++) {
                                celda = fila.createCell(j);
                                celda.setCellValue(d_sal[j]);
                            }
                            fila = sheet.createRow(6);
                            for (k = 0; k < t_uti.length; k++) {
                                celda = fila.createCell(k);
                                celda.setCellValue(t_uti[k]);
                            }
                            fila = sheet.createRow(7);
                            for (k = 0; k < d_uti.length; k++) {
                                celda = fila.createCell(k);
                                celda.setCellValue(d_uti[k]);
                            }
                            try {
                                FileOutputStream out = new FileOutputStream(archivo);
                                workbook.write(out);
                                out.close();
                                System.out.println("¡Archivo creado exitosamente!");
                            } catch (IOException ex) {
                                System.out.println("Error de escritura");
                                ex.printStackTrace();
                            }
                        }
                    });
                    archivo.add(guardar);
                    menu.add(archivo);
                    frame_grafica.getContentPane().add(panel_grafica);
                    frame_grafica.setBounds(60, 60, 450, 400);
                    frame_grafica.setJMenuBar(menu);
                    frame_grafica.setVisible(true);
                    frame_grafica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
                if (combobox.getSelectedIndex() == 5) {

                    datos_rec_hum.addValue(d_rh_a_lu, "Asistencias", "Lunes");
                    datos_rec_hum.addValue(d_rh_a_ma, "Asistencias", "Martes");
                    datos_rec_hum.addValue(d_rh_a_mi, "Asistencias", "Miércoles");
                    datos_rec_hum.addValue(d_rh_a_ju, "Asistencias", "Jueves");
                    datos_rec_hum.addValue(d_rh_a_vi, "Asistencias", "Viernes");
                    datos_rec_hum.addValue(d_rh_a_sa, "Asistencias", "Sábado");
                    datos_rec_hum.addValue(d_rh_a_do, "Asistencias", "Domingo");

                    datos_rec_hum.addValue(d_rh_r_lu, "Retardos", "Lunes");
                    datos_rec_hum.addValue(d_rh_r_ma, "Retardos", "Martes");
                    datos_rec_hum.addValue(d_rh_r_mi, "Retardos", "Miércoles");
                    datos_rec_hum.addValue(d_rh_r_ju, "Retardos", "Jueves");
                    datos_rec_hum.addValue(d_rh_r_vi, "Retardos", "Viernes");
                    datos_rec_hum.addValue(d_rh_r_sa, "Retardos", "Sábado");
                    datos_rec_hum.addValue(d_rh_r_do, "Retardos", "Domingo");

                    datos_rec_hum.addValue(d_rh_f_lu, "Faltas", "Lunes");
                    datos_rec_hum.addValue(d_rh_f_ma, "Faltas", "Martes");
                    datos_rec_hum.addValue(d_rh_f_mi, "Faltas", "Miércoles");
                    datos_rec_hum.addValue(d_rh_f_ju, "Faltas", "Jueves");
                    datos_rec_hum.addValue(d_rh_f_vi, "Faltas", "Viernes");
                    datos_rec_hum.addValue(d_rh_f_sa, "Faltas", "Sábado");
                    datos_rec_hum.addValue(d_rh_f_do, "Faltas", "Domingo");

                    Grafica = ChartFactory.createBarChart3D("Recursos Humanos", "Días", "Número de Empleados", datos_rec_hum, PlotOrientation.VERTICAL, true, true, false);

                    ChartPanel panel_grafica = new ChartPanel(Grafica);
                    JFrame frame_grafica = new JFrame("Gráfico");

                    JMenuBar menu = new JMenuBar();
                    JMenu archivo = new JMenu("Archivo");
                    JMenuItem guardar = new JMenuItem("Guardar como reporte...");
                    guardar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Document document = new Document();
                            PdfWriter writer = null;
                            try {
                                writer = PdfWriter.getInstance(document, new FileOutputStream("Gráfico Recursos Humanos.pdf"));
                            } catch (DocumentException ex) {
                                Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            document.open();
                            PdfContentByte cb = writer.getDirectContent();
                            PdfTemplate tp = cb.createTemplate(450, 450);
                            Graphics2D g2 = tp.createGraphicsShapes(450, 450);
                            menu.setVisible(false);
                            frame_grafica.print(g2);
                            menu.setVisible(true);
                            g2.dispose();
                            cb.addTemplate(tp, 30, 400);
                            document.close();

                            HSSFWorkbook workbook = new HSSFWorkbook();
                            HSSFSheet sheet = workbook.createSheet("Reporte de Recursos Humanos");

                            Row fila = sheet.createRow(0);
                            File archivo = new File("Reporte de Recursos Humanos.xls");
                            Cell celda;

                            String[] t_asi = {"A lunes", "A martes", "A miercoles", "A jueves", "A viernes", "A sabado", "A domingo"};
                            String[] t_ret = {"R lunes", "R martes", "R miercoles", "R jueves", "R viernes", "R sabado", "R domingo"};
                            String[] t_fal = {"F lunes", "F martes", "F miercoles", "F jueves", "F viernes", "F sabado", "F domingo"};
                            int[] d_asi = {d_rh_a_lu, d_rh_a_ma, d_rh_a_mi, d_rh_a_ju, d_rh_a_vi, d_rh_a_sa, d_rh_a_do};
                            int[] d_ret = {d_rh_r_lu, d_rh_r_ma, d_rh_r_mi, d_rh_r_ju, d_rh_r_vi, d_rh_r_sa, d_rh_r_do};
                            int[] d_fal = {d_rh_f_lu, d_rh_r_ma, d_rh_r_mi, d_rh_r_ju, d_rh_r_vi, d_rh_r_sa, d_rh_r_do};

                            int i, j, k;
                            for (i = 0; i < t_asi.length; i++) {
                                celda = fila.createCell(i);
                                celda.setCellValue(t_asi[i]);
                            }
                            fila = sheet.createRow(1);
                            for (i = 0; i < d_asi.length; i++) {
                                celda = fila.createCell(i);
                                celda.setCellValue(d_asi[i]);
                            }
                            fila = sheet.createRow(3);
                            for (j = 0; j < t_ret.length; j++) {
                                celda = fila.createCell(j);
                                celda.setCellValue(t_ret[j]);
                            }
                            fila = sheet.createRow(4);
                            for (j = 0; j < d_ret.length; j++) {
                                celda = fila.createCell(j);
                                celda.setCellValue(d_ret[j]);
                            }
                            fila = sheet.createRow(6);
                            for (k = 0; k < t_fal.length; k++) {
                                celda = fila.createCell(k);
                                celda.setCellValue(t_fal[k]);
                            }
                            fila = sheet.createRow(7);
                            for (k = 0; k < d_fal.length; k++) {
                                celda = fila.createCell(k);
                                celda.setCellValue(d_fal[k]);
                            }
                            try {
                                FileOutputStream out = new FileOutputStream(archivo);
                                workbook.write(out);
                                out.close();
                                System.out.println("¡Archivo creado exitosamente!");
                            } catch (IOException ex) {
                                System.out.println("Error de escritura");
                                ex.printStackTrace();
                            }
                        }
                    });
                    archivo.add(guardar);
                    menu.add(archivo);
                    frame_grafica.getContentPane().add(panel_grafica);
                    frame_grafica.setBounds(60, 60, 450, 400);
                    frame_grafica.setJMenuBar(menu);
                    frame_grafica.setVisible(true);
                    frame_grafica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        });

        jPanel = new JPanel();
        jPanel.setLayout(null);

        jPanel.add(cal1);
        jPanel.add(cal2);
        jPanel.add(etiqueta);
        jPanel.add(combobox);
        jPanel.add(calendario);
        jPanel.add(aceptar);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(jPanel);

        jFrame.setVisible(true);
    }
}
