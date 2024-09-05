package arboles_i;

public class Nodo {
    
    /*Punteros */
    private Estudiante estudiante;
    private Nodo izq;
    private Nodo der;

    //Constructor
    public Nodo (Estudiante estudiante) {
        this.izq = null;
        this.der = null;
        this.estudiante = estudiante;
    }

    public Nodo () {
        this.estudiante = null;
    }

    public Estudiante getEstudiante() {
        return this.estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Nodo getIzq() {
        return this.izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return this.der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

}
