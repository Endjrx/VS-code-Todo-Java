package calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    public static void main(String[] args) {
        
        Marco marco = new Marco();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}


class Marco extends JFrame {

    public Marco (){

        this.setSize (900, 500);
        this.setLocationRelativeTo(null);
        this.setTitle ("Calculadora");

        add (new Contenedor ());
        this.setVisible (true);
    }

}

class Datos {

    private int temperatura;
    private int humedad, presion;


    public Datos() {
    }


    public Datos(int temperatura, int humedad, int presion) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.presion = presion;
    }


    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public int getPresion() {
        return presion;
    }

    public void setPresion(int presion) {
        this.presion = presion;
    }


}

class Contenedor extends JPanel {

    

    public Contenedor (){

        setLayout(new BorderLayout()); //Cambiamos la disposicion del panel

        //Inicializamos los objetos de tipo JButton
        btnAceptar = new JButton ("Aceptar");
        btnCalcular = new JButton ("Calcular Promedio");
        btnVariacion = new JButton ("Mostrar Variacion");

        initComponent();

        //Añadimos el resto de paneles a este panel principal (Contenedor "Esta clase") y pasamos referencias de los objetos para agregarlos en cada panel correspodiente
        add (new ContenedorCombo (combo), BorderLayout.NORTH);
        add (new ContenedorTextos(lblTemp, txtTemp, lblPres, txtPres, lblHumedad, txtHumedad, advertencia, lblPromedio, lblVariacion, comboVariacion,lblCombo, comboVariacion2), BorderLayout.CENTER);
        add (new ContenedorBotones(btnAceptar, btnCalcular, btnVariacion), BorderLayout.SOUTH);

        indexCombo = combo.getSelectedIndex(); // Para obtener el index selecionado
        totalIndex = combo.getItemCount(); //Obtener el total de items en el combo

        //Inicializamos los objetos / variables declaradas.
        datos = new Datos[7];

        //Hacemos que los botones interactuen cuando lo presionan:
        //--------------------------------------------------------------------------
        btnAceptar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //Verifico si los campos de texto esten rellenos
                if (!txtTemp.getText().isBlank() && !txtPres.getText().isBlank() && !txtHumedad.getText().isBlank()){
                    advertencia.setText("");
                    advertencia.setVisible(false);
                   
                    if (indexCombo < totalIndex){

                        datos [indexCombo] = new Datos(Integer.parseInt(txtTemp.getText()), Integer.parseInt(txtPres.getText()), Integer.parseInt(txtHumedad.getText()));
                        indexCombo++;    
                        combo.setSelectedIndex(indexCombo);
                       
                        //vaciarCampos();

                    }

                    if (indexCombo == 7){

                        //Habilitamos y desahabilitamos los botones correspondientes
                        btnCalcular.setEnabled(true);
                        btnVariacion.setEnabled(true);
                        btnAceptar.setEnabled(false);

                        //Desahabilitamos que puedan editar los campos de textos
                        txtTemp.setEditable(false);
                        txtPres.setEditable(false);
                        txtHumedad.setEditable(false);


                    }


                } else {
                    advertencia.setText("Warning!! Debe llenar todos los Campos de Texto");
                    advertencia.setVisible(true);
                }

            }
            

        });

        btnCalcular.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                promedioTemp = 0;
                promedioPres = 0;
                promedioHum = 0;
                int auxTemperatura = 0, auxPresion = 0, auxHumedad = 0;

                for (int i = 0; i < datos.length; i++){
                    
                    if (datos [i] != null){

                        auxTemperatura += datos [i].getTemperatura();
                        auxPresion += datos [i].getPresion();
                        auxHumedad += datos [i].getHumedad();

                    }

                }
                
                

                promedioTemp = auxTemperatura / datos.length;
                promedioPres = auxPresion / datos.length;
                promedioHum = auxHumedad / datos.length;

                String texto = "<html>El promedio de temperatura en la semana fue de: " + promedioTemp + 
                                "<p>El promedio de la humedad en la semana fue de: " + promedioPres + 
                                "<p>El promedio de la presion en la semana fue de: " + promedioHum;
                lblPromedio.setText(texto);
                
            }   
             
        });

        btnVariacion.addActionListener (new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                int v1 = datos [0].getTemperatura();
                int v2 = datos [6].getTemperatura();

                int variacion = v1 - v2;

                //Evaluamos la resta, en caso sea negativa lo multiplicamos por menos uno para que de positivo
                if (variacion < 0){
                    variacion = variacion * - 1;
                    lblVariacion.setText("<html>Variacion de temperatura entre el Dia 1 & 7: " + variacion);

                } else {
                    lblVariacion.setText("<html>Variacion de temperatura entre el Dia 1 & 7: " + variacion);        
                }

            }
            
        });

        //---------------------------------------------------------------------------------

    }

    //Metodo para eliminar los datos ya ingresados en los campos
    private void vaciarCampos (){

        txtTemp.setText("");
        txtPres.setText("");
        txtHumedad.setText("");

    }

    //Metodo para incializar todos los objetos.
    private void initComponent (){


        lblTemp = new JLabel("Temperatura (°C): ");
        lblTemp.setBounds (10, 50, 200, 20);

        txtTemp = new JTextField("");
        txtTemp.setBounds (120, 50, 300, 20);

        lblPres = new JLabel("Presion (hPa): ");
        lblPres.setBounds (10, 100, 200, 20);

        txtPres = new JTextField("");
        txtPres.setBounds (120, 100, 300, 20);

        lblHumedad = new JLabel("Humedad (%): ");
        lblHumedad.setBounds (10, 150, 200, 20);

        txtHumedad = new JTextField("");
        txtHumedad.setBounds (120, 150, 300, 20);


        advertencia = new JLabel(new ImageIcon("D:\\Img Projects\\Mohammed/Warningg.png"));
        advertencia.setFont (new Font ("Arial", 0, 20 ));
        advertencia.setForeground(Color.red);
        advertencia.setBounds (75,210,500,40);
        advertencia.setVisible(false);

        String days [] = {"1", "2", "3", "4", "5", "6", "7", "..."};
        combo = new JComboBox(days);

        
        lblCombo = new JLabel("Variacion de dias: ");
        lblCombo.setBounds(600, 50, 150, 20);

        String nums [] = {"1", "2", "3", "4", "5", "6", "7"};
        comboVariacion = new JComboBox(nums);
        comboVariacion.setBounds(750, 51, 50, 20);

        comboVariacion2 = new JComboBox(nums);
        comboVariacion2.setBounds(810, 51, 50, 20);


        lblPromedio = new JLabel("");
        lblPromedio.setBounds(10, 230, 350, 80);;

        lblVariacion = new JLabel("");
        lblVariacion.setBounds(300, 230, 350, 80);;

    }

    private JLabel lblTemp, lblPres, lblHumedad, advertencia, lblPromedio, lblVariacion, lblCombo;
    private JTextField txtTemp, txtPres, txtHumedad;
    private JComboBox combo, comboVariacion, comboVariacion2;
    private JButton btnAceptar, btnCalcular, btnVariacion;
    private int indexCombo, totalIndex;
    private double promedioTemp, promedioPres, promedioHum;
    private Datos [] datos;

}


