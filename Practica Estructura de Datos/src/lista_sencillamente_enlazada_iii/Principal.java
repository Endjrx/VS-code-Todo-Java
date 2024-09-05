package lista_sencillamente_enlazada_iii;

public class Principal {

    public static void main(String[] args) {
    
        ListaEstudiantes lista = new ListaEstudiantes();

        lista.agregarEstudianteFinal(new Estudiante("Endjrx", 18));
        lista.agregarEstudianteFinal(new Estudiante("Will", 19));
        lista.agregarEstudianteFinal(new Estudiante("José", 18));
        lista.agregarEstudianteInicio(new Estudiante("Leo", 20));

        lista.mostrarDatos();
        lista.insertarEstudiante(new Estudiante("Roy", 21), 10);

        System.out.println("\n\nLista actualizada\n");
        lista.mostrarDatos();

        System.out.println("\nNueva lista despues de eliminar");
        lista.eliminarEstudiante("Will");
        lista.mostrarDatos();

    }

}
