package colas_prioridad_i;

public class Principal implements TiposEmergencias{

    public static void main(String[] args) {
    
        Metodos metodo = new Metodos();
        metodo.agregarPaciente(new Paciente("Leo", TiposEmergencias.NORMAL, 18));
        metodo.agregarPaciente(new Paciente("Andres", TiposEmergencias.GRAVE, 19));
        metodo.agregarPaciente(new Paciente("Pedro", TiposEmergencias.GRAVE, 21));
        metodo.agregarPaciente(new Paciente("Isa", TiposEmergencias.MUY_GRAVE, 17));
        
        System.out.println();
        metodo.mostrarDatos();

        System.out.println("\n\nPrioridad establecida: ");
        metodo.ordenarPrioridad();

    }

}
