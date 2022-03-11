package Vista;

import Excepciones.DatoNoValido;
import Modelo.BD.Base_Datos;
import Modelo.BD.PersonaDAO;
import Modelo.UML.Persona;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class V1 {
    private JPanel pPrincipal;
    private JLabel lPersonas;
    private JTextField tfOpcion;
    private JLabel lOp1;
    private JLabel lOp2;
    private JLabel lOp3;
    private JLabel lOp4;
    private JPanel pEleccion;
    private JPanel pOpciones;

    //Main:

    public V1() {
        tfOpcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    comprobarOpcion();
                } catch (DatoNoValido a) {
                    JOptionPane.showMessageDialog(null, a.getMessage());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("V1");
        frame.setContentPane(new V1().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //get set de pPrincipal:

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void setpPrincipal(JPanel pPrincipal) {
        this.pPrincipal = pPrincipal;
    }

    //Operaciones:
    public void comprobarOpcion() throws Exception {
        String opcion = tfOpcion.getText();
        switch (opcion){
            case "1":
                PersonaDAO.opcion1();
                break;
            case "2":
                PersonaDAO.opcion2();
                break;
            case "3":
                PersonaDAO.opcion3();
                break;
            case "4":
                Base_Datos.cerrarBD();
                System.exit(0);
                break;
            default:
                throw new DatoNoValido("Teclee una opción valida");
        }
    }
}
