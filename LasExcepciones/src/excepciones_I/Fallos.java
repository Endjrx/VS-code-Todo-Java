package excepciones_I;

public class Fallos {
    public static void main(String[] args) {
        
        int vector [] = new int [4]; 

        vector [0] = 12;
        vector [1] = 43;
        vector [2] = 54;
        vector [3] = 83;

        /*Apenas llegue a la linea de codigo de debajo, el programa lanzará una exception de tipo RuntimeException
         * al tener una logica en el programa nula.
         */
        vector [4] = 21; //Haciendo referencia a una posicion que no existe.

        for (int i = 0; i < vector.length; i++) {
            System.out.println("Valor en la posicion: " + (i + 1) + "es: " + vector [i]);
        }


    }
}
