package Vista;

import com.company.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

public class V1 {
    private JPanel pPrincipal;
    private JLabel lAcceso;
    private JButton bAcceso;
    private JPanel pAcceso;
    private JPanel pImagen;
    private JButton bImagen;

    public static void main(String[] args) {
        JFrame frame = new JFrame("V1");
        frame.setContentPane(new V1().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public V1() {
        bAcceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarVentantaV2();
            }
        });
    }
    //getter de pPrincipal:

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
