package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V1 {
    private JPanel pPrincipal;
    private JPanel pHerramientas;
    private JPanel pGuardarEvento;
    private JToolBar tbHerramientas;
    private JButton guardarEventoButton;
    private JButton bOpcionCancelar;
    private JButton bGuardar;
    private JPanel pCancelarEvento;
    private JButton bCancelarEvento;
    private JMenuItem miGuardarEvento;
    private JButton button1;
    private JMenuBar mbHerramientas;
    private JMenuItem miCancelarEvento;
    private JMenuItem miModificarEvento;

    public V1() {
        /**
         *Llamada al controlador, apertura ventana
         *
         * @author Victor Ibañez
         * @version 18/03/2022
         */
        miGuardarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.abrirVentanaGuardar();
            }
        });
        miCancelarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String nombre = JOptionPane.showInputDialog(null, "Introduce el evento que" +
                                                                " quieres cancelar");
                    validarNombre(nombre);
                    String datos = Main.calcelarEvento(nombre);
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de borrar" +
                                                                    " de forma definitiva este evento?" + datos);
                    if (respuesta == 0){
                        Main.borrarEvento();
                        JOptionPane.showMessageDialog(null, "Evento cancelado");
                    }
                }
                catch (Exception a){
                    JOptionPane.showMessageDialog(null, a.getMessage());
                }
            }
        });
        miModificarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.abrirVentanaModificar();
            }
        });
    }

    public void validarNombre(String nombre) throws Exception{
        if (nombre.isEmpty()){
            throw new Exception("El nombre es un dato obligatorio");
        }
    }

    //Main:

    public static void main(String[] args) {
        JFrame frame = new JFrame("V1");
        frame.setContentPane(new V1().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //get y set de pPrincipal:

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void setpPrincipal(JPanel pPrincipal) {
        this.pPrincipal = pPrincipal;
    }
}
