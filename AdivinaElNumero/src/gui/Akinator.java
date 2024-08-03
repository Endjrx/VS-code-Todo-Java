package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Akinator extends JFrame {
    
    public Akinator () {

        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Adivina el numero");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        add(new ContenedorPrincipal());
        this.setVisible(true);

    }

}



class ContenedorPrincipal extends JPanel {

    public ContenedorPrincipal () {

        setLayout(new BorderLayout());
        initComponents();

    }

    private void initComponents () {

        JPanel panel = new JPanel(){

            @Override
            public void paintComponent (Graphics g){

                try {

                    Image imagen = ImageIO.read(new File("src//img//BgInicio.png"));
                    g.drawImage(imagen, 0, 0, this);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        };
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        String reglas =  "<html>" + "Las reglas del juego son las siguientes: " + "<html><p><p>- El numero aleatorio estará comprendido entre 1 y 100. <p>" + 
        "<html>- Cada vez que falles el numero cambiará. <p>" + "<html>- Puedes usar una pista cuantas veces crear que es necesario." + "<html>";
        
        confiComponentes(panel, new JLabel("RANDOM NUMBER"), 180, 50, 400, 40, 40, JLabel.CENTER);
        confiComponentes(panel, new JLabel (reglas), 50, 80, 500, 200, 12, JLabel.LEFT);
        confiComponentes(panel, new JButton ("Easy Mode"), 80, 300, 100, 25, FRAMEBITS, ABORT);
        confiComponentes(panel, new JButton ("Medium Mode"), 200, 300, 120, 25, FRAMEBITS, ABORT);
        confiComponentes(panel, new JButton ("Hard Mode"), 340, 300, 100, 25, FRAMEBITS, ABORT);
        add (panel);
    }

    private void confiComponentes (JPanel panel, JComponent comp, int x, int y, int width, int height, int tam, int align){

        comp.setBounds(x, y, width, height);

        if (comp instanceof JLabel){

            JLabel label = (JLabel) comp;
            label.setHorizontalAlignment(align);
            label.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, tam));

        }

        if (comp instanceof JButton){

            JButton boton = (JButton) comp;
            boton.setContentAreaFilled(false);
            boton.setFocusPainted(false);
            boton.setBorderPainted(false);
            boton.setCursor (new Cursor(Cursor.HAND_CURSOR));   
            boton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    if (e.getActionCommand().equals("Easy Mode")) {



                    } else if (e.getActionCommand().equals("Medium Mode")) {

                    } else {

                        removeAll();
                        add(new Contenedor(100, 20, 25));
                        repaint();
                        revalidate ();

                    }

                }

                
            });

        }

        panel.add(comp);

    }


}



class Contenedor extends JPanel {

    public Contenedor (int max_value, int variacion_min, int variacion_max) {
        initComponents(max_value, variacion_min, variacion_max);
    }

    private void initComponents (int max_value, int variacion_min, int variacion_max) {

        setBackground(Color.WHITE);
        setLayout(null);

        try {
            imagen = ImageIO.read(new File("src//img//Background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        lblPista = new JLabel ();
        lblPista.setBounds(50, 250, 400, 125);
        add(lblPista);

        num_random = new Random(System.currentTimeMillis()).nextInt(max_value); //Inicializamos el numero random

        boton = new JButton("Mostrar Pista");
        boton.setContentAreaFilled(false);
        boton.setFocusPainted(false);
        boton.setBorder (null);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setBounds(330, 150, 200, 20);
        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                /*Obtenemos un valor aleatorio que será el que se le restará al numero aleatorio generado para generar un rango donde se encuentra ese numero
                * Ejemplo: numero_aleatorio: 20.  intervalo_minimo= 5, intervalo_maximo = 5,  rango donde se encuentra el numero: 15 al 25
                */
                int intervalo_minimo = (int) (Math.random() * variacion_min) + 3, intervalo_maximo = (int) (Math.random() * variacion_max) + 1;
                int rango_maximo = 1, rango_minimo = 0;

                if ((num_random - intervalo_minimo) > 0 && (num_random - intervalo_minimo) < (num_random + intervalo_maximo)) {
                    rango_minimo = num_random - intervalo_minimo;
                } else {

                    while (true){
                        if  ((num_random - intervalo_minimo) > 0 && (num_random - intervalo_minimo) < (num_random + intervalo_maximo)){

                            rango_minimo = num_random - intervalo_minimo;
                            break;

                        }

                        intervalo_minimo = (int) (Math.random() * 20);

                    }


                }


                if ((num_random + intervalo_maximo) < max_value){
                    rango_maximo = num_random + intervalo_maximo;
                } else {
                    rango_maximo = num_random + 1;
                }

                String msj = "<html>" + "Pista: <p><p>El numero se encuentra entre (" + rango_minimo + " y " + rango_maximo + ")." + "<html>";
                lblPista.setText(msj);

            }
            
        });
        add (boton);



        txtNumero = new JTextField ("Ingrese un numero");
        txtNumero.setForeground(Color.DARK_GRAY);
        txtNumero.setOpaque(false);
        txtNumero.setBorder (null);
        txtNumero.setBounds(50, 150, 250, 20);
        txtNumero.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked (MouseEvent e){

                if (txtNumero.getText().equals("Ingrese un numero")) {

                    txtNumero.setText("");
                    txtNumero.setForeground(Color.BLACK);

                }

            }

        });
        txtNumero.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                
                boolean verificar_numeros = ((e.getKeyChar() >= 45 && e.getKeyChar() <= 57)) ? true : false ;
                if (!verificar_numeros) e.consume();

            }

            @Override
            public void keyPressed (KeyEvent e){

                
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    
                    try {

                        num_ingresado = Integer.parseInt(txtNumero.getText());

                        if (num_ingresado == num_random){
                            JOptionPane.showMessageDialog(Contenedor.this, "Felicidades!! Adivinaste el numero");
                        } else {
    
                            JOptionPane.showMessageDialog(Contenedor.this, "El numero era: " + num_random);
                            lblPista.setText("");
                            txtNumero.setText(""); //Vaciamos el numero que el usuario ingreso
                            
                        }
    
                        num_random = new Random(System.currentTimeMillis()).nextInt(100); //Actualizamos el valor del numero random para que vaya cambiando

                    } catch (NumberFormatException ex) {
                        System.out.println("Error por: " + ex.getMessage());
                    }


                }



            }

        });
        add(txtNumero);

        JSeparator separador = new JSeparator();
        separador.setBackground(Color.DARK_GRAY);
        separador.setOpaque(false);
        separador.setBounds(50, 170, 250, 10);
        add (separador);


        JLabel titulo = new JLabel("Hard Mode");
        titulo.setFont(new Font("Roboto Black", Font.BOLD + Font.ITALIC, 30));
        titulo.setBounds(300, 20, 200, 30);
        add(titulo);

    }


    @Override
    public void paintComponent (Graphics g) {

        super.paintComponent(g);

        if (imagen != null) {

            g.drawImage(imagen, 0, 0, this);
            return;

        } 

        g.drawString("No se pudo cargar la imagen", 20, 50);

    }

    private Image imagen;
    private JTextField txtNumero;
    private JButton boton;
    private int num_random = 0, num_ingresado;
    private JLabel lblPista;
}