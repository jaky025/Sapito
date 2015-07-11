/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad;

import Conexion.DataBaseManager;
import Procesos.Proceso;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Arturo
 */
public class pass{

    public JFrame jFrame;
    public JPanel jPanel;
    public JTextField jTextField;
    public DataBaseManager cn= new DataBaseManager();
    public pass() {

        jFrame = new JFrame("Login");
        jFrame.setVisible(true);
        jFrame.setSize(200, 200);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("X:" + screenSize.width + " Y:" + screenSize.height);
        int x = (screenSize.width / 2) - (jFrame.getSize().width / 2);
        int y = (screenSize.height / 2) - (jFrame.getSize().height / 2);
        jFrame.setLocation(x, y);

        jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(Color.WHITE);

        JLabel usu = new JLabel("Usuario");
        usu.setBounds(10, 50, 90, 20);
        jPanel.add(usu);

        JLabel pas = new JLabel("Password");
        pas.setBounds(10, 80, 90, 20);
        jPanel.add(pas);

        JTextField usuario = new JTextField();
        usuario.setBounds(70, 50, 90, 20);
        JPasswordField password = new JPasswordField();
        password.setBounds(70, 80, 90, 20);
        jPanel.add(usuario);
        jPanel.add(password);

        JButton jboton = new JButton("Aceptar");
        jboton.setBounds(80, 110, 90, 20);
        jboton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cn.Connection();
                if(DataBaseManager.getConexion()!=null)
                {
                    ResultSet rs;
                    Statement st;
                    try {
                        st=DataBaseManager.getConexion().createStatement();
                        rs=st.executeQuery("Select NOMBRE from EMPLEADOS where USUARIO ='"+usuario.getText()+"' and CONTRASENA='"+password.getText()+"'");
                        if(rs.next()) 
                        {
                            String user="";
                            for (int i = 0; i < 3; i++)
                            {
                                user=user+usuario.getText().charAt(i);
                            }
                            
                            System.out.println(user);
                            switch(user)
                            {
                                case "DIR" :
                                    break;
                                case "REC":
                                    break;
                                case "COM" :
                                    break;
                                case "VEN":
                                    break;
                                case "INV":
                                    break;
                                case "CON":
                                    VentanaGeneral vent=new VentanaGeneral();
                                    vent.setVisible(true);
                                    jFrame.dispose();
                                    break;
                                case "FAC":
                                    break;
                            }
                        }
                        else{
                            System.out.println(usuario.getText());
                            System.out.println(password.getPassword().toString());
                            JOptionPane.showConfirmDialog(null,"Usuario o Contraseña incorrectos", "Error",JOptionPane.WARNING_MESSAGE);
                            usuario.setText("");
                            password.setText("");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(pass.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }                 
            }
        });

        jPanel.add(jboton);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

//    public static void main(String[] args) {
//        pass simple09 = new pass();
//    }
}
