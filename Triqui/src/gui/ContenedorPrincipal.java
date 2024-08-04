package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContenedorPrincipal extends JPanel {

    public ContenedorPrincipal () {

        setLayout (new BorderLayout()); // Establecemos el Layout del ContenedorPrincipal
        initComponents();

    }


    private void mostrarMensajeGanador (String mensaje) {

        JOptionPane.showMessageDialog (ContenedorPrincipal.this, mensaje);
        vaciarTextoBotones(); // Llamamos al metodo para resetear la tabla
        contador = 0; // Volvemos al valor inicial al contador
        comprobar = true; //Para indicar que si hubo un ganador

    }

    private void vaciarTextoBotones (){

        botonUno.setText("");
        botonDos.setText("");
        botonTres.setText("");
        botonCuatro.setText("");
        botonCinco.setText("");
        botonSeis.setText("");
        botonSiete.setText("");
        botonOcho.setText("");
        botonNueve.setText("");

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

        contador = 0; //Inicializamos la variable contadora
        comprobar = false;

        inicializarBotones();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 1, 1));

        /*Agrego todos los jpanels con sus botones al panel que genera la tabla. (El panel que tiene el gridlayout) */
        panel.add (new Contenedor(botonUno, "Primera Celda"));
        panel.add (new Contenedor(botonDos, "Segunda Celda"));
        panel.add (new Contenedor(botonTres, "Tercera Celda"));
        panel.add (new Contenedor(botonCuatro, "Cuarta Celda"));
        panel.add (new Contenedor(botonCinco, "Quinta Celda"));
        panel.add (new Contenedor(botonSeis, "Sexta Celda"));
        panel.add (new Contenedor(botonSiete, "Septima Celda"));
        panel.add (new Contenedor(botonOcho, "Octava Celda"));
        panel.add (new Contenedor(botonNueve, "Novena Celda"));


        //JLabel para mostrar quien tiene el turno
        siguiente = new JLabel();
        siguiente.setFont(new Font ("Roboto", Font.BOLD, 16));
        siguiente.setPreferredSize(new Dimension(getWidth(), 40));
        add(siguiente, BorderLayout.SOUTH);
        add (panel, BorderLayout.CENTER);

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
                    if (contador <= 9) {

                        if (btn.getText().isBlank()) {
                            
                            String accion = e.getActionCommand(); //Obtenemos el comando del boton que genero la accion
                            btn.setText((contador % 2 == 0) ? "X" : "O"); //Determinamos si colocar X o O;
                            contador++; //Aumentamos el valor del contador para determinar cual será el siguiente signo

                            switch (accion) {
                                case "Primera Celda": 
                                    
                                    if (btn.getText().equals("X")) {

                                        if (botonDos.getText().equals("X") && botonTres.getText().equals("X")){
                                            mostrarMensajeGanador("La X gana");

                                        } else if (botonCinco.getText().equals("X") && botonNueve.getText().equals("X")) {
                                            mostrarMensajeGanador("La X gana");

                                        } else if (botonCuatro.getText().equals("X") && botonSiete.getText().equals("X")) {
                                            mostrarMensajeGanador("La X gana");
                                        }
                                        
                                    } else {

                                        if (botonDos.getText().equals("O") && botonTres.getText().equals("O")){
                                            mostrarMensajeGanador("La O gana");

                                        } else if (botonCinco.getText().equals("O") && botonNueve.getText().equals("O")) {
                                            mostrarMensajeGanador("La O gana");

                                        } else if (botonCuatro.getText().equals("O") && botonSiete.getText().equals("O")) {
                                            mostrarMensajeGanador("La O gana");
                                        }

                                    }
                                    break;

                                case "Segunda Celda": 
                                    
                                    if (btn.getText().equals("X")) {

                                        if (botonUno.getText().equals("X") && botonTres.getText().equals("X")){
                                            mostrarMensajeGanador("La X gana");

                                        } else if (botonCinco.getText().equals("X") && botonOcho.getText().equals("X")) {
                                            mostrarMensajeGanador("La X gana");
                                        }    

                                    } else {

                                        if (botonUno.getText().equals("O") && botonTres.getText().equals("O")){
                                            mostrarMensajeGanador("La O gana");

                                        } else if (botonCinco.getText().equals("O") && botonOcho.getText().equals("O")) {
                                            mostrarMensajeGanador("La O gana");
                                        }

                                    }
                                    break;

                                case "Tercera Celda":

                                    if (btn.getText().equals("X")) {

                                        if (botonDos.getText().equals("X") && botonUno.getText().equals("X")){
                                            mostrarMensajeGanador("La X gana");

                                        } else if (botonCinco.getText().equals("X") && botonSiete.getText().equals("X")) {
                                            mostrarMensajeGanador("La X gana");

                                        } else if (botonSeis.getText().equals("X") && botonNueve.getText().equals("X")) {
                                            mostrarMensajeGanador("La X gana");
                                        }
                                        
                                    } else {

                                        if (botonDos.getText().equals("O") && botonUno.getText().equals("O")){
                                            mostrarMensajeGanador("La O gana");

                                        } else if (botonCinco.getText().equals("O") && botonSiete.getText().equals("O")) {
                                            mostrarMensajeGanador("La O gana");

                                        } else if (botonSeis.getText().equals("O") && botonNueve.getText().equals("O")) {
                                            mostrarMensajeGanador("La O gana");
                                        }

                                    }
                                    break;
                                
                                case "Cuarta Celda":
                                    if (btn.getText().equals("X")) {

                                        if (botonUno.getText().equals("X") && botonSiete.getText().equals("X")){
                                            mostrarMensajeGanador("La X gana");

                                        } else if (botonCinco.getText().equals("X") && botonSeis.getText().equals("X")) {
                                            mostrarMensajeGanador("La X gana");
                                        }    

                                    } else {

                                        if (botonUno.getText().equals("O") && botonSiete.getText().equals("O")){
                                            mostrarMensajeGanador("La O gana");

                                        } else if (botonCinco.getText().equals("O") && botonSeis.getText().equals("O")) {
                                            mostrarMensajeGanador("La O gana");
                                        }

                                    }
                                    break;

                                case "Quinta Celda":
                                    
                                    if (btn.getText().equals("X")) {

                                        if (botonDos.getText().equals("X") && botonOcho.getText().equals("X")) {
                                            mostrarMensajeGanador("La X gana");
                                        } else if (botonCuatro.getText().equals("X") && botonSeis.getText().equals("X")){
                                            mostrarMensajeGanador("La X gana");
                                        }

                                    } else {

                                        if (botonDos.getText().equals("O") && botonOcho.getText().equals("O")) {
                                            mostrarMensajeGanador("La O gana");
                                        } else if (botonCuatro.getText().equals("O") && botonSeis.getText().equals("O")){
                                            mostrarMensajeGanador("La O gana");
                                        }

                                    }

                                    break;
                                
                                case "Sexta Celda":
                                    
                                    if (btn.getText().equals("X")) {

                                        if (botonTres.getText().equals("X") && botonNueve.getText().equals("X")) {
                                            mostrarMensajeGanador("La X gana");
                                        } else if (botonCuatro.getText().equals("X") && botonCinco.getText().equals("X")){
                                            mostrarMensajeGanador("La X gana");
                                        }

                                    } else {

                                        if (botonTres.getText().equals("O") && botonNueve.getText().equals("O")) {
                                            mostrarMensajeGanador("La O gana");
                                        } else if (botonCuatro.getText().equals("O") && botonCinco.getText().equals("O")){
                                            mostrarMensajeGanador("La O gana");
                                        }


                                    }
                                    break;

                                case "Septima Celda":
                                    
                                    if (btn.getText().equals("X")) {

                                        if (botonOcho.getText().equals("X") && botonNueve.getText().equals("X")){
                                            mostrarMensajeGanador("La X gana");

                                        } else if (botonCinco.getText().equals("X") && botonTres.getText().equals("X")) {
                                            mostrarMensajeGanador("La X gana");

                                        } else if (botonCuatro.getText().equals("X") && botonUno.getText().equals("X")) {
                                            mostrarMensajeGanador("La X gana");
                                        }
                                        
                                    } else {

                                        if (botonOcho.getText().equals("O") && botonNueve.getText().equals("O")){
                                            mostrarMensajeGanador("La O gana");

                                        } else if (botonCinco.getText().equals("O") && botonTres.getText().equals("O")) {
                                            mostrarMensajeGanador("La O gana");

                                        } else if (botonCuatro.getText().equals("O") && botonUno.getText().equals("O")) {
                                            mostrarMensajeGanador("La O gana");
                                        }

                                    }
                                    break;

                                case "Octava Celda": 

                                    if (btn.getText().equals("X")) {

                                        if (botonCinco.getText().equals("X") && botonDos.getText().equals("X")) {
                                            mostrarMensajeGanador("La X gana");
                                        } else if (botonSiete.getText().equals("X") && botonNueve.getText().equals("X")){
                                            mostrarMensajeGanador("La X gana");
                                        }

                                    } else {

                                        if (botonCinco.getText().equals("O") && botonDos.getText().equals("O")) {
                                            mostrarMensajeGanador("La O gana");
                                        } else if (botonSiete.getText().equals("X") && botonNueve.getText().equals("O")){
                                            mostrarMensajeGanador("La O gana");
                                        }
                                    }

                                    break;    

                                
                                case "Novena Celda":   

                                    if (btn.getText().equals("X")) {

                                        if (botonOcho.getText().equals("X") && botonSiete.getText().equals("X")){
                                            mostrarMensajeGanador("La X gana");

                                        } else if (botonSeis.getText().equals("X") && botonTres.getText().equals("X")) {
                                            mostrarMensajeGanador("La X gana");

                                        } else if (botonCinco.getText().equals("X") && botonUno.getText().equals("X")) {
                                            mostrarMensajeGanador("La X gana");
                                        }
                                        
                                    } else {

                                        if (botonOcho.getText().equals("O") && botonSiete.getText().equals("O")){
                                            mostrarMensajeGanador("La O gana");

                                        } else if (botonSeis.getText().equals("O") && botonTres.getText().equals("O")) {
                                            mostrarMensajeGanador("La O gana");

                                        } else if (botonCinco.getText().equals("O") && botonUno.getText().equals("O")) {
                                            mostrarMensajeGanador("La O gana");
                                        }

                                    }
                                    break;
                                    

                            }
                            

                        }


                        /*En caso esta condicion se cumpla, quiere decir que ya se agaotaron los espacios de la tabla de triqui */
                        if (contador > 8) {

                            if (!comprobar){ 

                                JOptionPane.showMessageDialog(ContenedorPrincipal.this, "Nadie Gano!");
                                vaciarTextoBotones();
                                contador = 0;
                            }

                            if (comprobar) comprobar = false; //Si comprobar es igual a true, quiere decir que alguien gano y hay que restablecer dicho valor
                            

                        }

                    }

                    siguiente.setText( (contador % 2 == 0) ? "Siguiente turno al jugador del Equis" : "Siguiente turno al jugador de la Circulo" );
                    
    
                }
                
    
    
            });
    
            add(boton);
        }
    
    }



    private int contador;
    private JLabel siguiente;
    private JButton botonUno, botonDos, botonTres, botonCuatro, botonCinco, botonSeis, botonSiete, botonOcho, botonNueve;
    private boolean comprobar; //Servirá para comprobar si alguien gano para poder vaciar las celdas en caso nadie gane
}

