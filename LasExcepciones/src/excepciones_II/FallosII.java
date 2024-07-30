package excepciones_II;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FallosII {
    public static void main(String[] args) {
        
        Marco marco = new Marco();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }   
}


class Marco extends JFrame {

    public Marco () {

        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setTitle("Imagen en marco");

        add (new Contenedor());
        this.setVisible(true);

    }

}


class Contenedor extends JPanel {

    public Contenedor () {

        try {
            imagen = ImageIO.read(new File("C://Users//endij//OneDrive//Imágenes//Saved Pictures//Hijacked.jpeg"));
        } catch (IOException e) {
            System.out.println("La imagen no ha sido encontrada");
        }


        JTextField campo = new JTextField(20);
        campo.setOpaque(false);
        campo.setBorder(null);
        add(campo);


    }

    @Override
    public void paintComponent (Graphics g){

        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, 700, 400, this);

    }

    private Image imagen;
}