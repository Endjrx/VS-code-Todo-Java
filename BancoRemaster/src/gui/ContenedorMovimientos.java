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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ContenedorMovimientos extends JPanel {
 
    //-----------------------------MI MODELO DEL JTABLE--------------------------
    DefaultTableModel modelo;
    

    //--------------------------------------CONSTRUCTOR-----------------------------------
    public ContenedorMovimientos (ArrayList <Plantilla> lista, JPanel contenedor, int posicion) {
        
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        initComponents();
        
        this.contenedor = contenedor;
        this.lista = lista;
        this.posicion = posicion;
        
        setModel();
        setDatosModelo(posicion);
    }
    

    //-------------------------METODOS PARA CONFIGURAR EL JTABLE---------------------------
    private void setModel () {

        modelo = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            };
    
        };

        modelo.setColumnIdentifiers(new Object[] {
            "Saldo", "Prestamo", "Deuda + Interes", "Cuotas", "Total"
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
                        historial.obtenerDatos() [i].getHistorial().getCuota(),
                        historial.obtenerDatos() [i].getHistorial().getTotal()

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
        JButton btnRegresar = new JButton ("Cerrar Sesion");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setBorder(null);
        btnRegresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                contenedor.removeAll();
                contenedor.add(new ContenedorLogin(contenedor, lista), BorderLayout.CENTER);
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
        imgAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imgAccount.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked (MouseEvent e) {

                contenedor.removeAll();
                contenedor.add(new Account(contenedor, lista, posicion));
                contenedor.repaint();
                contenedor.revalidate ();

            }

        });
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
        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (e.getActionCommand().equals("Prestamo")) {
                   
                    if (tabla.getRowCount() > 0) {
                        if ((double)tabla.getValueAt(tabla.getRowCount() - 1 , 1) == 0) {
                            if ((double) tabla.getValueAt(tabla.getRowCount() - 1, 4) >= 1000){
                            
                                double prestamo = (double) tabla.getValueAt(tabla.getRowCount() - 1, 4) * 0.5;
                                double deuda = prestamo + (prestamo * 0.02);
                                double cuotas = deuda / 6;
                                if (lista.get(posicion) instanceof Clientes) {
    
                                    Clientes cliente = (Clientes) lista.get(posicion);
    
                                    int tamaño = cliente.getHistorial().obtenerTamaño();
                                    cliente.getHistorial().obtenerDatos() [tamaño - 1].getHistorial().setPrestamo(prestamo);
                                    cliente.getHistorial().obtenerDatos() [tamaño - 1].getHistorial().setDeuda(deuda);
                                    cliente.getHistorial().obtenerDatos() [tamaño - 1].getHistorial().setCuota(cuotas);
    
                                    setModel();
                                    setDatosModelo(posicion);
    
                                }
        
        
                            } else {
                                JOptionPane.showMessageDialog(ContenedorMovimientos.this, "Tiene que tener += 1000$ para aspirar a un prestamo", "Advertencia", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(ContenedorMovimientos.this, "No puede hacer otro prestamo si ya tiene uno vigente", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        }
                    }

                } else if (e.getActionCommand().equals("Retirar")) {
                    
                    try {

                        double retirar = Double.parseDouble (field.getText());
                        if (lista.get(posicion) instanceof Clientes) {
                            if (retirar  > 0 ) {
                                if (tabla.getRowCount() > 0) { //Al evaluar esta condicion, basicamente verifico si hay algun dato en la tabla.
                                    
                                    Clientes cliente = (Clientes) lista.get(posicion);

                                    if (retirar <= (double) tabla.getValueAt(tabla.getRowCount() - 1, 4)) { //Me aseguro que ya haya saldo previo y el suficiente.

                                        //Obtenemos el saldo de la ultima final y lo restamo con el nuevo y agregar ese nuevo saldo al historial
                                        double saldoVigente = (Double) tabla.getValueAt(tabla.getRowCount() -  1, 4);
                                        double nuevoSaldo = saldoVigente - retirar;
                                        double prestamoVigente = (double) tabla.getValueAt(tabla.getRowCount() - 1, 1);
                                        double cuotaVigente = (double) tabla.getValueAt(tabla.getRowCount() - 1, 3);
                                        double deudaVigente = (double) tabla.getValueAt(tabla.getRowCount() - 1, 2);
                                        cliente.getHistorial().agregarDatos(new Historial((retirar * - 1), prestamoVigente, cuotaVigente, deudaVigente, nuevoSaldo));

                                        setModel();
                                        setDatosModelo(posicion);

                                    } else {
                                        JOptionPane.showMessageDialog(ContenedorMovimientos.this, "No puede retirar más del saldo total disponible", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(ContenedorMovimientos.this, "Saldo insuficiente", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                }

                            } else {
                                JOptionPane.showMessageDialog(ContenedorMovimientos.this, "No puede ingresar valores menores o igual a cero", "Warning", JOptionPane.WARNING_MESSAGE);
                            }

                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(ContenedorMovimientos.this, "Ingrese valores numericos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }    

                } else if (e.getActionCommand().equals("Consignar")) {
                    
                    try {

                        double saldo = Double.parseDouble(field.getText());
                        
                        if (lista.get(posicion) instanceof Clientes) {
                            if (saldo > 0) {

                                Clientes cliente = (Clientes) lista.get(posicion);

                                double ultimoSaldo = 0;
                                double prestamo = 0;
                                double deuda = 0;
                                double cuotas = 0;

                                int tamañoHistorial = cliente.getHistorial().obtenerTamaño();
                                if (tamañoHistorial > 0) {
                                    ultimoSaldo = (double) cliente.getHistorial().obtenerDatos() [tamañoHistorial - 1].getHistorial().getTotal();
                                    prestamo = (double) cliente.getHistorial().obtenerDatos() [tamañoHistorial - 1].getHistorial().getPrestamo();
                                    deuda = (double) cliente.getHistorial().obtenerDatos() [tamañoHistorial - 1].getHistorial().getDeuda();
                                    cuotas = (double) cliente.getHistorial().obtenerDatos() [tamañoHistorial - 1].getHistorial().getCuota();
                                }

                                cliente.getHistorial().agregarDatos(new Historial(saldo,  prestamo, cuotas, deuda, ultimoSaldo + saldo));

                                setModel();
                                setDatosModelo(posicion);

                            } else {
                                JOptionPane.showMessageDialog(ContenedorMovimientos.this, "No puede ingresar valores menores o igual a cero", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                        }

                    } catch (NumberFormatException exx) {
                        JOptionPane.showMessageDialog(ContenedorMovimientos.this, "Ingrese valores numericos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }

                } else if (e.getActionCommand().equals("Cuotas")){

                    if (lista.get(posicion) instanceof Clientes) {
                        
                        try {
                            
                            if (Double.parseDouble(field.getText()) >= (double) tabla.getValueAt(tabla.getRowCount() - 1, 3) ) { //Me aseguro que abone lo de la cuota

                                double valorPagar = Double.parseDouble(field.getText());
                                Clientes cliente = (Clientes) lista.get(posicion);
                                Historial ultimoHistorial = cliente.getHistorial().obtenerDatos() [cliente.getHistorial().obtenerTamaño() - 1].getHistorial();

                                if (((double)tabla.getValueAt(tabla.getRowCount() - 1, 2) + (valorPagar * -1)) >= 0) {

                                    ultimoHistorial.setDeuda(ultimoHistorial.getDeuda() - valorPagar);
                                    ultimoHistorial.setTotal(ultimoHistorial.getTotal() - valorPagar);

                                    setModel();
                                    setDatosModelo(posicion);

                                    if ((double)tabla.getValueAt(tabla.getRowCount() - 1, 2) == 0) {

                                        

                                    }

                                } else {
                                    JOptionPane.showMessageDialog(ContenedorMovimientos.this, "No puede abonar más de lo que debe");
                                }

                            } else {
                                JOptionPane.showMessageDialog(ContenedorMovimientos.this, "Las cuotas deben ser pagadas como lo establecido", "Advertencia", JOptionPane.WARNING_MESSAGE);
                            }

                        } catch (Exception ex) {
                            
                        }

                    }

                }   

            }
            
        });
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
    private int posicion;
}
