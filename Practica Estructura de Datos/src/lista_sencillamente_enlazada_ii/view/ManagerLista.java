package lista_sencillamente_enlazada_ii.view;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import lista_sencillamente_enlazada_ii.modelo.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.*;


public class ManagerLista extends JPanel {

    public ManagerLista (ListaPacientes lista, JPanel panel_principal) {

        setLayout(new BorderLayout (20, 0));
        setBackground(Color.WHITE);

        leftContent();
        add (new TablaDatos(lista, panel_principal), BorderLayout.CENTER);

    }

    private void leftContent () {

        JLabel img = new JLabel (new ImageIcon("src//lista_sencillamente_enlazada_ii/resources/Img.png"));
        img.setBounds(0, 0, 350, 580);
        add(img, BorderLayout.WEST);

    }

}




class TablaDatos extends JPanel {

    /*Creamos el modelo de la tabla */
    DefaultTableModel modelo_tabla;


    /*Constructor */
    public TablaDatos (ListaPacientes lista, JPanel panel_principal) {

        this.panel_principal = panel_principal;
        this.lista = lista;
        zonaCentral();
        zonaNorte();

    }



    /*Metodo para crear la tabla y sus utilidades */
    private void zonaCentral () {

        setLayout(new BorderLayout ());
        setBackground(Color.WHITE);

        /*Instanciamos y configuramos la tabla */
        tabla = new JTable();
        pane = new JScrollPane(tabla);
        setModeloTabla();
        setDatosTabla();


        add(pane, BorderLayout.CENTER);
    }


    /*Metodo para todo lo que se encuentra en la zona norte */
    private void zonaNorte () {

        /*Panel que se agregará en dicha zona */
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(getWidth(), 170));

        /*---------------------------JLABELS------------------------- */
        JLabel mensaje = new JLabel("Datos de los pacientes");
        mensaje.setFont(new Font ("Roboto Black", Font.BOLD, 20));
        mensaje.setBounds(0, 50, 300, 25);
        panel.add(mensaje);


        JLabel busqueda = new JLabel("Busqueda: ");
        busqueda.setFont(new Font ("Roboto", Font.PLAIN, 12));
        busqueda.setBounds(2, 110, 70, 25);
        panel.add(busqueda);
        /*------------------------------------------------------------- */


        txtBusqueda = new JTextField("");
        txtBusqueda.setBounds(90, 110, 250, 25);
        txtBusqueda.setBorder (null);
        txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                
                System.out.println("ingresando texto");

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("removiendo texto");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("cambiando texto");
            }
            
        });
        panel.add(txtBusqueda);


        JSeparator sptr = new JSeparator();
        sptr.setBounds(90, 135, 250, 5);
        panel.add(sptr);



        /*BOTONES DE NAVEGACION. */
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        btnRegresar = new JButton(new ImageIcon("src//lista_sencillamente_enlazada_ii//resources//Flecha.png"));

        crearBotones(panel, btnAgregar, "Agregar P", 400, 110, 70, 20);
        crearBotones(panel, btnEliminar, "Eliminar P", 500, 110, 70, 20);
        crearBotones(panel, btnRegresar, "Regresar", -20, 10, 70, 20);

        add (panel, BorderLayout.NORTH);
    }


    private void crearBotones (JPanel panel, JButton boton, String command, int x, int y, int width, int height) {

        boton.setActionCommand(command);
        boton.setContentAreaFilled(false);
        boton.setCursor (new Cursor(Cursor.HAND_CURSOR));
        boton.setBounds(x, y, width, height);
        boton.setFocusPainted(false);
        boton.setBorder(null);

        if (boton.getActionCommand().equals("Eliminar P")) {

            boton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    if (tabla.getSelectedRow() == - 1) {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar a un paciente en la tabla primero.");
                    } else {

                        /*Hay que removerlo de la tabla y de la lista. */
                        /*Obtenemos la cedula del paciente seleccionado */
                        String cedula = (String) modelo_tabla.getValueAt(tabla.getSelectedRow(), 1);
                        lista.eliminarPacientes(cedula); //Buscamo la cedula en la lista y en caso la encuentre, la elimina

                        setModeloTabla();
                        setDatosTabla();

                    }

                }
                
            });

        } else if (boton.getActionCommand().equals("Agregar P")) {

            boton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente: ");
                    String cedula = JOptionPane.showInputDialog("Ingrese la cedula: ");
                    String telefono = JOptionPane.showInputDialog("Ingrese el numero de telefono: ");
                    String ciudad = JOptionPane.showInputDialog("Ingrese la ciudad: ");
                    String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion de la cita: ");
                    String sexo = JOptionPane.showInputDialog("Ingrese el sexo: ");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad: "));

                    lista.agregarPacienteFinal(new Paciente(nombre, cedula, telefono, ciudad, descripcion, sexo, edad));

                    setModeloTabla();
                    setDatosTabla();

                }
                
            });

        } else if (boton.getActionCommand().equals("Regresar")) {

            boton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    panel_principal.removeAll();
                    panel_principal.add(new ContenedorLogin(lista, panel_principal));
                    panel_principal.repaint();
                    panel_principal.revalidate ();

                }
                
            });

        }

        panel.add(boton);

    }



    /*Set Modelo para la tabla */
    private void setModeloTabla () {

        String header [] = {
            "Nombre", "Cedula", "Telefono", "Ciudad", "Sexo", "Edad", "Descripcion"
        };

        modelo_tabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable (int row, int column) {
                return false;
            }

        };
        modelo_tabla.setColumnIdentifiers(header);
        tabla.setModel(modelo_tabla);

    }


    /*Set Datos para la tabla. */
    private void setDatosTabla () {

        if (lista.getInicio() == null) {
            return;
        } else {

            Nodo temp = lista.getInicio();
            while (temp != null) {

                modelo_tabla.addRow(new Object[] {

                    temp.getPaciente().getNombre(), temp.getPaciente().getCedula(), temp.getPaciente().getTelefono(),
                    temp.getPaciente().getCiudad(), temp.getPaciente().getSexo(), temp.getPaciente().getEdad(),
                    temp.getPaciente().getDescripcion()

                });

                temp = temp.getNodoSiguiente();
            }

            tabla.setModel(modelo_tabla); //Establecemos el modelo a la tabla.
        }


    }


    private JTable tabla;
    private JScrollPane pane;
    private JTextField txtBusqueda;
    private ListaPacientes lista;
    private JPanel panel_principal;
    private JButton btnAgregar, btnEliminar, btnRegresar;
}