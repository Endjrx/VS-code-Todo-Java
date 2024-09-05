package colas_prioridad_i;

public class Nodo {
    
    //Atributos
    private Nodo siguiente;
    private Paciente paciente;

    public Nodo (Paciente paciente) {
        this.siguiente = null;
        this.paciente = paciente;
    }

    //Getters And Setters
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
