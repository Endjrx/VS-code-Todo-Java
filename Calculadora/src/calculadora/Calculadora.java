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

        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension miPantalla = tool.getScreenSize();

        this.setSize (miPantalla.width / 2, miPantalla.height /2);
        this.setLocationRelativeTo(null);
        this.setTitle ("Calculadora");

        add (new Contenedor ());
        this.setVisible (true);
    }

}

class Datos {

    private double temperatura;
    private int humedad, presion;


    public Datos() {
    }


    public Datos(int temperatura, int humedad, int presion) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.presion = presion;
    }


    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
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

        setLayout(new BorderLayout());

        //Inicializamos los objetos de tipo JButton
        btnAceptar = new JButton ("Aceptar");
        btnCalcular = new JButton ("Calcular Promedio");
        btnVariacion = new JButton ("Mostrar Variacion");

        initComponent();

        add (new ContenedorCombo (combo), BorderLayout.NORTH);
        add (new ContenedorTextos(lblTemp, txtTemp, lblPres, txtPres, lblHumedad, txtHumedad, advertencia), BorderLayout.CENTER);
        add (new ContenedorBotones(btnAceptar, btnCalcular, btnVariacion), BorderLayout.SOUTH);

        indexCombo = combo.getSelectedIndex(); // Para obtener el index selecionado
        totalIndex = combo.getItemCount(); //Obtener el total de items en el combo
        datos = new Datos[7];

        //-------------------
        btnAceptar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (!txtTemp.getText().isBlank() && !txtPres.getText().isBlank() && !txtHumedad.getText().isBlank()){
                    advertencia.setText("");
                    advertencia.setVisible(false);
                   
                    if (indexCombo < totalIndex){
                        datos [indexCombo] = new Datos(Integer.parseInt(txtTemp.getText()), Integer.parseInt(txtPres.getText()), Integer.parseInt(txtHumedad.getText()));
                        combo.setSelectedIndex(indexCombo);
                        indexCombo++;
                    }

                    if (indexCombo == 7){
                        btnCalcular.setEnabled(true);
                    }

                } else {
                    advertencia.setText("Warning!! Debe llenar todos los Campos de Texto");
                    advertencia.setVisible(true);
                }

            }
            

        });

    }

    //Metodo para incializar todos los objetos.
    private void initComponent (){


        lblTemp = new JLabel("Temperatura (°C): ");
        lblTemp.setBounds (0, 50, 200, 20);

        txtTemp = new JTextField("");
        txtTemp.setBounds (120, 50, 300, 20);

        lblPres = new JLabel("Presion (hPa): ");
        lblPres.setBounds (0, 100, 200, 20);

        txtPres = new JTextField("");
        txtPres.setBounds (120, 100, 300, 20);

        lblHumedad = new JLabel("Humedad (%): ");
        lblHumedad.setBounds (0, 150, 200, 20);

        txtHumedad = new JTextField("");
        txtHumedad.setBounds (120, 150, 300, 20);


        advertencia = new JLabel(new ImageIcon("D:\\Img Projects\\Mohammed/Warningg.png"));
        advertencia.setFont (new Font ("Arial", 0, 20 ));
        advertencia.setForeground(Color.red);
        advertencia.setBounds (75,210,500,40);
        advertencia.setVisible(false);

        String days [] = {"1", "2", "3", "4", "5", "6", "7"};
        combo = new JComboBox(days);

    }

    private JLabel lblTemp, lblPres, lblHumedad, advertencia;
    private JTextField txtTemp, txtPres, txtHumedad;
    private JComboBox combo;
    private JButton btnAceptar, btnCalcular, btnVariacion;
    private int indexCombo, totalIndex;
    private Datos [] datos;
}


class ContenedorCombo extends JPanel {

    public ContenedorCombo (JComboBox combo){

        setLayout(new GridLayout(1, 2));
        text = new JLabel("Dias de la semana: ");

        add (text);
        add (combo);

    }

    private JLabel text;
}


class ContenedorTextos extends JPanel {

    public ContenedorTextos (JLabel lblTemp, JTextField txtTemp, JLabel lblPres, JTextField txtPres, JLabel lblHumedad, JTextField txtHumedad, JLabel advertencia){

        setLayout (null);

        
        add (advertencia);
        add (lblTemp);
        add (txtTemp);
        add (lblPres);
        add (txtPres);
        add (lblHumedad);
        add (txtHumedad);

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