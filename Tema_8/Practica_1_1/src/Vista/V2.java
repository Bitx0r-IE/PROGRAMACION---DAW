package Vista;

import Excepciones.DatoNoValido;
import Modelo.BD.Base_Datos;
import Modelo.BD.PersonaDAO;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class V2 {
    private JPanel pInfo;
    private JPanel pTitulo;
    private JLabel lTitulo;
    private JLabel lNombre;
    private JTextField tfNombre;
    private JPanel pDatos;
    private JTextField tfEdad;
    private JTextField tfProfesion;
    private JTextField tfTelefono;
    private JButton bSalir;
    private JButton bSiguiente;
    private JButton bAtras;
    private JButton bAceptar;

    public V2() {
        bAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Base_Datos.cerrarBD();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validar() ==true){
                    try {
                        PersonaDAO.crearPerso(tfEdad.getText(), tfNombre.getText(), tfProfesion.getText(),
                                            tfTelefono.getText());
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });
    }

    //Main:

    public static void main(String[] args) {
        JFrame frame = new JFrame("V2");
        frame.setContentPane(new V2().pInfo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //get set de pInfo:

    public JPanel getpInfo() {
        return pInfo;
    }

    public void setpInfo(JPanel pInfo) {
        this.pInfo = pInfo;
    }

    //Operaciones:

    public boolean validar(){
        try {
            if (tfEdad.getText().isEmpty()){
                throw new DatoNoValido("Campo EDAD sin completar");
            }
            if (tfNombre.getText().isEmpty()){
                throw new DatoNoValido("Campo NOMBRE sin completar");
            }
            if (tfProfesion.getText().isEmpty()){
                throw new DatoNoValido("Campo PROFESION sin completar");
            }
            if (tfTelefono.getText().isEmpty()){
                throw new DatoNoValido("Campo TELEFONO sin completar");
            }
        }
        catch (DatoNoValido e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
        return true;
    }
}
