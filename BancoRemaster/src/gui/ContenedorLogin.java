package gui;

import javax.swing.*;
import datos_user.Plantilla;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ContenedorLogin extends JPanel {

    public ContenedorLogin (JPanel contenedor, ArrayList <Plantilla> lista){

        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        initComponents();
        this.contenedor = contenedor;
        this.lista = lista;

    }

    //-----------------------METODO PARA CREAR TODOS LOS COMPONENTES-----------------------
    private void initComponents () {

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        //---------------------------------------METODO QUE CONSTRUYE AUTOMATICAMENTE LOS JLABELS--------------------------------------
        panel.add (construirLabels(new JLabel ("BANCO CALL OF DUTY"), 320, 20, 600, 30, new Font("Roboto Black", Font.BOLD, 32)));
        panel.add (construirLabels(new JLabel ("INICIAR SESION"), 100, 120, 250, 30, new Font("Roboto Black", Font.BOLD, 26)));
        panel.add (construirLabels(new JLabel ("Email"), 100, 200, 100, 30, new Font("Roboto Black", Font.BOLD, 20)));
        panel.add (construirLabels(new JLabel ("Password"), 100, 300, 100, 30, new Font("Roboto Black", Font.BOLD, 20)));
        
        //--------------------------------------INSTANCIAMOS LOS OBJETOS Y LOS POSICIONAMOS CON EL METODO----------------------------
        txtEmail = new JTextField("Ingrese su email");
        txtPassword = new JPasswordField("---.contraseña.---");

        construirCampos(panel, txtEmail, 100, 240, 300, 20);
        txtEmail.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

                if (txtEmail.getText().equals("Ingrese su email")) {
                    txtEmail.setText("");
                    txtEmail.setForeground(Color.BLACK);
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
               
                if (txtEmail.getText().isBlank()) {
                    txtEmail.setText("Ingrese su email");
                    txtEmail.setForeground(Color.GRAY);
                }

            }
            
        });

        construirCampos(panel, txtPassword, 100, 340, 300, 20);
        txtPassword.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                
                String contraseña = "";
                for (int i = 0; i < txtPassword.getPassword().length; i++) {
                    contraseña += txtPassword.getPassword() [i];
                }

                if (contraseña.equals("---.contraseña.---")) {
                    txtPassword.setText("");
                    txtPassword.setForeground(Color.BLACK);
                }  

            }

            @Override
            public void focusLost(FocusEvent e) {
                
                String contraseña = "";
                for (int i = 0; i < txtPassword.getPassword().length; i++) {
                    contraseña += txtPassword.getPassword() [i];
                }

                if (contraseña.isBlank()) {
                    txtPassword.setText("---.contraseña.---");
                    txtPassword.setForeground(Color.GRAY);
                }

            }
            
        });


        //------------------------------------METODO QUE CONSTRUYE LOS BOTONES Y LE CONFIGURA SUS ATRIBUTOS--------------------------------------
        panel.add (construirBoton(new JButton ("INCIAR SESION"), "Iniciar", 170, 440, 400, 35, new Color (0, 134, 190), Color.WHITE));
        add(panel);
    }

    //------------------------------METODO QUE SE ENCARGA DE CONSTRUIR JLABELS--------------------------------------------
    private JLabel construirLabels (JLabel label, int x, int y, int width, int height, Font fuente){

        label.setBounds(x, y, width, height);
        label.setFont(fuente);

        return label;
    }


    //--------------------------------METODO QUE SE ENCARGA DE CONSTRURIR LOS FIELDS ---------------------------------  
    private void construirCampos (JPanel panel, JComponent componente, int x, int y, int width, int height){

        componente.setOpaque(false);
        componente.setForeground(Color.GRAY);
        componente.setBorder (null);
        componente.setBounds(x, y, width, height);
        panel.add(componente);

        JSeparator separador = new JSeparator ();
        separador.setBounds (x, y + 20, width, 4);
        panel.add(separador);
        
    }


    //----------------------------------------METODO QUE CONSTRUYE TODOS LOS JBUTTONS------------------------------------  
    private JButton construirBoton (JButton boton, String texto, int x, int y, int width, int height, Color color, Color font) {

        boton.setBounds(x, y, width, height);
        boton.setActionCommand(texto);
        boton.setBorder(null);
        boton.setFocusPainted(false);
        boton.setBackground(color);
        boton.setForeground(font);
        boton.setFont(new Font ("Roboto Black", Font.BOLD, 14));

        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (e.getActionCommand().equals("Iniciar")) {

                    for (int i = 0; i < lista.size(); i++) {

                        if (txtEmail.getText().equals(lista.get(i).getEmail())) {

                            for (int j = 0; j < lista.size(); j++) {
                                if (txtPassword.getPassword() [j] != lista.get(i).getContraseña() [j]) {
                                    JOptionPane.showMessageDialog(ContenedorLogin.this, "Contraseña y/o email incorrecto");
                                    return;
                                }    
                            }
                            
                            contenedor.removeAll();
                            contenedor.add(new ContenedorMovimientos(lista, contenedor, i));
                            contenedor.repaint();
                            contenedor.revalidate ();

                            return;
                        }
                    } 

                    JOptionPane.showMessageDialog(ContenedorLogin.this, "Email y/o contraseña Incorrecta");

                }

            }    
            
        });

        return boton;
    }

    private JPanel contenedor;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private ArrayList <Plantilla> lista = new ArrayList<Plantilla>();
}
