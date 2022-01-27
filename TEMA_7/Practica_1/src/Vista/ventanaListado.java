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

    //Main:

    public static void main(String[] args) {
        JFrame frame = new JFrame("ventanaListado");
        frame.setContentPane(new ventanaListado().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    //set y get:

    public JPanel getPanel() {
        return Panel;
    }

    public void setPanel(JPanel panel) {
        Panel = panel;
    }

    //Acciones
    public ventanaListado() {
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
    }

    public void fAccept() {
        if (validar()) {
            Main.crearPerso(tNombre.getText(), tApellidos.getText(), tDNI.getText());
            inicializar();
        }
    }

    public boolean validar() {
        try {
            if (tNombre.getText().isEmpty()) {
                throw new DatoNoValido("Campo obligatorio sin rellenar");
            }
            if (tApellidos.getText().isEmpty()) {
                throw new DatoNoValido("Campo obligatorio sin rellenar");
            }
            if (tDNI.getText().isEmpty()) {
                throw new DatoNoValido("Campo obligatorio sin rellenar");
            }
        } catch (DatoNoValido e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return true;
    }

    public void inicializar(){
        //retornar la ventana a su estado original:
        tNombre.setText("");
        tApellidos.setText("");
        tDNI.setText("");
        tNombre.requestFocus();
    }
}


