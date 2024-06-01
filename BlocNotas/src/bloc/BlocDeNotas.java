package bloc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlocDeNotas {
    public static void main(String[] args) {
        
        Marco marco = new Marco ();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}


class Marco extends JFrame {

    public Marco() {

        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension miPantalla = tool.getScreenSize();

        this.setTitle("Bloc De Notas By Endjrx");
        this.setSize(miPantalla.width / 2, miPantalla.height / 2);
        this.setLocationRelativeTo(null);

        add (new Contenedor());
        this.setVisible(true);

    }

}


class Contenedor extends JPanel {

    public Contenedor() {

        this.setBackground(SystemColor.window);
        setLayout(new BorderLayout());

        initComponent();

        add (new ContenedorNorth(txtArea), BorderLayout.NORTH);
        add (bar, BorderLayout.CENTER);

    }

    private void initComponent (){

        txtArea = new JTextArea ("");
        bar = new JScrollPane(txtArea);

    }

    private JTextArea txtArea;
    private JScrollPane bar;
}

class ContenedorNorth extends JPanel {

    public ContenedorNorth (JTextArea txtArea){

        this.setBackground(SystemColor.window);
        setLayout (new GridLayout (1,1));

        barra = new JMenuBar (); //Instaciamos la barra
        file = new JMenu ("File");


        //---------------------------------------------------------
        abrir = new JMenuItem("Open");
        guardar = new JMenuItem("Save As");

        file.add(abrir);
        file.add(guardar);
        //---------------------------------------------------------

        barra.add(file);
        add (barra);

    }

    private JMenuBar barra;
    private JMenu file;
    private JMenuItem abrir, guardar;
}
