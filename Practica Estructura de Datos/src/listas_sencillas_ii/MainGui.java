package listas_sencillas_ii;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MainGui {
    public static void main(String[] args) {
        
        Marco marco = new Marco();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}


class Marco extends JFrame {

    public Marco () {

        this.setSize(1150, 700);
        this.setLocationRelativeTo(null);
        this.setTitle("Practica Lista");

        add (new Contenedor());
        this.setVisible(true);

    }


}



class Contenedor  extends JPanel {

    public Contenedor () {
        initComponents();
    }


    private void initComponents () {
        
        setLayout(new BorderLayout()); //Establecemos el layout para el contenedor
        lista = new ListaEmpresa(); //Creamos la lista

        tabla = new JTable ();
        pane = new JScrollPane(tabla);
        add (pane, BorderLayout.CENTER);

        setModelo(); //Modelo para mi tabla

        JPanel panelNorte = new JPanel();
        panelNorte.setLayout(null);
        panelNorte.setPreferredSize(new Dimension(getWidth(), 150));

        txtNombre = new JTextField("Ingrese su nombre");
        txtEdad = new JTextField("Ingrese su edad");
        txtSexo = new JTextField("Ingrese su sexo");

        JLabel lblExtra = new JLabel ("null");
        txtExtra = new JTextField ("null");
        combo = new JComboBox<String>(new String[]{
            "....", "Jefe", "Empleado"
        });

        combo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (combo.getSelectedIndex() == 1) {

                    lblExtra.setText("Cargo: ");
                    txtExtra.setText("Ingrese su cargo");

                } else if (combo.getSelectedIndex() == 2) {

                    lblExtra.setText("Puesto: ");
                    txtExtra.setText("Ingrese su puesto");

                }
            }
            
        });

        /*--------------AGREGAMOS COMPONENTES AL PANEL QUE VA EN LA ZONA NORTE-------------- */
        colocarComponentes(panelNorte, new JLabel ("Nombre: "), 10, 10, 70, 25, null);
        colocarComponentes(panelNorte, txtNombre, 120, 10, 220, 25, "Nombre");

        colocarComponentes(panelNorte, new JLabel ("Edad: "), 10, 60, 70, 25, null);
        colocarComponentes(panelNorte, txtEdad, 120, 60, 220, 25, "Edad");

        colocarComponentes(panelNorte, new JLabel ("Sexo: "), 400, 10, 70, 25, null);
        colocarComponentes(panelNorte, txtSexo, 510, 10, 220, 25, "Sexo");

        colocarComponentes(panelNorte, lblExtra, 400, 60, 70, 25, null);
        colocarComponentes(panelNorte, txtExtra, 510, 60, 220, 25, "Extra");

        colocarComponentes(panelNorte, new JLabel ("Tipo Empleado: "), 800, 10, 100, 25, null);
        colocarComponentes(panelNorte, combo, 800, 40, 150, 25, "Combo");
        /*-------------------------------------------------------------------------------------- */

        JPanel panelSur = new JPanel();
        panelSur.setLayout(new GridLayout(1,2));
        
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setFocusPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                boolean v1 = false, v2 = false, v3 = false;
                if (!txtNombre.getText().equals("Ingrese su nombre") && !txtNombre.getText().isEmpty()) v1 = true;
                if (!txtEdad.getText().equals("Ingrese su edad") && !txtEdad.getText().isEmpty()) v2 = true;
                if (!txtSexo.getText().equals("Ingrese su sexo") && !txtSexo.getText().isEmpty()) v3 = true;

                if (v1 && v2 && v3) {

                    try{

                        lista.agregaDatos(new Persona(txtNombre.getText(), Integer.parseInt(txtEdad.getText()), txtSexo.getText()));
                        setModelo();
                        setDatos();
                        vaciarFields();

                    } catch (NumberFormatException ex) {

                        JOptionPane.showMessageDialog(Contenedor.this, "Ingrese numero entero para la edad");
                        txtEdad.setText("Ingrese su edad");

                    }    

                } else {
                    JOptionPane.showMessageDialog(Contenedor.this, "Rellene todos los campos");
                }


            }
            
        });

        panelSur.add(btnAgregar);


        add (panelSur, BorderLayout.SOUTH);
        add(panelNorte, BorderLayout.NORTH);
    }


    private void colocarComponentes (JPanel panel, JComponent comp, int x, int y, int width, int height, String command) {

        comp.setBounds(x, y, width, height);
        
        if (comp instanceof JTextField) {

            JTextField txt = (JTextField) comp;
            txt.setOpaque(false);
            txt.setBorder(null);
            txt.setActionCommand(command);
            txt.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent e) {
                    
                    if (e.getSource() == txtNombre){
                        if (txtNombre.getText().equals("Ingrese su nombre")) txtNombre.setText("");
                    } else if (e.getSource() == txtEdad) {
                        if (txtEdad.getText().equals("Ingrese su edad")) txtEdad.setText("");
                    } else if (e.getSource() == txtSexo) {
                        if (txtSexo.getText().equals("Ingrese su sexo")) txtSexo.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    
                    if (e.getSource() == txtNombre){
                        if (txtNombre.getText().isBlank()) txtNombre.setText("Ingrese su nombre");
                    }  else if (e.getSource() == txtEdad) {
                        if (txtEdad.getText().isBlank()) txtEdad.setText("Ingrese su edad");
                    } else if (e.getSource() == txtSexo) {
                        if (txtSexo.getText().isBlank()) txtSexo.setText("Ingrese su sexo");
                    }

                }
                
            });

            JSeparator sptr = new JSeparator();
            sptr.setBounds(x, y + 22, width, height);
            panel.add(sptr);

        }


        panel.add(comp);

    }


    /*-------------------------------------------------------------------------- */
    
    private void setModelo () {
        
        modelo = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable (int row, int column) {
                return false;
            }
            
        };
        modelo.setColumnIdentifiers(new String []{
            "Nombre", "Edad", "Sexo", "Cargo", "Puesto"
        });
        
        tabla.setModel(modelo);
        
    }

    
    private void setDatos () {
        
        if (lista.getNodoInicio() == null) {
            return;
        } else {

            Nodo temp = lista.getNodoInicio();
            while (temp != null) {

                modelo.addRow(new Object[]{
                    temp.getPersona().getNombre(), temp.getPersona().getEdad(), temp.getPersona().getSexo()
                });


                temp = temp.getNodoSiguiente();

            }
            tabla.setModel(modelo);

        }

    }
    

    private void vaciarFields () {

        txtEdad.setText("Ingrese su edad");
        txtSexo.setText("Ingrese su sexo");
        txtNombre.setText("Ingrese su nombre");

    }

    /*-------------------------------------------------------------------------- */
    
    
    
    private DefaultTableModel modelo;
    private JTable tabla;
    private JScrollPane pane;
    private ListaEmpresa lista;
    private JTextField txtNombre, txtEdad, txtSexo, txtExtra;
    private JComboBox <String> combo;
}