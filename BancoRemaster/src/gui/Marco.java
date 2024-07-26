package gui;

import javax.swing.*;
import java.util.ArrayList;
import datos_user.*;

public class Marco extends JFrame {

    ArrayList <Plantilla> lista = new ArrayList<Plantilla>();

    public Marco () {

        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Banco Remastered");
        this.setResizable(false);

        add(new ContenedorPrincipal(lista));
        this.setVisible(true);

    }

}
