package Vista;

import javax.swing.*;

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

    public static void main(String[] args) {
        JFrame frame = new JFrame("ventanaListado");
        frame.setContentPane(new ventanaListado().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


