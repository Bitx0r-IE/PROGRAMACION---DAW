package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VDVenta extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfPrecio;
    private JTextField tfCliente;
    private JCheckBox cbVolumen;
    private JCheckBox cbppp;
    private JTextField tfImporte;

    private float importe;
    private int unidades;

    // En el Main.
    private final  int DTOPP = 3;
    private final  int DTOV = 2;

    public VDVenta(int unidades,Float precio) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        setLocationRelativeTo(null);
        this.unidades = unidades;
        tfPrecio.setText(String.valueOf(precio));
        importe = unidades * precio;
        tfImporte.setText(String.valueOf(importe));
        tfCliente.requestFocus();

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
        cbVolumen.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                calcularImporteVenta();
            }
        });
    }

    public void calcularImporteVenta()
    {
        // En el Main?
        int dto=0;
        if (cbppp.isSelected())
            dto = DTOPP;

        if (cbVolumen.isSelected())
            dto += DTOV;

        tfImporte.setText(String.valueOf(importe - importe*dto/100));
    }
    private void onOK() {
        try
        {
            validarCliente();
            Main.guardarVenta(unidades);
            dispose();
        }
        catch(Exception e)
        {
            mostrarError(e.getMessage());
        }

    }

    public void validarCliente() throws Exception {
        String cliente = tfCliente.getText();
        if (cliente.isEmpty())
            throw new Exception("El nombre del cliente es un dato obligatorio");

        Pattern patron = Pattern.compile("^[A-Z][a-z]+([ ][a-z]+)*$");
        Matcher m = patron.matcher(cliente);
        if (!m.matches())
            throw new Exception("Nombre de cliente no vÃ¡lido");

        Main.buscarCliente(cliente);

        tfCliente.setEditable(false);
    }

    public void mostrarError(String mensaje)
    {
        String[] botones = {"Aceptar"};
        JOptionPane.showOptionDialog(null,mensaje, "ERROR",
                JOptionPane.DEFAULT_OPTION ,JOptionPane.ERROR_MESSAGE , null , botones , botones[0]);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
