package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class VModificarEvento extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfLoc;
    private JTextField tfFecha;
    private JTextField tfHoraI;
    private JTextField tfHoraF;
    private JTextField tfAforo;
    private JLabel lAforo;
    private JLabel lhFin;
    private JLabel lhInicio;
    private JLabel lFecha;
    private JLabel lLoc;
    private JLabel lNombre;
    private JComboBox cbNombre;

    public VModificarEvento() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        try{
            ArrayList<String> nombres = Main.datosLlenarComboBox();
            for (String n:nombres)
                cbNombre.addItem(n);
            cbNombre.setSelectedIndex(-1);
        } catch (Exception e) {
            System.out.println("Problemas con la ComboBox");
        }

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

        cbNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getEventoSelec(cbNombre.getSelectedIndex());
                //Mostrar eventos:
                tfLoc.setText(Main.getLoc());
                tfFecha.setText(Main.getFecha());
                tfHoraI.setText(Main.getHoraInit());
                tfHoraF.setText(Main.getHoraFin());
                tfAforo.setText(Main.getAforo());
            }
        });
    }

    private void onOK() {
        //Validat datos y enviar al controlador:
        try {
            validarLoc();
            validarFecha();
            validarHoras();
            validarAforo();

            Main.getDatosActualizados(tfLoc.getText(), fecha, horaI, horaF, aforo);
            JOptionPane.showMessageDialog(null, "Acontecimiento modificado");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /* VALIDACIONES */
    //Variables globales para la conversión:
    private LocalDate fecha;
    private LocalTime horaI;
    private LocalTime horaF;
    private int aforo;

    public void validarLoc() throws Exception{
        if (tfLoc.getText().isEmpty()){
            throw new Exception("La localización es un dato obligatorio");
        }
    }
    public void validarFecha() throws Exception{
        if (tfFecha.getText().isEmpty()){
            throw new Exception("La fecha del evento es un dato obligatorio");
        }
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fecha = LocalDate.parse(tfFecha.getText(), formato);
        if (fecha.compareTo(LocalDate.now()) <= 0){
            throw new Exception("La fecha no puede ser anterior al día de hoy");
        }
    }
    public void validarHoras() throws Exception{
        if (tfHoraI.getText().isEmpty()){
            throw new Exception("La hora de inicio es un dato obligatorio");
        }
        if (tfHoraF.getText().isEmpty()){
            throw new Exception("La hora de fin es un dato obligatorio");
        }
        // HoraF debe ser mayor que HoraI:
        horaF = LocalTime.parse(tfHoraF.getText());
        horaI = LocalTime.parse(tfHoraI.getText());

        if (horaF.compareTo(horaI) <= 0){
            throw new Exception("Horas no validas");
        }
    }
    public void validarAforo() throws Exception{
        if (tfAforo.getText().isEmpty()){
            throw new Exception("El aforo del evento es un dato obligatorio");
        }
        aforo = Integer.parseInt(tfAforo.getText());
        if (aforo <= 0){
            throw new Exception("Aforo no valido, no puede ser 0 o un numero negativo");
        }
    }
    /* FIN VALIDACIONES */

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        VModificarEvento dialog = new VModificarEvento();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
