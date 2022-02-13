package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class V1 {
    private JPanel pTitulo;
    private JLabel lTitulo;
    private JTextField tfNombreProd;
    private JTextField tfUnidades;
    private JLabel lNombre;
    private JLabel lUnidades;
    private JPanel PanelPrincipal;
    private JPanel pTipoOp;
    private JRadioButton rbCompra;
    private JRadioButton rbVenta;
    private JPanel pDatosCompra;
    private JLabel lPrecio;
    private JTextField tfPrecio;
    private JComboBox cbProveedor;
    private JPanel pDatosVenta;
    private JLabel lPrecioV;
    private JFormattedTextField ftPrecio;
    private JTextField tfCliente;
    private JPanel pDescuento;
    private JTextField tfImporteVenta;
    private JLabel lImporteVenta;
    private JCheckBox cbPorVolumen;
    private JCheckBox cbProntoPago;
    private JButton bAcepar;
    private JButton bCancelar;
    private JTextField tfImporte;

    //main:
    public static void main(String[] args) {
        JFrame frame = new JFrame("V1");
        frame.setContentPane(new V1().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //set y get (panel)


    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        PanelPrincipal = panelPrincipal;
    }

    public JPanel getpDatosCompra() {
        return pDatosCompra;
    }

    public void setpDatosCompra(JPanel pDatosCompra) {
        this.pDatosCompra = pDatosCompra;
    }

    public JPanel getpDatosVenta() {
        return pDatosVenta;
    }

    public void setpDatosVenta(JPanel pDatosVenta) {
        this.pDatosVenta = pDatosVenta;
    }

    public JTextField getTfNombreProd() {
        return tfNombreProd;
    }

    public void setTfNombreProd(JTextField tfNombreProd) {
        this.tfNombreProd = tfNombreProd;
    }

    public JTextField getTfUnidades() {
        return tfUnidades;
    }

    public void setTfUnidades(JTextField tfUnidades) {
        this.tfUnidades = tfUnidades;
    }

    public JComboBox getCbProveedor() {
        return cbProveedor;
    }

    public void setCbProveedor(JComboBox cbProveedor) {
        this.cbProveedor = cbProveedor;
    }

    public JTextField getTfCliente() {
        return tfCliente;
    }

    public void setTfCliente(JTextField tfCliente) {
        this.tfCliente = tfCliente;
    }
    //Acciones:

    public V1() {
        bAcepar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetVentana();
            }
        });
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        tfNombreProd.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                Main.validarProd(getTfNombreProd());
            }
        });
        tfUnidades.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                Main.validarUnidades(getTfUnidades());
            }
        });
        rbCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compraVisible();
            }
        });
        rbVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventaVisible();
            }
        });
        cbPorVolumen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.porVolumen();
            }
        });
        cbProntoPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.prontoPago();
            }
        });
    }
    public void compraVisible(){
        pDatosVenta.setVisible(false);
        pDatosCompra.setVisible(true);
    }
    public void ventaVisible(){
        pDatosCompra.setVisible(false);
        pDatosVenta.setVisible(true);
    }
    public void resetVentana(){
        pDatosVenta.setVisible(true);
        pDatosVenta.setVisible(true);
        setPanelPrincipal(null);
    }
}


