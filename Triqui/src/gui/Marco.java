package gui;

import javax.swing.*;

public class Marco extends JFrame {
    
    public Marco () {

        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Triqui");

        add (new ContenedorPrincipal());
        this.setVisible(true);

    }

}
