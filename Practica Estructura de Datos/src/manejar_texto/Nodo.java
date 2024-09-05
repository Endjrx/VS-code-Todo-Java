package manejar_texto;

public class Nodo {
    
    /*Atributos */
    private Nodo siguiente;
    private String texto;

    /*Constructor */
    public Nodo (String texto) {

        this.siguiente = null;
        this.texto = texto;

    } 

    public Nodo getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
