package RH;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MenuListener implements ActionListener {

    JFrame jFrame;

    public MenuListener(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("e: " + e.getActionCommand());
        switch (e.getActionCommand()) {
            case "E_Alta":
                new AgregarEmpleado("Alta de Empleado");
                break;
            case "E_Baja":
                new ModificarEmpleado("Baja de Empleado");
                break;
            case "E_Modificar":
                new ModificarEmpleado("Modificar Empleado");
                break;
            case "E_Generar Pago":
                new GenerarNomina("Generar Nómina");
                break;
            case "P_Alta":
                new AgregarPuesto("Alta de Puesto");
                break;
            case "P_Baja":
                new ModificarPuesto("Inhabilitar Puesto");
                break;
            case "P_Modificar":
                new ModificarPuesto("Modificar Puesto");
            case "C_Reclutamineto":
                new Recluta("Reclutamiento de personal");
                break;
            case "C_Seleccion":
                break;
            case "C_Capacitacion":
                break;
            case "Acerca de":
                JOptionPane.showMessageDialog(jFrame, "Se presiono Acerca de ", "Informacion", JOptionPane.ERROR_MESSAGE);
                break;
            case "Salir":
                System.exit(0);
        }
    }

}
