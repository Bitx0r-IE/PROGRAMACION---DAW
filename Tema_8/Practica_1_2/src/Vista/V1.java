package Vista;

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
    private JTextField tfNombre;
    private JLabel lNombre;
    private JTextField tfLoc;
    private JLabel lLoc;
    private JTextField tfFecha;
    private JTextField tfInicio;
    private JTextField tfFin;
    private JTextField tfnumPerso;
    private JButton bGuardar;
    private JPanel pCancelarEvento;
    private JLabel lnumPerso;
    private JLabel lhoraFin;
    private JLabel lhoraInit;
    private JLabel lFecha;
    private JTextField tfNombreEvento;
    private JLabel lnomEvento;
    private JButton bCancelarEvento;
    private JMenuItem miGuardarEvento;

    public V1() {
        //todos los panel excepto el de la barra de herramientas son invisibles hasta que se pulse su botón:
        pHerramientas.setVisible(true);
        pGuardarEvento.setVisible(false);
        pCancelarEvento.setVisible(false);

        guardarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pGuardarEvento.setVisible(true);
                pCancelarEvento.setVisible(false);
            }
        });
        bOpcionCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCancelarEvento.setVisible(true);
                pGuardarEvento.setVisible(false);
            }
        });
        bGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bCancelarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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
