package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContenedorPrincipal extends JPanel {

    public ContenedorPrincipal () {

        setLayout (new GridLayout (3, 3, 1, 1)); // Establecemos el Layout del ContenedorPrincipal
        initComponents();

    }

    private void initComponents () {

        contador = 1; //Inicializamos la variable contadora

        add (new Contenedor("Primera Celda"));
        add (new Contenedor("Segunda Celda"));
        add (new Contenedor("Tercera Celda"));
        add (new Contenedor("Cuarta Celda"));
        add (new Contenedor("Quinta Celda"));
        add (new Contenedor("Sexta Celda"));
        add (new Contenedor("Septima Celda"));
        add (new Contenedor("Octava Celda"));
        add (new Contenedor("Novena Celda"));

    }



    private class Contenedor extends JPanel {

        public Contenedor (String command) {
    
            setBorder (BorderFactory.createEtchedBorder()); //Le colocamos un border
            setLayout(new BorderLayout());
    
            JButton boton = new JButton("");
            boton.setBorder(null);
            boton.setContentAreaFilled(false);
            boton.setFocusPainted(false);
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            boton.setActionCommand(command);
            boton.setFont (new Font ("Roboto Black", Font.BOLD, 50));
            boton.addActionListener(new ActionListener() {
    
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    JButton btn = (JButton) e.getSource();
                    if (contador < 10) {

                        if (btn.getText().isBlank()) {
                            
                            btn.setText((contador % 2 == 0) ? "O" : "X");
                            contador++;

                        }

                    }
    
                }
                
    
    
            });
    
            add(boton);
    
        }
    
    }



    private int contador;
}

