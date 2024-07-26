package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import datos_user.*;
import java.util.ArrayList;

public class ContenedorPrincipal extends JPanel {

    public ContenedorPrincipal (ArrayList <Plantilla> lista) {

        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        //----------------------CREAMOS JPANELES PARA CADA BOTON----------------------------------------
        JPanel panelRegresar = new JPanel();
        panelRegresar.setBackground(Color.WHITE);
        panelRegresar.setLayout(new FlowLayout(FlowLayout.LEFT, 5,0));

        JPanel panelRegistrar = new JPanel();
        panelRegistrar.setBackground(Color.WHITE);
        panelRegistrar.setLayout(new FlowLayout(FlowLayout.RIGHT, 5,0));


        //-----------------------CREAMOS LOS BOTONES PARA CADA LIMINA CON SUS CONFIGURACIONBES------------------------------------
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setBorder(null);
        btnRegistrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                removeAll();
                add(new ContenedorRegistros(ContenedorPrincipal.this, lista, panelRegistrar), BorderLayout.CENTER);
                add(panelRegresar, BorderLayout.NORTH);
                repaint();
                revalidate();

            }
            
        });
        panelRegistrar.add(btnRegistrar);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setFocusPainted(false);
        btnRegresar.setBorder(null);
        btnRegresar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                removeAll();
                add(new ContenedorLogin(ContenedorPrincipal.this, lista), BorderLayout.CENTER);
                repaint();
                add (panelRegistrar, BorderLayout.NORTH);
                revalidate ();

            }
            
        });
        panelRegresar.add(btnRegresar);

        add(new ContenedorLogin(this, lista), BorderLayout.CENTER);
        add(panelRegistrar, BorderLayout.NORTH);

    }

}
