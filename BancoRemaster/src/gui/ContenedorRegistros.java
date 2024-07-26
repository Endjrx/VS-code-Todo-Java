package gui;

import javax.swing.*;
import datos_user.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ContenedorRegistros extends JPanel {
    
    ArrayList <Plantilla> lista = new ArrayList<Plantilla>();

    public ContenedorRegistros (JPanel contenedor, ArrayList <Plantilla> lista) {

        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        initComponents();

        this.lista = lista;
        this.contenedor = contenedor;
    }

    private void initComponents () {

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        txtUsuario = new JTextField ("Ingrese su nombre de usuario");
        txtID = new JTextField ("Ingrese su numero de identificacion");
        txtEmail = new JTextField ("Ingrese su email");
        combo = new JComboBox<String>(new String [] {
            "....", "Masculino", "Femenino"
        });
        txtPassword = new JPasswordField("---.Contraseña.---");

        //-------------------------------------------------------AGREGAMOS LOS COMPONENTES A LA INTERFAZ----------------------------------------------------------------
        construirComponentes(panel, new JLabel("REGISTROS"), null, 410, 20, 200, 30, new Font("Roboto Black", Font.BOLD, 32), Color.BLACK, null, null);
        construirComponentes(panel, new JLabel("USUARIO"), null, 70, 100, 120, 30, new Font("Roboto Black", Font.BOLD, 20), Color.BLACK, null, null);
        construirComponentes(panel, txtUsuario, new JSeparator(), 70, 130, 300, 20, new Font("Arial", Font.PLAIN, 12), Color.GRAY, null, null);
        
        construirComponentes(panel, new JLabel("ID"), null, 70, 170, 120, 30, new Font("Roboto Black", Font.BOLD, 20), Color.BLACK, null, null);
        construirComponentes(panel, txtID, new JSeparator(), 70, 200, 300, 20, new Font("Arial", Font.PLAIN, 12), Color.GRAY, null, null);
        
        construirComponentes(panel, new JLabel("EMAIL"), null, 70, 250, 120, 30, new Font("Roboto Black", Font.BOLD, 20), Color.BLACK, null, null);
        construirComponentes(panel, txtEmail, new JSeparator(), 70, 280, 300, 20, new Font("Arial", Font.PLAIN, 12), Color.GRAY, null, null);

        construirComponentes(panel, new JLabel("SEXO"), null, 70, 320, 200, 30, new Font("Roboto Black", Font.BOLD, 20), Color.BLACK, null, null);
        construirComponentes(panel, combo, null, 70, 350, 300, 25, new Font("Arial", Font.PLAIN, 12), Color.BLACK, null, null);

        construirComponentes(panel, new JLabel("CONTRASEÑA"), null, 70, 400, 200, 30, new Font("Roboto Black", Font.BOLD, 20), Color.BLACK, null, null);
        construirComponentes(panel, txtPassword, new JSeparator(), 70, 430, 300, 20, new Font("Arial", Font.PLAIN, 12), Color.GRAY, null, null);

        
        //-------------------------------------------------------AGREGAMOS LOS BOTONES------------------------------------------------------------------------
        construirComponentes(panel, new JButton("Login"), null, 900, 0, 80, 35, new Font("Roboto Black", Font.PLAIN, 14), Color.BLACK, new Color (0, 134, 190), "Login");
        construirComponentes(panel, new JButton("REGISTRAR"), null, 100, 480, 400, 35, new Font("Roboto Black", Font.PLAIN, 14), Color.WHITE, new Color (0, 134, 190), "Registrar R");
        add(panel, BorderLayout.CENTER);

    }


    private void construirComponentes (JPanel panel, JComponent comp, JComponent comp2, int x, int y, int width, int height, Font fuente, Color fore, Color back, String command) {

        comp.setBounds(x, y, width, height);
        comp.setOpaque(false);
        comp.setForeground(fore);
        comp.setBorder(null);
        comp.setFont(fuente);
        panel.add(comp);

        if (comp instanceof JButton) {

            JButton boton = (JButton) comp;
            boton.setActionCommand(command);
            boton.setFocusPainted(false);
            boton.setBackground(back);
            boton.setOpaque(true);

            if (boton.getActionCommand().equals("Login")) {
                boton.setContentAreaFilled(false);
            }

            boton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    if (e.getActionCommand().equals("Registrar R")) {

                        boolean v1 = false, v2 = false, v3 = false, v4 = false;

                        v1 = (!txtEmail.getText().equals("Ingrese su email") || !txtEmail.getText().isBlank()) ? true : false;
                        v2 = (!txtID.getText().equals("Ingrese su numero de identificacion") || !txtID.getText().isBlank()) ? true : false;
                        v3 = (!txtUsuario.getText().equals("Ingrese su nombre de usuario") || !txtUsuario.getText().isBlank()) ? true : false;
                        v4 = (txtPassword.getPassword().length != 0) ? true : false;

                        if (v1 && v2 && v3 && v4) {

                            lista.add(new Clientes(txtUsuario.getText(), txtEmail.getText(), txtPassword.getPassword(), txtID.getText(),0, 0, 0, 0, 0));
                            JOptionPane.showMessageDialog(ContenedorRegistros.this, "Registro Exitoso", "Informe", JOptionPane.INFORMATION_MESSAGE);
                            
                            contenedor.removeAll();
                            contenedor.add(new ContenedorLogin(contenedor, lista), BorderLayout.CENTER);
                            contenedor.repaint();
                            contenedor.revalidate ();

                        }

                    }

                    if (e.getActionCommand().equals("Login")) {

                        contenedor.removeAll();
                        contenedor.add(new ContenedorLogin(contenedor, lista));
                        contenedor.repaint();
                        contenedor.revalidate ();

                    }

                }   
                
            });

        }

        if (comp instanceof JTextField) {

            JTextField field = (JTextField) comp;
            field.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent e) {
                    
                    if (e.getSource() == txtUsuario) {
                        
                        if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
                        
                            txtUsuario.setForeground(Color.BLACK);
                            txtUsuario.setText("");
                        }    

                    } else if (e.getSource() == txtID) {

                        if (txtID.getText().equals("Ingrese su numero de identificacion")) {
                        
                            txtID.setForeground(Color.BLACK);
                            txtID.setText("");

                        }    

                    } else if (e.getSource() == txtEmail) {

                        if (txtEmail.getText().equals("Ingrese su email")) {
                        
                            txtEmail.setText("");
                            txtEmail.setForeground(Color.BLACK);

                        }

                    } else if (e.getSource() == txtPassword) {

                        String contraseña = "";
                        for (int i = 0; i < txtPassword.getPassword().length; i++) {
                            contraseña += txtPassword.getPassword() [i];
                        }

                        if (contraseña.equals("---.Contraseña.---")) {
                            
                            txtPassword.setText("");
                            txtPassword.setForeground (Color.BLACK);
                        }
                            
                    }

                }

                @Override
                public void focusLost(FocusEvent e) {
                    
                    if (e.getSource() == txtUsuario) {

                        if (txtUsuario.getText().isBlank()) {
                         
                            txtUsuario.setText("Ingrese su nombre de usuario");
                            txtUsuario.setForeground(Color.GRAY);

                        }


                    } else if (e.getSource() == txtEmail) {

                        if (txtEmail.getText().isBlank()) {

                            txtEmail.setText("Ingrese su email");
                            txtEmail.setForeground(Color.GRAY);
                            
                        }

                    } else if (e.getSource() == txtID) {

                        if (txtID.getText().isBlank()) {

                            txtID.setText("Ingrese su numero de identificacion");
                            txtID.setForeground(Color.GRAY);

                        }

                    } else if (e.getSource() == txtPassword){

                        if (txtPassword.getPassword().length == 0) {

                            txtPassword.setText("---.Contraseña.---");
                            txtPassword.setForeground(Color.GRAY);

                        }

                    }


                }
                
            });
            

        }


        //Evaluamos que sea diferente de null en caso no se vaya agregar un JSeparator
        if (comp2 != null) {
            comp2.setBounds(x, y + 20, width, 10);
            comp2.setForeground(Color.BLACK);
            panel.add(comp2);
        }

    }

    private JTextField txtUsuario, txtID, txtEmail;
    private JComboBox <String> combo;
    private JPasswordField txtPassword;
    private JPanel contenedor;
}
