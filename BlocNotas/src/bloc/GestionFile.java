package bloc;

import java.io.*;

import javax.swing.JOptionPane;

public class GestionFile {
    
    public GestionFile() {
    }
    

    //Metodo para abrir texto
    public String abrirTexto (File archivo){
        String contenido = "";

        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while ((ascci = entrada.read()) != -1){
                char caracter = (char) ascci;
                contenido += caracter;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return contenido;
    }


    public String guardarTexto (File archivo, String contenido){
        String respuesta = null;

        try {
            salida = new FileOutputStream(archivo);
            byte [] bytesTexto = contenido.getBytes();
            salida.write(bytesTexto);

            respuesta = "El archivo se guardo con exito";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return respuesta;
    }

    private FileInputStream entrada;
    private FileOutputStream salida;

}
