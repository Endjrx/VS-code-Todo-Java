package lista_sencillamente_enlazada_ii.view;

import lista_sencillamente_enlazada_ii.modelo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MarcoPrincipal extends JFrame {

    public MarcoPrincipal () {

        this.setSize(1100, 605);
        this.setTitle("Gestion Pacientes");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(true);

        lista = new ListaPacientes(); //Creamos nuestra lista.
        lista.agregarInicio(new Paciente("Endjrx", "1124009262", "3007821853", "Maicao", "No sé", "Masculino", 18));

        configurarMovimientoFrame();
        add (new Contenedor(lista), BorderLayout.CENTER);
        this.setVisible(true);

    }


    private void configurarMovimientoFrame () {

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 7, 0));
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(getWidth(), 25));
        panel.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        
        panel.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed (MouseEvent e) {

                x = e.getX();
                y = e.getY();

            }

        });
        panel.addMouseMotionListener(new MouseAdapter() {
            
            @Override
            public void mouseDragged (MouseEvent e) {

                setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);

            }

        });


        JButton btnMinimizar = new JButton("-");
        btnMinimizar.setFont(new Font("Monospaced", Font.BOLD, 24));
        btnMinimizar.setForeground(Color.WHITE);
        btnMinimizar.setContentAreaFilled(false);
        btnMinimizar.setFocusPainted(false);
        btnMinimizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMinimizar.setBorder(null);
        panel.add (btnMinimizar);


        JButton btnCerrar = new JButton("X");
        btnCerrar.setFont(new Font("Monospaced", Font.BOLD, 18));
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCerrar.setBorder(null);
        btnCerrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
        panel.add(btnCerrar);

        add (panel, BorderLayout.NORTH);
    }

    private int x = 0, y = 0;
    private ListaPacientes lista;
}
