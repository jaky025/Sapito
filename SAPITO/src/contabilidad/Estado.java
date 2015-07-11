/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad;

import Procesos.Proceso;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Arturo
 */
public class Estado extends JFrame {

    JFrame jFrame;
    JPanel jPanel;
    JLabel sysfecha = new JLabel();
    JFileChooser selector = new JFileChooser();
    public ResultSet rs;
    public Statement st;

    public Estado() throws SQLException {
        jFrame = new JFrame("Estado de Resultados");
        jFrame.setDefaultCloseOperation(jFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setIconImage(new ImageIcon(getClass().getResource("../imagenes/rana.jpg")).getImage());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("X:" + screenSize.width + " Y:" + screenSize.height);
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Inicio");
        JMenu jMenu2 = new JMenu("Reportes");
        JMenu jMenu3 = new JMenu("Ayuda");

        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);

        JMenuItem jMenuIte = new JMenuItem("Reporte Excel");
        jMenuIte.addActionListener(new MenuListener(jFrame));
        jMenuIte.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selector = new JFileChooser();
                int op = selector.showSaveDialog(null);
                if (op == JFileChooser.APPROVE_OPTION) {
                    try {
                        OutputStream archivo = new FileOutputStream(selector.getSelectedFile() + ".xls");
                        Workbook wb;
                        if (".xls".equals(".xls")) {
                            wb = new HSSFWorkbook();
                        } else {
                            wb = new XSSFWorkbook();
                        }
                        Sheet sheet1 = wb.createSheet("Unica Hoja");

                        Row row = sheet1.createRow((short) 0);

                        sheet1.createRow((short) 0).createCell((short) 0).setCellValue("   Estado de Resultados ");
                        sheet1.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
                        sheet1.createRow((short) 1).createCell((short) 0).setCellValue("   Empresa Sapito S.A. de C.V.");
                        sheet1.addMergedRegion(new CellRangeAddress(1, 1, 0, 3));
                        sheet1.createRow((short) 2).createCell((short) 0).setCellValue("Fecha: ");
                        sheet1.addMergedRegion(new CellRangeAddress(2, 2, 0, 3));
                        sheet1.createRow((short) 4).createCell((short) 0).setCellValue("Ventas ");
                        sheet1.addMergedRegion(new CellRangeAddress(4, 4, 0, 3));

                        sheet1.createRow(5).createCell(1).setCellValue("  Costo de Venta");
                        sheet1.getRow(5).createCell(2).setCellValue(new Proceso().costoVen());

                        sheet1.createRow((short) 10).createCell((short) 0).setCellValue("Gastos: Depto. Administracion");
                        sheet1.addMergedRegion(new CellRangeAddress(10, 10, 0, 3));
                        sheet1.createRow(11).createCell(1).setCellValue("Utilidad de Operacion");
                        sheet1.createRow(13).createCell(1).setCellValue("Utilidad");
                        sheet1.getRow(13).createCell(2).setCellValue(new Proceso().costoVen());
                        sheet1.createRow(14).createCell(1).setCellValue("Utilidad Neta");
                        sheet1.getRow(14).createCell(2).setCellValue(new Proceso().ventatotal());

                        sheet1.createRow(7).createCell(1).setCellValue("Gastos de Planta");
                        sheet1.getRow(7).createCell(2).setCellValue(new Proceso().salariocom());

                        sheet1.createRow(8).createCell(1).setCellValue("Gastos de Venta ");

                        wb.write(archivo);
                        archivo.close();
                        Runtime.getRuntime().exec("cmd /c start " + selector.getSelectedFile() + ".xls");
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Estado.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Estado.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Estado.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        });
        JMenuItem jMenuItem3 = new JMenuItem("Salir");
        jMenuItem3.addActionListener(new MenuListener(jFrame));
        jMenuItem3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaGeneral es = new VentanaGeneral();
                jFrame.dispose();
            }
        });

        JMenuItem jMenuItem7 = new JMenuItem("Acerca De");
        jMenuItem7.addActionListener(new MenuListener(jFrame));

        jMenu2.add(jMenuIte);
        jMenu.add(jMenuItem3);
        jMenu3.add(jMenuItem7);

        jFrame.setJMenuBar(jMenuBar);
        Calendar fecha1 = Calendar.getInstance();
        Calendar fecha2 = new GregorianCalendar();
        int año = fecha2.get(Calendar.YEAR);
        int mes = fecha2.get(Calendar.MONTH);
        int dia = fecha2.get(Calendar.DAY_OF_MONTH);
        Date date = new Date();
        sysfecha.setText(dia + "/" + (mes + 1) + "/" + año);
        JLabel fecha = new JLabel("Fecha de Estado:  " + sysfecha.getText());
        fecha.setBounds(600, 10, 190, 15);
        jPanel.add(fecha);

        JLabel label = new JLabel("Estado de Resultados");
        label.setBounds(30, 10, 160, 20);
        jPanel.add(label);

        JLabel ve = new JLabel("Ventas");
        ve.setBounds(30, 50, 120, 20);
        jPanel.add(ve);

        JLabel vel = new JLabel(Float.toString(new Proceso().ventas()));
        vel.setBounds(270, 50, 90, 20);
        jPanel.add(vel);

        JLabel de = new JLabel("Descuentos");
        de.setBounds(30, 70, 120, 20);
        jPanel.add(de);

        JLabel cv = new JLabel("Costo de Ventas");
        cv.setBounds(30, 90, 120, 20);
        jPanel.add(cv);

        JLabel cov = new JLabel(Float.toString(new Proceso().costoVen()));
        cov.setBounds(270, 90, 90, 20);
        jPanel.add(cov);

        JLabel gv = new JLabel("Gastos de Ventas");
        gv.setBounds(30, 140, 120, 20);
        jPanel.add(gv);

        JLabel s = new JLabel("Salarios");
        s.setBounds(30, 160, 120, 20);
        jPanel.add(s);

        JLabel gav = new JLabel(Float.toString(new Proceso().salarioVent()));
        gav.setBounds(270, 160, 90, 20);
        jPanel.add(gav);

        JLabel gc = new JLabel("Gastos de Compras");
        gc.setBounds(30, 190, 120, 20);
        jPanel.add(gc);

        JLabel sa = new JLabel("Salarios");
        sa.setBounds(30, 210, 120, 20);
        jPanel.add(sa);

        JLabel gac = new JLabel(Float.toString(new Proceso().salariocom()));
        gac.setBounds(270, 210, 90, 20);
        jPanel.add(gac);

        JLabel gi = new JLabel("Gastos de Inventario");
        gi.setBounds(30, 240, 120, 20);
        jPanel.add(gi);

        JLabel sa2 = new JLabel("Salarios");
        sa2.setBounds(30, 260, 120, 20);
        jPanel.add(sa2);

        JLabel gai = new JLabel(Float.toString(new Proceso().salarioinv()));
        gai.setBounds(270, 260, 90, 20);
        jPanel.add(gai);

        JLabel gd = new JLabel("Gastos de Direccion");
        gd.setBounds(30, 290, 120, 20);
        jPanel.add(gd);

        JLabel sa3 = new JLabel("Salarios");
        sa3.setBounds(30, 310, 120, 20);
        jPanel.add(sa3);

        JLabel gad = new JLabel(Float.toString(new Proceso().salariodir()));
        gad.setBounds(270, 310, 90, 20);
        jPanel.add(gad);

        JLabel grh = new JLabel("Gastos de Recursos Humanos");
        grh.setBounds(30, 340, 200, 20);
        jPanel.add(grh);

        JLabel sa4 = new JLabel("Salarios");
        sa4.setBounds(30, 360, 120, 20);
        jPanel.add(sa4);

        JLabel gar = new JLabel(Float.toString(new Proceso().salarioRH()));
        gar.setBounds(270, 360, 90, 20);
        jPanel.add(gar);

        JLabel gcc = new JLabel("Gastos de Contabilidad");
        gcc.setBounds(30, 390, 160, 20);
        jPanel.add(gcc);

        JLabel sa5 = new JLabel("Salarios");
        sa5.setBounds(30, 410, 200, 20);
        jPanel.add(sa5);

        JLabel gacc = new JLabel(Float.toString(new Proceso().salariocont()));
        gacc.setBounds(270, 410, 90, 20);
        jPanel.add(gacc);

        JLabel gm = new JLabel("Gastos de Mantenimiento");
        gm.setBounds(30, 440, 160, 20);
        jPanel.add(gm);

        JLabel sa6 = new JLabel("Salarios");
        sa6.setBounds(30, 460, 200, 20);
        jPanel.add(sa6);

        JLabel gamm = new JLabel(Float.toString(new Proceso().salariomant()));
        gamm.setBounds(270, 460, 90, 20);
        jPanel.add(gamm);

        JLabel ot = new JLabel("Otros Gastos");
        ot.setBounds(30, 490, 160, 20);
        jPanel.add(ot);

        JLabel ma = new JLabel("Mantenimiento");
        ma.setBounds(30, 510, 160, 20);
        jPanel.add(ma);

        JLabel gma = new JLabel("Prueba");
        gma.setBounds(270, 510, 90, 20);
        jPanel.add(gma);
        
        JLabel total = new JLabel("Utilidad:  "+Float.toString(totalt(gamm.getText(), vel.getText(), cov.getText(), gav.getText(), gac.getText(), gacc.getText(),gar.getText(), gad.getText(), gai.getText())));
        total.setBounds(450, 100, 90, 20);
        jPanel.add(total);

        JButton boton = new JButton("Regresar");
        boton.setBounds(600, 450, 150, 30);
        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaGeneral es = new VentanaGeneral();
                jFrame.dispose();
            }
        });
        jPanel.add(boton);

        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

   public float totalt(String gamm, String vel, String cov, String gav, String gac, String gacc, String gar, String gad, String gai) {
        float total = 0;
        float var = Float.parseFloat(gamm);
        float var1 = Float.parseFloat(vel);
        float var2 = Float.parseFloat(cov);
        float var3 = Float.parseFloat(gav);
        float var4 = Float.parseFloat(gac);
        float var5 = Float.parseFloat(gacc);
        float var6 = Float.parseFloat(gar);
        float var7 = Float.parseFloat(gad);
        float var8 = Float.parseFloat(gai);
        total = var + var1 + var3+var4+var5+var6+var7+var8-var2;
        return total;
    }

//    public static void main(String arg[]) throws SQLException {
//        Estado as = new Estado();
//    }

}
