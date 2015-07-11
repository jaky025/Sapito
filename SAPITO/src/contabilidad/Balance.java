/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad;

import Procesos.Proceso;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
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
public class Balance {

    public JFrame jFrame;
        int capit=5000;
    JLabel sysfecha = new JLabel();
    JFileChooser selector = new JFileChooser();

    public Balance() throws SQLException {

        jFrame = new JFrame("Balanace General");
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

        JLabel label = new JLabel("Balance General");
        label.setBounds(10, 10, 120, 20);
        jPanel.add(label);

        Calendar fecha1 = Calendar.getInstance();
        Calendar fecha2 = new GregorianCalendar();
        int año = fecha2.get(Calendar.YEAR);
        int mes = fecha2.get(Calendar.MONTH);
        int dia = fecha2.get(Calendar.DAY_OF_MONTH);
        Date date = new Date();
        sysfecha.setText(dia + "/" + (mes + 1) + "/" + año);
        JLabel fecha = new JLabel("Fecha de Reporte:  " + sysfecha.getText());
        fecha.setBounds(550, 10, 190, 15);
        jPanel.add(fecha);

        JLabel activo = new JLabel("Activo");
        activo.setBounds(30, 70, 90, 20);
        jPanel.add(activo);

        JLabel pasivo = new JLabel("Pasivo");
        pasivo.setBounds(400, 70, 90, 20);
        jPanel.add(pasivo);

        JLabel capital = new JLabel("Capital");
        capital.setBounds(30, 300, 90, 20);
        jPanel.add(capital);

        JLabel banco = new JLabel("Bancos");
        banco.setBounds(30, 100, 90, 20);
        jPanel.add(banco);

        JLabel ban = new JLabel();
        ban.setText(Double.toString(13000.82));
        ban.setBounds(200, 100, 90, 20);
        jPanel.add(ban);

        JLabel caja = new JLabel("Caja Chica");
        caja.setBounds(30, 120, 90, 20);
        jPanel.add(caja);

        JLabel cajon = new JLabel();
        float caj=(float) 12439.23;
        cajon.setText(Float.toString(caj));
        cajon.setBounds(200, 120, 90, 20);
        jPanel.add(cajon);

        JLabel cobrar = new JLabel("Cuentas por Cobrar");
        cobrar.setBounds(30, 140, 120, 20);
        jPanel.add(cobrar);

        JLabel cxc = new JLabel();
        cxc.setText(Float.toString(new Proceso().costoVen()));
        cxc.setBounds(200, 140, 90, 20);
        jPanel.add(cxc);

        JLabel ivaA = new JLabel("IVA Acreditable");
        ivaA.setBounds(30, 160, 90, 20);
        jPanel.add(ivaA);

        JLabel iva = new JLabel();
        iva.setText(Float.toString(new Proceso().ivaAcreditable()));
        iva.setBounds(200, 160, 90, 20);
        jPanel.add(iva);

        JLabel inv = new JLabel("Inventario");
        inv.setBounds(30, 180, 90, 20);
        jPanel.add(inv);

        JLabel vent = new JLabel();
        vent.setText(Float.toString(new Proceso().inventario()));
        vent.setBounds(200, 180, 90, 20);
        jPanel.add(vent);

        JLabel af = new JLabel("Activo Fijo");
        af.setBounds(30, 200, 90, 20);
        jPanel.add(af);

        JLabel acf = new JLabel();
        acf.setText(Float.toString(new Proceso().inmueble()));
        acf.setBounds(200, 200, 90, 20);
        jPanel.add(acf);
        
        JLabel totalA = new JLabel("Total: ");
        totalA.setBounds(150, 220, 90, 20);
        jPanel.add(totalA);
        
        JLabel tot = new JLabel(Float.toString(totalActivo(ban.getText(), cajon.getText(), cxc.getText(), iva.getText(), vent.getText(), acf.getText())));
        tot.setBounds(200, 220, 90, 20);
     
        jPanel.add(tot);

        JLabel cp = new JLabel("Cuentas por Pagar");
        cp.setBounds(400, 100, 120, 20);
        jPanel.add(cp);

        JLabel cxp = new JLabel(Float.toString(new Proceso().ventas()));
        cxp.setBounds(550, 100, 90, 20);
        jPanel.add(cxp);

        JLabel sp = new JLabel("Salarios por Pagar");
        sp.setBounds(400, 120, 120, 20);
        jPanel.add(sp);

        JLabel slp = new JLabel(Float.toString(new Proceso().nomina()));
        slp.setBounds(550, 120, 90, 20);
        jPanel.add(slp);

        JLabel ip = new JLabel("IVA por Pagar");
        ip.setBounds(400, 140, 120, 20);
        jPanel.add(ip);

        JLabel ixp = new JLabel(Float.toString(new Proceso().impuestos()));
        ixp.setBounds(550, 140, 90, 20);
        jPanel.add(ixp);
        
        JLabel totalP = new JLabel("Total: ");
        totalP.setBounds(500, 160, 120, 20);
        jPanel.add(totalP);
        
        JLabel totalPc = new JLabel("Total: ");
        totalPc.setBounds(410, 350, 120, 20);
        jPanel.add(totalPc);
        
       

        JLabel tota = new JLabel(Float.toString(totalPasivo(cxp.getText(),slp.getText(),ixp.getText())));
        tota.setBounds(550, 160, 90, 20);
        jPanel.add(tota);

        JLabel cpe = new JLabel("Capital Social");
        cpe.setBounds(30, 330, 90, 20);
        jPanel.add(cpe);

        JLabel cs = new JLabel();
        cs.setText(Float.toString(capit));
        cs.setBounds(200, 330, 90, 20);
        jPanel.add(cs);

        JLabel er = new JLabel("Estado de Resultado");
        er.setBounds(30, 350, 120, 20);
        jPanel.add(er);

        JLabel est = new JLabel(" ");
        est.setBounds(200, 350, 90, 20);
        jPanel.add(est);

        JLabel total = new JLabel("Total");
        total.setBounds(200, 370, 90, 20);
        jPanel.add(total);
        
         JLabel totalPC = new JLabel(Float.toString(totalPasivoactivo(cxp.getText(),slp.getText(),ixp.getText(),capit)));
        totalPC.setBounds(450, 350, 120, 20);
        jPanel.add(totalPC);
        
        JLabel tot1 = new JLabel("=   "+Float.toString(totalActivo(ban.getText(), cajon.getText(), cxc.getText(), iva.getText(), vent.getText(), acf.getText())));
        tot1.setBounds(505, 350, 90, 20);
        tot1.setBackground(Color.white);
        jPanel.add(tot1);
        
        

        JButton boton = new JButton("Regresar");
        boton.setBounds(300, 450, 150, 30);
        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaGeneral es = new VentanaGeneral();
                jFrame.dispose();
            }
        });
        jPanel.add(boton);

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
                        int dinero=5000;
                        float cxc=new Proceso().costoVen();
                        float inv=new Proceso().inventario();
                        float iva=new Proceso().ivaAcreditable();
                        float prove=new Proceso().ventas();
                        float impuesto=new Proceso().impuestos();
                        
                        Sheet sheet1 = wb.createSheet("Unica Hoja");

                        Row row = sheet1.createRow((short) 0);
                        sheet1.createRow((short)2).createCell((short)0).setCellValue("   Estado de Situacion Financiera");
                        sheet1.addMergedRegion(new CellRangeAddress(2,2,0,5));
                        sheet1.createRow((short)3).createCell((short)0).setCellValue("   Empresa Sapito S.A. de C.V.");
                        sheet1.addMergedRegion(new CellRangeAddress(3,3,0,5));
                        sheet1.createRow((short)4).createCell((short)0).setCellValue("Fecha: ");
                        sheet1.addMergedRegion(new CellRangeAddress(4,4,0,5));
                        sheet1.createRow((short)6).createCell((short)0).setCellValue(" Activo");
                        sheet1.addMergedRegion(new CellRangeAddress(6,6,0,5));
                        sheet1.createRow(7).createCell(2).setCellValue(" Efectivo");
                        sheet1.getRow(7).createCell(5).setCellValue(dinero);
                        sheet1.createRow(8).createCell(2).setCellValue(" Cuentas por Cobrar");
                        sheet1.getRow(8).createCell(5).setCellValue(cxc);
                        sheet1.createRow(10).createCell(2).setCellValue(" Inventario ");
                        sheet1.getRow(10).createCell(5).setCellValue(inv);
                        sheet1.createRow(11).createCell(2).setCellValue(" IVA ");
                        sheet1.getRow(11).createCell(5).setCellValue(iva);
                        sheet1.createRow(13).createCell(3).setCellValue(" Total ");
                        sheet1.getRow(13).createCell(5).setCellValue(dinero+cxc+inv+iva);
                        sheet1.createRow(12).createCell(2).setCellValue(" Total Activo Circulante");
                        sheet1.createRow((short)15).createCell((short)0).setCellValue(" Pasivo y Patrimonio ");
                        sheet1.addMergedRegion(new CellRangeAddress(15,15,0,5));
                        sheet1.createRow(16).createCell(2).setCellValue(" Proveedores ");
                        sheet1.getRow(16).createCell(5).setCellValue(prove);
                        sheet1.createRow(17).createCell(2).setCellValue(" Impuesto Sobre la Renta ");
                        sheet1.getRow(17).createCell(5).setCellValue(impuesto);
                        sheet1.createRow(19).createCell(2).setCellValue(" Total Pasivo ");
                        sheet1.getRow(19).createCell(5).setCellValue(prove+impuesto);
                        sheet1.createRow((short)22).createCell((short)0).setCellValue(" Patrimonio ");
                        sheet1.addMergedRegion(new CellRangeAddress(22,22,0,5));
                        sheet1.createRow(23).createCell(2).setCellValue(" Capital Social ");
                        sheet1.getRow(23).createCell(5).setCellValue(capit);
                        sheet1.createRow(24).createCell(2).setCellValue(" Utilidad de Ejercicio ");
                        sheet1.createRow(25).createCell(2).setCellValue(" Total de Patrimonio ");
                        sheet1.getRow(25).createCell(5).setCellValue(capit);
                        sheet1.createRow(27).createCell(2).setCellValue(" Suma el Pasivo y Capital ");
                        sheet1.getRow(27).createCell(5).setCellValue(capit+prove+impuesto);

                        wb.write(archivo);
                        archivo.close();
                        Runtime.getRuntime().exec("cmd /c start " + selector.getSelectedFile() + ".xls");
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Balance.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Balance.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Balance.class.getName()).log(Level.SEVERE, null, ex);
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

        jFrame.add(jPanel);
        jFrame.setVisible(true);

    }
    public float totalPasivo(String cxp,String sueldos, String impuestos)
    {
        float total=0;
        float var = Float.parseFloat(cxp);
        float var1 = Float.parseFloat(sueldos);
        float var2 = Float.parseFloat(impuestos);
        total=var+var1+var2;
        return total;
    }
    
     public float totalPasivoactivo(String cxp,String sueldos, String impuestos,int capit)
    {
        float total=0;
        float var = Float.parseFloat(cxp);
        float var1 = Float.parseFloat(sueldos);
        float var2 = Float.parseFloat(impuestos);
        float var3 = capit;
        total=var+var1+var2+var3;
        return total;
    }
    public float totalActivo(String ban, String cajach, String cxc, String ivaa, String inv, String inm) {
        float total = 0;
        float var = Float.parseFloat(ban);
        float var1 = Float.parseFloat(cajach);
        float var2 = Float.parseFloat(cxc);
        float var3 = Float.parseFloat(ivaa);
        float var4 = Float.parseFloat(inv);
        float var5 = Float.parseFloat(inm);

        total = var + var1 + var2 + var3 + var4 + var5;
        return total;
    }

//    public static void main(String[] args) throws SQLException {
//        Balance simple09 = new Balance();
//    }

}
