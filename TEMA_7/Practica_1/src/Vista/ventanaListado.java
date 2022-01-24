package Vista;

import Exception.*;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaListado {
    private JLabel lTitulo;
    private JTextField tNombre;
    private JTextField tApellidos;
    private JTextField tDNI;
    private JButton bAceptar;
    private JButton bSalir;
    private JLabel lNombre;
    private JLabel lApellidos;
    private JLabel lDNI;
    private JPanel Panel;

    //Acciones
    public ventanaListado() {
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fClick();
            }
        });
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
    public void fClick(){
        boolean continuar = true;
        while (continuar){
            try {
                if(tNombre.getText().isEmpty() || tApellidos.getText().isEmpty() || tDNI.getText().isEmpty()){
                    throw new DatoNoValido("Campo obligatorio sin rellenar");
                }
                else{
                    continuar = false;
                    Main.tenDatos(tNombre.getText(), tApellidos.getText(), tDNI.getText());
                }
            }
            catch (DatoNoValido e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("ventanaListado");
        frame.setContentPane(new ventanaListado().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}


