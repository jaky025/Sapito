/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

//import Sapito.Ventas1;
//import Sapito.factura1;
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.OutputStream;

/**
 *
 * @author JonaManz
 */
public class registro extends JFrame {

    public JFrame jFrame;
    public JPanel jPanel;
    JComboBox jComboBox;
    JComboBox jcsexo;
    JLabel sysfecha = new JLabel();
    JTextField Tcli, Tnom, Tap_pa, Tap_ma, Tfech, Tgen, Ttel, Tmun, Tcol, Tcal, Tcp, Tnum_int, Tnum_ext, Trfc, Trz;

    public registro() {
        String frameTitle = "Registro";

        jFrame = new JFrame(frameTitle);

        jFrame.setDefaultCloseOperation(jFrame.DISPOSE_ON_CLOSE);
//Damos el ancho y largo
        jFrame.setSize(800, 600);
//Dimenciones es una clase de lo que es el tipo 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width);
        int y = (screenSize.height / 2) - (jFrame.getSize().height);

        jFrame.setLocationRelativeTo(null);
        jPanel = new JPanel();
        jPanel.setLayout(null);

        JLabel id_cli = new JLabel("Id_cliente: ");
        id_cli.setBounds(350, 20, 100, 20);
        //la siguiente jlabel es para jalar el id del cliente de la B.D
        JLabel num_cliente = new JLabel();
        num_cliente.setBounds(530, 60, 100, 20);
        JLabel nom = new JLabel("Nombre:");
        nom.setBounds(350, 60, 100, 20);
        JLabel ap_pa = new JLabel("Apellido Paterno:");
        ap_pa.setBounds(350, 95, 150, 20);
        JLabel ap_ma = new JLabel("Apellido Materno:");
        ap_ma.setBounds(350, 130, 150, 20);
        JLabel fecha = new JLabel("fecha:" + sysfecha.getText());
        fecha.setBounds(350, 160, 100, 20);
        Calendar fecha1 = Calendar.getInstance();
        Calendar fecha2 = new GregorianCalendar();
        int año = fecha2.get(Calendar.YEAR);
        int mes = fecha2.get(Calendar.MONTH);
        int dia = fecha2.get(Calendar.DAY_OF_MONTH);
        Date date = new Date();

        sysfecha.setText(dia + "/" + (mes + 1) + "/" + año);
        sysfecha.setBounds(530, 160, 200, 23);

//        JLabel fecha = new JLabel("Fecha:");
//        fecha.setBounds(350, 160, 100, 20);
        JLabel gen = new JLabel("Genero:");
        gen.setBounds(350, 195, 100, 20);
        JLabel tel = new JLabel("Telefono:");
        tel.setBounds(350, 225, 100, 20);
        JLabel estado = new JLabel("Estado:");
        estado.setBounds(350, 258, 100, 20);
        JLabel mun = new JLabel("Municipio:");
        mun.setBounds(350, 290, 100, 20);
        JLabel col = new JLabel("Colonia:");
        col.setBounds(350, 320, 100, 20);
        JLabel calle = new JLabel("Calle:");
        calle.setBounds(350, 350, 100, 20);
        JLabel cp = new JLabel("CP:");
        cp.setBounds(350, 375, 100, 20);
        JLabel no_int = new JLabel("No_interno:");
        no_int.setBounds(350, 400, 100, 20);
        JLabel no_ext = new JLabel("No_externo:");
        no_ext.setBounds(350, 430, 100, 20);
        JLabel rfc = new JLabel("RFC:");
        rfc.setBounds(350, 460, 100, 20);
        JLabel rz = new JLabel("Razon social:");
        rz.setBounds(350, 490, 100, 20);

        //Cajas de texto
        Tnom = new JTextField("");
        Tnom.setBounds(530, 60, 200, 23);
        Tnom.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'A' || car > 'Z') && (car < 'a' || car > 'z') && (car != (char) KeyEvent.VK_SPACE)) {
                    ke.consume();
                }
                if (Tnom.getText().length() + 1 > 24) {
                    JOptionPane.showMessageDialog(null, "Sobrepasa el nivel de caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    Tnom.setText(" ");

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

        Tap_pa = new JTextField("");
        Tap_pa.setBounds(530, 95, 200, 23);
        Tap_pa.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'A' || car > 'Z') && (car < 'a' || car > 'z') && (car != (char) KeyEvent.VK_SPACE)) {
                    ke.consume();
                }
                if (Tap_pa.getText().length() > 24) {
                    JOptionPane.showMessageDialog(null, "Sobrepasa el nivel de caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    Tap_pa.setText("");

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

        Tap_ma = new JTextField("");
        Tap_ma.setBounds(530, 130, 200, 23);
        Tap_ma.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'A' || car > 'Z') && (car < 'a' || car > 'z') && (car != (char) KeyEvent.VK_SPACE)) {
                    ke.consume();
                }
                if (Tap_ma.getText().length() > 24) {
                    JOptionPane.showMessageDialog(null, "Sobrepasa el nivel de caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    Tap_ma.setText("");
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

        Tgen = new JTextField("");
        String genero[] = {"M", "F"};
        jcsexo = new JComboBox(genero);
        jcsexo.setBounds(530, 195, 200, 23);
        jPanel.add(jcsexo);

//        Tgen.setBounds(530, 195, 200, 23); 
//        Tgen.addKeyListener(new KeyListener() {
//
//            @Override
//            public void keyTyped(KeyEvent ke) {
//                char car = ke.getKeyChar();       
//                if((car<'A' || car>'Z')&&(car<'a'||car>'z')&& (car!=(char)KeyEvent.VK_SPACE)){       
//                    ke.consume();  
//                }
//            }
//
//            @Override
//            public void keyPressed(KeyEvent ke) {
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void keyReleased(KeyEvent ke) {
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
        Ttel = new JTextField("");
        Ttel.setBounds(530, 225, 200, 23);
        Ttel.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < '0' || car > '9')) {
                    ke.consume();
                }
                if (Ttel.getText().length() > 15) {
                    JOptionPane.showMessageDialog(null, "Sobrepasa el nivel de caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    Ttel.setText("");
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

        String items[] = {"Aguascalientes", "Baja California Norte", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila", "Colima", "Durango",
            "Estado de México", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacán", "Morelos", "Nayarit", "Nuevo", "León", "Oaxaca", "Puebla",
            "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas"};

        jComboBox = new JComboBox(items);
        jComboBox.setBounds(530, 258, 125, 20);

        Tmun = new JTextField("");
        Tmun.setBounds(530, 290, 200, 23);
        Tmun.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'A' || car > 'Z') && (car < 'a' || car > 'z') && (car != (char) KeyEvent.VK_SPACE)) {
                    ke.consume();
                    if (Tmun.getText().length() > 24) {
                        JOptionPane.showMessageDialog(null, "Sobrepasa el nivel de caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        Tmun.setText("");
                    }
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

        Tcol = new JTextField("");
        Tcol.setBounds(530, 320, 200, 23);
        Tcol.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'A' || car > 'Z') && (car < 'a' || car > 'z') && (car != (char) KeyEvent.VK_SPACE)) {
                    ke.consume();
                    if (Tcol.getText().length() > 24) {
                        JOptionPane.showMessageDialog(null, "Sobrepasa el nivel de caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        Tcol.setText("");
                    }
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

        Tcal = new JTextField("");
        Tcal.setBounds(530, 347, 200, 23);
        Tcal.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'A' || car > 'Z') && (car < 'a' || car > 'z') && (car < '0' || car > '9') && (car != (char) KeyEvent.VK_SPACE)) {
                    ke.consume();
                    if (Tcal.getText().length() > 24) {
                        JOptionPane.showMessageDialog(null, "Sobrepasa el nivel de caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        Tcal.setText("");
                    }
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

        Tcp = new JTextField("");
        Tcp.setBounds(530, 373, 200, 23);
        Tcp.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < '0' || car > '9')) {
                    ke.consume();
                    if (Tcp.getText().length() > 24) {
                        JOptionPane.showMessageDialog(null, "Sobrepasa el nivel de caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        Tcp.setText("");
                    }
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

        Tnum_int = new JTextField("");
        Tnum_int.setBounds(530, 400, 200, 23);
        Tnum_int.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < '0' || car > '9')) {
                    ke.consume();
                    if (Tnum_int.getText().length() > 24) {
                        JOptionPane.showMessageDialog(null, "Sobrepasa el nivel de caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        Tnum_int.setText("");
                    }
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

        Tnum_ext = new JTextField("");
        Tnum_ext.setBounds(530, 430, 200, 23);
        Tnum_ext.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < '0' || car > '9')) {
                    ke.consume();
                    if (Tnum_ext.getText().length() > 24) {
                        JOptionPane.showMessageDialog(null, "Sobrepasa el nivel de caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        Tnum_ext.setText("");
                    }
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

        Trfc = new JTextField("");
        Trfc.setBounds(530, 460, 200, 23);
        Trfc.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'A' || car > 'Z') && (car < '0' || car > '9') && (car != (char) KeyEvent.VK_SPACE)) {
                    ke.consume();
                    if (Trfc.getText().length() > 24) {
                        JOptionPane.showMessageDialog(null, "Sobrepasa el nivel de caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        Trfc.setText("");
                    }
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

        Trz = new JTextField("");
        Trz.setBounds(530, 490, 200, 23);
        Trz.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'A' || car > 'Z') && (car < '0' || car > '9') && (car != (char) KeyEvent.VK_SPACE)) {
                    ke.consume();
                    if (Trz.getText().length() > 24) {
                        JOptionPane.showMessageDialog(null, "Sobrepasa el nivel de caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        Trz.setText("");
                    }
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

        String path = "../Ventas/1.png";
        URL url = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(url);
        JLabel imagen1 = new JLabel("Cliente");
        imagen1.setBounds(35, 30, 226, 223);
        imagen1.setIcon(icon);
        jPanel.add(imagen1);
// JTextField Tcli, Tnom, Tap_pa, Tap_ma, Tfech, Tgen, Ttel, Tmun, Tcol, Tcal, Tcp, Tnum_int, Tnum_ext, Trfc, Trz;
        JButton ven1 = new JButton("Guardar Cliente");
        ven1.setBounds(50, 300, 150, 30);
        ven1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                if (Tnom.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese un nombre", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (Tap_pa.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese un Apellido Paterno", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (Tap_ma.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese un Apellido Materno", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (Ttel.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese un Telefono", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (Tmun.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese un Municipio", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (Tcol.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese una Colonia", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(Tcal.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Ingrese una Calle", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(Tcp.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Ingrese un Codigo Postal", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(Tnum_int.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Ingrese un Numero Interno", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(Tnum_ext.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Ingrese un Numero Externo", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(Trfc.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Ingrese el RFC", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(Trz.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Ingrese Razon Social", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                
                
                try {
                    Conexion con = new Conexion();
                    con.openConnection();
                    new Conexion().insert_cliente(con,
                            Tnom.getText(),
                            Tap_pa.getText(),
                            Tap_ma.getText(),
                            jcsexo.getSelectedItem().toString(),
                            Ttel.getText(),
                            jComboBox.getSelectedItem().toString(),
                            Tmun.getText(),
                            Tcol.getText(),
                            Tcal.getText(),
                            Integer.parseInt(Tcp.getText()),
                            Tnum_int.getText(),
                            Tnum_ext.getText(),
                            Trfc.getText(),
                            Trz.getText());

                } catch (SQLException ex) {
                    Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
                }

//                Principal_Encargado venta = new Principal_Encargado();
                jFrame.dispose();
                try {
                    Principal_Encargado principal = new Principal_Encargado();
                } catch (SQLException ex) {
                    Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
                }
              }
            }            
        });
        
        JButton can1 = new JButton("Cancelar");
        can1.setBounds(50, 350, 150, 30);
        can1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    Principal_Encargado rt = new Principal_Encargado();
                } catch (SQLException ex) {
                    Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
                }
                jFrame.dispose();
            }
        });

        JButton pdf = new JButton("Generar");
        pdf.setBounds(50, 400, 150, 30);
        pdf.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser report = new JFileChooser();
                int g = report.showSaveDialog(null);
                if (g == JFileChooser.APPROVE_OPTION) {
                    try {
                        OutputStream salida = new FileOutputStream(report.getSelectedFile() + ".pdf");
                        Document formato = new Document();
                        PdfWriter writer= PdfWriter.getInstance(formato, salida);
                        writer.setInitialLeading(16);
                        
                        formato.open();;
                       formato.close();
                       salida.close();
                       Runtime.getRuntime().exec("cmd /c start"+report.getSelectedFile()+".pdf");
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DocumentException ex) {
                        Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
//        jPanel.add(Tcli);
        jPanel.add(id_cli);
        jPanel.add(nom);
        jPanel.add(ap_pa);
        jPanel.add(ap_ma);
        jPanel.add(fecha);
        jPanel.add(gen);
        jPanel.add(tel);
        jPanel.add(estado);
        jPanel.add(mun);
        jPanel.add(col);
        jPanel.add(calle);
        jPanel.add(cp);
        jPanel.add(no_int);
        jPanel.add(no_ext);
        jPanel.add(rfc);
        jPanel.add(rz);
        jPanel.add(Tnom);
        jPanel.add(Tap_pa);
        jPanel.add(Tap_ma);
        jPanel.add(Tgen);
        jPanel.add(Ttel);
        jPanel.add(Tmun);
        jPanel.add(Tcol);
        jPanel.add(jComboBox);
        jPanel.add(Tcal);
        jPanel.add(Tcp);
        jPanel.add(Tnum_int);
        jPanel.add(Tnum_ext);
        jPanel.add(Trfc);
        jPanel.add(Trz);
        jPanel.add(ven1);
        jPanel.add(can1);
        jPanel.add(pdf);
        jPanel.add(fecha);
        jPanel.add(sysfecha);
        jFrame.setVisible(true);
        jFrame.add(jPanel);

    }

//    public static void main(String[] args) {
//        registro app = new registro();
//
//    }

    public void createDocument(String filename, String extension) throws DocumentException, FileNotFoundException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename + "." + extension));
        document.open();

        document.add(new Paragraph("Clientes Dados de Alta"));
        document.add(new Paragraph(" "));

        int total[] = new int[5];
        String nombres[] = {"No. Control", "Factura", "Documento", "Fecha", "Importe", "Estado"};
        PdfPTable pdfPTable = new PdfPTable(nombres.length + 1);

        PdfPCell cell = new PdfPCell(new Phrase());
        pdfPTable.addCell(cell);

        for (int i = 0; i < nombres.length; i++) {
            cell = new PdfPCell(new Phrase(nombres[i]));
            pdfPTable.addCell(cell);
        }
        cell = new PdfPCell(new Phrase("No. Cliente"));
        pdfPTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Total"));
        pdfPTable.addCell(cell);
        for (int i = 0; i < total.length; i++) {
            cell = new PdfPCell(new Phrase(Integer.toString(total[i])));
            pdfPTable.addCell(cell);

        }

        document.add(pdfPTable);
        document.close();
    }
}

