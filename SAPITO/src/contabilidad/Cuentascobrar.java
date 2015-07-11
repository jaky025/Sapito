/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad;

import Conexion.DataBaseManager;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JCalendar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
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


/**
 *
 * @author Arturo
 */
public class Cuentascobrar extends JFrame {

    public JFrame jFrame;
    public JPanel jPanel;
    JFileChooser selector = new JFileChooser();
    String año;
    String mes;
    String dia;
    String fechaCal;
    JRadioButton cliente;
    JTextField text;
    JTable jTable;
    DefaultTableModel model;
    Statement  st;
    ResultSet rs;
    public Cuentascobrar() throws SQLException {

        jFrame = new JFrame("Cuentas por Cobrar");
        jFrame.setDefaultCloseOperation(jFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setIconImage(new ImageIcon(getClass().getResource("../imagenes/rana.jpg")).getImage());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("X:" + screenSize.width + " Y:" + screenSize.height);
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        System.out.println("X:" + x + "Y" + y);
        jFrame.setLocation(x, y);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        JCalendar calendar = new JCalendar();
        calendar.setBounds(15, 340, 325, 200);

        String columnNames[] = {"ID Cliente", "ID Producto", "Tipo de Documento", "Fecha", "Importe"};
        String tablaContent[][] = {{}};
        model=new DefaultTableModel(tablaContent, columnNames);

        jTable = new JTable(model);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn columna1 = jTable.getColumn("Tipo de Documento");
        columna1.setMinWidth(150);

        TableColumn columna2 = jTable.getColumn("ID Cliente");
        columna2.setMinWidth(130);

        TableColumn columna3 = jTable.getColumn("ID Producto");
        columna3.setMinWidth(160);
        
        TableColumn columna4 = jTable.getColumn("Importe");
        columna4.setMinWidth(85);
        

        JScrollPane jScrollpane = new JScrollPane(jTable);
        jScrollpane.setBounds(90, 110, 603, 200);

        JLabel cc = new JLabel("Cuentas por Cobrar");
        cc.setBounds(15, 15, 120, 20);
        jPanel.add(cc);

        text = new JTextField();
        text.setBounds(80, 50, 200, 20);
        text.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'A' || car > 'Z') && (car < 'a' || car > 'z') && (car != (char) KeyEvent.VK_SPACE)) {
                    ke.consume();
                }
                if (text.getText().length() + 1 > 60) {
                    JOptionPane.showMessageDialog(null, "Sobrepasa el Nivel de Caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    text.setText("");
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
        JTextField textfa = new JTextField("");
        textfa.setBounds(360, 50, 180, 20);
        textfa.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')) {
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
        jPanel.add(textfa);

        JLabel fecha = new JLabel("Fecha");
        cliente = new JRadioButton("Cliente", false);
        ButtonGroup grupo1 = new ButtonGroup();

        grupo1.add(cliente);
        cliente.setSelected(true);
        textfa.setEditable(false);
        cliente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (cliente.getModel().isSelected()) {

                    textfa.setEditable(false);
                    text.setEditable(true);
                    textfa.setText("");
                    calendar.setVisible(false);
                }
            }
        });

        fecha.setBounds(290, 50, 70, 20);
        jPanel.add(text);
        cliente.setBounds(5, 50, 70, 20);
        jPanel.add(cliente);

        JLabel lable1 = new JLabel("Saldo Total Liquidado");
        lable1.setBounds(360, 380, 190, 20);
        jPanel.add(lable1);

        JLabel text1 = new JLabel();
        text1.setBounds(500, 380, 90, 20);
        jPanel.add(text1);

        JLabel IT = new JLabel("Importe Total");
        IT.setBounds(360, 420, 120, 20);
        jPanel.add(IT);

        JLabel IT1 = new JLabel();
        IT1.setBounds(500, 420, 90, 20);
        jPanel.add(IT1);

        JCheckBox box = new JCheckBox();
        box.setBounds(10, 50, 20, 20);
        jPanel.add(box);
        JButton boton1 = new JButton("Buscar");
        boton1.setBounds(580, 45, 150, 30);
        boton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              
                try {
                    if (cliente.isSelected()) {
                        st = DataBaseManager.getConexion().createStatement();
                         rs = st.executeQuery("select v.ID_CLIENTE,\n" +
"        v.ID_PRODUCTO,\n" +
"        v.FECHA,\n" +
"        v.CATIDAD_PROD,\n" +
"        v.SUBTOTAL,\n" +
"        v.TOTAL \n" +
"from VENTAS v join CLIENTES c on(v.ID_CLIENTE=c.ID_CLIENTE) and c.NOMBRE='"+text.getText()+"'");
                        if(rs.next())
                        {
                            Object datos[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                            model.addRow(datos);
                        }
                    }
                    else
                    {
                        Statement  st = DataBaseManager.getConnection().createStatement();
                        ResultSet rs = st.executeQuery("select (ID_CLIENTE,ID_PRODUCTO,FECHA,CANTIDAD_PROD,SUBTOTAL,TOTAL) from VENTAS");
                    }
                    
                    
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                } catch (SQLException ex) {
                    Logger.getLogger(Cuentascobrar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

/////CALENDARIO
        calendar.setVisible(false);
        JButton calen = new JButton("Cal");
        calen.setBounds(540, 50, 20, 20);
        calen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                text.setEditable(false);
                text.setText("");
                calendar.setVisible(true);
                año = Integer.toString(calendar.getCalendar().get(java.util.Calendar.YEAR));
                mes = Integer.toString(calendar.getCalendar().get(java.util.Calendar.MONTH) + 1);
                dia = Integer.toString(calendar.getCalendar().get(java.util.Calendar.DATE));
                fechaCal = dia + "/" + mes + "/" + año;
                textfa.setText(fechaCal);

            }
        });
        boton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (textfa.getText().isEmpty() && text.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo vacio", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (text.getText().length() == 0 && textfa.getText().length() > 0) {
                        año = Integer.toString(calendar.getCalendar().get(java.util.Calendar.YEAR));
                        mes = Integer.toString(calendar.getCalendar().get(java.util.Calendar.MONTH) + 1);
                        dia = Integer.toString(calendar.getCalendar().get(java.util.Calendar.DATE));
                        fechaCal = dia + "/" + mes + "/" + año;
                        textfa.setText(fechaCal);
                    }
                }
            }
        });

        JButton boton6 = new JButton("Regresar");
        boton6.setBounds(580, 485, 150, 30);
        boton6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Reportes es = new Reportes();
                jFrame.dispose();
            }
        });
        jPanel.add(boton6);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Inicio");
        JMenu jMenu2 = new JMenu("Reportes");
        JMenu jMenu3 = new JMenu("Ayuda");

        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);

        JMenuItem jMenuItem2 = new JMenuItem("Reporte PDF");
        jMenuItem2.addActionListener(new MenuListener(jFrame));
        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selector = new JFileChooser();
                int op = selector.showSaveDialog(Cuentascobrar.this);
                if (op == JFileChooser.APPROVE_OPTION) {
                    try {
                        OutputStream archivo = new FileOutputStream(selector.getSelectedFile() + ".pdf");
                        Document doc = new Document();
                        PdfWriter writer = PdfWriter.getInstance(doc, archivo);
                        writer.setInitialLeading(16);
                        Rectangle rct = new Rectangle(80, 104, 500, 688);
                        writer.setBoxSize("art", rct);
                        HeaderFooter event = new HeaderFooter();
                        writer.setPageEvent(event);

                        doc.open();
                        doc.add(new Paragraph("Cuentas por Cobrar"));
                        doc.add(new Paragraph(" "));
                        Paragraph parrafo3 = new Paragraph("Fecha: 25/5/42");
                        parrafo3.setAlignment(2);//el 1 es para centrar
                        doc.add(parrafo3);
                        doc.add(new Paragraph(" "));
                        doc.add(new Paragraph(" "));
                        doc.add(new Paragraph(" "));
                        Paragraph parrafo2 = new Paragraph("Cliente: ");
                        parrafo2.setAlignment(1);//el 1 es para centrar
                        doc.add(parrafo2);
                        doc.add(new Paragraph(" "));
                        doc.add(new Paragraph(" "));
                        doc.add(new Paragraph(" "));

                        String nombres[] = {"ID CLIENTE", "ID PRODUCTO", "Tipo de documento", "Fecha", "Importe"};
                        PdfPTable pdfPTable = new PdfPTable(nombres.length);
                        for (int i = 0; i < jTable.getRowCount(); i++) {
                            for (int j = 0; j < jTable.getColumnCount(); j++) {
                                pdfPTable.addCell(jTable.getValueAt(i, j).toString());
                            }
                        }
                        PdfPCell cell = new PdfPCell(new Phrase());
                        pdfPTable.addCell(cell);

                        for (int i = 0; i < nombres.length; i++) {
                            cell = new PdfPCell(new Phrase(nombres[i]));
                            pdfPTable.addCell(cell);
                        }
                        doc.add(new Paragraph(" "));
                        doc.add(new Paragraph(" "));

                        Paragraph parrafo4 = new Paragraph("Importe Total Liquidado: "+rs.getString(5));
                        parrafo4.setAlignment(2);//el 1 es para centrar
                        doc.add(parrafo4);

                        Paragraph parrafo5 = new Paragraph("Importe Total: "+rs.getString(6));
                        parrafo5.setAlignment(2);//el 1 es para centrar
                        doc.add(parrafo5);

                        doc.add(new Paragraph(" "));
                        doc.add(new Paragraph(" "));

                        doc.add(pdfPTable);
                        doc.close();
                        archivo.close();
                        Runtime.getRuntime().exec("cmd /c start " + selector.getSelectedFile() + ".pdf");

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
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

        jMenu.add(jMenuItem3);
        jMenu2.add(jMenuItem2);
        jMenu3.add(jMenuItem7);
        jPanel.add(fecha);
        jPanel.add(boton1);
        jPanel.add(calen);
        jPanel.add(calendar);
        jPanel.add(jScrollpane);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(jPanel);
        jFrame.setVisible(true);

    }

//    public static void main(String[] args) throws SQLException {
//        Cuentascobrar simple09 = new Cuentascobrar();
//    }
    static class HeaderFooter extends PdfPageEventHelper {

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            Rectangle rect = writer.getBoxSize("art");

            Image imghead = null;
            PdfContentByte cbhead = null;

            try {
                imghead = Image.getInstance("LogoSapito5.png");
                imghead.setAbsolutePosition(0, 0);
                imghead.setAlignment(Image.ALIGN_CENTER);
                imghead.scalePercent(10f);
                cbhead = writer.getDirectContent();
                PdfTemplate tp = cbhead.createTemplate(100, 150);
                tp.addImage(imghead);
                cbhead.addTemplate(tp, 100, 715);

            } catch (BadElementException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(Cuentaspagar.class.getName()).log(Level.SEVERE, null, ex);
            }

            Phrase headPhraseImg = new Phrase(cbhead + "", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7, Font.NORMAL));

            Calendar c1 = Calendar.getInstance();
            Calendar c2 = new GregorianCalendar();
            String dia, mes, annio;
            dia = Integer.toString(c1.get(Calendar.DATE));
            mes = Integer.toString(c1.get(Calendar.MONTH));
            annio = Integer.toString(c1.get(Calendar.YEAR));
            java.util.Date fecha = new Date();
            String fechis = dia + "/" + mes + "/" + annio;
            Paragraph parrafo5 = new Paragraph(fechis, FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK));
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(parrafo5),
                    rect.getRight(450), rect.getTop(-80), 0);

            Paragraph parrafo7 = new Paragraph("Empresa Sapito S.A. de C.V.", FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK));
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(parrafo7),
                    rect.getBottom(250), rect.getTop(-60), 0);

            Paragraph parrafo8 = new Paragraph("Cuentas por cobrar", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK));
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(parrafo8),
                    rect.getBottom(250), rect.getTop(-40), 0);

            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_BOTTOM, new Phrase("      _________________________________________________________________________________    "),
                    rect.getBorder(), rect.getTop(-24), 0);

            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_BOTTOM, new Phrase("      _________________________________________________________________________________    "),
                    rect.getBorder(), rect.getTop(-20), 0);

            Paragraph parrafo6 = new Paragraph(String.format("Pág %d", writer.getPageNumber()), FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK));
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(parrafo6),
                    rect.getRight(-35), rect.getTop(-80), 0);

        }
    }
}
