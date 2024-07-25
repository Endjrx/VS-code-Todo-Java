package gui;

import javax.swing.*;

public class Marco extends JFrame {
    
    public Marco () {

        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Banco Remastered");
        this.setResizable(false);

        add(new ContenedorPrincipal());
        this.setVisible(true);

    }

}