//    static class HeaderFooter extends PdfPageEventHelper {
//
//        public void onEndPage(PdfWriter writer, Document document) {
//            com.itextpdf.text.Rectangle rect = writer.getBoxSize("art");
//
//            Image imghead = null;
//            PdfContentByte cbhead = null;
//
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
//            } catch (DocumentException e) {
//                e.printStackTrace();
//            } catch (IOException ex) {
//                Logger.getLogger(Cuentaspagar.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            Phrase headPhraseImg = new Phrase(cbhead + "", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7, Font.NORMAL));
//
//            Calendar c1 = Calendar.getInstance();
//            Calendar c2 = new GregorianCalendar();
//            String dia, mes, annio;
//            dia = Integer.toString(c1.get(Calendar.DATE));
//            mes = Integer.toString(c1.get(Calendar.MONTH));
//            annio = Integer.toString(c1.get(Calendar.YEAR));
//            java.util.Date fecha = new Date();
//            String fechis = dia + "/" + mes + "/" + annio;
//            Paragraph parrafo5 = new Paragraph(fechis, FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK));
//            ColumnText.showTextAligned(writer.getDirectContent(),
//                    Element.ALIGN_CENTER, new Phrase(parrafo5),
//                    rect.getRight(450), rect.getTop(-80), 0);
//
//            Paragraph parrafo7 = new Paragraph("Empresa Sapito S.A. de C.V.", FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK));
//            ColumnText.showTextAligned(writer.getDirectContent(),
//                    Element.ALIGN_CENTER, new Phrase(parrafo7),
//                    rect.getBottom(250), rect.getTop(-60), 0);
//
//            Paragraph parrafo8 = new Paragraph("Cuentas por pagar", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK));
//            ColumnText.showTextAligned(writer.getDirectContent(),
//                    Element.ALIGN_CENTER, new Phrase(parrafo8),
//                    rect.getBottom(250), rect.getTop(-40), 0);
//
//            ColumnText.showTextAligned(writer.getDirectContent(),
//                    Element.ALIGN_BOTTOM, new Phrase("      _________________________________________________________________________________    "),
//                    rect.getBorder(), rect.getTop(-24), 0);
//
//            ColumnText.showTextAligned(writer.getDirectContent(),
//                    Element.ALIGN_BOTTOM, new Phrase("      _________________________________________________________________________________    "),
//                    rect.getBorder(), rect.getTop(-20), 0);
//
//            Paragraph parrafo6 = new Paragraph(String.format("Pág %d", writer.getPageNumber()), FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK));
//            ColumnText.showTextAligned(writer.getDirectContent(),
//                    Element.ALIGN_CENTER, new Phrase(parrafo6),
//                    rect.getRight(-35), rect.getTop(-80), 0);
//
//        }
//    }
//}
