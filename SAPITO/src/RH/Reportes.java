package RH;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Reportes extends JPanel {

    public JFrame jFrame;
    public JPanel jPanel;
    public JTextField IdEmpleado;

    public Reportes() {
        String jFrameTitle = "Reportes"; // dar tiitulo al frame
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

        JMenuBar jMenuBar = new JMenuBar();

        JMenu jMenu = new JMenu("Archivo");
        JMenu jMenu2 = new JMenu("Edición");
        JMenu jMenu3 = new JMenu("Ayuda");

        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);

        JMenuItem jMenuItem = new JMenuItem("Buscar");
        jMenuItem.addActionListener(new MenuListener(jFrame) {
        });
        JMenuItem jMenuItem2 = new JMenuItem("Guardad");
        jMenuItem2.addActionListener(new MenuListener(jFrame));
        JMenuItem jMenuItem3 = new JMenuItem("Cerrar");
        jMenuItem3.addActionListener(new MenuListener(jFrame));
        JMenuItem jMenuItem4 = new JMenuItem("Copiar");
        jMenuItem4.addActionListener(new MenuListener(jFrame));
        JMenuItem jMenuItem5 = new JMenuItem("Pegar");
        jMenuItem5.addActionListener(new MenuListener(jFrame));
        JMenuItem jMenuItem6 = new JMenuItem("Resaltar");
        jMenuItem6.addActionListener(new MenuListener(jFrame));
        JMenuItem jMenuItem7 = new JMenuItem("Acerca de");
        jMenuItem7.addActionListener(new MenuListener(jFrame));

        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem2);
        jMenu.add(jMenuItem3);
        jMenu2.add(jMenuItem4);
        jMenu2.add(jMenuItem5);
        jMenu2.add(jMenuItem6);
        jMenu3.add(jMenuItem7);

        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

}
