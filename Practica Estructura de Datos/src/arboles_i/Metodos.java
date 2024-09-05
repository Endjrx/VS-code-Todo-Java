package arboles_i;

public class Metodos {

    //Puntero raiz del arbol
    private Nodo raiz;

    //Constructor
    public Metodos () {
        this.raiz = null;
    }


    //Metodo para insertar nodo al arbol binario de busqueda
    public void agregarNodo (Estudiante estudiante) {

        Nodo nuevo_nodo = new Nodo(estudiante);
        if (raiz == null) raiz = nuevo_nodo;
        else {

            Nodo aux = raiz;
            Nodo aux2;

            while (true) {

                aux2 = aux;
                if (nuevo_nodo.getEstudiante().getEdad() < aux.getEstudiante().getEdad()) {

                    aux = aux.getDer();
                    if (aux == null) {

                        aux2.setDer(nuevo_nodo);
                        return;

                    }

                } else {

                    aux = aux.getIzq();
                    if (aux == null) {

                        aux2.setIzq(nuevo_nodo);
                        return;

                    }

                }

            }

        }

    }


    //Metodo para mostrar el arbol binario.
    public void mostrarArbol () {

        if (raiz == null) System.out.println("NO HAY DATOS EN EL ARBOL");
        else {

            Nodo aux = raiz;
            while (aux != null) {

                System.out.println(aux.getEstudiante().toString() + "\n");
                aux = aux.getDer();

            }

        }

    }


}
