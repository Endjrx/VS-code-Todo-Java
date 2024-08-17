package lista_sencillamente_enlazada_ii.modelo;

public class Nodo {
    
    private Nodo siguiente;
    private Paciente paciente;

    public Nodo (Paciente paciente) {

        this.paciente = paciente;
        this.siguiente = null;

    }

    /*Getters And Setters */
    public Nodo getNodoSiguiente() {
        return this.siguiente;
    }

    public void setNodoSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}
