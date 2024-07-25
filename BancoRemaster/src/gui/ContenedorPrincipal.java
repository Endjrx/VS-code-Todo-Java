package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContenedorPrincipal extends JPanel {

    public ContenedorPrincipal () {

        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        //----------------------CREAMOS JPANELES PARA CADA BOTON----------------------------------------
        JPanel panelBack = new JPanel();
        panelBack.setBackground(Color.WHITE);
        panelBack.setLayout(new FlowLayout(FlowLayout.LEFT, 5,0));

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(Color.WHITE);
        panelBoton.setLayout(new FlowLayout(FlowLayout.RIGHT, 5,0));


        //-----------------------CREAMOS LOS BOTONES PARA CADA LIMINA CON SUS CONFIGURACIONBES------------------------------------
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setBorder(null);
        btnRegistrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                removeAll();
                add(new ContenedorRegistros(), BorderLayout.CENTER);
                repaint();
                add(panelBack, BorderLayout.NORTH);
                revalidate();

            }
            
        });
        panelBoton.add(btnRegistrar);


    //-------------------------------CREAMOS UN JPANEL Y UN BOTON PARA GUARDAR EL BOTON EN EL JPANEL Y AGREGAR ESE PANEL EN LA ZONA NORTE-------------------------

        JButton btnBack = new JButton("Regresar");
        btnBack.setContentAreaFilled(false);
        btnBack.setFocusPainted(false);
        btnBack.setBorder(null);
        btnBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                removeAll();
                add(new ContenedorLogin(), BorderLayout.CENTER);
                repaint();
                add (panelBoton, BorderLayout.NORTH);
                revalidate ();

            }
            
        });
        panelBack.add(btnBack);

        add(new ContenedorLogin(), BorderLayout.CENTER);
        add(panelBoton, BorderLayout.NORTH);
    }

}
