package gui;

import javax.swing.*;
import java.awt.*;
import datos_user.*;
import java.util.ArrayList;

public class ContenedorPrincipal extends JPanel {

    public ContenedorPrincipal (ArrayList <Plantilla> lista) {

        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.setBackground(getBackground());
        panelCentral.add(new ContenedorLogin(this, lista), BorderLayout.CENTER);

        add(panelCentral);
    }

}
