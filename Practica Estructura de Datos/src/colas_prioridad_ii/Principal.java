package colas_prioridad_ii;

public class Principal {
    
    public static void main(String[] args) {
        
        Metodos metodos = new Metodos();

        metodos.agregarAlFinal(new Estudiante("Endjrx", 4.0, 18));
        metodos.agregarAlFinal(new Estudiante("X", 4.0, 20));
        metodos.agregarAlFinal(new Estudiante("José", 4.1, 18));
        metodos.agregarAlInicio(new Estudiante("Y", 4.5, 19));

        metodos.mostrarDatos();
        metodos.insertar(new Estudiante("Somobody", 3.7, 23), 3);

        System.out.println("\n\nNueva lista: ");
        metodos.mostrarDatos();

        System.out.println("\n\nNueva lista después de eliminar \n");
        metodos.eliminarEstudiante("X");
        metodos.mostrarDatos();

        System.out.println("\n\nNueva lista después de organizarla\n");
        metodos.establecerPrioridad();
        metodos.mostrarDatos();

    }

}
