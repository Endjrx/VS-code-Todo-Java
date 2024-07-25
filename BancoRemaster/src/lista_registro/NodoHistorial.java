package lista_registro;

public class NodoHistorial {
    
    private Historial historial;
    private NodoHistorial siguiente;

    public NodoHistorial (Historial historial) {

        this.historial = historial;
        this.siguiente = null;

    }

    public Historial getHistorial() {
        return this.historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public NodoHistorial getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(NodoHistorial siguiente) {
        this.siguiente = siguiente;
    }

}
