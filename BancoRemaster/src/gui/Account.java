package gui;

import javax.swing.*;

import datos_user.Plantilla;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Account extends JPanel {
    
    ArrayList <Plantilla> lista = new ArrayList<>();

    public Account (JPanel contenedor, ArrayList <Plantilla> lista, int posicion) {

        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        
        this.contenedor = contenedor;
        this.lista = lista;

        initComponents(posicion);
    }


    //--------------------------------METODO BASE CLASE------------------------------
    private void initComponents (int posicion) {

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        construrirInterfaz(panel, posicion);
        add(panel, BorderLayout.CENTER);


        JPanel panelRegresar = new JPanel();
        panelRegresar.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 2));
        panelRegresar.setBackground(getBackground());

        JButton boton = new JButton("Regresar");
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false);
        boton.setBorder (null);
        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                contenedor.removeAll();
                contenedor.add(new ContenedorMovimientos(lista, panel, posicion));
                contenedor.repaint();
                contenedor.revalidate ();

            }
            
        });
        panelRegresar.add(boton);

        add(panelRegresar, BorderLayout.NORTH);

    }


    //------------------------------------METODO QUE EXTRAE EL NOMBRE Y EMAIL DEL USUARIO---------------------------------
    private String [] getDatos (int posicion) {
        return new String [] {
                lista.get(posicion).getNombre(), lista.get(posicion).getEmail()
        };
    }


    //-------------------------------METODO QUE SE ENCARGA SOLO DE LLAMAR AL METODO QUE CREA Y POSICIONA LOS COMPONENTES----------------------------
    private void construrirInterfaz (JPanel panel, int posicion) {

        confiComp(panel, new JLabel ("Settings"), new Font("Roboto", Font.BOLD, 32), null, null, Color.BLACK, 60, 50, 150, 35);        
        confiComp(panel, new JLabel ("Account"), new Font("Arial", Font.PLAIN, 13), new JSeparator(), new Cursor(Cursor.HAND_CURSOR), Color.GRAY, 60, 150, 70, 35);        
        confiComp(panel, new JLabel ("Publishing"), new Font("Arial", Font.PLAIN, 13), new JSeparator(), new Cursor(Cursor.HAND_CURSOR), Color.GRAY, 150, 150, 70, 35);        
        confiComp(panel, new JLabel ("Notifications"), new Font("Arial", Font.PLAIN, 13), new JSeparator(), new Cursor(Cursor.HAND_CURSOR), Color.GRAY, 250, 150, 100, 35);        
        confiComp(panel, new JLabel ("Membership and payment"), new Font("Arial", Font.PLAIN, 13), new JSeparator(), new Cursor(Cursor.HAND_CURSOR), Color.GRAY, 360, 150, 150, 35);        
        confiComp(panel, new JLabel ("Security and apps"), new Font("Arial", Font.PLAIN, 13), new JSeparator(), new Cursor(Cursor.HAND_CURSOR), Color.GRAY, 550, 150, 150, 35);        
        
        //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        confiComp(panel, new JLabel ("Email address"), new Font("Arial", Font.PLAIN, 13), null, new Cursor(Cursor.HAND_CURSOR), Color.GRAY, 60, 220, 500, 25);        
        confiComp(panel, new JLabel (getDatos(posicion) [1], JLabel.RIGHT), new Font("Arial", Font.PLAIN, 13), null, new Cursor(Cursor.HAND_CURSOR), Color.GRAY, 540, 220, 200, 25); 
        
        confiComp(panel, new JLabel ("Username and subdomain"), new Font("Arial", Font.PLAIN, 13), null, new Cursor(Cursor.HAND_CURSOR), Color.GRAY, 60, 270, 500, 25);        
        confiComp(panel, new JLabel (getDatos(posicion) [0], JLabel.RIGHT), new Font("Arial", Font.PLAIN, 13), null, new Cursor(Cursor.HAND_CURSOR), Color.GRAY, 540, 270, 200, 25);        
        
        confiComp(panel, new JLabel ("Profile information"), new Font("Arial", Font.PLAIN, 13), null, new Cursor(Cursor.HAND_CURSOR), Color.GRAY, 60, 320, 170, 25);        
        confiComp(panel, new JLabel ("Profile desing"), new Font("Arial", Font.PLAIN, 13), null, new Cursor(Cursor.HAND_CURSOR), Color.GRAY, 60, 370, 170, 25);        
        //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        confiComp(panel, new JLabel (""), null, new JSeparator(), null, Color.GRAY, 60, 420, 645, 25);        
        confiComp(panel, new JLabel ("Deactivate account"), new Font("Courier", Font.PLAIN, 13), null, new Cursor(Cursor.HAND_CURSOR), new Color (191, 0, 16), 60, 490, 400, 25);        
        confiComp(panel, new JLabel ("Deactivating will suspend your account until you sign back in"), new Font("Arial", Font.PLAIN, 13), null, new Cursor(Cursor.HAND_CURSOR), Color.GRAY, 60, 515, 400, 25);

    }


    //----------------------------------METODO QUE CREA Y POSICIONA LOS COMPONENTES----------------------------------------
    private void confiComp (JPanel panel, JLabel label, Font fuente, JSeparator separador, Cursor cursor, Color foreground,int x, int y, int width, int height) {

        label.setFont(fuente);
        label.setForeground(foreground);
        label.setBounds(x, y, width, height);
        label.setCursor(cursor);
        panel.add(label);

        if (separador != null){
            separador.setForeground(Color.LIGHT_GRAY);
            separador.setBounds(x, y + 30, width + 40, 10);
            panel.add(separador);
        }

    }


    private JPanel contenedor; //Objeto que obtedrá una referencia al contenedor principal
}
