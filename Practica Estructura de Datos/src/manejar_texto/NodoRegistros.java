package manejar_texto;

public class NodoRegistros {
    
    /*Atributos */
    private String texto;
    private NodoRegistros siguiente;

    /*Constructor */
    public NodoRegistros (String texto) {

        this.texto = texto;
        this.siguiente = null;

    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public NodoRegistros getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(NodoRegistros siguiente) {
        this.siguiente = siguiente;
    }

}