class ContenedorCombo extends JPanel {

    public ContenedorCombo (JComboBox combo){

        setLayout(new GridLayout(1, 2));
        text = new JLabel("   Dias de la semana: ");

        add (text);
        add (combo);

    }

    private JLabel text;
}


class ContenedorTextos extends JPanel {

    public ContenedorTextos (JLabel lblTemp, JTextField txtTemp, JLabel lblPres, JTextField txtPres, JLabel lblHumedad, JTextField txtHumedad, JLabel advertencia, JLabel lblPromedio, JLabel lblVariacion, JComboBox comboVariacion, JLabel lblCombo, JComboBox comboVariacion2){

        setLayout (null);

        add (lblVariacion);
        add (comboVariacion);
        add (comboVariacion2);
        add (lblPromedio);
        add (advertencia);
        add (lblTemp);
        add (txtTemp);
        add (lblPres);
        add (txtPres);
        add (lblHumedad);
        add (txtHumedad);
        add (lblCombo);
        

    }

}

class ContenedorBotones extends JPanel {

    public ContenedorBotones (JButton btnAceptar, JButton btnCalcular, JButton btnVariacion){

        btnCalcular.setEnabled(false);
        btnVariacion.setEnabled(false);

        add (btnAceptar);
        add (btnVariacion);
        add (btnCalcular);

    }

}