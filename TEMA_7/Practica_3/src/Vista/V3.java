package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V3 {
    private JPanel pPrincipalV3;
    private JMenu mResumen;
    private JMenuBar mbBAR;
    private JMenu mTarjetas;
    private JMenu mInversiones;
    private JMenu mMercados;
    private JMenu mPrestamos;
    private JMenu mSeguros;
    private JMenu mServicios;
    private JMenuItem miConsulta;
    private JMenu mCuentas;
    private JMenuItem miMovimientos;
    private JPanel pMenu;
    private JButton bConsulta;
    private JButton bMovimientos;
    private JPanel pTabla;
    private JToolBar tbTablaHerramientas;
    private JPanel pCuentas;
    private JPanel pMovimientos;

    public V3() {
        bConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bMovimientos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("V3");
        frame.setContentPane(new V3().pPrincipalV3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //get set:

    public JPanel getpPrincipalV3() {
        return pPrincipalV3;
    }

    public void setpPrincipalV3(JPanel pPrincipalV3) {
        this.pPrincipalV3 = pPrincipalV3;
    }


}
