package RH;

import Compras.PrincipalCompras;
import Conexion.DataBaseManager;
import Inventario.Menu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import direccion.Direccion;
import Ventas.Gerente;
import contabilidad.VentanaGeneral;
import facilities.Facilities;

public class login extends JPanel {

    public JFrame jFrame;
    public JPanel jPanel;
    JTextField userId;
    JPasswordField password;

    public login() {
        String frameTitle = "Acceso a SAPITO S.A. DE C.V.";
        jFrame = new JFrame(frameTitle);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(300, 300);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);

        jPanel = new JPanel();
        jPanel.setLayout(null);

        userId = new JTextField();
        userId.setBounds(100, 10, 150, 25);

        password = new JPasswordField();
        password.setBounds(100, 40, 150, 25);

        JLabel user = new JLabel("Usuario");
        user.setBounds(10, 10, 50, 25);
        JLabel clave = new JLabel("Contraseña");
        clave.setBounds(10, 40, 90, 25);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBounds(100, 100, 100, 40);
        aceptar.addActionListener((ActionEvent e) -> {
            String passw = new String(password.getPassword());
            if (!userId.getText().isEmpty() && !passw.isEmpty()) {
                String userid = "";
                for (int i = 0; i < 3; i++) {
                    userid = userid + userId.getText().charAt(i);
                }
                switch (userid) {
                    case "DIR":
                        if (userId.equals("DIRECCION")||passw.equals("dir123")) {
                            System.out.println("Correcto");
                            new Direccion();
                            jFrame.dispose();
                        } else {
                            MensajeError();
                        }

                        break;
                    case "REH":
                        if (passw.equals("rh123")) {
                            System.out.println("Correcto");
                            new Principal_RH();
                            jFrame.dispose();
                        } else {
                            MensajeError();
                        }
                        break;
                    case "COM":
                        if (passw.equals("compras123")) {
                            System.out.println("Correcto");
                            new PrincipalCompras();
                            jFrame.dispose();
                        } else {
                            MensajeError();
                        }
                        break;
                    case "VEN":
                        if (passw.equals("ven123")) {
                            System.out.println("Correcto");
                            new Gerente();
                            jFrame.dispose();
                        } else {
                            MensajeError();
                        }
                        break;
                    case "INV":
                        if (passw.equals("inv123")) {
                            System.out.println("Correcto");
                            new Menu();
                            jFrame.dispose();
                        } else {
                            MensajeError();
                        }
                        break;
                    case "CON":
                        if (passw.equals("con123")) {
                            System.out.println("Correcto");
                            new VentanaGeneral();
                            jFrame.dispose();
                        } else {
                            MensajeError();
                        }
                        break;

                    case "FAC":
                        if (passw.equals("mueble123")) {
                            System.out.println("Correcto");
                            new Facilities();
                            jFrame.dispose();
                        } else {
                            MensajeError();
                        }
                        break;
                    default:
                        MensajeError();
                        break;
                }
            } else {
                MensajeError();
            }
        });

        jPanel.add(aceptar);
        jPanel.add(user);
        jPanel.add(clave);
        jPanel.add(password);
        jPanel.add(userId);
        jFrame.add(jPanel);
        jFrame.setVisible(
                true);
    }

    public void MensajeError() {
        JOptionPane.showMessageDialog(jFrame, "Usuario o contraseña incorrectos", "Alerta",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) throws SQLException {
        login log = new login();
        DataBaseManager obc = new DataBaseManager();
        //  obc.Conectar();

    }

    public void Connection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
