/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package direccion;

import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Element;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Oscar Gabriel
 */
public class GeneradorFormato extends PdfPageEventHelper {

    @Override
    public void onEndPage(PdfWriter writer, Document document) {

        Rectangle rect = writer.getBoxSize("art");
        Image imghead = null;
        PdfContentByte cbhead = null;

//        try {
//            imghead = Image.getInstance("LogoSapito5.png");
//            imghead.setAbsolutePosition(0, 0);
//            imghead.setAlignment(Image.ALIGN_CENTER);
//            imghead.scalePercent(10f);
//            cbhead = writer.getDirectContent();
//            PdfTemplate tp = cbhead.createTemplate(100, 150);
//            tp.addImage(imghead);
//            cbhead.addTemplate(tp, 100, 715);
//        } catch (BadElementException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }

        Phrase headPhraseImg = new Phrase(cbhead + "", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7, Font.NORMAL));

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = new GregorianCalendar();
        String dia, mes, annio;
        dia = Integer.toString(c1.get(Calendar.DATE));
        mes = Integer.toString(c1.get(Calendar.MONTH));
        annio = Integer.toString(c1.get(Calendar.YEAR));
        Date fecha = new Date();
        String fechis = dia + "/" + mes + "/" + annio;
        
        Paragraph parrafo5 = new Paragraph(fechis, FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK));
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(parrafo5), rect.getRight(450), rect.getTop(-80), 0);

        Paragraph parrafo7 = new Paragraph("Empresa Sapito S.A. de C.V.", FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK));
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(parrafo7), rect.getBottom(250), rect.getTop(-60), 0);

        Paragraph parrafo8 = new Paragraph("Reporte algoooooo", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK));
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(parrafo8), rect.getBottom(250), rect.getTop(-40), 0);

        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_BOTTOM, new Phrase("      _____________________________________________________________________________________    "), rect.getBorder(), rect.getTop(650), 0);

        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_BOTTOM, new Phrase("      _____________________________________________________________________________________    "), rect.getBorder(), rect.getTop(-24), 0);

        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_BOTTOM, new Phrase("      _____________________________________________________________________________________    "), rect.getBorder(), rect.getTop(-20), 0);

        Paragraph parrafo6 = new Paragraph(String.format("Pág %d", writer.getPageNumber()), FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK));
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(parrafo6), rect.getRight(-35), rect.getTop(-80), 0);
    }

    public static void main(String[] args) {

        try {
            Document document = new Document(PageSize.LETTER, 50, 50, 85, 50);
            document.addAuthor("Dirección");
            document.addTitle("Reporte de algo");

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Reporte prueba.pdf"));
            writer.setInitialLeading(16);
            Rectangle rct = new Rectangle(80, 104, 500, 688);
            writer.setBoxSize("art", rct);
            GeneradorFormato event = new GeneradorFormato();
            writer.setPageEvent(event);

            document.open();
            Paragraph parrafo2 = new Paragraph("De aqui en adelante el contenido, ya se pone en automatico el encabezado en cada página y el número", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED));
            parrafo2.setAlignment(0);
            document.add(parrafo2);

            document.add(Chunk.NEWLINE);

            document.close();
        } catch (FileNotFoundException | DocumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
