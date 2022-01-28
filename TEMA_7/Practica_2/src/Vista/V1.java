package Vista;

import Excepciones.DatoNoValido;
import com.company.Main;
import com.sun.org.apache.xerces.internal.dom.DeferredNotationImpl;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V1 {
    private JPanel pPrincipal;
    private JTextField tDNI;
    private JTextField tNombre;
    private JTextField tApellidos;
    private JTextField tCurso;
    private JLabel ldni;
    private JLabel lNombre;
    private JLabel lApellidos;
    private JLabel lCurso;
    private JButton bAceptar;
    private JButton bSalir;

    //Main:

    public V1() {
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fAccept();
            }
        });
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        tCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bAceptar.doClick();//fAccept()
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("V1");
        frame.setContentPane(new V1().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);//Que aparezca centrado
        frame.pack();
        frame.setVisible(true);
    }

    //set y get (panel):

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void setpPrincipal(JPanel pPrincipal) {
        this.pPrincipal = pPrincipal;
    }

    //Funciones:
    public void fAccept(){
        //Validar datos y enviar a main.java:
        if (validar()){
            //Crear persona en caso de que no esté en la base de datos:
            Main.crearPersona(tDNI.getText() ,tNombre.getText(), tApellidos.getText(), tCurso.getText());
            //Inicializar la ventana:
            inicializar();
        }
    }

    public void inicializar(){
        //Inicializar la ventana (vaciar ventana y colocar el cursor en la primera):
        tDNI.setText("");
        tNombre.setText("");
        tApellidos.setText("");
        tCurso.setText("");
        tDNI.requestFocus();
    }

    public boolean validar(){
        //validar datos antes de enviar la respuesta al main:
        try {
            if (tNombre.getText().isEmpty()){
                throw new DatoNoValido("Campo NOMBRE sin rellenar");
            }
            if (tApellidos.getText().isEmpty()){
                throw new DatoNoValido("Campo APELLIDOS sin rellenar");
            }
            if (tDNI.getText().isEmpty()){
                throw new DatoNoValido("Campo DNI sin rellenar");
            }
            if (tCurso.getText().isEmpty()){
                throw new DatoNoValido("Campo CURSO sin rellenar");
            }
            if (Main.comprobarCurso(tCurso.getText()) == false){
                throw new DatoNoValido("El curso introducido NO es VALIDO");
            }
            if (Main.comprobarDNI(tDNI.getText()) == true){
                Main.modificar();
            }
            return true;
        }
        catch (DatoNoValido e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
}

