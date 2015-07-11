package RH;

import Conexion.DataBaseManager;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class AgregarEmpleado extends JPanel {

    public JFrame jFrame;
    public JPanel jPanel;
    public JTextField IdEmpleado;
    public JTextField campoFechNaci;
    public JTextField campoNombre;
    public JTextField campoId;
    public JTextField CampoPass;
    public JTextField campoPaterno;
    public JTextField campoMaterno;
    public JTextField campoIdEm;
    public JTextField campoTelefono;
    public JTextField CampoFecha;
    public JTextField campoPuesto;
    public JTextField campoCalle;
    public JTextField CampoCol;
    public JTextField CampoCP;
    public JTextField CampoMun;
    public JTextField CampoNumExt;
    public JTextField CampoNumInt;
    public JTextField capComentario;
    public JComboBox EstCiv;
    public JComboBox ComEstado;
    public String FechaNaci;
    public String FechaContra;
    public String Genero;
    public String tatus;
    public String items[] = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila", "Colima", "Durango",
        "Estado de México", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla",
        "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas"};
    public String Civil[] = {"Soltero", "Casado", "Viudo", "Divorciado", "Union Libre"};

    public AgregarEmpleado(String Titulo) {
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

        JMenuBar jMenuBar = new JMenuBar();

        JMenu jMenu = new JMenu("Agregar");
        JMenu jMenu2 = new JMenu("Edicion");
        JMenu jMenu3 = new JMenu("Ayuda");

        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);
        JMenuItem jMenuItem2 = new JMenuItem("Guardar");
        jMenuItem2.addActionListener(new MenuListener(jFrame));
        JMenuItem jMenuItem3 = new JMenuItem("Salir");
        jMenuItem3.addActionListener(new MenuListener(jFrame));
        JMenuItem jMenuItem4 = new JMenuItem("Copiar");
        jMenuItem4.addActionListener(new MenuListener(jFrame));
        JMenuItem jMenuItem5 = new JMenuItem("Pegar");
        jMenuItem5.addActionListener(new MenuListener(jFrame));
        JMenuItem jMenuItem7 = new JMenuItem("Acerca de");
        jMenuItem7.addActionListener(new MenuListener(jFrame));

        JLabel Nombre = new JLabel("Nombre(s):");
        Nombre.setBounds(10, 30, 200, 23);
        campoNombre = new JTextField();
        campoNombre.setBounds(10, 60, 200, 23);
        campoNombre.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'A' || car > 'Z')
                        && (car < 'a' || car > 'z')
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
        JLabel FechNaci = new JLabel("Fecha de Nacimiento: ");
        FechNaci.setBounds(240, 210, 200, 23);
        campoFechNaci = new JTextField("DD-MM-AAAA");
        campoFechNaci.setBounds(240, 240, 200, 23);
        campoFechNaci.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                campoFechNaci.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        campoFechNaci.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if ((x < '0' || x > '9')
                        && (x != '-')
                        && (x < 'A' || x > 'Z')
                        && (x != (char) KeyEvent.VK_SPACE)) {
                    ke.consume();
                }

            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        JLabel IdUsuario = new JLabel("Usuario:");
        IdUsuario.setBounds(10, 150, 200, 23);
        campoId = new JTextField();
        campoId.setBounds(10, 180, 200, 23);
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
        Password.setBounds(240, 150, 200, 23);
        CampoPass = new JTextField();
        CampoPass.setBounds(240, 180, 200, 23);
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
        ApPaterno.setBounds(240, 30, 200, 23);
        campoPaterno = new JTextField();
        campoPaterno.setBounds(240, 60, 200, 23);
        campoPaterno.addKeyListener(new KeyListener() {
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
        JLabel ApMaterno = new JLabel("Apellido Materno: ");
        ApMaterno.setBounds(470, 30, 200, 23);
        campoMaterno = new JTextField();
        campoMaterno.setBounds(470, 60, 200, 23);
        campoMaterno.addKeyListener(new KeyListener() {
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
        JLabel IdEmpleado = new JLabel("Id Empleado");
        IdEmpleado.setBounds(10, 90, 200, 23);
        campoIdEm = new JTextField();
        campoIdEm.setBounds(10, 120, 200, 23);
        campoIdEm.addKeyListener(new KeyListener() {
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
        JLabel Telefono = new JLabel("Teléfono: ");
        Telefono.setBounds(240, 90, 200, 23);
        campoTelefono = new JTextField();
        campoTelefono.setBounds(240, 120, 200, 23);
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
        FechaCont.setBounds(470, 90, 200, 23);
        CampoFecha = new JTextField("DD-MM-AAAA");
        CampoFecha.setBounds(470, 120, 200, 23);
        CampoFecha.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                CampoFecha.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        CampoFecha.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if ((x < '0' || x > '9')
                        && (x != '-')
                        && (x < 'A' || x > 'Z')
                        && (x != (char) KeyEvent.VK_SPACE)) {
                    ke.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        JLabel EstadoCiv = new JLabel("Estado Civil: ");
        EstadoCiv.setBounds(10, 210, 200, 23);
        EstCiv = new JComboBox(Civil);
        EstCiv.setBounds(10, 240, 200, 23);

        JLabel Sexo = new JLabel("Genero: ");
        Sexo.setBounds(480, 210, 100, 23);
        JRadioButton sFem = new JRadioButton("Femenino");
        sFem.setBounds(470, 235, 100, 23);
        JRadioButton sMas = new JRadioButton("Masculino");
        sMas.setBounds(470, 260, 100, 23);
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(sFem);
        buttonGroup1.add(sMas);
        JLabel Puesto = new JLabel("Puesto: ");
        Puesto.setBounds(470, 150, 200, 23);
        campoPuesto = new JTextField();
        campoPuesto.setBounds(470, 180, 200, 23);
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
        campoCalle.setBounds(10, 330, 200, 23);
        JLabel Colonia = new JLabel("Colonia");
        Colonia.setBounds(240, 360, 200, 23);
        CampoCol = new JTextField();
        CampoCol.setBounds(240, 390, 200, 23);
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
                //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        JLabel Estado = new JLabel("Estado");
        Estado.setBounds(470, 360, 200, 23);
        ComEstado = new JComboBox(items);
        ComEstado.setBounds(470, 390, 200, 23);
        JLabel Municipio = new JLabel("Municipio");
        Municipio.setBounds(10, 420, 200, 23);
        CampoMun = new JTextField();
        CampoMun.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char car = ke.getKeyChar();
                if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && car != 'á' && car != 'é' && car != 'í' && car != 'ó' && car != 'ú' && car != 'Á' && car != 'É' && car != 'Í' && car != 'Ó' && car != 'Ú' && car != 'ñ' && car != 'Ñ' && (car != (char) KeyEvent.VK_SPACE)) {
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
        CampoMun.setBounds(10, 450, 200, 23);
        JLabel NumExt = new JLabel("Número Exterior: ");
        NumExt.setBounds(240, 300, 200, 23);
        CampoNumExt = new JTextField();
        CampoNumExt.setBounds(240, 330, 200, 23);
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
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        JLabel NumInt = new JLabel("Número Interior: ");
        NumInt.setBounds(470, 300, 200, 23);
        CampoNumInt = new JTextField();
        CampoNumInt.setBounds(470, 330, 200, 23);
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
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        JLabel Status = new JLabel("Status: ");
        Status.setBounds(300, 420, 100, 23);
        JRadioButton Activo = new JRadioButton("Activo");
        Activo.setBounds(290, 450, 85, 23);
        JRadioButton Inactivo = new JRadioButton("Inactivo");
        Inactivo.setBounds(375, 450, 85, 23);
        JRadioButton Descanso = new JRadioButton("Descanso");
        Descanso.setBounds(460, 450, 100, 23);
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(Activo);
        buttonGroup2.add(Inactivo);
        buttonGroup2.add(Descanso);

        JButton Guardar = new JButton("Guardar");
        Guardar.setBounds(630, 470, 150, 30);
        Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estalleno() == true) {
                    System.out.println("Ok");
                    DataBaseManager obc = new DataBaseManager();
                    obc.Connection();
                    if (sMas.isSelected()) {
                        Genero = "M";
                    } else if (sFem.isSelected()) {
                        Genero = "F";
                    }
                    if (Activo.isSelected()) {
                        tatus = "Activo";
                    } else if (Inactivo.isSelected()) {
                        tatus = "Inactivo";
                    } else if (Descanso.isSelected()) {
                        tatus = "Descanso";
                    }
                    int campoidEm = Integer.parseInt(campoIdEm.getText());
                    String camponombre = campoNombre.getText();
                    String campopaterno = campoPaterno.getText();
                    String campomaterno = campoMaterno.getText();
                    String campofechanacimiento = campoFechNaci.getText();
                    int campoestciv = EstCiv.getSelectedIndex();
                    String campotelefono = campoTelefono.getText();
                    String campoestado = (String) ComEstado.getSelectedItem();
                    String Campomun = CampoMun.getText();
                    String Campocol = CampoCol.getText();
                    String campocalle = campoCalle.getText();
                    int campoCP = Integer.parseInt(CampoCP.getText());
                    String CamponumInt = CampoNumInt.getText();
                    String CamponumExt = CampoNumExt.getText();
                    String usuario = campoId.getText();
                    String Campopass = CampoPass.getText();
                    String Campopuesto = campoPuesto.getText();
                    String Campofecha = CampoFecha.getText();

                    // genero 
                    String chalala = "insert into EMPLEADOS values ("
                            + campoidEm + ",'"
                            + camponombre + "','"
                            + campopaterno + "','"
                            + campomaterno + "','"
                            + campofechanacimiento + "',"
                            + campoestciv + ",'"
                            + campotelefono + "','"
                            + campoestado + "','"
                            + Campomun + "','"
                            + Campocol + "','"
                            + campocalle + "',"
                            + campoCP + ",'"
                            + CamponumInt + "','"
                            + CamponumExt + "','"
                            + usuario + "','"
                            + Campopass + "',"
                            + Campopuesto + ",'"
                            + Campofecha + "','"
                            + Genero + "','"
                            + tatus + "')";
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
        Reg.setBounds(630, 430, 150, 30);
        Reg.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                           jFrame.dispose();
                    }
                }
        );

        jMenu.add(jMenuItem2);
        jMenu.add(jMenuItem3);
        jMenu2.add(jMenuItem4);
        jMenu2.add(jMenuItem5);
        jMenu3.add(jMenuItem7);
        jPanel.add(Reg);
        jPanel.add(Status);
        jPanel.add(Activo);
        jPanel.add(Inactivo);
        jPanel.add(Descanso);
        jPanel.add(Estado);
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
        jPanel.add(FechNaci);
        jPanel.add(campoFechNaci);
        jPanel.add(Telefono);
        jPanel.add(campoTelefono);
        jPanel.add(Puesto);
        jPanel.add(campoPuesto);
//        jPanel.add(Comentario);
//        jPanel.add(capComentario);
        jPanel.add(Guardar);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

    public boolean estalleno() {
        if (campoNombre.getText().isEmpty()
                || campoPaterno.getText().isEmpty()
                || campoMaterno.getText().isEmpty()
                || campoTelefono.getText().isEmpty()
                || CampoFecha.getText().isEmpty()
                || campoCalle.getText().isEmpty()
                || campoId.getText().isEmpty()
                || campoIdEm.getText().isEmpty()
                || CampoMun.getText().isEmpty()
                || CampoNumExt.getText().isEmpty()
                || CampoNumInt.getText().isEmpty()
                || CampoPass.getText().isEmpty()
                || campoFechNaci.getText().isEmpty()
                || campoPuesto.getText().isEmpty()
                || CampoCP.getText().isEmpty()
                || CampoCol.getText().isEmpty()) {
            return false;
        }
        return true;
    }
}
