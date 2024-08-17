package lista_sencillamente_enlazada_ii.view;

import lista_sencillamente_enlazada_ii.modelo.ListaPacientes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContenedorLogin extends JPanel {

    public ContenedorLogin (ListaPacientes lista, JPanel panel_principal) {

        setLayout(new BorderLayout()); //Establecemos la disposicion del JPanel
        crearLeftContent();
        crearRightContent();

        this.lista = lista;
        this.panel_principal = panel_principal; //Obtenemos el panel principal para actualizar su view
    }


    private void crearLeftContent () {
        
        JLabel bg = new JLabel(new ImageIcon("src//lista_sencillamente_enlazada_ii//resources//Left Content.png"));
        bg.setBounds(0, 0, 500, 580);

        JPanel left_content = new JPanel();
        left_content.setLayout(null);
        left_content.setPreferredSize(new Dimension(500, 580));
        
        JLabel titulo = new JLabel("GoodHealth");
        titulo.setFont(new Font("Roboto Black", Font.BOLD, 30));
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(100, 200, 200, 30);

        JLabel eslogan = new JLabel("The best hospital for your family and friends");
        eslogan.setForeground (Color.WHITE);
        eslogan.setFont(new Font ("Roboto", Font.PLAIN, 16));
        eslogan.setBounds (100, 230, 400, 30);

        left_content.add(eslogan);
        left_content.add(titulo);
        left_content.add(bg);


        add (left_content, BorderLayout.WEST);
    }
    private void crearRightContent () {

        JPanel right_content = new JPanel();
        right_content.setLayout(null);
        right_content.setBackground(Color.WHITE);

        JLabel hello = new JLabel("Hello Again!");
        hello.setForeground(Color.BLACK);
        hello.setFont(new Font("Roboto Black", Font.BOLD, 24));
        hello.setBounds(100, 120, 300, 30);
        right_content.add(hello);

        JLabel welcome = new JLabel("Welcome  Back");
        welcome.setForeground(Color.BLACK);
        welcome.setFont(new Font("Roboto", Font.PLAIN, 16));
        welcome.setBounds(100, 150, 300, 30);
        right_content.add(welcome);


        /*Llamamos al metodo encargado de colocar los componentes */
        posicionarRightContents(right_content); 
       
    }
    


    
    /*Metodo para posicionar los elementos en el rightContent */
    private void posicionarRightContents (JPanel right_content) {

        /*Crear */
        txtEmail = new JTextField("Email Address");
        txtPassword = new JPasswordField("-.:Contraseña:.-");

        configurarRightContents(right_content, txtEmail, Color.GRAY, 100, 220, 330, 30, null);
        configurarRightContents(right_content, txtPassword, Color.GRAY, 100, 290, 330, 30, null);

        /*-----------------AGREGAMOS LOS BOTONES---------------- */
        btnLogin = new JButton ("Login");
        configurarRightContents(right_content, btnLogin, new Color (5, 117, 230), 120, 370, 300, 32, "Login");

        btnForgot = new JButton ("Forgot Password");
        configurarRightContents(right_content, btnForgot, Color.GRAY, 150, 410, 250, 30, "Forgot");

        add (right_content, BorderLayout.CENTER);

    }


    //Este metodo se encarga de configurar y darle apareciencia a los componentes del contenido derecho.
    private void configurarRightContents (JPanel panel, JComponent componente, Color color, int x, int y, int width, int height, String command) {

        if (componente instanceof JTextField || componente instanceof JPasswordField) {

            componente.setForeground(color);
            componente.setOpaque(false);
            componente.setBounds(x, y, width, height);
            componente.setBorder (null);

            JSeparator sptr = new JSeparator();
            sptr.setBounds(x, y + 30, width, height);
            sptr.setForeground(Color.BLACK);
            panel.add(sptr);

        }


        if (componente instanceof JButton) {

            JButton boton = (JButton) componente; //Obtenemos el objeto original de jbutton que fue enviado.

            boton.setActionCommand(command);
            boton.setBounds(x, y, width, height);
            boton.setBorder(null);
            boton.setFocusPainted(false);
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            if (boton.getActionCommand().equals("Forgot")) {

                boton.setOpaque(false);
                boton.setForeground(color);
                boton.setContentAreaFilled(false);
                boton.addActionListener(null);


            } else if (boton.getActionCommand().equals("Login")) {
                
                boton.setBackground(color);
                boton.setForeground(Color.WHITE);

                boton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        /*Actualizamos el contenido de la ventana. */
                        panel_principal.removeAll();
                        panel_principal.add(new ManagerLista(lista, panel_principal));
                        panel_principal.repaint();
                        panel_principal.revalidate ();


                    }
                    
                });

            }



        }


        panel.add(componente);

    }




    private JButton btnLogin, btnForgot;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private ListaPacientes lista;
    private JPanel panel_principal;
}
