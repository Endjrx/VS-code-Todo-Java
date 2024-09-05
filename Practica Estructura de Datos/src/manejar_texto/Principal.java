package manejar_texto;

public class Principal {
    
    public static void main(String[] args) {
        
        Metodos metodo = new Metodos();

        metodo.insertarTexto("Hola mi nombre es "); 
        metodo.insertarTexto("José David Perea Mejia "); 
        metodo.insertarTexto("Y tengo 18 años de edad"); 

        metodo.mostrarTexto();
        metodo.eliminarTexto();
        metodo.eliminarTexto();

        System.out.println("\nTexto actualizado: ");
        metodo.mostrarTexto();
        
        System.out.println("\nTexto actualizado: ");
        metodo.restablecerTexto();
        metodo.restablecerTexto();
        metodo.mostrarTexto();
        metodo.restablecerTexto();


    }

}
