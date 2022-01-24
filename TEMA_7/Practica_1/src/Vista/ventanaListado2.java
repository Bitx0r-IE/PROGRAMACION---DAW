package Vista;

import javax.swing.*;

public class ventanaListado2 {
    private JPanel Panel;
    private JLabel lTitulo;
    private JTextArea textArea1;
    private JButton bSalir;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ventanaListado2");
        frame.setContentPane(new ventanaListado2().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
