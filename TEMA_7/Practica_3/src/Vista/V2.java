package Vista;

import Exceptions.DatoNoValido;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class V2 extends JDialog{
    private JPanel pPrincipalV2;
    private JPanel pDatos;
    private JPanel pTeclado;
    private JTextField tfNIF;
    private JLabel lNIF;
    private JTextField tfClave;
    private JLabel lClave;
    private JButton b3;
    private JButton b2;
    private JButton b9;
    private JButton b1;
    private JButton b10;
    private JButton b4;
    private JButton b7;
    private JButton b5;
    private JButton b8;
    private JButton b6;
    private JButton bEntrar;

    public V2() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //validarDNI        -->(opcional si se quiere)
                    if (!Main.buscarCliente(tfNIF.getText(), tfClave.getText().toString())){
                        throw new DatoNoValido("Identificación del cliente incorrecta");
                        Main.mostrarVentanaV3();
                        dispose();
                    }
                }
                catch (DatoNoValido a){
                    JOptionPane.showMessageDialog(null, a.getMessage());
                }
            }
        });
    }
    //Generar numeros para el teclado:
    public void generarNum(){
        //Array o Arraylist que contenga los números:
        ArrayList<Integer> numAleatorios = new ArrayList<>();
        int pos = 0;
        do{
            int numAleatorio = (int) (Math.random()*10);
            //Caso de repetición del num:
            if (!numAleatorios.contains(numAleatorio)){
                numAleatorios.add(numAleatorio);
                pos++;
            }
        }
        while (pos != 10);

        JButton[] aBotones = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b10 };
        for (int x = 0; x < numAleatorios.size(); x++){
            //Dar valor a los botones con un numero random del ArrayList
            aBotones[x].setText(numAleatorios.get(x).toString());
        }
    }
}
