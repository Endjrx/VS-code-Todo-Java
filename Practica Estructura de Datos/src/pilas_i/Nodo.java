package pilas_i;

public class Nodo {

    //Miembros
    private Empleado empleado;
    private Nodo siguiente;

    public Nodo (Empleado empleado) {
        this.empleado = empleado;
        this.siguiente = null;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Nodo getNodoSiguiente() {
        return this.siguiente;
    }

    public void setNodoSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
