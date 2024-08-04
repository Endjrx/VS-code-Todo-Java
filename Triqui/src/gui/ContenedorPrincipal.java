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


    private void inicializarBotones () {

        botonUno = new JButton();
        botonDos = new JButton();
        botonTres = new JButton();
        botonCuatro = new JButton();
        botonCinco = new JButton();
        botonSeis = new JButton();
        botonSiete = new JButton();
        botonOcho = new JButton();
        botonNueve = new JButton();


    }

    private void initComponents () {

        contador = 1; //Inicializamos la variable contadora

        inicializarBotones();

        add (new Contenedor(botonUno, "Primera Celda"));
        add (new Contenedor(botonDos, "Segunda Celda"));
        add (new Contenedor(botonTres, "Tercera Celda"));
        add (new Contenedor(botonCuatro, "Cuarta Celda"));
        add (new Contenedor(botonCinco, "Quinta Celda"));
        add (new Contenedor(botonSeis, "Sexta Celda"));
        add (new Contenedor(botonSiete, "Septima Celda"));
        add (new Contenedor(botonOcho, "Octava Celda"));
        add (new Contenedor(botonNueve, "Novena Celda"));

    }



    private class Contenedor extends JPanel {

        public Contenedor (JButton boton, String command) {
    
            setBorder (BorderFactory.createEtchedBorder()); //Le colocamos un border alos paneles que tendrán los botones
            setLayout(new BorderLayout());

            boton.setBorder(null);
            boton.setContentAreaFilled(false);
            boton.setFocusPainted(false);
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            boton.setActionCommand(command);
            boton.setFont (new Font ("Roboto Black", Font.BOLD, 50));
            boton.addActionListener(new ActionListener() {
    
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    JButton btn = (JButton) e.getSource(); //Obtenemos el boton generó el evento
                    if (contador < 10) {

                        if (btn.getText().isBlank()) {
                            
                            String accion = e.getActionCommand(); //Obtenemos el comando del boton que genero la accion
                            btn.setText((contador % 2 == 0) ? "O" : "X"); //Determinamos si colocar X o O;
                            if (accion.equals("Primera Celda") || accion.equals("Segunda Celda") || accion.equals("Tercera Celda") || accion.equals("Quinta Celda")) {

                                if (btn.getText().equals("X")) {
                                    if ((botonDos.getText().equals("X") && botonTres.getText().equals("X") && botonUno.getText().equals("X")) || (botonUno.getText().equals("X") && botonCinco.getText().equals("X") && botonNueve.getText().equals("X"))){
                                        
                                        JOptionPane.showMessageDialog (ContenedorPrincipal.this, "LA X GANA");

                                    }
                                } else {

                                    if (botonDos.getText().equals("O") && botonTres.getText().equals("O") && botonUno.getText().equals("O")){
                                        
                                        JOptionPane.showMessageDialog (ContenedorPrincipal.this, "LA O GANA");

                                    }

                                }

                            }


                            contador++;

                        }

                    }
    
                }
                
    
    
            });
    
            add(boton);
    
        }
    
    }



    private int contador;
    private JButton botonUno, botonDos, botonTres, botonCuatro, botonCinco, botonSeis, botonSiete, botonOcho, botonNueve;
}

