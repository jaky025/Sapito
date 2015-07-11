/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad;

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
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

/**
 *
 * @author Arturo
 */
public class Capital extends JFrame{
    JFrame jFrame;
    JPanel jPanel;
   JFileChooser selecto=new JFileChooser();
   
    public Capital(){
        jFrame = new JFrame("Capital");
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
       
        
        JLabel capitalC=new JLabel("Capital Social: ");
        capitalC.setBounds(50, 90, 90, 20);
        jPanel.add(capitalC);
        
       JLabel cs=new JLabel("5000");
        cs.setBounds(140, 90, 90, 20);
        jPanel.add(cs);
        
        JLabel resultado=new JLabel("Resultado de ejercicio: ");
        resultado.setBounds(100, 130, 150, 20);
        jPanel.add(resultado);
        
        JLabel er=new JLabel("prueba");
        er.setBounds(250, 130, 90, 20);
        jPanel.add(er);
        
         JLabel capitalCT=new JLabel("Total Capital: ");
        capitalCT.setBounds(170, 170, 90, 20);
        jPanel.add(capitalCT);
        
        JLabel toc=new JLabel("prueba");
        toc.setBounds(270, 170, 90, 20);
        jPanel.add(toc);
        
      JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Inicio");
        JMenu jMenu2 = new JMenu("Reportes");
        JMenu jMenu3=new JMenu("Ayuda");
        
        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);
       
      
        JMenuItem jMenuItem2 = new JMenuItem("Reporte PDF");
        jMenuItem2.addActionListener(new MenuListener(jFrame));
        jMenuItem2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selecto=new JFileChooser();
                int op=selecto.showSaveDialog(null);
                if (op==JFileChooser.APPROVE_OPTION) {
                    try {
                        OutputStream archivo=new FileOutputStream(selecto.getSelectedFile()+".pdf");
                        Document document=new Document();
                        document.addAuthor("Contabilidad");
            document.addTitle("Capital");

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(selecto.getSelectedFile()+".pdf"));
            writer.setInitialLeading(16);
            Rectangle rct = new Rectangle(80, 104, 500, 688);
            writer.setBoxSize("art", rct);
            HeaderFooter event = new HeaderFooter();
            writer.setPageEvent(event);


            document.open();
            document.add(new Paragraph("Capital"));
        document.add(new Paragraph(" "));
        Paragraph parrafo3 = new Paragraph("Fecha: 25/5/42");
        parrafo3.setAlignment(2);//el 1 es para centrar
        document.add(parrafo3);
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        Paragraph parrafo2 = new Paragraph("Capital Social :  5000 ");
        parrafo2.setAlignment(6);//el 1 es para centrar
        document.add(parrafo2);
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        

        Paragraph parrafo5 = new Paragraph("Estado de resultados: ");
        parrafo5.setAlignment(6);//el 1 es para centrar
        document.add(parrafo5);

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
            
            
            document.close();
            archivo.close();
            Runtime.getRuntime().exec("cmd /c start "+selecto.getSelectedFile()+".pdf");
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Capital.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DocumentException ex) {
                        Logger.getLogger(Capital.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Capital.class.getName()).log(Level.SEVERE, null, ex);
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
       
        JMenuItem jMenuItem7 = new JMenuItem("Acerca de");
        jMenuItem7.addActionListener(new MenuListener(jFrame));

        jMenu.add(jMenuItem3);
        jMenu2.add(jMenuItem2);
        jMenu3.add(jMenuItem7);

        jFrame.setJMenuBar(jMenuBar);
        
        JButton botonac = new JButton("Aceptar");
        botonac.setBounds(300, 300, 150, 30);
        botonac.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Reportes es = new Reportes();
                jFrame.dispose();
            }
        });
        jPanel.add(botonac);
        
        
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }
//    public static void main(String[] args){
//        Capital capital=new Capital();
//    }
    

    

    static class HeaderFooter extends PdfPageEventHelper {

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

            Paragraph parrafo8 = new Paragraph("Capital", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK));
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
