
package RH;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Recluta extends JPanel {

    public JFrame jFrame;
    public JPanel jPanel;
    public JTextField IdEmpleado;
    public JComboBox EstCiv;
    public JComboBox CampoEstado;
    public String items[] = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila", "Colima", "Durango",
        "Estado de México", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla",
        "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas"};
    public String Civil[] = {"Soltero", "Casado", "Viudo", "Divorciado", "Union Libre"};

    public Recluta(String Titulo) {
        String jFrameTitle = Titulo; // dar tiitulo al frame
        jFrame = new JFrame(jFrameTitle); //definir el evento para el cerrado del frame
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //definir el tamaÃ±o del frame
        jFrame.setSize(800, 600);

        //dar la posicion del frame
        //obtener las dimensiones de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);

        //Generar un panel para incrustar elementos
        jPanel = new JPanel();
        //Definit el layout para acomodar la informaciÃ³n en el panel
        jPanel.setLayout(null);

        JMenuBar mbModificar = new JMenuBar();

        JMenu mEdicion = new JMenu("Edición");
        JMenu mAyuda = new JMenu("Ayuda");

        mbModificar.add(mEdicion);
        mbModificar.add(mAyuda);

        JMenuItem miGuardar = new JMenuItem("Guardar");
////        miGuardar.addActionListener(new MenuListener(jFrame)

        JMenuItem miAyuda = new JMenuItem("Acerca de");
//        miAyuda.addActionListener(new MenuListener(jFrame));
        
        
        JLabel Nombre = new JLabel("Nombre(s):");
        Nombre.setBounds(10, 30, 200, 23);
        JTextField campoNombre = new JTextField();
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

       
        JLabel Edad = new JLabel("Fecha de Nacimiento: ");
        Edad.setBounds(260, 210, 200, 23);
        JTextField campoEdad = new JTextField("dd/mm/aaaa");
        campoEdad.setBounds(260, 240, 200, 23);
        campoEdad.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                campoEdad.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        campoEdad.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if ((x < '0' || x > '9') 
                        && (x != '-')
                        && (x < 'a' || x > 'z')
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
        JTextField campoId = new JTextField();
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
        Password.setBounds(260, 150, 200, 23);
        JTextField CampoPass = new JTextField();
        CampoPass.setBounds(260, 180, 200, 23);
        JLabel ApPaterno = new JLabel("Apellido Paterno: ");
        ApPaterno.setBounds(260, 30, 200, 23);
        JTextField campoPaterno = new JTextField();
        campoPaterno.setBounds(260, 60, 200, 23);
        campoPaterno.addKeyListener(new KeyListener() {

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
        JLabel ApMaterno = new JLabel("Apellido Materno: ");
        ApMaterno.setBounds(520, 30, 200, 23);
        JTextField campoMaterno = new JTextField();
        campoMaterno.setBounds(520, 60, 200, 23);
        campoMaterno.addKeyListener(new KeyListener() {

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
        JLabel IdEmpleado = new JLabel("Id Empleado");
        IdEmpleado.setBounds(10, 90, 200, 23);
        JTextField campoIdEm = new JTextField();
        campoIdEm.setBounds(10, 120, 200, 23);
        JLabel Telefono = new JLabel("Teléfono: ");
        Telefono.setBounds(260, 90, 200, 23);
        JTextField campoTelefono = new JTextField();
        campoTelefono.setBounds(260, 120, 200, 23);
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
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        JLabel FechaCont = new JLabel("Fecha contratación");
        FechaCont.setBounds(520, 90, 200, 23);
        JTextField CampoFecha = new JTextField("dd/mm/aaaa");
        CampoFecha.setBounds(520, 120, 200, 23);
        CampoFecha.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                campoEdad.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        campoEdad.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if ((x < '0' || x > '9') 
                        && (x != '-')
                        && (x < 'a' || x > 'z')
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
        JComboBox campoEstCiv = new JComboBox(Civil);
        campoEstCiv.setBounds(10, 240, 200, 23);
        
        JLabel Sexo = new JLabel("Género: ");
        Sexo.setBounds(510, 210, 100, 23);
        JRadioButton sFem = new JRadioButton("Femenino");
        sFem.setBounds(520, 235, 100, 23);
        JRadioButton sMas = new JRadioButton("Masculino");
        sMas.setBounds(520, 260, 100, 23);
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(sFem);
        buttonGroup1.add(sMas);
        JLabel Puesto = new JLabel("Puesto: ");
        Puesto.setBounds(520, 150, 200, 23);
        JTextField campoPuesto = new JTextField();
        campoPuesto.setBounds(520, 180, 200, 23);
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
        JTextField campoCalle = new JTextField();
        campoCalle.setBounds(10, 330, 200, 23);
        JLabel Colonia = new JLabel("Colonia");
        Colonia.setBounds(260, 360, 200, 23);
        JTextField CampoCol = new JTextField();
        CampoCol.setBounds(260, 390, 200, 23);
        JLabel CP = new JLabel("Código Postal");
        CP.setBounds(10, 360, 200, 23);
        JTextField CampoCP = new JTextField();
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
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        JLabel Estado = new JLabel("Estado");
        Estado.setBounds(520, 360, 200, 23);
        CampoEstado = new JComboBox(items);
        CampoEstado.setBounds(520, 390, 200, 23);

        
        JLabel Municipio = new JLabel("Municipio");
        Municipio.setBounds(10, 420, 200, 23);
        JTextField CampoMun = new JTextField();
        CampoMun.setBounds(10, 450, 200, 23);
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

        JLabel NumExt = new JLabel("Número Exterior: ");
        NumExt.setBounds(260, 300, 200, 23);
        JTextField CampoNumExt = new JTextField();
        CampoNumExt.setBounds(260, 330, 200, 23);
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
        NumInt.setBounds(520, 300, 200, 23);
        JTextField CampoNumInt = new JTextField();
        CampoNumInt.setBounds(520, 330, 200, 23);
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

        JLabel Comentario = new JLabel("Descripción Descanso: ");
        Comentario.setBounds(10, 480, 200, 23);
        JTextField capComentario = new JTextField();
        capComentario.setBounds(160, 480, 400, 100);
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

        JLabel BuscarLabel = new JLabel("Id Empleado:");
        BuscarLabel.setBounds(10, 3, 100, 23);
        JTextField BuscarEmpleado = new JTextField();
        BuscarEmpleado.setBounds(115, 3, 200, 23);
        JButton Ok = new JButton("Buscar");
        Ok.setBounds(320, 3, 150, 30);
        JButton Guardar = new JButton("Guardar");
        Guardar.setBounds(620, 500, 150, 30);
        //Guardar.addActionListener();

        mEdicion.add(miGuardar);
        mAyuda.add(miAyuda);
        jPanel.add(Estado);
        jPanel.add(Status);
        jPanel.add(Activo);
        jPanel.add(Inactivo);
        jPanel.add(Descanso);
        jPanel.add(CampoEstado);
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
        jPanel.add(campoEstCiv);
        jPanel.add(Sexo);
        jPanel.add(sFem);
        jPanel.add(sMas);
        jPanel.add(Edad);
        jPanel.add(campoEdad);
        jPanel.add(Telefono);
        jPanel.add(campoTelefono);
        jPanel.add(Puesto);
        jPanel.add(campoPuesto);
        jPanel.add(Comentario);
        jPanel.add(capComentario);
        jPanel.add(Guardar);
        jFrame.setJMenuBar(mbModificar);
        jPanel.add(BuscarLabel);
        jPanel.add(BuscarEmpleado);
        jPanel.add(Ok);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }
}
