package RH;

import Conexion.DataBaseManager;
import Inventario.Menu;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class AgregarPuesto extends JPanel {

    public JFrame jFrame;
    public JPanel jPanel;
    public JTextField CampoDesc;
    JTextField campoArea;
    JTextField campoSueldo;
    JTextField campoId;

    public AgregarPuesto(String Titulo) {
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

        JMenuItem miGuardar = new JMenuItem("Guardar");
        miGuardar.addActionListener(new MenuListener(jFrame) {
        });
        JMenuItem miSalir = new JMenuItem("Salir");
        miSalir.addActionListener(new MenuListener(jFrame) {
        });
        JMenuItem miAyuda = new JMenuItem("Acerca de");
        miAyuda.addActionListener(new MenuListener(jFrame));
        mEdicion.add(miGuardar);
        mEdicion.add(miSalir);
        mAyuda.add(miAyuda);
        mbPuesto.add(mEdicion);
        mbPuesto.add(mAyuda);

        JLabel NvoPuesto = new JLabel("Nuevo Puesto");
        NvoPuesto.setBounds(300, 10, 200, 50);
        JLabel IdPuesto = new JLabel("Id Puesto:");
        IdPuesto.setBounds(300, 60, 200, 23);
        campoId = new JTextField();
        campoId.setBounds(300, 90, 200, 23);
        campoId.addKeyListener(new KeyListener() {
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
        JLabel Sueldo = new JLabel("Sueldo: ");
        Sueldo.setBounds(300, 125, 200, 23);
        campoSueldo = new JTextField();
        campoSueldo.setBounds(300, 160, 200, 23);
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
        JLabel AreaAsig = new JLabel("Área asignada: ");
        AreaAsig.setBounds(300, 195, 200, 23);
        campoArea = new JTextField();
        campoArea.setBounds(300, 230, 200, 23);
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

        JButton Guardar = new JButton("Guardar");
        Guardar.setBounds(325, 350, 150, 30);
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
                    String chalala = "insert into PUESTOS values ("
                            + Campoid + ",'"
                            + CampoDescrip + "',"
                            + CampoSueldo + ",'"
                            + CampoArea + "')";
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
        jPanel.add(NvoPuesto);
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
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

    public boolean estalleno() {
        if (CampoDesc.getText().isEmpty()
                || campoId.getText().isEmpty()
                || campoArea.getText().isEmpty()
                || campoSueldo.getText().isEmpty()) {
            return false;
        }
        return true;

    }
}
