package Vista;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VGuardaEvento extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfNombre;
    private JTextField tfLoc;
    private JTextField tfFecha;
    private JTextField tfhoraInit;
    private JTextField tfhoraFin;
    private JPasswordField tfnumPerso;
    private JLabel lNombre;
    private JLabel lLoc;
    private JLabel lFecha;
    private JLabel lHoraInit;
    private JLabel lhoraFin;
    private JLabel lnumAsis;

    public VGuardaEvento() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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
    }

    private void onOK() {
        // add your code here
        try{
            validarNombre();
            validarLugar();
            validarFecha();
            validarHoras();
            validarAforo();

            Main.getDatosEvento(tfNombre.getText(), tfLoc.getText(), fecha, horaI, horaF, aforo);
            dispose();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    /*PRINCIPIO VALIDACIONES:*/

    //variables globales para no repetir la conversión:
    private LocalDate fecha;
    private LocalTime horaI;
    private LocalTime horaF;
    private int aforo;

    public void validarNombre() throws Exception{
        if (tfNombre.getText().isEmpty()){
            throw new Exception("El nombre es un campo obligatorio");
        }
        //Comprobar que son letras (si se quiere)
    }

    public void validarLugar() throws Exception{
        if (tfLoc.getText().isEmpty()){
            throw new Exception("El lugar es un campo obligatorio");
        }
        //Comprobar que son letras (si se quiere)
    }

    public void validarFecha() throws Exception{
        if (tfFecha.getText().isEmpty()){
            throw new Exception("La fecha del evento es un campo obligatorio");
        }
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fecha = LocalDate.parse(tfFecha.getText(), formato);
        if (fecha.compareTo(LocalDate.now()) <= 0){
            throw new Exception("La fecha no puede ser anterior al día de hoy");
        }
    }

    public void validarHoras() throws Exception{
        if (tfhoraInit.getText().isEmpty()){
            throw new Exception("La hora de inicio es un campo obligatorio");
        }
        if (tfhoraFin.getText().isEmpty()){
            throw new Exception("La hora de fin es un campo obligatorio");
        }
        //Hora Inicio debe ser mayor que la Hora Fin:
        horaI = LocalTime.parse(tfhoraInit.getText());
        horaF = LocalTime.parse(tfhoraFin.getText());

        if (horaF.compareTo(horaI) <= 0){
            throw new Exception ("Horas introducidas no válidas");
        }
    }

    public void validarAforo() throws Exception{
        if (tfnumPerso.getText().isEmpty()){
            throw new Exception("El aforo/num personas es un campo obligatorio");
        }
        aforo = Integer.parseInt(tfnumPerso.getText());
        if (aforo <= 0){
            throw new NumberFormatException();
        }
    }

    /*FIN VALIDACIONES*/

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        VGuardaEvento dialog = new VGuardaEvento();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
