package lista_sencillamente_enlazada_iii;

public class Nodo {
    
    private Estudiante estudiante;
    private Nodo siguiente;

    public Nodo(Estudiante estudiante) {
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
