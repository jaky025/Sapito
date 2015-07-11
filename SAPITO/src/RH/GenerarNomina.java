package RH;

import Conexion.DataBaseManager;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GenerarNomina extends JPanel {
    
    public JFrame jFrame;
    public JPanel jPanel;
    private PreparedStatement pS;
    private PreparedStatement pS2;
    private ResultSet resultSet;
    private ResultSet rs2;
    private ResultSet rs;
    public JTextField BuscarEmpleado;
    JTextField campoNombre;
    JTextField campoPaterno;
    JTextField campoMaterno;
    JComboBox campoPuesto;
    String items[]={"Director","Subdirector","Jefe de RH","Recepcion","Secretari@","Jefe Inventario","Auxiliar 1",
        "Auxiliar 2","Gerente General","Auxiliar Gerencia","Capturista","Jefe de Compras","Auxiliar C1","Auxiliar C2","Jefe Ventas","Vendedor"};
    JTextField campoSaldo;
    JTextField campoFaltas;
    JTextField capComentario;
    private String id;
    Connection conn;
    Statement stmt;
    String  Campopuesto2;
    
    public GenerarNomina(String Titulo) {
        String jFrameTitle = Titulo; // dar tiitulo al frame
        jFrame = new JFrame(jFrameTitle); //definir el evento para el cerrado del frame
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //definir el tamaño del frame
        jFrame.setSize(800, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);
        jPanel = new JPanel();
        jPanel.setLayout(null);
        
        JLabel BuscarLabel = new JLabel("Id Empleado:");
        BuscarLabel.setBounds(10, 15, 100, 23);
        BuscarEmpleado = new JTextField();
        BuscarEmpleado.setBounds(115, 20, 200, 23);
        BuscarEmpleado.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if (x < '0' || x > '9') {
                    ke.consume();
                }
            }
            
            @Override
            public void keyPressed(KeyEvent ke) {
            }
            
            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });
        JButton Ok = new JButton("Buscar");
        Ok.setBounds(330, 20, 150, 30);
        Ok.addActionListener(new ActionListener() {
            private Component rootPane;
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if (BuscarEmpleado.getText().length() > 0) {
                    id = BuscarEmpleado.getText();
                    this.consulta(id);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Debe ingresar un ID de Proveedor");
                }
                
            }
            
            private void consulta(String ids) {
                try {
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sapito", "sapito");
                    stmt = conn.createStatement();
                    System.out.println("Conexión realizada");
                    pS = conn.prepareStatement("SELECT ID_EMPLEADO, NOMBRE, APELLIDO_P, APELLIDO_M,ID_PUESTO FROM EMPLEADOS WHERE ID_EMPLEADO =?");
                    pS.setString(1, ids);
                    rs = pS.executeQuery();
                    
                    if (rs.next()) {
                        //el .next sirve para pasarnos a otra tupla

                        pS = conn.prepareStatement("SELECT ID_EMPLEADO, NOMBRE, APELLIDO_P, APELLIDO_M, ID_PUESTO FROM EMPLEADOS WHERE ID_EMPLEADO =?");
                        pS.setString(1, ids);
                        resultSet = pS.executeQuery();
                        while (resultSet.next()) {
                            BuscarEmpleado.setText(resultSet.getString("id_empleado"));
                            campoNombre.setText(resultSet.getString("nombre"));
                            campoPaterno.setText(resultSet.getString("apellido_p"));
                            campoMaterno.setText(resultSet.getString("apellido_m"));
                            Campopuesto2 = rs.getString("id_puesto");
                            if (Campopuesto2.equals("0")) {
                                campoPuesto.setSelectedItem("Director");
                            } else if (Campopuesto2.equals("1")) {
                                campoPuesto.setSelectedItem("Subdirector");
                            } else if (Campopuesto2.equals("2")) {
                                campoPuesto.setSelectedItem("Jefe de RH");
                            } else if (Campopuesto2.equals("3")) {
                                campoPuesto.setSelectedItem("Recepción");
                            } else if (Campopuesto2.equals("4")) {
                                campoPuesto.setSelectedItem("Secretari@");
                            } else if (Campopuesto2.equals("5")) {
                                campoPuesto.setSelectedItem("Jefe Inventario");
                            } else if (Campopuesto2.equals("6")) {
                                campoPuesto.setSelectedItem("Auxiliar 1");
                            } else if (Campopuesto2.equals("7")) {
                                campoPuesto.setSelectedItem("Auxiliar 2");
                            } else if (Campopuesto2.equals("8")) {
                                campoPuesto.setSelectedItem("Gerente General");
                            } else if (Campopuesto2.equals("9")) {
                                campoPuesto.setSelectedItem("Auxiliar Gerencia");
                            } else if (Campopuesto2.equals("10")) {
                                campoPuesto.setSelectedItem("Capturista");
                            } else if (Campopuesto2.equals("11")) {
                                campoPuesto.setSelectedItem("Jefe de Compras");
                            } else if (Campopuesto2.equals("12")) {
                                campoPuesto.setSelectedItem("Auxiliar C1");
                            } else if (Campopuesto2.equals("13")) {
                                campoPuesto.setSelectedItem("Auxiliar C2");
                            } else if (Campopuesto2.equals("14")) {
                                campoPuesto.setSelectedItem("Jefe Ventas");
                            } else if (Campopuesto2.equals("15")) {
                                campoPuesto.setSelectedItem("Vendedor");
                            }
                                                           ////// t_par.setEditable(false);
                        }
                    } else {
                        //JOptionPane.showMessageDialog(rootPane, "VERIFIQUE SU ID", "Error!! ", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(rootPane, "VERIFIQUE SU ID POR FAVOR", "Error!!", JOptionPane.ERROR_MESSAGE);
                    }
                    
                } catch (SQLException ex) {
                    System.out.println("X: " + ex);
                }
            }
            
        });
        
        JMenuBar jMenuBar = new JMenuBar();
        
        JMenu jMenu = new JMenu("Archivo");
        JMenu jMenu3 = new JMenu("Ayuda");
        
        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu3);
        
        JMenuItem jMenuItem = new JMenuItem("Buscar");
        jMenuItem.addActionListener(new MenuListener(jFrame) {
        });
        JMenuItem jMenuItem2 = new JMenuItem("Guardad");
        jMenuItem2.addActionListener(new MenuListener(jFrame));
        JMenuItem jMenuItem3 = new JMenuItem("Salir");
        jMenuItem3.addActionListener(new MenuListener(jFrame));
        JMenuItem jMenuItem7 = new JMenuItem("Acerca de");
        jMenuItem7.addActionListener(new MenuListener(jFrame));
        
        JLabel Nombre = new JLabel("Nombre(s):");
        Nombre.setBounds(10, 60, 200, 23);
        campoNombre = new JTextField();
        campoNombre.setBounds(10, 90, 200, 23);
        campoNombre.setEditable(false);
        JLabel ApPaterno = new JLabel("Apellido Paterno: ");
        ApPaterno.setBounds(240, 60, 200, 23);
        campoPaterno = new JTextField();
        campoPaterno.setBounds(240, 90, 200, 23);
        campoPaterno.setEditable(false);
        JLabel ApMaterno = new JLabel("Apellido Materno: ");
        ApMaterno.setBounds(470, 60, 200, 23);
        campoMaterno = new JTextField();
        campoMaterno.setBounds(470, 90, 200, 23);
        campoMaterno.setEditable(false);
        JLabel Puesto = new JLabel("Puesto: ");
        Puesto.setBounds(10, 150, 200, 23);
        campoPuesto = new JComboBox(items);
        campoPuesto.setBounds(10, 180, 200, 23);
        campoPuesto.setEditable(true);
        JLabel Saldo = new JLabel("Saldo: ");
        Saldo.setBounds(240, 150, 200, 23);
        campoSaldo = new JTextField();
        campoSaldo.setBounds(240, 180, 200, 23);
        campoSaldo.setEditable(true);
        campoSaldo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if (x < '0' || x > '9') {
                    ke.consume();
                }
            }
            
            @Override
            public void keyPressed(KeyEvent ke) {
            }
            
            @Override
            public void keyReleased(KeyEvent ke) {
            }
            
        });
        JLabel Faltas = new JLabel("Faltas: ");
        Faltas.setBounds(470, 150, 200, 23);
        campoFaltas = new JTextField();
        campoFaltas.setBounds(470, 180, 200, 23);
        campoFaltas.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if (x < '0' || x > '9') {
                    ke.consume();
                }
            }
            
            @Override
            public void keyPressed(KeyEvent ke) {
            }
            
            @Override
            public void keyReleased(KeyEvent ke) {
            }
            
        });
        JLabel Comentario = new JLabel("Descripción: ");
        Comentario.setBounds(60, 280, 200, 23);
        capComentario = new JTextField();
        capComentario.setBounds(160, 290, 400, 100);
        capComentario.setEditable(true);
        capComentario.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'a' || car > 'z')
                        && (car < 'A' || car > 'Z')
                        && car != 'á' && car != 'é'
                        && car != 'í' && car != 'ó'
                        && car != 'ú' && car != 'Á'
                        && car != 'É' && car != 'Í'
                        && car != 'Ó' && car != 'Ú'
                        && car != 'ñ' && car != 'Ñ'
                        && (car != (char) KeyEvent.VK_SPACE)) {
                    ke.consume();
                }
            }
            
            @Override
            public void keyPressed(KeyEvent ke) {
            }
            
            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });
        JButton Guardar = new JButton("Generar Nomina");
        Guardar.setBounds(230, 460, 150, 30);//generar por orden
        Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estalleno() == true) {
                    System.out.println("Ok");
                    DataBaseManager obc = new DataBaseManager();
                    obc.Connection();
                    int a=1;
                    a=a+1;
                    int idnomina = (a);
                    String id = BuscarEmpleado.getText();
                    String nombre = campoNombre.getText();
                    int idpuesto = campoPuesto.getSelectedIndex();
                    String CampoSaldo = campoSaldo.getText();
                    String CampoDescrip = capComentario.getText();
                    String CampoFaltas = campoFaltas.getText();
                    int total = Integer.parseInt(campoSaldo.getText());
                    int tol = total * 20;
                    String chalala = "insert into NOMINAS values ("+idnomina +"," 
                            + id +",'" 
                            + nombre + "'," 
                            + idpuesto + "," 
                            + CampoSaldo + "," 
                            + CampoFaltas + ",'" 
                            + CampoDescrip + "',"
                            + tol + ")";
                    System.out.println(chalala);
                    String Sentencia = (chalala);
                    obc.Escribir(Sentencia);
                    JOptionPane.showMessageDialog(null, "Datos Guardados");
                } else {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                }
            }
        });
                JButton Reg = new JButton("Regresar");
        Reg.setBounds(580, 503, 150, 30);
        Reg.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                       // new Principal_RH();
                        jFrame.dispose();
                    }
                }
        );
        jPanel.add(Reg);
        
        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem2);
        jMenu.add(jMenuItem3);
        jMenu3.add(jMenuItem7);
        
        jPanel.add(Faltas);
        jPanel.add(campoFaltas);
        jPanel.add(Comentario);
        jPanel.add(capComentario);
        jPanel.add(Saldo);
        jPanel.add(campoSaldo);
        jPanel.add(Guardar);
        jPanel.add(Nombre);
        jPanel.add(ApPaterno);
        jPanel.add(ApMaterno);
        jPanel.add(Puesto);
        jPanel.add(campoNombre);
        jPanel.add(campoPaterno);
        jPanel.add(campoMaterno);
        jPanel.add(campoPuesto);
        jPanel.add(Ok);
        jPanel.add(BuscarLabel);
        jPanel.add(BuscarEmpleado);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }
    
    public boolean estalleno() {
        if (capComentario.getText().isEmpty()
                || campoSaldo.getText().isEmpty()
                || campoFaltas.getText().isEmpty()) {
            return false;
        }
        return true;
    }
 }
