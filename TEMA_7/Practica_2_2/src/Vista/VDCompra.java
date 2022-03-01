package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VDCompra extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfPrecio;
    private JComboBox cbProveedores;
    private JTextField tfImporte;

    private Integer unidades;

    public VDCompra(Integer unidades) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setLocationRelativeTo(null);

        llenarCombo(Main.getDatosProveedores());

        this.unidades = unidades;

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        tfPrecio.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                calcularImporte();
            }
        });
    }

    private void onOK() {
        try {
            validarPrecio();
            if (cbProveedores.getSelectedIndex() == -1)
                throw new Exception("Hay que indicar el proveedor de la compra");
            Main.guardarCompra(unidades,tfPrecio.getText());
            dispose();
        }
        catch(Exception e)
        {
            mostrarError(e.getMessage());
        }


    }

    public void validarPrecio() throws Exception
    {
        String precio = tfPrecio.getText();
        if (precio.isEmpty())
            throw new Exception("El precio de compra es un dato obligatorio");

        Pattern patron = Pattern.compile("^[0-9]+([.][0-9]*)?$");
        Matcher m = patron.matcher(precio);
        if (!m.matches())
            throw new Exception("El precio de compra es un dato numÃ©rico");

        if(Float.parseFloat(precio) <= 0)
            throw new Exception("El precio tiene que ser mayor que cero");

    }

    public void calcularImporte()
    {
        float importe = unidades * Float.parseFloat(tfPrecio.getText());
        tfImporte.setText(String.valueOf(importe));
    }

    public void mostrarError(String mensaje)
    {
        String[] botones = {"Aceptar"};
        JOptionPane.showOptionDialog(null,mensaje, "ERROR",
                JOptionPane.DEFAULT_OPTION ,JOptionPane.ERROR_MESSAGE , null , botones , botones[0]);
    }
    private void onCancel() {
        // add your code here if necessary
        JOptionPane.showMessageDialog(null,Main.getDatos());
        dispose();
    }


    public void llenarCombo(String[] nombres)
    {
        cbProveedores.removeAllItems(); // Vaciar
        for(String n: nombres)
            cbProveedores.addItem(n);
        cbProveedores.setSelectedIndex(-1); //nada seleccionado.

    }
}
