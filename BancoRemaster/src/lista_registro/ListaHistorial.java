package lista_registro;

public class ListaHistorial {
    
    private NodoHistorial inicio;

    public ListaHistorial () {
        this.inicio = null;
    }

    public void agregarDatos (Historial historial) {

        NodoHistorial nodo = new NodoHistorial(historial);
        if (inicio == null) {
            inicio = nodo;
        } else {

            NodoHistorial aux = inicio;
            while (true) {

                if (aux.getSiguiente() == null) {
                    break;
                }

                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }

    }


    public NodoHistorial [] obtenerDatos () {

        if (inicio == null) {
            return null;
        } else {

            int cont = 0;

            NodoHistorial [] historiales = new NodoHistorial[obtenerTamaño()];
            NodoHistorial aux = inicio;

            while (true) {

                historiales [cont] = aux;
                cont++;
                
                if (aux.getSiguiente() == null) break;
                aux = aux.getSiguiente();

            }

            return historiales;
        }

    }

    public int obtenerTamaño () {

        int contador = 1;

        if (inicio == null) {
            return 0;
        } else {

            NodoHistorial aux = inicio;
            while (aux.getSiguiente() != null) {
            
                aux = aux.getSiguiente();
                contador++;

            }

            return contador;
        }

    }
    

}
