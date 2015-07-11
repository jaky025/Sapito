package RH;

import Conexion.DataBaseManager;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class ModificarPuesto extends JPanel {

    public JFrame jFrame;
    public JPanel jPanel;
    public JTextField CampoDesc;
    JTextField campoArea;
    JTextField campoSueldo;
    JTextField campoId;
    JTextField BuscarPuesto;

    public ModificarPuesto(String Titulo) {
        String jFrameTitle = Titulo; // dar tiitulo al frame
        jFrame = new JFrame(jFrameTitle); //definir el evento para el cerrado del frame
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //definir el tamaÃƒÂ±o del frame
        jFrame.setSize(800, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);
        jPanel = new JPanel();
        jPanel.setLayout(null);

        JMenuBar mbPuesto = new JMenuBar();

        JMenu mEdicion = new JMenu("Edición");
        JMenu mAyuda = new JMenu("Ayuda");

        mbPuesto.add(mEdicion);
        mbPuesto.add(mAyuda);

        JMenuItem miGuardar = new JMenuItem("Guardar");
        miGuardar.addActionListener(new MenuListener(jFrame) {
        });
        JMenuItem miAyuda = new JMenuItem("Acerca de");
        miAyuda.addActionListener(new MenuListener(jFrame));

        JLabel IdPuesto = new JLabel("Id Puesto:");
        IdPuesto.setBounds(300, 60, 200, 23);
        campoId = new JTextField();
        campoId.setBounds(300, 90, 200, 23);
        campoId.setEditable(false);
        JLabel Sueldo = new JLabel("Sueldo: ");
        Sueldo.setBounds(300, 125, 200, 23);
        campoSueldo = new JTextField();
        campoSueldo.setBounds(300, 160, 200, 23);
        campoSueldo.setEditable(true);
        campoSueldo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if ((x < '0' || x > '9') && (x != '.')) {
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
        JLabel AreaAsig = new JLabel("Area asignada: ");
        AreaAsig.setBounds(300, 195, 200, 23);
        campoArea = new JTextField();
        campoArea.setBounds(300, 230, 200, 23);
        campoArea.setEditable(true);
        campoArea.addKeyListener(new KeyListener() {

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
        JLabel Descripcion = new JLabel("Descripción ");
        Descripcion.setBounds(300, 265, 200, 23);
        CampoDesc = new JTextField();
        CampoDesc.setBounds(300, 300, 200, 23);
        CampoDesc.setEditable(true);
        CampoDesc.addKeyListener(new KeyListener() {

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

        JLabel BuscarLabel = new JLabel("Id_Puesto:");
        BuscarLabel.setBounds(200, 10, 100, 23);
        BuscarPuesto = new JTextField();
        BuscarPuesto.setBounds(305, 10, 200, 23);
        BuscarPuesto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char x = ke.getKeyChar();
                if ((x < '0' || x > '9') && (x != '.')) {
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
        JButton BuscarBoton = new JButton("Buscar");
        BuscarBoton.setBounds(510, 5, 150, 30);

        JLabel Status = new JLabel("Status: ");
        Status.setBounds(300, 340, 100, 23);
        JRadioButton Activo = new JRadioButton("Activo");
        Activo.setBounds(290, 370, 85, 23);
        JRadioButton Inactivo = new JRadioButton("Inactivo");
        Inactivo.setBounds(375, 370, 85, 23);
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(Activo);
        buttonGroup1.add(Inactivo);
        JButton Guardar = new JButton("Guardar");
        Guardar.setBounds(325, 450, 150, 30);
        Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estalleno() == true) {
                    System.out.println("Ok");
                    DataBaseManager obc = new DataBaseManager();
                    obc.Connection();
                    String Campoid = campoId.getText();
                    String CampoDescrip = CampoDesc.getText();
                    String CampoArea = campoArea.getText();
                    String CampoSueldo = campoSueldo.getText();
                    // genero 
                    String chalala = "UPDATE PUESTOS set "
                            + "DESCRIPCION='" + CampoDescrip + "',"
                            + "SUELDO=" + CampoSueldo + ","
                            + "AREA_ASIG='" + CampoArea + "' "
                            + "WHERE='" + Campoid + ";";
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
//                        new Principal_RH();
                        jFrame.dispose();
                    }
                }
        );
        jPanel.add(Reg);
        
        jPanel.add(IdPuesto);
        jPanel.add(campoId);
        jPanel.add(Sueldo);
        jPanel.add(campoSueldo);
        jPanel.add(AreaAsig);
        jPanel.add(campoArea);
        jPanel.add(Descripcion);
        jPanel.add(CampoDesc);
        jPanel.add(Guardar);
        jFrame.setJMenuBar(mbPuesto);
        jPanel.add(BuscarLabel);
        jPanel.add(BuscarPuesto);
        jPanel.add(BuscarBoton);
        jPanel.add(Status);
        jPanel.add(Activo);
        jPanel.add(Inactivo);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

    public boolean estalleno() {
        if (CampoDesc.getText().isEmpty()
                || campoArea.getText().isEmpty()
                || campoSueldo.getText().isEmpty()) {
            return false;
        }
        return true;
    }

}
