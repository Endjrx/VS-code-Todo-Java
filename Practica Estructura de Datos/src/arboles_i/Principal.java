package arboles_i;

public class Principal {
    public static void main(String[] args) {

        Metodos metodo = new Metodos();

        metodo.agregarNodo(new Estudiante("Endjrx", 18));
        metodo.agregarNodo(new Estudiante("Jose", 20));
        metodo.agregarNodo(new Estudiante("Kel", 43));
        metodo.agregarNodo(new Estudiante("Sam", 16));

        metodo.mostrarArbol();

    }
}
