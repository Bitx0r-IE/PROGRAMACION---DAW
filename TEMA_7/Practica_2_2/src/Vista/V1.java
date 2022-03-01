package Vista;

import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.company.Main;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class V1 extends javax.swing.JFrame{
    private JPanel pOperacion;
    private JPanel pProducto;
    private JPanel pTitulo;
    private JPanel pPrincipal;
    private JTextField tfNombreProducto;
    private JTextField tfUnidades;
    private JRadioButton rbCompra;
    private JRadioButton rbVenta;
    private ButtonGroup bgOperacion;

    // Validaciones
    private boolean productoCorrecto;


    public V1(){

        // actionPerformed
        tfNombreProducto.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                // Validar el nombre del producto
                productoCorrecto = validarProducto();
            }
        });

        tfUnidades.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                // Validar unidades
                if ( productoCorrecto)
                    validarUnidades();
            }
        });

        rbCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprar();
            }
        });

        rbVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Main.hayUnidades(Integer.parseInt(tfUnidades.getText())))
                    vender();
                else
                {
                    JOptionPane.showMessageDialog(null, "No hay tantas unidades disponibles");
                    tfUnidades.setEditable(true);
                    tfUnidades.requestFocus();
                }
                // try
            }
        });
    }

    public void limpiar()
    {
        // Dejar la ventana como al principio
        tfNombreProducto.setText("");
        tfNombreProducto.setEditable(true);
        tfUnidades.setText("");
        tfUnidades.setEditable(true);
        //rbCompra.setSelected(false);
        bgOperacion.clearSelection();
        tfNombreProducto.requestFocus();
    }



    public boolean validarProducto()
    {
        try {
            // if (!bCancelar.isFocusOwner()) {  // TodavÃ­a no estÃ¡ el cursor en el botÃ³n cancelar.
            String producto = tfNombreProducto.getText();
            if (producto.isEmpty())
                throw new Exception("El nombre del producto es un dato obligatorio");

            Pattern patron = Pattern.compile("^[A-Z][a-z]+([ ][a-z]+)*$");
            Matcher m = patron.matcher(producto);
            if (!m.matches())
                throw new Exception("Nombre de producto no vÃ¡lido");

            if (!Main.buscarProducto(producto))
                throw new Exception("El producto indicado no existe");

            // }
            tfNombreProducto.setEditable(false);

            //}
            return true;
        }
        catch(Exception e)
        {
            mostrarError(e.getMessage());
            tfNombreProducto.setSelectionStart(0);
            tfNombreProducto.setSelectionEnd(tfNombreProducto.getText().length());
            tfNombreProducto.requestFocus();
            return false;
        }

    }

    public boolean validarUnidades()
    {
        // TODO: INTENTAR CREAR UN UNICO VALIDAR
        try {
            String unidades = tfUnidades.getText();
            if (unidades.isEmpty())
                throw new Exception("Las unidades son un dato obligatorio");

            Pattern patron = Pattern.compile("^[0-9]+$");
            Matcher m = patron.matcher(unidades);
            if (!m.matches())
                throw new Exception("Las unidades han de ser un nÃºmero entero");

            if(Integer.parseInt(unidades) <= 0)
                throw new Exception("Las unidades tienen que ser mayores que cero");

            tfUnidades.setEditable(false);
            return true;
        }
        catch(Exception e)
        {
            mostrarError(e.getMessage());
            tfUnidades.setSelectionStart(0);
            tfUnidades.setSelectionEnd(tfUnidades.getText().length());
            tfUnidades.requestFocus();
            return false;
        }

    }

    public void mostrarError(String mensaje)
    {
        String[] botones = {"Aceptar"};
        JOptionPane.showOptionDialog(null,mensaje, "ERROR",
                JOptionPane.DEFAULT_OPTION ,JOptionPane.ERROR_MESSAGE , null , botones , botones[0]);
    }

    public void comprar()
    {
        Main.mostrarDialogoCompra(tfUnidades.getText());
        limpiar();
    }

    public void vender()
    {
        Main.mostrarDialogoVenta(tfUnidades.getText());
        limpiar();
    }





    public JPanel getpPrincipal()
    {
        return pPrincipal;
    }

}

