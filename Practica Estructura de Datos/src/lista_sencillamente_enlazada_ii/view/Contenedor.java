package lista_sencillamente_enlazada_ii.view;

import lista_sencillamente_enlazada_ii.modelo.*;
import javax.swing.*;
import java.awt.*;

public class Contenedor extends JPanel {

    public Contenedor (ListaPacientes lista) {

        setLayout(new BorderLayout());
        add (new ContenedorLogin(lista, this));

    }

}
