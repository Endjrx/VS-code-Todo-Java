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


    public void obtenerDatos () {

        if (inicio == null) {
            return;
        } else {

            NodoHistorial aux = inicio;
            while (aux.getSiguiente() != null) {
                
                System.out.println("Saldo: " + aux.getHistorial().getSaldo());
                aux = aux.getSiguiente();
                
            }

        }

    }

}
