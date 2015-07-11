package RH;

import RH.GeneradorFormato.HeaderFooter;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Principal_RH extends JPanel {

    public JFrame jFrame;
    public JPanel jPanel;
    public JTable tabla;
    public JTable jTable;
    DefaultTableModel model;
    public Object[] data;
    Statement stmt;
    Connection conn;
    private ResultSet rs;
    public static String RESULT = "Reporte Recursos Humanos.pdf";
    public static String CHUNK = "CHUNK";

    public Principal_RH() {

        String jFrameTitle = "Principal Recursos Humanos"; // dar tiitulo al frame
        jFrame = new JFrame(jFrameTitle); //definir el evento para el cerrado del frame
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //definir el tamaÃ±o del frame
        jFrame.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);
        jPanel = new JPanel();
        jPanel.setLayout(null);

        JLabel Nombre = new JLabel("Lista de empleados:");
        Nombre.setBounds(10, 30, 200, 23);

        JButton Detalles = new JButton("Detalles");
        Detalles.setBounds(20, 450, 150, 30);

        JButton pdf = new JButton("Generar PDF");
        pdf.setBounds(200, 450, 150, 30);
        pdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                      try {

            Document document = new Document(PageSize.LETTER, 50, 50, 85, 50);
            document.addAuthor("Recursos Humanos");
            document.addTitle("Reporte Recursos Humanos");

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
            writer.setInitialLeading(16);

            Rectangle rct = new Rectangle(80, 104, 500, 688);
            writer.setBoxSize("art", rct);
            HeaderFooter event = new HeaderFooter();
            writer.setPageEvent((PdfPageEvent) event);

            document.open();
            Paragraph parrafo2 = new Paragraph("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED));
            parrafo2.setAlignment(0);
            document.add(parrafo2);
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
            document.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
     class HeaderFooter extends PdfPageEventHelper {

        public void onEndPage(PdfWriter writer, Document document) {
            Rectangle rect = writer.getBoxSize("art");

            Image imghead = null;
            PdfContentByte cbhead = null;

//            try {
//                imghead = Image.getInstance("LogoSapito5.png");
//                imghead.setAbsolutePosition(0, 0);
//                imghead.setAlignment(Image.ALIGN_CENTER);
//                imghead.scalePercent(10f);
//                cbhead = writer.getDirectContent();
//                PdfTemplate tp = cbhead.createTemplate(100, 150);
//                tp.addImage(imghead);
//                cbhead.addTemplate(tp, 100, 715);
//
//            } catch (BadElementException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (DocumentException e) {
//                e.printStackTrace();
//            }

            Phrase headPhraseImg = new Phrase(cbhead + "", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7, Font.NORMAL));

            Calendar c1 = Calendar.getInstance();
            Calendar c2 = new GregorianCalendar();
            String dia, mes, annio;
            dia = Integer.toString(c1.get(Calendar.DATE));
            mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
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

            Paragraph parrafo8 = new Paragraph("Reporte de Recursos Humanos", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK));
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
            JOptionPane.showConfirmDialog(jFrame, "Crear pdf");
            }
            
        });

        JButton Actualizar = new JButton("Actualizar");
        Actualizar.setBounds(190, 30, 150, 30);
        data = new Object[100];
        model = new DefaultTableModel();
        model.addColumn("ID_EMPLEADO");
        model.addColumn("NOMBRE");
        model.addColumn("APELLIDO_P");
        model.addColumn("APELLIDO_M");
        model.addColumn("TELEFONO");
        model.addColumn("ID_PUESTO");
        model.addColumn("STATUS");

        jTable = new JTable(model);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane jScrollPane = new JScrollPane(jTable);//tabla
        jScrollPane.setBounds(10, 80, 750, 300);

        Actualizar.addActionListener(new ActionListener() {
            private Component rootPane;

            @Override
            public void actionPerformed(ActionEvent e) {
                consultar();
            }

            private void consultar() {
                try {
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sapito", "sapito");
                    stmt = conn.createStatement();
                    System.out.println("Conexion realizada");
                    rs = stmt.executeQuery("SELECT * FROM EMPLEADOS");
                    ResultSetMetaData total = rs.getMetaData();
                    int canColumnas = total.getColumnCount();

                    while (rs.next()) {
                        Object[] file = new Object[canColumnas];
                        int i = 0;

                        file[i] = rs.getObject("ID_EMPLEADO");
                        file[i + 1] = rs.getObject("NOMBRE");
                        file[i + 2] = rs.getObject("APELLIDO_P");
                        file[i + 3] = rs.getObject("APELLIDO_M");
                        file[i + 4] = rs.getObject("TELEFONO");
                        file[i + 5] = rs.getObject("STATUS");
                        file[i + 6] = rs.getObject("ID_PUESTO");
                        model.addRow(file);
                    }

                    JOptionPane.showMessageDialog(rootPane, "MUY BIEN SI ENTRASTE", "CORRECTO!!", JOptionPane.PLAIN_MESSAGE);
                } catch (SQLException ex) {
                    System.out.println("X: " + ex);
                }

            }

        });

        JButton Buscar = new JButton("Buscar");
        Buscar.setBounds(350, 30, 150, 30);
        Buscar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ModificarEmpleado("Buscar Empleado");
            }
        });

        JMenuBar mbPrincipal = new JMenuBar();

        JMenu mEmpleado = new JMenu("Empleados");
        JMenu mPuesto = new JMenu("Puestos");
        JMenu mReportes = new JMenu("Reportes");
        JMenu mAyuda = new JMenu("Ayuda");

        mbPrincipal.add(mEmpleado);
        mbPrincipal.add(mPuesto);
        mbPrincipal.add(mReportes);
        mbPrincipal.add(mAyuda);

        JMenuItem miAlta = new JMenuItem("E_Alta");
        miAlta.addActionListener(new MenuListener(jFrame));
        JMenuItem miBajas = new JMenuItem("E_Baja");
        miBajas.addActionListener(new MenuListener(jFrame));
        JMenuItem miModificacion = new JMenuItem("E_Modificar");
        miModificacion.addActionListener(new MenuListener(jFrame));
        JMenuItem miGenPago = new JMenuItem("E_Generar Pago");
        miGenPago.addActionListener(new MenuListener(jFrame));
        JMenuItem Salir = new JMenuItem("Salir");
        Salir.addActionListener(new MenuListener(jFrame));
        JMenuItem miAltaPuesto = new JMenuItem("P_Alta");
        miAltaPuesto.addActionListener(new MenuListener(jFrame));
        JMenuItem miBajaPuesto = new JMenuItem("P_Baja");
        miBajaPuesto.addActionListener(new MenuListener(jFrame));
        JMenuItem miModificarPuesto = new JMenuItem("P_Modificar");
        miModificarPuesto.addActionListener(new MenuListener(jFrame));
        JMenuItem miEmpleado = new JMenuItem("R_Por Empleado");
        miEmpleado.addActionListener(new MenuListener(jFrame));
        JMenuItem miArea = new JMenuItem("R_Por Area");
        miArea.addActionListener(new MenuListener(jFrame));
        JMenuItem miAyuda = new JMenuItem("Acerca de");
        miAyuda.addActionListener(new MenuListener(jFrame));

        mEmpleado.add(miAlta);
        mEmpleado.add(miBajas);
        mEmpleado.add(miModificacion);
        mEmpleado.add(miGenPago);
        mEmpleado.add(Salir);
        mPuesto.add(miAltaPuesto);
        mPuesto.add(miBajaPuesto);
        mPuesto.add(miModificarPuesto);
        mReportes.add(miEmpleado);
        mReportes.add(miArea);
        mAyuda.add(miAyuda);
        jPanel.add(pdf);
        jPanel.add(Detalles);
        jPanel.add(Actualizar);
        jPanel.add(Buscar);
        jPanel.add(Nombre);
        jPanel.add(jScrollPane);
        jFrame.add(jPanel);
        jFrame.setJMenuBar(mbPrincipal);
        jFrame.setVisible(true);

    }

}
