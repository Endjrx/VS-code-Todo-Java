package lista_sencillamente_enlazada_i;

public class ListaOrganizacional {
    
    /*Nodo Inicial */
    private Nodo inicio;

    //Constructor
    public ListaOrganizacional () {
        this.inicio = null;
    }



    //Metodo para agregar Datos al inicio.
    public void agregarTareaInicial (Tarea tarea) {

        Nodo nodo = new Nodo(tarea);
        nodo.setNodoSiguiente(inicio);
        inicio = nodo;

    }



    //Insertar al final
    public void agregarTareaFinal (Tarea tarea) {

        Nodo nodo = new Nodo (tarea);
        if (inicio == null) {

            inicio = nodo;
            return;

        } else {

            Nodo temp = inicio;
            while (true) {
                
                if (temp.getNodoSiguiente() == null) {
                    break;
                }

                temp = temp.getNodoSiguiente();
            }

            temp.setNodoSiguiente(nodo);
        }

    }



    //Inserccion donde sea.
    public void insertarTarea (Tarea tarea, int posicion) {

        Nodo nodo = new Nodo (tarea);
        if (posicion == 0) {
            
            nodo.setNodoSiguiente(inicio);
            inicio = nodo;
            return;

        } else {

            Nodo temp = inicio;
            if (posicion <= obtenerTamañoLista()) {

                for (int i = 0; i < posicion - 1; i++) {
                    temp = temp.getNodoSiguiente();
                }

                nodo.setNodoSiguiente(temp.getNodoSiguiente());
                temp.setNodoSiguiente(nodo);

            } else {
                System.out.println("\n Fuera de rango!!");
            }

        }

    }


    //Obtener tamaño lista
    public int obtenerTamañoLista () {

        int aux = 0;
        if (inicio == null) {
            return 0; //Si inicio es igual a null, quiere decir que no hay datos, entonces si no hay datos, la lista no tiene elementos.
        } else {

            Nodo temp = inicio;
            while (temp != null) {

                aux++;
                temp = temp.getNodoSiguiente();

            }

        }

        return aux;
    }



    //Metodo para mostrar los datos
    public void mostrarDatos () {

        if (inicio == null) {
            System.out.println("No se encuentran datos en la lista.");
        } else {

            Nodo temp = inicio;
            while (temp != null) {

                System.out.println(temp.getTarea().toString() + "\n");
                temp = temp.getNodoSiguiente();

            }

        }

    }



    //Eliminar Tarea.
    public void eliminarTarea (String nombre, String descripcion) {

        if (inicio == null) {
            System.out.println("No hay datos que eliminar ya que la lista esta vacía.");
        } else {

            Nodo temp = inicio;
            Nodo aux = temp;

            if (temp.getTarea().getNombreTarea().equals(nombre) && temp.getTarea().getDescripcion().equals(descripcion)) {

                inicio = temp.getNodoSiguiente();
                System.out.println("La tarea ha sido eliminada con exito \n");

            } else {

                while (true) {

                    if (!temp.getTarea().getNombreTarea().equals(nombre) && !temp.getTarea().getDescripcion().equals(descripcion)) {

                        if (temp.getNodoSiguiente() == null) {
                            break;
                        }

                        aux = temp;
                        temp = temp.getNodoSiguiente();

                    } else {

                        aux.setNodoSiguiente(temp.getNodoSiguiente());
                        System.out.println("Dato eliminado con exito.");
                        break;

                    }

                }



            }

        }


    }






}
