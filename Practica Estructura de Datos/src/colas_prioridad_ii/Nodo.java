package colas_prioridad_ii;

public class Nodo {
    
    //Atributos
    private Estudiante estudiante;
    private Nodo siguiente;

    //Constructor
    public Nodo (Estudiante estudiante) {
        this.estudiante = estudiante;
        this.siguiente = null;
    }

    public Estudiante getEstudiante() {
        return this.estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Nodo getNodoSiguiente() {
        return this.siguiente;
    }

    public void setNodoSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
