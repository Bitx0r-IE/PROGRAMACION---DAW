package Vista;

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
                    comprabarOpcion();
                } catch (SQLException ex) {
                    ex.printStackTrace();
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
    public void comprabarOpcion() throws SQLException {
        String opcion = tfOpcion.getText();
        switch (opcion){
            case "1":
            case "2":
            case "3":
                Main.mostrarVentanaPersonas();
                break;
            case "4":
                Main.cerrarBD();
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Teclee una opción valida");
        }
    }
}
