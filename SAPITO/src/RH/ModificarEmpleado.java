package RH;

import Compras.Productos;
import Conexion.DataBaseManager;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ModificarEmpleado extends JPanel {

    public JFrame jFrame;
    public JPanel jPanel;
    private PreparedStatement pS;
    private PreparedStatement pS2;
    private ResultSet resultSet;
    private ResultSet rs2;
    private ResultSet rs;
    Connection conn;
    Statement stmt;
    public JTextField IdEmpleado;
    JTextField campoFechNaci;
    JTextField campoNombre;
    JTextField campoId;
    JTextField CampoPass;
    JTextField campoPaterno;
    JTextField campoMaterno;
    JTextField campoIdEm;
    JTextField campoTelefono;
    JTextField CampoFecha;
    JTextField campoPuesto;
    JTextField campoCalle;
    JTextField CampoCol;
    JTextField CampoCP;
    JTextField CampoMun;
    JTextField CampoNumExt;
    JTextField CampoNumInt;
    JTextField capComentario;
    JTextField BuscarEmpleado;
    public JComboBox EstCiv;
    public JComboBox ComEstado;
    public String FechaNaci;
    public String FechaContra;
    public String Genero;
    public String tatus;
     private String campIdEmp;
    public JRadioButton sMas;
    public JRadioButton sFem;
    public JRadioButton Activo;
    public JRadioButton Inactivo;
    public JRadioButton Descanso;

    public String items[] = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila", "Colima", "Durango",
        "Estado de México", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla",
        "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas"};
    public String Civil[] = {"Soltero", "Casado", "Viudo", "Divorciado", "Union Libre"};

    public ModificarEmpleado(String Titulo) {
        String jFrameTitle = Titulo; // dar tiitulo al frame
        jFrame = new JFrame(jFrameTitle); //definir el evento para el cerrado del frame
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //definir el tamaÃ±o del frame
        jFrame.setSize(800, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);
        jPanel = new JPanel();
        jPanel.setLayout(null);

        JMenuBar mbModificar = new JMenuBar();

        JMenu mEdicion = new JMenu("Edición");
        JMenu mAyuda = new JMenu("Ayuda");

        mbModificar.add(mEdicion);
        mbModificar.add(mAyuda);

        JMenuItem miGuardar = new JMenuItem("Guardar");
        miGuardar.addActionListener(new MenuListener(jFrame) {
        });
        JMenuItem miAyuda = new JMenuItem("Acerca de");
        miAyuda.addActionListener(new MenuListener(jFrame));

        JLabel Nombre = new JLabel("Nombre(s):");
        Nombre.setBounds(10, 30, 200, 23);
        campoNombre = new JTextField();
        campoNombre.setBounds(10, 60, 200, 23);
        campoNombre.setEditable(false);
        JLabel Edad = new JLabel("Fecha de Nacimiento: ");
        Edad.setBounds(260, 210, 200, 23);
        campoFechNaci = new JTextField();
        campoFechNaci.setBounds(260, 240, 200, 23);
        campoFechNaci.setEditable(false);
        JLabel IdUsuario = new JLabel("Usuario:");
        IdUsuario.setBounds(10, 150, 200, 23);
        campoId = new JTextField();
        campoId.setBounds(10, 180, 200, 23);
        campoId.setEditable(true);
        campoId.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                campoId.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        campoId.addKeyListener(new KeyListener() {
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
        JLabel Password = new JLabel("Contraseña:");
        Password.setBounds(260, 150, 200, 23);
        CampoPass = new JTextField();
        CampoPass.setBounds(260, 180, 200, 23);
        CampoPass.setEditable(true);
        CampoPass.addKeyListener(new KeyListener() {
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
        JLabel ApPaterno = new JLabel("Apellido Paterno: ");
        ApPaterno.setBounds(260, 30, 200, 23);
        campoPaterno = new JTextField();
        campoPaterno.setBounds(260, 60, 200, 23);
        campoPaterno.setEditable(false);
        JLabel ApMaterno = new JLabel("Apellido Materno: ");
        ApMaterno.setBounds(520, 30, 200, 23);
        campoMaterno = new JTextField();
        campoMaterno.setBounds(520, 60, 200, 23);
        campoMaterno.setEditable(false);
        JLabel IdEmpleado = new JLabel("Id Empleado");
        IdEmpleado.setBounds(10, 90, 200, 23);
        campoIdEm = new JTextField();
        campoIdEm.setBounds(10, 120, 200, 23);
        campoIdEm.setEditable(false);
        JLabel Telefono = new JLabel("Teléfono: ");
        Telefono.setBounds(260, 90, 200, 23);
        campoTelefono = new JTextField();
        campoTelefono.setBounds(260, 120, 200, 23);
        campoTelefono.setEditable(true);
        campoTelefono.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                campoTelefono.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        campoTelefono.addKeyListener(new KeyListener() {
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
        JLabel FechaCont = new JLabel("Fecha contratación");
        FechaCont.setBounds(520, 90, 200, 23);
        CampoFecha = new JTextField();
        CampoFecha.setBounds(520, 120, 200, 23);
        CampoFecha.setEditable(false);
        JLabel EstadoCiv = new JLabel("Estado Civil: ");
        EstadoCiv.setBounds(10, 210, 200, 23);
        EstCiv = new JComboBox(Civil);
        EstCiv.setEditable(true);
        EstCiv.setBounds(10, 240, 200, 23);
        JLabel Sexo = new JLabel("Género: ");
        Sexo.setBounds(510, 210, 100, 23);
        sFem = new JRadioButton("Femenino");
        sFem.setBounds(520, 235, 100, 23);
        sMas = new JRadioButton("Masculino");
        sMas.setBounds(520, 260, 100, 23);
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(sFem);
        buttonGroup1.add(sMas);

        JLabel Puesto = new JLabel("Puesto: ");
        Puesto.setBounds(520, 150, 200, 23);
        campoPuesto = new JTextField();
        campoPuesto.setBounds(520, 180, 200, 23);
        campoPuesto.setEditable(true);
        campoPuesto.addKeyListener(new KeyListener() {
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
        JLabel Domicilio = new JLabel("Domicilio ");
        Domicilio.setBounds(10, 270, 200, 23);
        JLabel Calle = new JLabel("Calle:");
        Calle.setBounds(10, 300, 200, 23);
        campoCalle = new JTextField();
        campoCalle.setBounds(10, 330, 200, 23);
        campoCalle.setEditable(true);
        campoCalle.addKeyListener(new KeyListener() {
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
        JLabel Colonia = new JLabel("Colonia");
        Colonia.setBounds(260, 360, 200, 23);
        CampoCol = new JTextField();
        CampoCol.setBounds(260, 390, 200, 23);
        CampoCol.setEditable(true);
        CampoCol.addKeyListener(new KeyListener() {
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
        JLabel CP = new JLabel("Código Postal");
        CP.setBounds(10, 360, 200, 23);
        CampoCP = new JTextField();
        CampoCP.setBounds(10, 390, 200, 23);
        CampoCP.setEditable(true);
        CampoCP.addKeyListener(new KeyListener() {
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
        JLabel Estado = new JLabel("Estado");
        Estado.setBounds(520, 360, 200, 23);
        ComEstado = new JComboBox(items);
        ComEstado.setBounds(520, 390, 200, 23);
        ComEstado.setEditable(true);
        JLabel Municipio = new JLabel("Municipio");
        Municipio.setBounds(10, 420, 200, 23);
        CampoMun = new JTextField();
        CampoMun.setBounds(10, 450, 200, 23);
        CampoMun.setEditable(true);
        CampoMun.addKeyListener(new KeyListener() {
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
        JLabel NumExt = new JLabel("Número Exterior: ");
        NumExt.setBounds(260, 300, 200, 23);
        CampoNumExt = new JTextField();
        CampoNumExt.setBounds(260, 330, 200, 23);
        CampoNumExt.setEditable(true);
        CampoNumExt.addKeyListener(new KeyListener() {
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
        JLabel NumInt = new JLabel("Número Interior: ");
        NumInt.setBounds(520, 300, 200, 23);
        CampoNumInt = new JTextField();
        CampoNumInt.setBounds(520, 330, 200, 23);
        CampoNumInt.setEditable(true);
        CampoNumInt.addKeyListener(new KeyListener() {
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
        JLabel Comentario = new JLabel("Descripción Descanso: ");
        Comentario.setBounds(10, 480, 200, 23);
        capComentario = new JTextField();
        capComentario.setBounds(160, 480, 400, 100);
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
        JLabel Status = new JLabel("Status: ");
        Status.setBounds(300, 420, 100, 23);
        Activo = new JRadioButton("Activo");
        Activo.setBounds(290, 450, 85, 23);
        Inactivo = new JRadioButton("Inactivo");
        Inactivo.setBounds(375, 450, 85, 23);
        Descanso = new JRadioButton("Descanso");
        Descanso.setBounds(460, 450, 100, 23);
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(Activo);
        buttonGroup2.add(Inactivo);
        buttonGroup2.add(Descanso);
        JButton Guardar = new JButton("Guardar");
        Guardar.setBounds(620, 500, 150, 30);
        Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estalleno() == true) {
                    System.out.println("Ok");
                    DataBaseManager obc = new DataBaseManager();
                    obc.Connection();
                    String idEmpleado = campoIdEm.getText();
                    int campoestciv = EstCiv.getSelectedIndex();
                    String campotelefono = campoTelefono.getText();
                    String campoestado = (String) ComEstado.getSelectedItem();
                    String Campomun = CampoMun.getText();
                    String Campocol = CampoCol.getText();
                    String campocalle = campoCalle.getText();
                    String campoCP = CampoCP.getText();
                    String CamponumInt = CampoNumInt.getText();
                    String CamponumExt = CampoNumExt.getText();
                    String usuario = campoId.getText();
                    String Campopass = CampoPass.getText();
                    String Campopuesto = campoPuesto.getText();
                    if (Activo.isSelected()) {
                        tatus = "Activo";
                    } else if (Inactivo.isSelected()) {
                        tatus = "Inactivo";
                    } else {
                        tatus = "Descanso";
                    }
                    if (sFem.isSelected()) {
                        Genero = "F";
                    } else {
                        Genero = "M";
                    }

                    // genero 
                    String chalala = "update EMPLEADOS set "
                            + "ESTADO_CIVIL =" + campoestciv + ","
                            + "TELEFONO='" + campotelefono + "',"
                            + "ESTADO='" + campoestado + "',"
                            + "MUNICIPIO='" + Campomun + "',"
                            + "COLONIA='" + Campocol + "',"
                            + "CALLE='" + campocalle + "',"
                            + "CP=" + campoCP + ","
                            + "NUM_INT='" + CamponumInt + "',"
                            + "NUM_EXT='" + CamponumExt + "',"
                            + "USUARIO='" + usuario + "',"
                            + "CONTRASENA='" + Campopass + "',"
                            + "ID_PUESTO=" + Campopuesto + ","
                            + "STATUS='" + tatus + "' "
                            + "WHERE ID_EMPLEADO =" + idEmpleado;
                    System.out.println(chalala);
                    String Sentencia = (chalala);
                    obc.Escribir(Sentencia);
                    JOptionPane.showMessageDialog(null, "Datos Guardados");
                } else {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                }
            }
        });

        JLabel BuscarLabel = new JLabel("Id Empleado:");
        BuscarLabel.setBounds(10, 3, 100, 23);
        BuscarEmpleado = new JTextField();
        BuscarEmpleado.setBounds(115, 3, 200, 23);
        BuscarEmpleado.setEditable(true);
        BuscarEmpleado.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < '0' || car > '9')) {
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
        Ok.setBounds(320, 3, 150, 30);
        Ok.addActionListener(new ActionListener() {
 private Component rootPane;
            @Override
            public void actionPerformed(ActionEvent e) {
                campIdEmp = BuscarEmpleado.getText();
     try {
         this.consulta(campIdEmp);
     } catch (SQLException ex) {
         Logger.getLogger(ModificarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
     }
            }
               
            private void consulta (String IdEmp) throws SQLException{
                try {
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sapito", "sapito");
                    stmt = conn.createStatement();
                    System.out.println("Conexión realizada");
                    pS = conn.prepareStatement("SELECT ID_EMPLEADO, NOMBRE, APELLIDO_P, APELLIDO_M, FECHA_NAC, ESTADO_CIVIL, TELEFONO, ESTADO, MUNICIPIO, COLONIA, CALLE, CP, NUM_INT, NUM_EXT, USUARIO, CONTRASENA, ID_PUESTO, FECHA_CONTRATO, GENERO, STATUS FROM EMPLEADOS WHERE ID_EMPLEADO =?");
                    pS.setString(1, campIdEmp);
                    rs = pS.executeQuery();
                    
                    if (rs.next()) {
                        pS = conn.prepareStatement("SELECT ID_EMPLEADO, NOMBRE, APELLIDO_P, APELLIDO_M, FECHA_NAC, ESTADO_CIVIL, TELEFONO, ESTADO, MUNICIPIO, COLONIA, CALLE, CP, NUM_INT, NUM_EXT, USUARIO, CONTRASENA, ID_PUESTO, FECHA_CONTRATO, GENERO, STATUS FROM EMPLEADOS WHERE ID_EMPLEADO =?");
                        System.out.println(pS);
                        pS.setString(1, campIdEmp);
                        resultSet = pS.executeQuery();
                   
                        while (resultSet.next()) {
                            campoIdEm.setText(rs.getString("id_empleado"));
                            campoNombre.setText(rs.getString("NOMBRE"));
                            campoPaterno.setText(rs.getString("APELLIDO_P"));
                            campoMaterno.setText(rs.getString("APELLIDO_M"));
                            campoFechNaci.setText(rs.getString("FECHA_NAC"));
                            EstCiv.setSelectedItem(rs.getString("ESTADO_CIVIL"));
                            campoTelefono.setText(rs.getString("TELEFONO"));
                            ComEstado.setSelectedItem(rs.getString("ESTADO"));
                            CampoMun.setText(rs.getString("MUNICIPIO"));
                            CampoCol.setText(rs.getString("COLONIA"));
                            campoCalle.setText(rs.getString("CALLE"));
                            CampoCP.setText(rs.getString("CP"));
                            CampoNumInt.setText(rs.getString("NUM_INT"));
                            CampoNumExt.setText(rs.getString("NUM_EXT"));
                            campoId.setText(rs.getString("USUARIO"));
                            CampoPass.setText(rs.getString("CONTRASENA"));
                            campoPuesto.setText(rs.getString("ID_PUESTO"));
                            CampoFecha.setText(rs.getString("FECHA_CONTRATO"));
                            String Genero1 = rs.getString("GENERO");
                            if (Genero1 == "F") {
                                sFem.setSelected(true);
                            } else {
                                sMas.setSelected(true);
                            }
                            String status = rs.getString("STATUS");
                            if (status.equals("Activo")) {
                                Activo.setSelected(true);

                            } else {
                                if (status.equals("Inactivo")) {
                                    Inactivo.setSelected(true);
                                } else {
                                    if (status.equals("Descanso")) {
                                        Descanso.setSelected(true);
                                    }
                                }
                            }

                    }
                    } else {
                        JOptionPane.showMessageDialog(null, "NO INGRESO EL ID A BUSCAR", "Error!!", JOptionPane.ERROR_MESSAGE);
                    }
                   } catch (SQLException ex) {
                    System.out.println("X: " + ex);
                }
            }
        });
                JButton Reg = new JButton("Regresar");
        Reg.setBounds(620, 460, 150, 30);
        Reg.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                       jFrame.dispose();
                    }
                }
        );
        jPanel.add(Reg);
        mEdicion.add(miGuardar);
        mAyuda.add(miAyuda);
        jPanel.add(Estado);
        jPanel.add(Status);
        jPanel.add(Activo);
        jPanel.add(Inactivo);
        jPanel.add(Descanso);
        jPanel.add(ComEstado);
        jPanel.add(Municipio);
        jPanel.add(CampoMun);
        jPanel.add(NumExt);
        jPanel.add(CampoNumExt);
        jPanel.add(NumInt);
        jPanel.add(CampoNumInt);
        jPanel.add(Password);
        jPanel.add(CampoPass);
        jPanel.add(CP);
        jPanel.add(CampoCP);
        jPanel.add(Colonia);
        jPanel.add(CampoCol);
        jPanel.add(FechaCont);
        jPanel.add(CampoFecha);
        jPanel.add(IdUsuario);
        jPanel.add(campoId);
        jPanel.add(Domicilio);
        jPanel.add(Calle);
        jPanel.add(campoCalle);
        jPanel.add(IdEmpleado);
        jPanel.add(campoIdEm);
        jPanel.add(Nombre);
        jPanel.add(campoNombre);
        jPanel.add(ApPaterno);
        jPanel.add(campoPaterno);
        jPanel.add(ApMaterno);
        jPanel.add(campoMaterno);
        jPanel.add(EstadoCiv);
        jPanel.add(EstCiv);
        jPanel.add(Sexo);
        jPanel.add(sFem);
        jPanel.add(sMas);
        jPanel.add(Edad);
        jPanel.add(campoFechNaci);
        jPanel.add(Telefono);
        jPanel.add(campoTelefono);
        jPanel.add(Puesto);
        jPanel.add(campoPuesto);
        jPanel.add(Guardar);
        jFrame.setJMenuBar(mbModificar);
        jPanel.add(BuscarLabel);
        jPanel.add(BuscarEmpleado);
        jPanel.add(Ok);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

    public boolean estalleno() {
        if (campoTelefono.getText().isEmpty()
                || campoCalle.getText().isEmpty()
                || campoId.getText().isEmpty()
                || CampoMun.getText().isEmpty()
                || CampoNumExt.getText().isEmpty()
                || CampoNumInt.getText().isEmpty()
                || CampoPass.getText().isEmpty()
                || campoPuesto.getText().isEmpty()
                || CampoCP.getText().isEmpty()
                || CampoCol.getText().isEmpty()) {
            return false;
        }
        return true;
    }
}
