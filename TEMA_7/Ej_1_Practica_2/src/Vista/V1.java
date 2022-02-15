package Vista;

import Excepciones.DatoNoValido;
import Modelo.Producto;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    // Validaciones
    private boolean prodCorrecto;
    private boolean unidadesCorrectas;
    private boolean precioCompraCorrecto;
    private boolean nombreClienteCorrecto;

    private final  int DTOPP = 3;
    private final  int DTOV = 2;
    private Float importeVenta;


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
                //Validar nombre del producto:
                prodCorrecto = validarProd();
            }
        });
        tfUnidades.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (prodCorrecto){
                    unidadesCorrectas = validarUnidades();
                }
            }
        });
        rbCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compra();
            }
        });
        rbVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                venta();
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
    public boolean validarProd(){
        try{
            String producto = tfNombreProd.getText();
            if (producto.isEmpty()){
                throw new DatoNoValido("Nombre del producto es un campo obligatorio");
            }
            //Posibilidade de introducir un patrón
            if (!Main.buscarProd(producto)){
                throw new DatoNoValido("El producto que buscas no existe");
            }
            tfNombreProd.setEditable(false);
        }
        catch (DatoNoValido e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            tfNombreProd.setSelectionStart(0);
            tfNombreProd.setSelectionEnd(tfNombreProd.getText().length());
            tfNombreProd.requestFocus();
            return false;
        }
        return true;
    }
    public boolean validarUnidades(){
        try{
            String precio = tfUnidades.getText();
            if (precio.isEmpty()){
                throw new DatoNoValido("Campo obligatorio unidades sin rellenar");
            }
            Pattern patron = Pattern.compile("[0-9]+([.][0-9]*)?$");
            Matcher m = patron.matcher(precio);
            if (!m.matches()){
                throw new DatoNoValido("El precio debe ser un dato NUMÉRICO");
            }
            if (Float.parseFloat(precio) <= 0){
                throw new DatoNoValido("El precio debe ser mayor que 0");
            }
        }catch (DatoNoValido e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            tfUnidades.setSelectionStart(0);
            tfUnidades.setSelectionEnd(tfUnidades.getText().length());
            tfUnidades.requestFocus();
            return false;
        }
        return true;
    }
    public void compra(){
        pDatosVenta.setVisible(false);
        pDatosCompra.setVisible(true);
        llenarComboBox(Main.getDatosProveedores());
    }
    public void venta(){
        pDatosCompra.setVisible(false);
        pDatosVenta.setVisible(true);
    }
    public void resetVentana(){
        pDatosVenta.setVisible(true);
        pDatosVenta.setVisible(true);
        setPanelPrincipal(null);
    }
}


