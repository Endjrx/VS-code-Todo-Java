package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import datos_user.Clientes;
import datos_user.Plantilla;
import lista_registro.Historial;
import lista_registro.ListaHistorial;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ContenedorMovimientos extends JPanel {
 
    //-----------------------------MI MODELO DEL JTABLE--------------------------
    DefaultTableModel modelo = new DefaultTableModel(){

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        };

    };
    

    //--------------------------------------CONSTRUCTOR-----------------------------------
    public ContenedorMovimientos (ArrayList <Plantilla> lista, JPanel contenedor, int posicion) {
        
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        initComponents();
        
        this.contenedor = contenedor;
        this.lista = lista;
        
        setModel();
        setDatosModelo(posicion);
    }
    

    //-------------------------METODOS PARA CONFIGURAR EL JTABLE---------------------------
    private void setModel () {

        modelo.setColumnIdentifiers(new Object[] {
            "Saldo", "Prestamo", "Deuda + Interes", "Cuotas"
        });
        tabla.setModel(modelo);
    }

    private void setDatosModelo (int posicion) {    

        if (lista.get(posicion) instanceof Clientes) {

            Clientes cliente = (Clientes) lista.get(posicion);
            ListaHistorial historial = cliente.getHistorial();

            if (historial.obtenerDatos() != null) {
                
                for (int i = 0; i < historial.obtenerTamaño(); i++) {
                    modelo.addRow(new Object []{

                        historial.obtenerDatos() [i].getHistorial().getSaldo(),
                        historial.obtenerDatos() [i].getHistorial().getPrestamo(),
                        historial.obtenerDatos() [i].getHistorial().getDeuda(),
                        historial.obtenerDatos() [i].getHistorial().getCuota()

                    });
                }

            }

            tabla.setModel(modelo);
     
        }
    }

    
    //----------------------------------------METODO CORAZON CLASE-----------------------------------
    private void initComponents () {
        
        JPanel panelPadreNorte = new JPanel(new GridLayout(1,2));
        JPanel panelRegresar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 4));  
        panelRegresar.setBackground(Color.WHITE);


        //-----------------------------BOTON PARA REGRESAR AL MENU DE LOGING---------------------------
        JButton btnRegresar = new JButton ("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setBorder(null);
        btnRegresar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                contenedor.removeAll();
                contenedor.add(new ContenedorLogin(contenedor, lista));
                contenedor.repaint();
                contenedor.revalidate ();

            }
            
        });

        panelRegresar.add(btnRegresar);
        panelPadreNorte.add(panelRegresar);
        

        //----------------------------PANEL ACCOUNT---------------------------------
        JPanel panelAccount = new JPanel();
        panelAccount.setBackground(Color.WHITE);
        panelAccount.setLayout(new FlowLayout(FlowLayout.RIGHT, 10,4));

        JLabel imgAccount = new JLabel (new ImageIcon("src//img//Account.png"));
        imgAccount.addMouseListener(null);
        panelAccount.add(imgAccount);

        panelPadreNorte.add(panelAccount);        
        add(panelPadreNorte, BorderLayout.NORTH);
        
        
        //---------------------JTABLE ------------------------------------------------
        JLabel title = new JLabel ("MOVIMIENTOS DEL USUARIO");
        title.setFont(new Font("Roboto Black", Font.BOLD, 30));
        title.setHorizontalAlignment(JLabel.CENTER);

        tabla = new JTable();
        paneScroll = new JScrollPane(tabla);

        JPanel panelCentral = new JPanel (new BorderLayout(5,20));
        panelCentral.setBackground(Color.WHITE);
        panelCentral.add(paneScroll, BorderLayout.CENTER);
        panelCentral.add(title, BorderLayout.NORTH);

        add(panelCentral, BorderLayout.CENTER);


        JPanel panelBotones = new JPanel();   
        panelBotones.setLayout(null); 
        panelBotones.setBackground(Color.WHITE);
        panelBotones.setPreferredSize(new Dimension(getWidth(), 100));

        construirBotones(panelBotones, new JButton ("PRESTAMO"), null,"Prestamo", Color.WHITE, new Color (0, 134, 190), 50, 10, null);
        construirBotones(panelBotones, new JButton ("RETIRAR"), new JSeparator(), "Retirar", Color.BLACK, new Color (253, 221, 202), 300, 10, new JTextField ());
        construirBotones(panelBotones, new JButton ("CONSIGNAR"), new JSeparator(), "Consignar", Color.WHITE, new Color (0, 134, 190), 550, 10, new JTextField ());
        construirBotones(panelBotones, new JButton ("CUOTAS"), new JSeparator(), "Cuotas", Color.BLACK, new Color (253, 221, 202), 800, 10, new JTextField ());
        add(panelBotones, BorderLayout.SOUTH);
    }
    

    private void construirBotones (JPanel panel, JButton boton, JSeparator separator, String command, Color fore, Color back, int x, int y, JTextField field) {
        
        boton.setFocusPainted(false);
        boton.setForeground(fore);
        boton.setBackground(back);
        boton.setActionCommand(command);
        boton.setBounds(x, y, 170, 35);
        boton.setFont(new Font("Roboto Black", Font.BOLD, 14));
        panel.add(boton);

        if (separator != null){

            separator.setBounds(x, y + 80, 170, 10);
            separator.setForeground(Color.BLACK);
            panel.add(separator);

        }
        
        if (field != null) {
            
            field.setBackground(panel.getBackground());
            field.setBorder(null);
            field.setOpaque(true);
            field.setBounds(x, y + 60, 170, 20);
            panel.add(field);

        }
    }


    private JTable tabla;
    private JScrollPane paneScroll;
    private JPanel contenedor;
    private ArrayList <Plantilla> lista = new ArrayList<Plantilla>();
}
