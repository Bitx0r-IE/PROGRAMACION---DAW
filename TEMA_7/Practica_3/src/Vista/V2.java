package Vista;

import Exceptions.DatoNoValido;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V2 {
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
    private JButton b0;
    private JButton b4;
    private JButton b7;
    private JButton b5;
    private JButton b8;
    private JButton b6;
    private JButton bEntrar;

    public V2() {
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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
        bEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                }
                catch (DatoNoValido e){
                    JOptionPane.showMessageDialog(e.getMessage());
                }
            }
        });
    }
}
