package Inventario;

import java.sql.*;
import static Inventario.PDF.RESULT;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import javax.swing.text.Document;
//import javax.swing.text.Element;
/**
 *
 * @author daniel
 */

public class Infraestructura extends JPanel {
     private ResultSet rs;
    private String id;
     private PreparedStatement pS;
      Statement stmt;
       Connection conn;
       
        private ResultSet resultSet;
public Object[] data;
DefaultTableModel model;
    JPanel jPanel;
    JTable jTable;
    public JFrame jFrame;
 
 
    public Infraestructura() {
        String jFrameTitle = "Inventario";
        jFrame = new JFrame(jFrameTitle);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);
//        ImageIcon imageIcon = new ImageIcon("d:\\man_not_working_ahead.png");
//        jFrame.setIconImage(imageIcon.getImage());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        //lo que aparce en el pdf
         data = new Object[9];
        model = new DefaultTableModel();
        jTable =new JTable(model);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
                 data = new Object[9];
        model = new DefaultTableModel();

//       String tableContent[][];
//        model.addColumn("Id");
//        model.addColumn("Nombre");
//        model.addColumn("Detalles");
//        model.addColumn("Unidad");
//        model.addColumn("Maximos");
//        model.addColumn("Minimos");
//        model.addColumn("Total pzs");
//        model.addColumn("Total $ pzs");
//        model.addColumn("Existencia");
//        model.addColumn("Precio compra");
//        model.addColumn("Precio venta");

        jTable =new JTable(model);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(20, 200, 1300, 200);
        

        String etiqueta11 = "INVENTARIO GENERAL";
        JLabel jLabel11 = new JLabel(etiqueta11);
        jLabel11.setBounds(300, 20, 200, 23);

        JButton jButton = new JButton("Generar PDF");
        jButton.setBounds(80, 501, 150, 30);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, "Reporte Generado");
                    createDocument("Inventario", "pdf");
                } catch (DocumentException ex) {
                    java.util.logging.Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    java.util.logging.Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         // etiqueta generar inventario
        String etiqueta12 = " insercion en inventario";
        JLabel jLabel12 = new JLabel(etiqueta12);
        jLabel12.setBounds(350, 35, 200, 23);

      
        ////////////////////////////////////////////////////////////////////////////
 JLabel etiquetas = new JLabel("Elige una opción:");
        etiquetas.setBounds(50, 10, 200, 23);
        JComboBox eleccion = new JComboBox();
        eleccion.setBounds(50, 30, 150, 30);
        add(eleccion);
        eleccion.addItem("Compra-venta");
        eleccion.addItem("Infraestructura");
        
        JButton Reg = new JButton("Regresar");
        Reg.setBounds(580, 503, 150, 30);
        Reg.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Menu menu = new Menu();
                        jFrame.dispose();
                    }
                }
        );
       
        data = new Object[100];
        model = new DefaultTableModel();
           
        model.addColumn("id");
        model.addColumn("nombre");
        model.addColumn("Cantidad_prod");
        model.addColumn("Unidad");
        model.addColumn("Detalles");
        model.addColumn("Precio venta");
        model.addColumn("Id prov");
        model.addColumn("Max");
        model.addColumn("Min");
         model.addColumn("Para venta");
        
         jTable =new JTable(model);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        jScrollPane = new JScrollPane(jTable);//tabla
        jScrollPane.setBounds(60, 250, 850, 200);
        ///////////// generar inv
         JButton inv = new JButton("Generar nuevo inventario");
        inv.setBounds(250, 150, 200, 30);
       inv.addActionListener(new ActionListener() 
        {
             private Component rootPane;
             
         @Override
                  public void actionPerformed(ActionEvent e) {
                    int id=0;
                 String nom="";
                 int cant=0;
                 String unidad="";
                 String detalles="";
                 int prec=0;
                 int id_prov=0;
                 int max=0;
                 int min=0;
                 int para_vta=0 ;
                 
                  try {
                   
                     
                      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sapito", "sapito");
                  //  stmt = conn.createStatement();
                     stmt= conn.createStatement();
                    System.out.println("Conexion realizada");
                    rs=stmt.executeQuery("select * from PRODUCTOS");
                    //obteniendo info de las columnas consultadas
                    ResultSetMetaData rsMd=rs.getMetaData();
                    //cant de colum que tiene la consulta
                    int cantColumnas=rsMd.getColumnCount();

                    //filas para el jTable
                    while(rs.next())
                    {
                    Object[] fila=new Object[cantColumnas];
                  int i=0;
                        fila[i]=rs.getObject("id_producto");
                     fila[i+1]=rs.getObject("nombre");
                     fila[i+2]=rs.getObject("cantidad_prod");
                      fila[i+3]=rs.getObject("unidad_medida");
                       fila[i+4]=rs.getObject("detalles");
                        fila[i+5]=rs.getObject("precio_venta");
                         fila[i+6]=rs.getObject("id_proveedor");
                          fila[i+7]=40;    //valor asignado a maximos
                          fila[i+8]=5;    //valor asignado a minimos
                          //en caso de que cuando agreguen 
//                          fila[i+7]=rs.getObject("m_ax");
//                           fila[i+8]=rs.getObject("m_in");
                            fila[i+9]=rs.getObject("para_venta");
                    
                    model.addRow(fila);
                    }
                   
                    rs.close();
                   
                  } catch (SQLException ex) {
                  System.out.println("X: " + ex);

                }
            }

        } );
       
        jPanel.add(Reg);
        jPanel.add(jButton);
        jPanel.add(jLabel11);
        jPanel.add(jScrollPane);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        jPanel.add(inv);
         jPanel.add(eleccion);
          jPanel.add(etiquetas);
        
    }

     public void createDocument(String filename, String extension) throws DocumentException, FileNotFoundException
    {   
        try {

            Document document = new Document(PageSize.LETTER, 50, 50, 85, 50);
            document.addAuthor("Inventario");
            document.addTitle("Reporte de Inventario Compra-Venta");

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
            writer.setInitialLeading(16);
            Rectangle rct = new Rectangle(80, 104, 500, 688);
            writer.setBoxSize("art", rct);
            HeaderFooter event = new HeaderFooter();
            writer.setPageEvent(event);


            document.open();
            Paragraph parrafo2 = new Paragraph("Reportes de Inventario", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.GRAY));
            parrafo2.setAlignment(0);
            document.add(parrafo2);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

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
            } catch (IOException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                e.printStackTrace();
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

            Paragraph parrafo8 = new Paragraph("Reporte de Inventario", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK));
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(parrafo8),
                    rect.getBottom(250), rect.getTop(-40), 0);
            
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_BOTTOM, new Phrase("      _____________________________________________________________________________________    "),
                    rect.getBorder(), rect.getTop(650), 0);

            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_BOTTOM, new Phrase("      _____________________________________________________________________________________    "),
                    rect.getBorder(), rect.getTop(-24), 0);

            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_BOTTOM, new Phrase("      _____________________________________________________________________________________    "),
                    rect.getBorder(), rect.getTop(-20), 0);

            Paragraph parrafo6 = new Paragraph(String.format("Pág %d", writer.getPageNumber()), FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK));
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(parrafo6),
                    rect.getRight(-35), rect.getTop(-80), 0);

        }
    }
    public static void main(String arguments[]) {
        Inventario Inv = new Inventario();
    }

}
