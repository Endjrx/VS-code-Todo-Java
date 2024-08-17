package lista_sencillamente_enlazada_i;

public class Organizacion {
    public static void main(String[] args) {
        
        ListaOrganizacional lista = new ListaOrganizacional ();

        lista.agregarTareaFinal(new Tarea("Tarea Fisica", "Realizar actividad"));
        lista.agregarTareaFinal(new Tarea("Estudiar Ecuaciones", "Practicar para parcial"));
        lista.agregarTareaInicial(new Tarea("Programar", "Ponte Pilas"));

        System.out.println("---------Datos a mostrar---------");
        lista.mostrarDatos();

        lista.insertarTarea(new Tarea("Ver Video", "Practica viendo videos"), 2);
        System.out.println("\n------Mostrar Datos-----");
        lista.mostrarDatos();
        
        lista.eliminarTarea("Tarea Fisica", "Realizar actividad");
        System.out.println("\n------Mostrar Datos-----");
        lista.mostrarDatos();


    }
}
