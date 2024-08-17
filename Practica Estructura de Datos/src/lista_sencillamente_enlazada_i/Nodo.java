package lista_sencillamente_enlazada_i;

public class Nodo {
    
    /*Atributos */
    private Nodo siguiente;
    private Tarea tarea;

    /*Constructor default */
    public Nodo () {
    }

    /*Constructor */
    public Nodo (Tarea tarea) {
        this.tarea = tarea;
        this.siguiente = null;
    } 


    //Getters And Setters (Metodos Accesores)
    public Nodo getNodoSiguiente() {
        return this.siguiente;
    }

    public void setNodoSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Tarea getTarea() {
        return this.tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    
}
